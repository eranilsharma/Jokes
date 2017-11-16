package com.sharmaji.jokes;

import android.content.Intent;
import android.os.Bundle;
import android.support.design.widget.FloatingActionButton;
import android.support.design.widget.NavigationView;
import android.support.design.widget.Snackbar;
import android.support.v4.view.GravityCompat;
import android.support.v4.widget.DrawerLayout;
import android.support.v7.app.ActionBarDrawerToggle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.support.v7.widget.Toolbar;
import android.view.GestureDetector;
import android.view.Menu;
import android.view.MenuItem;
import android.view.MotionEvent;
import android.view.View;
import android.widget.TextView;

import com.google.android.gms.ads.AdRequest;
import com.google.android.gms.ads.AdView;

import java.util.ArrayList;

public class MainActivity extends AppCompatActivity
        implements NavigationView.OnNavigationItemSelectedListener {
    TextView textView;
    private ArrayList status;
    RecyclerView recyclerView;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);
        textView=(TextView)findViewById(R.id.txtjoke);
        recyclerView = (RecyclerView)findViewById(R.id.recyclerview);
        AdView mAdView = (AdView) findViewById(R.id.adView);
        AdRequest adRequest = new AdRequest.Builder().build();
        mAdView.loadAd(adRequest);
        initViews1();
        FloatingActionButton fab = (FloatingActionButton) findViewById(R.id.fab);
        fab.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Snackbar.make(view, "Replace with your own action", Snackbar.LENGTH_LONG)
                        .setAction("Action", null).show();
            }
        });



        DrawerLayout drawer = (DrawerLayout) findViewById(R.id.drawer_layout);
        ActionBarDrawerToggle toggle = new ActionBarDrawerToggle(
                this, drawer, toolbar, R.string.navigation_drawer_open, R.string.navigation_drawer_close);
        drawer.addDrawerListener(toggle);
        toggle.syncState();

        NavigationView navigationView = (NavigationView) findViewById(R.id.nav_view);
        navigationView.setNavigationItemSelectedListener(this);
    }

    @Override
    public void onBackPressed() {
        DrawerLayout drawer = (DrawerLayout) findViewById(R.id.drawer_layout);
        if (drawer.isDrawerOpen(GravityCompat.START)) {
            drawer.closeDrawer(GravityCompat.START);
        } else {
            super.onBackPressed();
        }
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.main, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        // Handle action bar item clicks here. The action bar will
        // automatically handle clicks on the Home/Up button, so long
        // as you specify a parent activity in AndroidManifest.xml.
        int id = item.getItemId();

        //noinspection SimplifiableIfStatement
        if (id == R.id.action_settings) {
            return true;
        }

        return super.onOptionsItemSelected(item);
    }

    @SuppressWarnings("StatementWithEmptyBody")
    @Override
    public boolean onNavigationItemSelected(MenuItem item) {
        // Handle navigation view item clicks here.
        int id = item.getItemId();

        if (id == R.id.nav_btn1) {
            initViews1();
        } else if (id == R.id.nav_btn2) {
            initViews2();
        } else if (id == R.id.nav_btn3) {
            initViews3();
        } else if (id == R.id.nav_btn4) {
            initViews4();
        } else if (id == R.id.nav_btn5) {
            initViews5();
        } else if (id == R.id.nav_rating) {
            Intent intent=new Intent(this,RatingActivity.class);
            startActivity(intent);
        }
        else if(id==R.id.nav_aboutus){
            Intent intent=new Intent(this,aboutUsActivity.class);
            startActivity(intent);
        }

        DrawerLayout drawer = (DrawerLayout) findViewById(R.id.drawer_layout);
        drawer.closeDrawer(GravityCompat.START);
        return true;
    }
    private void initViews4(){

        recyclerView.setHasFixedSize(true);
        RecyclerView.LayoutManager layoutManager = new LinearLayoutManager(this);
        recyclerView.setLayoutManager(layoutManager);
        status = new ArrayList<>();
        status.add("Beta: Papa apki shaadi ho gayi? \n" +
                "Papa: Haan. \n" +
                "Beta: Kis se hui? \n" +
                "Papa: Bewkuf teri mummy se.. \n" +
                "Beta: Wah papa ghar me hi setting kar li. \n");
        status.add("MAA-Beta Apple Khaoge, \n" +
                "BETA-Nahi \n" +
                "MAA-Beta Mengo Khaoge, \n" +
                "BETA-Nahi \n" +
                "MAA-Beta Orange Khaoge, \n" +
                "BETA-Nahi \n" +
                "MAA-Bilkul Baap Par Gaya Hai, \n" +
                "Chappal Hi Khayega. ");
        status.add("Baith kar apni mehbuba ki zulfo k saye me aisa josh aaya, \n" +
                "wah wah! \n" +
                "Phir.. \n" +
                "phir.. \n" +
                "Usk Papa ne dekh liya aur I.C.U. me hosh aaya. ");
        status.add("Love Aur Arrange Marriage Me Kya Faraq He \n" +
                "Love Marriage Me Aap Apni Girlfriend Se Shadi Karte Hai \n" +
                "Aur \n" +
                "Arrange Marriage Me \n" +
                "Kisi Aur Ki ;-) ");
        status.add("Khud ko kar kanjoos itna ki.. \n" +
                "har sms bhejne se pehle, \n" +
                "SERVICE CENTER wale khud call kar k puche.. \n" +
                "Bata sach me bhejna he ya galti se sent ho gaya tha. ");
        RecyclerView.Adapter adapter = new DataAdapter(status, this);
        recyclerView.setAdapter(adapter);

        recyclerView.addOnItemTouchListener(new RecyclerView.OnItemTouchListener() {
            @Override
            public boolean onInterceptTouchEvent(RecyclerView rv, MotionEvent e) {
                return false;
            }

            @Override
            public void onTouchEvent(RecyclerView rv, MotionEvent e) {

            }

            @Override
            public void onRequestDisallowInterceptTouchEvent(boolean disallowIntercept) {

            }

            GestureDetector gestureDetector = new GestureDetector(getApplicationContext(), new GestureDetector.SimpleOnGestureListener() {

                @Override public boolean onSingleTapUp(MotionEvent e) {
                    return true;
                }

            });
        });
    }
    private void initViews1(){

        recyclerView.setHasFixedSize(true);
        RecyclerView.LayoutManager layoutManager = new LinearLayoutManager(this);
        recyclerView.setLayoutManager(layoutManager);
        status = new ArrayList<>();
        status.add("Father: “Son, you were adopted.”\n" +
                " \n" +
                "Son: “What?! I knew it! I want to meet my biological parents!”\n" +
                " \n" +
                "Father: “We are your biological parents. Now pack up, the new ones will pick you up in 20 minutes.”\n" +
                "\n");
        status.add("Why did my washing machine stop pumping out water?\n" +
                " \n" +
                "And more importantly, where is my hamster?\n" +
                "\n");
        status.add("Mother: \"How was school today, Patrick?\"\n" +
                "\n" +
                "Patrick: \"It was really great mum! Today we made explosives!\"\n" +
                "\n" +
                "Mother: \"Ooh, they do very fancy stuff with you these days. And what will you do at school tomorrow?\"\n" +
                "\n" +
                "Patrick: \"What school?\"\n" +
                "\n" );
        status.add("\n" +
                "Doctor: \"I'm sorry but you suffer from a terminal illness and have only 10 to live.\"\n" +
                "\n" +
                "Patient: \"What do you mean, 10? 10 what? Months? Weeks?!\"\n" +
                "\n" +
                "Doctor: \"Nine.\"\n" +
                "\n");
        status.add("A man asks a farmer near a field, “Sorry sir, would you mind if I crossed your field instead of going around it? You see, I have to catch the 4:23 train.”\n" +
                "\n" +
                "The farmer says, “Sure, go right ahead. And if my bull sees you, you’ll even catch the 4:11 one.”\n" +
                "\n");
        RecyclerView.Adapter adapter = new DataAdapter(status, this);
        recyclerView.setAdapter(adapter);

        recyclerView.addOnItemTouchListener(new RecyclerView.OnItemTouchListener() {
            @Override
            public boolean onInterceptTouchEvent(RecyclerView rv, MotionEvent e) {
                return false;
            }

            @Override
            public void onTouchEvent(RecyclerView rv, MotionEvent e) {

            }

            @Override
            public void onRequestDisallowInterceptTouchEvent(boolean disallowIntercept) {

            }

            GestureDetector gestureDetector = new GestureDetector(getApplicationContext(), new GestureDetector.SimpleOnGestureListener() {

                @Override public boolean onSingleTapUp(MotionEvent e) {
                    return true;
                }

            });
        });
    }
    private void initViews2(){

        recyclerView.setHasFixedSize(true);
        RecyclerView.LayoutManager layoutManager = new LinearLayoutManager(this);
        recyclerView.setLayoutManager(layoutManager);
        status = new ArrayList<>();
        status.add("दुकानदार : कैसा सूट दिखाऊँ ?\n" +
                "महिला : पड़ोसन तड़प – तड़प कर दम तोड़ दे ऐसा ……\uD83D\uDE1D\uD83D\uDE1C\uD83D\uDE1D\uD83D\uDE1C\uD83D\uDE1D\uD83D\uDE1C");
        status.add("खून में तेरे गर्मी , गर्मी में तेरा खून …. ऊपर सूरज निचे धरती बीच में May aur june \uD83D\uDE02\uD83D\uDE01 हे भगवान् \uD83D\uDE2C\uD83D\uDE1D\uD83D\uDE1C");
        status.add("टीचर – संजू यमुना नदी कहॉं बहती है ?\n" +
                "संजू – जमीन पर\n" +
                "टीचर – नक्शे में बताओं कहॉं बहती है ?\n" +
                "संजू – नक्शे में कैसे बह सकती है, नक्शा गल नहीं जाएगा  \uD83D\uDE02 \uD83D\uDE02 \uD83D\uDE02 \uD83D\uDE02 \uD83D\uDE02");
        status.add("aaj ka social media\n" +
                "कॉकरोच देख कर चिल्लाते हुये दस किलोमीटर तक भागने वाले पाकिस्तान को धमका रहे होते हैं कि “अब भी वक्त है सुधर जाओ”।");
        status.add(" सुबह एक महिला फल वाले से अंग्रेजी में फल मांग रही थी ये बोलकर – “Give me some destroyed husband”\n" +
                "एक घंटा लगा यह समझने में कि वह “नाशपति ” मांग रही थी।\uD83D\uDE02\uD83D\uDE1D\uD83D\uDE02");
        RecyclerView.Adapter adapter = new DataAdapter(status, this);
        recyclerView.setAdapter(adapter);

        recyclerView.addOnItemTouchListener(new RecyclerView.OnItemTouchListener() {
            @Override
            public boolean onInterceptTouchEvent(RecyclerView rv, MotionEvent e) {
                return false;
            }

            @Override
            public void onTouchEvent(RecyclerView rv, MotionEvent e) {

            }

            @Override
            public void onRequestDisallowInterceptTouchEvent(boolean disallowIntercept) {

            }

            GestureDetector gestureDetector = new GestureDetector(getApplicationContext(), new GestureDetector.SimpleOnGestureListener() {

                @Override public boolean onSingleTapUp(MotionEvent e) {
                    return true;
                }

            });
        });
    }
    private void initViews3(){

        recyclerView.setHasFixedSize(true);
        RecyclerView.LayoutManager layoutManager = new LinearLayoutManager(this);
        recyclerView.setLayoutManager(layoutManager);
        status = new ArrayList<>();
        status.add(getString(R.string.status1));
        status.add(getString(R.string.status2));
        status.add(getString(R.string.status3));
        status.add(getString(R.string.status4));
        status.add(getString(R.string.status5));
        RecyclerView.Adapter adapter = new DataAdapter(status, this);
        recyclerView.setAdapter(adapter);

        recyclerView.addOnItemTouchListener(new RecyclerView.OnItemTouchListener() {
            @Override
            public boolean onInterceptTouchEvent(RecyclerView rv, MotionEvent e) {
                return false;
            }

            @Override
            public void onTouchEvent(RecyclerView rv, MotionEvent e) {

            }

            @Override
            public void onRequestDisallowInterceptTouchEvent(boolean disallowIntercept) {

            }

            GestureDetector gestureDetector = new GestureDetector(getApplicationContext(), new GestureDetector.SimpleOnGestureListener() {

                @Override public boolean onSingleTapUp(MotionEvent e) {
                    return true;
                }

            });
        });
    }
    private void initViews5(){

        recyclerView.setHasFixedSize(true);
        RecyclerView.LayoutManager layoutManager = new LinearLayoutManager(this);
        recyclerView.setLayoutManager(layoutManager);
        status = new ArrayList<>();
        status.add(getString(R.string.status1));
        status.add(getString(R.string.status2));
        status.add(getString(R.string.status3));
        status.add(getString(R.string.status4));
        status.add(getString(R.string.status5));
        RecyclerView.Adapter adapter = new DataAdapter(status, this);
        recyclerView.setAdapter(adapter);

        recyclerView.addOnItemTouchListener(new RecyclerView.OnItemTouchListener() {
            @Override
            public boolean onInterceptTouchEvent(RecyclerView rv, MotionEvent e) {
                return false;
            }

            @Override
            public void onTouchEvent(RecyclerView rv, MotionEvent e) {

            }

            @Override
            public void onRequestDisallowInterceptTouchEvent(boolean disallowIntercept) {

            }

            GestureDetector gestureDetector = new GestureDetector(getApplicationContext(), new GestureDetector.SimpleOnGestureListener() {

                @Override public boolean onSingleTapUp(MotionEvent e) {
                    return true;
                }

            });
        });
    }

}