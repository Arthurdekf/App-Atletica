package com.example.appatletica.model;

public final class member extends User {
    private String name;
    private String curso;
    boolean receberNoticias;

    public member(String id, String email, String senha, String name, String curso, boolean receberNoticias) {
        super(id, email, senha);
        this.name = name;
        this.curso = curso;
        this.receberNoticias = receberNoticias;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getCurso() {
        return curso;
    }

    public void setCurso(String curso) {
        this.curso = curso;
    }

    public boolean isReceberNoticias() {
        return receberNoticias;
    }

    public void setReceberNoticias(boolean receberNoticias) {
        this.receberNoticias = receberNoticias;
    }
}
