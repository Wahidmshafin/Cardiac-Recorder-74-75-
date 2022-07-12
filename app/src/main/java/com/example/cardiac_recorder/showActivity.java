package com.example.cardiac_recorder;
import androidx.appcompat.app.AppCompatActivity;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.LinearLayout;

public class showActivity extends AppCompatActivity
{

    EditText ea_time,ea_date, ea_systolic, ea_diastolic, ea_rate, ea_comment;
    //Button btn_add;


    Button btn_add,btn_editable;
    Intent intent;
    int position;
    String TAG="Error";
    public void init()
    {
        ea_time=findViewById(R.id.sa_time);
        ea_date=findViewById(R.id.sa_date);
        ea_systolic=findViewById(R.id.sa_et_systolic);
        ea_diastolic=findViewById(R.id.sa_et_diatolic);
        ea_rate=findViewById(R.id.sa_et_rate);
        ea_comment=findViewById(R.id.sa_et_comment);
        btn_add=findViewById(R.id.sa_btn);
        btn_editable=findViewById(R.id.sa_notEditable);
    }

    @Override
    protected void onCreate(Bundle savedInstanceState)
    {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_show);
        init();
        intent=getIntent();
        position=intent.getIntExtra("position",0);
        //position=0;
        boolean add=intent.getBooleanExtra("add",false);
        if(add)
        {
            btn_add.setText("ADD");
            btn_add.setOnClickListener(new View.OnClickListener()
            {
                @Override
                public void onClick(View view)
                {
                    Measurement measurement=new Measurement(ea_date.getText().toString(),ea_time.getText().toString(),
                            Integer.parseInt(ea_systolic.getText().toString()),Integer.parseInt(ea_diastolic.getText().toString())
                            ,Integer.parseInt(ea_rate.getText().toString()),ea_comment.getText().toString());

                    intent.putExtra("info",measurement);
                    setResult(Activity.RESULT_OK,intent);
                    finish();
                }
            });
        }
        else

        {
            btn_add.setText("Update");
            btn_editable.setVisibility(View.VISIBLE);
            btn_add.setText("Edit");
            Measurement measurement=(Measurement) intent.getSerializableExtra("info");
            ea_time.setText(measurement.getTime());
            ea_date.setText(measurement.getDate());
            ea_systolic.setText(Integer.toString(measurement.getSystolicPressure()));
            ea_diastolic.setText(Integer.toString(measurement.getDiastolicPressure()));
            ea_rate.setText(Integer.toString(measurement.getHeartrate()));
            ea_comment.setText(measurement.getComment());
            btn_add.setOnClickListener(new View.OnClickListener()
            {
                @Override
                public void onClick(View v)
                {
                    if(btn_add.getText().equals("Edit"))
                    {
                        btn_add.setText("Save");
                        btn_editable.setVisibility(View.GONE);
                    }
                    else
                    {
                        btn_add.setText("Edit");
                        btn_editable.setVisibility(View.VISIBLE);
                    }
                }
            });

        }

    }

    @Override
    protected void onDestroy()
    {
        super.onDestroy();
        Measurement measurement=new Measurement(ea_date.getText().toString(),ea_time.getText().toString(),
                Integer.parseInt(ea_systolic.getText().toString()),Integer.parseInt(ea_diastolic.getText().toString())
                ,Integer.parseInt(ea_rate.getText().toString()),ea_comment.getText().toString());
        Log.e(TAG, "onDestroy: Pressed");
        intent.putExtra("info",measurement);
        intent.putExtra("position",position);
        setResult(Activity.RESULT_OK,intent);
        finish();
    }


}