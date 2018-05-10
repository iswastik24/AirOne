package com.swastikijari.airone;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.ImageButton;

public class Booking extends AppCompatActivity {
    ImageButton bus,hotel,restaurant;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_booking);
        bus=findViewById(R.id.bus);
        hotel=findViewById(R.id.hotels);
        restaurant=findViewById(R.id.Resturants);
        bus.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
               Intent  intent= new Intent(Booking.this,Buss_Booking.class);
               intent.putExtra("name","Hello");
               startActivity(intent);
            }
        });
        hotel.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                startActivity(new Intent(Booking.this,Hotel.class));
            }
        });
        restaurant.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                startActivity(new Intent(Booking.this,Restaurants.class));
            }
        });

    }
}
