package oop.persistence;

import oop.entities.Product;
import java.util.List;
import oop.exceptions.PersistenceException;

/**
 *
 * @author Hemrik Balázs
 */
public interface ProductHandler {
    
    public void insert(Product product) throws PersistenceException;
    
    public void update(Product product) throws PersistenceException;
    
    public List<? extends Product> selectAll() throws PersistenceException;
}
