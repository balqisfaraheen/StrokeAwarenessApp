package com.example.strokeawarenessapp;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

import androidx.appcompat.app.AppCompatActivity;


import java.text.DateFormat;
import java.util.Calendar;

public class ResultRisk extends AppCompatActivity {

    Double messageFromBank4;
    TextView totalRisk, category, description;
    int risk;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_result_risk);


        totalRisk = findViewById(R.id.riskTV);
        category = findViewById(R.id.categoryTV);
        description = findViewById(R.id.descriptionTV);


        // Bundle bundle = getIntent().getExtras();
        // messageFromBank4 = bundle.getInt("risk",risk);
        // totalRisk.setText(messageFromBank4);

        Bundle bundle = getIntent().getExtras();
        messageFromBank4 = bundle.getDouble("risk",risk);
        String finalRisk= new Double(risk).toString();
        totalRisk.setText(finalRisk);

        Calendar calendar = Calendar.getInstance();
        String currentDate = DateFormat.getDateInstance().format(calendar.getTime());

        TextView textViewDate = findViewById(R.id.calendarTV);
        textViewDate.setText(currentDate);

        category();
    }

    private void category() {

        if(risk<=20){
            category.setText("Very Low Risk");
            description.setText("You are good in maintaing healthy lifestyle");
        }
        else if(risk<=40){
            category.setText("Low Risk");
            description.setText("Keep practicing what you have done");
        }
        else if(risk<=60){
            category.setText("Average");
            description.setText("You are in the middle of having high or low risk");
        }
        else if(risk<=80){
            category.setText("High Risk");
            description.setText("Try to change your bad habit of drinking or smoking");
        }
        else if (risk>=81){
            category.setText("Very High Risk");
            description.setText("You have to plan on how to lower your stroke risk");
        }


    }

}
