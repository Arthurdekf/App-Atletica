package com.example.appatletica.model;

public abstract class user {
    private String email;
    private String senha;

    public user(String email, String senha) {
        this.email = email;
        this.senha = senha;
    }

    public String getEmail() {
        return email;
    }

    public String getSenha() {
        return senha;
    }
}
