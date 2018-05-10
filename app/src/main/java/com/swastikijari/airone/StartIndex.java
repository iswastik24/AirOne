package com.swastikijari.airone;

import android.content.Intent;
import android.os.Bundle;
import android.support.design.widget.FloatingActionButton;
import android.support.design.widget.Snackbar;
import android.view.View;
import android.support.design.widget.NavigationView;
import android.support.v4.view.GravityCompat;
import android.support.v4.widget.DrawerLayout;
import android.support.v7.app.ActionBarDrawerToggle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.Menu;
import android.view.MenuItem;
import android.widget.Button;
import android.widget.Toast;

import com.google.firebase.auth.FirebaseAuth;

import java.util.Arrays;

public class StartIndex extends AppCompatActivity
        implements NavigationView.OnNavigationItemSelectedListener {
    private Button b1,b2,b3,b4,b5;
    String source,destination,boarding,booking_id,date,drop_point,name_d,list_name;
    FirebaseAuth firebaseAuth;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_start_index);
        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);

       
        DrawerLayout drawer = (DrawerLayout) findViewById(R.id.drawer_layout);
        ActionBarDrawerToggle toggle = new ActionBarDrawerToggle(
                this, drawer, toolbar, R.string.navigation_drawer_open, R.string.navigation_drawer_close);
        drawer.addDrawerListener(toggle);
        toggle.syncState();

        NavigationView navigationView = (NavigationView) findViewById(R.id.nav_view);
        navigationView.setNavigationItemSelectedListener(this);
        //get data
        source=getIntent().getStringExtra("src");
        destination=getIntent().getStringExtra("dest");
        boarding=getIntent().getStringExtra("bdpt");
        drop_point=getIntent().getStringExtra("drpt");
        date=getIntent().getStringExtra("doj");
        booking_id=getIntent().getStringExtra("bid");
        name_d=getIntent().getStringExtra("name");
        list_name=getIntent().getStringExtra("seatlist");

        firebaseAuth =FirebaseAuth.getInstance();
        b1=findViewById(R.id.button5);
        //hotel
        b2=findViewById(R.id.button6);
        //Resturants
        b3=findViewById(R.id.button7);
        //Wether
        b4=findViewById(R.id.button8);
        //Search
        b5=findViewById(R.id.button10);

        b1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                startActivity(new Intent(StartIndex.this,Buss_Booking.class));
            }
        });
        b2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                startActivity(new Intent(StartIndex.this,Hotel.class));
            }
        });
        b3.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                startActivity(new Intent(StartIndex.this,Restaurants.class));
            }
        });
        b4.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                startActivity(new Intent(StartIndex.this,Weather.class));
            }
        });
        b5.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                startActivity(new Intent(StartIndex.this,Second.class));
            }
        });
    }
    private void Logout(){
        firebaseAuth.signOut();
        finish();
        startActivity(new Intent(StartIndex.this,MainActivity.class));
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
        getMenuInflater().inflate(R.menu.menu, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        // Handle action bar item clicks here. The action bar will
        // automatically handle clicks on the Home/Up button, so long
        // as you specify a parent activity in AndroidManifest.xml.

        switch (item.getItemId()) {

            case R.id.logout1: {
                Logout();

            }
            case R.id.About1:
                Toast.makeText(StartIndex.this,"Designed and Developed \n \nby\n \nShivkumar B\nSwastik ijari",Toast.LENGTH_LONG).show();



        }

        return super.onOptionsItemSelected(item);
    }


    @SuppressWarnings("StatementWithEmptyBody")
    @Override
    public boolean onNavigationItemSelected(MenuItem item) {
        // Handle navigation view item clicks here.
        int id = item.getItemId();

        if (id == R.id.search_places) {
            startActivity(new Intent(StartIndex.this,Second.class));

        } else if (id == R.id.booking) {
            startActivity(new Intent(StartIndex.this,Booking.class));


        } else if (id == R.id.bus_ticket) {
            startActivity(new Intent(StartIndex.this,Buss_Booking.class));

        } else if (id == R.id.hotel_info) {

            startActivity(new Intent(StartIndex.this,Hotel.class));

        } else if (id == R.id.resturants_info) {

            startActivity(new Intent(StartIndex.this,Restaurants.class));

        } else if (id == R.id.weather_report) {

            startActivity(new Intent(StartIndex.this,Weather.class));

        }
        else if (id == R.id.Tickets) {

            Intent ip1 = new  Intent(StartIndex.this,GetTicketDetails.class);
            ip1.putExtra("bid",booking_id);
            ip1.putExtra("src",source);
            ip1.putExtra("dest",destination);
            ip1.putExtra("doj",date);
            ip1.putExtra("name",name_d);
            ip1.putExtra("bdpt",boarding);
            ip1.putExtra("drpt",drop_point);
            ip1.putExtra("seatlist", list_name);
            startActivity(ip1);

        }
        else if (id == R.id.about) {
            Toast.makeText(StartIndex.this,"Designed and Developed \n by \nShivkumar B\nSwastik ijari",Toast.LENGTH_LONG).show();


        }

        DrawerLayout drawer = (DrawerLayout) findViewById(R.id.drawer_layout);
        drawer.closeDrawer(GravityCompat.START);
        return true;
    }
}