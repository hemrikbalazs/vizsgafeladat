package oop.entities;

import oop.exceptions.PersistenceException;
import oop.persistence.ProductHandler;
import oop.persistence.ProductHandlerFactory;
import oop.persistence.ProductHandlerType;

/**
 *
 * @author Hemrik Balázs
 */
public class StorageInventoryFactory {

    private static ProductHandler handler;

    private StorageInventoryFactory() {
    }

    public static ProductList createDurableProductsInventory() throws PersistenceException {
        handler = ProductHandlerFactory.createProductHandler(
                ProductHandlerType.DURABLE_PRODUCT);
        return new ProductList(handler.selectAll(), new String[]{
            "Article Number", "Name", "Brand", "Family", "Netto Price",
            "Brutto Price", "Tax Key", "Quantity", "Amount Units",
            "CriticalQuantity", "Warany Period (months)", "Gross Weight"
        });
    }

    public static ProductList createPerishableProductsInventory() throws PersistenceException {
        handler = ProductHandlerFactory.createProductHandler(
                ProductHandlerType.PERISHABLE_PRODUCT);
        return new ProductList(handler.selectAll(), new String[]{
            "Article Number", "Name", "Brand", "Family", "Netto Price",
            "Brutto Price", "Tax Key", "Quantity", "Amount Units",
            "CriticalQuantity", "Production Date", "Expiration Date",
            "Expires In (days)"
        });
    }

}
