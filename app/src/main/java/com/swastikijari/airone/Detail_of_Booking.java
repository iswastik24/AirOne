package com.swastikijari.airone;

import android.content.DialogInterface;
import android.content.Intent;
import android.net.Uri;
import android.sax.StartElementListener;
import android.support.v7.app.AlertDialog;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.RadioButton;
import android.widget.RadioGroup;
import android.widget.Toast;

import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;

import java.util.Arrays;
import java.util.Random;

public class Detail_of_Booking extends AppCompatActivity {
    EditText email,phon_no,name,age;
    RadioGroup gendergroup;
    RadioButton radio_gender;
    String source;
    String destination;
    String busnumber;
    Integer totalCost;
    String boarding;
    String drop_point;
    String date;
    private String email_str,phon_str,name_str,age_str,gender;
    Button b_next;
    String booking_id,flag;
    String names[];
    Random rand;
    AlertDialog alertDialog;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_detail_of__booking);
        rand = new Random();
        b_next=findViewById(R.id.goto_displayticket);
        email=findViewById(R.id.ed_email);
        phon_no=findViewById(R.id.ed_phone);
        name=findViewById(R.id.ed_name);
        age=findViewById(R.id.ed_age);
        gendergroup=findViewById(R.id.radio_group);
        //get the details
        source=getIntent().getStringExtra("Source");
        flag=getIntent().getStringExtra("flag");
        destination=getIntent().getStringExtra("Dest");
        totalCost=getIntent().getIntExtra("TotalCost",0);
        busnumber=getIntent().getStringExtra("Busnumber");
        boarding=getIntent().getStringExtra("Boarding_pt");
        drop_point=getIntent().getStringExtra("Drop_loc");
        date=getIntent().getStringExtra("Date");
        Bundle z=this.getIntent().getExtras();
        names=z.getStringArray("seats_name");


        //on click it will go to payment activity

        b_next.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                {

                    //Send the data to database
                    email_str=email.getText().toString();
                    phon_str=phon_no.getText().toString();
                    name_str=name.getText().toString();
                    age_str=age.getText().toString();

                    Log.d("DDDDDddd", date);
                    Log.d("DDDDDddd", source);
                    Log.d("DDDDDddd", destination);
                    Log.d("DDDDDddd", String.valueOf(totalCost));
                    Log.d("DDDDDddd", email_str);
                    Log.d("DDDDDddd", phon_str);
                    Log.d("DDDDDddd", name_str);
                    Log.d("DDDDDddd", age_str);
                    Log.d("DDDDDddd", boarding);
                    Log.d("DDDDDddd",drop_point);
                    Log.d("DDDDDddd", busnumber);
                        int rand_int1 = rand.nextInt(1000);

                    booking_id=(source.substring(0)+destination.substring(0)+(1000+rand_int1));
                    Log.d("DDDDDddd", booking_id);
                    Log.d("DDDDDDdd", Arrays.toString(names));
                    //Payment interface using alert dialog
                    final AlertDialog.Builder builder = new AlertDialog.Builder(Detail_of_Booking.this);
                    builder.setMessage("Welcome to Payment interface !!!.\nSelect any one option and pay money").setCancelable(false)
                            .setPositiveButton("PAY NOW", new DialogInterface.OnClickListener() {
                                @Override
                                public void onClick(DialogInterface dialogInterface, int i) {
                                   Toast.makeText(Detail_of_Booking.this,"Payment successfull",Toast.LENGTH_LONG).show();
                                    sendUserData();
                                  Intent ip1 = new Intent(Detail_of_Booking.this,StartIndex.class);
                                  ip1.putExtra("bid",booking_id);
                                  ip1.putExtra("src",source);
                                  ip1.putExtra("dest",destination);
                                  ip1.putExtra("doj",date);
                                  ip1.putExtra("name",name_str);
                                  ip1.putExtra("bdpt",boarding);
                                  ip1.putExtra("drpt",drop_point);
                                  ip1.putExtra("seatlist",Arrays.toString(names));
          sendEmail(email_str);
                                       FirebaseDatabase database = FirebaseDatabase.getInstance();
                                    final DatabaseReference mef = database.getReference("Seats").child("buffer");
                                    mef.setValue(flag);
                                  startActivity(ip1);
                                }
                            }).setNegativeButton("CANCLE", new DialogInterface.OnClickListener() {
                        @Override
                        public void onClick(DialogInterface dialogInterface, int i) {
                            dialogInterface.cancel();
                        }
                    }).create().show();

                }


            }
        });

    }
    public void Check0(View v){
        int radioId = gendergroup.getCheckedRadioButtonId();
        radio_gender = findViewById(radioId);
        gender=radio_gender.getText().toString();

       //
    }
    private void sendUserData() {
        FirebaseDatabase firebaseDatabase = FirebaseDatabase.getInstance();
        DatabaseReference ref = firebaseDatabase.getReference().child("Booking");
        Booking_send_details booking_send_details= new Booking_send_details(source,destination,date,boarding,drop_point,email_str,
                phon_str, name_str,age_str,booking_id,Arrays.toString(names),busnumber);
        ref.child(booking_id).setValue(booking_send_details);
    }
    protected void sendEmail(String email_str) {
        Log.i("Send email", "");
        String TO = email_str;

        Intent emailIntent = new Intent(Intent.ACTION_SEND);

        emailIntent.setData(Uri.parse("mailto:"));
        emailIntent.setType("text/plain");
        emailIntent.putExtra(Intent.EXTRA_EMAIL, TO);
        emailIntent.putExtra(Intent.EXTRA_SUBJECT, "Bus tickets ");
        emailIntent.putExtra(Intent.EXTRA_TEXT, "Bus ticket sent successfully");

        try {
            startActivity(Intent.createChooser(emailIntent, "Send mail..."));
            finish();
           // Log.i("Finished sending email...", "");
        } catch (android.content.ActivityNotFoundException ex) {
            Toast.makeText(Detail_of_Booking.this, "There is no email client installed.", Toast.LENGTH_SHORT).show();
        }
    }
}
