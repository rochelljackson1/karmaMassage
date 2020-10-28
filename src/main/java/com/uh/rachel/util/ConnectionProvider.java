//Connects to Database so that you can do cool stuff
package com.uh.rachel.util;

import java.sql.Connection;
import java.sql.DriverManager;

import static com.uh.rachel.util.LoginCred.*;

public class ConnectionProvider {
    private static Connection connection = null;
    static {
        try {
            Class.forName(DRIVER);
            connection = DriverManager.getConnection(CONNECTION, USER, PASSWORD);
        } catch (Exception e){
            e.printStackTrace();
        }
    }

    public static Connection getConnection() {
        return connection;
    }

}
