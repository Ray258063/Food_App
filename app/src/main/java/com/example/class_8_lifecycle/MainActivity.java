package com.example.class_8_lifecycle;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {
    private Button btnSignin;
    private Button btCreate;
    private EditText etUsername;
    private EditText etPassword;


    //我這個activity 再開起來的時候需要很多資源 我們可以在onstart 或是 onresume 的時候去拿這些資源
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        //按鈕監聽換頁
        btnSignin = findViewById(R.id.bt_login);
        btCreate=findViewById(R.id.bt_create);
        etUsername=findViewById(R.id.et_account_input);
        etPassword=findViewById(R.id.et_password_input);

        Button.OnClickListener listener = new Button.OnClickListener() {
            @Override
            public void onClick(View v) {
                if(v.getId()==R.id.bt_login){
                    SharedPreferences sharedPreferences=getSharedPreferences("account",MODE_PRIVATE);
                    String username=sharedPreferences.getString("username","");
                    String password=sharedPreferences.getString("password","");
                    if(username.equals(etUsername.getText().toString())&&password.equals(etPassword.getText().toString())){
                        Intent intent = new Intent(MainActivity.this, ProductListActivity.class); //從這個class到哪個class
                        startActivity(intent);
                    }
                    else{
                        Toast.makeText(MainActivity.this, "account or password wrong", Toast.LENGTH_SHORT).show();
                    }

                }
                else if(v.getId()==R.id.bt_create){
                    Intent intent = new Intent(MainActivity.this, SignupActivity_new.class); //從這個class到哪個class
                    startActivity(intent);

                }
            }
        };
        btnSignin.setOnClickListener(listener);
        btCreate.setOnClickListener(listener);
        Toast.makeText(this, "onCreate method is called", Toast.LENGTH_SHORT).show();

    }


    //onstart方法 //取得sharedPrefences 資料夾裡面的 account key and value 去比對帳號是否正確

    @Override
    protected void onStart() {
        super.onStart();
        Toast.makeText(this, "onStart method is called", Toast.LENGTH_SHORT).show();
    }

    //onstart方法 //取得sharedPrefences 資料夾裡面的 account key and value 去比對帳號是否正確
    @Override
    protected void onResume() {
        super.onResume();
        Toast.makeText(this, "onResume method is called", Toast.LENGTH_SHORT).show();
    }

    //onPause
    @Override
    protected void onPause() {
        super.onPause();
        Toast.makeText(this, "onPause method is called", Toast.LENGTH_SHORT).show();
    }

    //onStop
    @Override
    protected void onStop() {
        super.onStop();
        Toast.makeText(this, "onStop method is called", Toast.LENGTH_SHORT).show();
    }
}
