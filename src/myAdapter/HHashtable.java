package myAdapter;
import java.util.Enumeration;

/***
 *This interface represent the hashtable of the Java version cldc 1.1, which maps keys to values. Any non-null object can be used as a key or as a value.<br>
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
public interface HHashtable {
    /***
     * Return the number of keys in this hashtable.
     * @return the number of keys in this hashtable.
     */
   int size();

    /***
     * Tests if this hashtable maps no keys to values.
     * @return true if this hashtable maps no keys to values;false otherwise.
     */
   boolean isEmpty();

    /***
     * Returns an enumeration of the keys in this hashtable.
     * @return an enumeration of the keys in this hashtable.
     */
   Enumeration keys();

    /***
     * Returns an enumeration of the values in this hashtable. Use the Enumeration methods on the returned object to fetch the elements sequentially.
     * @return an enumeration of the values in this hashtable
     */
   Enumeration elements();

    /***
     * Tests if some key maps into the specified value in this hashtable. This operation is more expensive than the containsKey method.
     * @param value - a value to search for
     * @return true if some key maps to the value argument in this hashtable;false otherwise.
     * @throws java.lang.NullPointerException - if the value is null
     */
   boolean contains(Object value);

    /***
     * Tests if the specified object is a key in this hashtable.
     * @param key - possible key
     * @return true if the specified object is a key in this hashtable;false otherwise.
     */
   boolean containsKey(Object key);

    /***
     * Returns the value to which the specified key is mapped in this hashtable.
     * @param key - a key in the hashtable
     * @return the value to which the key is mapped in this hashtable; null if the key is not mapped to any value in this hashtable.
     */
   Object get (Object key);

    /***
     * Maps the specifie key to the specified value in this hashtable. Neither the key nor the value can be  null.
     * @param key the hashtable key
     * @param value the value
     * @return the previous value of the specified key in this hashtable, or null if it did not have one.
     * @throws NullPointerException - if the key value is null
     */
   Object put (Object key, Object value);

    /***
     * Removes the key (and its corresponding value) from this hashtable. This method does nothing if the key is not in the hashtable.
     * @param key the key that need to be removed.
     * @return the value to which the key had been mapped in this hashtable, or null if the key did not have a mapping.
     */
   Object remove (Object key);

    /***
     * Clears this hashtable so that it contains no keys.
     */
   public void clear();

    /***
     * Return a rather long string representation of thi hashtable
     * @return a string representation of this hashtable
     */
   String toString();
}
