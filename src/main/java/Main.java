import dao.RoleDAO;
import dao.UserDAO;
import dao.impl.RoleDAOImpl;
import dao.impl.UserDAOImpl;
import model.Role;
import model.User;


public class Main {
    private static final UserDAO USER_DAO = new UserDAOImpl();
    private static final RoleDAO ROLE_DAO = new RoleDAOImpl();

    public static void main(String[] args) {

        Role role1 = new Role("Начальник");
        Role role2 = new Role("Подчиненный");

        User user1 = new User(1,"Андрей", "Andrey", "password1", role1);
        User user2 = new User(2,"Борис", "Boris", "password2", role2);
        User user3 = new User(3,"Владимир", "Vladimir", "password3", role2);





        System.out.println("Список пользователей без ролей");
        USER_DAO.getUsers().forEach(System.out::println);
//
        System.out.println("Получение пользователя по id в БД");
        User userId = USER_DAO.readById(28);
        System.out.println(userId);

        System.out.println("Список пользователей по роли");
        USER_DAO.getByRole(role1).forEach(System.out::println); // что-то не так, не выводится список с заданной ролью

        System.out.println("Добавление пользователя с ролью");
        ROLE_DAO.create(role1);
        ROLE_DAO.create(role2);
        USER_DAO.create(user1);
        USER_DAO.create(user2);
        USER_DAO.create(user3);
        USER_DAO.getUsers().forEach(System.out::println);
//
        System.out.println("Удаление пользователя");
        USER_DAO.deleteUser(USER_DAO.readById(25));
        USER_DAO.getUsers().forEach(System.out::println);
//


        System.out.println("Редактирование пользователя");
        USER_DAO.readById(27).setPassword("password4");
        USER_DAO.update(USER_DAO.readById(27)); // поле password не обновляется, почему?
        USER_DAO.getUsers().forEach(System.out::println);
    }
}
