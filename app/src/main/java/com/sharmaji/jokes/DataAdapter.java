package com.sharmaji.jokes;

import android.content.Context;
import android.content.Intent;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;

import com.google.android.gms.ads.AdListener;
import com.google.android.gms.ads.AdRequest;
import com.google.android.gms.ads.InterstitialAd;

import java.util.ArrayList;

/**
 * Created by jagbros-6 on 08-Nov-17.
 */
public class DataAdapter extends RecyclerView.Adapter<DataAdapter.ViewHolder> {
    Context context;
    private ArrayList<String> status;
    private InterstitialAd interstitial;

    public DataAdapter(ArrayList<String> status, Context context) {
        this.status = status;
        this.context = context;
    }

    @Override
    public ViewHolder onCreateViewHolder(ViewGroup viewGroup, int i) {
        View view = LayoutInflater.from(viewGroup.getContext()).inflate(R.layout.jokelayout, viewGroup, false);
        return new ViewHolder(view);

    }

    @Override
    public void onBindViewHolder(final DataAdapter.ViewHolder viewHolder, int i) {

        viewHolder.textview.setText(status.get(i));

        viewHolder.btncopy.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                int sdk = android.os.Build.VERSION.SDK_INT;
                if (sdk < android.os.Build.VERSION_CODES.HONEYCOMB) {
                    android.text.ClipboardManager clipboard = (android.text.ClipboardManager) context.getSystemService(Context.CLIPBOARD_SERVICE);
                    clipboard.setText(viewHolder.textview.getText().toString());
                    Toast.makeText(context, "Text Copied", Toast.LENGTH_LONG).show();
                } else {
                    android.content.ClipboardManager clipboard = (android.content.ClipboardManager) context.getSystemService(Context.CLIPBOARD_SERVICE);
                    android.content.ClipData clip = android.content.ClipData.newPlainText("text label", viewHolder.textview.getText().toString());
                    clipboard.setPrimaryClip(clip);
                    Toast.makeText(context, "Text Copied", Toast.LENGTH_LONG).show();
                }
            }
        });

        viewHolder.btnshare.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                AdRequest adRequest = new AdRequest.Builder().build();
                interstitial = new InterstitialAd(context);
                // Insert the Ad Unit ID
                interstitial.setAdUnitId(context.getString(R.string.admob_interstitial_id));
                interstitial.loadAd(adRequest);
                // Prepare an Interstitial Ad Listener
                interstitial.setAdListener(new AdListener() {
                    public void onAdLoaded() {
                        // Call displayInterstitial() function
                        displayInterstitial();
                    }
                });
                Intent shareIntent = new Intent();
                shareIntent.setAction(Intent.ACTION_SEND);
                shareIntent.putExtra(Intent.EXTRA_TEXT, viewHolder.textview.getText().toString());
                shareIntent.setType("text/plain");
                context.startActivity(Intent.createChooser(shareIntent, "share with..."));
            }
        });
    }

    @Override
    public int getItemCount() {
        return status.size();
    }

    public class ViewHolder extends RecyclerView.ViewHolder {
        TextView textview;
        Button btnshare, btncopy;


        public ViewHolder(View view) {
            super(view);
            textview = (TextView) view.findViewById(R.id.txtjoke);
            btncopy = (Button) view.findViewById(R.id.btncopy);
            btnshare = (Button) view.findViewById(R.id.btnshare);


        }
    }

    public void displayInterstitial() {
// If Ads are loaded, show Interstitial else show nothing.
        if (interstitial.isLoaded()) {
            interstitial.show();
        }
    }

}