package controller;

import com.example.appatletica.model.administrator;
import com.example.appatletica.model.member;
import com.example.appatletica.model.user;

import java.util.List;
import java.util.ArrayList;


import userDAO.user_dao;

public class login_controller {
    private final user_dao userDAO;

    public login_controller(user_dao userDAO) {

        this.userDAO = userDAO;
    }

    public boolean autenticarUsuario(String email, String senha) {
        if (email == null || senha == null || email.isEmpty() || senha.isEmpty()) {
            return false;
        }
        return userDAO.autenticarUsuario(email, senha);
    }

    public String getUserType(String email, String senha) {
        List<user> userList = userDAO.getUsers();

        for (user u : userList) {
            if (u instanceof member && u.getEmail().equals(email) && u.getSenha().equals(senha)) {
                return "membro";
            }
        }

        for (user u : userList) {
            if (u instanceof administrator && u.getEmail().equals(email) && u.getSenha().equals(senha)) {
                return "administrador";
            }
        }
        return null;
    }
}