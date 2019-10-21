package com.example.strokeawarenessapp;

import android.app.ProgressDialog;
import android.content.Intent;
import android.os.Bundle;
import android.text.Editable;
import android.text.InputType;
import android.text.TextUtils;
import android.text.TextWatcher;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;

import com.example.strokeawarenessapp.Login;
import com.example.strokeawarenessapp.R;
import com.example.strokeawarenessapp.Users;
import com.google.android.gms.tasks.OnCompleteListener;
import com.google.android.gms.tasks.Task;
import com.google.firebase.auth.AuthResult;
import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;


public class register extends AppCompatActivity implements View.OnClickListener{
    private Button buttonRegister;
    private TextView textViewSignIn, mPasswordTV;
    private EditText  editTextEmail, mPasswordET, fullName, note;
    private ProgressDialog progressDialog;
    private FirebaseAuth firebaseAuth;
    private DatabaseReference mDatabase;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_register);

        firebaseAuth = FirebaseAuth.getInstance();
        progressDialog = new ProgressDialog(this);
        mDatabase = FirebaseDatabase.getInstance().getReference("Users");

        buttonRegister =  findViewById(R.id.button3);
        textViewSignIn = findViewById(R.id.login);

        //editTextPassword = findViewById(R.id.password);
        fullName = findViewById(R.id.fullname);
        editTextEmail = findViewById(R.id.email);
        mPasswordET = findViewById(R.id.PasswordET);
        mPasswordTV = findViewById(R.id.ToggleTV);
        note = findViewById(R.id.NoteToMyself);

        buttonRegister.setOnClickListener(this);
        textViewSignIn.setOnClickListener(this);


        mPasswordTV.setVisibility(View.GONE);
        mPasswordET.setInputType(InputType.TYPE_CLASS_TEXT | InputType.TYPE_TEXT_VARIATION_PASSWORD);
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

    }

    private void registerUser() {
        final String email = editTextEmail.getText().toString().trim();
        final String password = mPasswordET.getText().toString().trim();


        if (TextUtils.isEmpty(email)) {
            Toast.makeText(this, "Please enter email", Toast.LENGTH_SHORT).show();
            return;
        }
        if (TextUtils.isEmpty(password)) {
            Toast.makeText(this, "Please enter password", Toast.LENGTH_SHORT).show();
            return;
        }


        progressDialog.setMessage("Registering User..");
        progressDialog.show();

        firebaseAuth.createUserWithEmailAndPassword(email, password)
                .addOnCompleteListener(this, new OnCompleteListener<AuthResult>() {
                    @Override
                    public void onComplete(@NonNull Task<AuthResult> task) {
                        if (task.isSuccessful()) {
                            String noteToSelf = note.getText().toString();
                            String name = fullName.getText().toString();

                            Users information = new Users(
                                    name,
                                    email,
                                    noteToSelf

                            );

                            FirebaseDatabase.getInstance().getReference("Users")
                                    .child(FirebaseAuth.getInstance().getCurrentUser().getUid())
                                    .setValue(information).addOnCompleteListener(new OnCompleteListener<Void>() {
                                @Override
                                public void onComplete(@NonNull Task<Void> task) {
                                    Toast.makeText(register.this, "Done", Toast.LENGTH_SHORT).show();
                                    Toast.makeText(register.this, "Registered Successfully", Toast.LENGTH_SHORT).show();
                                    Intent intToHome = new Intent(register.this, Login.class);
                                    startActivity(intToHome);
                                    progressDialog.dismiss();
                                }
                            });

                            String userID = firebaseAuth.getCurrentUser().getUid();
                            Users newUser = new Users(userID, name, email, noteToSelf);

                            mDatabase.child("Users").child(userID).setValue(newUser, new DatabaseReference.CompletionListener() {

                                @Override
                                public void onComplete(@Nullable DatabaseError databaseError, @NonNull DatabaseReference databaseReference) {
                                    Toast.makeText(register.this, "Done", Toast.LENGTH_SHORT).show();
                                    Toast.makeText(register.this, "Registered Successfully", Toast.LENGTH_SHORT).show();
                                    Intent intToHome = new Intent(register.this, Login.class);
                                    startActivity(intToHome);
                                    progressDialog.dismiss();
                                }
                            });

                        } else {
                            Toast.makeText(register.this, task.getException().getMessage(), Toast.LENGTH_SHORT).show();
                            progressDialog.dismiss();
                        }
                    }
                });
    }

    @Override
    public void onClick(View view) {
        if(view == buttonRegister){
            registerUser();
        }
        if (view == textViewSignIn){
            Intent intToHome = new Intent(register.this, Login.class);
            startActivity(intToHome);

        }

    }
}

