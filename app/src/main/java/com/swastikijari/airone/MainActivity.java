package com.swastikijari.airone;

import android.app.ProgressDialog;
import android.content.Intent;
import android.support.annotation.NonNull;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import com.google.android.gms.tasks.OnCompleteListener;
import com.google.android.gms.tasks.Task;
import com.google.firebase.auth.AuthResult;
import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.auth.FirebaseUser;

public class MainActivity extends AppCompatActivity {
     private EditText username,password;
     private Button btnlogin,reglink;
     private TextView attempts;
     private int counter=5;
      private FirebaseAuth firebaseAuth;
      private ProgressDialog progressDialog;
      private TextView forgetpass;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        username =(EditText)findViewById(R.id.user_name);
        password =(EditText)findViewById(R.id.password);
        btnlogin=(Button)findViewById(R.id.btlogin);
        attempts=(TextView)findViewById(R.id.tvcount);
        reglink=(Button) findViewById(R.id.reglink);

        forgetpass=(TextView)findViewById(R.id.forgetpass);

        attempts.setText("No of attempts Remaining is 5");
         //getting an instance of fire base auth
         firebaseAuth = FirebaseAuth.getInstance();

         progressDialog =new ProgressDialog(this);

         FirebaseUser user=firebaseAuth.getCurrentUser();
       if(user!=null){

            startActivity(new Intent(MainActivity.this,StartIndex.class));
            finish();

        }
        forgetpass.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                startActivity(new Intent(MainActivity.this,ForgetPassword.class));
            }
        });
        btnlogin.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if((username.getText().toString().isEmpty())||password.getText().toString().isEmpty()){
                    Toast.makeText(MainActivity.this,"Enter the User name and password",Toast.LENGTH_SHORT).show();
                }else {
                    validate(username.getText().toString().trim(), password.getText().toString().trim());
                }
            }
        });
        reglink.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent ip1 = new Intent(MainActivity.this,Register.class);
                startActivity(ip1);
            }
        });

    }
    private  void validate(String username, final String password){
        progressDialog.setMessage("Wait until its loads");
        progressDialog.show();
        firebaseAuth.signInWithEmailAndPassword(username,password).addOnCompleteListener(new OnCompleteListener<AuthResult>() {
            @Override
            public void onComplete(@NonNull Task<AuthResult> task) {

                 if(task.isSuccessful()){
                     progressDialog.dismiss();
                   //  checkEmailVerification();
                     startActivity(new Intent(MainActivity.this,StartIndex.class));
                     finish();

                 }
                 else{
                     Toast.makeText(MainActivity.this,"Incorrect Credentials",Toast.LENGTH_LONG).show();
                     counter--;
                     attempts.setText("No of attemts remaining  is"+ counter);
                     progressDialog.dismiss();
                     if(counter==0){
                         btnlogin.setEnabled(false);
                     }
                 }
            }
        });
    }
    private void checkEmailVerification(){

        FirebaseUser firebaseUser =FirebaseAuth.getInstance().getCurrentUser();
        Boolean emailFlag =firebaseUser.isEmailVerified();
        if(emailFlag){
            finish();
            startActivity(new Intent(MainActivity.this,StartIndex.class));
        }else {
            Toast.makeText(MainActivity.this,"Verify your Email",Toast.LENGTH_LONG).show();
            firebaseAuth.signOut();
        }
    }
}
