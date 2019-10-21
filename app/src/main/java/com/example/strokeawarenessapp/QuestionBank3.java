package com.example.strokeawarenessapp;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.RadioButton;

import com.example.strokeawarenessapp.R;

public class QuestionBank3 extends AppCompatActivity {

    int messageFromBank2;
    RadioButton current, past, former, more, less, not, active;
    Button next;
    int points;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_question_bank3);

        Bundle bundle = getIntent().getExtras();
        messageFromBank2 = bundle.getInt("points",points);

        current = findViewById(R.id.currentRB);
        past = findViewById(R.id.pastRB);
        former = findViewById(R.id.formerRB);
        more = findViewById(R.id.moreRB);
        less = findViewById(R.id.lessRB);
        not = findViewById(R.id.notRB);
        active = findViewById(R.id.activeRB);
        setmNext();
    }

    public void setmNext() {
        next.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                if( current.isSelected()){
                    points=points+3;
                }
                if(past.isSelected()){
                    points=points+4;
                }
                if(more.isSelected()){
                    points=points+4;
                }
                if(not.isSelected()){
                    points=points+4;
                }
                else   if(active.isSelected()){
                    points=points+3;
                }
                Intent intent = new Intent(QuestionBank3.this, QuestionBank4.class);
                intent.putExtra("points", points);
                startActivity(intent);

            }
        });
    }
}
