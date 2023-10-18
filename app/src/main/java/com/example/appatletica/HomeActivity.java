package com.example.appatletica;

import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.View;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;
import com.example.appatletica.CardAdapter;
import com.example.appatletica.model.CardItem;


import java.util.ArrayList;
import java.util.List;


public class HomeActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.home_screen);

        RecyclerView recyclerView = findViewById(R.id.recyclerView); // R.id.recyclerView deve corresponder ao ID no seu arquivo activity_home.xml
        recyclerView.setLayoutManager(new LinearLayoutManager(this));

        List<CardItem> itemList = createCardItemList();


        CardAdapter cardAdapter = new CardAdapter(itemList);
        recyclerView.setAdapter(cardAdapter);

        String userType = getIntent().getStringExtra("userType");


        if (userType != null) {
            String userTypeText = userType.equals("membro") ? "membro" : "administrador";
            Log.d("HomeActivity", "Você entrou como " + userTypeText);
        } else {
            Log.d("HomeActivity", "Tipo de usuário desconhecido");
        }


    }

    public void account(View view){
        Intent intent = new Intent(this, AccountActivity.class);
        startActivity(intent);
    }

    private List<CardItem> createCardItemList() {
        List<CardItem> itemList = new ArrayList<>();

        itemList.add(new CardItem("Arthur", "A expressão Lorem ipsum em design gráfico e editoração é um texto padrão em latim utilizado"));
        itemList.add(new CardItem("Unaerp", "A expressão Lorem ipsum em design gráfico e editoração é um texto padrão em latim utilizado A expressão Lorem ipsum em design gráfico e editoração é um texto padrão em latim utilizado"));
        itemList.add(new CardItem("João", "A expressão Lorem ipsum em design gráfico e editoração é um texto padrão em latim utilizado"));
        return itemList;
    }

}