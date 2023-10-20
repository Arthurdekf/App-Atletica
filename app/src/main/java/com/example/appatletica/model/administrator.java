package com.example.appatletica.model;

public final class administrator extends User {
    private String nomeAtletica;

    public administrator(String id, String email, String senha) {
        super(id, email, senha);
    }

    public String getNomeAtletica() {
        return nomeAtletica;
    }

    public void setNomeAtletica(String nomeAtletica) {
        this.nomeAtletica = nomeAtletica;
    }
}
