package com.example.appatletica;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;

public class AdminActivity extends AppCompatActivity {
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.admin_screen);

    }

    public void btnVoltarAdm(View view){
        Intent intent = new Intent(AdminActivity.this, HomeActivity.class);
        startActivity(intent);
        Toast.makeText(this,"Saiu do modo Administrador", Toast.LENGTH_SHORT).show();
    }
}