package com.swastikijari.airone;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.RadioGroup;
import android.widget.Toast;

import java.util.Random;

public class Payment extends AppCompatActivity {
Button button;
RadioGroup rg1;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_payment);
        button=findViewById(R.id.button9);
        rg1=findViewById(R.id.rg8);
        button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Toast.makeText(Payment.this,"Success ful payment",Toast.LENGTH_LONG).show();
            }
        });
    }
}
