package com.example.cardiac_recorder;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.RecyclerView;

import android.os.Bundle;

public class recycleview extends AppCompatActivity {
    private RecyclerView contactsrecview;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_recycleview);

        contactsrecview = findViewById(R.id.contactsrecview);
    }
}