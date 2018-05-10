package com.swastikijari.airone;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.RadioButton;
import android.widget.RadioGroup;
import android.widget.Toast;

import java.util.Arrays;

//Data entry
public class Boarding_point extends AppCompatActivity {
    //stores the bus tag which displays bus route
RadioButton b_r1,d_r1,a,b,c,d,e,f,g,h;
RadioGroup rgb,rgd;
Button b1;
String bording_loc,drop_loc;
String src;
    String dest,flag;
    String busnumber;
    int TotalPrice;
    String date;
    String names[];
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_boarding_point);
        rgb=findViewById(R.id.rg_b);
        rgd=findViewById(R.id.rg_d);
        b1=findViewById(R.id.button4);
        a=findViewById(R.id.r1);
        b=findViewById(R.id.r2);
        c=findViewById(R.id.r3);
        d=findViewById(R.id.r4);
        e=findViewById(R.id.r5);
        f=findViewById(R.id.r6);
        g=findViewById(R.id.r7);
        h=findViewById(R.id.r8);
         src = getIntent().getStringExtra("src");
        flag = getIntent().getStringExtra("flag");

         dest=getIntent().getStringExtra("dst");
        TotalPrice =  getIntent().getIntExtra("TotalPrice",0);
        busnumber=getIntent().getStringExtra("buscode");
        dest=getIntent().getStringExtra("dst");
        date=getIntent().getStringExtra("Date");
        Bundle z=this.getIntent().getExtras();
        names=z.getStringArray("seats_name");
                if(src.equals("Bengaluru")&&dest.equals("Goa")) {
            //Source places added below
            a.setText("Kempegowda Bus Station");
            b.setText("Malleshwaram");
            c.setText("Vijaynagar");
            d.setText("Yeshwantpur");
            //Destination places to be added below
            e.setText("Madgao");
            f.setText("Vasco");
            g.setText("Goa Church ");
            h.setText("Panaji");
        }

        if(src.equals("Bengaluru")&&dest.equals("Delhi")) {
            //Source places added below
            a.setText("Kempegowda Bus Station");
            b.setText("Malleshwaram");
            c.setText("Vijaynagar");
            d.setText("Yeshwantpur");
            //Destination places to be added below
            e.setText("Gurugram");
            f.setText("Mehrauli");
            g.setText("Rashtrapati Bhawan ");
            h.setText("Humayun Tomb");

        }
        if(src.equals("Bengaluru")&&dest.equals("Hydrabad")) {
            //Source places added below
            a.setText("Kempegowda Bus Station");
            b.setText("Malleshwaram");
            c.setText("Vijaynagar");
            d.setText("Yeshwantpur");
            //Destination places to be added below
            e.setText("Ramoji Flim city");
            f.setText("Salar jung museum");
            g.setText("Golkonda Fort");
            h.setText("Inorbit");

        }
        if(src.equals("Bengaluru")&&dest.equals("Mysore")) {
            //Source places added below
            a.setText("Kempegowda Bus Station");
            b.setText("Malleshwaram");
            c.setText("Vijaynagar");
            d.setText("Yeshwantpur");
            //Destination places to be added below
            e.setText("Chamundi Hills");
            f.setText("Mysore Bus stand ");
            g.setText("Mysore zoo ");
            h.setText("Mysore Palace");

        }
        if(src.equals("Bengaluru")&&dest.equals("Chennai")) {
            //Source places added below
            a.setText("Kempegowda Bus Station");
            b.setText("Malleshwaram");
            c.setText("Vijaynagar");
            d.setText("Yeshwantpur");
            //Destination places to be added below
            e.setText("Kapaleeshwar Temple");
            f.setText("Chennai Metro Rail");
            g.setText("Mylapore");
            h.setText("Jagannath Temple,Kanathur");
        }
        if(src.equals("Delhi")&&dest.equals("Bengaluru")) {
            //Source places added below
            a.setText("Gurugram");
            b.setText("Mehrauli");
            c.setText("Rashtrapati Bhawan ");
            d.setText("Humayun Tomb");
            //Destination places to be added below
            e.setText("Kempegowda Bus Station");
            f.setText("Malleshwaram");
            g.setText("Vijaynagar");
            h.setText("Yeshwantpur");
        }
        if(src.equals("Hydrabad")&&dest.equals("Bengaluru")) {
            //Source places added below
            a.setText("Ramoji Flim city");
            b.setText("Salar jung museum");
            c.setText("Golkonda Fort");
            d.setText("Inorbit");
            //Destination places to be added below
            e.setText("Kempegowda Bus Station");
            f.setText("Malleshwaram");
            g.setText("Vijaynagar");
            h.setText("Yeshwantpur");
        }
        if(src.equals("Mysore")&&dest.equals("Bengaluru")) {
            //Source places added below
            a.setText("Chamundi Hills");
            b.setText("Mysore Bus stand ");
            c.setText("Mysore zoo ");
            d.setText("Mysore Palace");
            //Destination places to be added below
            e.setText("Kempegowda Bus Station");
            f.setText("Malleshwaram");
            g.setText("Vijaynagar");
            h.setText("Yeshwantpur");
        }
        if(src.equals("Chennai")&&dest.equals("Bengaluru")) {
            //Source places added below
            a.setText("Kapaleeshwar Temple");
            b.setText("Chennai Metro Rail");
            c.setText("Mylapore");
            d.setText("Jagannath Temple,Kanathur");
            //Destination places to be added below
            e.setText("Kempegowda Bus Station");
            f.setText("Malleshwaram");
            g.setText("Vijaynagar");
            h.setText("Yeshwantpur");
        }
        if(src.equals("Goa")&&dest.equals("Bengaluru")) {
            //Source places added below
            a.setText("Madgao");
            b.setText("Vasco");
            c.setText("Goa Church ");
            d.setText("Panaji");
            //Destination places to be added below
            e.setText("Kempegowda Bus Station");
            f.setText("Malleshwaram");
            g.setText("Vijaynagar");
            h.setText("Yeshwantpur");
        }

       Log.d("XXXXXX", Arrays.toString(names));






    }
    public void Check(View v){
        int radioId = rgb.getCheckedRadioButtonId();
        b_r1 = findViewById(radioId);
        bording_loc=b_r1.getText().toString();

    }
    public void Check2(View v){
        int radioId2 = rgd.getCheckedRadioButtonId();
        d_r1=findViewById(radioId2);
        drop_loc=d_r1.getText().toString();


    }
    public void Book(View v){
      if(a.isChecked()||b.isChecked()||c.isChecked()||d.isChecked()){

        }
        else{
          Toast.makeText(Boarding_point.this,"Seclect Boarding point",Toast.LENGTH_SHORT).show();

      }
        if(e.isChecked()||f.isChecked()||g.isChecked()||h.isChecked()){

        }else{
            Toast.makeText(Boarding_point.this,"Seclect Drop point",Toast.LENGTH_SHORT).show();

        }
        if((a.isChecked()||b.isChecked()||c.isChecked()||d.isChecked())&&
                (e.isChecked()||f.isChecked()||g.isChecked()||h.isChecked())){
            Intent ip1 = new Intent(Boarding_point.this, Detail_of_Booking.class);
            ip1.putExtra("Source",src);
            ip1.putExtra("Dest",dest);
            ip1.putExtra("TotalCost",TotalPrice);
            ip1.putExtra("Busnumber",busnumber);
            ip1.putExtra("Boarding_pt",bording_loc);
            ip1.putExtra("Drop_loc",drop_loc);
            ip1.putExtra("Date",date);
            ip1.putExtra("flag",flag);
            Bundle b=new Bundle();

            b.putStringArray("seats_name",names);;
            ip1.putExtras(b);
            startActivity(ip1);
        }
        else {
            Toast.makeText(Boarding_point.this,"Select boarding and drop points",Toast.LENGTH_SHORT).show();

        }

    }
}
