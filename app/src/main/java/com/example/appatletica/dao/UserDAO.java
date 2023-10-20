package com.example.appatletica.dao;

import com.example.appatletica.model.User;

import java.util.List;

public interface UserDAO {
    boolean autenticarUsuario(String email, String senha);

    List<User> getUsers();

    //void addUser(User user);

    //User getUserById(String id);

    //void deleteUser(String id);

    //void updateUser(User updatedUser);
}
