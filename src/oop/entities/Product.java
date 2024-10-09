package oop.entities;

/**
 *
 * @author Hemrik Balázs
 */
public interface Product {
    
    void save();
    
    void editQuantity(int value);
    
    Object getAttributeByIndex(int index);
}
