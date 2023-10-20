package com.example.appatletica;
import android.os.Bundle;
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
        setContentView(R.layout.shopping_screen); // Defina o layout da sua tela de compras

        recyclerView = findViewById(R.id.recyclerView);
        LinearLayoutManager layoutManager = new LinearLayoutManager(this);
        recyclerView.setLayoutManager(layoutManager);

        List<Product> productList = generateSampleProductList(); // Método fictício para gerar dados de exemplo
        productAdapter = new ProductAdapter(productList);
        recyclerView.setAdapter(productAdapter);
    }

    private List<Product> generateSampleProductList() {
        List<Product> productList = new ArrayList<>();
        productList.add(new Product("Produto 1", "Descrição do Produto 1"));
        productList.add(new Product("Produto 2", "Descrição do Produto 2"));
        return productList;
    }
}
