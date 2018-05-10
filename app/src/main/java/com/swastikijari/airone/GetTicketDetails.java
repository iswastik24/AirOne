package com.swastikijari.airone;

import android.content.Context;
import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.util.Log;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import com.firebase.ui.database.FirebaseRecyclerAdapter;
import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.Query;
import com.google.firebase.database.ValueEventListener;
import com.squareup.picasso.Picasso;

public class GetTicketDetails extends AppCompatActivity {
    FirebaseAuth firebaseAuth;
    RecyclerView busList;
    RecyclerView recyclerView;
    DatabaseReference mref;
    TextView tv1,tv2,tv3,tv4,tv5,tv6,tv7,tv8;
    String source,destination,boarding,booking_id,date,drop_point,name_d,list_name;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_get_ticket_details);
        source=getIntent().getStringExtra("src");
        destination=getIntent().getStringExtra("dest");
        boarding=getIntent().getStringExtra("bdpt");
        drop_point=getIntent().getStringExtra("drpt");
        date=getIntent().getStringExtra("doj");
        booking_id=getIntent().getStringExtra("bid");
        name_d=getIntent().getStringExtra("name");
        list_name=getIntent().getStringExtra("seatlist");
        mref=FirebaseDatabase.getInstance().getReference();

        tv1=findViewById(R.id.bid);
        tv2=findViewById(R.id.s1);
        tv3=findViewById(R.id.d1);

        tv4=findViewById(R.id.doj11);

        tv5=findViewById(R.id.bdpt);

        tv6=findViewById(R.id.drpt);
        tv7=findViewById(R.id.bname);
        tv8=findViewById(R.id.getseats);


            tv1.setText(booking_id);
             tv2.setText(source);
             tv3.setText(destination);
             tv4.setText(date);
             tv5.setText(boarding);
             tv6.setText(drop_point);
             tv7.setText(name_d);
             tv8.setText(list_name);

        // Write a message to the database


    }
    // Read from the database




}
