package myAdapter;

import java.util.Enumeration;
import java.util.NoSuchElementException;

public class MapAdapter implements HMap {

    private HashtableAdaptee table;


    public MapAdapter() {
        table = new HashtableAdaptee();
    }

    public MapAdapter(int initialCapacity) {
        table = new HashtableAdaptee(initialCapacity);
    }

    @Override
    public void clear() { table.clear(); }

    @Override
    public boolean containsKey(Object key) {
        if(key.equals(null))
            throw new NullPointerException("null key is not allowed");
        return table.containsKey(key);
    }

    @Override
    public boolean containsValue(Object value) { return table.contains(value); }

    @Override
    public HSet entrySet() { return new EntrySet(table); }

    @Override
    public boolean equals(Object o){
        if(o.equals(null) || ! (o instanceof HMap))
            return false;
        MapAdapter m = (MapAdapter) o;
        EntrySet e1 = (EntrySet) m.keySet();
        EntrySet e2 = (EntrySet) this.keySet();
        Iterk iterk1 = (Iterk) e1.iterator();
        Iterk iterk2 = (Iterk) e2.iterator();
        while(iterk1.hasNext() && iterk2.hasNext()) {
            Object obj1 = iterk1.next();
            Object obj2 = iterk2.next();
            if(obj1.equals(obj2)) {
                if(table.get(obj1).equals(table.get(obj2))) {}
                else
                    return false;
            }
            else
                return false;
        }
        if(iterk1.hasNext() || iterk2.hasNext())
            return false;
        else
            return true;
    }

    @Override
    public Object get(Object key) {
        if(key.equals(null))
            throw new NullPointerException("null key is not allowed");
        return table.get(key);
    }

    @Override
    public int hashCode(){
        int ia = 0, ib = 0, ic = 0;
        Enumeration k = table.keys();
        Enumeration v = table.elements();
        while(k.hasMoreElements()) {
            ib = k.nextElement().hashCode();
            ic = v.nextElement().hashCode();
            ia += ib + ic;
        }
        return ia;
    }

    @Override
    public boolean isEmpty() { return table.isEmpty(); }

    @Override
    public HSet keySet() { return new SetKey(table); }

    @Override
    public Object put(Object key, Object value) {
        if(key.equals(null))
            throw new NullPointerException("null key is not allowed");
        Entry e = new Entry(key,value);
        return table.put(e.getKey(),e.getValue());
    }

    @Override
    public void putAll(HMap t) {
        if(!(t instanceof HMap))
            throw new ClassCastException("incompatible type");
        if(t.equals(null))
            throw new NullPointerException("null map is not allowed");
        MapAdapter m = (MapAdapter) t;
        Enumeration e = m.table.keys();
        Object obj;
        while(e.hasMoreElements()) {
            obj = e.nextElement();
            this.put(obj,table.get(obj));
        }
    }

    @Override
    public Object remove(Object key) {
        if(key.equals(null))
            throw new NullPointerException("null key is not allowed");
        return table.remove(key);
    }

    @Override
    public int size() { return table.size(); }

    @Override
    public HCollection values() { return new SetValue(table); }

    public static class Entry implements HEntry {

        private Object key,value;

        public Entry(Object key,Object value) {
            if(key.equals(null)||value.equals(null))
                throw new NullPointerException("null key/value is not allowed");
            this.key = key;
            this.value = value;
        }

        @Override
        public Object getKey() {
            return key;
        }

        @Override
        public Object getValue() {
            return value;
        }

        @Override
        public Object setValue(Object value) {
            if(value.equals(null))
                throw new NullPointerException("null value is not allowed");
            return this.value = value;
        }

        public boolean equals(Object o) {
            if (o ==  null) {
                throw new NullPointerException();
            }
            if (!(o instanceof Entry)) {
                return false;
            }
            Entry e = (Entry) o;
            if (e.getKey().equals(key) && e.getValue().equals(value)) {
                return true;
            }
            else {
                return false;
            }
        }

        @Override
        public int hashCode() {
            return key.hashCode() + value.hashCode();
        }
    }


    private class EntrySet implements HSet {

        private HashtableAdaptee tab;

        public EntrySet(HashtableAdaptee x) {
            tab = x;
        }

        @Override
        public boolean add(Object o) {
            throw new UnsupportedOperationException("add method in HSet is not allowed");
        }

        @Override
        public boolean addAll(HCollection c) {
            throw new UnsupportedOperationException("add method in HSet is not allowed");
        }

        @Override
        public void clear() {
            tab.clear();
        }

        @Override
        public boolean contains(Object o) {
            if(! (o instanceof Entry))
                throw new ClassCastException("Entry Object is required");
            if(o.equals(null))
                throw new NullPointerException("null Entry is not allowed");
            Entry e = (Entry) o;
            return tab.containsKey(e.getKey()) && tab.contains(e.getValue());
        }

        @Override
        public boolean containsAll(HCollection c) {
            if(c.equals(null))
                throw new NullPointerException("null collection is not allowed");
            if(! (c instanceof EntrySet))
                throw new ClassCastException("Different HCollection of EntrySet is not allowed");
            EntrySet e = (EntrySet) c;
            Iterk it = (Iterk) e.iterator();
            boolean set = true;
            while(it.hasNext() && set) {
                Object obj = it.next();
                set = contains(obj);
            }
            return set;
        }

        @Override
        public boolean equals(Object o) {
            if (o.equals(null) || !(o instanceof EntrySet) || ((EntrySet) o).size() != size())
                return false;
            EntrySet e = (EntrySet) o;
            return containsAll(e);
        }

        @Override
        public int hashCode(){
            int ia = 0, ib = 0, ic = 0;
            Enumeration k = tab.keys();
            Enumeration v = tab.elements();
            while(k.hasMoreElements()) {
                ib = k.nextElement().hashCode();
                ic = v.nextElement().hashCode();
                ia += ib + ic;
            }
            return ia;
        }

        @Override
        public boolean isEmpty() {
            return tab.isEmpty();
        }

        @Override
        public HIterator iterator() {
            return new Iterk(tab);
        }

        @Override
        public boolean remove(Object o) {
            if(o.equals(null))
                throw new NullPointerException("null element is not allowed");
            if(! (o instanceof Entry))
                throw new ClassCastException("different class from Entry is not allowed");
            Entry e = (Entry) o;
            boolean set = contains(e);
            if(set)
                tab.remove(e.getKey());
            return set;
        }

        @Override
        public boolean removeAll(HCollection c) {
            if(c.equals(null))
                throw new NullPointerException("null HCollection is not allowed");
            if(! (c instanceof EntrySet))
                throw new ClassCastException("incompatible type");
            EntrySet es = (EntrySet) c;
            Iterk iterk = (Iterk) es.iterator();
            boolean set = false;
            while(iterk.hasNext()){
                Object obj = iterk.next();
                if(remove(obj))
                    set = true;
            }
            return set;
        }

        @Override
        public boolean retainAll(HCollection c) {
            if(c.equals(null))
                throw new NullPointerException("null HCollection is not allowed");
            if(! (c instanceof EntrySet))
                throw new ClassCastException("incompatible type");
            if(c.isEmpty())
                return false;
            EntrySet es = (EntrySet) c;
            Iterk iterk = (Iterk) es.iterator();
            boolean set = false;
            HashtableAdaptee newTAb = new HashtableAdaptee(c.size());
            while(iterk.hasNext()){
                Object obj = iterk.next();
                if(contains(obj))
                    newTAb.put(obj,tab.get(obj));
                    set = true;
            }
            tab = newTAb;
            return set;
        }

        @Override
        public int size() {
            return tab.size();
        }

        @Override
        public Object[] toArray() {
            Entry[] array = new Entry[tab.size()];
            Iterk iterk = (Iterk) iterator();
            Entry e;
            int counter = 0;
            while (iterk.hasNext()){
                Object obj = iterk.next();
                e = new Entry(obj,tab.get(obj));
                array[counter++] = e;
            }
            return array;
        }

        @Override
        public Object[] toArray(Object[] a) {
            if(a.equals(null))
                throw new NullPointerException("null array is not allowed");
            if(! (a instanceof Entry[]))
                throw  new ClassCastException("incompatible type");
            if(a.length < size())
                return toArray();
            else {
                Iterk iterk = (Iterk) iterator();
                Entry e;
                int counter = 0;
                while (iterk.hasNext()) {
                    Object obj = iterk.next();
                    e = new Entry(obj, tab.get(obj));
                    a[counter++] = e;
                }
            }
            return a;
        }
    }

    /***
     * private internal class that implements HSet
     * Used to generate a Set of Keys
     */
    private class SetKey implements HSet {

        private HashtableAdaptee tabk;

        public SetKey(HashtableAdaptee x) {
            tabk = x;
        }

        @Override
        public boolean add(Object o) {
            throw new UnsupportedOperationException("add method in HSet is not allowed");
        }

        @Override
        public boolean addAll(HCollection c) {
            throw new UnsupportedOperationException("add method in HSet is not allowed");
        }

        @Override
        public void clear() { tabk.clear(); }

        @Override
        public boolean contains(Object o) {
            if(o.equals(null))
                throw new NullPointerException("null Entry is not allowed");
            return tabk.containsKey(o);
        }

        @Override
        public boolean containsAll(HCollection c) {
            if(c.equals(null))
                throw new NullPointerException("null collection is not allowed");
            if(! (c instanceof SetKey))
                throw new ClassCastException("Different HCollection of EntrySet is not allowed");
            SetKey e = (SetKey) c;
            Iterk it = (Iterk) e.iterator();
            boolean set = true;
            while(it.hasNext() && set) {
                Object obj = it.next();
                set = contains(obj);
            }
            return set;
        }

        @Override
        public boolean equals(Object o) {
            if (o.equals(null) || !(o instanceof SetKey) || ((SetKey) o).size() != size())
                return false;
            return containsAll((SetKey)o);
        }

        @Override
        public int hashCode(){
            int ia = 0;
            Enumeration k = tabk.keys();
            while(k.hasMoreElements()) {
                ia += k.nextElement().hashCode();
            }
            return ia;
        }

        @Override
        public boolean isEmpty() {return tabk.isEmpty();}

        @Override
        public HIterator iterator() { return new Iterk(tabk); }

        @Override
        public boolean remove(Object o) {
            boolean set = contains(o);
            if(set)
                tabk.remove(o);
            return set;
        }

        @Override
        public boolean removeAll(HCollection c) {
            if(c.equals(null))
                throw new NullPointerException("null HCollection is not allowed");
            if(! (c instanceof HSet))
                throw new ClassCastException("incompatible type");
            HSet es = (HSet) c;
            Iterk iterk = (Iterk) es.iterator();
            boolean set = false;
            while(iterk.hasNext()){
                Object obj = iterk.next();
                if(remove(obj))
                    set = true;
            }
            return set;
        }

        @Override
        public boolean retainAll(HCollection c) {
            if(c.equals(null))
                throw new NullPointerException("null HCollection is not allowed");
            if(! (c instanceof EntrySet))
                throw new ClassCastException("incompatible type");
            if(c.isEmpty())
                return false;
            EntrySet es = (EntrySet) c;
            Iterk iterk = (Iterk) es.iterator();
            boolean set = false;
            HashtableAdaptee newTAb = new HashtableAdaptee(c.size());
            while(iterk.hasNext()){
                Object obj = iterk.next();
                if(contains(obj))
                    newTAb.put(obj,tabk.get(obj));
                set = true;
            }
            tabk = newTAb;
            return set;
        }

        @Override
        public int size() { return tabk.size(); }

        @Override
        public Object[] toArray() {
            Object[] array = new Object[tabk.size()];
            Iterk iterk = (Iterk) iterator();
            int counter = 0;
            while (iterk.hasNext()){
                array[counter++] = iterk.next();
            }
            return array;
        }

        @Override
        public Object[] toArray(Object[] a) {
            if(a.equals(null))
                throw new NullPointerException("null array is not allowed");
            if(a.length < size())
                return toArray();
            else {
                Iterk iterk = (Iterk) iterator();
                int counter = 0;
                while (iterk.hasNext()) {
                    a[counter++] = iterk.next();
                }
            }
            return a;
        }
    }


    /***
     * private internal class that Extends EntrySet
     * Used to generate a Collection of values, Collection in this case is extended by HSet and implemented by SetValue
     */
    private class SetValue implements HSet {
        private HashtableAdaptee tabv;

        public SetValue(HashtableAdaptee x) {
            tabv = x;
        }

        @Override
        public boolean add(Object o) {
            throw new UnsupportedOperationException("add method in HSet is not allowed");
        }

        @Override
        public boolean addAll(HCollection c) {
            throw new UnsupportedOperationException("add method in HSet is not allowed");
        }

        @Override
        public void clear() { tabv.clear(); }

        @Override
        public boolean contains(Object o) {
            if(o.equals(null))
                throw new NullPointerException("null value is not allowed");
            return tabv.contains(o);
        }
        @Override
        public boolean containsAll(HCollection c) {
            if(c.equals(null))
                throw new NullPointerException("null collection is not allowed");
            if(! (c instanceof SetValue))
                throw new ClassCastException("incompatible type introduced");
            SetValue es = (SetValue) c;
            Iterv iter = (Iterv) es.iterator();
            boolean set = true;
            while(iter.hasNext() && set) {
                Object obj = iter.next();
                set = contains(obj);
            }
            return set;
        }

        @Override
        public boolean equals(Object o) {
            if (o.equals(null) || !(o instanceof SetValue) || ((SetValue) o).size() != size())
                return false;
            return containsAll((SetValue)o);
        }

        @Override
        public int hashCode(){
            int ia = 0;
            Enumeration v = tabv.elements();
            while(v.hasMoreElements()) {
                ia += v.nextElement().hashCode();
            }
            return ia;
        }

        @Override
        public boolean isEmpty() { return tabv.isEmpty(); }

        @Override
        public HIterator iterator() { return new Iterv(tabv); }

        @Override
        public boolean remove(Object o) {
            if(o.equals(null))
                throw new NullPointerException("null element is not allowed");
            boolean set = contains(o);
            if(set) {
                Iterk iterk = (Iterk) iterator();
                Object obj;
                while (iterk.hasNext()) {
                    obj = iterk.next();
                    if (tabv.get(obj).equals(o)) {
                        tabv.remove(obj);
                        set = true;
                    }
                }
            }
            return set;
        }

        @Override
        public boolean removeAll(HCollection c) {
            if(c.equals(null))
            throw new NullPointerException("null HCollection is not allowed");
            if(! (c instanceof SetValue))
                throw new ClassCastException("incompatible type");
            if(c.isEmpty())
                return false;
            SetValue es = (SetValue) c;
            Iterv iterv = (Iterv) es.iterator();
            boolean set = false;
            while(iterv.hasNext()){
                Object obj = iterv.next();
                if(remove(obj))
                    set = true;
            }
            return set;
        }

        @Override
        public boolean retainAll(HCollection c) {
            if(c.equals(null))
            throw new NullPointerException("null HCollection is not allowed");
            if(! (c instanceof SetValue))
                throw new ClassCastException("incompatible type");
            if(c.isEmpty())
                return false;
            SetValue sv = (SetValue) c;
            Iterk iterk = (Iterk) sv.iterator();
            boolean set = false;
            HashtableAdaptee newTAb = new HashtableAdaptee(c.size());
            while(iterk.hasNext()){
                Object obj1 = iterk.next();
                Object obj2 = tabv.get(obj1);
                if(contains(obj2))
                    newTAb.put(obj1,obj2);
                set = true;
            }
            tabv = newTAb;
            return set; }

        @Override
        public int size() { return tabv.size();}

        @Override
        public Object[] toArray() {
            Object[] array = new Object[tabv.size()];
            Iterk iterk = (Iterk) iterator();
            int counter = 0;
            while (iterk.hasNext()){
                Object obj = iterk.next();
                array[counter++] = tabv.get(obj);
            }
            return array;
        }

        @Override
        public Object[] toArray(Object[] a) {
            if (a.equals(null))
                throw new NullPointerException("null array is not allowed");
            if (a.length < size())
                return toArray();
            else {
                Iterk iterk = (Iterk) iterator();
                int counter = 0;
                while (iterk.hasNext()) {
                    Object obj = iterk.next();
                    a[counter++] = tabv.get(obj);
                }
            }
            return a;
        }

        /***
         * This iterator implements HIterator
         */
        private class Iterv implements HIterator {
            private Enumeration enumer;
            private boolean hasIterate = false;
            private Object lastValue;
            private Object lastkey;
            private HashtableAdaptee tabv;

            private Iterv(HashtableAdaptee h) {
                tabv = h;
                enumer = h.keys();
            }

            @Override
            public boolean hasNext() {
                return enumer.hasMoreElements();
            }

            /***
             *
             * @return the next value
             */
            @Override
            public Object next(){
                if (!enumer.hasMoreElements()) {
                    throw new NoSuchElementException();
                }
                hasIterate = true;
                lastkey = enumer.nextElement();
                lastValue = tabv.get(lastkey);
                return lastValue;
            }

            @Override
            public void remove() {
                if (!hasIterate) {
                    throw new IllegalStateException();
                }
                tabv.remove(lastkey);
            }
        }
    }


    /***
     * private internal class that implements HIterator
     */
    private class Iterk implements HIterator {

        private Enumeration enumer;
        private Object lastKey;
        private boolean hasIterate = false;
        private HashtableAdaptee tab;

        private Iterk(HashtableAdaptee h) {
            tab = h;
            enumer = tab.keys();
        }


        @Override
        public boolean hasNext() {
            return enumer.hasMoreElements();
        }

        /***
         *
         * @return the nextKey
         */
        @Override
        public Object next() {
            if (!enumer.hasMoreElements()) {
                throw new NoSuchElementException();
            }
            hasIterate = true;
            lastKey = enumer.nextElement();
            return lastKey;
        }

        @Override
        public void remove() {
            if (!hasIterate) {
                throw new IllegalStateException();
            }
            tab.remove(lastKey);
        }
    }
}