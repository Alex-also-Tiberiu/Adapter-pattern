package myAdapter;

public class MapAdapter implements HMap {

    private HHashtable table;

    public MapAdapter() {
        table = new HashtableAdaptee();
    }

    public MapAdapter(int initialCapacity) {
        table = new HashtableAdaptee(initialCapacity);
    }

    @Override
    public void clear() {

    }

    @Override
    public boolean containsKey(Object key) {
        return false;
    }

    @Override
    public boolean containsValue(Object value) {
        return false;
    }

    @Override
    public HSet entrySet() {
        return null;
    }

    @Override
    public Object get(Object key) {
        return null;
    }

    @Override
    public boolean isEmpty() {
        return false;
    }

    @Override
    public HSet keySet() {
        return null;
    }

    @Override
    public Object put(Object key, Object value) {
        return null;
    }

    @Override
    public void putAll(MapAdapter t) {

    }

    @Override
    public Object remove(Object key) {
        return null;
    }

    @Override
    public int size() {
        return 0;
    }

    @Override
    public HCollection values() {
        return null;
    }

    public class Entry implements HEntry {

        private Object key,value;

        public Entry(Object key,Object value) {
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
            return this.value = value;
        }
    }
}