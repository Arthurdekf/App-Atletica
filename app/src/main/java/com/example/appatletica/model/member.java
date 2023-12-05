package com.example.appatletica.model;

public final class member extends User {
    private String name;
    private String curso;
    boolean receberNoticias;

    public member(String email, String senha, String name, String curso, boolean receberNoticias) {
        super(email, email, senha, curso);
        this.name = name;
        this.receberNoticias = receberNoticias;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public boolean isReceberNoticias() {
        return receberNoticias;
    }

    public void setReceberNoticias(boolean receberNoticias) {
        this.receberNoticias = receberNoticias;
    }

    public String getCurso() {
        return curso;
    }

    public void setCurso(String curso) {
        this.curso = curso;
    }
}