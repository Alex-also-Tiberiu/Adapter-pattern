package myAdapter.Test;
import myAdapter.*;
import myAdapter.UnsupportedOperationException;
import org.junit.Test;
import org.junit.Before;
import static org.junit.Assert.*;


/***
 * Testing a HCollection of MapAdapter.ValueCollection() <br>
 * This class was generated to return keySet objects from the map, so it implements HCollection, and must respond appropriately to the HCollection interface. <br>
 * Since the class is private, a MapAdapter variable is used, which through the ValueCollection() method will instantiate the object to be tested with HCollection’s methods.<br>
 * The method that instantiates the object to be tested is setup(), which will be executed before all tests.<br>
 * In the first part the HCollection methods will be tested, but in the second part the backing to MapAdapter will be verified.<br>
 * Tests of this class are performed by the ESTestRunner class. <br>
 * @see CollectionValuesTestRunner CollectionValuesTestRunner. <br>
 * @see MapAdapter MapAdapter <br>
 *
 */
public class CollectionValuesTest{
    /***
     * Private MapAdapter variable that is used to make an ValueCollection.
     */
    private MapAdapter m1;
    /***
     * Private MapAdapter variable that is used to make an ValueCollection with some key objects.
     */
    private MapAdapter m2;
    /***
     * Private HCollection variable that is implemented by the method keySet().<br>
     * For simplicity we will use to define it in this class as KeySet.
     */
    private HCollection cv1;
    /***
     * Private HCollection variable that is implemented by the method keySet.<br>
     * For simplicity we will use to define it in this class as KeySet.<br>
     * This object already have some elements inside.
     */
    private HCollection cv2;

    /***
     * <b>Test : </b> <br>
     * <b>Description : </b> This method instantiates MapAdapter m1 and after instantiates an HCollection object of ValueCollection nature cv1. <br>
     * It also instantiates a MapAdapter m2 with some additional elements inside, and a HCollection of ValueCollection nature cv2 that has the elements of ms2. <br>
     * Instantiation of these objects occurs before all test class methods. <br>
     * It is also checked that all the object instantiated have not a reference to null.
     *  cv1 = {  } <br>
     *  m1 = {  } <br>
     *  cv2 = { a , b , c , d } <br>
     *  m2 = { [0,a] , [1,b] , [2,c] , [3,d] } <br>
     * <b>Pre-condition : </b> the sample variables have been created without being instantiated <br>
     * <b>Post-condition : </b> <br>
     * <b>Expected result : </b> <br>
     */
    @Before
    public void setup(){
        m1 = new MapAdapter();
        cv1 = m1.values();
        m2 = new MapAdapter();
        m2.put(0,"a");
        m2.put(1,"b");
        m2.put(2,"c");
        m2.put(3,"d");
        cv2 = m2.values();
        assertTrue(m1 != null);
        assertTrue(m2 != null);
        assertTrue(cv1 != null);
        assertTrue(cv2 != null);
    }


    /***
     * <b>Test : </b>  This method tests the right initialization of ValueCollection after setup() method. <br>
     * <b>Description : </b> The ValueCollection cv1 and cv2 are implemented with different size, and it is verified by the method size() of HCollection. <br>
     * Also it is verified that the ValueCollection cv1, cv2 and MapAdapter m1 and m2 have not a reference to null. <br>
     * Finally it is verified the size of each elements and the fact that one ValueCollection is empty and the over one is not Empty. <br>
     * <b>Pre-condition : </b> Two MapAdapter objects properly initialized, m1 is empty and m2 has 4 elements.<br>
     * ValueCollection cv2 object properly initialized on the MapAdapter m2 object.<br>
     *      cv1 = { } <br>
     *      m1 = {  } <br>
     *      cv2 = { a , b , c , d } <br>
     *      m2 = { [0,a] , [1,b] , [2,c] , [3,d] } <br>
     * <b>Post-condition : </b> The objects are proper initialized. <br>
     * <b>Expected result : </b> The objects have not a reference to null <br>
     */
    @Test
    public void testValueCollectionInitialization() {
        assertTrue(m1 != null);
        assertTrue(m2 != null);
        assertTrue(cv1 != null);
        assertTrue(cv2 != null);
        assertTrue(cv1.size() == 0);
        assertTrue(cv1.isEmpty());
        assertTrue(cv2.size() == 4);
        assertFalse(cv2.isEmpty());
    }

    /***
     * <b>Test : </b> the wrong functioning of HCollection.add() method. <br>
     * <b>Description : </b> In any case this method must throw UnsupportedOperationException. <br>
     * <b>Pre-condition : </b> Two MapAdapter objects properly initialized, m1 is empty and m2 has 4 elements.<br>
     * ValueCollection cv2 object properly initialized on the MapAdapter m2 object. <br>
     * <b>Post-condition : </b> the exception to the calling method is passed, if this is not handled then the program ends. <br>
     * <b>Expected result : </b>  UnsupportedOperationException thrown <br>
     */
    @Test (expected = UnsupportedOperationException.class)
    public void add() {
        cv1.add("a");
    }


    /***
     * <b>Test : </b> the wrong functioning of HCollection.adAll() method. <br>
     * <b>Description : </b> In any case this method must throw UnsupportedOperationException. <br>
     * <b>Pre-condition : </b> Two MapAdapter objects properly initialized, m1 is empty and m2 has 4 elements.<br>
     * ValueCollection cv2 object properly initialized on the MapAdapter m2 object. <br>
     * <b>Post-condition : </b> the exception to the calling method is passed, if this is not handled then the program ends. <br>
     * <b>Expected result : </b>  UnsupportedOperationException thrown <br>
     */
    @Test (expected = UnsupportedOperationException.class)
    public void addAll() {
        cv1.add(new java.util.Vector());
    }

    /***
     * <b>Test : </b> This method tests the HCollection.clear() method. <br>
     * <b>Description : </b> The size of ValueCollection2 is checked and it is 4, then a clear() is made on it and finally it is checked that his size is 0. <br>
     * At the same time it is verified that the MapAdapter m1 size change as the size of ValueCollection2 cv1. <br>
     * <b>Pre-condition : </b> Two MapAdapter objects properly initialized, m1 is empty and m2 has 4 elements.<br>
     * ValueCollection cv2 object properly initialized on the MapAdapter m2 object.<br>
     *      cv1 = {  } <br>
     *      m1 = {  } <br>
     *      cv2 = { a , b , c , d } <br>
     *      m2 = { [0,a] , [1,b] , [2,c] , [3,d] } <br>
     *          Backing works. <br> <br>
     * <b>Post-condition : </b> The ValueCollection is clear. <br>
     * <b>Expected result : </b> clear erase the elements of the ValueCollection. <br>
     */
    @Test
    public void clear() {
        assertTrue(cv2.size() == 4);
        assertTrue(m2.size() == 4);
        cv2.clear();
        assertTrue(cv2.size() == 0);
        assertTrue(m2.size() == 0);
    }

    /***
     * <b>Test : </b> This method tests the HCollection.contains() method. <br>
     * <b>Description : </b> 3 Key are created which through the contains() method are verified of their presence in ValueCollection. <br>
     * 1 Key is already present and is verified, while the other two are Entries that were not introduced initially and therefore were not found. <br>
     * <b>Pre-condition : </b> Two MapAdapter objects properly initialized, m1 is empty and m2 has 4 elements.<br>
     * ValueCollection cv2 object properly initialized on the MapAdapter m2 object.<br>
     *      cv1 = {  } <br>
     *      m1 = {  } <br>
     *      cv2 = { a , b , c , d } <br>
     *      m2 = { [0,a] , [1,b] , [2,c] , [3,d] } <br>
     *          Backing works. <br> <br>
     * <b>Post-condition : </b> the objects don't change their state after contains is called. <br>
     * <b>Expected result : </b> contains return true if an object is contained or false if not. <br>
     */
    @Test
    public void contains() {
        Object k1 = "a";
        Object k2 = "b";
        Object k3 = 4;
        assertTrue(cv2.contains(k1));
        assertTrue(cv2.contains(k2));
        assertFalse(cv2.contains(k3));
    }

    /***
     * <b>Test : </b> the wrong functioning of HCollection.contains() method. <br>
     * <b>Description : </b> In this case is expected that the method throws a NullPointerException because in the method contains() was introduced a null parameter. <br>
     * <b>Pre-condition : </b> Two MapAdapter objects properly initialized, m1 is empty and m2 has 4 elements.<br>
     * ValueCollection cv1, cv2 object properly initialized on the MapAdapter m1 ,m2 object. <br>
     * <b>Post-condition : </b>  the exception to the calling method is passed, if this is not handled then the program ends. <br>
     * <b>Expected result : </b> NullPointerException thrown. <br>
     */
    @Test (expected = NullPointerException.class)
    public void contains_Null() {
        cv1.contains(null);
    }

    /***
     * <b>Test : </b> this method tests the HCollection.containsAll() method. <br>
     * <b>Description : </b> 3 pairs are added to MapAdapter1, ValueCollection1 size is checked, and ValueCollection2 is compared symmetrically with ValueCollection1. <br>
     * Finally it was added a fourth pair in ValueCollection2 from obtain 4 identical elements in both ValueCollections,
     * it check the size of ValueCollection2 and then the two ValueCollections are symmetrically equal .<br>
     * It has not been possible to check if the containsAll() method launches ClassCastException,
     * because the code does not compile if a class different from that indicated by the interface is introduced.<br>
     * <b>Pre-condition : </b> Two MapAdapter objects properly initialized, m1 is empty and m2 has 4 elements.<br>
     * ValueCollection cv2 object properly initialized on the MapAdapter m2 object.<br>
     *      cv1 = {  } <br>
     *      m1 = {  } <br>
     *      cv2 = { a , b , c , d } <br>
     *      m2 = { [0,a] , [1,b] , [2,c] , [3,d] } <br>
     *          Backing works. <br>
     * <b>Post-condition : </b> the state of the Objects don't change. <br>
     * <b>Expected result : </b> the containsAll() find if a collection is contained or not. <br>
     */
    @Test
    public void containsAll() {
        m1.put(0,"a");
        m1.put(1,"b");
        m1.put(2,"c");
        assertTrue(cv2.size() == 4);
        assertTrue(cv1.size() == 3);
        assertTrue(cv2.containsAll(cv1));
        assertFalse(cv1.containsAll(cv2));
        m1.put(3,"d");
        assertTrue(cv1.size() == 4);
        assertTrue(cv2.containsAll(cv1));
    }

    /***
     * <b>Test : </b> This method tests the HCollection.containsAll() method. <br>
     * <b>Description : </b> insert a null parameter on the remove method applied to an ValueCollection. <br>
     * <b>Pre-condition : </b> In this case is expected that the method throws a NullPointerException because in the method containsAll()
     * has been introduce a null parameter. <br>
     * <b>Post-condition : </b> the exception to the calling method is passed, if this is not handled then the program ends. <br>
     * <b>Expected result : </b> NullPointerException thrown.  <br>
     */
    @Test (expected = NullPointerException.class)
    public void containsAll_Null(){
        cv1.containsAll(null);
    }

    /***
     * <b>Test : </b> This method tests the HCollection.equals() method. <br>
     * <b>Description : </b> ValueCollection1 is initially compared to ValueCollection2 which is false because one is empty and the other has 4 elements,
     * then to ValueCollection1 adding to the Mapadapter1 4 pairs with the same keys of cv1 but with different values.
     * Finally, ValueCollection1 and ValueCollection2 are symmetrically compared.<br>
     * <b>Pre-condition : </b>  Two MapAdapter objects properly initialized, m1 is empty and m2 has 4 elements.<br>
     * ValueCollection cv2 object properly initialized on the MapAdapter m2 object.<br>
     *      cv1 = {  } <br>
     *      m1 = {  } <br>
     *      cv2 = { a , b , c , d } <br>
     *      m2 = { [0,a] , [1,b] , [2,c] , [3,d] } <br>
     *          Backing works. <br>
     * <b>Post-condition : </b> the objects don't change their status if equals() is called. <br>
     * <b>Expected result : </b> equals return true with two ValueCollection that they are the same keys. <br>
     */
    @Test
    public void equals() {
        assertFalse(cv1.equals(cv2));
        m1.put(10,"a");
        m1.put(11,"b");
        m1.put(12,"c");
        m1.put(13,"d");
        assertTrue(cv1.equals(cv2));
        assertTrue(cv2.equals(cv1));
    }

    /***
     * <b>Test : </b> the wrong functioning of HCollection.equals on a ValueCollection. <br>
     * <b>Description : </b> The method returns false because a null parameter has been introduced. <br>
     * <b>Pre-condition : </b> Two MapAdapter objects properly initialized, m1 is empty and m2 has 4 elements.<br>
     * ValueCollection cv1 and cv2 objects properly initialized on the MapAdapter m1 and m2.<br>
     * <b>Post-condition : </b> the state of the ValueCollection don't change if equals() is called. <br>
     * <b>Expected result : </b> equals return false <br>
     */
    @Test
    public void equalsToNull() {
        assertFalse(cv1.equals(null));
    }


    /***
     * <b>Test : </b> This method tests the wrong functioning of HCollection.equals on a ValueCollection. <br>
     * <b>Description : </b> The method returns false because a different class from ValueCollection has been introduced as a parameter.<br> <br>
     * <b>Pre-condition : </b> Two MapAdapter objects properly initialized, m1 is empty and m2 has 4 elements.<br>
     * ValueCollection cv1 and cv2 object properly initialized on the MapAdapter m1 and m2.<br>
     * <b>Post-condition : </b> the state of the object don't change if equals() is called. <br>
     * <b>Expected result : </b> equals return false. <br>
     */
    @Test
    public void equalsToAnotheTypeOfObject() {
        assertFalse(cv1.equals(new java.util.Vector()));
    }

    /***
     * <b>Test : </b> This method tests the HCollection.hashCode() method. <br>
     * <b>Description : </b> Compare the hashCode of two ValueCollection with different pairs,
     * then add the elements of the full map to the empty one and verify that the generated hashcodes are equal.<br>
     * At the end it was added an element to one of the two maps to verify that the hashCodes are different.<br><br>
     * <b>Pre-condition : </b> Two MapAdapter objects properly initialized, m1 is empty and m2 has 4 elements.<br>
     * ValueCollection cv1 and cv2 object properly initialized on the MapAdapter m1 and m2.<br>
     *     cv1 = {  } <br>
     *     m1 = {  } <br>
     *     cv2 = { a , b , c , d } <br>
     *     m2 = { [0,a] , [1,b] , [2,c] , [3,d] } <br>
     *          Backing works. <br>
     * <b>Post-condition : </b> the hashcode remain the same if the ValueCollections or MapAdapter associated don't change. <br>
     * <b>Expected result : </b> Two hashcode match if two ValueCollection have the same elements. <br>
     */
    @Test
    public void hashcode() {
        assertNotEquals(cv1.hashCode(), cv2.hashCode());
        m1.putAll(m2);
        assertEquals(cv1.hashCode(),cv1.hashCode());
        m1.put(12,"babuska");
        assertNotEquals(cv1.hashCode(), cv2.hashCode());
    }

    /***
     * <b>Test : </b> the proper functioning of HCollection.isEmpty on a ValueCollection. <br>
     * <b>Description : </b> It is verified that ValueCollection1 is empty and ValueCollection2,MaoAdapter2 is not empty, ValueCollection2 is cleared and it is verified that it is empty. <br>
     * It is also verified that MapAdapter m2 is empty. MapAdapter1 remain empty. <br>
     * <b>Pre-condition : </b> Two MapAdapter objects properly initialized, m1 is empty and m2 has 4 elements.<br>
     * ValueCollection cv1 and cv2 object properly initialized on the MapAdapter m1 and m2.<br>
     *      cv1 = {  } <br>
     *      m1 = {  } <br>
     *      cv2 = { a , b , c , d } <br>
     *      m2 = { [0,a] , [1,b] , [2,c] , [3,d] } <br>
     *          Backing works. <br>
     * <b>Post-condition : </b> The ValueCollection1 and ValueCollection 2 and MapAdapter 2 remain empty after this check. <br>
     * <b>Expected result : </b> the ValueCollection1, ValueCollection2, MapAdapter1 and MapAdapter2  are Empty. <br>
     */
    @Test
    public void isEmpty() {
        assertTrue(cv1.isEmpty());
        assertFalse(cv2.isEmpty());
        assertFalse(m2.isEmpty());
        cv2.clear();
        assertTrue(cv2.isEmpty());
        assertTrue(cv1.isEmpty());
        assertTrue(m2.isEmpty());
    }

    /**
     * <b>Tests</b> the proper functioning of iterator() method.<br>
     * <b>Description:</b> it calls the iterator() method on the 2 ValueCollection objects and checks that they are not null.<br>
     * <b>Pre-condition : </b> Two MapAdapter objects properly initialized, m1 is empty and m2 has 4 elements.<br>
     * Two ValueCollection objects (cv1 and cv2) properly initialized on the MapAdapter objects.<br>
     * Two HIterator objects (h1 and h2) properly initialized on the ValueCollection objects.<br>
     * <b>Post-condition : </b> the iterator are not null objects.<br>
     * <b>Expected result : </b> h1 and h2 are not null.<br>
     */
    @Test
    public void iterator(){
        HIterator h1 = cv1.iterator();
        HIterator h2 = cv2.iterator();
        assertFalse(h1.equals(null));
        assertFalse(h2.equals(null));
        assertFalse(h1 == null);
        assertFalse(h2 == null);
    }

    /***
     * <b>Test</b> The proper functioning of HIterator.hasNext() on a ValueCollection.  <br>
     * <b>Description : </b>This method tests if the iterator implemented on ValueCollection has next elements to iterate.<br>
     * <b>Pre-condition : </b> Two MapAdapter objects properly initialized, m1 is empty and m2 has 4 elements.<br>
     * Two ValueCollection objects (cv1 and cv2) properly initialized on the MapAdapter objects.<br>
     * Two HIterator objects (h1 and h2) properly initialized on the ValueCollection objects.<br>
     * <b>Post-condition : </b> the iterators are not null objects. <br>
     * <b>Expected result : </b> h1 has not next elements and h2 has next elements. <br>
     */
    @Test
    public void iteratorHasNext(){
        HIterator h1 = cv1.iterator();
        HIterator h2 = cv2.iterator();
        assertFalse(h1.hasNext());
        assertTrue(h2.hasNext());
    }

    /***
     * <b>Test : </b> The proper functioning of HIterator.next() on a ValueCollection. <br>
     * <b>Description : </b> This method tests if the iterator implemented on ValueCollection give back a key. <br>
     * An iterator is generated on ValueCollection2 that is not empty, then for each key object returned by the iterator its presence in Mapadapter2 and ValueCollection2 is verified. <br>
     * In this case we also checked the backing between Mapadapter and ValueCollection of the iterator.<br>
     * <b>Pre-condition : </b> Two MapAdapter objects properly initialized, m1 is empty and m2 has 4 elements.<br>
     * Two ValueCollection objects (cv1 and cv2) properly initialized on the MapAdapter objects.<br>
     * HIterator objects and h2 properly initialized on the ValueCollection cv2 object.<br>
     *      cv1 = {  } <br>
     *      m1 = {  } <br>
     *      cv2 = { a , b , c , d } <br>
     *      m2 = { [0,a] , [1,b] , [2,c] , [3,d] } <br>
     *          Backing works. <br>
     * <b>Post-condition : </b> The iterator don't change the elements in the MapAdapter m2 and the ValueCollection cv2. <br>
     * <b>Expected result : </b> All the key elements that the iterator h2 give back are present in the the MapAdapter m2 and also into the ValueCollection cv2.  <br>
     */
    @Test
    public void iteratorNextElement(){
        HIterator h2 = cv2.iterator();
        while(h2.hasNext()) {
            Object keys =  h2.next();
            assertTrue(m2.containsValue(keys));
            assertTrue(cv2.contains(keys));
        }
        assertTrue(cv2.size() == 4);
        assertTrue(m2.size() == 4);
    }

    /***
     * <b>Test : </b>The proper functioning of HIterator.remove() on a ValueCollection. <br>
     * <b>Description : </b> This method tests if the iterator implemented on ValueCollection remove the last element iterated. <br>
     * an iterator is created on ValueCollection cv2, from which an key is extracted, the key and value pair is verified if present in the map.<br>
     * For each remove() of the iterator the size of Mapadapter and ValueCollection is checked. Finally check that ValueCollection and Mapadapter are empty and have size 0.<br>
     * <b>Pre-condition : </b> Two MapAdapter objects properly initialized, m1 is empty and m2 has 4 elements.<br>
     * Two ValueCollection objects (cv1 and cv2) properly initialized on the MapAdapter objects.<br>
     * HIterator objects and h2 properly initialized on the ValueCollection cv2 object.<br>
     * The HIterator must call next() before to remove the element that next() found.<br>
     *      cv1 = {  } <br>
     *      m1 = {  } <br>
     *      cv2 = { a , b , c , d } <br>
     *      m2 = { [0,a] , [1,b] , [2,c] , [3,d] } <br>
     *          Backing works. <br>
     * <b>Post-condition : </b> The ValueCollection cv2 and the MapAdapter m2 are empty and their size is 0. <br>
     * <b>Expected result : </b> All the elements from ValueCollection cv2 and MapAdapter m2 are removed by the HIterator. <br>
     */
    @Test
    public void iteratorRemoveElement() {
        HIterator h2 = cv2.iterator();
        int i = 4;
        assertTrue(cv2.size() == i);
        while(h2.hasNext()){
            Object key = h2.next();
            assertTrue(m2.containsValue(key));
            h2.remove();
            assertTrue(cv2.size() == --i );
            assertTrue(m2.size() == i);
        }
        assertTrue(cv2.size() == 0);
        assertTrue(m2.size() == 0);
        assertTrue(cv2.isEmpty());
        assertTrue(m2.isEmpty());
    }

    /***
     * <b>Test : </b> The proper functioning of HCollection.remove() method on a ValueCollection.<br>
     * <b>Description : </b>
     * Initially the dimensions of Mapadapter m2 and ValueCollection cv2 are checked. <br>
     * After that it is checked that every time it is deleted an item from cv2 the size of cv2 and m2 decreases until it becomes zero. <br>
     * so it is checked that the backing also works.<br>
     * Finally an element is removed that is not present in the ValueCollection, therefore this removals is not true. <br>
     * <b>Pre-condition : </b>  It was instantiated correctly a Mapadapter m2 with 4 elements and from this an ValueCollection cv2
     * was initialized correctly with the same 4 elements. <br>
     *      cv1 = {  } <br>
     *      m1 = {  } <br>
     *      cv2 = { a , b , c , d } <br>
     *      m2 = { [0,a] , [1,b] , [2,c] , [3,d] } <br>
     *          Backing works.
     * <b>Post-condition :</b> the ValueCollection size is 0 and it's empty. <br>
     * <b>Expected result : </b> after every remove the size of the ValueCollection decrease by one.
     */
    @Test
    public void remove(){
        assertTrue(cv2.size() == 4);
        assertTrue(m2.size() == 4);
        assertTrue(cv2.remove("a"));
        assertTrue(cv2.size() == 3);
        assertTrue(m2.size() == 3);
        assertTrue(cv2.remove("b"));
        assertTrue(cv2.size() == 2);
        assertTrue(m2.size() == 2);
        assertTrue(cv2.remove("c"));
        assertTrue(cv2.size() == 1);
        assertTrue(m2.size() == 1);
        assertTrue(cv2.remove("d"));
        assertTrue(cv2.size() == 0);
        assertTrue(m2.size() == 0);
        assertTrue(cv2.isEmpty());
        assertTrue(m2.isEmpty());
        assertFalse(cv2.remove(4));
    }

    /***
     * <b>Test : </b> The wrong functioning of HCollection.remove() method on a ValueCollection.<br>
     * <b>Description : </b>  insert a null parameter on the remove method applied to an ValueCollection. <br>
     * <b>Pre-condition : </b> Two MapAdapter objects properly initialized, m1 is empty and m2 has 4 elements.<br>
     * Two ValueCollection objects (cv1 and cv2) properly initialized on the MapAdapter objects.<br>
     * <b>Post-condition : </b> the exception is passed to the calling method , if this is not handled then the program ends. <br>
     * <b>Expected result : </b> NullPointerException thrown <br>
     */
    @Test (expected = NullPointerException.class)
    public void removeANullObject() {
        cv2.remove(null);
    }

    /***
     * <b>Test : </b> The proper functioning of HCollection.remove() method on a ValueCollection. <br>
     * <b>Description : </b> Initially try to remove the empty cv1 from cv2 with 4 items with negative result, then vice versa with negative result.<br>
     * The two initial elements of cv2 to cv1 are added through MapAdapter m1. finally it is removed cv1 with two elements from cv2 with positive result. <br>
     * Finally it is checked the presence of the elements in cv2 and its final dimension that is 2. <br>
     * <b>Pre-condition : </b> Two MapAdapter objects properly initialized, m1 is empty and m2 has 4 elements.<br>
     * ValueCollection cv1 and cv2 object are properly initialized on the MapAdapter m1 and m2 object. <br>
     *     cv1 = {  } <br>
     *     m1 = {  } <br>
     *     cv2 = { a , b , c , d } <br>
     *     m2 = { [0,a] , [1,b] , [2,c] , [3,d] } <br>
     *         Backing works. <br>
     * <b>Post-condition : </b> The MapAdapter m2 and ValueCollection cv2 have the same two final object inside <br>
     * <b>Expected result : </b> The method removeAll() removes the collection not empty, and also don't remove nothing when the collection introduced is empty. <br>
     */
    @Test
    public void removeAll(){
        assertFalse(cv2.removeAll(cv1));
        assertFalse(cv1.removeAll(cv2));
        m1.put(10,"a");
        m1.put(11,"b");
        assertTrue(cv2.removeAll(cv1));
        assertFalse(cv2.contains("a"));
        assertFalse(cv2.contains("b"));
        assertTrue(cv2.contains("c"));
        assertTrue(cv2.contains("d"));
        assertTrue(cv2.size() == 2);
        assertTrue(m2.size() == 2);
    }

    /***
     * <b>Test : </b> The wrong functioning of HCollection.removeAll() method on a ValueCollection. <br>
     * <b>Description : </b> Insert a null parameter on the remove method applied to an ValueCollection. <br>
     * <b>Pre-condition : </b> Two MapAdapter objects properly initialized, m1 is empty and m2 has 4 elements.<br>
     * ValueCollection cv1 and cv2 object are properly initialized on the MapAdapter m1 and m2 object. <br>
     * <b>Post-condition : </b> the exception is passed to the calling method, if this is not handled then the program ends. <br>
     * <b>Expected result : </b> NullPointerException thrown <br>
     */
    @Test (expected = NullPointerException.class)
    public void removeALLNull(){
        cv2.removeAll(null);
    }

    /***
     * <b>Test : </b> The wrong functioning of HCollection.removeAll() method on a ValueCollection.  <br>
     * <b>Description : </b> Insert a HCollection as a parameter that is not compatible with ValueCollection. <br>
     * <b>Pre-condition : </b> Two MapAdapter objects properly initialized, m1 is empty and m2 has 4 elements.<br>
     * ValueCollection cv1 and cv2 object are properly initialized on the MapAdapter m1 and m2 object. <br>
     * <b>Post-condition : </b> the exception is passed to the calling method, if this is not handled then the program ends. <br>
     * <b>Expected result : </b> ClassCastException thrown. <br>
     */
    @Test (expected = ClassCastException.class)
    public void removeAllClassCastException() {
        cv2.removeAll(new ListAdapter());
    }

    /***
     * <b>Test : </b> he proper functioning of HCollection.retainAll() method on a ValueCollection.<br>
     * <b>Description : </b> the size of ValueCollection1 and ValueCollection2 is checked, ValueCollection2.ratainall(ValueCollection1) is done, which returns false as ValueCollection1 is empty.<br>
     * Add two elements to ValueCollection1 and check that ValueCollection2.retainall(ValueCollection1) returns true and that now ValueCollection2 has only two elements. <br>
     * <b>Pre-condition : </b> wo MapAdapter objects properly initialized, m1 is empty and m2 has 4 elements.<br>
     * ValueCollection cv1 and cv2 object are properly initialized on the MapAdapter m1 and m2 object. <br>
     *     cv1 = {  } <br>
     *     m1 = {  } <br>
     *     cv2 = { a , b , c , d } <br>
     *     m2 = { [0,a] , [1,b] , [2,c] , [3,d] } <br>
     *         Backing works. <br>
     * <b>Post-condition : </b> maps and ValueCollections maintain new status. <br>
     * <b>Expected result : </b> ValueCollection2 must keep the common items that have been added to ValueCollection1 by Mapadapter1. <br>
     */
    @Test
    public void retainAll() {
        assertTrue(cv1.size() == 0);
        assertTrue(cv2.size() == 4);
        assertFalse(cv2.retainAll(cv1));
        m1.put(10,"a");
        m1.put(11,"b");
        assertTrue(cv1.size() == 2);
        assertTrue(cv2.retainAll(cv1));
        assertTrue(cv2.size() == 2);
        assertTrue(m2.size() == 2);
        assertTrue(cv2.contains("a"));
        assertTrue(cv2.contains("b"));
        assertFalse(cv2.contains("c"));
        assertFalse(cv2.contains("d"));
        assertTrue(cv1.size() == 2);
        assertTrue(cv2.size() == 2);
        assertTrue(m1.size() == 2);
        assertTrue(m2.size() == 2);
    }

    /***
     * <b>Test : </b>The wrong functioning of HCollection.retainAll() method on a ValueCollection. <br>
     * <b>Description : </b> insert a null parameter on the retainAll() method applied to an ValueCollection. <br>
     * <b>Pre-condition : </b> Two MapAdapter objects properly initialized, m1 is empty and m2 has 4 elements.<br>
     * ValueCollection cv1 and cv2 object are properly initialized on the MapAdapter m1 and m2 object. <br>
     * <b>Post-condition : </b> the exception is passed to the calling method, if this is not handled then the program ends. <br>
     * <b>Expected result : </b> NullPointerException thrown <br>
     */
    @Test (expected = NullPointerException.class)
    public void retainAllNull(){
        cv1.retainAll(null);
    }

    /***
     * <b>Test : </b> The wrong functioning of HCollection.retainAll() method on a ValueCollection. <br>
     * <b>Description : </b> insert a ListAdapter class as parameter on the retainAll() method applied to an ValueCollection. <br>
     * <b>Pre-condition : </b> Two MapAdapter objects properly initialized, m1 is empty and m2 has 4 elements.<br>
     * ValueCollection cv1 and cv2 object are properly initialized on the MapAdapter m1 and m2 object. <br>
     * <b>Post-condition : </b> the exception is passed to the calling method , if this is not handled then the program ends.<br>
     * <b>Expected result : </b> ClassCastException thrown. <br>
     */
    @Test (expected = ClassCastException.class)
    public void retainAllClassCastException(){
        cv1.retainAll(new ListAdapter());
    }

    /***
     * <b>Test : </b> The proper functioning of HCollection.size() method on a ValueCollection. <br>
     * <b>Description : </b> it is checked that the number of elements that were inserted at the beginning in the ValueCollection match. <br>
     * <b>Pre-condition : </b> Two MapAdapter objects properly initialized, m1 is empty and m2 has 4 elements.<br>
     * ValueCollection cv1 and cv2 object are properly initialized on the MapAdapter m1 and m2 object. <br>
     * <b>Post-condition : </b> The size don't change <br>
     * <b>Expected result : </b> the size expected is the number of object that was introduced at the beginning into ValueCollection1 and ValueCollection2 through MapAdapter1 and MapAdapter2. <br>
     */
    @Test
    public void size() {
        assertTrue(cv1.size() == 0);
        assertTrue(cv2.size() == 4);
    }

    /***
     * <b>Test : </b> The proper functioning of HCollection.toArray() method on a ValueCollection. <br>
     * <b>Description : </b> an array of keys is generated by ValueCollection2 and it is verified that the elements of the array are contained in ValueCollection2 and Mapadapter2. <br>
     * <b>Pre-condition : </b> wo MapAdapter objects properly initialized, m1 is empty and m2 has 4 elements.<br>
     * ValueCollection cv1 and cv2 object are properly initialized on the MapAdapter m1 and m2 object. <br>
     *     cv1 = {  } <br>
     *     m1 = {  } <br>
     *     cv2 = { a , b , c , d } <br>
     *     m2 = { [0,a] , [1,b] , [2,c] , [3,d] } <br>
     *         Backing works. <br>
     * <b>Post-condition : </b> The ValueCollection don't change its status <br>
     * <b>Expected result : </b> the array contains the elements of ValueCollection2. <br>
     */
    @Test
    public void toArray() {
        Object[] values =  cv2.toArray();
        assertEquals(cv2.size(),values.length);
        for(int i = 0; i < cv2.size(); i++) {
            assertTrue(cv2.contains(values[i]));
        }
    }

    /***
     * <b>Test : </b> The proper functioning of HCollection.toArray(Object[] o) method on a ValueCollection. <br>
     * <b>Description : </b> two pairs are introduced into Mapadapter1 then an array is generated from it with the methodo toArray().
     * It is checked that the pairs are present in the ValueCollection1.
     * then this smaller array is passed to generate the ValueCollection2 key array.
     * Finally, check that the returned array is larger as the size of ValueCollection2 and contains all ValueCollection2 elements.<br>
     * <b>Pre-condition : </b>  Two MapAdapter objects properly initialized, m1 is empty and m2 has 4 elements.<br>
     * ValueCollection cv1 and cv2 object are properly initialized on the MapAdapter m1 and m2 object. <br>
     *     cv1 = {  } <br>
     *     m1 = {  } <br>
     *     cv2 = { a , b , c , d } <br>
     *     m2 = { [0,a] , [1,b] , [2,c] , [3,d] } <br>
     *         Backing works. <br>
     * <b>Post-condition : </b> The ValueCollection don't change its status <br>
     * <b>Expected result : </b> The array generated is an MapAdapter.key type and it contains the elements of the ValueCollection. <br>
     */
    @Test
    public void toArray2(){
        m1.put(10,"bratan");
        m1.put(22,"patzan");
        Object[] values1 = cv1.toArray();
        assertEquals(cv1.size(),values1.length);
        for(int i = 0 ; i < cv1.size(); i++) {
            System.out.println(values1[i]);
            assertTrue(cv1.contains(values1[i]));
        }
        Object[] values2 = cv2.toArray(values1);
        assertEquals(cv2.size(),values2.length);
        for(int i = 0; i < cv2.size(); i++)
            assertTrue(cv2.contains(values2[i]));

        Object[] values3 = new Object[10];
        values3 = cv2.toArray(values3);
    }

    /***
     * <b>Test : </b> The wrong functioning of HCollection.toArray() method on a ValueCollection. <br>
     * <b>Description : </b> insert a null parameter on the toArray() method applied to an ValueCollection <br>
     * <b>Pre-condition : </b> Two MapAdapter objects properly initialized, m1 is empty and m2 has 4 elements.<br>
     * ValueCollection cv1 and cv2 object are properly initialized on the MapAdapter m1 and m2 object. <br>
     * <b>Post-condition : </b> the exception is passed to the calling method , if this is not handled then the program ends. <br>
     * <b>Expected result : </b> NullPointerException thrown <br>
     */
    @Test (expected = NullPointerException.class)
    public void toArrayNull() {
        cv2.toArray(null);
    }


}