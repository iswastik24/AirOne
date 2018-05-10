package com.swastikijari.airone;

import android.content.Intent;
import android.support.annotation.NonNull;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import com.google.android.gms.tasks.OnCompleteListener;
import com.google.android.gms.tasks.Task;
import com.google.firebase.auth.FirebaseAuth;

public class ForgetPassword extends AppCompatActivity {

     private Button reset;
     private EditText f_email;
     private FirebaseAuth firebaseAuth;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_forget_password);
        firebaseAuth =FirebaseAuth.getInstance();
        reset =(Button)findViewById(R.id.fbtn);
        f_email=(EditText)findViewById(R.id.femail);

        reset.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                String fmail = f_email.getText().toString().trim();
                if(fmail.equals("")){
                    Toast.makeText(ForgetPassword.this,"Please NEter your Email id",Toast.LENGTH_SHORT).show();
                }
                else{
                    firebaseAuth.sendPasswordResetEmail(fmail).addOnCompleteListener(new OnCompleteListener<Void>() {
                        @Override
                        public void onComplete(@NonNull Task<Void> task) {
                            if(task.isSuccessful()){
                                Toast.makeText(ForgetPassword.this,"Password Reset Email Sent ",Toast.LENGTH_SHORT).show();
                                startActivity(new Intent(ForgetPassword.this,MainActivity.class));
                            }
                            else{
                                Toast.makeText(ForgetPassword.this,"Error in sending password Reset email ",Toast.LENGTH_SHORT).show();

                            }
                        }
                    });
                }

            }
        });
    }
}
