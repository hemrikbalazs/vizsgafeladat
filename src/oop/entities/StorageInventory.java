package oop.entities;

import java.util.List;
import oop.persistence.ProductHandler;
import oop.persistence.ProductHandlerFactory;
import oop.persistence.ProductHandlerType;

/**
 *
 * @author Hemrik Balázs
 */
public class StorageInventory {
    
    private static ProductHandler handler;
    
    private StorageInventory(){
    }
    
    public static ProductList getDurableProducts(){
        handler = ProductHandlerFactory.createProductHandler(
                ProductHandlerType.DURABLE_PRODUCT);
        return new ProductList(handler.selectAll(), new String[]{
            "Article Number", "Name", "Brand", "Family", "Netto Price",
            "Brutto Price", "Tax Key", "Quantity", "Amount Units",
            "CriticalQuantity", "Warany Period (months)", "Gross Weight"
        });
    }
    
    public static ProductList getPerishableProducts(){
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