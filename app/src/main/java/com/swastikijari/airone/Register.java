package com.swastikijari.airone;

import android.app.ProgressDialog;
import android.content.Intent;
import android.support.annotation.NonNull;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.view.accessibility.AccessibilityManager;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import com.google.android.gms.tasks.OnCompleteListener;
import com.google.android.gms.tasks.Task;
import com.google.firebase.auth.AuthResult;
import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.auth.FirebaseUser;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;

public class Register extends AppCompatActivity {
    private EditText username;
    private ImageView userprofilepic;
    private EditText userage;
    private EditText userpassword;
    private EditText userEmail;
    private Button btnregister;
    private FirebaseAuth firebaseAuth;
    private TextView goback;
    private ProgressDialog progressDialog;

    String name,email,password,age;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_register);
        username = (EditText) findViewById(R.id.regName);
        userpassword = (EditText) findViewById(R.id.regPassword);
        userEmail = (EditText) findViewById(R.id.regEmail);
        btnregister = (Button) findViewById(R.id.reqRegister);
        goback = (TextView) findViewById(R.id.regAlredy);
        userage = (EditText) findViewById(R.id.reg_age);
        userprofilepic = (ImageView) findViewById(R.id.userdp);
        progressDialog =new ProgressDialog(this);

        firebaseAuth = FirebaseAuth.getInstance();
        btnregister.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                progressDialog.setMessage("Wait until its loads");
                progressDialog.show();
                if (validate()) {

                    //upload
                    String Email = userEmail.getText().toString().trim();
                    String pass = userpassword.getText().toString().trim();
                    firebaseAuth.createUserWithEmailAndPassword(Email, pass).addOnCompleteListener(new OnCompleteListener<AuthResult>() {
                        @Override
                        public void onComplete(@NonNull Task<AuthResult> task) {
                            if (task.isSuccessful()) {
                                progressDialog.dismiss();

                                sendEmailVerification();
                            } else {

                                Toast.makeText(Register.this, "Reg Failed", Toast.LENGTH_SHORT).show();
                                progressDialog.dismiss();
                            }

                        }
                    });
                }
            }
        });
        goback.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent ip1 = new Intent(Register.this, MainActivity.class);
                startActivity(ip1);
            }
        });
    }

    private Boolean validate() {
        Boolean result = false;
        name = username.getText().toString();
         email = userEmail.getText().toString();
         password = userpassword.getText().toString();
         age=userage.getText().toString();
        if (name.isEmpty() || email.isEmpty() || password.isEmpty() || age.isEmpty()) {
            progressDialog.dismiss();
            Toast.makeText(Register.this, "Enter details in all fields", Toast.LENGTH_LONG).show();
        } else {
            result = true;
        }
        return result;

    }

    private void sendEmailVerification() {
        FirebaseUser firebaseUser = firebaseAuth.getCurrentUser();
        if (firebaseUser != null) {
            firebaseUser.sendEmailVerification().addOnCompleteListener(new OnCompleteListener<Void>() {
                @Override
                public void onComplete(@NonNull Task<Void> task) {
                    if (task.isSuccessful()) {
                        sendUserData();
                        Toast.makeText(Register.this, "Successfully Registered A registration mail has been sent", Toast.LENGTH_SHORT).show();
                        firebaseAuth.signOut();
                        finish();
                        startActivity(new Intent(Register.this, MainActivity.class));
                    } else {
                        Toast.makeText(Register.this, "MAil not Sent", Toast.LENGTH_SHORT).show();

                    }
                }
            });
        }
    }

    private void sendUserData() {
        FirebaseDatabase firebaseDatabase = FirebaseDatabase.getInstance();
        DatabaseReference ref = firebaseDatabase.getReference().child("User");
        UserProfile userProfile =new UserProfile(age,name,email);
        ref.child(firebaseAuth.getUid()).setValue(userProfile);
    }
}