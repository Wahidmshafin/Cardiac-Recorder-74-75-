package com.example.cardiac_recorder;
import androidx.appcompat.app.AppCompatActivity;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

public class showActivity extends AppCompatActivity
{

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
        btn_add=findViewById(R.id.sa_btn);
    }

    @Override
    protected void onCreate(Bundle savedInstanceState)
    {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_show);
        init();
        Intent intent=getIntent();
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

    }
}