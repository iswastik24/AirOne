package com.swastikijari.airone;

import android.app.ProgressDialog;
import android.content.Context;
import android.content.Intent;
import android.sax.TextElementListener;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.util.Log;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import com.firebase.ui.database.FirebaseRecyclerAdapter;
import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.Query;
import com.squareup.picasso.Picasso;

import java.lang.ref.SoftReference;

public class Book_1 extends AppCompatActivity {
    FirebaseAuth firebaseAuth;
    DatabaseReference mref;
    RecyclerView busList;
    private  String source1;
    private String destination1;
    private String date1;
    private String buffer1;
    TextView tvschedule;
    private String status;
    ProgressDialog progressDialog;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_book_1);

        firebaseAuth =FirebaseAuth.getInstance();
        mref= FirebaseDatabase.getInstance().getReference("Bus");
        busList=(RecyclerView)findViewById(R.id.recycleview_bus);
        busList.setHasFixedSize(true);
        busList.setLayoutManager(new LinearLayoutManager(this));
        //get intent
        source1=getIntent().getStringExtra("Source");
        destination1=getIntent().getStringExtra("Destination");
        date1=getIntent().getStringExtra("Date");
        tvschedule=findViewById(R.id.schedule);
        Log.d("DDDD",date1);
        tvschedule.setText(source1+"  --->  "+destination1);
        if(source1.equals("Bengaluru")&&destination1.equals("Delhi")) {
            buffer1="BD";
        }
        else if(source1.equals("Bengaluru")&&destination1.equals("Hydrabad")) {
            buffer1="BH";
        }
        else  if(source1.equals("Bengaluru")&&destination1.equals("Mysore")) {
            buffer1="BM";
        }
        else  if(source1.equals("Bengaluru")&&destination1.equals("Chennai")) {
            buffer1="BC";
        }
        else  if(source1.equals("Bengaluru")&&destination1.equals("Goa")) {
            buffer1="BG";
        }
        else if(source1.equals("Delhi")&&destination1.equals("Bengaluru")) {
            buffer1="DB";
        }
        else if(source1.equals("Hydrabad")&&destination1.equals("Bengaluru")) {
            buffer1="HB";
        }
        else  if(source1.equals("Mysore")&&destination1.equals("Bengaluru")) {
            buffer1="MB";
        }
        else  if(source1.equals("Chennai")&&destination1.equals("Bengaluru")) {
            buffer1="CB";
        }
        else  if(source1.equals("Goa")&&destination1.equals("Bengaluru")) {
            buffer1="GB";
        }

        {


          Query firebasequery = mref.orderByChild("tag").equalTo(buffer1);
            FirebaseRecyclerAdapter<Custom_Bus_list,ViewHolderAdapter1> adapterFirebaseRecyclerAdapter =
                    new FirebaseRecyclerAdapter<Custom_Bus_list, Book_1.ViewHolderAdapter1>(
                            Custom_Bus_list.class,
                            R.layout.custom_bus_list,
                            ViewHolderAdapter1.class,
                            firebasequery)
                    {

                        @Override
                        protected void populateViewHolder(ViewHolderAdapter1 viewHolder, final Custom_Bus_list model, int position) {
                            final String key = getRef(position).getKey();
                            viewHolder.showDetails(model.getTraveller(),
                                    model.getDep_time(),
                                    model.getArr_time(),
                                    model.getSleeper(),
                                    model.getSeats(),
                                    model.getSeats_desc(),
                                    model.getRating(),
                                    model.getRating_desc(),
                                    model.getFare());
                            //on click of each evet
                            viewHolder.mview.setOnClickListener(new View.OnClickListener() {
                                @Override
                                public void onClick(View view) {
                                    Toast.makeText(Book_1.this,key, Toast.LENGTH_SHORT).show();
                                    status=model.getSleeper();
                                     double fare=model.getFare();

                                    if(status.equals("AC Sleeper")){
                                        Toast.makeText(Book_1.this,status, Toast.LENGTH_SHORT).show();
                                        Intent ip1 = new Intent(Book_1.this,ACSleeper.class);
                                        ip1.putExtra("buscode",key);
                                        ip1.putExtra("price",fare);
                                        ip1.putExtra("buffer",buffer1);
                                        ip1.putExtra("seats",model.getSeats());
                                        ip1.putExtra("duration",model.getSeats_desc());
                                        ip1.putExtra("arival",model.getArr_time());
                                        ip1.putExtra("dep",model.getDep_time());
                                        ip1.putExtra("coach",model.getSleeper());
                                        ip1.putExtra("src",source1);
                                        ip1.putExtra("dst",destination1);
                                        ip1.putExtra("Date",date1);
                                        startActivity(ip1);

                                    }
                                    if(status.equals("NON AC Sleeper")){
                                        Toast.makeText(Book_1.this,status, Toast.LENGTH_SHORT).show();
                                        Intent ip1= new Intent(Book_1.this,NonACSleeper.class);
                                        ip1.putExtra("buscode",key);
                                        ip1.putExtra("buffer",buffer1);
                                        startActivity(ip1);

                                    }

                                }
                            });




                        }


                    };
            busList.setAdapter(adapterFirebaseRecyclerAdapter);
        }


    }



    public static class ViewHolderAdapter1 extends RecyclerView.ViewHolder{

        View mview;
        public ViewHolderAdapter1(View itemView) {
            super(itemView);
            mview = itemView;
        }
        public void showDetails(String traveller,
                                String dep_time,
                                String arr_time,
                                String sleeper,
                                double seats,
                                String seats_desc,
                                String rating,
                                String rating_desc,
                                double fare) {

            TextView traveller_disp = mview.findViewById(R.id.travelers);
            TextView departure = mview.findViewById(R.id.dep);
            TextView arrival = mview.findViewById(R.id.arivl);
            TextView sleper1 = mview.findViewById(R.id.sleeper);
            TextView seat_no = mview.findViewById(R.id.seats);
            TextView seats_disc = mview.findViewById(R.id.seat_desc);
            TextView rating_value = mview.findViewById(R.id.ratings);
            TextView rating_disp = mview.findViewById(R.id.rating_desc);
            TextView price = mview.findViewById(R.id.price);
             int value=(int) seats;
            traveller_disp.setText(traveller);
            departure.setText(dep_time);
            arrival.setText(arr_time);
            sleper1.setText(sleeper);
            seat_no.setText(String.valueOf(value));
            seats_disc.setText(seats_desc);
            rating_value.setText(rating);
            rating_disp.setText(rating_desc);
            price.setText(String.valueOf((fare)));


        }
    }
}
