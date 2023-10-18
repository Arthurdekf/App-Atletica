package com.example.appatletica;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;

import androidx.appcompat.app.AppCompatActivity;

public class AccountActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.account_screen);

    }

    public void btnVoltar (View view) {
        Intent intent = new Intent(this, HomeActivity.class);
        startActivity(intent);
    }
}
