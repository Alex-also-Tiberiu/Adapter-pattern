package myAdapter;
import java.util.Enumeration;

/***
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
   Enumeration Keys();

    /***
     * Returns an enumeration of the values in this hashtable. Use the Enumeration methods on the returned objectto fetch the elements sequentially.
     * @return an enumeration of the values in this hashtable
     */
   Enumeration elements();

    /***
     * Tests if some key maps into the specified value in this hashtable. This operation is more expensive than thecontainsKey method.
     * @param value - a value to search for
     * @return true if some key maps to thevalue argument in this hashtable;false otherwise.
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
     * @return the value to which the key is mapped in this hashtable;null if the key is not mapped to anyvalue in this hashtable.
     */
   Object get (Object key);

    /***
     * Maps the specifiedkey to the specifiedvalue in this hashtable. Neither the key nor the value can benull.
     * @param key - the hashtable key
     * @param value - the value
     * @return the previous value of the specified key in this hashtable, ornull if it did not have one.
     * @throws NullPointerException - if the key value is null
     */
   Object put (Object key, Object value);

    /***
     * Removes the key (and its corresponding value) from this hashtable. This method does nothing if the key isnot in the hashtable.
     * @param key - the key that need to be removed.
     * @return the value to which the key had been mapped in this hashtable, ornull if the key did not have amapping.
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
