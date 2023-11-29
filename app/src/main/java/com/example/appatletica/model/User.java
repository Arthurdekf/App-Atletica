package com.example.appatletica.model;

public abstract class User {
    private String id;
    private String email;
    private String senha;
    private String curso;


    public User(String id, String email, String senha, String curso) {
        this.id = id;
        this.email = email;
        this.senha = senha;
        this.curso = curso;
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
