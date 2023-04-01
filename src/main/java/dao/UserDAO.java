package dao;

import model.Role;
import model.User;

import java.util.List;

public interface UserDAO {

    void create(User user);

    void update(User user);

    void deleteUser(User user);

    User readById(int id);

    List<User> getUsers();

    List<User> getByRole(Role role);

}
