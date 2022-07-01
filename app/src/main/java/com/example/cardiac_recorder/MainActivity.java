package com.example.cardiac_recorder;

import static androidx.constraintlayout.helper.widget.MotionEffect.TAG;

import androidx.activity.result.ActivityResult;
import androidx.activity.result.ActivityResultCallback;
import androidx.activity.result.ActivityResultLauncher;
import androidx.activity.result.contract.ActivityResultContract;
import androidx.activity.result.contract.ActivityResultContracts;
import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import android.app.Activity;
import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.util.Log;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.view.View;
import android.widget.AdapterView;
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
    Measurement measurement=new Measurement();
    ActivityResultLauncher<Intent>getcontent=registerForActivityResult(new ActivityResultContracts.StartActivityForResult(), new ActivityResultCallback<ActivityResult>()
    {
        @Override
        public void onActivityResult(ActivityResult result)
        {
            if(result.getData()!=null && result.getResultCode()== Activity.RESULT_OK)
            {
                Log.e(TAG, "onActivityResult: Yes");

                measurement=(Measurement) result.getData().getSerializableExtra("info");

                if(measurement==null)
                {
                    Log.e(TAG, "onActivityResult: Its Null");

                }
                Log.e(TAG, "onActivityResult: " + measurement.getTime());
            }
        }
    });

    @Override
    protected void onCreate(Bundle savedInstanceState)
    {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);


    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu)
    {
        MenuInflater inflater=getMenuInflater();
        //inflater.inflate(R.menu.addbutton_view,menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(@NonNull MenuItem item)
    {

        Intent intent=new Intent(MainActivity.this, showActivity.class);
        intent.putExtra("add",true);
        getcontent.launch(intent);
        return true;
    }
}