package oop.entities;

import java.util.List;
import oop.events.ErrorEvent;
import oop.events.EventBroadcaster;
import oop.events.EventListener;
import oop.exceptions.PersistenceException;

/**
 *
 * @author Hemrik Balázs
 */
public class DurableProductsInventory implements EventBroadcaster{
    
    private ProductList products;
    private List<EventListener> listeners;

    public DurableProductsInventory() {
        try {
            products = StorageInventoryFactory.createDurableProductsInventory();
        } catch (PersistenceException ex) {
            fireEvent("An error occured in the persistenc layer, check your"
                    + "database connection");
        }
    }

    public ProductList getProducts() {
        return new ProductList(products, products.getAttributes());
    }
    
    @Override
    public void addListener(EventListener listener) {
        listeners.add(listener);
    }

    @Override
    public void removeListener(EventListener listener) {
        listeners.remove(listener);
    }

    @Override
    public final void fireEvent(String message) {
        ErrorEvent evt = new ErrorEvent(message, this);
        for (EventListener listener : listeners) {
            listener.handleErrorEvent(evt);
        }
    }
    
    
}
