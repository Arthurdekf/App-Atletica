package controller;

import com.example.appatletica.model.administrator;
import com.example.appatletica.model.member;
import com.example.appatletica.model.User;

import java.util.List;


import com.example.appatletica.dao.UserDAO;

public class login_controller {
    private final UserDAO userDAO;

    public login_controller(UserDAO userDAO) {

        this.userDAO = userDAO;
    }

    public boolean autenticarUsuario(String email, String senha) {
        if (email == null || senha == null || email.isEmpty() || senha.isEmpty()) {
            return false;
        }
        return userDAO.autenticarUsuario(email, senha);
    }

    public String getUserType(String email, String senha) {
        List<User> userList = userDAO.getUsers();

        for (User u : userList) {
            if (u instanceof member && u.getEmail().equals(email) && u.getSenha().equals(senha)) {
                return "membro";
            }
        }

        for (User u : userList) {
            if (u instanceof administrator && u.getEmail().equals(email) && u.getSenha().equals(senha)) {
                return "administrador";
            }
        }
        return null;
    }
}