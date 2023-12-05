package com.example.appatletica.model;

import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.auth.FirebaseUser;

public final class administrator extends User {
    private String nomeAtletica;
    FirebaseUser user = FirebaseAuth.getInstance().getCurrentUser();
    
    public administrator(String id, String email, String senha, String curso) {
        super(id, email, senha, curso);
    }

    public String getNomeAtletica() {
        return nomeAtletica;
    }

    public void setNomeAtletica(String nomeAtletica) {
        this.nomeAtletica = nomeAtletica;
    }

    public FirebaseUser getUser() {
        return user;
    }

    public void setUser(FirebaseUser user) {
        this.user = user;
    }
}
