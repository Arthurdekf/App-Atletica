package com.example.appatletica.model;

public abstract class User {
    private String id;
    private String email;
    private String senha;

    public User(String id,String email, String senha) {
        this.id = id;
        this.email = email;
        this.senha = senha;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getEmail() {
        return email;
    }

    public String getSenha() {
        return senha;
    }
}
