package com.swastikijari.airone;

import android.annotation.SuppressLint;
import android.content.Intent;
import android.graphics.Color;
import android.os.Bundle;
import android.support.design.widget.Snackbar;
import android.support.v7.app.AppCompatActivity;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;

/**
 * Created by swastik ijari on 12-04-2018.
 */

public class CustomACSLeeperUp extends AppCompatActivity {
    //Buttons declared
    Button u_1,u_2,u_3,u_4,u_5,u_6,u_7,u_8,u_9,u_10,u_11,u_12;
    //to get information about button state either booed or unbooked
    int a,b,c,d,e,f,g,h,i,j,x,l;
    //bus number is stored in this variable
    String busnumber,buffer2,src,dst;
    //bus price is stores hear
    double busprice;
    // Total price on booking seat
    Double total_price;
    //K stores total no of seats
    int k=0;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.custom_ac_sleeper_up);
        //bus code of selected bus
        busnumber=getIntent().getStringExtra("buscode");
        //bus price of selected bus from booking activity
        busprice=getIntent().getDoubleExtra("busprice",0.00);
        //prints the bus price and bus name
       // Log.d("DDDDDDDDDDDDDDDDDDD",busprice);
       // Log.d("DDDDDDDDDDDDDDDDDDD",busnumber);
        //Store the bus code
        buffer2=getIntent().getStringExtra("buffer");
        src =getIntent().getStringExtra("src");
         dst=getIntent().getStringExtra("dst");
        u_1=findViewById(R.id.u1);
        u_2=findViewById(R.id.u2);
        u_3=findViewById(R.id.u3);
        u_4=findViewById(R.id.u4);
        u_5=findViewById(R.id.u5);
        u_6=findViewById(R.id.u6);
        u_7=findViewById(R.id.u7);
        u_8=findViewById(R.id.u8);
        u_9=findViewById(R.id.u9);
        u_10=findViewById(R.id.u10);
        u_11=findViewById(R.id.u11);
        u_12=findViewById(R.id.u12);

        u_1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                if(a%2==0){
                    u_1.setBackgroundColor(Color.RED);
                    a++;
                    //if user clicks button then k will be no of seats up to book
                    k+=1;
                    calculate(k,view);

                }
                else{
                    u_1.setBackgroundColor(Color.LTGRAY);
                    a++;
                    //if user clicks button then k will be no of seats up to book
                    k-=1;
                    calculate(k,view);
                }
                Log.d("JHHHHHHHHHHHHHH", String.valueOf(k));


            }
        });
        u_2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                // Log.d("mess","clicked");
                if(b%2==0){
                    u_2.setBackgroundColor(Color.RED);
                    b++;
                    k+=1;
                    calculate(k,view);
                }
                else{
                    u_2.setBackgroundColor(Color.LTGRAY);
                    b++;
                    k-=1;
                    calculate(k,view);
                }
                Log.d("JHHHHHHHHHHHHHH", String.valueOf(k));


            }
        });
        u_3.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                if(c%2==0){
                    u_3.setBackgroundColor(Color.RED);
                    c++;
                    k+=1;
                    calculate(k,view);
                }
                else{
                    u_3.setBackgroundColor(Color.LTGRAY);
                    c++;
                    k-=1;
                    calculate(k,view);
                }
                Log.d("JHHHHHHHHHHHHHH", String.valueOf(k));
                //    Log.d("mess","clicked");
            }
        });
        u_4.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if(d%2==0){
                    u_4.setBackgroundColor(Color.RED);
                    d++;
                    k+=1;
                    calculate(k,view);
                }
                else{
                    u_4.setBackgroundColor(Color.LTGRAY);
                    d++;
                    k-=1;
                    calculate(k,view);
                }
                Log.d("JHHHHHHHHHHHHHH", String.valueOf(k));
//   Log.d("mess","clicked");
            }
        });
        u_5.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                if(e%2==0){
                    u_5.setBackgroundColor(Color.RED);
                    e++;
                    k+=1;
                    calculate(k,view);
                }
                else{
                    u_5.setBackgroundColor(Color.LTGRAY);
                    e++;
                    k-=1;
                    calculate(k,view);
                }
                Log.d("JHHHHHHHHHHHHHH", String.valueOf(k));
                //   Log.d("mess","clicked");
            }
        });
        u_6.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if(f%2==0){
                    u_6.setBackgroundColor(Color.RED);
                    f++;
                    k+=1;
                    calculate(k,view);
                }
                else{
                    u_6.setBackgroundColor(Color.LTGRAY);
                    f++;
                    k-=1;
                    calculate(k,view);
                }
                Log.d("JHHHHHHHHHHHHHH", String.valueOf(k));
                // Log.d("mess","clicked");
            }
        });
        u_7.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if(g%2==0){
                    u_7.setBackgroundColor(Color.RED);
                    g++;
                    k+=1;
                    calculate(k,view);
                }
                else{
                    u_7.setBackgroundColor(Color.LTGRAY);
                    g++;
                    k-=1;
                    calculate(k,view);
                }
                Log.d("JHHHHHHHHHHHHHH", String.valueOf(k));
                // Log.d("mess","clicked");
            }
        });
        u_8.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if(h%2==0){
                    u_8.setBackgroundColor(Color.RED);
                    h++;
                    k+=1;
                    calculate(k,view);
                }
                else{
                    u_8.setBackgroundColor(Color.LTGRAY);
                    h++;
                    k-=1;
                    calculate(k,view);

                }
                Log.d("JHHHHHHHHHHHHHH", String.valueOf(k));
                // Log.d("mess","clicked");
            }
        });
        u_9.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if(i%2==0){
                    u_9.setBackgroundColor(Color.RED);
                    i++;
                    k+=1;
                    calculate(k,view);
                }
                else{
                    u_9.setBackgroundColor(Color.LTGRAY);
                    i++;
                    k-=1;
                    calculate(k,view);
                }
                Log.d("JHHHHHHHHHHHHHH", String.valueOf(k));
                // Log.d("mess","clicked");
            }
        });
        u_10.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                if(j%2==0){
                    u_10.setBackgroundColor(Color.RED);
                    j++;
                    k+=1;
                    calculate(k,view);
                }
                else{
                    u_10.setBackgroundColor(Color.LTGRAY);
                    j++;
                    k-=1;
                    calculate(k,view);
                }
                Log.d("JHHHHHHHHHHHHHH", String.valueOf(k));
                // Log.d("mess","clicked");
            }
        });
        u_11.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if(x%2==0){
                    u_11.setBackgroundColor(Color.RED);
                    x++;
                    k+=1;
                    calculate(k,view);
                }
                else{
                    u_11.setBackgroundColor(Color.LTGRAY);
                    x++;
                    k-=1;
                    calculate(k,view);
                }
                Log.d("JHHHHHHHHHHHHHH", String.valueOf(k));
                //  Log.d("mess","clicked");
            }
        });
        u_12.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if(l%2==0){
                    u_12.setBackgroundColor(Color.RED);
                    l++;
                    k+=1;
                    calculate(k,view);
                }
                else{
                    u_12.setBackgroundColor(Color.LTGRAY);
                    l++;
                    k-=1;
                    calculate(k,view);
                }
               //  Log.d("JHHHHHHHHHHHHHH", String.valueOf(k));
            }
        });




    }
    public void calculate(int number,View v){
        int tp;
        total_price=number*busprice;
        tp=total_price.intValue();
        Log.d("JHHHHHHHHHHHHHH", String.valueOf(total_price));
        Snackbar snackbar= Snackbar.make(v, "Selected seats  :"+number+"\nTotal Price INR :"+tp, Snackbar.LENGTH_LONG)
                .setAction("BOOK", new View.OnClickListener() {
                    @Override
                    public void onClick(View view) {
                        Toast.makeText(CustomACSLeeperUp.this,"booking confirm",Toast.LENGTH_SHORT).show();
                        Intent ip1 = new Intent(CustomACSLeeperUp.this,Boarding_point.class);
                        ip1.putExtra("buffer",buffer2);
                        ip1.putExtra("dst",dst);
                        ip1.putExtra("src",src);
                        startActivity(ip1);
                        finish();
                    }
                }).setActionTextColor(Color.CYAN);
        // Changing action button text color
        View sbView = snackbar.getView();
        TextView textView = (TextView) sbView.findViewById(android.support.design.R.id.snackbar_text);
        textView.setTextColor(Color.YELLOW);
        snackbar.show();

    }
    


}

