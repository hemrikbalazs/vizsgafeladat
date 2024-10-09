package oop.persistence;

import oop.entities.Product;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.List;
import oop.exceptions.PersistenceException;

/**
 *
 * @author Hemrik Balázs
 */
abstract class ProductHandlerAbstract implements ProductHandler {
    
    private static SqlConnection sqlConnection;

    protected final void executeNonQuery(String sqlCommand) 
            throws PersistenceException {
        try (Statement statement = sqlConnection.getConnection().
                createStatement()) {
            statement.execute(sqlCommand);
        } catch (SQLException ex) {
            throw new PersistenceException(ex.getMessage());
        }
    }

    protected final List<? extends Product> executeQuery(String queryString)
            throws PersistenceException {
        List<Product> result = null;
        try (Statement statement = sqlConnection.getConnection().
                createStatement(); ResultSet resultSet = statement.executeQuery(
                        queryString)) {
            result = (List<Product>) getResultFromResultSet(resultSet);
        } catch (SQLException ex) {
            throw new PersistenceException(ex.getMessage());
        }
        return result;
    }

    protected abstract List<? extends Product> getResultFromResultSet(
            ResultSet resultSet) throws SQLException;
}
