package oop.entities;

import java.util.Arrays;
import java.util.Collection;
import java.util.Iterator;
import java.util.List;
import java.util.ListIterator;

/**
 *
 * @author Hemrik Balázs
 */
public class ProductList<Product> implements List<Product>{
    
    private List<Product> data;
    private String[] attributes;

    public ProductList(List<Product> data, String[] attributes) {
        this.data = data;
        this.attributes = attributes;
    }

    public String[] getAttributes() {
        return Arrays.copyOf(attributes, attributes.length);
    }        
    
    @Override
    public int size() {
        return data.size();
    }

    @Override
    public boolean isEmpty() {
        return data.isEmpty();
    }

    @Override
    public boolean contains(Object o) {
        return data.contains(o);
    }

    @Override
    public Iterator<Product> iterator() {
        return data.iterator();
    }

    @Override
    public Object[] toArray() {
        return data.toArray();
    }

    @Override
    public <T> T[] toArray(T[] a) {
        return data.toArray(a);
    }

    @Override
    public boolean add(Product e) {
        return data.add(e);
    }

    @Override
    public boolean remove(Object o) {
        return data.remove(o);
    }

    @Override
    public boolean containsAll(Collection<?> c) {
        return data.containsAll(c);
    }

    @Override
    public boolean addAll(Collection<? extends Product> c) {
        return data.addAll(c);
    }

    @Override
    public boolean addAll(int index, Collection<? extends Product> c) {
        return data.addAll(index, c);
    }

    @Override
    public boolean removeAll(Collection<?> c) {
        return data.removeAll(c);
    }

    @Override
    public boolean retainAll(Collection<?> c) {
        return data.retainAll(c);
    }

    @Override
    public void clear() {
        data.clear();
    }

    @Override
    public Product get(int index) {
        return data.get(index);
    }

    @Override
    public Product set(int index, Product element) {
        return data.set(index, element);
    }

    @Override
    public void add(int index, Product element) {
        data.add(index, element);
    }

    @Override
    public Product remove(int index) {
        return data.remove(index);
    }

    @Override
    public int indexOf(Object o) {
        return data.indexOf(o);
    }

    @Override
    public int lastIndexOf(Object o) {
        return data.lastIndexOf(o);
    }

    @Override
    public ListIterator<Product> listIterator() {
        return data.listIterator();
    }

    @Override
    public ListIterator<Product> listIterator(int index) {
        return data.listIterator(index);
    }

    @Override
    public List<Product> subList(int fromIndex, int toIndex) {
        return data.subList(fromIndex, toIndex);
    }
    
}
