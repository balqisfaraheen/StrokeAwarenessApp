package com.example.strokeawarenessapp;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ProgressBar;
import android.widget.Toast;

import com.example.strokeawarenessapp.Login;
import com.example.strokeawarenessapp.R;
import com.google.android.gms.tasks.OnCompleteListener;
import com.google.android.gms.tasks.Task;
import com.google.firebase.auth.FirebaseAuth;

public class forgotpassword extends AppCompatActivity {

    ProgressBar progressBar;
    EditText userEmail;
    Button userPass, signIn;

    FirebaseAuth firebaseAuth;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_forgotpassword);

        progressBar = findViewById(R.id.progressBar1);
        userEmail = findViewById(R.id.userEmailET);
        userPass = findViewById(R.id.sendPasswordBT);
        signIn = findViewById(R.id.signInBT);

        firebaseAuth = FirebaseAuth.getInstance();

        userPass.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                progressBar.setVisibility(View.VISIBLE);
                firebaseAuth.sendPasswordResetEmail(userEmail.getText().toString())
                        .addOnCompleteListener(new OnCompleteListener<Void>() {
                            @Override
                            public void onComplete(@NonNull Task<Void> task) {
                                progressBar.setVisibility(View.GONE);
                                if(task.isSuccessful()){
                                    Toast.makeText(forgotpassword.this, "Password send to your email", Toast.LENGTH_LONG).show();
                                } else {
                                    Toast.makeText(forgotpassword.this, task.getException().getMessage(), Toast.LENGTH_LONG).show();
                                }

                            }
                        });
            }
        });

        signIn.setOnClickListener(new View.OnClickListener() {

            @Override
            public void onClick(View view){
                Intent intent = new Intent(forgotpassword.this, Login.class);
                startActivity(intent);

            }
        });



    }
}
