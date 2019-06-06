package com.example.loginregisterapp;

import android.support.annotation.NonNull;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import com.google.android.gms.tasks.OnCompleteListener;
import com.google.android.gms.tasks.Task;
import com.google.firebase.auth.AuthResult;
import com.google.firebase.auth.FirebaseAuth;

public class Main2Activity extends AppCompatActivity implements View.OnClickListener {
    private FirebaseAuth mAuth;
    EditText Username, Password;
    Button buttonRegister;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main2);
        // Initialize Firebase Auth
        mAuth = FirebaseAuth.getInstance();
        Username = (EditText) findViewById(R.id.etusername);
        Password = (EditText) findViewById(R.id.etpassword);
        buttonRegister = (Button) findViewById(R.id.ButtonRegister);
    }

    @Override
    public void onClick(View v) {
        switch (v.getId()) {
            case R.id.ButtonRegister:
                String email = Username.getText().toString().trim();
                String password = Password.getText().toString().trim();

                if (email.isEmpty()) {

                    Toast.makeText(Main2Activity.this, "Please Enter Email", Toast.LENGTH_LONG).show();
                } else if (password.isEmpty()) {
                    Toast.makeText(Main2Activity.this, "Please Enter password", Toast.LENGTH_LONG).show();
                } else {
                    //we will register our user

                    mAuth.createUserWithEmailAndPassword(email, password).addOnCompleteListener(this, new OnCompleteListener<AuthResult>() {
                        @Override
                        public void onComplete(@NonNull Task<AuthResult> task) {
                            if (task.isSuccessful()) {

                                Toast.makeText(Main2Activity.this, "User is Successfully Registered", Toast.LENGTH_LONG).show();
                            }

                        }
                    });

                }
                //startActivity(new Intent(this,RegisterActivity.class));
                break;
        }
    }
}
