package main;

import fundamentals.Fundamental;
import java.util.List;
import oop.entities.DurableProduct;
import oop.entities.PerishableProduct;
import oop.entities.StorageInventoryFactory;

/**
 * @author --G--
 */
public class Main {

    public static void main(String[] args) {
        //backup
        System.out.println("Omnem dimittite spem, o vos intrantes!");
        //you can use this to test your solutions
        Fundamental.testMySolutions();
        
        /*
        List<PerishableProduct> pProducts = StorageInventoryFactory.getPerishableProducts();
        List<DurableProduct> dProducts = StorageInventoryFactory.getDurableProducts();
        
        for (PerishableProduct product : pProducts) {
            System.out.println(product.getName());
        }
        System.out.println("--------------------------------");
        
        for (DurableProduct dProduct : dProducts) {
            System.out.println(dProduct.getName());
        }
        */
    }

}
