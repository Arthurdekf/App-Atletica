package com.example.appatletica.model;

public final class administrator extends user {
    private String nomeAtletica;

    public administrator(String email, String senha) {
        super(email, senha);
    }

    public String getNomeAtletica() {
        return nomeAtletica;
    }

    public void setNomeAtletica(String nomeAtletica) {
        this.nomeAtletica = nomeAtletica;
    }
}
