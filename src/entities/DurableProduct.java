package entities;

/**
 *
 * @author Hemrik Balázs
 */
public class DurableProduct extends ProductAbstract{

    private int warantyPeriod;
    private double grossWeight;

    public DurableProduct(String articleNumber, String name, String brand, 
            String family, int nettoPrice, int taxID, int quantity,
            String amountUnits, int criticalQuantity, int warantyPeriod,
            double grossWeight) {
        setArticleNumber(articleNumber);
        setName(name);
        setBrand(brand);
        setFamily(family);
        setNettoPrice(nettoPrice);
        setTaxID(taxID);
        setQuantity(quantity);
        setAmountUnits(amountUnits);
        setCriticalQuantity(criticalQuantity);
        setWarantyPeriod(warantyPeriod);
        setGrossWeight(grossWeight);
    }

    public int getWarantyPeriod() {
        return warantyPeriod;
    }

    private void setWarantyPeriod(int warantyPeriod) {
        CheckConstraints.checkNumberLowerBound(0, warantyPeriod, "warantyPeriod");
        this.warantyPeriod = warantyPeriod;
    }

    public double getGrossWeight() {
        return grossWeight;
    }

    private void setGrossWeight(double grossWeight) {
        CheckConstraints.checkNumberLowerBound(0, grossWeight, "grossWeight");
        CheckConstraints.checkNumberUpperBound(999, grossWeight, "grossWeight");
        this.grossWeight = grossWeight;
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
