package myAdapter.Test;
import myAdapter.HCollection;
import myAdapter.HSet;
import myAdapter.MapAdapter;
import org.junit.Test;
import org.junit.Before;
import static org.junit.Assert.*;

/***
 * Testing MapAdapter. <br>
 * This class is implemented to test all the methods of MapAdapter. <br>
 * I create further classes to test the other classes that MapAdapter depend, which are EntrySet ,SetKey, SetValue.
 * This class use two MapAdapter variables and two MapAdapter.Entry variables which are implemented before all the test will start with the method setup(). <br>
 * I used this design because first of all we need at least one MapAdapter to execute all the tests.<br>
 * All the methods are described to give a full view of what was done, each one can also represent a different behavior of MapAdapter.<br>
 * All the Execution Records are obtained by the execution of MATestRunner.
 * @see MATestRunner MATestRunner
 * @see EntrySetTest EntrySetTest
 * @see SetKeyTest SetKeyTest
 * @see CollectionValuesTest CollectionValueTest
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
     * This method is executed before all the tests in this class. <br>
     * This method create an instance of MapAdapter with a default capacity, and another MapAdapter with an initial capacity introduced as a parameter.<br>
     * In the end create two different instance of MapAdapter.Entry.<br>
     * After the execution of this method here will be present two MapAdapter that can be used by all the test cases.<br>
     * Execution Record: initializationError(myAdapter.Test.MapAdapterTest): Invalid test class 'myAdapter.Test.MapAdapterTest':
     *   1. <br>
     * the execution record was obtained after the implementation of all other the tests.<br>
     *
     */
    @Before
    public void setup() {
        map1 = new MapAdapter();
        map2 = new MapAdapter(12);
        e1 = new MapAdapter.Entry(0,"a");
        e2 = new MapAdapter.Entry(1,"b");
    }

    /***
     * This method tests the right initialization of MapAdapter after the setup() method. <br>
     * The MapAdapter are initialized with different size, but they must be empty and both size must be 0.<br>
     */
    @Test
    public void testMapAdapterInit() {
        assertTrue(map1.isEmpty());
        assertTrue(map1.size() == 0);

        assertTrue(map2.isEmpty());
        assertTrue(map2.size() == 0);
    }

    /***
     * This method tests the right initialization of MapAdapter.Entry after the setup() method.<br>
     * The Entry objects are initialized with different parameters, and after the execution of this method the values introduced by the constructor,
     * must be the same returned by the getter methods.<br>
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
     * This method tests the wrong initialization of MapAdapter.<br>
     * It was introduced a negative index to generate a MapAdapter object, the execution of this method expects IndexOutOfBoundsException to be thrown.<br>
     * Execution Record : true.
     */
    @Test (expected = IndexOutOfBoundsException.class)
    public void testInvalidCapacity() {
        map1 = new MapAdapter( - 1);
    }

    /***
     * This method tests the wrong initialization of MapAdapter.Entry.<br>
     * It was introduce a null key in the MapAdapter.Entry object, the execution of this method expects NullPointerException.<br>
     * Execution Record : true.
     */
    @Test (expected = NullPointerException.class)
    public void testEntryNullKey() {
        e1 = new MapAdapter.Entry(null,"a");
    }

    /***
     * This method tests the wrong initialization of MapAdapter.Entry.<br>
     * It was introduce a null value in the MapAdapter.Entry object, the execution of this method expects NullPointerException.<br>
     * Execution Record : true.
     */
    @Test (expected = NullPointerException.class)
    public void testEntryNullValue() {
        e1 = new MapAdapter.Entry(0,null);
    }

    /***
     * This method test the proper functioning of clear().<br>
     * At the beginning the MapAdapter is empty, after that it was introduced two elements.<br>
     * The size of the MapAdapter was verified at two, after that it was used clear and the size of MapAdapter was verified at 0.<br>
     * The post condition is that the map has no elements and it's empty.<br>
     * Execution Record : true.
     */
    @Test
    public void clear(){
        assertTrue(map1.isEmpty());

        map1.put(0,"a");
        map1.put(2,"b");
        assertTrue(map1.size() == 2);

        map1.clear();
        assertEquals(0,map1.size());
        assertTrue(map1.isEmpty());
    }

    /***
     * This method test the proper functioning of containsKey().<br>
     * At the beginning it was inserted new elements in the MapAdapter, after with the containsKey() it checks if the inserted keys are present in the map.<br>
     * It also denies the presence of keys that have not been introduced.<br>
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
        assertFalse(map1.containsKey(3));
    }

    /***
     * this method tests the wrong functioning of containsKey().<br>
     * It was called containsKey() with a null parameter, the method is expected to throw a NullPointerException exception.<br>
     * Execution Record : true.
     */
    @Test (expected = NullPointerException.class)
    public void containsNullKey() {
        map1.containsKey(null);
    }

    /***
     * This method tests the proper functioning of containsValue().<br>
     * At the beginning three pairs of key and value have been inserted, after through the method containsValue() the presence of the values inserted previously is verified.<br>
     * It also denies the presence of keys that have not been introduced.<br>
     * Execution Record : true.
     */
    @Test
    public void containsValue() {
        map1.put(0,"a");
        map1.put(1,"b");
        map1.put(2,"c");
        assertTrue(map1.containsValue("a"));
        assertTrue(map1.containsValue("b"));
        assertTrue(map1.containsValue("c"));
        assertFalse(map1.containsValue("d"));
    }

    /***
     * This method tests the wrong functioning of containsValue().<br>
     * It was called containsValue() with a null parameter, the method is expected to throw a NullPointerException exception.<br>
     * Execution Record : true.
     */
    @Test (expected = NullPointerException.class)
    public void containsNullValue() {
        map1.containsValue(null);
    }

    /***
     * This method generates only one Hset of entry so that the verification of the tests of this object is postponed to the class indicated.<br>
     * The connection between the pairs in MapAdapter and EntrySet (backing) it is tested in the same class indicated. <br>
     * Execution Record : true.<br>
     * @see EntrySetTest EntrySetTest  - this class tested all the method of HSet on this type of Object, that implements HSet.
     */
    public void entrySet() {
        map1.put(0,"a");
        map1.put(1,"b");
        map1.put(2,"c");
        map1.put(3,"d");
        map1.put(4,"e");
        assertTrue(map1.size() == 5);

        HSet hs = map1.entrySet();
        assertTrue(hs.size() == 5);
    }

    /***
     * This method shows the proper functioning of equals that compare two MapAdapter. <br>
     * In the first part two pairs are inserted in map1, then compare map1 with the empty map2 with equals to see that they are not equal,
     * then insert the same elements in different order in map2 and verify that the two maps are equal.<br>
     * In the second part the map2 is cleaned, then the same pairs of before are inserted but with the values switched and it is verified that the two maps are not equal.<br>
     * Execution Record : true.
     */
    @Test
    public void equals() {
        //first part
        map1.put("a",0);
        map1.put("b",1);
        assertFalse(map1.equals(map2));
        assertFalse(map2.equals(map1));

        assertTrue(map1.size() == 2);
        assertTrue(map2.size() == 0);


        map2.put("b",1);
        map2.put("a",0);
        assertTrue(map2.size() == 2);
        assertTrue(map1.equals(map2));
        assertTrue(map2.equals(map1));

        //second part
        map2.clear();
        assertTrue(map1.size() == 2);
        map2.put("a",1);
        map2.put("b",0);
        assertFalse(map1.equals(map2));
    }

    /***
     * This method tests the functioning of equals() when it is introduced a null parameter.<br>
     * It was called equals() with a null parameter, the method is expected to return false.<br>
     * Execution Record : true.
     */
    @Test
    public void equalsToNull() {
        assertFalse(map1.equals(null));
    }

    /***
     * This method tests the functioning of equals() when it is introduced a different class from HMap.<br>
     * It was called equals() with a java.util.Vector object, the method is expected to return false.<br>
     * Execution Record : true.
     */
    @Test
    public void notEqualsToAnotherClass() {
        assertFalse(map1.equals(new java.util.Vector()));
    }

    /***
     * This method checks the proper functioning of get(). <br>
     * Initially four key and value pairs are added, then through the get() method it is checked if the values returned by get are those that were introduced.<br>
     * Execution Record : true.
     */
    @Test
    public void get(){
        map1.put(0,"a");
        map1.put(12,"aaaa");
        map1.put(31,"baba");
        map1.put(17,"babuska");
        assertEquals("a",map1.get(0));
        assertEquals("aaaa",map1.get(12));
        assertEquals("baba",map1.get(31));
        assertEquals("babuska",map1.get(17));
    }

    /***
     * This method checks the proper functioning of get().<br>
     * Check that the get method of an empty map returns a null element, the method works even in cases where you search for an element not present in the map
     */
    @Test
    public void getFromVoidMap(){
        assertEquals(null,map1.get("a"));
    }

    /***
     * This method tests the functioning of get() when it is introduced a null parameter.<br>
     * It was called get() with a null parameter, the method is expected to throw a NullPointerException.<br>
     * Execution Record : true.
     */
    @Test (expected = NullPointerException.class)
    public void getNull(){
        map1.get(null);
    }

    /***
     * This method checks the proper functioning of hashCode().<br>
     * Three key pairs and values are inserted in map1, these pairs are also inserted in map2. Assert that the two maps generate the same hashcode. <br>
     * Finally, insert another element in map2 and verify that the hashcode generated by the two maps are different.
     * Execution Record : true.
     */
    @Test
    public void hashcode(){
        assertEquals(0,map1.hashCode());
        assertEquals(0,map2.hashCode());
        map1.put(0,"a");
        map1.put(1,"b");
        map1.put(2,"c");
        map2.put(1,"b");
        map2.put(0,"a");
        map2.put(2,"c");

        assertTrue(map1.size() == 3);
        assertTrue(map2.size() == 3);
        assertEquals(map1.hashCode(),map2.hashCode());

        map2.put(12,"f");
        assertTrue(map2.size() == 4);
        assertNotEquals(map1.hashCode(),map2.hashCode());
    }

    /***
     * This method checks the proper functioning of isEmpty().<br>
     * It is initially confirmed that map1 is empty and map2 is empty, even if it is generated with a capacity of '12.
     * a pair is inserted in map1 and map2 and it is confirmed that they are not empty
     * Execution Record : true.
     */
    @Test
    public void isEmpty(){
        assertTrue(map1.isEmpty());
        assertTrue(map2.isEmpty());
        map1.put("a",0);
        map2.put(0,0);
        assertFalse(map1.isEmpty());
        assertFalse(map2.isEmpty());
    }

    /***
     * This method generates only one Hset of keys so that the verification of the tests of this object is postponed to the class indicated.<br>
     * The connection between the pairs in MapAdapter and SetKey (backing) it is tested in the same class indicated. <br>
     * @see SetKeyTest SetKeyTest  - this class tested all the method of HSet on this type of Object, that implements HSet.
     * Execution Record : true.
     */
    @Test
    public void keySet() {
        map1.put(0,"a");
        map1.put(1,"b");
        map1.put(2,"c");
        map1.put(3,"d");
        map1.put(4,"e");
        assertTrue(map1.size() == 5);

        HSet hs = map1.keySet();
        assertTrue(hs.size() == 5);
    }

    /***
     * This method checks the proper functioning of put().<br>
     * First check that the map is empty, then enter four key pairs and value, check the size of the map that is four,
     * then insert another element with a key similar to that already inserted and check that the size does not change. <br>
     * Finally it is checked through the get() method that the values inserted by the respective keys correspond in the map and are present,
     * it is also checked that the key that has been inserted with a new value has been replaced. <br>
     * Execution Record : true.
     */
    @Test
    public void put(){
        assertTrue(map1.size() == 0);
        map1.put(0,"a");
        map1.put(1,"b");
        map1.put(2,"c");
        map1.put(3,"d");
        assertTrue(map1.size() == 4);
        map1.put(2,"d");
        assertTrue(map1.size() == 4);

        assertEquals("a",map1.get(0));
        assertEquals("b",map1.get(1));
        assertEquals("d",map1.get(2));
        assertNotEquals("c",map1.get(2));
        assertEquals("d",map1.get(3));
    }

    /***
     * This method tests the wrong functioning of containsValue().<br>
     * A null key is inserted as a parameter of put(), the method is expected to throw a NullPointerException.<br>
     * Execution Record : true.
     */
    @Test (expected = NullPointerException.class)
    public void putNullKey(){
        map1.put(null,0);
    }

    /***
     * This method tests the wrong functioning of containsValue().<br>
     * A null key is inserted as a parameter of put(), the method is expected to throw a NullPointerException. <br>
     * Execution Record : true.
     */
    @Test(expected = NullPointerException.class)
    public void putNullValue(){
        map1.put(0,null);
    }

    /***
     * This method checks the proper functioning of putAll().<br>
     * If a class is introduced that does not implement HMap as a parameter of putAll(), the code does not even compile,
     * for which it was not possible to throw ClassCastException in a test.<br>
     * Initially map1 and map2 are empty, then two pairs are inserted in map1, then map1 is inserted in map2.<br>
     * The map2 size that has changed is checked, then the values of the map1 keys are checked in map2 and the returned values match.<br>
     * Execution Record : true.
     */
    @Test
    public void putAll(){
        assertTrue(map1.size() == 0);
        assertTrue(map2.size() == 0);
        map1.put(0,0);
        map1.put(1,1);
        map2.putAll(map1);
        assertTrue(map2.size() == 2);
        assertEquals(0,map2.get(0));
        assertEquals(1,map2.get(1));
        assertNotEquals(2,map2.get(2));
    }

    /***
     * This method tests the wrong functioning of putAll().<br>
     * A null parameter is introduced in the putAll() method, the method is expected to run NullPointerException. <br>
     * Execution Record : true.
     */
    @Test (expected = NullPointerException.class)
    public void putAllNull(){
        map1.putAll(null);
    }

    /***
     * This method checks the proper functioning of remove().<br>
     * Initially check that the map is empty, add two pairs, check the size of the map that is two and that is empty. <br>
     * Finally it was removed the pairs inserted with the respective keys through the remove method. <br>
     * Finally it expects the map to be 0 and empty.<br>
     * Execution Record : true.
     */
    @Test
    public void remove() {
        assertTrue(map1.size() == 0);
        map1.put(0,0);
        map1.put(1,1);
        assertTrue(map1.size() == 2);
        assertFalse(map1.isEmpty());
        map1.remove(0);
        map1.remove(1);
        assertTrue(map1.size() == 0);
        assertTrue(map1.isEmpty());

    }

    /***
     * This method tests the wrong functioning of remove().<br>
     * A null parameter is introduced in the remove() method, the method is expected to run NullPointerException. <br>
     * Execution Record : true.
     */
    @Test (expected = NullPointerException.class)
    public void removeNullKey(){
        map1.remove(null);
    }

    /***
     * This method checks the proper functioning of remove().<br>
     * Initially check that the map has size 0, then two pairs are added and verify that the map has size 2.<br>
     * At the end the map is cleaned and checked that the map has size 0.
     * Execution Record : true.
     */
    @Test
    public void size(){
        assertTrue(map1.size() == 0);
        map1.put(0,0);
        map1.put(1,1);
        assertTrue(map1.size() == 2);
        map1.clear();
        assertTrue(map1.size() == 0);
    }

    /***
     * This method generates only one HCollection of Values so that the verification of the tests of this object is postponed to the class indicated.<br>
     * In this case the class HCollection has been implemented with a set of values.<br>
     * The connection between the pairs in MapAdapter and HCollection of Values (backing) it is tested in the same class indicated. <br>
     * Execution Record : true.<br>
     * @see CollectionValuesTest CollectionValuesTest  - this class tested all the method of HSet on this type of Object, that implements HSet.
     */
    @Test
    public void values() {
        map1.put(0,"a");
        map1.put(1,"b");
        map1.put(2,"c");
        map1.put(3,"d");
        map1.put(4,"e");
        assertTrue(map1.size() == 5);

        HCollection hs = map1.values();
        assertTrue(hs.size() == 5);
    }
}
