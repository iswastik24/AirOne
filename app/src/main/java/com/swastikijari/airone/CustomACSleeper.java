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

import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.Query;
import com.google.firebase.database.ValueEventListener;

/**
 * Created by swastik ijari on 12-04-2018.
 */

public class CustomACSleeper extends AppCompatActivity {
    //Buttons declared
    Button l_1,l_2,l_3,l_4,l_5,l_6,l_7,l_8,l_9,l_10,l_11,l_12,bfbt;
    int tp;
    //to get information about button state either booed or unbooked
  int a,b,c,d,e,f,g,h,i,j,x,l;
  int k=0;
  char flag;
  String src,dst,date;
  String[] seats_name= new String[6];
  FirebaseDatabase database=FirebaseDatabase.getInstance();

  //Stores total price below
  Double total_price;
  //Bus number is stored below
    String busnumber,buffer2,value;
    //bus price is stores hear
    Double busprice;
    @Override
    protected void onCreate(final Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.custom_ac_sleeper);
        //get bus number and bus price from booking activity
        FirebaseDatabase database = FirebaseDatabase.getInstance();
        final DatabaseReference mef = database.getReference("Seats").child("buffer");

        busnumber = getIntent().getStringExtra("buscode");
        busprice = getIntent().getDoubleExtra("busprice", 0.00);
        buffer2=getIntent().getStringExtra("buffer");
        date=getIntent().getStringExtra("Date");
        //displays bus fare
          Log.d("DDDDDDDDDDDDDDDDDDD", String.valueOf(busprice));
        src=getIntent().getStringExtra("src");
        dst=getIntent().getStringExtra("dst");
        l_1 = findViewById(R.id.l1);
        l_2 = findViewById(R.id.l2);
        l_3 = findViewById(R.id.l3);
        l_4 = findViewById(R.id.l4);
        l_5 = findViewById(R.id.l5);
        l_6 = findViewById(R.id.l6);
        l_7 = findViewById(R.id.l7);
        l_8 = findViewById(R.id.l8);
        l_9 = findViewById(R.id.l9);
        l_10 = findViewById(R.id.l10);
        l_11 = findViewById(R.id.l11);
        l_12 = findViewById(R.id.l12);

        mef.addValueEventListener(new ValueEventListener() {
            @Override
            public void onDataChange(DataSnapshot dataSnapshot) {
                // This method is called once with the initial value and again
                // whenever data at this location is updated.
                value = dataSnapshot.getValue(String.class);
              //  Log.d("hh", "Value is: " + value);
            }

            @Override
            public void onCancelled(DatabaseError error) {
                // Failed to read value
              //  Log.w(TAG, "Failed to read value.", error.toException());
            }
        });

        l_1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                if (a % 2 == 0) {
                    l_1.setBackgroundColor(Color.RED);
                    //B for book
                    flag = 'B';
                    a++;
                    k += 1;
                    String buffer2;


                    buffer2=l_1.getText().toString();
                    seats_name[k]=buffer2;
                    calculate(k,view);


                } else {
                    l_1.setBackgroundColor(Color.LTGRAY);
                    //C for not book or cancel
                    flag = 'C';
                    a++;
                    k -= 1;

                    seats_name[k]=null;
                    calculate(k,view);
                }



            }
        });
        l_2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                // Log.d("mess","clicked");
                if (b % 2 == 0) {
                    l_2.setBackgroundColor(Color.RED);
                    flag = 'B';
                    b++;
                    k += 1;
                    String buffer2;
                    buffer2=l_2.getText().toString();
                    seats_name[k]=buffer2;
                    calculate(k,view);
                } else {
                    l_2.setBackgroundColor(Color.LTGRAY);
                    flag = 'C';
                    b++;
                    k -= 1;
                    seats_name[k]=null;
                    calculate(k,view);
                }

            }
        });
        l_3.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                if (c % 2 == 0) {
                    l_3.setBackgroundColor(Color.RED);
                    flag = 'B';
                    c++;
                    k += 1;
                    String buffer2;
                    buffer2=l_3.getText().toString();
                    seats_name[k]=buffer2;
                    calculate(k,view);
                } else {
                    l_3.setBackgroundColor(Color.LTGRAY);
                    flag = 'C';
                    c++;
                    k -= 1;
                    seats_name[k]=null;
                    calculate(k,view);
                }
                //    Log.d("mess","clicked");
           //     Log.d("JHHHHHHHHHHHHHH", seats_name[k]);

            }
        });
        l_4.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if (d % 2 == 0) {
                    l_4.setBackgroundColor(Color.RED);
                    flag = 'B';
                    d++;
                    k += 1;
                    String buffer2;
                    buffer2=l_4.getText().toString();
                    seats_name[k]=buffer2;
                    calculate(k,view);
                } else {
                    l_4.setBackgroundColor(Color.LTGRAY);
                    flag = 'C';
                    d++;
                    k -= 1;
                    seats_name[k]=null;
                    calculate(k,view);
                }
//   Log.d("mess","clicked");
              //  Log.d("JHHHHHHHHHHHHHH", seats_name[k]);

            }
        });
        l_5.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                if (e % 2 == 0) {
                    l_5.setBackgroundColor(Color.RED);
                    flag = 'B';
                    e++;
                    k += 1;
                    String buffer2;
                    buffer2=l_5.getText().toString();
                    seats_name[k]=buffer2;
                    calculate(k,view);
                } else {
                    l_5.setBackgroundColor(Color.LTGRAY);
                    flag = 'C';
                    e++;
                    k -= 1;
                    seats_name[k]=null;
                    calculate(k,view);
                }
                //   Log.d("mess","clicked");
             //   Log.d("JHHHHHHHHHHHHHH", seats_name[k]);

            }
        });
        l_6.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if (f % 2 == 0) {
                    l_6.setBackgroundColor(Color.RED);
                    flag = 'B';
                    f++;

                    k += 1;
                    String buffer2;
                    buffer2=l_6.getText().toString();
                    seats_name[k]=buffer2;
                    calculate(k,view);
                } else {
                    l_6.setBackgroundColor(Color.LTGRAY);
                    flag = 'C';
                    f++;
                    k -= 1;
                    seats_name[k]=null;
                    calculate(k,view);
                }

                // Log.d("mess","clicked");
             //   Log.d("JHHHHHHHHHHHHHH", seats_name[k]);

            }
        });
        l_7.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if (g % 2 == 0) {
                    l_7.setBackgroundColor(Color.RED);
                    flag = 'B';
                    g++;
                    k += 1;
                    String buffer2;
                    buffer2=l_7.getText().toString();
                    seats_name[k]=buffer2;
                    calculate(k,view);
                } else {
                    l_7.setBackgroundColor(Color.LTGRAY);
                    flag = 'C';
                    g++;
                    k -= 1;
                    seats_name[k]=null;
                    calculate(k,view);
                }
                // Log.d("mess","clicked");
              //  Log.d("JHHHHHHHHHHHHHH", seats_name[k]);

            }
        });
        l_8.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if (h % 2 == 0) {
                    l_8.setBackgroundColor(Color.RED);
                    flag = 'B';

                    h++;
                    k += 1;
                    String buffer2;
                    buffer2=l_8.getText().toString();
                    seats_name[k]=buffer2;
                    calculate(k,view);
                } else {
                    l_8.setBackgroundColor(Color.LTGRAY);
                    flag = 'C';
                    h++;
                    k -= 1;
                    seats_name[k]=null;
                    calculate(k,view);
                }
                // Log.d("mess","clicked");
           //     Log.d("JHHHHHHHHHHHHHH", seats_name[k]);

            }
        });
        l_9.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if (i % 2 == 0) {
                    l_9.setBackgroundColor(Color.RED);
                    flag = 'B';

                    i++;
                    k += 1;
                    String buffer2;
                    buffer2=l_9.getText().toString();
                    seats_name[k]=buffer2;
                    calculate(k,view);
                } else {
                    l_9.setBackgroundColor(Color.LTGRAY);
                    flag = 'C';
                    i++;
                    k -= 1;
                    seats_name[k]=null;
                    calculate(k,view);
                }
                // Log.d("mess","clicked");
              //  Log.d("JHHHHHHHHHHHHHH", seats_name[k]);

            }
        });
        l_10.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                if (j % 2 == 0) {
                    l_10.setBackgroundColor(Color.RED);
                    flag = 'B';
                    j++;
                    k += 1;
                    String buffer2;
                    buffer2=l_10.getText().toString();
                    seats_name[k]=buffer2;
                    calculate(k,view);
                } else {
                    l_10.setBackgroundColor(Color.LTGRAY);
                    flag = 'C';
                    j++;
                    k -= 1;
                    seats_name[k]=null;
                    calculate(k,view);
                }
                // Log.d("mess","clicked");
                //Log.d("JHHHHHHHHHHHHHH", seats_name[k]);

            }
        });
        l_11.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if (x % 2 == 0) {
                    l_11.setBackgroundColor(Color.RED);
                    flag = 'B';
                    x++;
                    k += 1;
                    String buffer2;
                    buffer2=l_11.getText().toString();
                    seats_name[k]=buffer2;
                    calculate(k,view);
                } else {
                    l_11.setBackgroundColor(Color.LTGRAY);
                    flag = 'C';
                    x++;
                    k -= 1;
                    seats_name[k]=null;
                    calculate(k,view);
                }
                //  Log.d("mess","clicked");
             //   Log.d("JHHHHHHHHHHHHHH", seats_name[k]);

            }
        });
        l_12.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if (l % 2 == 0) {
                    l_12.setBackgroundColor(Color.RED);
                    flag = 'B';
                    l++;
                    k += 1;
                    String buffer2;
                    buffer2=l_12.getText().toString();
                    seats_name[k]=buffer2;
                    calculate(k,view);
                } else {
                    l_12.setBackgroundColor(Color.LTGRAY);
                    flag = 'C';
                    l++;
                    k -= 1;
                    seats_name[k]=null;
                    calculate(k,view);
                }
                // Log.d("mess","clicked");


            }
        });


    }
    public void calculate(int number,View v){
        //stores total price in integer

        //Stores total value in double
        total_price=number*busprice;
        //double to integer conversion price value
        tp=total_price.intValue();
       Log.d("JHHHHHHHHHHHHHH", String.valueOf(total_price));
        //Snack bar is like toast at bottom of screan  passing 3 parameter view ,text ,and how much time does it must show or display
        Snackbar snackbar= Snackbar.make(v, "Selected seats  :"+number+"\nTotal Price INR :"+tp, Snackbar.LENGTH_LONG)
                .setAction("BOOK", new View.OnClickListener() {
                    @Override
                    public void onClick(View view) {
                   //     Toast.makeText(CustomACSleeper.this,"booking confirm",Toast.LENGTH_SHORT).show();
                           Intent ip1 = new Intent(CustomACSleeper.this,Boarding_point.class);
                            ip1.putExtra("buffer",buffer2);
                        ip1.putExtra("dst",dst);
                        ip1.putExtra("src",src);
                        ip1.putExtra("TotalPrice",tp);
                        ip1.putExtra("buscode",busnumber);
                        ip1.putExtra("Date",date);
                        ip1.putExtra("flag",flag);
                        //ip1.putExtra("seats_name",);seats name passed
                        Bundle b=new Bundle();
                        b.putStringArray("seats_name",seats_name);;
                        ip1.putExtras(b);
                            startActivity(ip1);

                    }
                }).setActionTextColor(Color.CYAN);
        // Changing action button text color
        View sbView = snackbar.getView();
        TextView textView = (TextView) sbView.findViewById(android.support.design.R.id.snackbar_text);
        textView.setTextColor(Color.YELLOW);
        snackbar.show();

    }

}

