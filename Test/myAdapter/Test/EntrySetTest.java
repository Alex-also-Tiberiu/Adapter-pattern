package myAdapter.Test;
import myAdapter.HIterator;
import myAdapter.HSet;
import myAdapter.MapAdapter;
import myAdapter.UnsupportedOperationException;
import org.junit.Test;
import org.junit.Before;
import static org.junit.Assert.*;

/***
 * Testing a HSet of MapAdapter.Entry <br>
 * This class was generated to return entry objects from the map, so it implements HSet, and must respond appropriately to the HSet interface. <br>
 * Since the class is private, a MapAdapter variable is used, which through the entrySet() method will instantiate the object to be tested with HSet’s methods.<br>
 * The method that instantiates the object to be tested is setup(), which will be executed before all tests.<br>
 * In the first part the HSet methods will be tested, but in the second part the backing to MapAdapter will be verified.<br>
 * Tests of this class are performed by the ESTestRunner class. <br>
 * @see ESTestRunner ESTestRunner.
 */
public class EntrySetTest {
    /***
     * Private MapAdapter variable that is used to make an EntrySet.
     */
    private MapAdapter m1;
    /***
     * Private MapAdapter variable that is used to make an EntrySet with some entry objects.
     */
    private MapAdapter m2;
    /***
     * Private HSet variable that is implemented by the method EntrySet.<br>
     * For simplicity we will use to define it in this class as EntrySet.
     */
    private HSet es1;
    /***
     * Private HSet variable that is implemented by the method EntrySet.<br>
     * This object already have some elements inside.
     */
    private HSet es2;

    /***
     * This method instantiates MapAdapter and after instantiates an HSet object of EntrySet nature. <br>
     * It also instantiates a MapAdapter and an HSet of EntrySet nature that already has elements inside. <br>
     * Instantiation of these objects occurs before all test class methods.
     */
    @Before
    public void setup(){
        m1 = new MapAdapter();
        es1 = m1.entrySet();
        m2 = new MapAdapter();
        m2.put(0,"a");
        m2.put(1,"b");
        m2.put(2,"c");
        m2.put(3,"d");
        es2 = m2.entrySet();
    }

    /***
     * This method tests the right initialization of EntrySet after setup() method. <br>
     * The EntrySet es1 and es2 are implemented with different size, and it is verified by the method size() of HSet.<br>
     * Execution Record : true.
     */
    @Test
    public void testEntrySetInit() {
        assertTrue(es1.size() == 0);
        assertTrue(es1.isEmpty());
        assertTrue(es2.size() == 4);
        assertFalse(es2.isEmpty());
    }

    /***
     * This method tests the HSet.add() method.<br>
     * in any case this method must launch UnsupportedOperationException.<br>
     * Execution Record : true.
     */
    @Test (expected = UnsupportedOperationException.class)
    public void add() {
        es1.add("a");
    }

    /***
     * This method tests the HSet.addAll() method.<br>
     * In any case this method must launch UnsupportedOperationException.<br>
     * Execution Record : true.
     */
    @Test (expected = UnsupportedOperationException.class)
    public void addAll() {
        es1.add(new java.util.Vector());
    }

    /***
     * This method tests the HSet.clear() method. <br>
     * The size of EntrySet2 is checked and it is 4, then a clear() is made on it and finally it is checked that his size is 0.<br>
     * Execution Record : true.
     */
    @Test
    public void clear() {
        assertTrue(es2.size() == 4);
        es2.clear();
        assertTrue(es2.size() == 0);
    }

    /***
     * This method tests the HSet.contains() method. <br>
     * 3 Entry are created which through the contains() method are verified of their presence in EntrySet. <br>
     * 1 Entry is already present and is verified, while the other two are Entries that were not introduced initially and therefore were not found. <br>
     * Execution Record : true.
     */
    @Test
    public void contains() {
        MapAdapter.Entry entry1 = new MapAdapter.Entry(0,"a");
        MapAdapter.Entry entry2 = new MapAdapter.Entry(0,"z");
        MapAdapter.Entry entry3 = new MapAdapter.Entry("a",0);
        assertTrue(es2.contains(entry1));
        assertFalse(es2.contains(entry2));
        assertFalse(es2.contains(entry3));
    }

    /***
     * This method tests the HSet.contains() method. <br>
     * In this case is expected that the method throws a NullPointerException because in the method contains() was introduced a null parameter. <br>
     * Execution Record : true.
     */
    @Test (expected = NullPointerException.class)
    public void contains_Null() {
        es1.contains(null);
    }

    /***
     * This method tests the HSet.contains() method. <br>
     * In this case is expected that the method throws a ClassCastException because in the method contains()
     * has been introduced a different class from Entry as a parameter. <br>
     * Execution Record : true.
     */
    @Test (expected = ClassCastException.class)
    public void contains_ADifferentObject() {
        es1.contains(new java.util.Vector());
    }

    /***
     * This method tests the HSet.containsAll() method. <br>
     * 3 pairs are added to MapAdapter1, EntrySet1 size is checked, and EntrySet2 is compared symmetrically with EntrySet1. <br>
     * Finally it was added a fourth pair in EntrySet2 from obtain 4 identical elements in both EntrySets,
     * it check the size of EntrySet2 and then the two EntrySets are symmetrically equal .<br>
     * It has not been possible to check if the containsAll() method launches ClassCastException,
     * because the code does not compile if a class different from that indicated by the interface is introduced.<br>
     * Execution Record : true.
     */
    @Test
    public void containsAll() {
        m1.put(0,"a");
        m1.put(1,"b");
        m1.put(2,"c");
        assertTrue(es2.size() == 4);
        assertTrue(es1.size() == 3);
        assertTrue(es2.containsAll(es1));
        assertFalse(es1.containsAll(es2));
        m1.put(3,"d");
        assertTrue(es1.size() == 4);
        assertTrue(es2.containsAll(es1));
    }

    /***
     * This method tests the HSet.containsAll() method. <br>
     * In this case is expected that the method throws a NullPointerException because in the method containsAll()
     * has been introduce a null parameter. <br>
     * Execution Record : true.
     */
    @Test (expected = NullPointerException.class)
    public void containsAll_Null(){
        es1.containsAll(null);
    }

    /***
     * This method tests the HSet.equals() method. <br>
     * Entryset1 is initially compared to Entryset2 which is false because one is empty and the other has 4 elements,
     * then to Entryset1 adding to the Mapadapter1 the elements of Mapadapter2 are added the pairs present in Mapadapter2.
     * Finally, Entryset1 and Entryset2 are symmetrically compared.<br>
     * Execution Record : true.
     */
    @Test
    public void equals() {
        assertFalse(es1.equals(es2));
        m1.putAll(m2);
        assertTrue(es1.equals(es2));
        assertTrue(es2.equals(es1));
    }

    /***
     * This method tests the HSet.equals() method. <br>
     * The method returns false because a null parameter has been introduced.<br>
     * Execution Record : true.
     */
    @Test
    public void equalsToNull() {
        assertFalse(es1.equals(null));
    }

    /***
     * This method tests the HSet.equals() method. <br>
     * The method returns false because a different class from EntrySet has been introduced as a parameter.<br>
     * Execution Record : true.
     */
    @Test
    public void equalsToAnotheTypeOfObject() {
        assertFalse(es1.equals(new java.util.Vector()));
    }

    /***
     * This method tests the HSet.hashCode() method. <br>
     * Compare the hashCode of two EntrySet with different pairs,
     * then add the elements of the full map to the empty one and verify that the generated hashcodes are equal.<br>
     * At the end it was added an element to one of the two maps to verify that the hashCodes are different.<br>
     * Execution Record : true.
     */
    @Test
    public void hashcode() {
        assertNotEquals(es1.hashCode(),es2.hashCode());
        m1.putAll(m2);
        assertEquals(es1.hashCode(),es1.hashCode());
        m1.put(12,"babuska");
        assertNotEquals(es1.hashCode(),es2.hashCode());
    }

    /***
     * This method tests the HSet.isEmpty() method. <br>
     * It is verified that Entryset1 is empty and Entryset2 is not empty, Entryset2 is cleared and it is verified that it is empty. <br>
     * Execution Record : true.
     */
    @Test
    public void isEmpty() {
        assertTrue(es1.isEmpty());
        assertFalse(es2.isEmpty());
        es2.clear();
        assertTrue(es2.isEmpty());
    }

    /***
     * This method tests the HSet.iterator() method. <br>
     * Two iterators are simply generated and it is checked that the two iterators do not point to a null memory location and that they do not have a null value.<br>
     * Execution Record : true.
     */
    @Test
    public void iterator(){
        HIterator h1 = es1.iterator();
        HIterator h2 = es2.iterator();
        assertFalse(h1.equals(null));
        assertFalse(h2.equals(null));
        assertFalse(h1 == null);
        assertFalse(h2 == null);
    }

    /***
     * This method tests if the iterator implemented on EntrySet has next elements to iterate.
     * Execution Record : true.
     */
    @Test
    public void iteratorHasNext(){
        HIterator h1 = es1.iterator();
        HIterator h2 = es2.iterator();
        assertFalse(h1.hasNext());
        assertTrue(h2.hasNext());
    }

    /***
     * This method tests if the iterator implemented on EntrySet give back the
     */
    @Test
    public void iteratorNextElement(){
        HIterator h2 = es2.iterator();
        while(h2.hasNext()) {
            assertTrue(m2.containsKey(h2.next()));
        }
    }

    /***
     * This method tests the HSet.remove() method. <br>
     * Initially, it is verified that Entryset2 has the elements with which it has been initialized and its size is 4,
     * then all the elements are removed and its size is verified to 0.
     * finally an element is removed that is not present in the Entryset, therefore this removals is not true. <br>
     * Execution Record : true.
     */
    @Test
    public void remove(){
        assertTrue(es2.size() == 4);
        assertTrue(es2.remove(new MapAdapter.Entry(0,"a")));
        assertTrue(es2.remove(new MapAdapter.Entry(1,"b")));
        assertTrue(es2.remove(new MapAdapter.Entry(2,"c")));
        assertTrue(es2.remove(new MapAdapter.Entry(3,"d")));
        assertTrue(es2.size() == 0);
        assertFalse(es2.remove(new MapAdapter.Entry(4,"e")));
    }
}
