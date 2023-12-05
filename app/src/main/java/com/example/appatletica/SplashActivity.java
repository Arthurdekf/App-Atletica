package com.example.appatletica;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

import androidx.appcompat.app.AppCompatActivity;

import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.auth.FirebaseUser;

public class SplashActivity extends AppCompatActivity {
    private Button btnContinuar;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.splash_screen);

        btnContinuar = findViewById(R.id.btnContinuar);

        String userType = getIntent().getStringExtra("userType");

        btnContinuar.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                FirebaseUser user = FirebaseAuth.getInstance().getCurrentUser();

                if (user != null && user.getEmail().equals("arthur@gmail.com")) {
                    Intent intent = new Intent(SplashActivity.this, AdminActivity.class);
                    startActivity(intent);
                } else {
                        Intent intent = new Intent(SplashActivity.this, HomeActivity.class);
                    startActivity(intent);
                }
            }
        });
    }
}