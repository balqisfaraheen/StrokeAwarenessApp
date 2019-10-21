package com.example.strokeawarenessapp;

public class QuestionLibrary {

    private String mQuestions [] = {
            "Is heart attack is same as stroke?",
            "What is hemorrhagic stroke?",
            "Where stroke can occur?",
            "What is acronym for stroke symptom?",
            "What can we do when someone attack by stroke?",
    };

    private String mChoices [] [] = {
            {"YES", "NO" , "NOT SURE"},
            {"Blood obstructed" , "blood vessel ruptures", "blood clot"},
            {"heart" , "brain" , "lung"} ,
            { "FEST" , "FIST" , "FAST"} ,
            {"calm him down" , "call police" , "call ambulance"}
    };

    private String mCorrectanswer [] = {"YES", "blood vessel rupture", "brain" , "FAST", "call ambulance"};


    public String getQuestion (int a) {
        String question = mQuestions[a];
        return question;
    }

    public String getChoice1(int a) {
        String choice0 = mChoices[a][0];
        return choice0;
    }

    public String getChoice2 (int a) {
        String choice1 = mChoices[a][1];
        return choice1;
    }

    public String getChoice3 (int a) {
        String choice2 = mChoices[a][2];
        return choice2;
    }

    public String getCorrectAnswer (int a) {
        String answer = mCorrectanswer[a];
        return answer;
    }


}
