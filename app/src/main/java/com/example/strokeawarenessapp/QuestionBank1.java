package com.example.strokeawarenessapp;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.text.Editable;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.RadioButton;

public class QuestionBank1 extends AppCompatActivity {
    // public static final String EXTRA_NUMBER = "com.example.strokeawareness.EXTRA_NUMBER";

    RadioButton male, female, school, diploma, university;
    EditText age;
    Button next;

    int points = 0;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_question_bank1);

        next = findViewById(R.id.nextBT);
        male = findViewById(R.id.maleRB);
        female = findViewById(R.id.femaleRB);
        school = findViewById(R.id.schoolRB);
        diploma = findViewById(R.id.diplomaRB);
        university = findViewById(R.id.universityRB);

        setmNext();
    }

    public void setmNext() {
        next.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                // age = findViewById(R.id.ageET);
                // String age1 = new age.getText();
                // String age1 = age.getText().toString();
                // int umur = Integer.parseInt(age1);

                EditText age = findViewById(R.id.ageET);
                int ageInt =Integer.parseInt(age.getText().toString());

                if(ageInt>20){
                    points=(ageInt-20); }

                if(male.isSelected()){
                    points=points+3;
                }
                if(school.isSelected()){
                    points=points+4;
                }
                else   if(diploma.isSelected()){
                    points=points+3;
                }



                Intent intent = new Intent(QuestionBank1.this, QuestionBank2.class);
                // intent.putExtra("points", points);
                intent.putExtra("points", points);
                startActivity(intent);


            }
        });
    }
}
