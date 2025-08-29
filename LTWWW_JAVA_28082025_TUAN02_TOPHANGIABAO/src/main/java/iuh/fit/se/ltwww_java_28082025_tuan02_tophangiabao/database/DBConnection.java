package iuh.fit.se.ltwww_java_28082025_tuan02_tophangiabao.database;

import org.mariadb.jdbc.Connection;

import java.sql.DriverManager;
import java.sql.SQLException;


public class DBConnection {
    private static final String JDBC_URL = "jdbc:mariadb://localhost:3306/uploadfiledb";
    private static final String JDBC_USER = "root";
    private static final String JDBC_PASSWORD = "25082004";

    static {
        try {
            Class.forName("org.mariadb.jdbc.Driver");

        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        }
    }

    public static Connection getConnection() throws SQLException {
        return (Connection) DriverManager.getConnection(JDBC_URL, JDBC_USER, JDBC_PASSWORD);
    }
}


