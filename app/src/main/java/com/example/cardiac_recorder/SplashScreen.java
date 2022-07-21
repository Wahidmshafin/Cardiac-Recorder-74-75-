package com.example.cardiac_recorder;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.widget.ProgressBar;

import java.util.Timer;
import java.util.TimerTask;

public class SplashScreen extends AppCompatActivity
{
    ProgressBar progressBar;
    Timer timer;
    int i=0;
    @Override
    protected void onCreate(Bundle savedInstanceState)
    {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_splash_screen);
        progressBar=findViewById(R.id.splash_progress);
        timer=new Timer();
        timer.schedule(new TimerTask()
        {
            @Override
            public void run()
            {
                if(i<100)
                {
                    runOnUiThread(new Runnable()
                    {
                        @Override
                        public void run()
                        {

                        }
                    });
                    progressBar.setProgress(i);
                    i++;
                }
                else
                {
                    timer.cancel();
                    Intent intent=new Intent(SplashScreen.this,MainActivity.class);
                    startActivity(intent);
                    finish();
                }
            }
        },0, 50);

    }
}