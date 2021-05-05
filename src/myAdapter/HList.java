package myAdapter;

/**
 * The interface H list.
 */
/*
 * List dovrebbe estendere Collection, vedere se è necessario aggiungere
 * delle classi per implementare collection oppure no.
 */
public interface HList {

    /***
     * Inserts the specified element at the specified position in this list
     * @param index the index
     * @param element the element
     */
    void add(int index, Object element);

    /***
     * return false if the Object introduced is null.
     * Appends the specified element to the end of this list.
     *
     * @param o the o
     * @return boolean
     */
    boolean add(Object o);

    /***
     * appends all of the elements in the specified collection to the end
     * of this list, in the order that they are returned by the specified
     * collection's iterator
     * @param c - collection whose elements are to be added to this list.
     * @return boolean
     */
    boolean addAll(HCollection c);

    /***
     * Inserts all of the elements in the specified collection into this list at the specified position
     * @param index the index
     * @param c the c
     * @return boolean
     */
    boolean addAll(int index, HCollection c);

    /***
     * Removes all of the elements from this list
     */
    void clear();

    /***
     *
     * @param o the o
     * @return Returns true if this list contains the specified element
     */
    boolean contains(Object o);

    /***
     *
     * @param c the c
     * @return Returns true if this list contains all of the elements of the specified collection
     */
    boolean containsAll(HCollection c);

    /***
     * Compares the specified object with this list for equality
     * @param o
     * @return
     */
    boolean equals(Object o);

    /***
     *
     * @param index the index
     * @return Returns the element at the specified position in this list
     */
    Object get(int index);

    /***
     *
     * @return Returns the hash code value for this list
     */
    int hashCode();

    /***
     *
     * @param o the o
     * @return Returns the index in this list of the first occurrence          of the specified element, or -1 if this list does not contain this element
     */
    int indexOf(Object o);

    /***
     *
     * @return Returns true if this list contains no elements
     */
    boolean isEmpty();

    /***
     *
     * @return Returns an iterator over the elements in this list in proper sequence
     */
    HIterator iterator();

    /***
     *
     * @param o the o
     * @return Returns the index in this list of the last occurrence of the specified         element, or -1 if this list does not contain this element
     */
    int lastIndexOf(Object o);

    /***
     *
     * @return Returns a list iterator of the elements in this list (in proper sequence)
     */
    HListIterator listIterator();

    /***
     *
     * @param index the index
     * @return Returns a list iterator of the elements in this list (in proper sequence),         starting at the specified position in this list
     */
    HListIterator listIterator(int index);

    /***
     * Removes the element at the specified position in this list (optional operation)
     * @param index the index
     * @return object
     */
    Object remove(int index);

    /***
     * Removes the first occurrence in this list of the specified element (optional operation)
     * @param o the o
     * @return boolean
     */
    boolean remove(Object o);

    /***
     * Removes from this list all the elements that are contained in the specified collection (optional operation)
     * @param c the c
     * @return boolean
     */
    boolean removeAll(HCollection c);

    /***
     * Retains only the elements in this list that are contained in
     * the specified collection (optional operation)
     * @param c the c
     * @return boolean
     */
    boolean retainAll(HCollection c);

    /***
     * Replaces the element at the specified position in this list with the specified element (optional operation)
     * @param index the index
     * @param element the element
     * @return object
     */
    Object set(int index, Object element);

    /***
     *
     * @return Returns the number of elements in this list
     */
    int size();

    /***
     *
     * @param fromIndex the from index
     * @param toIndex the to index
     * @return Returns a view of the portion of this list between the specified fromIndex, inclusive, and toIndex, exclusive
     */
    ListAdapter sublist(int fromIndex, int toIndex);

    /***
     *
     * @return Returns an array containing all of the elements in this list in proper sequence
     */
    Object[] toArray();

    /***
     *
     * @param a
     * @return Returns an array containing all of the elements in
     *          this list in proper sequence; the runtime type of the returned array
     *          is that of the specified array
     */
    Object[] toArray(Object[] a);
}
