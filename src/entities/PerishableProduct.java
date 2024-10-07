package entities;

import java.time.LocalDate;
import static java.time.temporal.ChronoUnit.DAYS;

/**
 *
 * @author Hemrik Balázs
 */
public class PerishableProduct extends ProductAbstract{

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
        throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }

    @Override
    public void editQuantity(int value) {
        throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }
    
}
