package com.example.firstapplication.myapplication;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

import com.google.firebase.database.FirebaseDatabase;

import java.util.HashMap;

public class next extends AppCompatActivity {
Button addbutton;
EditText name;
EditText age;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_next);
             age=findViewById(R.id.age);
             name=findViewById(R.id.name);
             addbutton=findViewById(R.id.addbutton);

        addbutton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                HashMap<String,Object> m=new HashMap<String,Object>();
                m.put("name",name.getText().toString());
                m.put("age",age.getText().toString());
//                String nameValue = name.getText().toString();
//                String ageValue = age.getText().toString();
                FirebaseDatabase.getInstance().getReference().child("nameValue").push().setValue(m);
            }
        });

    }
}