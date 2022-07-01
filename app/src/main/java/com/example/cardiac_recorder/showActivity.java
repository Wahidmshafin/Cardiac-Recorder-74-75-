package com.example.cardiac_recorder;

import androidx.appcompat.app.AppCompatActivity;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

public class showActivity extends AppCompatActivity {

    EditText ea_time,ea_date, ea_systolic, ea_diastolic, ea_rate, ea_comment;
    Button btn_add;

    public void init()
    {
        ea_time=findViewById(R.id.sa_time);
        ea_date=findViewById(R.id.sa_date);
        ea_systolic=findViewById(R.id.sa_et_systolic);
        ea_diastolic=findViewById(R.id.sa_et_diatolic);
        ea_rate=findViewById(R.id.sa_et_rate);
        ea_comment=findViewById(R.id.sa_et_comment);
    }

    @Override
    protected void onCreate(Bundle savedInstanceState)
    {
        init();
        Intent intent=getIntent();
        boolean add= ((Intent) intent).getBooleanExtra("add",false);
        if(add==true)
        {
            btn_add.setText("ADD");
            btn_add.setOnClickListener(new View.OnClickListener()
            {
                @Override
                public void onClick(View view)
                {
                    Measurement measurement=new Measurement(ea_date.getText().toString(),ea_time.getText().toString(),
                            Integer.getInteger(ea_systolic.getText().toString()),Integer.getInteger(ea_diastolic.getText().toString())
                            ,Integer.getInteger(ea_rate.getText().toString()),ea_systolic.getText().toString());

                    Intent backIntent=new Intent();
                    backIntent.putExtra("info",measurement);
                    setResult(Activity.RESULT_OK,backIntent);
                }
            });
        }
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_show);
    }

}