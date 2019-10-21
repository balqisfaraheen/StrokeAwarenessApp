package com.example.strokeawarenessapp;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.RadioButton;

import com.example.strokeawarenessapp.R;

public class QuestionBank2 extends AppCompatActivity {

    int messageFromBank1;
    RadioButton renal, heart, arterial, blood, ischemic;
    Button next;
    int points;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_question_bank2);

        Bundle extras = getIntent().getExtras();
        messageFromBank1 = extras.getInt("points",points);

        //Bundle bundle = getIntent().getExtras();
        //messageFromBank1 = bundle.getInt("points", points);

        renal = findViewById(R.id.renalRB);
        heart = findViewById(R.id.heartRB);
        arterial = findViewById(R.id.arterialRB);
        blood = findViewById(R.id.bloodRB);
        ischemic = findViewById(R.id.ischemicRB);

        setmNext();
    }

    public void setmNext() {
        next.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                if(renal.isSelected()){
                    points=points+3;
                }
                if(heart.isSelected()){
                    points=points+4;
                }
                if(arterial.isSelected()){
                    points=points+4;
                }
                if(blood.isSelected()){
                    points=points+4;
                }
                else   if(ischemic.isSelected()){
                    points=points+3;
                }
                Intent intent = new Intent(QuestionBank2.this, QuestionBank3.class);
                intent.putExtra("points", points);
                startActivity(intent);

            }
        });
    }
}
