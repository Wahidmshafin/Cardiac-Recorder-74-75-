package com.example.cardiac_recorder;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.os.Bundle;
import android.widget.RelativeLayout;

import java.util.ArrayList;

public class recycleview extends AppCompatActivity {
    private RecyclerView contactsrecview;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_recycleview);

        contactsrecview = findViewById(R.id.contactsrecview);

        ArrayList<Measurement> measurement = new ArrayList<>();
        measurement.add(new Measurement("1st July","9.56pm",80,137,92,"Healthy"));
        measurement.add(new Measurement("2nd July","9.57pm",81,135,96,"Healthy"));
        measurement.add(new Measurement("3rd July","9.58pm",82,134,93,"Healthy"));
        measurement.add(new Measurement("4th July","9.59pm",83,134,99,"Needs Observation"));

        ContactsRecVIewAdapter adapter = new ContactsRecVIewAdapter(this);
        adapter.setMeasurement(measurement);

        contactsrecview.setAdapter(adapter);
        contactsrecview.setLayoutManager(new LinearLayoutManager(this));
    }
}