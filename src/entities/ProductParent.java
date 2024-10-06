package entities;

/**
 *
 * @author Hemrik Balázs
 */
class ProductParent {
    
    private String articleNumber;
    private String name;
    private String brand;
    private String family;
    private int nettoPrice;
    private int taxID;
    private int quantity;
    private String amountUnits;
    private int criticalQuantity;

    public ProductParent(String articleNumber, String name, String brand, String family, int nettoPrice, int taxID, int quantity, String amountUnits, int criticalQuantity) {
        this.articleNumber = articleNumber;
        this.name = name;
        this.brand = brand;
        this.family = family;
        this.nettoPrice = nettoPrice;
        this.taxID = taxID;
        this.quantity = quantity;
        this.amountUnits = amountUnits;
        this.criticalQuantity = criticalQuantity;
    }

    
    
    public String getArticle_number() {
        return articleNumber;
    }

    public String getName() {
        return name;
    }

    public String getBrand() {
        return brand;
    }

    public String getFamily() {
        return family;
    }

    public int getNetto_price() {
        return nettoPrice;
    }

    public int getTax_id() {
        return taxID;
    }

    public int getQuantity() {
        return quantity;
    }

    public String getAmount_units() {
        return amountUnits;
    }

    public int getCritical_quantity() {
        return criticalQuantity;
    }

    public int getBrutto_price() {
        int multiplier = taxID / 100 + 1;
        return nettoPrice * multiplier;
    }
    
    
}
