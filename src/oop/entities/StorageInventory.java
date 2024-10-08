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
    
    public static List<DurableProduct> getDurableProducts(){
        handler = ProductHandlerFactory.createProductHandler(
                ProductHandlerType.DURABLE_PRODUCT);
        return (List<DurableProduct>) handler.selectAll();
    }
    
    public static List<PerishableProduct> getPerishableProducts(){
        handler = ProductHandlerFactory.createProductHandler(
                ProductHandlerType.PERISHABLE_PRODUCT);
        return (List<PerishableProduct>) handler.selectAll();
    }
    
}