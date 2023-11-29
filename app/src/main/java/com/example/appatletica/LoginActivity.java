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
import com.google.android.gms.tasks.OnCompleteListener;
import com.google.android.gms.tasks.Task;
import com.google.firebase.FirebaseApp;
import com.google.firebase.auth.FirebaseAuth;

import org.checkerframework.checker.nullness.qual.NonNull;

public class LoginActivity extends AppCompatActivity {
    private EditText emailEditText;
    private EditText senhaEditText;
    private login_controller loginController;
    private Button btnLoginNoAcc;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.login_screen);

        emailEditText = findViewById(R.id.emailEditText);
        senhaEditText = findViewById(R.id.senhaEditText);

        UserDAO userDAO = new userDAO_impl();
        loginController = new login_controller(userDAO);

    }

    public void efetuarLogin(View view){
        String email = emailEditText.getText().toString().trim();
        String senha = senhaEditText.getText().toString().trim();
        if (email.isEmpty() || senha.isEmpty()) {
            Toast.makeText(this, "Preencha todos os campos", Toast.LENGTH_SHORT).show();
            return;
        }

        FirebaseAuth.getInstance().signInWithEmailAndPassword(email, senha).addOnCompleteListener(this, new OnCompleteListener() {
                    @Override
                    public void onComplete(@NonNull Task task) {
                        if (task.isSuccessful()) {
                            Toast.makeText(LoginActivity.this, "Login bem-sucedido", Toast.LENGTH_SHORT).show();
                            Intent it = new Intent(LoginActivity.this, SplashActivity.class);
                            startActivity(it);
                        } else {
                            Toast.makeText(LoginActivity.this, "Falha no login: " +
                                    task.getException().getMessage(), Toast.LENGTH_SHORT).show();
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

    public void btnLoginNoAcc(View view){
        Intent intent = new Intent(this, SplashActivity.class);
        startActivity(intent);
        Toast.makeText(this,"Login realizado sem cadastro", Toast.LENGTH_SHORT).show();
    }
}