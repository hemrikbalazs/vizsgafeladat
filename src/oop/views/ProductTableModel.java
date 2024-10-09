package oop.views;

import javax.swing.table.AbstractTableModel;
import oop.entities.Product;
import oop.entities.ProductList;

/**
 *
 * @author Hemrik Balázs
 */
public class ProductTableModel extends AbstractTableModel{

    private ProductList products;

    public ProductTableModel(ProductList products) {
        this.products = products;
    }
    
    @Override
    public String getColumnName(int index) {
        return products.getAttributes()[index];
    }
    
    @Override
    public int getRowCount() {
        return products.size();
    }

    @Override
    public int getColumnCount() {
        return products.getAttributes().length;
    }

    @Override
    public Object getValueAt(int rowIndex, int columnIndex) {
        Product temp = (Product) products.get(rowIndex);
        return temp.getAttributeByIndex(columnIndex);
    }

    @Override
    public void setValueAt(Object aValue, int rowIndex, int columnIndex) {
        Product temp = (Product) products.get(rowIndex);
        if (aValue instanceof String){
            String text = (String) aValue;
            int value = Integer.parseInt(text);
            temp.editQuantity(value);
        }
    }

    @Override
    public boolean isCellEditable(int rowIndex, int columnIndex) {
        return columnIndex == 7;
    }

    
}
