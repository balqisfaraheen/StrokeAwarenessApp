package com.example.strokeawarenessapp;

import android.content.Intent;
import android.os.Bundle;
import android.text.Editable;
import android.text.InputType;
import android.text.TextWatcher;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import com.example.strokeawarenessapp.R;
import com.example.strokeawarenessapp.register;
import com.example.strokeawarenessapp.MainMenu;
import com.google.android.gms.tasks.OnCompleteListener;
import com.google.android.gms.tasks.Task;
import com.google.firebase.auth.AuthResult;
import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.auth.FirebaseUser;

public class Login extends AppCompatActivity {
    TextView RegisterHere, mPasswordTV, mforgotTV;
    Button btnClick1;
    EditText Email, mPasswordET;
    FirebaseAuth mFirebaseAuth;
    private FirebaseAuth.AuthStateListener mAuthStateListener;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);

        mFirebaseAuth = FirebaseAuth.getInstance();
        Email = findViewById(R.id.email);
        //Password = findViewById(R.id.password);
        RegisterHere = findViewById(R.id.registerhere);
        btnClick1 = findViewById(R.id.buttonlogin);

        mPasswordET = findViewById(R.id.PasswordET);
        mPasswordTV = findViewById(R.id.ToggleTV);
        mforgotTV = findViewById(R.id.forgotTV);

        mPasswordTV.setVisibility(View.GONE);
        mPasswordET.setInputType(InputType.TYPE_CLASS_TEXT | InputType.TYPE_TEXT_VARIATION_PASSWORD);


        //check available user
        mAuthStateListener = new FirebaseAuth.AuthStateListener(){
            @Override
            public void onAuthStateChanged(@NonNull FirebaseAuth firebaseAuth){
                FirebaseUser mFirebaseUser = mFirebaseAuth.getCurrentUser();
                if(mFirebaseUser != null ){
                    Toast.makeText(Login.this, "You are logged in", Toast.LENGTH_SHORT).show();
                    Intent i = new Intent(Login.this, MainMenu.class);
                    startActivity(i);
                }
                else{
                    Toast.makeText(Login.this, "Please Login", Toast.LENGTH_SHORT).show();
                }
            }
        };

        //password show/hide
        mPasswordET.addTextChangedListener(new TextWatcher() {
            @Override
            public void beforeTextChanged(CharSequence charSequence, int i, int i1, int i2) {

            }

            @Override
            public void onTextChanged(CharSequence charSequence, int i, int i1, int i2) {
                if(mPasswordET.getText().length() > 0){
                    mPasswordTV.setVisibility(View.VISIBLE);
                }
                else{
                    mPasswordTV.setVisibility(View.GONE);
                }
            }

            @Override
            public void afterTextChanged(Editable editable) {

            }
        });

        mPasswordTV.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if(mPasswordTV.getText() == "SHOW"){
                    mPasswordTV.setText("HIDE");
                    mPasswordET.setInputType(InputType.TYPE_TEXT_VARIATION_VISIBLE_PASSWORD);
                    mPasswordET.setSelection(mPasswordET.length());
                }
                else {
                    mPasswordTV.setText("SHOW");
                    mPasswordET.setInputType(InputType.TYPE_CLASS_TEXT | InputType.TYPE_TEXT_VARIATION_PASSWORD);
                    mPasswordET.setSelection(mPasswordET.length());
                }
            }
        });

        // register button
        btnClick1.setOnClickListener(new View.OnClickListener() {

            @Override
            public void onClick(View view) {
                String email = Email.getText().toString();
                String pwd = mPasswordET.getText().toString();

                if (email.isEmpty()) {
                    Email.setError("Please Enter Email");
                    Email.requestFocus();
                    return;
                }
                else if (pwd.isEmpty()) {
                    mPasswordET.setError("Please Enter Password");
                    mPasswordET.requestFocus();
                    return;
                }

                mFirebaseAuth.signInWithEmailAndPassword(email, pwd).addOnCompleteListener(Login.this, new OnCompleteListener<AuthResult>() {
                    @Override
                    public void onComplete(@NonNull Task<AuthResult> task) {
                        if(task.isSuccessful()) {
                            Intent intToHome = new Intent(Login.this, MainMenu.class);
                            startActivity(intToHome);
                        }
                        else {
                            Toast.makeText(Login.this, "Login Error, Please try again", Toast.LENGTH_SHORT).show();
                        }
                    }
                });
            }
        });

        RegisterHere.setOnClickListener(new View.OnClickListener() {

            @Override
            public void onClick(View view){
                Intent intent = new Intent(Login.this, register.class);
                startActivity(intent);

            }
        });

        mforgotTV.setOnClickListener(new View.OnClickListener() {

            @Override
            public void onClick(View view){
                Intent intent = new Intent(Login.this, forgotpassword.class);
                startActivity(intent);

            }
        });

    }
    @Override
    protected void onStart(){
        super.onStart();
        mFirebaseAuth.addAuthStateListener(mAuthStateListener);
    }
}



