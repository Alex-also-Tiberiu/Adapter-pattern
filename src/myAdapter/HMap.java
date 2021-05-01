package myAdapter;

import java.util.Collection;

public interface HMap {
    /***
     *
        Removes all mappings from this map (optional operation)
     */
    void clear();

    /***
     * Returns true if this map contains a mapping for the specified key.
     * More formally,returns true if and only if this map contains at a mapping
     * for a key k such that (key==null ? k==null : key.equals(k)).
     *  (There can be at most one such mapping.)
     *
     * @param key  - key whose presence in this map is to be tested
     * @return true if this map contains a mapping for the specified key
     * @throws ClassCastException,NullPointerException - if the key is of an inappropriate type for this map
     * - if the key is null and this map does not not permit null keys
     */
    boolean containsKey(Object key);

    /***
     * Returns true if this map maps one or more keys to the specified value.
     * More formally, returns true if and only if this map contains at least
     * one mapping to a value v such that (value==null ? v==null : value.equals(v)).
     * This operation will probably require time linear in the map size for most
     * implementations of the Map interface
     *
     * @param value -value whose presence in this map is to be tested
     * @return Returns true if this map maps one or more keys to the specified value
     * @throws ClassCastException,NullPointerException - if the value is of an inappropriate type fot this map.
     * -if the value is null and this map does not permit null values.
     */
    boolean containsValue(Object value);

    /***
     *
     * @return Returns a set view of the mappings contained in this map
     */
    HSet entrySet();

    /***
     * Compares the specified object with this map for equality.
     * Returns true if the given object is also a HMap and the two HMaps reppresent the sampe mappings.
     * @param o - object to be compared for equality with this map
     * @return true if the specified object is equal to this map
     */
    boolean equals(Object o);

    /***
     *
     * @param key
     * @return Returns the value to which this map maps the specified key
     */
    Object get(Object key);

    /***
     *
     * @return Returns the hash code value for this map
     */
    int hashCode();

    /***
     *
     * @return Returns true if this map contains no key-value mappings
     */
    boolean isEmpty();

    /***
     *
     * @return Returns a set view of the keys contained in this map
     */
    HSet keySet();

    /***
     * Associates the specified value with the specified key in this map (optional operation)
     * @param key
     * @param value
     * @return
     */
    Object put(Object key, Object value);

    /***
     * Copies all of the mappings from the specified map to this map (optional operation)
     * @param t
     */
    void putAll(HMap t);

    /***
     * Removes the mapping for this key from this map if it is present (optional operation)
     * @param key
     * @return
     */
    Object remove(Object key);

    /***
     *
     * @return Returns the number of key-value mappings in this map
     */
    int size();

    /***
     *
     * @return Returns a collection view of the values contained in this map
     */
    Collection values();
}
