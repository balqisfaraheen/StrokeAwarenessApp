package com.example.strokeawarenessapp;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;

import com.example.strokeawarenessapp.R;

public class quiz extends AppCompatActivity {

    private QuestionLibrary mQuestionLibrary = new QuestionLibrary();
    private TextView mScoreView;
    private TextView mQuestionView;
    private Button mButtonChoice1;
    private Button mButtonChoice2;
    private Button mButtonChoice3;

    private String mAnswer;
    private int mScore=0;
    private int mQuestionNumber = 0;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_quiz);

        mScoreView = findViewById(R.id.scoreTV);
        mQuestionView = findViewById(R.id.questionTV);
        mButtonChoice1 = findViewById(R.id.choice1TV);
        mButtonChoice2 = findViewById(R.id.choice2TV);
        mButtonChoice3 = findViewById(R.id.choice3TV);

        updateQuestion();

        mButtonChoice1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                if(mButtonChoice1.getText()== mAnswer){
                    mScore = mScore+1;
                    updateScore(mScore);
                    updateQuestion();

                    Toast.makeText(quiz.this, "correct", Toast.LENGTH_SHORT).show();
                }
                else {
                    Toast.makeText(quiz.this, "wrong", Toast.LENGTH_SHORT).show();
                    updateQuestion();
                }
            }
        });
        mButtonChoice2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                if(mButtonChoice2.getText()== mAnswer){
                    mScore = mScore+1;
                    updateScore(mScore);
                    updateQuestion();

                    Toast.makeText(quiz.this, "correct", Toast.LENGTH_SHORT).show();
                }
                else {
                    Toast.makeText(quiz.this, "wrong", Toast.LENGTH_SHORT).show();
                    updateQuestion();
                }
            }
        });
        mButtonChoice3.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                if(mButtonChoice3.getText()== mAnswer){
                    mScore = mScore+1;
                    updateScore(mScore);
                    updateQuestion();

                    Toast.makeText(quiz.this, "correct", Toast.LENGTH_SHORT).show();
                }
                else {
                    Toast.makeText(quiz.this, "wrong", Toast.LENGTH_SHORT).show();
                    updateQuestion();
                }
            }
        });



    }

    private void updateQuestion(){
        mQuestionView.setText(mQuestionLibrary.getQuestion(mQuestionNumber));
        mButtonChoice1.setText(mQuestionLibrary.getChoice1(mQuestionNumber));
        mButtonChoice2.setText(mQuestionLibrary.getChoice2(mQuestionNumber));
        mButtonChoice3.setText(mQuestionLibrary.getChoice3(mQuestionNumber));

        mAnswer = mQuestionLibrary.getCorrectAnswer(mQuestionNumber);
        mQuestionNumber++;
    }

    private void updateScore(int point) {
        mScoreView.setText("" + mScore);
    }
}
