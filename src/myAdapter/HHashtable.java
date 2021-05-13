package myAdapter;
import java.util.Enumeration;

/***
 *This class implements a hashtable, which maps keys to values. Any non-null object can be used as a key or as a value.
 *
 * To successfully store and retrieve objects from a hashtable, the objects used as keys must implement the hashCode method and the equals method.
 *
 * An instance of Hashtable has two parameters that affect its efficiency: its capacity and its load factor. The load factor in the CLDC implementation of the hashtable class is always 75 percent. When the number of entries in the hashtable exceeds the product of the load factor and the current capacity, the capacity is increased by calling the rehash method.
 *
 * If many entries are to be made into a Hashtable, creating it with a sufficiently large capacity may allow the entries to be inserted more efficiently than letting it perform automatic rehashing as needed to grow the table.
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
     * @param key - the hashtable key
     * @param value - the value
     * @return the previous value of the specified key in this hashtable, or null if it did not have one.
     * @throws NullPointerException - if the key value is null
     */
   Object put (Object key, Object value);

    /***
     * Removes the key (and its corresponding value) from this hashtable. This method does nothing if the key is not in the hashtable.
     * @param key - the key that need to be removed.
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
