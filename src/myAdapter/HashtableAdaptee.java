package myAdapter;

import java.util.Enumeration;
import java.util.Hashtable;

public class HashtableAdaptee implements HHashtable {

    Hashtable hash;
    /***
     *  Constructs a new, empty hashtable with a default initial capacity (11) and load factor (0.75).
     */
    public HashtableAdaptee() {
        hash = new Hashtable();
    }

    /*
        Questo costruttore può lanciare IllegalArgumentException
        se l'intero è un negativo
     */
    public HashtableAdaptee(int initialCapacity) {
        hash = new Hashtable(initialCapacity);
    }

    @Override
    public int size() {
        return hash.size();
    }

    @Override
    public boolean isEmpty() {
         return hash.isEmpty();
    }

    @Override
    public Enumeration Keys() {
        return hash.keys();
    }

    @Override
    public Enumeration elements() {
        return hash.elements();
    }

    /*
        Lancia NullPointerException se value è null, bisogna verificarlo
     */
    @Override
    public boolean contains(Object value) {
        return hash.contains(value);
    }

    /*
    Non deve lanciare NullPointerException se la chiave è nulla,
    fallisce silenziosamente
     */
    @Override
    public boolean containsKey(Object key) {
        return hash.containsKey(key);
    }
    /*
    Non deve lanciare NullPointerException se la chiave è nulla,
    fallisce silenziosamente
     */
    @Override
    public Object get(Object key) {
        return hash.get(key);
    }

    /***
     *  Rehashes the contents of the hashtable into a hashtable with a larger capacity. This method is calledautomatically when the number
     *  of keys in the hashtable exceeds this hashtable’s capacity and load factor.
     */
    protected void rehash(){}

    @Override
    public Object put(Object key, Object value) {
        return hash.put(key, value);
    }

    @Override
    public Object remove(Object key) {
        return hash.remove(key);
    }

    @Override
    public void clear() {
        hash.clear();
    }
}
