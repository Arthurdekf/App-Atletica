package com.example.appatletica.dao;

import java.util.ArrayList;
import java.util.List;
import com.example.appatletica.model.Product;

public class ProductDAO {

    private List<Product> products = new ArrayList<>();

    public void addProduct(Product product) {
        products.add(product);
    }

    public Product getProductByName(String name) {
        for (Product product : products) {
            if (product.getName().equals(name)) {
                return product;
            }
        }
        return null;
    }

    public void updateProduct(Product updatedProduct) {
        for (int i = 0; i < products.size(); i++) {
            Product product = products.get(i);
            if (product.getName().equals(updatedProduct.getName())) {
                products.set(i, updatedProduct);
                return;
            }
        }
    }

    public List<Product> getAllProducts() {
        return products;
    }
}
