package com.swastikijari.airone;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.widget.TextView;

public class RouteMap extends AppCompatActivity {
   String busnumber;
   TextView route1;
  
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_route_map);
        busnumber=getIntent().getStringExtra("buscode");
        String src = getIntent().getStringExtra("src");
        String dest=getIntent().getStringExtra("dst");

       // Log.d("XXXXXXVVVV",busnumber);
        route1=findViewById(R.id.routex);

        if(src.equals("Bengaluru")&&dest.equals("Delhi")) {
            route1.setText( "\n\nBanglore\n\nHydrabad\n\nBhopal\n\nLucknow\n\nAgra\n\nDelhi");
        }
         if(src.equals("Bengaluru")&&dest.equals("Hydrabad")) {
            route1.setText(" .\n\nBanglore\n\nGulbarga\n\nHydrabad");
        }
         if(src.equals("Bengaluru")&&dest.equals("Mysore")) {
        route1.setText(" .\n\nBanglore\n\nMandya\n\nMysore");
        }
         if(src.equals("Bengaluru")&&dest.equals("Chennai")) {
            route1.setText(" .\n\nBaglore\n\nElectronic city\n\nChennai" );

        }
          if(src.equals("Bengaluru")&&dest.equals("Goa")) {
            route1.setText( " .\n\nBanglore\n\nTumkur\n\nHubli\n\nVasco\n\nGoa");
        }
        if(src.equals("Delhi")&&dest.equals("Bengaluru")) {
            route1.setText(" \n\nDelhi\n\nAgra\n\nLucknow\n\nBhopal\n\nHydrabad\n\nBanglore");
        }
        if(src.equals("Hydrabad")&&dest.equals("Bengaluru")) {
            route1.setText( " .\n\nHydrabad\n\nGulbarga\n\nBanglore");
        }
         if(src.equals("Mysore")&&dest.equals("Bengaluru")) {
            route1.setText(" .\n\nMysore\n\nMandya\n\nBanglore");
        }
         if(src.equals("Chennai")&&dest.equals("Bengaluru")) {
            route1.setText(" .\n\nBaglore\n\nElectronic city\n\nChennai");
        }
        if(src.equals("Goa")&&dest.equals("Bengaluru")) {
            route1.setText( " .\n\nGoa\n\nVasco\n\nHubli\n\nTumkur\n\nBanglore");
        }


    }
}
