package jm.task.core.jdbc;

import jm.task.core.jdbc.service.UserService;
import jm.task.core.jdbc.service.UserServiceImpl;


public class Main {
    private final static UserService userService = new UserServiceImpl();

    public static void main(String[] args) {
        userService.createUsersTable();

        userService.saveUser("Кирилл", "Курскеев", (byte) 25);
        userService.saveUser("Не Кирилл", "Борисович", (byte) 10);
        userService.saveUser("Еще ОДин ", "Человек", (byte) 55);
        userService.saveUser("Тейп", "на бабках", (byte) 20);

        userService.removeUserById(2);

        userService.getAllUsers();

        userService.cleanUsersTable();

        userService.dropUsersTable();
    }
}
