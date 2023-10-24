package com.example.appatletica;

import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.View;


import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;
import com.example.appatletica.model.CardItem;


import java.util.ArrayList;
import java.util.List;

public class HomeActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.home_screen);

        RecyclerView recyclerView = findViewById(R.id.recyclerView);
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

    public void account1(View view){
        Intent intent = new Intent(this, AccountActivity.class);
        startActivity(intent);
    }

    public void shopping1 (View view) {
        Intent intent = new Intent(this, ShoppingActivity.class);
        startActivity(intent);
    }
    public void announcement1 (View view) {
        Intent intent = new Intent(this, AnnouncementActivity.class);
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