package myAdapter.Test;
import myAdapter.MapAdapter;
import org.junit.Test;
import org.junit.Before;
import static org.junit.Assert.*;

/***
 * Testing MapAdapter.
 * This class is implemented to test all the methods of MapAdapter.
 * I create further classes to test the other classes that MapAdapter depend, which are EntrySet ,SetKey, SetValue, IterK, IterV.
 * This class use two MapAdapter variables and two MapAdapter.Entry variables which are implemented before all the test will start.
 * I used this design because first of all we need at least one MapAdapter to execute all the tests.
 * All the methods are described to give a full view of what was done.
 * All the Execution Records are obtained by the execution of MATestRunner.
 */
public class MapAdapterTest {
    /***
     * map1 - first map to be implemented with the default constructor.
     */
    public MapAdapter map1;
    /***
     *  map2 - second map to be implemented with the constructor, that have an initial capacity introduced as a parameter.
     */
    public MapAdapter map2;
    /***
     * e1 - firs MapAdapter.Entry to be implemented with parameters.
     */
    public MapAdapter.Entry e1;
    /***
     * e2 - second MapAdapter.Entry to be implemented with parameters.
     */
    public MapAdapter.Entry e2;

    /***
     * This method create an instance of MapAdapter with a default capacity,
     * and another MapAdapter with an initial capacity introduced as a parameter.
     * In the end create two different instance of MapAdapter.Entry.
     * After the execution of this method here will be present two MapAdapter that can be used by all the test case.
     * Execution Record: initializationError(myAdapter.Test.MapAdapterTest): Invalid test class 'myAdapter.Test.MapAdapterTest':
     *   1. No runnable methods
     * false
     */
    @Before
    public void setup() {
        map1 = new MapAdapter();
        map2 = new MapAdapter(12);
        e1 = new MapAdapter.Entry(0,"a");
        e2 = new MapAdapter.Entry(1,"b");
    }

    /***
     * This method tests the right initialization of MapAdapter after the setup() method.
     * The MapAdapter are initialized with different size, but they must be empty and both size must be 0.
     * Execution Record: true.
     */
    @Test
    public void testMapAdapterInit() {
        assertTrue(map1.isEmpty());
        assertTrue(map1.size() == 0);

        assertTrue(map2.isEmpty());
        assertTrue(map2.size() == 0);
    }

    /***
     * This method tests the right initialization of MapAdapter.Entry after the setup() method.
     * The Entry objects are initialized with different parameters, and after the execution of this method the values introduced by the constructor,
     * must be the same returned by the getter methods.
     * Execution Record : true.
     */
    @Test
    public void testEntryInit() {
        assertEquals(0,e1.getKey());
        assertEquals("a",e1.getValue());
        assertEquals(1,e2.getKey());
        assertEquals("b",e2.getValue());
    }


    /***
     * This method tests the wrong initialization of MapAdapter.
     * It was introduced a negative index to generate a MapAdapter object, the execution of this method expects IndexOutOfBoundsException to be thrown.
     * Execution Record : true.
     */
    @Test (expected = IndexOutOfBoundsException.class)
    public void testInvalidCapacity() {
        map1 = new MapAdapter( - 1);
    }

    /***
     * This method tests the wrong initialization of MapAdapter.Entry.
     * It was introduce a null key in the MapAdapter.Entry object, the execution of this method expects NullPointerException
     * Execution Record : true.
     */
    @Test (expected = NullPointerException.class)
    public void testEntryNullKey() {
        e1 = new MapAdapter.Entry(null,"a");
    }

    /***
     * This method tests the wrong initialization of MapAdapter.Entry.
     * It was introduce a null value in the MapAdapter.Entry object, the execution of this method expects NullPointerException
     * Execution Record : true.
     */
    @Test (expected = NullPointerException.class)
    public void testEntryNullValue() {
        e1 = new MapAdapter.Entry(0,null);
    }

    /***
     * This method test the proper functioning of clear().
     * At the beginning the MapAdapter is empty, after that it was introduced two elements.
     * The size of the MapAdapter is verified, after that it was used clear and the size of MapAdapter is verified.
     * Execution Record : true.
     */
    @Test
    public void clear(){
        assertTrue(map1.isEmpty());

        map1.put(0,"a");
        map1.put(2,"b");
        assertTrue(map1.size() == 2);

        map1.clear();
        assertTrue(map1.isEmpty());
    }

    /***
     * This method test the proper functioning of containsKey().
     * at the beginning we insert new elements in the MapAdapter, after we check with the containkey() if the inserted keys are present in the map.
     * Execution Record : true.
     */
    @Test
    public void containsKey() {
        map1.put(0,"a");
        map1.put(1,"b");
        map1.put(2,"c");
        assertTrue(map1.containsKey(0));
        assertTrue(map1.containsKey(1));
        assertTrue(map1.containsKey(2));
    }

    /***
     * this method tests the wrong functioning of containsKey().
     * It was called containsKey() with a null parameter, the method is expected to throw a NullPointerException exception.
     * Execution Record : true.
     */
    @Test (expected = NullPointerException.class)
    public void containsNullKey() {
        map1.containsKey(null);
    }

    /***
     * This method tests the proper functioning of containsValue().
     * At the beginning three pairs of key and value have been inserted,
     * after through the method containsValue() the presence of the values inserted previously is verified
     */
    @Test
    public void containsValue() {
        map1.put(0,"a");
        map1.put(1,"b");
        map1.put(2,"c");
        assertTrue(map1.containsValue("a"));
        assertTrue(map1.containsValue("b"));
        assertTrue(map1.containsValue("c"));
    }

    /***
     * This method tests the wrong functioning of containsValue().
     * It was called containsValue() with a null parameter, the method is expected to throw a NullPointerException exception.
     * Execution Record : true.
     */
    @Test (expected = NullPointerException.class)
    public void containsNullValue() {
        map1.containsValue(null);
    }
}
