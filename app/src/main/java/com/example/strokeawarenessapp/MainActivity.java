package com.example.strokeawarenessapp;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.content.Intent;
import android.os.Bundle;
import android.os.Handler;
import android.content.Intent;
import android.os.Bundle;
import android.os.Handler;

import android.content.Intent;
import android.os.Bundle;
import android.os.Handler;

import com.example.strokeawarenessapp.Login;
import com.example.strokeawarenessapp.R;

public class MainActivity extends AppCompatActivity {

    public static int TIME_OUT = 2000;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        Handler handler = new Handler();
        handler.postDelayed(new Runnable() {
            @Override
            public void run() {
                Intent intent = new Intent(MainActivity.this, Login.class);
                startActivity(intent);
                finish();
            }

        }, TIME_OUT);
    }

}
