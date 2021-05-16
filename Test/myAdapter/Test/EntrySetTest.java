package myAdapter.Test;
import myAdapter.*;
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
 * @see EntrySetTestRunner EntrySestTestRunner.<br>
 * @see MapAdapter MapAdapter. <br>
 *
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
     * Private HSet variable that is implemented by the method entrySet().<br>
     * For simplicity we will use to define it in this class as EntrySet.
     */
    private HSet es1;
    /***
     * Private HSet variable that is implemented by the method EntrySet.<br>
     * For simplicity we will use to define it in this class as EntrySet.<br>
     * This object already have some elements inside.
     */
    private HSet es2;

    /***
     * <b>Test : </b> Setup test, this is done before every test <br>
     * <b>Description : </b> This method instantiates MapAdapter m1 and after instantiates an HSet object of EntrySet nature es1. <br>
     * It also instantiates a MapAdapter m2 with some additional elements inside, and a HSet of EntrySet nature es2 that has the elements of ms2. <br>
     * Instantiation of these objects occurs before all test class methods. <br>
     * It is also checked that all the object instantiated have not a reference to null.
     *  es1 = m1 = {  } <br>
     *  es2 = m2 = { [0,a] , [1,b] , [2,c] , [3,d] } <br>
     * <b>Pre-condition : </b> the sample variables have been created without being instantiated <br>
     * <b>Post-condition : </b> the objects have not a reference to null <br>
     * <b>Expected result : </b> the objects have not a reference to null <br>
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
        assertTrue(m1 != null);
        assertTrue(m2 != null);
        assertTrue(es1 != null);
        assertTrue(es2!= null);
    }


    /***
     * <b>Test : </b>  This method tests the right initialization of EntrySet after setup() method. <br>
     * <b>Description : </b> The EntrySet es1 and es2 are implemented with different size, and it is verified by the method size() of HSet. <br>
     * Also it is verified that the EntrySet es1, es2 and MapAdapter m1 and m2 have not a reference to null. <br>
     * Finally it is verified the size of each elements and the fact that one EntrySet is empty and the over one is not Empty. <br>
     * <b>Pre-condition : </b> Two MapAdapter objects properly initialized, m1 is empty and m2 has 4 elements.<br>
     * EntrySet es2 object properly initialized on the MapAdapter m2 object.<br>
     *      es1 = m1 = {  } <br>
     *      es2 = m2 = { [0,a] , [1,b] , [2,c] , [3,d] } <br>
     * <b>Post-condition : </b> The objects are proper initialized. <br>
     * <b>Expected result : </b> The objects have not a reference to null <br>
     */
    @Test
    public void testEntrySetInitialization() {
        assertTrue(m1 != null);
        assertTrue(m2 != null);
        assertTrue(es1 != null);
        assertTrue(es2!= null);
        assertTrue(es1.size() == 0);
        assertTrue(es1.isEmpty());
        assertTrue(es2.size() == 4);
        assertFalse(es2.isEmpty());
    }

     /***
     * <b>Test : </b> the wrong functioning of HSet.add() method. <br>
     * <b>Description : </b> In any case this method must throw UnsupportedOperationException. <br>
     * <b>Pre-condition : </b> Two MapAdapter objects properly initialized, m1 is empty and m2 has 4 elements.<br>
     * EntrySet es2 object properly initialized on the MapAdapter m2 object. <br>
     * <b>Post-condition : </b> the exception to the calling method is passed, if this is not handled then the program ends. <br>
     * <b>Expected result : </b>  UnsupportedOperationException thrown <br>
     */
    @Test (expected = UnsupportedOperationException.class)
    public void add() {
        es1.add("a");
    }


    /***
     * <b>Test : </b> the wrong functioning of HSet.adAll() method. <br>
     * <b>Description : </b> In any case this method must throw UnsupportedOperationException. <br>
     * <b>Pre-condition : </b> Two MapAdapter objects properly initialized, m1 is empty and m2 has 4 elements.<br>
     * EntrySet es2 object properly initialized on the MapAdapter m2 object. <br>
     * <b>Post-condition : </b> the exception to the calling method is passed, if this is not handled then the program ends. <br>
     * <b>Expected result : </b>  UnsupportedOperationException thrown <br>
     */
    @Test (expected = UnsupportedOperationException.class)
    public void addAll() {
        es1.add(new java.util.Vector());
    }

    /***
     * <b>Test : </b> This method tests the HSet.clear() method. <br>
     * <b>Description : </b> The size of EntrySet2 is checked and it is 4, then a clear() is made on it and finally it is checked that his size is 0. <br>
     * At the same time it is verified that the MapAdapter m1 size change as the size of EntrySet2 es1. <br>
     * <b>Pre-condition : </b> Two MapAdapter objects properly initialized, m1 is empty and m2 has 4 elements.<br>
     * EntrySet es2 object properly initialized on the MapAdapter m2 object.<br>
     *      es1 = m1 = {  } <br>
     *      es2 = m2 = { [0,a] , [1,b] , [2,c] , [3,d] } <br>
     *          Backing works. <br> <br>
     * <b>Post-condition : </b> The EntrySet is clear. <br>
     * <b>Expected result : </b> clear erase the elements of the EntrySet. <br>
     */
    @Test
    public void clear() {
        assertTrue(es2.size() == 4);
        assertTrue(m2.size() == 4);
        es2.clear();
        assertTrue(es2.size() == 0);
        assertTrue(m2.size() == 0);
    }

    /***
     * <b>Test : </b> This method tests the HSet.contains() method. <br>
     * <b>Description : </b> 3 Entry are created which through the contains() method are verified of their presence in EntrySet. <br>
     * 1 Entry is already present and is verified, while the other two are Entries that were not introduced initially and therefore were not found. <br>
     * <b>Pre-condition : </b> Two MapAdapter objects properly initialized, m1 is empty and m2 has 4 elements.<br>
     * EntrySet es2 object properly initialized on the MapAdapter m2 object.<br>
     *      es1 = m1 = {  } <br>
     *      es2 = m2 = { [0,a] , [1,b] , [2,c] , [3,d] } <br>
     *          Backing works. <br> <br>
     * <b>Post-condition : </b> the objects don't change their state after contains is called. <br>
     * <b>Expected result : </b> contains return true if an object is contained or false if not. <br>
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
     * <b>Test : </b> the wrong functioning of HSet.contains() method. <br>
     * <b>Description : </b> In this case is expected that the method throws a NullPointerException because in the method contains() was introduced a null parameter. <br>
     * <b>Pre-condition : </b> Two MapAdapter objects properly initialized, m1 is empty and m2 has 4 elements.<br>
     * EntrySet es2 object properly initialized on the MapAdapter m2 object. <br>
     * <b>Post-condition : </b>  the exception to the calling method is passed, if this is not handled then the program ends. <br>
     * <b>Expected result : </b> NullPointerException thrown. <br>
     */
    @Test (expected = NullPointerException.class)
    public void contains_Null() {
        es1.contains(null);
    }

    /***
     * <b>Test : </b> the wrong functioning of HSet.contains() method. <br>
     * <b>Description : </b> In this case is expected that the method throws a ClassCastException because in the method contains()
     * has been introduced a different class from Entry as a parameter. <br>
     * <b>Pre-condition : </b>  Two MapAdapter objects properly initialized, m1 is empty and m2 has 4 elements.<br>
     * EntrySet es2 object properly initialized on the MapAdapter m2 object. <br>
     * <b>Post-condition : </b> the exception to the calling method is passed, if this is not handled then the program ends. <br>
     * <b>Expected result : </b> ClassCastException thrown. <br>
     */
    @Test (expected = ClassCastException.class)
    public void contains_ADifferentObject() {
        es1.contains(new java.util.Vector());
    }


    /***
     * <b>Test : </b> this method tests the HSet.containsAll() method. <br>
     * <b>Description : </b> 3 pairs are added to MapAdapter1, EntrySet1 size is checked, and EntrySet2 is compared symmetrically with EntrySet1. <br>
     * Finally it was added a fourth pair in EntrySet2 from obtain 4 identical elements in both EntrySets,
     * it check the size of EntrySet2 and then the two EntrySets are symmetrically equal .<br>
     * It has not been possible to check if the containsAll() method launches ClassCastException,
     * because the code does not compile if a class different from that indicated by the interface is introduced.<br>
     * <b>Pre-condition : </b> Two MapAdapter objects properly initialized, m1 is empty and m2 has 4 elements.<br>
     * EntrySet es2 object properly initialized on the MapAdapter m2 object.<br>
     *      es1 = m1 = {  } <br>
     *      es2 = m2 = { [0,a] , [1,b] , [2,c] , [3,d] } <br>
     *          Backing works. <br>
     * <b>Post-condition : </b> the state of the Objects don't change. <br>
     * <b>Expected result : </b> the containsAll() find if a collection is contained or not. <br>
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
     * <b>Test : </b> This method tests the HSet.containsAll() method. <br>
     * <b>Description : </b> insert a null parameter on the remove method applied to an Entryset. <br>
     * <b>Pre-condition : </b> In this case is expected that the method throws a NullPointerException because in the method containsAll()
     * has been introduce a null parameter. <br>
     * <b>Post-condition : </b> the exception to the calling method is passed, if this is not handled then the program ends. <br>
     * <b>Expected result : </b> NullPointerException thrown.  <br>
     */
    @Test (expected = NullPointerException.class)
    public void containsAll_Null(){
        es1.containsAll(null);
    }

    /***
     * <b>Test : </b> This method tests the HSet.equals() method. <br>
     * <b>Description : </b> Entryset1 is initially compared to Entryset2 which is false because one is empty and the other has 4 elements,
     * then to Entryset1 adding to the Mapadapter1 the elements of Mapadapter2 are added the pairs present in Mapadapter2.
     * Finally, Entryset1 and Entryset2 are symmetrically compared.<br>
     * <b>Pre-condition : </b>  Two MapAdapter objects properly initialized, m1 is empty and m2 has 4 elements.<br>
     * EntrySet es2 object properly initialized on the MapAdapter m2 object.<br>
     *      es1 = m1 = {  } <br>
     *      es2 = m2 = { [0,a] , [1,b] , [2,c] , [3,d] } <br>
     *          Backing works. <br>
     * <b>Post-condition : </b> the objects don't change their status if equals() is called. <br>
     * <b>Expected result : </b> equals return true with two EntrySet that they are the same elements. <br>
     */
    @Test
    public void equals() {
        assertFalse(es1.equals(es2));
        m1.putAll(m2);
        assertTrue(es1.equals(es2));
        assertTrue(es2.equals(es1));
    }

    /***
     * <b>Test : </b> the wrong functioning of Hset.equals on a EntrySet. <br>
     * <b>Description : </b> The method returns false because a null parameter has been introduced. <br>
     * <b>Pre-condition : </b> Two MapAdapter objects properly initialized, m1 is empty and m2 has 4 elements.<br>
     * EntrySet es2 object properly initialized on the MapAdapter m2 object.<br>
     * <b>Post-condition : </b> the state of the EntrySet don't change if equals() is called. <br>
     * <b>Expected result : </b> equals return false <br>
     */
    @Test
    public void equalsToNull() {
        assertFalse(es1.equals(null));
    }


    /***
     * <b>Test : </b> This method tests the wrong functioning of HSet.equals on a EntrySet. <br>
     * <b>Description : </b> The method returns false because a different class from EntrySet has been introduced as a parameter.<br> <br>
     * <b>Pre-condition : </b> Two MapAdapter objects properly initialized, m1 is empty and m2 has 4 elements.<br>
     * EntrySet es2 object properly initialized on the MapAdapter m2 object.<br>
     * <b>Post-condition : </b> the state of the object don't change if equals() is called. <br>
     * <b>Expected result : </b> equals return false. <br>
     */
    @Test
    public void equalsToAnotheTypeOfObject() {
        assertFalse(es1.equals(new java.util.Vector()));
    }

    /***
     * <b>Test : </b> This method tests the HSet.hashCode() method. <br>
     * <b>Description : </b> Compare the hashCode of two EntrySet with different pairs,
     * then add the elements of the full map to the empty one and verify that the generated hashcodes are equal.<br>
     * At the end it was added an element to one of the two maps to verify that the hashCodes are different.<br><br>
     * <b>Pre-condition : </b> Two MapAdapter objects properly initialized, m1 is empty and m2 has 4 elements.<br>
     * EntrySet es2 object properly initialized on the MapAdapter m2 object.<br>
     *     es1 = m1 = {  } <br>
     *     es2 = m2 = { [0,a] , [1,b] , [2,c] , [3,d] } <br>
     *          Backing works. <br>
     * <b>Post-condition : </b> the hashcode remain the same if the EntrySets don't change. <br>
     * <b>Expected result : </b> Two hashcode match if two EntrySet have the same elements. <br>
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
     * <b>Test : </b> the proper functioning of HSet.isEmpty on a EntrySet. <br>
     * <b>Description : </b> It is verified that Entryset1 is empty and Entryset2 is not empty, Entryset2 is cleared and it is verified that it is empty. <br>
     * <b>Pre-condition : </b> Two MapAdapter objects properly initialized, m1 is empty and m2 has 4 elements.<br>
     * EntrySet es2 object properly initialized on the MapAdapter m2 object.<br>
     *      es1 = m1 = {  } <br>
     *      es2 = m2 = { [0,a] , [1,b] , [2,c] , [3,d] } <br>
     *          Backing works. <br>
     * <b>Post-condition : </b> The EntrySet1 and EntrySet 2 remain empty after this check. <br>
     * <b>Expected result : </b> the EntrySet1 and EntrySet are Empty. <br>
     */
    @Test
    public void isEmpty() {
        assertTrue(es1.isEmpty());
        assertFalse(es2.isEmpty());
        es2.clear();
        assertTrue(es2.isEmpty());
    }

    /**
     * <b>Tests</b> the proper functioning of iterator() method.<br>
     * <b>Description:</b> it calls the iterator() method on the 2 EntrySet objects and checks that they are not null.<br>
     * <b>Pre-condition : </b> Two MapAdapter objects properly initialized, m1 is empty and m2 has 4 elements.<br>
     * Two EntrySet objects (es1 and es2) properly initialized on the MapAdapter objects.<br>
     * Two HIterator objects (h1 and h2) properly initialized on the EntrySet objects.<br>
     * <b>Post-condition : </b> the iterator are not null objects.<br>
     * <b>Expected result : </b> h1 and h2 are not null.<br>
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
     * <b>Test</b> The proper functioning of HIterator.hasNext() on a EntrySet.  <br>
     * <b>Description : </b>This method tests if the iterator implemented on EntrySet has next elements to iterate.<br>
     * <b>Pre-condition : </b> Two MapAdapter objects properly initialized, m1 is empty and m2 has 4 elements.<br>
     * Two EntrySet objects (es1 and es2) properly initialized on the MapAdapter objects.<br>
     * Two HIterator objects (h1 and h2) properly initialized on the EntrySet objects.<br>
     * <b>Post-condition : </b> the iterator are not null objects. <br>
     * <b>Expected result : </b> h1 has not next elements and h2 has next elements. <br>
     */
    @Test
    public void iteratorHasNext(){
        HIterator h1 = es1.iterator();
        HIterator h2 = es2.iterator();
        assertFalse(h1.hasNext());
        assertTrue(h2.hasNext());
        m1.put(0,"a");
        assertTrue(h1.hasNext());
    }

    /***
     * <b>Test : </b> The proper functioning of HIterator.next() on a EntrySet. <br>
     * <b>Description : </b> This method tests if the iterator implemented on EntrySet give back a Entry type. <br>
     * An iterator is generated on Entryset2 that is not empty, then for each entry object returned by the iterator its presence in Mapadapter2 and EntrySet2 is verified. <br>
     * In this case we also checked the backing between Mapadapter and Entryset of the iterator.<br>
     * <b>Pre-condition : </b> Two MapAdapter objects properly initialized, m1 is empty and m2 has 4 elements.<br>
     * EntrySet es2 object properly initialized on the MapAdapter m2 object.<br>
     * HIterator objects and h2 properly initialized on the EntrySet es2 object.<br>
     *      es1 = m1 = {  } <br>
     *      es2 = m2 = { [0,a] , [1,b] , [2,c] , [3,d] } <br>
     *          Backing works. <br>
     * <b>Post-condition : </b> The iterator don't change the elements in the MapAdapter m2 and the EntrySet es2. <br>
     * <b>Expected result : </b> All the Entry elements that the iterator h2 give back are present in the the MapAdapter m2 and also into the EntrySet es2.  <br>
     */
    @Test
    public void iteratorNextElement(){
        HIterator h2 = es2.iterator();
        while(h2.hasNext()) {
            MapAdapter.Entry entry = (MapAdapter.Entry) h2.next();
            assertTrue(m2.containsKey(entry.getKey()) && m2.containsValue(m2.get(entry.getKey())));
            assertTrue(es2.contains(entry));
        }
        assertTrue(es2.size() == 4);
        assertTrue(m2.size() == 4);
    }

    /***
     * <b>Test : </b>The proper functioning of HIterator.remove() on a EntrySet. <br>
     * <b>Description : </b> This method tests if the iterator implemented on EntrySet remove the last element iterated. <br>
     * an iterator is created on Entryset es2, from which an Entry object is extracted, the key and value pair is verified if present in the map.<br>
     * For each remove() of the iterator the size of Mapadapter and Entryset is checked. Finally check that Entryset and Mapadapter are empty and have size 0.<br>
     * <b>Pre-condition : </b> Two MapAdapter objects properly initialized, m1 is empty and m2 has 4 elements.<br>
     * EntrySet es2 object properly initialized on the MapAdapter m2 object.<br>
     * HIterator objects and h2 properly initialized on the EntrySet es2 object.<br>
     * The HIterator must call next() before to remove the element that next() found.<br>
     *      es1 = m1 = {  } <br>
     *      es2 = m2 = { [0,a] , [1,b] , [2,c] , [3,d] } <br>
     *          Backing works. <br>
     * <b>Post-condition : </b> The EntrySet es2 and the MapAdapter m2 are empty and their size is 0. <br>
     * <b>Expected result : </b> All the elements from EntrySet es2 and MapAdapter m2 are removed by the HIterator. <br>
     */
    @Test
    public void iteratorRemoveElement() {
        HIterator h2 = es2.iterator();
        int i = 4;
        assertTrue(es2.size() == i);
        while(h2.hasNext()){
            MapAdapter.Entry entry =(MapAdapter.Entry) h2.next();
            assertTrue(m2.containsKey(entry.getKey()));
            Object val = m2.get(entry.getKey());
            assertEquals(val,entry.getValue());
            h2.remove();
            assertTrue(es2.size() == --i );
            assertTrue(m2.size() == i);
        }
        assertTrue(es2.size() == 0);
        assertTrue(m2.size() == 0);
        assertTrue(es2.isEmpty());
        assertTrue(m2.isEmpty());
    }

    /***
     * <b>Test : </b> The proper functioning of HSet.remove() method on a EntrySet.<br>
     * <b>Description : </b>
     * Initially the dimensions of Mapadapter m2 and Entryset es2 are checked. after that it is checked that every time it is
     * deleted an item from es2 the size of es2 and m1 decreases until it becomes zero, so it is checked that the backing also works.<br>
     * Finally an element is removed that is not present in the Entryset, therefore this removals is not true. <br>
     * <b>Pre-condition : </b>  It was instantiated correctly a Mapadapter m2 with 4 elements and from this an Entryset es2
     * was initialized correctly with the same 4 elements. <br>
     *      es1 = m1 = {  } <br>
     *      es2 = m2 = { [0,a] , [1,b] , [2,c] , [3,d] } <br>
     *          Backing works.
     * <b>Post-condition :</b> the EntrySet size is 0 and it's empty. <br>
     * <b>Expected result : </b> after every remove the size of the EntrySet decrease by one.
     */
    @Test
    public void remove(){
        assertTrue(es2.size() == 4);
        assertTrue(m2.size() == 4);
        assertTrue(es2.remove(new MapAdapter.Entry(0,"a")));
        assertTrue(es2.size() == 3);
        assertTrue(m2.size() == 3);
        assertTrue(es2.remove(new MapAdapter.Entry(1,"b")));
        assertTrue(es2.size() == 2);
        assertTrue(m2.size() == 2);
        assertTrue(es2.remove(new MapAdapter.Entry(2,"c")));
        assertTrue(es2.size() == 1);
        assertTrue(m2.size() == 1);
        assertTrue(es2.remove(new MapAdapter.Entry(3,"d")));
        assertTrue(es2.size() == 0);
        assertTrue(m2.size() == 0);
        assertTrue(es2.isEmpty());
        assertTrue(m2.isEmpty());
        assertFalse(es2.remove(new MapAdapter.Entry(4,"e")));
    }

    /***
     * <b>Test : </b> The wrong functioning of HSet.remove() method on a EntrySet.<br>
     * <b>Description : </b>  insert a null parameter on the remove method applied to an Entryset. <br>
     * <b>Pre-condition : </b> It was instantiated correctly a Mapadapter m2 with 4 elements and from this an Entryset es2
     * was initialized correctly with the same 4 elements. <br>
     * <b>Post-condition : </b> the exception is passed to the calling method , if this is not handled then the program ends. <br>
     * <b>Expected result : </b> NullPointerException thrown <br>
     */
    @Test (expected = NullPointerException.class)
    public void removeANullObject() {
        es2.remove(null);
    }

    /***
     * <b>Test : </b> The wrong functioning of HSet.remove() method on a EntrySet.<br>
     * <b>Description : </b> insert a java.util.Vector class as parameter on the remove method applied to an Entryset <br>
     * <b>Pre-condition : </b> It was instantiated correctly a Mapadapter m2 with 4 elements and from this an Entryset es2
     * was initialized correctly with the same 4 elements.<br>
     * <b>Post-condition : </b> the exception is passed to the calling method , if this is not handled then the program ends. <br>
     * <b>Expected result : </b> ClassCastException thrown <br>
     */
    @Test (expected = ClassCastException.class)
    public void removeADifferentTypeOfObject(){
        es2.remove(new java.util.Vector());
    }

    /***
     * <b>Test : </b> The proper functioning of HSet.remove() method on a EntrySet. <br>
     * <b>Description : </b> Initially try to remove the empty es1 from es2 with 4 items with negative result, then vice versa with negative result.<br>
     * The two initial elements of es2 to es1 are added through MapAdapter m1. finally it is removed es1 with two elements from es2 with positive result. <br>
     * Finally it is checked the presence of the elements in es2 and its final dimension that is 2. <br>
     * <b>Pre-condition : </b> Two MapAdapter objects properly initialized, m1 is empty and m2 has 4 elements.<br>
     * EntrySet es1 and es2 object are properly initialized on the MapAdapter m1 and m2 object. <br>
     *     es1 = m1 = {  } <br>
     *      es2 = m2 = { [0,a] , [1,b] , [2,c] , [3,d] } <br>
     *         Backing works. <br>
     * <b>Post-condition : </b> The MapAdapter m2 and EntrySet es2 have the same two final object inside <br>
     * <b>Expected result : </b> The method removeAll() removes the collection not empty, and also don't remove nothing when the collection introduced is empty. <br>
     */
    @Test
    public void removeAll(){
        assertFalse(es2.removeAll(es1));
        assertFalse(es1.removeAll(es2));
        m1.put(0,"a");
        m1.put(1,"b");
        assertTrue(es2.removeAll(es1));
        assertFalse(es2.contains(new MapAdapter.Entry(0,"a")));
        assertFalse(es2.contains(new MapAdapter.Entry(1,"b")));
        assertTrue(es2.contains(new MapAdapter.Entry(2,"c")));
        assertTrue(es2.contains(new MapAdapter.Entry(3,"d")));
        assertTrue(es2.size() == 2);
        assertTrue(m2.size() == 2);
    }

    /***
     * <b>Test : </b> The wrong functioning of HSet.removeAll() method on a EntrySet. <br>
     * <b>Description : </b> Insert a null parameter on the remove method applied to an Entryset. <br>
     * <b>Pre-condition : </b> Two MapAdapter objects properly initialized, m1 is empty and m2 has 4 elements.<br>
     * EntrySet es1 and es2 object are properly initialized on the MapAdapter m1 and m2 object. <br>
     * <b>Post-condition : </b> the exception is passed to the calling method, if this is not handled then the program ends. <br>
     * <b>Expected result : </b> NullPointerException thrown <br>
     */
    @Test (expected = NullPointerException.class)
    public void removeALLNull(){
        es2.removeAll(null);
    }

    /***
     * <b>Test : </b> The wrong functioning of HSet.removeAll() method on a EntrySet.  <br>
     * <b>Description : </b> Insert a HCollection as a parameter that is not compatible with Entryset. <br>
     * <b>Pre-condition : </b> Two MapAdapter objects properly initialized, m1 is empty and m2 has 4 elements.<br>
     * EntrySet es1 and es2 object are properly initialized on the MapAdapter m1 and m2 object. <br>
     * <b>Post-condition : </b> the exception is passed to the calling method, if this is not handled then the program ends. <br>
     * <b>Expected result : </b> ClassCastException thrown. <br>
     */
    @Test (expected = ClassCastException.class)
    public void removeAllClassCastException() {
        es2.removeAll(new ListAdapter());
    }

    /***
     * <b>Test : </b> he proper functioning of HSet.retainAll() method on a EntrySet.<br>
     * <b>Description : </b> the size of entryset1 and entryset2 is checked, entryset2.ratainall(entryset1) is done, which returns false as entryset1 is empty.<br>
     * Add two elements to entryset1 and check that entryset2.retainall(entryset1) returns true and that now entryset2 has only two elements. <br>
     * <b>Pre-condition : </b> wo MapAdapter objects properly initialized, m1 is empty and m2 has 4 elements.<br>
     * EntrySet es1 and es2 object are properly initialized on the MapAdapter m1 and m2 object. <br>
     *     es1 = m1 = {  } <br>
     *      es2 = m2 = { [0,a] , [1,b] , [2,c] , [3,d] } <br>
     *         Backing works. <br>
     * <b>Post-condition : </b> maps and entrysets maintain new status. <br>
     * <b>Expected result : </b> Entryset2 must keep the common items that have been added to Entryset1 by Mapadapter1. <br>
     */
    @Test
    public void retainAll() {
        assertTrue(es1.size() == 0);
        assertTrue(es2.size() == 4);
        assertFalse(es2.retainAll(es1));
        m1.put(0,"a");
        m1.put(1,"b");
        assertTrue(es1.size() == 2);
        assertTrue(es2.retainAll(es1));
        assertTrue(es2.size() == 2);
        assertTrue(es2.contains(new MapAdapter.Entry(0,"a")));
        assertTrue(es2.contains(new MapAdapter.Entry(1,"b")));
        assertFalse(es2.contains(new MapAdapter.Entry(2,"c")));
        assertFalse(es2.contains(new MapAdapter.Entry(3,"d")));
        assertTrue(es1.size() == 2);
        assertTrue(es2.size() == 2);
        assertTrue(m1.size() == 2);
        assertTrue(m2.size() == 2);
    }

    /***
     * <b>Test : </b>The wrong functioning of HSet.retainAll() method on a EntrySet. <br>
     * <b>Description : </b> insert a null parameter on the retainAll() method applied to an Entryset. <br>
     * <b>Pre-condition : </b> Two MapAdapter objects properly initialized, m1 is empty and m2 has 4 elements.<br>
     * EntrySet es1 and es2 object are properly initialized on the MapAdapter m1 and m2 object. <br>
     * <b>Post-condition : </b> the exception is passed to the calling method, if this is not handled then the program ends. <br>
     * <b>Expected result : </b> NullPointerException thrown <br>
     */
    @Test (expected = NullPointerException.class)
    public void retainAllNull(){
        es1.retainAll(null);
    }

    /***
     * <b>Test : </b> The wrong functioning of HSet.retainAll() method on a EntrySet. <br>
     * <b>Description : </b> insert a ListAdapter class as parameter on the retainAll() method applied to an Entryset. <br>
     * <b>Pre-condition : </b> Two MapAdapter objects properly initialized, m1 is empty and m2 has 4 elements.<br>
     * EntrySet es1 and es2 object are properly initialized on the MapAdapter m1 and m2 object. <br>
     * <b>Post-condition : </b> the exception is passed to the calling method , if this is not handled then the program ends.<br>
     * <b>Expected result : </b> ClassCastException thrown. <br>
     */
    @Test (expected = ClassCastException.class)
    public void retainAllClassCastException(){
        es1.retainAll(new ListAdapter());
    }

    /***
     * <b>Test : </b> The proper functioning of HSet.size() method on a EntrySet. <br>
     * <b>Description : </b> it is checked that the number of elements that were inserted at the beginning in the Entryset match. <br>
     * <b>Pre-condition : </b> Two MapAdapter objects properly initialized, m1 is empty and m2 has 4 elements.<br>
     * EntrySet es1 and es2 object are properly initialized on the MapAdapter m1 and m2 object. <br>
     * <b>Post-condition : </b> The size don't change <br>
     * <b>Expected result : </b> the size expected is the number of object that was introduced at the beginning into EntrySet1 and EntrySet2 through MapAdapter1 and MapAdapter2. <br>
     */
    @Test
    public void size() {
        assertTrue(es1.size() == 0);
        assertTrue(es2.size() == 4);
    }

    /***
     * <b>Test : </b> The proper functioning of HSet.toArray() method on a EntrySet. <br>
     * <b>Description : </b> an array of Entry is generated by Entryset2 and it is verified that the elements of the array are contained in Entryset2 and Mapadapter2. <br>
     * <b>Pre-condition : </b> wo MapAdapter objects properly initialized, m1 is empty and m2 has 4 elements.<br>
     * EntrySet es1 and es2 object are properly initialized on the MapAdapter m1 and m2 object. <br>
     *     es1 = m1 = {  } <br>
     *      es2 = m2 = { [0,a] , [1,b] , [2,c] , [3,d] } <br>
     *         Backing works. <br>
     * <b>Post-condition : </b> The EntrySet don't change its status <br>
     * <b>Expected result : </b> the array contains the elements of Entryset2. <br>
     */
    @Test
    public void toArray() {
        MapAdapter.Entry[] entry = (MapAdapter.Entry[]) es2.toArray();
        assertEquals(es2.size(),entry.length);
        for(int i = 0; i < es2.size(); i++) {
            assertTrue(es2.contains(entry[i]));
            Object val = m2.get(entry[i].getKey());
            assertTrue( val.equals(entry[i].getValue()));
        }
    }

    /***
     * <b>Test : </b> The proper functioning of HSet.toArray(Object[] o) method on a EntrySet. <br>
     * <b>Description : </b> two pairs are introduced into Mapadapter1 then an array is generated from it with the methodo toArray().
     * It is checked that the pairs are present in the entryset1.
     * then this smaller array is passed to generate the Entryset2 entry array.
     * Finally, check that the returned array is larger as the size of EntrySEt2 and contains all Entryset2 elements.<br>
     * <b>Pre-condition : </b>  Two MapAdapter objects properly initialized, m1 is empty and m2 has 4 elements.<br>
     * EntrySet es1 and es2 object are properly initialized on the MapAdapter m1 and m2 object. <br>
     *     es1 = m1 = {  } <br>
     *      es2 = m2 = { [0,a] , [1,b] , [2,c] , [3,d] } <br>
     *         Backing works. <br>
     * <b>Post-condition : </b> The EntrySet don't change its status <br>
     * <b>Expected result : </b> The array generated is an MapAdapter.Entry type and it contains the elements of the EntrySet. <br>
     */
    @Test
    public void toArray2(){
        m1.put(2,"bratan");
        m1.put(12,"patzan");
        MapAdapter.Entry[] entry1 = (MapAdapter.Entry[]) es1.toArray();
        assertEquals(es1.size(),entry1.length);
        for(int i = 0 ; i < es1.size(); i++)
            assertTrue(es1.contains(entry1[i]));

        MapAdapter.Entry[] entry2 = (MapAdapter.Entry[]) es2.toArray(entry1);
        assertEquals(es2.size(),entry2.length);
        for(int i = 0; i < es2.size(); i++)
            assertTrue(es2.contains(entry2[i]));
    }

    /***
     * <b>Test : </b> The wrong functioning of HSet.toArray() method on a EntrySet. <br>
     * <b>Description : </b> insert a null parameter on the toArray() method applied to an Entryset <br>
     * <b>Pre-condition : </b> Two MapAdapter objects properly initialized, m1 is empty and m2 has 4 elements.<br>
     * EntrySet es1 and es2 object are properly initialized on the MapAdapter m1 and m2 object. <br>
     * <b>Post-condition : </b> the exception is passed to the calling method , if this is not handled then the program ends. <br>
     * <b>Expected result : </b> NullPointerException thrown <br>
     */
    @Test (expected = NullPointerException.class)
    public void toArrayNull() {
        es2.toArray(null);
    }

    /***
     * <b>Test : </b> The wrong functioning of HSet.toArray() method on a EntrySet. <br>
     * <b>Description : </b> insert an array java.lang.String[10] as parameter into the toArray() method applied to an Entryset <br>
     * <b>Pre-condition : </b> Two MapAdapter objects properly initialized, m1 is empty and m2 has 4 elements.<br>
     * EntrySet es1 and es2 object are properly initialized on the MapAdapter m1 and m2 object. <br>
     * <b>Post-condition : </b> the exception is passed to the calling method , if this is not handled then the program ends. <br>
     * <b>Expected result : </b> ArrayStoreException thrown. <br>
     */
    @Test (expected = ArrayStoreException.class)
    public void toArrayClassCastException() {
        es2.toArray(new java.lang.String[10]);
    }


    /***
     * <b>Test : </b> <br>
     * <b>Description : </b> <br>
     * <b>Pre-condition : </b> <br>
     * <b>Post-condition : </b> <br>
     * <b>Expected result : </b> <br>
     */



    /***
     * <b>Test</b> The wrong functioning of HSet.removeAll() method on a EntrySet. <br>
     * <b>Description : </b> insert a java.util.Vector class as parameter on the remove method applied to an Entryset <br>
     * <b>Pre-condition : </b> Two MapAdapter objects properly initialized, m1 is empty and m2 has 4 elements.<br>
     * EntrySet es1 and es2 object are properly initialized on the MapAdapter m1 and m2 object. <br>
     * <b>Post-condition : </b> the exception is passed to the calling method , if this is not handled then the program ends. <br>
     * <b>Expected result : </b> NullPointerException thrown <br>
     */
}
