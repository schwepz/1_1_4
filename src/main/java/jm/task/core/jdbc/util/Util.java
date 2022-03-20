package jm.task.core.jdbc.util;

import jm.task.core.jdbc.model.User;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.boot.registry.StandardServiceRegistryBuilder;
import org.hibernate.cfg.Configuration;
import org.hibernate.cfg.Environment;
import org.hibernate.service.ServiceRegistry;

import java.sql.Connection;

import java.sql.DriverManager;

import java.sql.SQLException;
import java.util.Properties;



public class Util {
    private static Connection conn = null;
    private static Util instance = null;
    private static SessionFactory sessionFactory = null;
    private static String root = "root";
    private static String pass = "Ah1fl8NqN%muiip";
    private static String url = "jdbc:mysql://localhost/lolkek?useSSL=false";
    private static String driver = "com.mysql.cj.jdbc.Driver";

    private Util() {
        try {
            conn = DriverManager.getConnection(url, root, pass ) ;
        } catch (SQLException  e) {
            e.printStackTrace();
        }
    }

    public static Util getInstance() {
        if (null == instance) {
            instance = new Util();
        }
        return instance;
    }


    public Connection getConnection() {        Connection connection = null;
        try {
            Class.forName(driver);
            conn = DriverManager.getConnection(url, root, pass);
        }
        catch (SQLException | ClassNotFoundException e) {
            System.out.println("Failed to load driver");
            e.printStackTrace();
        }

        if (conn != null) {
            System.out.println("Connection successfully");
        } else {
            System.out.println("Failed to make connect");
        }
        return conn;
    }

    public static SessionFactory getSessionFactory() {
        if (sessionFactory == null) {
            try {

                Configuration configuration = new Configuration();
                Properties settings = new Properties();

                settings.put(Environment.DRIVER, driver);
                settings.put(Environment.URL, url);
                settings.put(Environment.USER, root);
                settings.put(Environment.PASS, pass);
                settings.put(Environment.DIALECT, "org.hibernate.dialect.MySQL5Dialect");

                settings.put(Environment.SHOW_SQL, "true");

                settings.put(Environment.CURRENT_SESSION_CONTEXT_CLASS, "thread");

                settings.put(Environment.HBM2DDL_AUTO, "create-drop");

                configuration.setProperties(settings);

                configuration.addAnnotatedClass(User.class);



                sessionFactory = configuration.buildSessionFactory(new StandardServiceRegistryBuilder()
                        .applySettings(configuration.getProperties()).build());
            } catch (Exception e) {

                e.printStackTrace();
            }
        }
        return sessionFactory;
    }
}