package com.example.cardiac_recorder;

import static androidx.constraintlayout.helper.widget.MotionEffect.TAG;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.util.Log;
import android.widget.ArrayAdapter;
import android.widget.ListView;
import android.widget.TextView;

import java.sql.Time;
import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;
import java.util.GregorianCalendar;

public class MainActivity extends AppCompatActivity
{
    TextView txt_test;
    ListView record_listView;
    @Override
    protected void onCreate(Bundle savedInstanceState)
    {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        ArrayList<RecordTime> timeList=new ArrayList<>();
        record_listView=findViewById(R.id.ma_record_listView);
        timeList.add(new RecordTime(18,6,2022,14,34));
        timeList.add(new RecordTime(22,6,2022,16,24));
        timeList.add(new RecordTime(20,6,2022,19,54));
        ArrayAdapter<RecordTime> arrayAdapter=new CustomList(this,timeList);
        record_listView.setAdapter(arrayAdapter);
        Log.e(TAG, "onCreate: "+timeList.get(1) );

    }
}