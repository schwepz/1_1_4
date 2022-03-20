
package jm.task.core.jdbc.dao;

import jm.task.core.jdbc.model.*;
import jm.task.core.jdbc.util.Util;
import org.hibernate.MappingException;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;

import java.util.ArrayList;
import java.util.List;

public class UserDaoHibernateImpl implements UserDao {
    private SessionFactory sessionFactory;
    private Session session;
    private Transaction transaction;


    public UserDaoHibernateImpl() {
    }

    @Override
    public void createUsersTable() {
        sessionFactory = Util.getSessionFactory();
        session = sessionFactory.openSession();
        transaction = session.beginTransaction();
        session.createSQLQuery("CREATE TABLE IF NOT EXISTS user " +
               "(id BIGINT PRIMARY KEY AUTO_INCREMENT, name VARCHAR(255), last_name VARCHAR(255), age INT)").executeUpdate();
        transaction.commit();
        session.close();

    }

    @Override
    public void dropUsersTable() {
        sessionFactory = Util.getSessionFactory();
        session = sessionFactory.openSession();
        transaction = session.beginTransaction();
        session.createSQLQuery("DROP TABLE user").executeUpdate();
        transaction.commit();
        session.close();

    }

    @Override
    public void saveUser(String name, String lastName, byte age) {
        sessionFactory = Util.getSessionFactory();
        session = sessionFactory.openSession();
        transaction = session.beginTransaction();
        session.save(new User(name, lastName, age));
        transaction.commit();
        session.close();
    }



    @Override
    public void removeUserById(long id) {
        sessionFactory = Util.getSessionFactory();
        session = sessionFactory.openSession();
        transaction = session.beginTransaction();
        session.delete((User) session.get(User.class, id));
        transaction.commit();
        session.close();
    }
    @Override
    public List<User> getAllUsers() {
        List<User> userList = new ArrayList<>();
        Session session = sessionFactory.openSession();
        transaction = session.beginTransaction();
        userList = session.createQuery("FROM User", User.class).getResultList();
        transaction.commit();
        return userList;
    }


    @Override
    public void cleanUsersTable() {
        sessionFactory = Util.getSessionFactory();
        session = sessionFactory.openSession();
        transaction = session.beginTransaction();
        session.createSQLQuery("TRUNCATE TABLE user").executeUpdate();
        transaction.commit();

        session.close();
    }

}
