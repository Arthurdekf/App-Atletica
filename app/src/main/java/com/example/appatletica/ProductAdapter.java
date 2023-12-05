package com.example.appatletica;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.example.appatletica.model.Product;

import java.util.List;

public class ProductAdapter extends RecyclerView.Adapter<ProductAdapter.ViewHolder> {
    private List<Product> productList;

    public ProductAdapter(List<Product> productList) {
        this.productList = productList;
    }

    @NonNull
    @Override
    public ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext())
                .inflate(R.layout.small_post, parent, false);
        return new ViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull ViewHolder holder, int position) {
        Product product = productList.get(position);
        holder.productNameTextView.setText(product.getName());
        holder.productDescriptionTextView.setText(product.getDescription());
        holder.productPriceTextView.setText(product.getPrice());
        //holder.productImageView.setImageResource(product.getImageResId());
    }

    @Override
    public int getItemCount() {
        return productList.size();
    }

    public class ViewHolder extends RecyclerView.ViewHolder {
        TextView productNameTextView;
        TextView productDescriptionTextView;
        TextView productPriceTextView;
        //ImageView productImageView;
        public ViewHolder(View itemView) {
            super(itemView);
            productNameTextView = itemView.findViewById(R.id.productname);
            productDescriptionTextView = itemView.findViewById(R.id.content);
            productPriceTextView = itemView.findViewById(R.id.price);
            //productImageView = itemView.findViewById(R.id.backgroundImage);
        }
    }
}
