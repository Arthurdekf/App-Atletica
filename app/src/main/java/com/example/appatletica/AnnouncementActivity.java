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
        setContentView(R.layout.announcements_screen);

        recyclerView = findViewById(R.id.recyclerView);
        LinearLayoutManager layoutManager = new LinearLayoutManager(this);
        recyclerView.setLayoutManager(layoutManager);

        List<Product> productList = generateSampleProductList();
        productAdapter = new ProductAdapter(productList);
        recyclerView.setAdapter(productAdapter);
    }

    private List<Product> generateSampleProductList() {
        List<Product> productList = new ArrayList<>();
        productList.add(new Product("Festa da Bata", "09/12/23 - Local: Estação mangueira", "R$55")); //, R.drawable.festa
        productList.add(new Product("Cupom de desconto", "Oak Berry", "5% OFF")); //, R.drawable.oakberry
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
