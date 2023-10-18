package com.example.appatletica;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;

import java.util.regex.Pattern;

public class RecoverActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.login_recover);

        Button btnEnviar = findViewById(R.id.btnEnviar);
        final EditText emailEditText = findViewById(R.id.emailEditText);
        btnEnviar.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                String email = emailEditText.getText().toString();

                if (isValidEmail(email)) {
                    Intent intent = new Intent(RecoverActivity.this, SentRecoverActivity.class);
                    startActivity(intent);
                } else {
                    Toast.makeText(RecoverActivity.this, "Por favor, insira um email válido.", Toast.LENGTH_SHORT).show();
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