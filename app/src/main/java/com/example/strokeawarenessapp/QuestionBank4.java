package com.example.strokeawarenessapp;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.RadioButton;

import com.example.strokeawarenessapp.R;

public class QuestionBank4 extends AppCompatActivity {

    int messageFromBank3;
    RadioButton critical, cry, fearful;
    Button calculate;
    int points;
    int risk;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_question_bank4);

        Bundle bundle = getIntent().getExtras();
        messageFromBank3 = bundle.getInt("points",points);

        critical = findViewById(R.id.criticalRB);
        cry = findViewById(R.id.cryRB);
        fearful = findViewById(R.id.fearfulRB);
        calculate = findViewById(R.id.calculateBT);
        setmNext();
    }

    public void setmNext() {
        calculate.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                if( critical.isSelected()){
                    points=points+4;
                }
                if(cry.isSelected()){
                    points=points+4;
                }
                else if(fearful.isSelected()){
                    points=points+3;
                }

                calculateRisk();

            }

            private void calculateRisk() {

                //Risk=1-[0.99982]exp(30/10)
                // To make it into percentage *100

                int count1 = points/10 ;
                double count2 = Math.exp(count1);
                double count3 = Math.pow(0.99982, count2);
                double count4 = 1-count3 ;
                double risk = count4*100;

                Intent intent = new Intent(QuestionBank4.this, ResultRisk.class);
                intent.putExtra("risk", risk);
                startActivity(intent);
            }
        });
    }

}
