package com.example.cardiac_recorder;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;

public class showActivity extends AppCompatActivity
{

    @Override
    protected void onCreate(Bundle savedInstanceState)
    {
        Intent intent=getIntent();
        boolean add=intent.getBooleanExtra("add",false);
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_show);
    }
}