package oop.persistence;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

/**
 *
 * @author Hemrik Balázs
 */
class SqlConnection {
    private static Connection connection;
    
    private static final String CONNECTION_STRING;

    static {
        CONNECTION_STRING = "jdbc:mysql://localhost:3306/storage";
    }

    static Connection getConnection() throws SQLException {
        if (connection == null) {
            connection = DriverManager.getConnection(CONNECTION_STRING, "root",
                    "Seb4dawin");

        }

        return connection;
    }

}
