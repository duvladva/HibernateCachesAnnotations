package dao;

import model.Role;
import model.User;

import java.util.List;

public interface UserAndRoleDAO {
    void createUser(User user);

    void createRole(Role role);

    List<User> readAll();

    User getByUser(int id);

    Role getByRole(int id);

    void deleteUser(int id);

    void updateUser(User user);

}