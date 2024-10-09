package oop.entities;

import oop.persistence.ProductHandler;
import oop.persistence.ProductHandlerFactory;
import oop.persistence.ProductHandlerType;

/**
 *
 * @author Hemrik Balázs
 */
public class DurableProduct extends ProductAbstract{
    
    private static final ProductHandler handler;
    
    static {
        handler = ProductHandlerFactory.createProductHandler(
                ProductHandlerType.DURABLE_PRODUCT);
    }
    
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
    public Object getAttributeByIndex(int index) {
                Object result = getArticleNumber();
        switch (index) {
            case 1:
                result = getName();
                break;
            case 2:
                result = getBrand();
                break;
            case 3:
                result = getFamily();
                break;
            case 4:
                result = getNettoPrice();
                break;
            case 5:
                result = getBruttoPrice();
                break;
            case 6:
                result = getTaxID();
                break;
            case 7:
                result = getQuantity();
                break;
            case 8:
                result = getAmountUnits();
                break;
            case 9:
                result = getCriticalQuantity();
                break;
            case 10:
                result = getWarantyPeriod();
                break;
            case 11:
                result = getGrossWeight();
                break;
            default:
                result = getArticleNumber();
                break;
        }
        return result;
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
