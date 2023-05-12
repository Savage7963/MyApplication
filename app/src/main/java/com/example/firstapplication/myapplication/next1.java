package com.example.firstapplication.myapplication;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.ListView;

import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.ValueEventListener;

import java.util.ArrayList;

public class next1 extends AppCompatActivity {
    private Button show;
    private ListView list;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_next1);

        show = findViewById(R.id.show);
        list = findViewById(R.id.list);

        show.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                ArrayList<String> a = new ArrayList<>();
                ArrayAdapter<String> adapter = new ArrayAdapter<>(next1.this, R.layout.items, a);
                list.setAdapter(adapter);

                FirebaseDatabase.getInstance().getReference().child("vendor1").addListenerForSingleValueEvent(new ValueEventListener() {
                    @Override
                    public void onDataChange(@NonNull DataSnapshot snapshot) {
                        if (snapshot.exists()) {
                            a.clear();
                            for (DataSnapshot childSnapshot : snapshot.getChildren()) {
                                String name = childSnapshot.child("name").getValue(String.class);
                                String age = childSnapshot.child("age").getValue(String.class);
                                String t = name + ":" + age;
                                a.add(t);
                            }
                            adapter.notifyDataSetChanged();
                        }
                    }

                    @Override
                    public void onCancelled(@NonNull DatabaseError error) {
                        Log.e("next1", "Failed to read value.", error.toException());
                    }
                });

                FirebaseDatabase.getInstance().getReference().child("nameValue").addListenerForSingleValueEvent(new ValueEventListener() {
                    @Override
                    public void onDataChange(@NonNull DataSnapshot snapshot) {
                        if (snapshot.exists()) {
//                            a.clear();
                            for (DataSnapshot childSnapshot : snapshot.getChildren()) {
                                String name = childSnapshot.child("name").getValue(String.class);
                                String age = childSnapshot.child("age").getValue(String.class);
                                String t = name + ":" + age;
                                a.add(t);
                            }
                            adapter.notifyDataSetChanged();
                        }
                    }

                    @Override
                    public void onCancelled(@NonNull DatabaseError error) {
                        Log.e("next1", "Failed to read value.", error.toException());
                    }
                });
            }
        });

    }
}
