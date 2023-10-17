package com.example.appatletica;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.example.appatletica.model.CardItem;

import java.util.List;

public class CardAdapter extends RecyclerView.Adapter<CardAdapter.CardViewHolder> {
    private List<CardItem> itemList;

    public CardAdapter(List<CardItem> itemList) {
        this.itemList = itemList;
    }

    @NonNull
    @Override
    public CardViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.item_post, parent, false);
        return new CardViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull CardViewHolder holder, int position) {
        CardItem item = itemList.get(position);

        holder.usernameTextView.setText(item.getUsername());
        holder.contentTextView.setText(item.getContent());
    }

    @Override
    public int getItemCount() {
        return itemList.size();
    }

    static class CardViewHolder extends RecyclerView.ViewHolder {
        TextView usernameTextView;
        TextView contentTextView;

        public CardViewHolder(@NonNull View itemView) {
            super(itemView);
            usernameTextView = itemView.findViewById(R.id.username);
            contentTextView = itemView.findViewById(R.id.content);
        }
    }
}

