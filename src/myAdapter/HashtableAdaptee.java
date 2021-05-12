package myAdapter;

import java.util.Enumeration;
import java.util.Hashtable;

public class HashtableAdaptee implements HHashtable {

    Hashtable hash;
    /***
     *  Constructs a new, empty hashtable with a default initial capacity and load factor.
     */
    public HashtableAdaptee() {
        hash = new Hashtable();
    }

    /***
     * Constructs a new, empty hashtable with the specified initial capacity.
     * @param initialCapacity - the initial capacity of the hashtable.
     */
    public HashtableAdaptee(int initialCapacity) {
        if(initialCapacity < 0 )
            throw new IndexOutOfBoundsException("negative index is not allowed");
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
    public Enumeration keys() {
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

    @java.lang.Override
    public String toString() {
        return hash.toString();
    }
}
