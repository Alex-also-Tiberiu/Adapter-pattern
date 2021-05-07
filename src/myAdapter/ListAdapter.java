package myAdapter;

import java.util.Iterator;
import java.util.NoSuchElementException;

public class ListAdapter implements HList {
    private VectorAdaptee v;

    public ListAdapter() {
        v = new VectorAdaptee();
    }

    public ListAdapter(int rows) {
        v = new VectorAdaptee(rows);
    }

    @Override
    public void add(int index, Object element) {
        if(element.equals(null))
            throw new NullPointerException("null Object is not allowed");
        if(index < 0 || index > size())
            throw  new IndexOutOfBoundsException("you can do better");
        v.insertElementAt(element,index);
    }

    @Override
    public boolean add(Object o) {
        if(o.equals(null))
            throw new NullPointerException("null Object is not allowed");
        else {
            v.addElement(o);
            return true;
        }
    }

    @Override
    public boolean addAll(HCollection c) {
        if(c.equals(null))
            throw new NullPointerException("null Collection is not allowed");

        HIterator h = c.iterator();
        /*
        devo usare un iteratore per scandire la list e poi inserirla nel vector
         */

        if(!h.hasNext())
            return false;
        else {
            while (h.hasNext()) {
                if(h.next().equals(null))
                    throw new NullPointerException("null object of the collection is not allowed");
                else
                    v.addElement(h.next());
            }
            return true;
        }
    }

    @Override
    public boolean addAll(int index, HCollection c) {
        if(index < 0 || index > size())
            throw new IndexOutOfBoundsException("select a different index to add the elements");
        if(c.equals(null))
            throw new NullPointerException("null Collection is not allowed");
        HIterator h = c.iterator();
        if(!h.hasNext())
            return false;
        else {
            while( h.hasNext() ) {
                if(h.next().equals(null))
                    throw new NullPointerException("null object of the Collection is not allowed");
                else
                    v.insertElementAt(h.next(),index++);
            }
            return true;
        }
    }

    @Override
    public void clear() {
        int count = 0;
        while(count++ < size())
            v.setElementAt(null,count);
    }

    @Override
    public boolean contains(Object o) {
        if (o.equals(null))
            throw new NullPointerException("the list does not support to contain null elements");
        ListIteratorr h = listIterator();
        while(h.hasNext()) {
            if (h.next().equals(o))
                return true;
            else
                h.next();
        }
        return false;
    }

    @Override
    public boolean containsAll(HCollection c) {
        if(c.equals(null))
            throw new NullPointerException("null HCollection is not allowed");
        HIterator h = c.iterator();
        int count = 0;
        while(h.hasNext()) {
            if(contains(h.next()))
                count++;
            else
                break;
        }
        return count == c.size();
    }

    @Override
    public boolean equals(Object o){
        if(!(o instanceof ListAdapter))
            return false;
        ListIteratorr h1 = listIterator();
        ListIteratorr h2 = new ListIteratorr((ListAdapter) o);
        while(h1.hasNext() && h2.hasNext()) {
            if(h1.next().equals(h2.next())) {
                h1.next();
                h2.next();
            }
            else
                return false;
        }
        if(h1.hasNext() || h2.hasNext())
            return false;
        else
            return true;
    }

    @Override
    public Object get(int index) {
        return v.indexOf(index);
    }

    @Override
    public int hashCode() {
        int hashCode = 1;
        HIterator i = iterator();
        while (i.hasNext()) {
            Object obj = i.next();
            hashCode = 31*hashCode + (obj==null ? 0 : obj.hashCode());
        }
        return hashCode;
    }

    @Override
    public int indexOf(Object o) {
        return v.indexOf(o);
    }

    @Override
    public boolean isEmpty() {
        return v.isEmpty();
    }

    @Override
    public Iteratorr iterator() {
        return new Iteratorr();
    }

    @Override
    public int lastIndexOf(Object o) {
        return v.lastIndexOf(o);
    }

    @Override
    public ListIteratorr listIterator() {
        return new ListIteratorr();
    }

    @Override
    public ListIteratorr listIterator(int index) {
        if(index < 0 || index >= size())
            throw new IndexOutOfBoundsException("It was introduced an invalid index");

        return new ListIteratorr(index);
    }

    @Override
    public Object remove(int index) {
        if(index < 0 || index >= size())
            throw new IndexOutOfBoundsException("It was introduced an invalid index");
        Object give = v.elementAt(index);
        v.removeElementAt(index);
        return give;
    }

    @Override
    public boolean remove(Object o) {
        if(o.equals(null))
            throw  new NullPointerException("Null object is not allowed");
        return v.removeElement(o);
    }

    @Override
    public boolean removeAll(HCollection c) {
        if(c.equals(null))
            throw new NullPointerException("null HCollection is not allowed");
        HIterator h = iterator();
        if( !h.hasNext() )
            return false;
        else {
            boolean set = false;
            while( h.hasNext() ){
                if( v.removeElement(h.next()) ) {
                    h.next();
                    set = true;
                }
                else if(h.next().equals(null))
                    throw new NullPointerException("null element detected in the HCollection");
                else
                    h.next();
            }
            return set;
        }
    }

    @Override
    public boolean retainAll(HCollection c) {
        if(c.equals(null))
            throw new NullPointerException("null HCollection is not allowed");
        HIterator h = iterator();
        if( !h.hasNext() )
            return false;
        else {
            boolean set = false;
            VectorAdaptee w = new VectorAdaptee();
            while(h.hasNext()) {
                if(v.contains(h.next())) {
                    w.addElement(h.next());
                    set = true;
                }
                else if(h.next().equals(null))
                    throw new NullPointerException("null element detected in the HCollection");
                else
                    h.next();
            }
            if(set)
                v = w;
            return set;
        }
    }

    @Override
    public Object set(int index, Object element) {
        if(index < 0 || index >= size())
            throw new IndexOutOfBoundsException("index not valid");
        if(element.equals(null))
            throw new NullPointerException("null element is not allowed");

        Object give = v.elementAt(index);
        v.setElementAt(element,index);
        return give;
    }

    @Override
    public int size() {
        return v.size();
    }

    @Override
    public HList subList(int fromIndex, int toIndex) {
        if( fromIndex < 0 || toIndex > size() || fromIndex > toIndex)
            throw new IndexOutOfBoundsException("fromIndex and toIndex are wrong, insert two index allowed");
        ListAdapter l = new ListAdapter();
        if(fromIndex == toIndex)
            return l;
        l = new ListAdapter(size());
        int count = 0;
        Object set = null;
        while(fromIndex < toIndex) {
            set = this.get(fromIndex++);
            l.set(count++,set);
        }
        return l;
    }

    @Override
    public Object[] toArray() {
        Object[] a = new Object[size()];
        if(isEmpty()) { }
        else {
            ListIteratorr h = listIterator();
            int ia = 0;
            while(h.hasNext()){
                a[ia++] = h.next();
            }
        }
        return a;
    }

    @Override
    public Object[] toArray(Object[] a) {
        if (!(a instanceof Object))
            throw new ArrayStoreException("invalis supertype of array");
        if(a == null)
            throw new NullPointerException("null array is not allowed");
        if(a.length < size())
            a = new Object[size()];
        ListIteratorr h = listIterator();
        int ia = 0;
        while(h.hasNext()) {
            a[ia++] = h.next();
        }
        return a;
    }


    /***
     * Internal Class that implements HListIterator
     */
    public class ListIteratorr implements HListIterator {
        private int place;
        private VectorAdaptee w;
        private boolean next;
        private boolean prev;

        private ListIteratorr() {
            place = 0;
            next = false;
            prev = false;
            w = v;
        }

        private ListIteratorr( ListAdapter l ) {
            place = 0;
            next = false;
            prev = false;
            w = l.v;
        }

        private ListIteratorr( int index) {
            place = index;
            next = false;
            prev = false;
            w = v;
        }

        /*
        deve aggiungere correttamente nella posizione dove punta l'iteratore
         */
        @Override
        public void add(Object o) {
            if(o.equals(null))
                throw new NullPointerException("Null value is not accepted");
            w.insertElementAt(o, place);
        }

        /*
        deve dirmi correttamente se ha un elemento successivo
         */
        @Override
        public boolean hasNext() {
            if(place < w.size()) {
                return true;
            }
            else
                return false;
        }

        /*
        deve dirmi correttamente se ha un elemento precedente
         */
        @Override
        public boolean hasPrevious() {
            if(place > 0) {
                return true;
            }
            else
                return false;
        }

        /*
           deve restituirmi l'elemento successivo
         */
        @Override
        public Object next() {
            if (hasNext()) {
                next = true;
                prev = false;
                return w.elementAt(place++);
            }
            else
                throw new NoSuchElementException("Iterator come to the end");
        }

        /*
        deve restituirmi l'indice successivo
         */
        @Override
        public int nextIndex() {
            return place;
        }

        /*
        deve restituirmi l'elemento precedente
         */
        @Override
        public Object previous() {
            if (hasPrevious()) {
                next = false;
                prev = true;
                return w.elementAt(--place);
            }
            else
                throw  new NoSuchElementException("Iterator come to the beginning");
        }

        /*
        deve restituirmi l'indice precedente a quello che punta l'iteratore
         */
        @Override
        public int previousIndex() {
            return place - 1;
        }

        /*
        deve eliminare l'ultimo elemento chiamato da next o prev
         */
        @Override
        public void remove() {
            if(place > 0 && place < size()) {
                if(next) {
                    v.removeElementAt(--place);
                }
                else if(prev) {
                    v.removeElementAt(place);
                }
            }
            else
                throw new IllegalArgumentException("Iterator didn't call next or previous");
        }

        /*
        deve sostituire l'ultimo elemento chiamato da next o da prev
         */
        @Override
        public void set(Object o) {
            if(place >= 0 && place < w.size()) {
                if (next)
                    v.setElementAt(o, place - 1);
                else if (prev)
                    v.setElementAt(o, place);
            }
        }

    }


    /***
     * internal class that implements HIterator
     */

    private class Iteratorr implements HIterator {
        private int place;
        private VectorAdaptee w;
        private boolean ok;

        private Iteratorr() {
            w = v;
            place = 0;
        }

        @Override
        public boolean hasNext() {
            if( place < w.size() ){
                ok = true;
                return true;
            }
            else
                return false;
        }

        @Override
        public Object next() {
            return w.elementAt(place++);
        }

        @Override
        public void remove() {
            if(ok) {
                ok = false;
                w.removeElementAt(place);
            }
            else
                throw new IllegalArgumentException("  \"Has next\"  wasn't call");
        }
    }

}