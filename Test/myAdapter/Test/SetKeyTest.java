package myAdapter.Test;
import myAdapter.*;
import myAdapter.UnsupportedOperationException;
import org.junit.Test;
import org.junit.Before;
import static org.junit.Assert.*;


/***
 * Testing a HSet of MapAdapter.setKey() <br>
 * This class was generated to return keySet objects from the map, so it implements HSet, and must respond appropriately to the HSet interface. <br>
 * Since the class is private, a MapAdapter variable is used, which through the SetKey() method will instantiate the object to be tested with HSet’s methods.<br>
 * The method that instantiates the object to be tested is setup(), which will be executed before all tests.<br>
 * In the first part the HSet methods will be tested, but in the second part the backing to MapAdapter will be verified.<br>
 * Tests of this class are performed by the ESTestRunner class. <br>
 * @see SetKeyTestRunner SetKeyTestRunner. <br>
 * @see MapAdapter MapAdapter. <br>
 *
 */
public class SetKeyTest {
    /***
     * Private MapAdapter variable that is used to make an SetKey.
     */
    private MapAdapter m1;
    /***
     * Private MapAdapter variable that is used to make an SetKey with some key objects.
     */
    private MapAdapter m2;
    /***
     * Private HSet variable that is implemented by the method keySet().<br>
     * For simplicity we will use to define it in this class as KeySet.
     */
    private HSet sk1;
    /***
     * Private HSet variable that is implemented by the method keySet.<br>
     * For simplicity we will use to define it in this class as KeySet.<br>
     * This object already have some elements inside.
     */
    private HSet sk2;

    /***
     * <b>Test : </b> <br>
     * <b>Description : </b> This method instantiates MapAdapter m1 and after instantiates an HSet object of SetKey nature sk1. <br>
     * It also instantiates a MapAdapter m2 with some additional elements inside, and a HSet of SetKey nature sk2 that has the elements of ms2. <br>
     * Instantiation of these objects occurs before all test class methods. <br>
     * It is also checked that all the object instantiated have not a reference to null.
     *  sk1 = {  } <br>
     *  m1 = {  } <br>
     *  sk2 = { 0 , 1 , 2 , 3 } <br>
     *  m2 = { [0,a] , [1,b] , [2,c] , [3,d] } <br>
     * <b>Pre-condition : </b> the sample variables have been created without being instantiated <br>
     * <b>Post-condition : </b> the objects have not a reference to null <br>
     * <b>Expected result : </b> the objects have not a reference to null <br>
     */
    @Before
    public void setup(){
        m1 = new MapAdapter();
        sk1 = m1.keySet();
        m2 = new MapAdapter();
        m2.put(0,"a");
        m2.put(1,"b");
        m2.put(2,"c");
        m2.put(3,"d");
        sk2 = m2.keySet();
        assertTrue(m1 != null);
        assertTrue(m2 != null);
        assertTrue(sk1 != null);
        assertTrue(sk2 != null);
    }


    /***
     * <b>Test : </b>  This method tests the right initialization of SetKey after setup() method. <br>
     * <b>Description : </b> The SetKey sk1 and sk2 are implemented with different size, and it is verified by the method size() of HSet. <br>
     * Also it is verified that the SetKey sk1, sk2 and MapAdapter m1 and m2 have not a reference to null. <br>
     * Finally it is verified the size of each elements and the fact that one SetKey is empty and the over one is not Empty. <br>
     * <b>Pre-condition : </b> Two MapAdapter objects properly initialized, m1 is empty and m2 has 4 elements.<br>
     * SetKey sk2 object properly initialized on the MapAdapter m2 object.<br>
     *      sk1 = { } <br>
     *      m1 = {  } <br>
     *      sk2 = { 0 , 1 , 2 , 3 } <br>
     *      m2 = { [0,a] , [1,b] , [2,c] , [3,d] } <br>
     * <b>Post-condition : </b> The objects are proper initialized. <br>
     * <b>Expected result : </b> The objects have not a reference to null <br>
     */
    @Test
    public void testSetKeyInitialization() {
        assertTrue(m1 != null);
        assertTrue(m2 != null);
        assertTrue(sk1 != null);
        assertTrue(sk2 != null);
        assertTrue(sk1.size() == 0);
        assertTrue(sk1.isEmpty());
        assertTrue(sk2.size() == 4);
        assertFalse(sk2.isEmpty());
    }

    /***
     * <b>Test : </b> the wrong functioning of HSet.add() method. <br>
     * <b>Description : </b> In any case this method must throw UnsupportedOperationException. <br>
     * <b>Pre-condition : </b> Two MapAdapter objects properly initialized, m1 is empty and m2 has 4 elements.<br>
     * SetKey sk2 object properly initialized on the MapAdapter m2 object. <br>
     * <b>Post-condition : </b> the exception to the calling method is passed, if this is not handled then the program ends. <br>
     * <b>Expected result : </b>  UnsupportedOperationException thrown <br>
     */
    @Test (expected = UnsupportedOperationException.class)
    public void add() {
        sk1.add("a");
    }


    /***
     * <b>Test : </b> the wrong functioning of HSet.adAll() method. <br>
     * <b>Description : </b> In any case this method must throw UnsupportedOperationException. <br>
     * <b>Pre-condition : </b> Two MapAdapter objects properly initialized, m1 is empty and m2 has 4 elements.<br>
     * SetKey sk2 object properly initialized on the MapAdapter m2 object. <br>
     * <b>Post-condition : </b> the exception to the calling method is passed, if this is not handled then the program ends. <br>
     * <b>Expected result : </b>  UnsupportedOperationException thrown <br>
     */
    @Test (expected = UnsupportedOperationException.class)
    public void addAll() {
        sk1.add(new java.util.Vector());
    }

    /***
     * <b>Test : </b> This method tests the HSet.clear() method. <br>
     * <b>Description : </b> The size of SetKey2 is checked and it is 4, then a clear() is made on it and finally it is checked that his size is 0. <br>
     * At the same time it is verified that the MapAdapter m1 size change as the size of SetKey2 sk1. <br>
     * <b>Pre-condition : </b> Two MapAdapter objects properly initialized, m1 is empty and m2 has 4 elements.<br>
     * SetKey sk2 object properly initialized on the MapAdapter m2 object.<br>
     *      sk1 = {  } <br>
     *      m1 = {  } <br>
     *      sk2 = { 0 , 1 , 2 , 3 } <br>
     *      m2 = { [0,a] , [1,b] , [2,c] , [3,d] } <br>
     *          Backing works. <br> <br>
     * <b>Post-condition : </b> The SetKey is clear. <br>
     * <b>Expected result : </b> clear erase the elements of the SetKey. <br>
     */
    @Test
    public void clear() {
        assertTrue(sk2.size() == 4);
        assertTrue(m2.size() == 4);
        sk2.clear();
        assertTrue(sk2.size() == 0);
        assertTrue(m2.size() == 0);
    }

    /***
     * <b>Test : </b> This method tests the HSet.contains() method. <br>
     * <b>Description : </b> 3 Key are created which through the contains() method are verified of their presence in SetKey. <br>
     * 1 Key is already present and is verified, while the other two are Entries that were not introduced initially and therefore were not found. <br>
     * <b>Pre-condition : </b> Two MapAdapter objects properly initialized, m1 is empty and m2 has 4 elements.<br>
     * SetKey sk2 object properly initialized on the MapAdapter m2 object.<br>
     *      sk1 = {  } <br>
     *      m1 = {  } <br>
     *      sk2 = { 0 , 1 , 2 , 3 } <br>
     *      m2 = { [0,a] , [1,b] , [2,c] , [3,d] } <br>
     *          Backing works. <br> <br>
     * <b>Post-condition : </b> the objects don't change their state after contains is called. <br>
     * <b>Expected result : </b> contains return true if an object is contained or false if not. <br>
     */
    @Test
    public void contains() {
        Object k1 = 0;
        Object k2 = 1;
        Object k3 = 4;
        assertTrue(sk2.contains(k1));
        assertTrue(sk2.contains(k2));
        assertFalse(sk2.contains(k3));
    }

    /***
     * <b>Test : </b> the wrong functioning of HSet.contains() method. <br>
     * <b>Description : </b> In this case is expected that the method throws a NullPointerException because in the method contains() was introduced a null parameter. <br>
     * <b>Pre-condition : </b> Two MapAdapter objects properly initialized, m1 is empty and m2 has 4 elements.<br>
     * SetKey sk1, sk2 object properly initialized on the MapAdapter m1 ,m2 object. <br>
     * <b>Post-condition : </b>  the exception to the calling method is passed, if this is not handled then the program ends. <br>
     * <b>Expected result : </b> NullPointerException thrown. <br>
     */
    @Test (expected = NullPointerException.class)
    public void contains_Null() {
        sk1.contains(null);
    }

    /***
     * <b>Test : </b> this method tests the HSet.containsAll() method. <br>
     * <b>Description : </b> 3 pairs are added to MapAdapter1, SetKey1 size is checked, and SetKey2 is compared symmetrically with SetKey1. <br>
     * Finally it was added a fourth pair in SetKey2 from obtain 4 identical elements in both SetKeys,
     * it check the size of SetKey2 and then the two SetKeys are symmetrically equal .<br>
     * It has not been possible to check if the containsAll() method launches ClassCastException,
     * because the code does not compile if a class different from that indicated by the interface is introduced.<br>
     * <b>Pre-condition : </b> Two MapAdapter objects properly initialized, m1 is empty and m2 has 4 elements.<br>
     * SetKey sk2 object properly initialized on the MapAdapter m2 object.<br>
     *      sk1 = {  } <br>
     *      m1 = {  } <br>
     *      sk2 = { 0 , 1 , 2 , 3 } <br>
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
        assertTrue(sk2.size() == 4);
        assertTrue(sk1.size() == 3);
        assertTrue(sk2.containsAll(sk1));
        assertFalse(sk1.containsAll(sk2));
        m1.put(3,"d");
        assertTrue(sk1.size() == 4);
        assertTrue(sk2.containsAll(sk1));
    }

    /***
     * <b>Test : </b> This method tests the HSet.containsAll() method. <br>
     * <b>Description : </b> insert a null parameter on the remove method applied to an SetKey. <br>
     * <b>Pre-condition : </b> In this case is expected that the method throws a NullPointerException because in the method containsAll()
     * has been introduce a null parameter. <br>
     * <b>Post-condition : </b> the exception to the calling method is passed, if this is not handled then the program ends. <br>
     * <b>Expected result : </b> NullPointerException thrown.  <br>
     */
    @Test (expected = NullPointerException.class)
    public void containsAll_Null(){
        sk1.containsAll(null);
    }

    /***
     * <b>Test : </b> This method tests the HSet.equals() method. <br>
     * <b>Description : </b> SetKey1 is initially compared to SetKey2 which is false because one is empty and the other has 4 elements,
     * then to SetKey1 adding to the Mapadapter1 4 pairs with the same keys of sk1 but with different values.
     * Finally, SetKey1 and SetKey2 are symmetrically compared.<br>
     * <b>Pre-condition : </b>  Two MapAdapter objects properly initialized, m1 is empty and m2 has 4 elements.<br>
     * SetKey sk2 object properly initialized on the MapAdapter m2 object.<br>
     *      sk1 = {  } <br>
     *      m1 = {  } <br>
     *      sk2 = { 0 , 1 , 2 , 3 } <br>
     *      m2 = { [0,a] , [1,b] , [2,c] , [3,d] } <br>
     *          Backing works. <br>
     * <b>Post-condition : </b> the objects don't change their status if equals() is called. <br>
     * <b>Expected result : </b> equals return true with two SetKey that they are the same keys. <br>
     */
    @Test
    public void equals() {
        assertFalse(sk1.equals(sk2));
        m1.put(0,"x");
        m1.put(1,"y");
        m1.put(2,"z");
        m1.put(3,"j");
        assertTrue(sk1.equals(sk2));
        assertTrue(sk2.equals(sk1));
    }

    /***
     * <b>Test : </b> the wrong functioning of Hset.equals on a SetKey. <br>
     * <b>Description : </b> The method returns false because a null parameter has been introduced. <br>
     * <b>Pre-condition : </b> Two MapAdapter objects properly initialized, m1 is empty and m2 has 4 elements.<br>
     * SetKey sk1 and sk2 objects properly initialized on the MapAdapter m1 and m2.<br>
     * <b>Post-condition : </b> the state of the SetKey don't change if equals() is called. <br>
     * <b>Expected result : </b> equals return false <br>
     */
    @Test
    public void equalsToNull() {
        assertFalse(sk1.equals(null));
    }


    /***
     * <b>Test : </b> This method tests the wrong functioning of HSet.equals on a SetKey. <br>
     * <b>Description : </b> The method returns false because a different class from SetKey has been introduced as a parameter.<br> <br>
     * <b>Pre-condition : </b> Two MapAdapter objects properly initialized, m1 is empty and m2 has 4 elements.<br>
     * SetKey sk1 and sk2 object properly initialized on the MapAdapter m1 and m2.<br>
     * <b>Post-condition : </b> the state of the object don't change if equals() is called. <br>
     * <b>Expected result : </b> equals return false. <br>
     */
    @Test
    public void equalsToAnotheTypeOfObject() {
        assertFalse(sk1.equals(new java.util.Vector()));
    }

    /***
     * <b>Test : </b> This method tests the HSet.hashCode() method. <br>
     * <b>Description : </b> Compare the hashCode of two SetKey with different pairs,
     * then add the elements of the full map to the empty one and verify that the generated hashcodes are equal.<br>
     * At the end it was added an element to one of the two maps to verify that the hashCodes are different.<br><br>
     * <b>Pre-condition : </b> Two MapAdapter objects properly initialized, m1 is empty and m2 has 4 elements.<br>
     * SetKey sk1 and sk2 object properly initialized on the MapAdapter m1 and m2.<br>
     *     sk1 = {  } <br>
     *     m1 = {  } <br>
     *     sk2 = { 0 , 1 , 2 , 3 } <br>
     *     m2 = { [0,a] , [1,b] , [2,c] , [3,d] } <br>
     *          Backing works. <br>
     * <b>Post-condition : </b> the hashcode remain the same if the SetKeys or MapAdapter associated don't change. <br>
     * <b>Expected result : </b> Two hashcode match if two SetKey have the same elements. <br>
     */
    @Test
    public void hashcode() {
        assertNotEquals(sk1.hashCode(), sk2.hashCode());
        m1.putAll(m2);
        assertEquals(sk1.hashCode(),sk1.hashCode());
        m1.put(12,"babuska");
        assertNotEquals(sk1.hashCode(), sk2.hashCode());
    }

    /***
     * <b>Test : </b> the proper functioning of HSet.isEmpty on a SetKey. <br>
     * <b>Description : </b> It is verified that SetKey1 is empty and SetKey2,MaoAdapter2 is not empty, SetKey2 is cleared and it is verified that it is empty. <br>
     * It is also verified that MapAdapter m2 is empty. MapAdapter1 remain empty. <br>
     * <b>Pre-condition : </b> Two MapAdapter objects properly initialized, m1 is empty and m2 has 4 elements.<br>
     * SetKey sk1 and sk2 object properly initialized on the MapAdapter m1 and m2.<br>
     *      sk1 = {  } <br>
     *      m1 = {  } <br>
     *      sk2 = { 0 , 1 , 2 , 3 } <br>
     *      m2 = { [0,a] , [1,b] , [2,c] , [3,d] } <br>
     *          Backing works. <br>
     * <b>Post-condition : </b> The SetKey1 and SetKey 2 and MapAdapter 2 remain empty after this check. <br>
     * <b>Expected result : </b> the SetKey1, SetKey2, MapAdapter1 and MapAdapter2  are Empty. <br>
     */
    @Test
    public void isEmpty() {
        assertTrue(sk1.isEmpty());
        assertFalse(sk2.isEmpty());
        assertFalse(m2.isEmpty());
        sk2.clear();
        assertTrue(sk2.isEmpty());
        assertTrue(sk1.isEmpty());
        assertTrue(m2.isEmpty());
    }

    /**
     * <b>Tests</b> the proper functioning of iterator() method.<br>
     * <b>Description:</b> it calls the iterator() method on the 2 SetKey objects and checks that they are not null.<br>
     * <b>Pre-condition : </b> Two MapAdapter objects properly initialized, m1 is empty and m2 has 4 elements.<br>
     * Two SetKey objects (sk1 and sk2) properly initialized on the MapAdapter objects.<br>
     * Two HIterator objects (h1 and h2) properly initialized on the SetKey objects.<br>
     * <b>Post-condition : </b> the iterator are not null objects.<br>
     * <b>Expected result : </b> h1 and h2 are not null.<br>
     */
    @Test
    public void iterator(){
        HIterator h1 = sk1.iterator();
        HIterator h2 = sk2.iterator();
        assertFalse(h1.equals(null));
        assertFalse(h2.equals(null));
        assertFalse(h1 == null);
        assertFalse(h2 == null);
    }

    /***
     * <b>Test</b> The proper functioning of HIterator.hasNext() on a SetKey.  <br>
     * <b>Description : </b>This method tests if the iterator implemented on SetKey has next elements to iterate.<br>
     * <b>Pre-condition : </b> Two MapAdapter objects properly initialized, m1 is empty and m2 has 4 elements.<br>
     * Two SetKey objects (sk1 and sk2) properly initialized on the MapAdapter objects.<br>
     * Two HIterator objects (h1 and h2) properly initialized on the SetKey objects.<br>
     * <b>Post-condition : </b> the iterators are not null objects. <br>
     * <b>Expected result : </b> h1 has not next elements and h2 has next elements. <br>
     */
    @Test
    public void iteratorHasNext(){
        HIterator h1 = sk1.iterator();
        HIterator h2 = sk2.iterator();
        assertFalse(h1.hasNext());
        assertTrue(h2.hasNext());
    }

    /***
     * <b>Test : </b> The proper functioning of HIterator.next() on a SetKey. <br>
     * <b>Description : </b> This method tests if the iterator implemented on SetKey give back a key. <br>
     * An iterator is generated on SetKey2 that is not empty, then for each key object returned by the iterator its presence in Mapadapter2 and SetKey2 is verified. <br>
     * In this case we also checked the backing between Mapadapter and SetKey of the iterator.<br>
     * <b>Pre-condition : </b> Two MapAdapter objects properly initialized, m1 is empty and m2 has 4 elements.<br>
     * Two SetKey objects (sk1 and sk2) properly initialized on the MapAdapter objects.<br>
     * HIterator objects and h2 properly initialized on the SetKey sk2 object.<br>
     *      sk1 = {  } <br>
     *      m1 = {  } <br>
     *      sk2 = { 0 , 1 , 2 , 3 } <br>
     *      m2 = { [0,a] , [1,b] , [2,c] , [3,d] } <br>
     *          Backing works. <br>
     * <b>Post-condition : </b> The iterator don't change the elements in the MapAdapter m2 and the SetKey sk2. <br>
     * <b>Expected result : </b> All the key elements that the iterator h2 give back are present in the the MapAdapter m2 and also into the SetKey sk2.  <br>
     */
    @Test
    public void iteratorNextElement(){
        HIterator h2 = sk2.iterator();
        while(h2.hasNext()) {
            Object keys =  h2.next();
            assertTrue(m2.containsKey(keys));
            assertTrue(sk2.contains(keys));
        }
        assertTrue(sk2.size() == 4);
        assertTrue(m2.size() == 4);
    }

    /***
     * <b>Test : </b>The proper functioning of HIterator.remove() on a SetKey. <br>
     * <b>Description : </b> This method tests if the iterator implemented on SetKey remove the last element iterated. <br>
     * an iterator is created on SetKey sk2, from which an key is extracted, the key and value pair is verified if present in the map.<br>
     * For each remove() of the iterator the size of Mapadapter and SetKey is checked. Finally check that SetKey and Mapadapter are empty and have size 0.<br>
     * <b>Pre-condition : </b> Two MapAdapter objects properly initialized, m1 is empty and m2 has 4 elements.<br>
     * Two SetKey objects (sk1 and sk2) properly initialized on the MapAdapter objects.<br>
     * HIterator objects and h2 properly initialized on the SetKey sk2 object.<br>
     * The HIterator must call next() before to remove the element that next() found.<br>
     *      sk1 = {  } <br>
     *      m1 = {  } <br>
     *      sk2 = { 0 , 1 , 2 , 3 } <br>
     *      m2 = { [0,a] , [1,b] , [2,c] , [3,d] } <br>
     *          Backing works. <br>
     * <b>Post-condition : </b> The SetKey sk2 and the MapAdapter m2 are empty and their size is 0. <br>
     * <b>Expected result : </b> All the elements from SetKey sk2 and MapAdapter m2 are removed by the HIterator. <br>
     */
    @Test
    public void iteratorRemoveElement() {
        HIterator h2 = sk2.iterator();
        int i = 4;
        assertTrue(sk2.size() == i);
        while(h2.hasNext()){
            Object key = h2.next();
            assertTrue(m2.containsKey(key));
            h2.remove();
            assertTrue(sk2.size() == --i );
            assertTrue(m2.size() == i);
        }
        assertTrue(sk2.size() == 0);
        assertTrue(m2.size() == 0);
        assertTrue(sk2.isEmpty());
        assertTrue(m2.isEmpty());
    }

    /***
     * <b>Test : </b> The proper functioning of HSet.remove() method on a SetKey.<br>
     * <b>Description : </b>
     * Initially the dimensions of Mapadapter m2 and SetKey sk2 are checked. <br>
     * After that it is checked that every time it is deleted an item from sk2 the size of sk2 and m2 decreases until it becomes zero. <br>
     * so it is checked that the backing also works.<br>
     * Finally an element is removed that is not present in the SetKey, therefore this removals is not true. <br>
     * <b>Pre-condition : </b>  It was instantiated correctly a Mapadapter m2 with 4 elements and from this an SetKey sk2
     * was initialized correctly with the same 4 elements. <br>
     *      sk1 = {  } <br>
     *      m1 = {  } <br>
     *      sk2 = { 0 , 1 , 2 , 3 } <br>
     *      m2 = { [0,a] , [1,b] , [2,c] , [3,d] } <br>
     *          Backing works.
     * <b>Post-condition :</b> the SetKey size is 0 and it's empty. <br>
     * <b>Expected result : </b> after every remove the size of the SetKey decrease by one.
     */
    @Test
    public void remove(){
        assertTrue(sk2.size() == 4);
        assertTrue(m2.size() == 4);
        assertTrue(sk2.remove(0));
        assertTrue(sk2.size() == 3);
        assertTrue(m2.size() == 3);
        assertTrue(sk2.remove(1));
        assertTrue(sk2.size() == 2);
        assertTrue(m2.size() == 2);
        assertTrue(sk2.remove(2));
        assertTrue(sk2.size() == 1);
        assertTrue(m2.size() == 1);
        assertTrue(sk2.remove(3));
        assertTrue(sk2.size() == 0);
        assertTrue(m2.size() == 0);
        assertTrue(sk2.isEmpty());
        assertTrue(m2.isEmpty());
        assertFalse(sk2.remove(4));
    }

    /***
     * <b>Test : </b> The wrong functioning of HSet.remove() method on a SetKey.<br>
     * <b>Description : </b>  insert a null parameter on the remove method applied to an SetKey. <br>
     * <b>Pre-condition : </b> Two MapAdapter objects properly initialized, m1 is empty and m2 has 4 elements.<br>
     * Two SetKey objects (sk1 and sk2) properly initialized on the MapAdapter objects.<br>
     * <b>Post-condition : </b> the exception is passed to the calling method , if this is not handled then the program ends. <br>
     * <b>Expected result : </b> NullPointerException thrown <br>
     */
    @Test (expected = NullPointerException.class)
    public void removeANullObject() {
        sk2.remove(null);
    }

    /***
     * <b>Test : </b> The proper functioning of HSet.remove() method on a SetKey. <br>
     * <b>Description : </b> Initially try to remove the empty sk1 from sk2 with 4 items with negative result, then vice versa with negative result.<br>
     * The two initial elements of sk2 to sk1 are added through MapAdapter m1. finally it is removed sk1 with two elements from sk2 with positive result. <br>
     * Finally it is checked the presence of the elements in sk2 and its final dimension that is 2. <br>
     * <b>Pre-condition : </b> Two MapAdapter objects properly initialized, m1 is empty and m2 has 4 elements.<br>
     * SetKey sk1 and sk2 object are properly initialized on the MapAdapter m1 and m2 object. <br>
     *     sk1 = {  } <br>
     *     m1 = {  } <br>
     *     sk2 = { 0 , 1 , 2 , 3 } <br>
     *     m2 = { [0,a] , [1,b] , [2,c] , [3,d] } <br>
     *         Backing works. <br>
     * <b>Post-condition : </b> The MapAdapter m2 and SetKey sk2 have the same two final object inside <br>
     * <b>Expected result : </b> The method removeAll() removes the collection not empty, and also don't remove nothing when the collection introduced is empty. <br>
     */
    @Test
    public void removeAll(){
        assertFalse(sk2.removeAll(sk1));
        assertFalse(sk1.removeAll(sk2));
        m1.put(0,"a");
        m1.put(1,"b");
        assertTrue(sk2.removeAll(sk1));
        assertFalse(sk2.contains(0));
        assertFalse(sk2.contains(1));
        assertTrue(sk2.contains(2));
        assertTrue(sk2.contains(3));
        assertTrue(sk2.size() == 2);
        assertTrue(m2.size() == 2);
    }

    /***
     * <b>Test : </b> The wrong functioning of HSet.removeAll() method on a SetKey. <br>
     * <b>Description : </b> Insert a null parameter on the remove method applied to an SetKey. <br>
     * <b>Pre-condition : </b> Two MapAdapter objects properly initialized, m1 is empty and m2 has 4 elements.<br>
     * SetKey sk1 and sk2 object are properly initialized on the MapAdapter m1 and m2 object. <br>
     * <b>Post-condition : </b> the exception is passed to the calling method, if this is not handled then the program ends. <br>
     * <b>Expected result : </b> NullPointerException thrown <br>
     */
    @Test (expected = NullPointerException.class)
    public void removeALLNull(){
        sk2.removeAll(null);
    }

    /***
     * <b>Test : </b> The wrong functioning of HSet.removeAll() method on a SetKey.  <br>
     * <b>Description : </b> Insert a HCollection as a parameter that is not compatible with SetKey. <br>
     * <b>Pre-condition : </b> Two MapAdapter objects properly initialized, m1 is empty and m2 has 4 elements.<br>
     * SetKey sk1 and sk2 object are properly initialized on the MapAdapter m1 and m2 object. <br>
     * <b>Post-condition : </b> the exception is passed to the calling method, if this is not handled then the program ends. <br>
     * <b>Expected result : </b> ClassCastException thrown. <br>
     */
    @Test (expected = ClassCastException.class)
    public void removeAllClassCastException() {
        sk2.removeAll(new ListAdapter());
    }

    /***
     * <b>Test : </b> he proper functioning of HSet.retainAll() method on a SetKey.<br>
     * <b>Description : </b> the size of SetKey1 and SetKey2 is checked, SetKey2.ratainall(SetKey1) is done, which returns false as SetKey1 is empty.<br>
     * Add two elements to SetKey1 and check that SetKey2.retainall(SetKey1) returns true and that now SetKey2 has only two elements. <br>
     * <b>Pre-condition : </b> wo MapAdapter objects properly initialized, m1 is empty and m2 has 4 elements.<br>
     * SetKey sk1 and sk2 object are properly initialized on the MapAdapter m1 and m2 object. <br>
     *     sk1 = {  } <br>
     *     m1 = {  } <br>
     *     sk2 = { 0 , 1 , 2 , 3 } <br>
     *     m2 = { [0,a] , [1,b] , [2,c] , [3,d] } <br>
     *         Backing works. <br>
     * <b>Post-condition : </b> maps and SetKeys maintain new status. <br>
     * <b>Expected result : </b> SetKey2 must keep the common items that have been added to SetKey1 by Mapadapter1. <br>
     */
    @Test
    public void retainAll() {
        assertTrue(sk1.size() == 0);
        assertTrue(sk2.size() == 4);
        assertFalse(sk2.retainAll(sk1));
        m1.put(0,"x");
        m1.put(1,"y");
        assertTrue(sk1.size() == 2);
        assertTrue(sk2.retainAll(sk1));
        assertTrue(sk2.size() == 2);
        assertTrue(m2.size() == 2);
        assertTrue(sk2.contains(0));
        assertTrue(sk2.contains(1));
        assertFalse(sk2.contains(2));
        assertFalse(sk2.contains(3));
        assertTrue(sk1.size() == 2);
        assertTrue(sk2.size() == 2);
        assertTrue(m1.size() == 2);
        assertTrue(m2.size() == 2);
    }

    /***
     * <b>Test : </b>The wrong functioning of HSet.retainAll() method on a SetKey. <br>
     * <b>Description : </b> insert a null parameter on the retainAll() method applied to an SetKey. <br>
     * <b>Pre-condition : </b> Two MapAdapter objects properly initialized, m1 is empty and m2 has 4 elements.<br>
     * SetKey sk1 and sk2 object are properly initialized on the MapAdapter m1 and m2 object. <br>
     * <b>Post-condition : </b> the exception is passed to the calling method, if this is not handled then the program ends. <br>
     * <b>Expected result : </b> NullPointerException thrown <br>
     */
    @Test (expected = NullPointerException.class)
    public void retainAllNull(){
        sk1.retainAll(null);
    }

    /***
     * <b>Test : </b> The wrong functioning of HSet.retainAll() method on a SetKey. <br>
     * <b>Description : </b> insert a ListAdapter class as parameter on the retainAll() method applied to an SetKey. <br>
     * <b>Pre-condition : </b> Two MapAdapter objects properly initialized, m1 is empty and m2 has 4 elements.<br>
     * SetKey sk1 and sk2 object are properly initialized on the MapAdapter m1 and m2 object. <br>
     * <b>Post-condition : </b> the exception is passed to the calling method , if this is not handled then the program ends.<br>
     * <b>Expected result : </b> ClassCastException thrown. <br>
     */
    @Test (expected = ClassCastException.class)
    public void retainAllClassCastException(){
        sk1.retainAll(new ListAdapter());
    }

    /***
     * <b>Test : </b> The proper functioning of HSet.size() method on a SetKey. <br>
     * <b>Description : </b> it is checked that the number of elements that were inserted at the beginning in the SetKey match. <br>
     * <b>Pre-condition : </b> Two MapAdapter objects properly initialized, m1 is empty and m2 has 4 elements.<br>
     * SetKey sk1 and sk2 object are properly initialized on the MapAdapter m1 and m2 object. <br>
     * <b>Post-condition : </b> The size don't change <br>
     * <b>Expected result : </b> the size expected is the number of object that was introduced at the beginning into SetKey1 and SetKey2 through MapAdapter1 and MapAdapter2. <br>
     */
    @Test
    public void size() {
        assertTrue(sk1.size() == 0);
        assertTrue(sk2.size() == 4);
    }

    /***
     * <b>Test : </b> The proper functioning of HSet.toArray() method on a SetKey. <br>
     * <b>Description : </b> an array of keys is generated by SetKey2 and it is verified that the elements of the array are contained in SetKey2 and Mapadapter2. <br>
     * <b>Pre-condition : </b> wo MapAdapter objects properly initialized, m1 is empty and m2 has 4 elements.<br>
     * SetKey sk1 and sk2 object are properly initialized on the MapAdapter m1 and m2 object. <br>
     *     sk1 = {  } <br>
     *     m1 = {  } <br>
     *     sk2 = { 0 , 1 , 2 , 3 } <br>
     *     m2 = { [0,a] , [1,b] , [2,c] , [3,d] } <br>
     *         Backing works. <br>
     * <b>Post-condition : </b> The SetKey don't change its status <br>
     * <b>Expected result : </b> the array contains the elements of SetKey2. <br>
     */
    @Test
    public void toArray() {
        Object[] keys =  sk2.toArray();
        assertEquals(sk2.size(),keys.length);
        for(int i = 0; i < sk2.size(); i++) {
            assertTrue(sk2.contains(keys[i]));
        }
    }

    /***
     * <b>Test : </b> The proper functioning of HSet.toArray(Object[] o) method on a SetKey. <br>
     * <b>Description : </b> two pairs are introduced into Mapadapter1 then an array is generated from it with the methodo toArray().
     * It is checked that the pairs are present in the SetKey1.
     * then this smaller array is passed to generate the SetKey2 key array.
     * Finally, check that the returned array is larger as the size of SetKey2 and contains all SetKey2 elements.<br>
     * <b>Pre-condition : </b>  Two MapAdapter objects properly initialized, m1 is empty and m2 has 4 elements.<br>
     * SetKey sk1 and sk2 object are properly initialized on the MapAdapter m1 and m2 object. <br>
     *     sk1 = {  } <br>
     *     m1 = {  } <br>
     *     sk2 = { 0 , 1 , 2 , 3 } <br>
     *     m2 = { [0,a] , [1,b] , [2,c] , [3,d] } <br>
     *         Backing works. <br>
     * <b>Post-condition : </b> The SetKey don't change its status <br>
     * <b>Expected result : </b> The array generated is an MapAdapter.key type and it contains the elements of the SetKey. <br>
     */
    @Test
    public void toArray2(){
        m1.put(2,"bratan");
        m1.put(12,"patzan");
        Object[] keys1 = sk1.toArray();
        assertEquals(sk1.size(),keys1.length);
        for(int i = 0 ; i < sk1.size(); i++)
            assertTrue(sk1.contains(keys1[i]));

        Object[] keys2 = sk2.toArray(keys1);
        assertEquals(sk2.size(),keys2.length);
        for(int i = 0; i < sk2.size(); i++)
            assertTrue(sk2.contains(keys2[i]));

        Object[] keys3 = new Object[10];
        keys3 = sk2.toArray(keys3);
    }

    /***
     * <b>Test : </b> The wrong functioning of HSet.toArray() method on a SetKey. <br>
     * <b>Description : </b> insert a null parameter on the toArray() method applied to an SetKey <br>
     * <b>Pre-condition : </b> Two MapAdapter objects properly initialized, m1 is empty and m2 has 4 elements.<br>
     * SetKey sk1 and sk2 object are properly initialized on the MapAdapter m1 and m2 object. <br>
     * <b>Post-condition : </b> the exception is passed to the calling method , if this is not handled then the program ends. <br>
     * <b>Expected result : </b> NullPointerException thrown <br>
     */
    @Test (expected = NullPointerException.class)
    public void toArrayNull() {
        sk2.toArray(null);
    }


}