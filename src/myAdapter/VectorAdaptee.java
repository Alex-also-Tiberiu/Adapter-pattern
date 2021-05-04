package myAdapter;

import java.util.Collection;
import java.util.Enumeration;
import java.util.Vector;

public class VectorAdaptee implements HVector {
    Vector v;

    /***
     * Constructs an empty vector so that its internal data array has size 10 and its standard capacity increment is zero.
     */
    public VectorAdaptee() {
        v = new Vector();
    }

    /***
     * Constructs a vector containing the elements of the specified collection, in the order they are returned by the collection's iterator.
     * @param c - the collection whose elements are to be placed into this vector.
     */
    public VectorAdaptee(Collection c) {
        v = new Vector(c);
    }

    /***
     * Constructs an empty vector with the specified initial capacity and with its capacity increment equal to zero.
     * @param initialCapacity - the initial capacity.
     */
    public VectorAdaptee(int initialCapacity) {
        v = new Vector(initialCapacity);
    }

    /***
     * Constructs an empty vector with the specified initial capacity and capacity increment.
     * @param initialCapacity - the initial capacity of the vector.
     * @param capacityIncrement - the amount by which the capacity is increased when the vector overflows.
     */
    public VectorAdaptee(int initialCapacity, int capacityIncrement) {
        v = new Vector(initialCapacity,capacityIncrement);
    }

    @Override
    public void copyInto(Object[] anArray) {
        v.copyInto(anArray);
    }

    @Override
    public void trimToSize() {
        v.trimToSize();
    }

    @Override
    public void ensureCapacity(int minCapacity) {
        v.ensureCapacity(minCapacity);
    }

    @Override
    public void setSize(int newSize) {
        v.setSize(newSize);
    }

    @Override
    public int capacity() {
        return v.capacity();
    }

    @Override
    public int size() {
        return v.size();
    }

    @Override
    public boolean isEmpty() {
        return v.isEmpty();
    }

    @Override
    public Enumeration elements() {
        return v.elements();
    }

    @Override
    public boolean contains(Object element) {
        return v.contains(element);
    }

    @Override
    public int indexOf(Object element) {
        return v.indexOf(element);
    }

    @Override
    public int indexOf(Object elem, int index) {
        return v.indexOf(elem,index);
    }

    @Override
    public int lastIndexOf(Object elem) {
        return v.lastIndexOf(elem);
    }

    @Override
    public int lastIndexOf(Object elem, int index) {
        return v.lastIndexOf(elem,index);
    }

    @Override
    public Object elementAt(int index) {
        return v.elementAt(index);
    }

    @Override
    public Object firstElement() {
        return v.firstElement();
    }

    @Override
    public Object lastElement() {
        return v.lastElement();
    }

    @Override
    public void setElementAt(Object obj, int index) {
        v.setElementAt(obj,index);
    }

    @Override
    public void removeElementAt(int index) {
        v.removeElementAt(index);
    }

    @Override
    public void insertElementAt(Object obj, int index) {
        v.insertElementAt(obj,index);
    }

    @Override
    public void addElement(Object obj) {
        v.addElement(obj);
    }

    @Override
    public boolean removeElement(Object obj) {
        return v.removeElement(obj);
    }

    @Override
    public void removeAllElements() {
        v.removeAllElements();
    }
}
