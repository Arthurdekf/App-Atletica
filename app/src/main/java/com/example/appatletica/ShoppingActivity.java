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
        productList.add(new Product("Kit Inter Unaerp", "Camiseta + Bolsa do Inter Unaerp 2023", "R$60")); //, R.drawable.inter_unaerp
        productList.add(new Product("Uniforme 1 Engenharias", "Camiseta e short masculino", "R$74.99")); //, R.drawable.kit
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