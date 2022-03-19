package jm.task.core.jdbc.dao;

import jm.task.core.jdbc.model.*;
import jm.task.core.jdbc.util.Util;
import org.hibernate.MappingException;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;

import java.util.List;

public class UserDaoHibernateImpl implements UserDao {
    private Transaction transaction;
    private SessionFactory sessionFactory;
    private Session session;

    public UserDaoHibernateImpl() {

    }

    @Override
    public void createUsersTable() {
//        transaction = Util.getSessionFactory().openSession().beginTransaction();
//        session.createSQLQuery("CREATE TABLE IF NOT EXISTS users " +
//                "(id BIGINT PRIMARY KEY AUTO_INCREMENT, name VARCHAR(255), last_name VARCHAR(255), age INT)").executeUpdate();
//        transaction.commit();
//        session.close();
    }

    @Override
    public void dropUsersTable() {
        transaction = Util.getSessionFactory().openSession().beginTransaction();
       session.createSQLQuery("DROP TABLE users").executeUpdate();
        System.out.println("drop users table");
       transaction.commit();
        session.close();
    }

    @Override
    public void saveUser(String name, String lastName, byte age) {
        transaction =  Util.getSessionFactory().openSession().beginTransaction();
        session.save(new User(name, lastName, age));
        transaction.commit();
        session.close();

    }

    @Override
    public void removeUserById(long id) {
        transaction = Util.getSessionFactory().openSession().beginTransaction();
        User user = (User) session.get(User.class, id);
        System.out.println("remove users");
        session.delete(user);
        transaction.commit();
        session.close();
    }

    @Override
    public List<User> getAllUsers() {


//        transaction = Util.getSessionFactory().openSession().beginTransaction();
//        List<User> users = session.createQuery("FROM users").list();
        System.out.println("getAllUsers()");
//        transaction.commit();
//        session.close();
        return null;
    }

    @Override
    public void cleanUsersTable() {
//        transaction = Util.getSessionFactory().openSession().beginTransaction();
//        session.createSQLQuery("TRUNCATE TABLE users").executeUpdate();
//        transaction.commit();

        System.out.println("cleanUsersTable();");
//        session.close();
    }

}
