package oop.persistence;

import oop.entities.PerishableProduct;
import oop.entities.Product;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author Hemrik Balázs
 */
class PerishableProductHandler extends ProductHandlerAbstract{
    
    private static final String INSERT_INTO;
    private static final String UPDATE_QUANTITY;
    private static final String SELECT_ALL;
    
    static{
        INSERT_INTO = "CALL INSERT_PERISHABLE_PRODUCT"
                + "('%s', '%s', '%s', '%s', %d, %d, %d, '%s', %d, '%s', '%s');";
        
        UPDATE_QUANTITY = "UPDATE PERISHABLE_PRODUCT SET QUANTITY = %d "
                + "WHERE ARTICLE_NUMBER = '%s';";
        
        SELECT_ALL = "SELECT * FROM PERISHABLE_PRODUCT";
    }
    

    @Override
    public void insert(Product product) {
        PerishableProduct pp = castProduct(product);
        String insert = String.format(INSERT_INTO, pp.getArticleNumber(),
                pp.getName(), pp.getBrand(), pp.getFamily(), pp.getNettoPrice(),
                pp.getTaxID(), pp.getQuantity(), pp.getAmountUnits(),
                Util.dateToString(pp.getExpirationDate()), 
                Util.dateToString(pp.getProductionDate()));
        executeNonQuery(insert);
    }

    @Override
    public void update(Product product) {
        PerishableProduct pp = castProduct(product);
        String update = String.format(UPDATE_QUANTITY, pp.getQuantity(),
                pp.getArticleNumber());
        executeNonQuery(update);
    }

    @Override
    public List<? extends Product> selectAll() {
        return executeQuery(SELECT_ALL);
    }
    
    @Override
    protected List<? extends Product> getResultFromResultSet(ResultSet resultSet)
            throws SQLException {
        List<PerishableProduct> ppList = new ArrayList<>();
        PerishableProduct ppTemp;
        while(resultSet.next()){
            ppTemp = createPerishableProduct(resultSet);
            ppList.add(ppTemp);
        }
        return ppList;
    }

    private PerishableProduct createPerishableProduct(ResultSet resultSet) throws SQLException {
        String articleNumber = resultSet.getString(1);
        String name = resultSet.getString(2);
        String brand = resultSet.getString(3);
        String family = resultSet.getString(4);
        int nettoPrice = resultSet.getInt(5);
        int taxID = resultSet.getInt(6);
        int quantity = resultSet.getInt(7);
        String amountUnits = resultSet.getString(8);
        int criticalQuantity = resultSet.getInt(9);
        LocalDate expirationDate = Util.stringToDate(resultSet.getString(10));
        LocalDate productionDate = Util.stringToDate(resultSet.getString(11));
        return new PerishableProduct(articleNumber, name, brand, family, nettoPrice, taxID, quantity, amountUnits, criticalQuantity, expirationDate, productionDate);
    }
    
    private PerishableProduct castProduct(Product product) {
        return (PerishableProduct) product;
    }

}
