package com.example.homework8;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;

import java.util.HashMap;
import java.util.Map;

public class MainActivity extends AppCompatActivity {

    private EditText etUsername;
    private EditText textPassword;
    private Button btnSignIn;
    private Map<String, String> signInInfo = new HashMap<>();


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        signInInfo.put("admin123", "admin@gmail.com");

        etUsername = this.findViewById(R.id.et_username);
        textPassword = this.findViewById(R.id.text_password);
        btnSignIn = this.findViewById(R.id.btn_sign_in);

        signIn();
    }

    private void signIn() {
        btnSignIn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                String username = etUsername.getText().toString().trim();
                String password = textPassword.getText().toString().trim();

                if (signInInfo.containsKey(password) && signInInfo.containsValue(username)) {
                    Toast.makeText(MainActivity.this, "Вы успешно вошли в аккаунт", Toast.LENGTH_SHORT).show();
                    signInInfo();
                } else {
                    Toast.makeText(MainActivity.this, "Неправильно введены имя пользователя или пароль", Toast.LENGTH_SHORT).show();
                }
            }
        });
    }

    private void signInInfo() {
        Intent signUpIntent = new Intent(MainActivity.this, SecondActivity.class);
        startActivity(signUpIntent);
    }
}