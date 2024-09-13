package com.eventos;

import android.annotation.SuppressLint;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

import androidx.activity.ComponentActivity;

public class LoginActivity extends ComponentActivity implements View.OnClickListener {

    EditText usernameInput, passwordInput ;
    Button loginBtn;
    TextView goToRegister;

    @SuppressLint("MissingInflatedId")
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);

        usernameInput = findViewById(R.id.username_input);
        passwordInput = findViewById(R.id.password_input);
        loginBtn = findViewById(R.id.login_btn);
        goToRegister = findViewById(R.id.tvGoToRegister);

        goToRegister.setOnClickListener(v -> {
            Intent intent = new Intent(LoginActivity.this, RegisterActivity.class);
            startActivity(intent);
        });

        loginBtn.setOnClickListener(v -> {
            Intent intent = new Intent(LoginActivity.this, MainActivity.class);
            startActivity(intent);
        });
    }

    @Override
    public void onClick(View v) {

    }
}
