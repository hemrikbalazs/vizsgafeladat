package oop.persistence;

import java.util.HashMap;
import java.util.Map;

/**
 *
 * @author Hemrik Balázs
 */
public class ProductHandlerFactory {
    
    private static Map<ProductHandlerType, ProductHandler> handlerMap;
    
    static {
        handlerMap = new HashMap<>();
        handlerMap.put(ProductHandlerType.DURABLE_PRODUCT, 
                new DurableProductHandler());
        handlerMap.put(ProductHandlerType.PERISHABLE_PRODUCT, 
                new PerishableProductHandler());
    }
    
    private ProductHandlerFactory(){
    }
    
    public static ProductHandler createProductHandler(ProductHandlerType type){
        return handlerMap.get(type);
    }
}
