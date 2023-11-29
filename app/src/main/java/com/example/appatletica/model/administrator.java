package com.example.appatletica.model;

public final class administrator extends User {
    private String nomeAtletica;

    public administrator(String id, String email, String senha, String curso) {
        super(id, email, senha, curso);
    }

    public String getNomeAtletica() {
        return nomeAtletica;
    }

    public void setNomeAtletica(String nomeAtletica) {
        this.nomeAtletica = nomeAtletica;
    }
}
