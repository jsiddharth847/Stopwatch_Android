package com.example.my_stopwatch;

import androidx.appcompat.app.AppCompatActivity;
import android.os.Bundle;
import android.os.Handler;
import android.view.View;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {

    private int second = 0;
    private boolean running;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        startTimer();
    }

    public void onStart(View view){
       running = true;
    }

    public void onPause(View view){
        running = false;
    }


    public void onReset(View view){
        running = false;
        second = 0;

    }
    private void startTimer(){
        TextView timer = findViewById(R.id.timer);
        Handler handler = new Handler();
        handler.post(new Runnable() {
            @Override
            public void run() {
                int hrs = second/3600;
                int mins = (second%3600)/60;
                int sec = second%60;
                String time = String.format("%02d:%02d:%02d",hrs,mins,sec);
                timer.setText(time);
                if (running){
                    second++;
                }
                handler.postDelayed(this,0);
            }
        });
    }
}