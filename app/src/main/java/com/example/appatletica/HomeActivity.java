package com.example.appatletica;

import android.os.Bundle;
import android.util.Log;

import androidx.appcompat.app.AppCompatActivity;


public class HomeActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.home_screen);

        String userType = getIntent().getStringExtra("userType");

        if (userType != null) {
            String userTypeText = userType.equals("membro") ? "membro" : "administrador";
            Log.d("HomeActivity", "Você entrou como " + userTypeText);
        } else {
            Log.d("HomeActivity", "Tipo de usuário desconhecido");
        }
    }

}