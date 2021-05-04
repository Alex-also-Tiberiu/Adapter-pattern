
package myAdapter;

import java.util.Enumeration;
import java.util.Vector;

public class VectorAdaptee implements HVector {

    /***
     * The amount by which the capacity of the vector is automatically incremented when its size becomes
     * greater than its capacity. If the capacity increment is 0, the capacity of the vector is doubled
     * each time it needs to grow.
     */
    protected int capacityIncrement;
    /***
     * The number of valid components in the vector.
     */
    protected int elementCount;

    /***
     * The array buffer into which the components of the vector are stored.
     * The capacity of the vector is the length of this array buffer.
     */
    protected Object[] elementData;

    /***
     * Constructs an empty vector.
     */
    public VectorAdaptee() {
        elementData = new Object[1];
        capacityIncrement = 0;
        elementCount = 0;
    }

    /***
     * Constructs an empty vector with the specified initial capacity.
     * @param initialCapacity - the initial capacity of the vector.
     */
    public VectorAdaptee(int initialCapacity) {
        elementData = new Object[initialCapacity];
        capacityIncrement = 0;
        elementCount = 0;
    }

    /***
     * Constructs an empty vector with the specified initial capacity and capacity increment.
     * @param initialCapacity - the initial capacity of the vector.
     * @param capacityIncrement - the amount by which the capacity is increased when the vector overflows.
     * @throws  IllegalArgumentException - if the specified initial capacity is negative
     */
    public VectorAdaptee(int initialCapacity, int capacityIncrement) {
        elementData = new Object[initialCapacity];
        this.capacityIncrement = capacityIncrement;
        elementCount = 0;
    }

    /*
        in questo caso un possibile errore sarebbe che l'array non è abbastanza grande per contenere tutti
        gli elementi del vettore.
        il tipo di dati dell'array potrebbe essere incompatibile se uso un array di un tipo diverso? vedremo con un test.
     */
    @Override
    public void copyInto(Object[] anArray) {
        for(int i = 0 ; i < elementCount ; i++ ) {
            anArray[i] = elementData[i];
        }
    }

    @Override
    public void trimToSize() {
        Object[] a = new Object[elementCount - 1];
        for(int i = 0; i < elementCount; i++) {
            a[i] = elementData[i];
        }
        elementData = a;
    }

    @Override
    public void ensureCapacity(int minCapacity) {

    }

    @Override
    public void setSize(int newSize) {

    }

    @Override
    public int capacity() {
        return 0;
    }

    @Override
    public int size() {
        return 0;
    }

    @Override
    public boolean isEmpty() {
        return false;
    }

    @Override
    public Enumeration elements() {
        return null;
    }

    @Override
    public boolean contains(Object element) {
        return false;
    }

    @Override
    public int indexOf(Object element) {
        return 0;
    }

    @Override
    public int indexOf(Object elem, int index) {
        return 0;
    }

    @Override
    public int lastIndexOf(Object elem) {
        return 0;
    }

    @Override
    public int lastIndexOf(Object elem, int index) {
        return 0;
    }

    @Override
    public Object elementAt(int index) {
        return null;
    }

    @Override
    public Object firstElement() {
        return null;
    }

    @Override
    public Object lastElement() {
        return null;
    }

    @Override
    public void setElementAt(Object obj, int index) {

    }

    @Override
    public void removeElementAt(int index) {

    }

    @Override
    public void insertElementAt(Object obj, int index) {

    }

    @Override
    public void addElement(Object obj) {

    }

    @Override
    public boolean removeElement(Object obj) {
        return false;
    }

    @Override
    public void removeAllElements() {

    }
}
