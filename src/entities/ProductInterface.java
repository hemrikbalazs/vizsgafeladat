package entities;

/**
 *
 * @author Hemrik Balázs
 */
public interface ProductInterface {
    
    void save();
    
    void editQuantity();
    
    int calculateBruttoPrice();
}
