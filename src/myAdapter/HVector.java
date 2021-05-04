/**
 The VectorAdaptee class implements a growable array of objects. Like an array, it contains components that can be
 accessed using an integer index. However, the size of a Vector can grow or shrink as needed to accommodate
 adding and removing items after theVector has been created.
 Each vector tries to optimize storage management by maintaining a capacity and a capacity Increment.
 The capacity is always at least as large as the vector size; it is usually larger because as components are added
 to the vector, the vector’s storage increases in chunks the size of capacity Increment.
 An application can increase the capacity of a vector before inserting a large number of components;
 this reduces the amount of incremental reallocation.
 */


package myAdapter;

import java.util.Enumeration;
import java.util.NoSuchElementException;

public interface HVector {

    /***
     * Copies the components of this vector into the specified array. The array must be big enough to hold all the objects in this vector.
     * @param anArray - the array into which the components get copied.
     */
    void copyInto(Object[] anArray);

    /***
     * Trims the capacity of this vector to be the vector’s current size. An application can use this operation to minimize the storage of a vector.
     */
    void trimToSize();

    /***
     * Increases the capacity of this vector, if necessary, to ensure that it can hold at least the number of components specified by the minimum capacity argument.
     * @param minCapacity - the desired minimum capacity.
     */
    void ensureCapacity(int minCapacity);

    /***
     * Sets the size of this vector. If the new size is greater than the current size, new null items are added to the end of the vector.
     * If the new size is less than the current size, all components at index newSize and greater are discarded.
     * @param newSize - the new size of the vector
     * @throws IndexOutOfBoundsException - if the new size is negative.
     */
    void setSize(int newSize);

    /***
     * Returns the current capacity of this vector.
     * @return the current capacity of this vector.
     */
    int capacity();

    /***
     * Returns the number of components in this vector.
     * @return the number of components in this vector.
     */
    int size();

    /***
     * Tests if this vector has no components.
     * @return true if this vector has no components; false otherwise.
     */
    boolean isEmpty();

    /***
     * Return an enumeration of the components of this vector.
     * @return an enumeration of the components of this vector.
     */
    Enumeration elements();

    /***
     * Tests if the specified object is a component in this vector.
     * @param element - an object.
     * @return true if the specified object is a component in this vector;false otherwise.
     */
    boolean contains(Object element);

    /***
     * Searches for the first occurence of the given argument, testing for equality using the equals method.
     * @param element - an object.
     * @return the index of the first occurrence of the argument in this vector; returns-1 if the object is not found.
     */
    int indexOf(Object element);

    /***
     * Searches for the first occurence of the given argument, beginning the search at index, and testing for equality using the equals method.
     * @param elem - an object.
     * @param index - the index to start searching from.
     * @return the index of the first occurrence of the object argument in this vector at position index or later in the vector;
     *         returns-1 if the object is not found.
     */
    int indexOf(Object elem, int index);

    /***
     * Returns the index of the last occurrence of the specified object in this vector.
     * @param elem - the desired component.
     * @return the index of the last occurrence of the specified object in this vector; returns-1 if the object is not found.
     */
    int lastIndexOf(Object elem);

    /***
     * Searches backwards for the specified object, starting from the specified index, and returns an index to it.
     * @param elem - the desired component.
     * @param index - the index to start searching from.
     * @return the index of the last occurrence of the specified object in this vector at position less than index in the vector;
     *         returns -1 if the object is not found.
     * @throws IndexOutOfBoundsException - if the index is greater than or equal to the current size of this vector
     */
    int lastIndexOf(Object elem, int index);

    /***
     * Returns the component at the specified index.
     * @param index - an index into this vector.
     * @return the component at the specified index.
     * @throws  ArrayIndexOutOfBoundsException - if an invalid index was given.
     */
    Object elementAt(int index);

    /***
     * Returns the first component of this vector.
     * @return the first component of this vector.
     * @throws  NoSuchElementException - if this vector has no components.
     */
    Object firstElement();

    /***
     * Return the last component of the vector.
     * @return the last component of the vector, i.e., the component at index size() -1.
     * @throws NoSuchElementException - if this vector is empty.
     */
    Object lastElement();

    /***
     * Sets the component at the specified index of this vector to be the specified object. The previous
     * component at that position is discarded.
     * @param obj - what the component is to be set to.
     * @param index - the specified index.
     * @throws ArrayIndexOutOfBoundsException - if the index was invalid
     */
    void setElementAt(Object obj, int index);

    /***
     * Deletes the component at the specified index. Each component in this vector with an index greater or equal
     * to the specified index is shifted downward to have an index one smaller than the value it had previously.
     * The index must be a value greater than or equal to0 and less than the current size of the vector.
     * @param index the index of the object to remove.
     * @throws  ArrayIndexOutOfBoundsException - if the index was invalid.
     */
    void removeElementAt(int index);

    /***
     * Inserts the specified object as a component in this vector at the specified index.
     * Each component in this vector with an index greater or equal to the specified index is shifted upward to have
     * an index one greater than the value it had previously.The index must be a value greater than or equal to 0
     * and less than or equal to the current size of the vector.
     * @param obj - the component to insert.
     * @param index - where to insert the new component.
     * @throws ArrayIndexOutOfBoundsException - if the index was invalid.
     */
    void insertElementAt(Object obj, int index);

    /**
     * Adds the specified component to the end of this vector, increasing its size by one. The capacity of
     * this vector is increased if its size becomes greater than its capacity.
     * @param obj - the component to be added.
     */
    void addElement(Object obj);

    /***
     * Adds the specified component to the end of this vector, increasing its size by one.
     * The capacity of this vector is increased if its size becomes greater than its capacity.
     * @param obj - the component to be removed.
     * @return true if the argument was a component of this vector; false otherwise.
     */
    boolean removeElement(Object obj);

    /***
     * Removes all components from this vector and sets its size to zero.
     */
    void removeAllElements();

    /***
     * Returns a string representation of this vector.
     * @return a string representation of this vector.
     */
    String toString();
}
