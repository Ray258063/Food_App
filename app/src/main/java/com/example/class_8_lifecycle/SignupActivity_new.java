package com.example.class_8_lifecycle;

import androidx.appcompat.app.AppCompatActivity;

import android.content.SharedPreferences;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

public class SignupActivity_new extends AppCompatActivity {
    private EditText etUsername;
    private EditText etPassword;
    private Button btn_signup;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_signup_new);
        etUsername=findViewById(R.id.et_signup_account);
        etPassword=findViewById(R.id.et_signup_password);
        btn_signup=findViewById(R.id.bt_signup);
        View.OnClickListener signupListener=new View.OnClickListener(){

            @Override
            public void onClick(View view) {
                String name=etUsername.getText().toString();
                String password=etPassword.getText().toString();
                if(name.isEmpty()||password.isEmpty()) return;
                SharedPreferences sharedPreferences =getSharedPreferences("account",MODE_PRIVATE);
                SharedPreferences.Editor editor =sharedPreferences.edit();
                editor.putString("username",name);
                editor.putString("password",password);
                editor.commit();
                Toast.makeText(SignupActivity_new.this, "signup successful"+";"+name+";"+password, Toast.LENGTH_SHORT).show();

            }
        };
        btn_signup.setOnClickListener(signupListener);

    }
}