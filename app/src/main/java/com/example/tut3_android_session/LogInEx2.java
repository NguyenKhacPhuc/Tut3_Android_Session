package com.example.tut3_android_session;

import android.content.Intent;
import android.os.Bundle;
import android.text.Editable;
import android.text.TextWatcher;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;

public class LogInEx2 extends AppCompatActivity {
    private EditText email;
    private EditText password;
    private Button signIn;
    private TextView signUp;
    private Button forgot;
    private Intent intent;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.loginex2);
        initView();
        signIn.setOnClickListener(clickSignIn ->{
               if(checkCondition()){
                   Toast.makeText(LogInEx2.this, "Hello"+email.getText().toString(),Toast.LENGTH_SHORT).show();
               }
        });
        try {
            Bundle bun = intent.getBundleExtra("in4");
            assert bun != null;
            String sign_up_mail = bun.getString("email");
            String sign_up_password = bun.getString("pass");
            email.setText(sign_up_mail);
            password.setText(sign_up_password);
            if(!password.getText().toString().isEmpty()){
                forgot.setVisibility(View.INVISIBLE);
            }
        }catch (Exception ignored){

        }
        password.addTextChangedListener(new TextWatcher() {
            @Override
            public void beforeTextChanged(CharSequence s, int start, int count, int after) {

            }

            @Override
            public void onTextChanged(CharSequence s, int start, int before, int count) {

                    forgot.setVisibility(View.INVISIBLE);

            }

            @Override
            public void afterTextChanged(Editable s) {
                    String afterC = password.getText().toString();
                    if(afterC.isEmpty()){
                        forgot.setVisibility(View.VISIBLE);
                    }else{
                        forgot.setVisibility(View.INVISIBLE);
                    }
            }
        });
        signUp.setOnClickListener(clickSignUp ->{
            startActivity(new Intent(LogInEx2.this, SignUp.class));
        });
    }
    void initView(){
        email = (EditText)findViewById(R.id.email_input);
        password = (EditText)findViewById(R.id.password_input);
        signIn = (Button)findViewById(R.id.Log_in_btn);
        forgot = (Button)findViewById(R.id.forgot_pass);
        signUp = (TextView)findViewById(R.id.login_signup);
        intent = getIntent();
    }
    private boolean checkCondition(){
        if(email.getText().toString().isEmpty()){
            email.requestFocus();
            email.setError("Please fill in the field");
            return false;
        }
        else if(password.getText().toString().isEmpty()){
            password.requestFocus();
            password.setError("Please fill in this field");
            return false;
        }else{
            return true;
        }
    }
}
