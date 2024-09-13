package com.eventos;

import android.content.Intent;
import android.os.Bundle;
import android.widget.Button;
import android.widget.EditText;

import androidx.appcompat.app.AppCompatActivity;

public class RegisterActivity extends AppCompatActivity {
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_register);

        EditText username = findViewById(R.id.username_input);
        EditText password = findViewById(R.id.password_input);
        Button registerButton = findViewById(R.id.register_btn);

        registerButton.setOnClickListener(v -> {
            // Guardar usuario y contraseña en base de datos o preferencia compartida
            String user = username.getText().toString();
            String pass = password.getText().toString();

            // Simular registro exitoso y redirigir a LoginActivity
            Intent intent = new Intent(RegisterActivity.this, LoginActivity.class);
            startActivity(intent);
        });
    }
}
