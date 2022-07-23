package com.example.cardiac_recorder;

import static androidx.constraintlayout.helper.widget.MotionEffect.TAG;

import androidx.activity.result.ActivityResult;
import androidx.activity.result.ActivityResultCallback;
import androidx.activity.result.ActivityResultLauncher;
import androidx.activity.result.contract.ActivityResultContract;
import androidx.activity.result.contract.ActivityResultContracts;
import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.app.Activity;
import android.content.Intent;
import android.icu.util.Measure;
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

import com.google.firebase.FirebaseApp;
import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.ValueEventListener;

import java.sql.Time;
import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;
import java.util.GregorianCalendar;
import java.util.HashMap;
import java.util.Map;

public class MainActivity extends AppCompatActivity
{
    TextView txt_test;
    ListView record_listView;
    ArrayList<Measurement> measurement = new ArrayList<>();
    FirebaseDatabase firebaseDatabase;
    DatabaseReference databaseReference;
    private RecyclerView contactsrecview;

    ActivityResultLauncher<Intent>getcontent=registerForActivityResult(new ActivityResultContracts.StartActivityForResult(), new ActivityResultCallback<ActivityResult>()
    {
        @Override
        public void onActivityResult(ActivityResult result)
        {
            if(result.getData()!=null && result.getResultCode()== Activity.RESULT_OK)
            {

                Measurement ms=(Measurement) result.getData().getSerializableExtra("info");

                measurement.add(ms);
                adapter.notifyItemInserted(measurement.size()-1);
                adapter.notifyDataSetChanged();
                databaseReference.child("newest").push().setValue(ms);
            }
        }
    });


    ContactsRecVIewAdapter adapter;

    @Override
    protected void onCreate(Bundle savedInstanceState)
    {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        contactsrecview = findViewById(R.id.contactsrecview);

        databaseReference= FirebaseDatabase.getInstance().getReference();
        
        databaseReference.child("newest").addValueEventListener(new ValueEventListener()
        {
            @Override
            public void onDataChange(@NonNull DataSnapshot snapshot)
            {
                measurement.clear();
                for(DataSnapshot dataSnapshot:snapshot.getChildren())
                {
                    Measurement ms=dataSnapshot.getValue(Measurement.class);
                    measurement.add(ms);
                    adapter.notifyItemInserted(measurement.size()-1);
                }
                adapter.notifyDataSetChanged();
            }

            @Override
            public void onCancelled(@NonNull DatabaseError error)
            {

            }
        });
        adapter= new ContactsRecVIewAdapter(this);
        adapter.setMeasurement(measurement);
//
        contactsrecview.setAdapter(adapter);
        contactsrecview.setLayoutManager(new LinearLayoutManager(this));
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu)
    {
        MenuInflater inflater=getMenuInflater();
        inflater.inflate(R.menu.addbutton_view,menu);
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