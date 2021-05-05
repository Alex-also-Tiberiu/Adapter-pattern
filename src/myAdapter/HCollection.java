package myAdapter;

import java.util.Collection;

public interface HCollection {
    boolean add(Object o);

    boolean addAll(HCollection c);

    void clear();

    boolean contains(Object o);

    boolean containsAll(Object o);

    boolean equals(Object o);

    int hashCode();

    boolean isEmpty();

    HIterator iterator();

    boolean remove(Object o);

    boolean removeAll(HCollection c);

    boolean retainAll(HCollection c);

    int size();

    Object[] toArray();

    Object[] toArray(Object[] a);
}
