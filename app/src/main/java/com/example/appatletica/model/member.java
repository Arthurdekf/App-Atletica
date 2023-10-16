package com.example.appatletica.model;

public final class member extends user {
    private String ra;

    public member(String email, String senha) {
        super(email, senha);
    }

    public String getRa() {
        return ra;
    }

    public void setRa(String ra) {
        this.ra = ra;
    }

}
