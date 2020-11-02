package com.uh.rachel.util;

import java.sql.Connection;
import java.sql.DriverManager;
import static com.uh.rachel.util.DatabaseConnector.USERNAME;

public class DatabaseConnector {
    static String DRIVER = "com.microsoft.sqlserver.jdbc.SQLServerDriver";
    static String CONNECTION_URL = "jdbc:sqlserver://CoT-CIS3365-13.cougarnet.uh.edu;database=karma-massage-db";
    static String USERNAME="admin";
    static String PASSWORD="admin123";
    public static class ConnectionProvider {
        private static Connection connection = null;
        static {
            try {
                Class.forName(DatabaseConnector.DRIVER);
                connection = DriverManager.getConnection(DatabaseConnector.CONNECTION_URL, USERNAME, PASSWORD);
            } catch (Exception e) {
                e.printStackTrace();
            }
        }
        public Connection getConnection() {
            return connection;
        }
    }
}
