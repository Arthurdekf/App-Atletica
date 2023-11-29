package com.example.appatletica;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;

import com.google.android.gms.tasks.OnCompleteListener;
import com.google.android.gms.tasks.Task;
import com.google.firebase.auth.FirebaseAuth;

import org.checkerframework.checker.nullness.qual.NonNull;

import java.util.regex.Pattern;

public class RecoverActivity extends AppCompatActivity {

    private EditText emailEditText;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.login_recover);
        emailEditText = findViewById(R.id.emailEditText);
    }

    public void esqueceuSenha(View view){
        String email = emailEditText.getText().toString();
        FirebaseAuth.getInstance().sendPasswordResetEmail(email).addOnCompleteListener(new OnCompleteListener<Void>() {
                    @Override
                    public void onComplete(@NonNull Task<Void> task) {
                        if (task.isSuccessful()) {
                            Toast.makeText(RecoverActivity.this,
                                    "Um e-mail de redefinição de senha foi enviado para " +
                                            "o seu endereço de e-mail.",
                                    Toast.LENGTH_LONG).show();
                            finish();
                        } else {
                            Toast.makeText(RecoverActivity.this,
                                    "Falha ao enviar e-mail de redefinição de senha. " +
                                            "Verifique se o endereço de e-mail é válido.",
                                    Toast.LENGTH_LONG).show();
                        }
                    }
        });
    }


    private boolean isValidEmail(String email) {
        String padraoEmail = "^[A-Za-z0-9+_.-]+@(.+)$";
        Pattern pattern = Pattern.compile(padraoEmail);
        return pattern.matcher(email).matches();
    }

    public void btnVoltar (View view) {
        Intent intent = new Intent(this, LoginActivity.class);
        startActivity(intent);
    }
}