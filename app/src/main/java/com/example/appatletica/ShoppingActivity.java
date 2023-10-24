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

public class ShoppingActivity extends AppCompatActivity {

    private RecyclerView recyclerView;
    private ProductAdapter productAdapter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.shopping_screen);

        recyclerView = findViewById(R.id.recyclerView);
        LinearLayoutManager layoutManager = new LinearLayoutManager(this);
        recyclerView.setLayoutManager(layoutManager);

        List<Product> productList = generateSampleProductList();
        productAdapter = new ProductAdapter(productList);
        recyclerView.setAdapter(productAdapter);
    }


    private List<Product> generateSampleProductList() {
        List<Product> productList = new ArrayList<>();
        productList.add(new Product("Produto 1", "Descrição do Produto 1", "R$20.00"));
        productList.add(new Product("Produto 2", "Descrição do Produto 2", "R$20.00"));
        return productList;
    }

    public void account2(View view){
        Intent intent = new Intent(this, AccountActivity.class);
        startActivity(intent);
    }

    public void home2(View view){
        Intent intent = new Intent(this, HomeActivity.class);
        startActivity(intent);
    }

    public void announcement2(View view){
        Intent intent = new Intent(this, AnnouncementActivity.class);
        startActivity(intent);
    }
}