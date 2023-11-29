package com.example.appatletica.dao;

import com.example.appatletica.model.administrator;
import com.example.appatletica.model.member;
import com.example.appatletica.model.User;
import java.util.ArrayList;
import java.util.List;

public class userDAO_impl implements UserDAO {
    private List<User> userList;

    public userDAO_impl() {
        userList = new ArrayList<>();
        userList.add(new member("joao@gmail.com", "teste123", "João", "Engenharia", false));
        userList.add(new administrator("1", "arthur@gmail.com", "admin123", "Engenharia"));
    }

    @Override
    public boolean autenticarUsuario(String email, String senha) {
        for (User user : userList) {
            if (user.getEmail().equals(email) && user.getSenha().equals(senha)) {
                if (user instanceof member) {
                    return true;
                } else if (user instanceof administrator) {
                    return true;
                }
            }
        }
        return false;
    }

    @Override
    public List<User> getUsers() {
        return userList;
    }
}
