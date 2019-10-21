package com.example.strokeawarenessapp;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.TextView;

import com.google.firebase.auth.FirebaseAuth;

public class menuinfo extends AppCompatActivity {

    TextView textViewtype, textViewtreatment, textViewsymptom, textViewfAQ, textViewfAST, quizz;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_menuinfo);

         textViewtype = findViewById(R.id.textViewtype);
         textViewtreatment = findViewById(R.id.textViewTreatment);
         textViewsymptom = findViewById(R.id.textViewSymptom);
         textViewfAQ = findViewById(R.id.textViewFAQ);
         textViewfAST = findViewById(R.id.textViewFAST);
        quizz = findViewById(R.id.VideoTV);

        textViewtype.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(menuinfo.this, menulocation.class);
                startActivity(intent);
            }
        });

        textViewtreatment.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(menuinfo.this, infoTreatment.class);
                startActivity(intent);
            }
        });

        textViewsymptom.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(menuinfo.this, infoSymptom.class);
                startActivity(intent);
            }
        });

        textViewfAQ.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(menuinfo.this, infoFaq.class);
                startActivity(intent);
            }
        });

        textViewfAST.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(menuinfo.this, infoFast.class);
                startActivity(intent);
            }
        });

        quizz.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(menuinfo.this, simplequiz.class);
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
