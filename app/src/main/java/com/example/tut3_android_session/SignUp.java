package com.example.tut3_android_session;

import android.content.Intent;
import android.os.Bundle;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;

public class SignUp extends AppCompatActivity {
    private EditText fullName;
    private EditText email;
    private EditText password;
    private TextView signIn;
    private Button signUp ;
    private Bundle bun;


    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.sign_up);
        initView();
        signUp.setOnClickListener(clickSignUp ->{
                if(checkCondition()){
                    Toast.makeText(SignUp.this,"Sign Up Success",Toast.LENGTH_SHORT).show();
                }
        });
        signIn.setOnClickListener(clickSignIn ->{

                Intent intent = new Intent(SignUp.this,LogInEx2.class);
               bun.putString("email", email.getText().toString());
               bun.putString("pass", password.getText().toString());
               intent.putExtra("in4",bun);
               startActivity(intent);

        });
    }
    void initView(){
        fullName = (EditText)findViewById(R.id.full_name_input);
        email = (EditText)findViewById(R.id.sign_up_email_input);
        password = (EditText)findViewById(R.id.sign_up_password_input);
        signIn = (TextView)findViewById(R.id.sign_in_text);
        signUp = (Button)findViewById(R.id.sign_up_btn);
        bun = new Bundle();
    }
    private boolean checkCondition(){
        if(fullName.getText().toString().isEmpty()){
            fullName.requestFocus();
            fullName.setError("Please fill in the field");
            return false;
        }
        else if(email.getText().toString().isEmpty()){
            email.requestFocus();
            email.setError("Please fill in the field");
            return false;
        }
        else if(password.getText().toString().isEmpty()){
            password.requestFocus();
            password.setError("Please fill in this field");
            return false;
        }
        else{

            return true;
        }
    }
}
