package oop.entities;

import java.time.LocalDate;
import static java.time.temporal.ChronoUnit.DAYS;
import java.util.ArrayList;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import oop.events.ErrorEvent;
import oop.events.EventBroadcaster;
import oop.events.EventListener;
import oop.exceptions.PersistenceException;
import oop.persistence.ProductHandler;
import oop.persistence.ProductHandlerFactory;
import oop.persistence.ProductHandlerType;

/**
 *
 * @author Hemrik Balázs
 */
public class PerishableProduct extends ProductAbstract implements EventBroadcaster{

    private static final ProductHandler handler;
    
    static {
        handler = ProductHandlerFactory.createProductHandler(
                ProductHandlerType.PERISHABLE_PRODUCT);
    }
    
    private final List<EventListener> listeners;
    private LocalDate expirationDate;
    private LocalDate productionDate;

public PerishableProduct(String articleNumber, String name, String brand, 
            String family, int nettoPrice, int taxID, int quantity,
            String amountUnits, int criticalQuantity, LocalDate expirationDate,
            LocalDate productionDate) {
        this.listeners = new ArrayList<>();
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
                result = getProductionDate();
                break;
            case 11:
                result = getExpirationDate();
                break;
            case 12:
                result= getDaysUntilExpiration();
                break;
            default:
                result = getArticleNumber();
                break;
        }
        return result;
    }
    
    @Override
    public void save() {
        try {
            handler.insert(this);
        } catch (PersistenceException ex) {
            fireEvent("An error occured in the persistenc layer, check your"
                    + "database connection");
        }
    }

    @Override
    public void editQuantity(int value) {
        setQuantity(value);
        try {
            handler.update(this);
        } catch (PersistenceException ex) {
            fireEvent("An error occured in the persistenc layer, check your"
                    + "database connection");
        }
    }

    @Override
    public void addListener(EventListener listener) {
        listeners.add(listener);
    }

    @Override
    public void removeListener(EventListener listener) {
        listeners.remove(listener);
    }

    @Override
    public void fireEvent(String message) {
        ErrorEvent evt = new ErrorEvent(message, this);
        for (EventListener listener : listeners) {
            listener.handleErrorEvent(evt);
        }
    }

    
}
