package oop.entities;

import oop.entities.Product;
import oop.entities.CheckConstraints;

/**
 *
 * @author Hemrik Balázs
 */
abstract class ProductAbstract implements Product {

    private String articleNumber;
    private String name;
    private String brand;
    private String family;
    private int nettoPrice;
    private int taxID;
    private int quantity;
    private String amountUnits;
    private int criticalQuantity;


    public final String getArticleNumber() {
        return articleNumber;
    }

    protected final void setArticleNumber(String articleNumber) {
        CheckConstraints.checkIDFormat(articleNumber, "articleNumber");
        this.articleNumber = articleNumber;
    }

    public final String getName() {
        return name;
    }

    protected final void setName(String name) {
        CheckConstraints.checkTextLength(150, name, "name");
        this.name = name;
    }

    public final String getBrand() {
        return brand;
    }

    protected final void setBrand(String brand) {
        CheckConstraints.checkTextLength(50, brand, "brand");
        this.brand = brand;
    }

    public final String getFamily() {
        return family;
    }

    protected final void setFamily(String family) {
        CheckConstraints.checkTextLength(50, family, "family");
        this.family = family;
    }

    public final int getNettoPrice() {
        return nettoPrice;
    }

    protected final void setNettoPrice(int nettoPrice) {
        CheckConstraints.checkNumberLowerBound(0, nettoPrice, "nettoPrice");
        this.nettoPrice = nettoPrice;
    }

    public final int getTaxID() {
        return taxID;
    }

    protected final void setTaxID(int taxID) {
        CheckConstraints.checkNumberLowerBound(0, taxID, "taxID");
        CheckConstraints.checkNumberUpperBound(100, taxID, "taxID");
        this.taxID = taxID;
    }

    public final int getQuantity() {
        return quantity;
    }

    public final void setQuantity(int quantity) {
        CheckConstraints.checkNumberLowerBound(0, quantity, "quantity");
        this.quantity = quantity;
    }

    public final String getAmountUnits() {
        return amountUnits;
    }

    protected final void setAmountUnits(String amountUnits) {
        CheckConstraints.checkTextLength(10, amountUnits, "amountUnits");
        this.amountUnits = amountUnits;
    }

    public final int getCriticalQuantity() {
        return criticalQuantity;
    }

    protected final void setCriticalQuantity(int criticalQuantity) {
        CheckConstraints.checkNumberLowerBound(0, criticalQuantity, "criticalQuantity");
        this.criticalQuantity = criticalQuantity;
    }

    public final int getBrutto_price() {
        int multiplier = taxID / 100 + 1;
        return nettoPrice * multiplier;
    }

    
}
