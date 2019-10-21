package com.example.strokeawarenessapp;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;

import android.content.Intent;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.ImageView;

import com.google.firebase.auth.FirebaseAuth;

public class MainMenu extends AppCompatActivity {

    ImageView mlocation, mhistory, mcalculator, mquiz, minfo, mprofile;
    FirebaseAuth firebaseAuth;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main_menu);

        firebaseAuth = FirebaseAuth.getInstance();
        android.widget.Toast.makeText(MainMenu.this, "Firebase connection Success", android.widget.Toast.LENGTH_LONG).show();

        mlocation = findViewById(R.id.locationIV);
        mhistory = findViewById(R.id.historyIV);
        mcalculator = findViewById(R.id.calculatorIV);
        mquiz = findViewById(R.id.quizIV);
        mprofile = findViewById(R.id.profileIV);
        minfo = findViewById(R.id.informationIV);

       // Toolbar toolbar = findViewById(R.id.toolbar);
        //setSupportActionBar(toolbar);


        mlocation.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(MainMenu.this, menulocation.class);
                startActivity(intent);
            }
        });

        mhistory.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(MainMenu.this, menuhistory.class);
                startActivity(intent);
            }
        });

        mcalculator.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(MainMenu.this, menuCalculator.class);
                startActivity(intent);
            }
        });

        mquiz.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(MainMenu.this, simplequiz.class);
                startActivity(intent);
            }
        });


        minfo.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(MainMenu.this, menuinfo.class);
                startActivity(intent);
            }
        });


        mprofile.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(MainMenu.this, menuprofile.class);
                startActivity(intent);
            }
        });
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        getMenuInflater().inflate(R.menu.menu_layout,menu);
        return super.onCreateOptionsMenu(menu);


    }

    @Override
    public boolean onOptionsItemSelected(@NonNull MenuItem item) {
        if(item.getItemId() ==R.id.signOutMenuItd){

            FirebaseAuth.getInstance().signOut();
            finish();
            Intent intent = new Intent(getApplicationContext(),Login.class);
            startActivity(intent);
        }

        if(item.getItemId() ==R.id.homeItem){

            Intent intent = new Intent(getApplicationContext(), MainMenu.class);
            startActivity(intent);
        }
        return super.onOptionsItemSelected(item);
    }


}
