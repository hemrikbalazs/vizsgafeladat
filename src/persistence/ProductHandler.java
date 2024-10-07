package persistence;

import entities.Product;
import java.util.List;

/**
 *
 * @author Hemrik Balázs
 */
public interface ProductHandler {
    
    public void insert(Product product);
    
    public void update(Product product);
    
    public List<? extends Product> selectAll();
}
