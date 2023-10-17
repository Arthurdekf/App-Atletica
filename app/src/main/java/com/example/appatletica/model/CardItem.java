package com.example.appatletica.model;

public class CardItem {
    private String username;
    private String content;

    public CardItem(String username, String content) {
        this.username = username;
        this.content = content;
    }

    public String getUsername() {
        return username;
    }

    public String getContent() {
        return content;
    }
}

