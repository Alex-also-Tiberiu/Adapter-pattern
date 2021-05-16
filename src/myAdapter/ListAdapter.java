package myAdapter;
import java.util.Enumeration;
import java.util.NoSuchElementException;

/***
 * public class List <br> implements
 * @see HList,
 * @see HIterator,
 * @see HListIterator, <br>
 * Public class ListAdapter, which realizes the List interface Java library 1.4.2.<br>
 * The class was implemented with the Vectoradaptee that mimics the vector behavior of the version of java cldc 1.1. <br>
 * The structure of Listadapter is based on a vector, but maintains the behavior of a list. consequently the class respects the Hlist interface. <br>
 * <b>Note this : </b> if the list change the size when an iterator is initialized on it, the iterator will restart from the beginning of the list.<br>
 *
 */

public class ListAdapter implements HList {
    private VectorAdaptee v;

    /***
     * Creates a new scrolling list.
     */
    public ListAdapter() {
        v = new VectorAdaptee();
    }

    /***
     * Creates a new scrolling list initialized with the specified number of rows.
     * @param rows the number of items to show.
     */
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
        if(!(c instanceof ListAdapter))
            throw new ClassCastException("Different HCollection that are not implemented by ListAdapter are not allowed");
        HIterator h = c.iterator();

        if(!h.hasNext())
            return false;
        else {
            while (h.hasNext()) {
                Object obj = h.next();
                if(obj.equals(null))
                    throw new NullPointerException("null element is not allowed");
                else
                    v.addElement(obj);
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
        if(!(c instanceof ListAdapter))
            throw new ClassCastException("Different HCollection that are not implemented by ListAdapter are not allowed");
        HIterator h = c.iterator();
        if(!h.hasNext())
            return false;
        else {
            while( h.hasNext() ) {
                Object obj = h.next();
                if(obj.equals(null))
                    throw new NullPointerException("null element is not allowed");
                else
                    v.insertElementAt(obj,index++);
            }
            return true;
        }
    }

    @Override
    public void clear() {
        while(!v.isEmpty()) {
            v.removeElementAt(0);
        }
    }

    @Override
    public boolean contains(Object o) {
        if (o.equals(null))
            throw new NullPointerException("the list does not support to contain null elements");
        ListIteratorr h = listIterator();
        while(h.hasNext()) {
            Object obj = h.next();
            if (obj.equals(o))
                return true;
        }
        return false;
    }

    @Override
    public boolean containsAll(HCollection c) {
        if(c.equals(null))
            throw new NullPointerException("null HCollection is not allowed");
        if(c.size() > size())
            return false;

        int coincidence = 0;
        HIterator h = c.iterator();
        while (h.hasNext()) {
            Object obj = h.next();
            if (obj.equals(null))
                throw new NullPointerException("null HCollection is not allowed");
            else if (contains(obj))
                coincidence++;
            }
        return coincidence == c.size();
    }

    @Override
    public boolean equals(Object o){
        if(!(o instanceof ListAdapter))
            return false;
        ListIteratorr h1 = listIterator();
        ListIteratorr h2 = new ListIteratorr((ListAdapter) o);
        while(h1.hasNext() && h2.hasNext()) {
            Object obj1 = h1.next();
            Object obj2 = h2.next();
            if(obj1.equals(obj2)) {
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
        return v.elementAt(index);
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
        if(o.equals(null))
            throw new NullPointerException("null object is not allowed");
        return v.indexOf(o);
    }

    @Override
    public boolean isEmpty() {
        return v.isEmpty();
    }

    @Override
    public HIterator iterator() {
        return new Iteratorr(this.v);
    }

    @Override
    public int lastIndexOf(Object o) {
        if(o.equals(null))
            throw new NullPointerException("null element is not allowed");
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
        HIterator h = c.iterator();
        if( !h.hasNext() )
            return false;
        else {
            boolean set = false;
            while( h.hasNext() ){
                Object obj = h.next();
                if(obj.equals(null))
                    throw new NullPointerException("null element detected in the HCollection");
                else if( v.removeElement(obj) ) {
                    set = true;
                }
            }
            return set;
        }
    }

    @Override
    public boolean retainAll(HCollection c) {
        if(c.equals(null))
            throw new NullPointerException("null HCollection is not allowed");
        HIterator h = c.iterator();
        if( !h.hasNext() )
            return false;
        else {
            boolean set = false;
            VectorAdaptee w = new VectorAdaptee();
            while(h.hasNext()) {
                Object obj = h.next();
                if(obj.equals(null))
                    throw new NullPointerException("null element detected in the HCollection");
                else if(v.contains(obj)) {
                    w.addElement(obj);
                    set = true;
                }
            }
            if(set)
                v = w;
            return set;
        }
    }

    @Override
    public Object set(int index, Object element) {
        if(index < 0 || index >= size() )
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
        if(a.equals(null))
            throw new NullPointerException("null array is not allowed");
        if (!(a instanceof Object))
            throw new ArrayStoreException("invalid supertype of array");
        if(a.length < size())
            a = new Object[size()];
        ListIteratorr h = listIterator();
        int ia = 0;
        while(h.hasNext()) {
            a[ia++] = h.next();
        }
        while(ia < a.length)
            a[ia++] = null;
        return a;
    }

    @Override
    public HList subList(int fromIndex, int toIndex) {
        subListRangeCheck(fromIndex, toIndex, this.size());
        return new SmallerList(this.v, fromIndex, toIndex);
    }

    private static void subListRangeCheck(int fromIndex, int toIndex, int size) {
        if (fromIndex < 0)
            throw new IndexOutOfBoundsException("fromIndex = " + fromIndex);
        if (toIndex >= size +1 )
            throw new IndexOutOfBoundsException("toIndex = " + toIndex);
        if (fromIndex > toIndex)
            throw new IllegalArgumentException("fromIndex(" + fromIndex +
                    ") > toIndex(" + toIndex + ")");
    }


    /***
     * Private internal class that support sublist
     */
    private class SmallerList extends ListAdapter {

        VectorAdaptee w;
        int startPosition = 0;
        int endPosition = 0;

        private SmallerList(VectorAdaptee x, int startPosition, int endPosition){
            w = x;
            this.startPosition = startPosition;
            this.endPosition = endPosition-1;
        }

        public void add(int index, Object object){
            if(index < 0 || index  > size())
                throw new IndexOutOfBoundsException("select a lower index");
            if(object.equals(null))
                throw new NullPointerException("null object is not allowed");
            w.insertElementAt(object,index+startPosition);
            endPosition++;
        }

        public boolean add(Object o) {
            if(o.equals(null))
                throw new NullPointerException("null Object is not allowed");
            w.insertElementAt(o,endPosition++);
            return true;
        }

        public boolean addAll(HCollection c) {
            if(c.equals(null))
                throw new NullPointerException("null Collection is not allowed");
            if(!(c instanceof ListAdapter))
                throw new ClassCastException("Different HCollection that are not implemented by ListAdapter are not allowed");
            HIterator h = c.iterator();

            if(!h.hasNext())
                return false;
            else {
                while (h.hasNext()) {
                    Object obj = h.next();
                    if(obj.equals(null))
                        throw new NullPointerException("null element is not allowed");
                    else {
                        add(obj);
                    }
                }
                return true;
            }
        }

        public boolean addAll(int index, HCollection c) {
            if(index < 0 || index > size())
                throw new IndexOutOfBoundsException("select a different index to add the elements");
            if(c.equals(null))
                throw new NullPointerException("null Collection is not allowed");
            if(!(c instanceof ListAdapter))
                throw new ClassCastException("Different HCollection that are not implemented by ListAdapter are not allowed");
            HIterator h = c.iterator();
            if(!h.hasNext())
                return false;
            else {
                while( h.hasNext() ) {
                    Object obj = h.next();
                    if(obj.equals(null))
                        throw new NullPointerException("null element is not allowed");
                    else {
                        add(index++, obj);
                    }
                }
                return true;
            }
        }

        public void clear() {
            for(int i = startPosition; i <= endPosition; i++) {
                w.removeElementAt(startPosition);
            }
        }

        public boolean contains (Object object){
            if(object.equals(null))
                throw new NullPointerException("null object is not allowed");
            for (int i = startPosition; i <= endPosition ; i++){
                if (w.elementAt(i).equals(object)){
                    return true;
                }
            }
            return false;
        }

        public boolean containsAll(HCollection c) {
            if(c.equals(null))
                throw new NullPointerException("null HCollection is not allowed");
            if(!(c instanceof ListAdapter))
                throw new ClassCastException("ListAdapter object is required");
            if(c.size() > size())
                return false;

            HIterator h = c.iterator();
            while (h.hasNext()) {
                Object obj = h.next();
                if (obj.equals(null))
                    throw new NullPointerException("null HCollection is not allowed");
                else if (!contains(obj))
                    return false;
            }
            return true;
        }

        public boolean equals(Object o){
            if(!(o instanceof ListAdapter))
                return false;
            if(o == null)
                return false;
            SmallerList s = (SmallerList)o;
            IteratorSub h1 = iterator();
            IteratorSub h2 = s.iterator();
            while(h1.hasNext() && h2.hasNext()) {
                    Object obj1 = h1.next();
                    Object obj2 = h2.next();
                    if(!obj1.equals(obj2))
                        return false;
                }
            if(h1.hasNext() || h2.hasNext())
                return false;
            else
                return true;
        }

        public Object get(int index) {
            if(index < 0 || index > size())
                throw new IndexOutOfBoundsException("select a lower index");
            return w.elementAt(startPosition + index);
        }

        public IteratorSub iterator() {
            return new IteratorSub(w,startPosition,endPosition);
        }

        public ListIteratorr listIterator() {
            return new ListIteratorr(w,startPosition,endPosition);
        }

        public ListIteratorr listIterator(int index) {
            if(index < 0 || index >= size())
                throw new IndexOutOfBoundsException("It was introduced an invalid index");

            return new ListIteratorr(w,index,startPosition,endPosition);
        }

        public int hashCode() {
            int hashCode = 1;
            HIterator i = iterator();
            while (i.hasNext()) {
                Object obj = i.next();
                hashCode = 31*hashCode + (obj==null ? 0 : obj.hashCode());
            }
            return hashCode;
        }

        public int indexOf(Object o) {
            if(o.equals(null))
                throw new NullPointerException("null object is not allowed");
            int i = w.indexOf(o,startPosition);
            if( i <endPosition)
                return  i - startPosition;
            else
                return -1;
        }

        public boolean isEmpty() {
            return startPosition > endPosition  ;
        }

        public int lastIndexOf(Object o) {
            if(o.equals(null))
                throw new NullPointerException("null element is not allowed");
            int i = w.lastIndexOf(o,startPosition);
            if( i < endPosition)
                return i - startPosition;
            else
                return -1;
        }

        public Object remove(int index) {
            if(index < 0 || index >= size())
                throw new IndexOutOfBoundsException("It was introduced an invalid index");
            Object give = w.elementAt(index + startPosition);
            w.removeElementAt(index);
            endPosition--;
            return give;
        }

        public boolean remove(Object o) {
            if(o.equals(null))
                throw  new NullPointerException("Null object is not allowed");
            if( w.indexOf(o) < 0  )
                return false;
            boolean set = false;
            if(w.indexOf(o) > startPosition && w.indexOf(o) <= endPosition) {
                w.removeElement(o);
                set = true;
                endPosition--;
            }
            return set;
        }

        public boolean removeAll(HCollection c) {
            if(c.equals(null))
                throw new NullPointerException("null HCollection is not allowed");
            if(! (c instanceof ListAdapter))
                throw new ClassCastException("ListAdapter object is required");
            HIterator h = c.iterator();
            if( !h.hasNext() )
                return false;
            else {
                boolean set = false;
                while( h.hasNext() ){
                    Object obj = h.next();
                    if(obj.equals(null))
                        throw new NullPointerException("null element detected in the HCollection");
                    else if( remove(obj) )
                        set = true;
                }
                return set;
            }
        }

        public boolean retainAll(HCollection c) {
            if(c.equals(null))
                throw new NullPointerException("null HCollection is not allowed");
            if(!(c instanceof ListAdapter))
                throw new ClassCastException("ListAdapter object is required");
            HIterator h;
            boolean set = false;
            if(c.size() > size()) {
                h = (IteratorSub) c.iterator();
                if (!h.hasNext())
                    return false;
                else {
                    while (h.hasNext()) {
                        Object obj = h.next();
                        if (obj.equals(null))
                            throw new NullPointerException("null element detected in the HCollection");
                        else if (!contains(obj)) {
                            remove(obj);
                            set = true;
                        }
                    }
                }
            }
            else {
                h = (IteratorSub) iterator();
                if (!h.hasNext())
                    return false;
                else {
                    while (h.hasNext()) {
                        Object obj = h.next();
                        if (!c.contains(obj)) {
                            remove(obj);
                            set = true;
                        }
                    }
                }
            }
                return set;
        }


        public Object set(int index, Object element) {
            if(index < 0 || index > size() )
                throw new IndexOutOfBoundsException("index not valid");
            if(element.equals(null))
                throw new NullPointerException("null element is not allowed");

            Object give = w.elementAt(index + startPosition);
            w.setElementAt(element,index + startPosition);
            return give;
        }

        public int size(){
            return (endPosition + 1) -startPosition;
        }


        public Object[] toArray() {
            Object[] a = new Object[size()];
            if (!isEmpty()) {
                IteratorSub h = iterator();
                int ia = 0;
                while (h.hasNext()) {
                    a[ia++] = h.next();
                }
            }
            return a;
        }

        public Object[] toArray(Object[] a) {
            if(a.equals(null))
                throw new NullPointerException("null array is not allowed");
            if(a.length < size())
                a = new Object[size()];
            IteratorSub h = iterator();
            int ia = 0;
            while(h.hasNext()) {
                a[ia++] = h.next();
            }
            while(ia < a.length)
                a[ia++] = null;
            return a;
        }

        private class IteratorSub implements HIterator {
            private int place;
            private int to;
            private int oldSize;
            private VectorAdaptee w;
            private boolean ok;


            private IteratorSub( VectorAdaptee x, int from, int to) {
                place = from;
                this.to = to;
                oldSize = to;
                w = x;
            }

            @Override
            public boolean hasNext() {
                if(oldSize != endPosition ) {
                    place = startPosition;
                    to = endPosition ;
                }
                if( place <= to ){
                    ok = true;
                    return true;
                }
                else
                    return false;
            }

            @Override
            public Object next() {
                if(hasNext()) {
                    Object give = w.elementAt(place);
                    place++;
                    return give;
                }
                else
                    throw new NoSuchElementException("Iterator come to the end");
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


    /***
     * Internal Class that implements HListIterator
     */
    private class ListIteratorr implements HListIterator {
        private int place;
        private int start;
        private int to;
        private VectorAdaptee w;
        private boolean next;
        private boolean prev;
        private boolean stopset = true;

        private ListIteratorr() {
            place = start = 0;
            to = v.size();
            next = false;
            prev = false;
            w = v;
        }

        private ListIteratorr( ListAdapter l ) {
            place = start = 0;
            to = l.size();
            next = false;
            prev = false;
            w = l.v;
        }

        private ListIteratorr( int index) {
            place = index;
            start = 0;
            to = v.size();
            next = false;
            prev = false;
            w = v;
        }

        /*
        This is the constructor for an iterator of sublist
         */
        private ListIteratorr( VectorAdaptee x, int from, int to) {
            place = from;
            start = from;
            this.to = to;
            next = false;
            prev = false;
            w = x;
        }

        private ListIteratorr( VectorAdaptee x,int index, int from, int to) {
            place = index + from;
            start = from;
            this.to = to;
            next = false;
            prev = false;
            w = x;
        }


        /*
        deve aggiungere correttamente nella posizione dove punta l'iteratore
         */
        @Override
        public void add(Object o) {
            if(o.equals(null))
                throw new NullPointerException("Null value is not accepted");
            w.insertElementAt(o, place);
            stopset = true;
        }

        /*
        deve dirmi correttamente se ha un elemento successivo
         */
        @Override
        public boolean hasNext() {
            if(to != size()) {
                to = w.size();
                place = start;
            }
            if(place < to) {
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
            if(to != size()) {
                to = w.size();
                place = start;
            }
            if(place > start) {
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
                stopset = false;
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
            if(to != size()) {
                to = w.size();
                place = start;
            }
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
                stopset = false;
                return w.elementAt(--place);
            }
            else
                throw  new NoSuchElementException("Iterator has no previous element");
        }

        /*
        deve restituirmi l'indice precedente a quello che punta l'iteratore
         */
        @Override
        public int previousIndex() {
            if(to != size()) {
                to = w.size();
                place = start;
            }
            if(place > start)
                return (place - 1);
            else
                return -1;
        }

        /*
        deve eliminare l'ultimo elemento chiamato da next o prev
         */
        @Override
        public void remove() {
            if(place > start && place < to) {
                if(next) {
                    stopset = true;
                    w.removeElementAt(--place);
                }
                else if(prev) {
                    stopset = true;
                    w.removeElementAt(place);
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
            if(stopset)
                throw  new IllegalStateException("next() or previous() was not called");
            if(place >= start && place <= to) {
                if (next)
                    w.setElementAt(o, place - 1);
                else if (prev)
                    w.setElementAt(o, place);
            }
            else
                throw new IllegalArgumentException("Iterator didn't call next or previous");
        }

    }




    /***
     * internal class that implements HIterator
     */

    private class Iteratorr implements HIterator {
        private VectorAdaptee w;
        private boolean ok;
        public Enumeration enumer;
        public Object lastElement;

        public Iteratorr(VectorAdaptee x) {
            w = x;
            enumer = w.elements();
        }


        @Override
        public boolean hasNext() {
            if(enumer.hasMoreElements())
                return ok = true;
            else
                return false;
        }

        @Override
        public Object next() {
            if(!enumer.hasMoreElements())
                throw new NoSuchElementException("no more elements");
            return enumer.nextElement();
        }

        @Override
        public void remove() {
            if(ok) {
                ok = false;
                w.removeElement(lastElement);
            }
            else
                throw new IllegalArgumentException("  \"Has next\"  wasn't call");
        }
    }



}