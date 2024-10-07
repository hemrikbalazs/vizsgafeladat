package persistence;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.util.logging.Level;
import java.util.logging.Logger;

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

    static void closeConnection() {
        if (connection != null) {
            try {
                connection.close();
            } catch (SQLException ex) {
                Logger.getLogger(SqlConnection.class.getName()).
                        log(Level.SEVERE, null, ex);
            }
            connection = null;
        }
    }
}
