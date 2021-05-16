package myAdapter;

/***
 *  An iterator over a collection. Iterator takes the place of Enumeration in the Java collections framework. Iterators differ from enumerations in two ways: <br>
 *<br>
 *    - Iterators allow the caller to remove elements from the underlying collection during the iteration with well-defined semantics.<br>
 *    - Method names have been improved. <br>
 */

public interface HIterator {
    /**
     * Returns true if the iteration has more elements.<br>
     * (In other words, returns true if next would return an element rather than throwing an exception.)<br>
     * @return true if the iterator has more elements.<br>
     */
    boolean hasNext();

    /**
     * Returns the next element in the iteration.<br>
     * @return the next element in the iteration.<br>
     * @throws java.util.NoSuchElementException - iteration has no more elements.<br>
     */
    Object next();

    /**
     * Removes from the underlying collection the last element returned by the iterator (optional operation). This method can be called only once per call to next. The behavior of an iterator is unspecified if the underlying collection is modified while the iteration is in progress in any way other than by calling this method.<br>
     * @throws UnsupportedOperationException - if the remove operation is not supported by this Iterator.<br>
     * @throws IllegalStateException - if the next method has not yet been called, or the remove method has already been called after the last call to the next method.<br>
     */
    void remove();
}
