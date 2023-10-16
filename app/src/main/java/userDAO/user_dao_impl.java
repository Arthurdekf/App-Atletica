package userDAO;

import com.example.appatletica.model.administrator;
import com.example.appatletica.model.member;
import com.example.appatletica.model.user;
import java.util.ArrayList;
import java.util.List;

public class user_dao_impl implements user_dao {
    private List<user> userList;

    public user_dao_impl() {
        userList = new ArrayList<>();
        userList.add(new member("joao@gmail.com", "teste123"));
        userList.add(new administrator("arthur@gmail.com", "admin123"));
    }

    @Override
    public boolean autenticarUsuario(String email, String senha) {
        for (user user : userList) {
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
    public List<user> getUsers() {
        return userList;
    }
}
