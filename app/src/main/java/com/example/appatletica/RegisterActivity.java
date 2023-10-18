package com.example.appatletica;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;

import androidx.appcompat.app.AppCompatActivity;

import com.example.appatletica.R;

public class RegisterActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.login_register);

    }

    public void btnVoltar (View view) {
        Intent intent = new Intent(this, LoginActivity.class);
        startActivity(intent);
    }
}
