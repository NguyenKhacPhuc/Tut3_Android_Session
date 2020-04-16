package com.example.tut3_android_session;

import android.os.Bundle;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;

public class LogIn extends AppCompatActivity {
    private Button logIn;
    private Button logInFb;
    private EditText email;
    private EditText password;
    private TextView forgotpw;
    private TextView register;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.login);
        initview();
//        logIn.setCompoundDrawablesWithIntrinsicBounds(R.drawable.left_icon,0,0,0);
        logIn.setOnClickListener(click ->{
            checkCondition();
        });
        logInFb.setOnClickListener(clicklis ->{
            Toast.makeText(LogIn.this,"This function is under repaired",Toast.LENGTH_SHORT).show();
        });
        forgotpw.setOnClickListener(clickforgotps ->{
            Toast.makeText(LogIn.this,"This function is under repaired",Toast.LENGTH_SHORT).show();
        });
        register.setOnClickListener(clickreg ->{
            Toast.makeText(LogIn.this,"This function is under repaired",Toast.LENGTH_SHORT).show();
        });
    }
    private void initview(){
        logIn = findViewById(R.id.Log_in_btn);
        logInFb = findViewById(R.id.login_with_face);
        email = findViewById(R.id.email_input);
        password = findViewById(R.id.password_input);
        forgotpw = findViewById(R.id.forgot_pw_lable);
        register = findViewById(R.id.register);
    }
    private void checkCondition(){
        if(email.getText().toString().isEmpty()){
            email.requestFocus();
            email.setError("Please fill in the field");
        }
        else if(password.getText().toString().isEmpty()){
            password.requestFocus();
            password.setError("Please fill in this field");
        }else{
            Toast.makeText(LogIn.this,"Sign In Success",Toast.LENGTH_SHORT).show();
        }
    }
}
