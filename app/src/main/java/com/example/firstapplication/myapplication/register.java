package com.example.firstapplication.myapplication;

import android.app.Activity;
import android.os.Bundle;
import android.text.TextUtils;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;

import com.google.android.gms.tasks.OnCompleteListener;
import com.google.android.gms.tasks.Task;
import com.google.firebase.auth.AuthResult;
import com.google.firebase.auth.FirebaseAuth;

public class register extends AppCompatActivity {
private EditText password;
    private EditText email;
    private Button register2;

    private FirebaseAuth auth;


    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_register);
        email=findViewById(R.id.email);
        password=findViewById(R.id.password);
        register2=findViewById(R.id.register2);
        auth=FirebaseAuth.getInstance();

        register2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
            String email1=email.getText().toString();
            String password1=password.getText().toString();
            if(TextUtils.isEmpty(email1)|| TextUtils.isEmpty(password1))
            {
                Toast.makeText(getApplicationContext(),"enetr mail",Toast.LENGTH_SHORT).show();

            }else{
                regis(email1,password1);
            }

            }
        });
    }
    private void regis(String email, String password) {
        auth.createUserWithEmailAndPassword(email, password).addOnCompleteListener(register.this, new OnCompleteListener<AuthResult>() {
            @Override
            public void onComplete(@NonNull Task<AuthResult> task) {
                if(task.isSuccessful()){
                    Toast.makeText(getApplicationContext(),"issucessful",Toast.LENGTH_LONG).show();
                }else {
                    Toast.makeText(getApplicationContext(),"isntsucessful",Toast.LENGTH_LONG).show();
                }
            }
        });
    }

}
