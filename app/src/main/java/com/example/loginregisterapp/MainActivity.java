package com.example.loginregisterapp;

import android.content.Intent;
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
import com.google.firebase.auth.FirebaseUser;

public class MainActivity extends AppCompatActivity implements View.OnClickListener{
 EditText Username, Password;
 Button buttonLogin, buttonRegister;
    private FirebaseAuth myauth;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        // Initialize Firebase Auth
        myauth = FirebaseAuth.getInstance();
        Username = (EditText) findViewById(R.id.etusername);
        Password = (EditText) findViewById(R.id.etpassword);
        buttonLogin = (Button) findViewById(R.id.ButtonLogin);
        buttonRegister = (Button) findViewById(R.id.ButtonRegister);
        buttonRegister.setOnClickListener(this);
        buttonLogin.setOnClickListener(this);
    }


    @Override
    public void onClick(View v){
        switch (v.getId()){
            case R.id.ButtonRegister:
               /*String email= Username.getText().toString().trim();
               String password= Password.getText().toString().trim();
                if(email.isEmpty()){

                   Toast.makeText(MainActivity.this, "Please Enter Email",Toast.LENGTH_LONG).show();
               }
               else if (password.isEmpty()){
                   Toast.makeText(MainActivity.this, "Please Enter password",Toast.LENGTH_LONG).show();
               }

               else {
                   //we will register our user

                   mAuth.createUserWithEmailAndPassword(email,password).addOnCompleteListener(this, new OnCompleteListener<AuthResult>() {
                       @Override
                       public void onComplete(@NonNull Task<AuthResult> task) {
                           if (task.isSuccessful()){

                               Toast.makeText(MainActivity.this, "User is Successfully Registered",Toast.LENGTH_LONG).show();
                           }

                       }
                   });

               }*/
                startActivity(new Intent(this,Main2Activity.class));
               break;
            case R.id.ButtonLogin:
                String email= Username.getText().toString().trim();
                String password= Password.getText().toString().trim();
                if(email.isEmpty()){

                    Toast.makeText(MainActivity.this, "Please Enter Email",Toast.LENGTH_LONG).show();
                }
                else if (password.isEmpty()){
                    Toast.makeText(MainActivity.this, "Please Enter password",Toast.LENGTH_LONG).show();
                }

                else {

                    myauth.signInWithEmailAndPassword(email,password).addOnCompleteListener(this, new OnCompleteListener<AuthResult>() {
                        @Override
                        public void onComplete(@NonNull Task<AuthResult> task) {

                            if (task.isSuccessful()){

                                Intent gotom3= new Intent(MainActivity.this,Main3Activity.class);
                                startActivity(gotom3);
                            }

                        }
                    });

                }

                //startActivity(new Intent(this, Main2Activity.class));
                break;
        }
    }
}
