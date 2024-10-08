package oop.persistence;

import oop.persistence.ProductHandler;
import oop.entities.Product;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author Hemrik Balázs
 */
abstract class ProductHandlerAbstract implements ProductHandler {
    
    private static SqlConnection sqlConnection;

    protected final void executeNonQuery(String sqlCommand) {
        try (Statement statement = sqlConnection.getConnection().
                createStatement()) {
            statement.execute(sqlCommand);
        } catch (SQLException ex) {
            Logger.getLogger(ProductHandlerAbstract.class.getName()).
                    log(Level.SEVERE, null, ex);
        }
    }

    protected final List<? extends Product> executeQuery(String queryString) {
        List<Product> result = null;
        try (Statement statement = sqlConnection.getConnection().
                createStatement(); ResultSet resultSet = statement.executeQuery(
                        queryString)) {
            result = (List<Product>) getResultFromResultSet(resultSet);
        } catch (SQLException ex) {
            Logger.getLogger(ProductHandlerAbstract.class.getName()).
                    log(Level.SEVERE, null, ex);
        }
        return result;
    }

    protected abstract List<? extends Product> getResultFromResultSet(
            ResultSet resultSet) throws SQLException;
}
