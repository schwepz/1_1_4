package jm.task.core.jdbc;

import jm.task.core.jdbc.dao.UserDao;
import jm.task.core.jdbc.dao.UserDaoHibernateImpl;
//import jm.task.core.jdbc.dao.UserDaoJDBCImpl;
import jm.task.core.jdbc.service.UserService;
import jm.task.core.jdbc.service.UserServiceImpl;
import jm.task.core.jdbc.util.Util;
import jm.task.core.jdbc.model.User;

import java.sql.SQLException;


public class Main {
    private final static UserService userService = new UserServiceImpl();
    private final static UserDao userDao = new UserDaoHibernateImpl();
    public static void main(String[] args) {
    userService.createUsersTable();
//
//        userService.saveUser("Кирилл", "Курскеев", (byte) 25);
//        userService.saveUser("Не Кирилл", "Борисович", (byte) 10);
//        userService.saveUser("Еще ОДин ", "Человек", (byte) 54);
//        userService.saveUser("Тейп", "на бабках", (byte) 21);
//
//        userService.removeUserById(2);
//
//        userService.getAllUsers();
//
//        userService.cleanUsersTable();
//
//        userService.dropUsersTable();


        userDao.createUsersTable();

        userDao.saveUser("Кирилл", "Курскеев", (byte) 25);
        userDao.saveUser("Не Кирилл", "Борисович", (byte) 10);
        userDao.saveUser("Еще ОДин ", "Человек", (byte) 54);
        userDao.saveUser("Тейп", "на бабках", (byte) 21);
        System.out.println(userDao.getAllUsers());
        userDao.cleanUsersTable();
        userDao.dropUsersTable();
    }
}
