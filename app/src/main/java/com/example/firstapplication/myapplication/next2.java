package com.example.firstapplication.myapplication;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.widget.ArrayAdapter;
import android.widget.ListView;

import java.util.ArrayList;

public class next2 extends AppCompatActivity {
    private ListView list;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_next2);

        list = findViewById(R.id.list);

        // Retrieve the data from the Intent object
        ArrayList<String> data = getIntent().getStringArrayListExtra("data");

        // Create an ArrayAdapter to display the data in a ListView
        ArrayAdapter<String> adapter = new ArrayAdapter<>(this, R.layout.items, data);
        list.setAdapter(adapter);
    }
}