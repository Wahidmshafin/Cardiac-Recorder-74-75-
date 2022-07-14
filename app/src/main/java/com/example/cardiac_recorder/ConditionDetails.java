package com.example.cardiac_recorder;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.ValueEventListener;

public class ConditionDetails extends AppCompatActivity {
    Button button_delete, button_edit;
    private DatabaseReference reference;
    String key;
    Button btn_add, btn_editable;
    Intent intent;
    int position;
    String TAG = "Error";
    EditText date, time, sys_pr, dias_pr, hrt_rate, comment;
    private Context context;

    public void init() {
        time = findViewById(R.id.sa_time);
        date = findViewById(R.id.sa_date);
        sys_pr = findViewById(R.id.sa_et_systolic);
        dias_pr = findViewById(R.id.sa_et_diatolic);
        hrt_rate = findViewById(R.id.sa_et_rate);
        comment = findViewById(R.id.sa_et_comment);
        button_delete = findViewById(R.id.button_delete);
        button_edit = findViewById(R.id.button_edit);
        btn_add = findViewById(R.id.sa_btn);
        btn_editable = findViewById(R.id.sa_notEditable);
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_condition_details);

        init();
        intent = getIntent();
        position = intent.getIntExtra("position", 0);
        //position=0;
        boolean add = intent.getBooleanExtra("add", false);
        if (add) {
            button_edit.setText("ADD");
            button_edit.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View view) {
                    Measurement measurement = new Measurement(date.getText().toString(), time.getText().toString(),
                            Integer.parseInt(sys_pr.getText().toString()), Integer.parseInt(dias_pr.getText().toString())
                            , Integer.parseInt(hrt_rate.getText().toString()), comment.getText().toString());

                    intent.putExtra("info", measurement);
                    setResult(Activity.RESULT_OK, intent);
                    finish();
                }
            });
        } else {
            button_edit.setText("Update");
            btn_editable.setVisibility(View.VISIBLE);
            button_edit.setText("Edit");
            Measurement measurement = (Measurement) intent.getSerializableExtra("info");
            time.setText(measurement.getTime());
            date.setText(measurement.getDate());
            sys_pr.setText(Integer.toString(measurement.getSystolicPressure()));
            dias_pr.setText(Integer.toString(measurement.getDiastolicPressure()));
            hrt_rate.setText(Integer.toString(measurement.getHeartrate()));
            comment.setText(measurement.getComment());
            button_edit.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    if (button_edit.getText().equals("Edit")) {
                        button_edit.setText("Save");
                        btn_editable.setVisibility(View.GONE);
                    } else {
                        String cdate, ctime, ccomt;
                        Integer csyspr, cdiaspr, chrt;
                        cdate = date.getText().toString();
                        ctime = time.getText().toString();
                        csyspr = Integer.valueOf(sys_pr.getText().toString());
                        cdiaspr = Integer.valueOf(dias_pr.getText().toString());
                        chrt = Integer.valueOf(hrt_rate.getText().toString());
                        ccomt = comment.getText().toString();

                        Measurement measurement = new Measurement(cdate, ctime, csyspr, cdiaspr, chrt, ccomt);
                        reference.child(key).setValue(measurement);
                        Intent newintent = new Intent(ConditionDetails.this, MainActivity.class);
                        startActivity(newintent);

                    }
                }
            });


            reference = FirebaseDatabase.getInstance().getReference("newest");
            reference.addValueEventListener(new ValueEventListener() {
                @Override
                public void onDataChange(@NonNull DataSnapshot snapshot) {
                    for (DataSnapshot postSnapshot : snapshot.getChildren()) {
                        Measurement mthis = postSnapshot.getValue(Measurement.class);
                        if (measurement.equals(mthis)) {
                            key = postSnapshot.getKey();
                        }
                    }
                }

                @Override
                public void onCancelled(@NonNull DatabaseError error) {

                }
            });
            button_delete.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    reference.child(key).removeValue();
                    Intent newintent = new Intent(ConditionDetails.this, MainActivity.class);
                    startActivity(newintent);
                }
            });

        }
    }
}