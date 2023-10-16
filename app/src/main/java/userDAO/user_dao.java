package userDAO;

import com.example.appatletica.model.user;

import java.util.List;

public interface user_dao {
    boolean autenticarUsuario(String email, String senha);

    List<user> getUsers();

    // deletar usuário

    //atualizar uauário
}
