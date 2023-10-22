package com.example.appatletica;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.example.appatletica.model.Product;

import java.util.ArrayList;
import java.util.List;

public class AnnouncementActivity extends AppCompatActivity {

    private RecyclerView recyclerView;
    private ProductAdapter productAdapter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.announcements_screen); // Defina o layout da sua tela de compras

        recyclerView = findViewById(R.id.recyclerView);
        LinearLayoutManager layoutManager = new LinearLayoutManager(this);
        recyclerView.setLayoutManager(layoutManager);

        List<Product> productList = generateSampleProductList(); // Método fictício para gerar dados de exemplo
        productAdapter = new ProductAdapter(productList);
        recyclerView.setAdapter(productAdapter);
    }

    private List<Product> generateSampleProductList() {
        List<Product> productList = new ArrayList<>();
        productList.add(new Product("Titulo 1", "Descrição do anúncio 1", "R$20.00"));
        productList.add(new Product("Titulo 2", "Descrição do anúncio 2", "R$20.00"));
        return productList;
    }

    public void home3(View view){
        Intent intent = new Intent(this, HomeActivity.class);
        startActivity(intent);
    }

    public void shopping3(View view){
        Intent intent = new Intent(this, ShoppingActivity.class);
        startActivity(intent);
    }

    public void account3(View view){
        Intent intent = new Intent(this, AccountActivity.class);
        startActivity(intent);
    }
}
