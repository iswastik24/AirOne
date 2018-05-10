package com.swastikijari.airone;

import android.annotation.SuppressLint;
import android.content.Context;
import android.content.Intent;
import android.content.res.Resources;
import android.sax.StartElementListener;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.AutoCompleteTextView;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageButton;
import android.widget.ImageView;
import android.widget.ListView;
import android.widget.TextView;
import android.widget.Toast;

import com.firebase.ui.database.FirebaseRecyclerAdapter;
import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.Query;
import com.squareup.picasso.Picasso;

import org.w3c.dom.Text;

import java.security.AccessControlContext;
import java.util.ArrayList;

import static java.security.AccessController.getContext;

public class Second extends AppCompatActivity  {

    FirebaseAuth firebaseAuth;
    AutoCompleteTextView autoCompleteTextView;
    ImageButton search;
   // Button nextActivity;
    RecyclerView recyclerView;
    DatabaseReference mref;
    String p_name;
    String[] names={"Bangalore","Mysore","Hyderabad","Goa","Mumbai","Chennai","Delhi"};

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_second);
        firebaseAuth =FirebaseAuth.getInstance();
        //initilize database
        mref=FirebaseDatabase.getInstance().getReference("Places");
        //linking the java with xml llobjects using blow methord
        autoCompleteTextView=findViewById(R.id.autoCompleteTextView);
        //nextActivity=findViewById(R.id.book);
        search=findViewById(R.id.imageButton);
        recyclerView=findViewById(R.id.recycleview);
        recyclerView.setHasFixedSize(true);
        recyclerView.setLayoutManager(new LinearLayoutManager(this));
        //Adapter to autocompleted text view is created using array Adapter
        ArrayAdapter<String>adapter = new ArrayAdapter<String>(Second.this,android.R.layout.simple_dropdown_item_1line,names);
        //setting max throshold limit which is 1 ie.. if u enter one word it will show the hint
        autoCompleteTextView.setThreshold(1);
        //set the addapter for auto complete text view
        autoCompleteTextView.setAdapter(adapter);

        //search initilization
        search.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                p_name = autoCompleteTextView.getText().toString();
                Log.d("Message", "search " + autoCompleteTextView.getText().toString());
                FirebaseSearch();
            }
        });
        //on book button click
      /*  nextActivity.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                startActivity(new Intent(Second.this,Booking.class));
            }
        });*/
    }

    public void FirebaseSearch() {
        Query firebasequery = mref.orderByChild("tag").startAt(p_name).endAt(p_name+"\uf8ff");
        FirebaseRecyclerAdapter<Display,ViewHolderAdapter>adapterFirebaseRecyclerAdapter =
                new FirebaseRecyclerAdapter<Display, ViewHolderAdapter>(
                        Display.class,
                        R.layout.custom_display,
                        ViewHolderAdapter.class,
                        firebasequery)

                 {
                    @Override
                    protected void populateViewHolder(ViewHolderAdapter viewHolder, Display model, int position) {

                        viewHolder.setDetails(getApplicationContext(),model.getTitle(),model.getDesc(),model.getImage());
                    }
                };
        recyclerView.setAdapter(adapterFirebaseRecyclerAdapter);
    }

    public static class ViewHolderAdapter extends RecyclerView.ViewHolder{

        View mview;
        public ViewHolderAdapter(View itemView) {
            super(itemView);
            mview = itemView;
        }
        public void setDetails(Context ctx,String title, String desc, String modelImage){
            TextView title_disp = mview.findViewById(R.id.title1);
            TextView desc_disp = mview.findViewById(R.id.description);
            ImageView image_disp = mview.findViewById(R.id.image1);
            title_disp.setText(title);
            desc_disp.setText(desc);
            Picasso.with(ctx).load(modelImage).into(image_disp);


        }
    }

}

