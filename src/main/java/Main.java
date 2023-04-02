import dao.UserAndRoleDAO;
import dao.impl.UserAndRoleDAOImpl;
import model.Role;
import model.User;


public class Main {
    private static final UserAndRoleDAO USER_AND_ROLE_DAO = new UserAndRoleDAOImpl();

    public static void main(String[] args) {

        Role role1 = new Role("Начальник");
        Role role2 = new Role("специалист");
        Role role3 = new Role("курьер");

        User user1 = new User("Андрей", "Andrey", "password1");
        User user2 = new User("Борис", "Boris", "password2");
        User user3 = new User("Владимир", "Vladimir", "password3");
        User user4 = new User("Геннадий", "Gennady", "password4");

        System.out.println("Создание роли"); // в таблицу ролей добавляются роли
        USER_AND_ROLE_DAO.createRole(role1);
        USER_AND_ROLE_DAO.createRole(role2);
        USER_AND_ROLE_DAO.createRole(role3);

        System.out.println("Создание пользователя"); // в таблицу юзеров добавляются юзеры
        USER_AND_ROLE_DAO.createUser(user1);
        USER_AND_ROLE_DAO.createUser(user2);
        USER_AND_ROLE_DAO.createUser(user3);
        USER_AND_ROLE_DAO.createUser(user4);

//        System.out.println("Добавление связи роли с пользователями");
//        role1.addUserToRole(user1);
//        role2.addUserToRole(user2);
//        role2.addUserToRole(user3);
//        role2.addUserToRole(user4);
//        role3.addUserToRole(user4);
//
//        System.out.println("Добавление связи пользователя с ролями");
//        user4.addRoleToUser(role2);
//        user4.addRoleToUser(role3);


        System.out.println("Список всех пользователей без роли"); // нормально выводит
        USER_AND_ROLE_DAO.readAll();

//        System.out.println("Вывод пользователя по его id без роли"); // нормально выводит
//        USER_AND_ROLE_DAO.getByUser(27);

//        System.out.println("Вывод роли пользователя по его id"); // нормально выводит
//        USER_AND_ROLE_DAO.getByRole(27);

//        System.out.println("Удаление пользователя"); // удаляет нормально
//        USER_AND_ROLE_DAO.deleteUser(34);

        System.out.println("Редактирование пользователя"); // почему-то не редактируется
        user3.setPassword("password300");
        user3.addRoleToUser(role2);
        USER_AND_ROLE_DAO.updateUser(user1);

        USER_AND_ROLE_DAO.readAll();
//


//

//

//


    }
}
