package com.swastikijari.airone;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.TextView;

public class BusInfo extends AppCompatActivity {
TextView tv;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_bus_info);
        String buscode =getIntent().getStringExtra("buscode");
        Double busprice =getIntent().getDoubleExtra("price",0.00);
        Double seats = getIntent().getDoubleExtra("seats",0.00);
        String  duration=getIntent().getStringExtra("duration");
        String arv=getIntent().getStringExtra("arival");
        String dep=getIntent().getStringExtra("dep");
        String coach=getIntent().getStringExtra("coach");
        String src=getIntent().getStringExtra("src");
        String dst=getIntent().getStringExtra("dst");
        tv=findViewById(R.id.binfo);
        tv.setText("FROM : "+src+"\n\n"+"TO  : "+dst+"\n\n"+"ARIVAL TIME: "+arv+"\n\n"+"DEPARTURE TIME : "+dep+"\n\n"+"BUS TYPE : "+coach+"\n\n"+"SEATS : "+seats+"\n\n" +
                ""+"DURATION : "+duration+"\n\n"+"PRICE PER SEAT :"+busprice);

    }
}
