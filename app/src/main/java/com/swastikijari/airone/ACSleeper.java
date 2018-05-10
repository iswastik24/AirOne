package com.swastikijari.airone;

import android.content.Intent;
import android.support.design.widget.TabLayout;
import android.support.v4.view.ViewPager;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.LinearLayout;
import android.widget.ScrollView;
import android.widget.Toast;


public class ACSleeper extends AppCompatActivity {

    private Button lower,upper,bus_info,route;
    String busnumber,buffer1,duration,arv,dep,coach,src,dest,var,date;
    Double price1,seats;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_acsleeper);
        lower=(Button)findViewById(R.id.button2);
        upper=(Button)findViewById(R.id.button3);
        route=(Button)findViewById(R.id.rout_map);
        bus_info=(Button)findViewById(R.id.genreral_info);
        //get info about bus
        seats=getIntent().getDoubleExtra("seats",0.00);
        duration=getIntent().getStringExtra("duration");
        arv=getIntent().getStringExtra("arival");
        dep=getIntent().getStringExtra("dep");
        coach=getIntent().getStringExtra("coach");
        src=getIntent().getStringExtra("src");
        dest=getIntent().getStringExtra("dst");
        date=getIntent().getStringExtra("Date");


        //get the busnumber from selected bus by user from booking activity
        busnumber=getIntent().getStringExtra("buscode");
        //get the bus rout code
        buffer1=getIntent().getStringExtra("buffer");
        //Get selected bus price
        price1=getIntent().getDoubleExtra("price",0.00);
          Log.d("JHHHHHHHHHHHHHH", String.valueOf(price1));
        lower.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
               Intent ip1 = (new Intent(ACSleeper.this,CustomACSleeper.class ));
               ip1.putExtra("buscode",busnumber);
               ip1.putExtra("busprice",price1);
                ip1.putExtra("buffer",buffer1);
                ip1.putExtra("dst",dest);;
                ip1.putExtra("Date",date);
                ip1.putExtra("src",src);
                startActivity(ip1);


            }
        });
        upper.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
              //  l1.setVisibility(View.GONE);
                Intent ip1 = (new Intent(ACSleeper.this,CustomACSLeeperUp.class ));
                ip1.putExtra("buscode",busnumber);
                ip1.putExtra("busprice",price1);
                ip1.putExtra("buffer",buffer1);
                ip1.putExtra("dst",dest);
                ip1.putExtra("src",src);
                startActivity(ip1);
            }
        });
        route.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                //ROute info
                Intent ip1 = (new Intent(ACSleeper.this,RouteMap.class ));
                ip1.putExtra("buscode",busnumber);
                ip1.putExtra("dst",dest);
                ip1.putExtra("src",src);
                startActivity(ip1);



            }
        });
        bus_info.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent ip1 = (new Intent(ACSleeper.this,BusInfo.class ));
                ip1.putExtra("buscode",busnumber);
                ip1.putExtra("price",price1);
                ip1.putExtra("seats",seats);
                ip1.putExtra("duration",duration);
                ip1.putExtra("arival",arv);
                ip1.putExtra("dep",dep);
                ip1.putExtra("coach",coach);
                ip1.putExtra("dst",dest);
                ip1.putExtra("src",src);
                startActivity(ip1);
            }
        });

    }

}

