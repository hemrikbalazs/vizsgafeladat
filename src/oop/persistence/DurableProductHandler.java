package oop.persistence;

import oop.entities.DurableProduct;
import oop.entities.Product;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import oop.exceptions.PersistenceException;

/**
 *
 * @author Hemrik Balázs
 */
class DurableProductHandler extends ProductHandlerAbstract{

    private static final String INSERT_INTO;
    private static final String UPDATE_QUANTITY;
    private static final String SELECT_ALL;
    
    static{
        INSERT_INTO = "CALL INSERT_DURABLE_PRODUCT"
                + "('%s', '%s', '%s', '%s', %d, %d, %d, '%s', %d, %d, %.1);";
        
        UPDATE_QUANTITY = "UPDATE DURABLE_PRODUCT SET QUANTITY = %d "
                + "WHERE ARTICLE_NUMBER = '%s';";
        
        SELECT_ALL = "SELECT * FROM DURABLE_PRODUCT";
    }
    
    @Override
    public void insert(Product product) throws PersistenceException {
        DurableProduct dp = castProduct(product);
        String insert = String.format(INSERT_INTO, dp.getArticleNumber(),
                dp.getName(), dp.getBrand(), dp.getFamily(), dp.getNettoPrice(),
                dp.getTaxID(), dp.getQuantity(), dp.getAmountUnits(),
                dp.getWarantyPeriod(), dp.getGrossWeight());
        executeNonQuery(insert);
    }

    @Override
    public void update(Product product) throws PersistenceException {
        DurableProduct dp = castProduct(product);
        String update = String.format(UPDATE_QUANTITY, dp.getQuantity(),
                dp.getArticleNumber());
        executeNonQuery(update);
    }

    @Override
    public List<? extends Product> selectAll() throws PersistenceException {
        return executeQuery(SELECT_ALL);

    }
    
    @Override
    protected List<? extends Product> getResultFromResultSet(ResultSet resultSet)
            throws SQLException {
        List<DurableProduct> dpList = new ArrayList<>();
        DurableProduct dpTemp;
        while (resultSet.next()){
            dpTemp = createDurableProduct(resultSet);
            dpList.add(dpTemp);
        }
        return dpList;
    }

    private DurableProduct createDurableProduct(ResultSet resultSet) throws SQLException {
        String articleNumber = resultSet.getString(1);
        String name = resultSet.getString(2);
        String brand = resultSet.getString(3);
        String family = resultSet.getString(4);
        int nettoPrice = resultSet.getInt(5);
        int taxID = resultSet.getInt(6);
        int quantity = resultSet.getInt(7);
        String amountUnits = resultSet.getString(8);
        int criticalQuantity = resultSet.getInt(9);
        int warantyPeriod = resultSet.getInt(10);
        double grossWeight =  resultSet.getDouble(11);
        return new DurableProduct(articleNumber, name, brand, family,
                nettoPrice, taxID, quantity, amountUnits, criticalQuantity, 
                warantyPeriod, grossWeight);
    }
    
    private DurableProduct castProduct(Product product) {
        return (DurableProduct) product;
    }

}
