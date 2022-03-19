package jm.task.core.jdbc.util;

import java.io.IOException;
import java.io.InputStream;
import java.net.URISyntaxException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.util.Properties;

public class Util {
    private static Connection conn = null;
    private static Util instance = null;
    private static String root = "root";
    private static String pass = "Ah1fl8NqN%muiip";
    private static String url = "jdbc:mysql://localhost/lolkek";

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

    public Connection getConnection() {
        return conn;
    }

}