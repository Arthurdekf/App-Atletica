package com.example.appatletica;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

import androidx.appcompat.app.AppCompatActivity;

public class SettingsActivity extends AppCompatActivity {
    private Button btnSair;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.settings_screen);

        btnSair = findViewById(R.id.btnSair);
        btnSair.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                Intent intent = new Intent(SettingsActivity.this, LoginActivity.class);
                startActivity(intent);
            }
        });
    }
    public void btnVoltar (View view) {
        Intent intent = new Intent(this, AccountActivity.class);
        startActivity(intent);
    }

    public void voltarMenu (View view) {
        Intent intent = new Intent(this, HomeActivity.class);
        startActivity(intent);
    }

}