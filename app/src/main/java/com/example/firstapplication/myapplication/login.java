package com.example.firstapplication.myapplication;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.text.TextUtils;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import com.google.android.gms.tasks.OnSuccessListener;
import com.google.firebase.auth.AuthResult;
import com.google.firebase.auth.FirebaseAuth;

public class login extends AppCompatActivity {
EditText email;
    EditText password;
    Button login2;
    FirebaseAuth auth;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);
        email=findViewById(R.id.email2);
        password=findViewById(R.id.password2);
        login2=findViewById(R.id.login2);
        auth=FirebaseAuth.getInstance();

        login2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String email1=email.getText().toString();
                String password1=password.getText().toString();
                if (TextUtils.isEmpty(email1)||TextUtils.isEmpty(password1))
                {
                    Toast.makeText(getApplicationContext(),"fill the filds", Toast.LENGTH_LONG).show();
                }else {
                    login3(email1,password1);
                }
            }

            void login3(String email, String password)
            {
                auth.signInWithEmailAndPassword(email, password).addOnSuccessListener(login.this, new OnSuccessListener<AuthResult>() {
                    @Override
                    public void onSuccess(AuthResult authResult) {
                        Toast.makeText(login.this,"make-done",Toast.LENGTH_LONG).show();
                        Intent a=new Intent(getApplicationContext(), next1.class);
                        startActivity(a);

                    }
                });
            }
        });
    }


}