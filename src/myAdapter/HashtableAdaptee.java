package myAdapter;

import java.util.Enumeration;
import java.util.Hashtable;

/***
 * This class implements a hashtable of Java cldc 1.1, which maps keys to values. Any non-null object can be used as a key or as a value.<br>
 * <br>
 * the implementation respects exactly the interface to which it is connected/ <br>
 * @see HHashtable HHashtable
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

    @Override
    public boolean contains(Object value) {
        return hash.contains(value);
    }

    @Override
    public boolean containsKey(Object key) {
        return hash.containsKey(key);
    }

    @Override
    public Object get(Object key) {
        return hash.get(key);
    }

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
