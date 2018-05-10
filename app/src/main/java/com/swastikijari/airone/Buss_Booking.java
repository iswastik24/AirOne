package com.swastikijari.airone;

import android.app.DatePickerDialog;
import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.AutoCompleteTextView;
import android.widget.Button;
import android.widget.CalendarView;
import android.widget.DatePicker;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.ValueEventListener;

import java.util.Calendar;

public class Buss_Booking extends AppCompatActivity {

    AutoCompleteTextView src,dest;
    DatePickerDialog picker;
    Button dat;
    private static String iii;
    Button search_bus;
    private String source,destination,date;
    String[] cities1 = {"Bengaluru","Chennai","Mumbai","Hydrabad","Delhi","Mysore","Goa"};
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_buss__booking);
        src=findViewById(R.id.source);
        search_bus=findViewById(R.id.bus_book);

        dest=findViewById(R.id.destination);
        dat=findViewById(R.id.date_of_jr);
        //Creating a adapters to extarct the string and display it into a desired layout formet
        final ArrayAdapter<String> sourceadapter = new ArrayAdapter<String>(this,android.R.layout.select_dialog_item,cities1);
        final ArrayAdapter<String> destadapter = new ArrayAdapter<String>(this,android.R.layout.select_dialog_item,cities1);
        //setting a adapter to the Auto completed text view
        src.setAdapter(sourceadapter);
        //Setting Throshold ie.. if user enters a single letter then it displays the hint for different cities
        src.setThreshold(1);
        //setting a adapter to the Auto completed text view  for destination
        dest.setAdapter(destadapter);
        //Setting Throshold ie.. if user enters a single letter then it displays the hint for different cities for destination
        dest.setThreshold(1);
        //getting the entered source and destination


        //on date button click the date should be seen and get the date into string and procede further
        dat.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                    final Calendar cldr = Calendar.getInstance();
                    final int day = cldr.get(Calendar.DAY_OF_MONTH);
                    int month = cldr.get(Calendar.MONTH);
                    int year = cldr.get(Calendar.YEAR);
                    // date picker dialog
                    picker = new DatePickerDialog(Buss_Booking.this,
                            new DatePickerDialog.OnDateSetListener() {
                                @Override
                                public void onDateSet(DatePicker view, int year, int monthOfYear, int dayOfMonth) {
                                     dat.setText(dayOfMonth + "/" + (monthOfYear + 1) + "/" + year);
                                    Toast.makeText(Buss_Booking.this,dat.getText().toString(),Toast.LENGTH_SHORT).show();

                                }
                            }, year, month, day);
                    picker.show();
                }
            });
        search_bus.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                source=src.getText().toString();
                destination=dest.getText().toString();
                date=dat.getText().toString();
                Log.d("DDDD",date);
                 if(source.matches("")||dest.equals("")||date.matches("")){
                     Toast.makeText(Buss_Booking.this,"Enter the details ",Toast.LENGTH_SHORT).show();

                 }
                 else {
                     Intent intent = new Intent(Buss_Booking.this, Book_1.class);
                     intent.putExtra("Source", source);
                     intent.putExtra("Destination", destination);
                     intent.putExtra("Date", date);
                     startActivity(intent);
                 }

            }
        });

    }


}
