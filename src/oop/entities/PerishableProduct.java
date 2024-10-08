package oop.entities;

import java.time.LocalDate;
import static java.time.temporal.ChronoUnit.DAYS;
import oop.persistence.ProductHandler;
import oop.persistence.ProductHandlerFactory;
import oop.persistence.ProductHandlerType;

/**
 *
 * @author Hemrik Balázs
 */
public class PerishableProduct extends ProductAbstract{

    private static final ProductHandler handler;
    
    static {
        handler = ProductHandlerFactory.createProductHandler(
                ProductHandlerType.PERISHABLE_PRODUCT);
    }
    
    private LocalDate expirationDate;
    private LocalDate productionDate;

public PerishableProduct(String articleNumber, String name, String brand, 
            String family, int nettoPrice, int taxID, int quantity,
            String amountUnits, int criticalQuantity, LocalDate expirationDate,
            LocalDate productionDate) {
        setArticleNumber(articleNumber);
        setName(name);
        setBrand(brand);
        setFamily(family);
        setNettoPrice(nettoPrice);
        setTaxID(taxID);
        setQuantity(quantity);
        setAmountUnits(amountUnits);
        setCriticalQuantity(criticalQuantity);
        initDateFields(expirationDate, productionDate);
    }

    private void initDateFields(LocalDate expirationDate, LocalDate productionDate){
        CheckConstraints.checkChronologicalOrder(productionDate, expirationDate,
                "productionDate", "expirationDate");
        this.expirationDate = expirationDate;
        this.productionDate = productionDate;
    }
    
    public LocalDate getExpirationDate() {
        return expirationDate;
    }

    public LocalDate getProductionDate() {
        return productionDate;
    }
    
    public int getDaysUntilExpiration(){
        LocalDate now = LocalDate.now();
        return (int) now.until(expirationDate, DAYS);
    }
    
    @Override
    public void save() {
        handler.insert(this);
    }

    @Override
    public void editQuantity(int value) {
        setQuantity(value);
        handler.update(this);
    }
    
}
