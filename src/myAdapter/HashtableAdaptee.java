package myAdapter;

import java.util.Enumeration;
import java.util.Hashtable;

/***
 *This class implements a hashtable, which maps keys to values. Any non-null object can be used as a key or as a value.<br>
 *<br>
 * To successfully store and retrieve objects from a hashtable, the objects used as keys must implement the hashCode method and the equals method.<br>
 * <br>
 * An instance of Hashtable has two parameters that affect its performance: initial capacity and load factor. The capacity is the number of buckets in the hash table, and the initial capacity is simply the capacity at the time the hash table is created. Note that the hash table is open: in the case of a "hash collision", a single bucket stores multiple entries, which must be searched sequentially. The load factor is a measure of how full the hash table is allowed to get before its capacity is automatically increased. When the number of entries in the hashtable exceeds the product of the load factor and the current capacity, the capacity is increased by calling the rehash method.<br>
 * <br>
 * Generally, the default load factor (.75) offers a good tradeoff between time and space costs. Higher values decrease the space overhead but increase the time cost to look up an entry (which is reflected in most Hashtable operations, including get and put).<br>
 * <br>
 * The initial capacity controls a tradeoff between wasted space and the need for rehash operations, which are time-consuming. No rehash operations will ever occur if the initial capacity is greater than the maximum number of entries the Hashtable will contain divided by its load factor. However, setting the initial capacity too high can waste space.<br>
 * <br>
 * If many entries are to be made into a Hashtable, creating it with a sufficiently large capacity may allow the entries to be inserted more efficiently than letting it perform automatic rehashing as needed to grow the table. <br>
 *
 */

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
     * @param initialCapacity the initial capacity of the hashtable.
     * @throws IllegalArgumentException if the initial capacity is less than zero.
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
