package com.example.appatletica;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;

import controller.login_controller;
import com.example.appatletica.dao.UserDAO;
import com.example.appatletica.dao.userDAO_impl;

public class LoginActivity extends AppCompatActivity {
    private EditText emailEditText;
    private EditText senhaEditText;
    private Button btnLogin;
    private login_controller loginController;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.login_screen);

        emailEditText = findViewById(R.id.emailEditText);
        senhaEditText = findViewById(R.id.senhaEditText);
        btnLogin = findViewById(R.id.btnLogin);

        UserDAO userDAO = new userDAO_impl();
        loginController = new login_controller(userDAO);

        btnLogin.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                String email = emailEditText.getText().toString();
                String senha = senhaEditText.getText().toString();
                String userType = loginController.getUserType(email, senha);

               if (userType != null) {
                    Intent intent = new Intent(LoginActivity.this, HomeActivity.class);
                   intent.putExtra("userType", userType);
                    startActivity(intent);
                } else {
                   Toast.makeText(LoginActivity.this, "Credenciais inválidas", Toast.LENGTH_SHORT).show();
               }
            }
        });
    }

    public void registrar(View view){
        Intent intent = new Intent(this, RegisterActivity.class);
        startActivity(intent);
    }
    public void esqueceu(View view){
        Intent intent = new Intent(this, RecoverActivity.class);
        startActivity(intent);
    }
}