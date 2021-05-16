package myAdapter.Test;
import myAdapter.*;
import org.junit.Test;
import org.junit.Before;
import static org.junit.Assert.*;

/***
 * Testing ListAdapter and ListIterator and Iterator.<br>
 * Some methods of ListAdapter use ListIterator and Iterator.<br>
 * The iterators were tested at the end of the class.<br>
 * This class tries to demonstrate the correct behavior of the methods used on ListAdapter. <br>
 * Tests of this class are performed by the LATestRunner class.<br>
 * @see
 * @see ListAdapterTestRunner ListAdapterTestRunner. <br>
 */
public class ListAdapterTest {

    /***
     * instance variable of ListAdapter - list1
     */
    private ListAdapter list1;
    /***
     * instance variable of ListAdapter - list2
     */
    private ListAdapter list2;
    /***
     * instance variable of a iterator of ListAdapter ls1. <br>
     * It will be generated with the method : HMap.iterator();
     */
    private HIterator h1;
    /***
     * instance variable of a HListIterator of ListAdapter list1. <br>#
     * It will be generated with the method : HMap.listIterator().
     */
    private HListIterator hl1;
    /***
     * instance variable of a HListIterator of HListAdapter list2. <br>#
     * It will be generate with the method : HMap.listIterator().
     */
    private HListIterator hl2;


    /***
     * <b>-Before : </b> Setup test, this is done before every test. <br>
     * <b>-Description:</b> This method create an instance of ListAdapter and ListAdapter with 15 rows.<br>
     * Two HListIterator hl1 and hl2 object, listIter1 initialized on list1, and listIter2 initialized on list2.<br>
     * <b>-Pre-condition:</b> the instance variable have been created without being instantiated. <br>
     * <b>-Post-condition:</b> the instance variable have been instantiated .<br>
     * <b>-Expected result:</b> the instance variable have been instantiated.<br>
     */
    @Before
    public void setup(){
        list1 = new ListAdapter();
        list2 = new ListAdapter(15);
        h1 = list1.iterator();
        hl1 = list1.listIterator();
        hl2 = list2.listIterator();
        assertTrue(list1 != null);
        assertTrue(list2 != null);
        assertTrue(h1 != null);
        assertTrue(hl1 != null);
        assertTrue(hl2 != null);
    }

    /***
     * <b>-Tests</b> the proper instantiation of ListAdapter1 and ListAdapter2.<br>
     * <b>-Description:</b> This method tests the right initialization of ListAdapter.<br>
     * <b>-Pre-condition:</b> Two ListAdapter properly initialized, list1 and list2.<br>
     * <b>-Post-condition:</b> the instance variable have been correctly instantiated.<br>
     * <b>-Expected result:</b> the instance variable have not a reference to null.<br>
     */
    @Test
    public void testListAdapterInit() {
        assertTrue(list1.isEmpty());
        assertTrue(list1.size() == 0);

        assertTrue(list2.isEmpty());
        assertTrue(list2.size() == 0);

        assertTrue(list1 != null);
        assertTrue(list2 != null);
    }

    /***
     * <b>-Tests</b> the wrong initialization of ListAdapter.<br>
     * <b>-Description:</b> insert a null parameter as a parameter of ListAdapter constructor.<br>
     * <b>-Pre-condition:</b> Two ListAdapter properly initialized, list1 and list2.<br>
     * <b>-Post-condition:</b> the exception is passed to the calling method , if this is not handled then the program ends.<br>
     * <b>-Expected result:</b> IllegalArgumentException thrown.<br>
     */
    @Test (expected = IllegalArgumentException.class)
    public void testInvalidCapacity() {
        list1 = new ListAdapter(-1);
        list2 = new ListAdapter(-2);
    }

    /***
     * <b>-Tests</b> the proper functioning of add() method.<br>
     * <b>-Description:</b> an element has been added to ls1 and an element to ls2 and it is verified that the dimension is increased of both the Listadapter.<br>
     * <b>-Pre-condition:</b> Two ListAdapter properly initialized, list1 and list2, they are empty.<br>
     * <b>-Post-condition:</b> list1 and list2 have each one the new object.<br>
     * <b>-Expected result:</b> list1 and list2 have each one the new object.<br>
     */
    @Test
    public void add() {
        assertTrue(list1.add("one"));
        assertTrue(list2.add("two"));
        assertTrue(list1.size() == 1);
        assertTrue(list2.size() == 1);
    }

    /***
     * <b>-Tests</b> the proper functioning of add() method.<br>
     * <b>-Description:</b> This method tests the add method of ListAdapter, using the index,
     * and also add an object where is already present an object, to see
     * if the object in the ListAdapter shifts on the right of their index..<br>
     * <b>-Pre-condition:</b> Two ListAdapter properly initialized, list1 and list2. they are empty. <br>
     * <b>-Post-condition:</b> list1 and list2 have each one the objects inserted at the valid index.<br>
     * <b>-Expected result:</b> list1 and list2 have each one the objects inserted at the valid index.<br>
     */
    @Test
    public void addWithIndex() {
        list1.add(0,"one");
        list1.add(1,"two");
        list1.add(2,"three");

        assertEquals("one",list1.get(0));
        assertEquals("two",list1.get(1));
        assertEquals("three",list1.get(2));

        list1.add(1,"seven");

        assertEquals("one",list1.get(0));
        assertEquals("seven",list1.get(1));
        assertEquals("two",list1.get(2));
        assertEquals("three",list1.get(3));
    }

    /***

     */
    /***
     * <b>-Tests</b> the proper functioning of addAll() method.<br>
     * <b>-Description:</b> This method inserts a HCollection in the ListAdapter, and check
     * the boolean condition that says if the ListAdapter changes its content.<br>
     * <b>-Pre-condition:</b> Two ListAdapter properly initialized, list1 and list2.<br>
     * <b>-Post-condition:</b> list1 and list2 have each of the elements of the HCollection inserted.<br>
     * <b>-Expected result:</b> list1 and list2 have each of the elements of the HCollection inserted.<br>
     */
    @Test
    public void addAll() {
        assertTrue(!(list1.addAll(list2)));

        list1.add("a");
        list1.add("b");
        list1.add("c");
        list1.add("d");

        assertTrue(!(list1.addAll(list2)));
        assertTrue(list1.size() == 4);
        assertTrue(list2.addAll(list1));
        assertTrue(list2.size() == 4);

        assertEquals("a",list2.get(0));
        assertEquals("b",list2.get(1));
        assertEquals("c",list2.get(2));
        assertEquals("d",list2.get(3));
    }

    /***
     * <b>-Tests</b> the proper functioning of addAll() method.<br>
     * <b>-Description:</b> This method insert a HCollection in the ListAdapter with an index, and check
     * the boolean condition that says if the ListAdapter changes its content.<br>
     * <b>-Pre-condition:</b> Two ListAdapter properly initialized, list1 and list2.<br>
     * <b>-Post-condition:</b> list1 and list2 have each of the elements of the HCollection inserted at the valid index.<br>
     * <b>-Expected result:</b> list1 and list2 have each of the elements of the HCollection inserted at the valid index.<br>
     */
    @Test
    public void AddAllWithIndex() {
        assertFalse(list1.addAll(0,list2));

        list1.add("a");
        list1.add("b");
        list1.add("c");
        list1.add("d");

        assertFalse(list1.addAll(0,list2));
        assertTrue(list1.size() == 4);

        list2.add("x");
        list2.add("y");
        list2.add("z");

        assertTrue(list1.addAll(2,list2));
        assertTrue(list1.size() == 7);
        assertEquals("a",list1.get(0));
        assertEquals("b",list1.get(1));
        assertEquals("x",list1.get(2));
        assertEquals("y",list1.get(3));
        assertEquals("z",list1.get(4));
        assertEquals("c",list1.get(5));
        assertEquals("d",list1.get(6));
    }


    /***
     * <b>-Tests</b> the wrong functioning of addAll() method.<br>
     * <b>-Description:</b> This method tests the expected NullPointerException if someone inserts
     * a null HCollection in ListAdapter.
     * Null elements in the HCollection can't be tested, because ListAdapter
     * do not allow to insert null elements.
     * Otherwise, both addAll methods are implemented to throw a NullPointerException,
     * in case will be introduced a different HCollection that accept null elements.<br>
     * <b>-Pre-condition:</b> Two ListAdapter properly initialized, list1 and list2.<br>
     * <b>-Post-condition:</b> the exception is passed to the calling method , if this is not handled then the program ends.<br>
     * <b>-Expected result:</b> NullPointerException thrown.<br>
     */
    @Test (expected = NullPointerException.class)
    public void addAllNull() {
        list1.addAll(null);
    }

    /***
     * <b>-Tests</b> the wrong functioning of addAll() method.<br>
     * <b>-Description:</b> This method excepts to introduce a null HCollection in the ListAdapter with an index.
     * At last NullPointerException must be throw.<br>
     * <b>-Pre-condition:</b> Two ListAdapter properly initialized, list1 and list2.<br>
     * <b>-Post-condition:</b> the exception is passed to the calling method , if this is not handled then the program ends.<br>
     * <b>-Expected result:</b> NullPointerException thrown.<br>
     */
    @Test (expected = NullPointerException.class)
    public void AddNullElementWithIndex() {
        list1.add(1,null);
        list1.add(null);
        list2.add(3,null);
        list2.add(null);
    }

    /***
     * <b>-Tests</b> the wrong functioning of addAll() method.<br>
     * <b>-Description:</b> a HCollection has been inserted with an implementation different from Listadapter.<br>
     * <b>-Pre-condition:</b> Two ListAdapter properly initialized, list1 and list2.<br>
     * An HIterator object h1 properly initialized on list1.<br> and two
     * Two HListIterator hl1 and hl2 object, listIter1 initialized on list1, and listIter2 initialized on list2.<br>
     * <b>-Post-condition:</b> the exception is passed to the calling method , if this is not handled then the program ends.<br>
     * <b>-Expected result:</b> ClassCastException thrown.<br>
     */
    @Test (expected = ClassCastException.class)
    public void addAllClassCastException(){
        list1.addAll(new MapAdapter().values());
    }

    /***
     * <b>-Tests</b> the wrong functioning of addAll() method.<br>
     * <b>-Description:</b> a HCollection has been inserted with an implementation different from Listadapter.<br>
     * <b>-Pre-condition:</b> Two ListAdapter properly initialized, list1 and list2.<br>
     * <b>-Post-condition:</b> the exception is passed to the calling method , if this is not handled then the program ends.<br>
     * <b>-Expected result:</b> ClassCastException thrown.<br>
     */
    @Test (expected = ClassCastException.class)
    public void addAllWithIndexClassCastException(){
        list1.addAll(0, new MapAdapter().values());
    }

    /***
     * <b>-Tests</b> the wrong functioning of add() method.<br>
     * <b>-Description:</b> This method excepts to introduce a negative index when it is added an HCollection.
     * At last IndexOutOfBoundsException must be throw..<br>
     * <b>-Pre-condition:</b> Two ListAdapter properly initialized, list1 and list2.<br>
     * <b>-Post-condition:</b> the exception is passed to the calling method , if this is not handled then the program ends.<br>
     * <b>-Expected result:</b> IndexOutOfBoundException thrown.<br>
     */
    @Test (expected = IndexOutOfBoundsException.class)
    public void AddNegativeIndex() {
        list1.add(-1,"one");
        list2.add(-2,"two");
    }


    /***
     * <b>-Tests</b> the proper functioning of clear() method.<br>
     * <b>-Description:</b> This method add three elements lo list1 and checks if the List is Empty after the clear() method.<br>
     * <b>-Pre-condition:</b> Two ListAdapter properly initialized, list1 and list2.<br>
     * An HIterator object h1 properly initialized on list1.<br> and two
     * Two HListIterator hl1 and hl2 object, listIter1 initialized on list1, and listIter2 initialized on list2.<br>
     * <b>-Post-condition:</b> the list1 is empty.<br>
     * <b>-Expected result:</b> the list1 don't have any element.<br>
     */
    @Test
    public void clear() {
        assertTrue(list1.size() == 0);

        list1.add("a");
        list1.add("b");
        list1.add("c");

        assertTrue(list1.size() == 3);

        list1.clear();
        assertTrue(list1.size() == 0);
        assertTrue(list1.isEmpty());
    }

    /***
     * <b>-Tests</b> the proper functioning of contains() method.<br>
     * <b>-Description:</b> This method checks if the ListAdapter recognize an object present after the add method.<br>
     * <b>-Pre-condition:</b> Two ListAdapter properly initialized, list1 and list2.<br>
     * <b>-Post-condition:</b> the list don't change its status.<br>
     * <b>-Expected result:</b> the list recognize the elements added.<br>
     */
    @Test
    public void contains() {
        list1.add(1);
        list1.add(2);
        list1.add(3);
        list1.add(4);
        list1.add(5);

        assertTrue(list1.contains(3));
        assertTrue(!list1.contains(6));
    }

    /***
     * <b>-Tests</b> the proper functioning of containsAll() method.<br>
     * <b>-Description:</b> this method checks if the ListAdapter contains all the elements of the HCollection introduced.<br>
     * <b>-Pre-condition:</b> Two ListAdapter properly initialized, list1 and list2.<br>
     * An HIterator object h1 properly initialized on list1.<br> and two
     * Two HListIterator hl1 and hl2 object, listIter1 initialized on list1, and listIter2 initialized on list2.<br>
     * <b>-Post-condition:</b> the list don't change its status.<br>
     * <b>-Expected result:</b> the list recognize the elements of the HCollection passed by argument.<br>
     */
    @Test
    public void containsAll() {
        list1.add("a");
        list1.add("b");
        list1.add("c");
        list1.add("d");

        list2.add(0,"c");
        list2.add(1,"d");
        list2.add(2,"a");

        assertTrue(list1.size() == 4);
        assertTrue(list2.size() == 3);

        assertTrue(list1.containsAll(list2));
        assertTrue(!list2.containsAll(list1));
    }

    /***
     * <b>-Tests</b> the wrong functioning of addAll() method.<br>
     * <b>-Description:</b> it was passed a null parameter to the method addAll().<br>
     * <b>-Pre-condition:</b> Two ListAdapter properly initialized, list1 and list2.<br>
     * <b>-Post-condition:</b> the exception is passed to the calling method , if this is not handled then the program ends.<br>
     * <b>-Expected result:</b> NullPointerException thrown.<br>
     */
    @Test (expected = NullPointerException.class)
    public void containsAllNullElement() {
        list1.contains(null);
    }

    /***
     * <b>-Tests</b> the proper functioning of equals() method.<br>
     * <b>-Description:</b> elements were added in the same order in list1 and list2 and verified that equals() checked that the two were equal or not.<br>
     *     equals is verified symmetrically.
     * <b>-Pre-condition:</b> Two ListAdapter properly initialized, list1 and list2.<br>
     * <b>-Post-condition:</b> the status of the object don't change after equals is called.<br>
     * <b>-Expected result:</b> equals recognize two object when they are equals or not.<br>
     */
    @Test
    public void equals() {
        list1.add(1);
        list1.add(2);
        list1.add(3);
        list1.add(4);

        list2.add(2);
        list2.add(4);
        list2.add(1);
        list2.add(3);
        String s = "";

        assertFalse(list1.equals(list2));
        assertFalse(list2.equals(list1));
        assertFalse(list1.equals(s));

        list2.clear();
        list2.add(1);
        list2.add(2);
        list2.add(3);
        list2.add(4);

        assertTrue(list1.equals(list2));
        assertTrue(list2.equals(list1));
    }

    /***
     * <b>-Tests</b> the proper functioning of get() method.<br>
     * <b>-Description:</b> 4 elements have been added to list1 and it occurs through get that these are present in the list.<br>
     * <b>-Pre-condition:</b> Two ListAdapter properly initialized, list1 and list2.<br>
     * <b>-Post-condition:</b> the elements of the list are still in the list.<br>
     * <b>-Expected result:</b> get method find the object inside the list.<br>
     */
    @Test
    public void get() {
        list1.add("a");
        list1.add("b");
        list1.add("c");
        list1.add("d");

        assertEquals("a",list1.get(0));
        assertEquals("b",list1.get(1));
        assertEquals("c",list1.get(2));
        assertEquals("d",list1.get(3));
    }

    /***
     * <b>-Tests</b> the wrong functioning of get() method.<br>
     * <b>-Description:</b> a null parameter is passed to the get() method.<br>
     * <b>-Pre-condition:</b> Two ListAdapter properly initialized, list1 and list2.<br>
     * <b>-Post-condition:</b> the exception is passed to the calling method , if this is not handled then the program ends.<br>
     * <b>-Expected result:</b> IndexOutOfBoundException thrown.<br>
     */
    @Test (expected = IndexOutOfBoundsException.class)
    public void getFromWrongIndex() {
        list1.get(0);
    }

    /***
     * This method tests the fact that two ListAdapter must have the same hashcode
     * if they are equals.
     */
    /***
     * <b>-Tests</b> the proper functioning of hashCode() method.<br>
     * <b>-Description:</b> This method tests the fact that two ListAdapter must have the same hashcode
     * if they are equals..<br>
     * <b>-Pre-condition:</b> Two ListAdapter properly initialized, list1 and list2.<br>
     * <b>-Post-condition:</b> the hashcode don't change if the list don't change.<br>
     * <b>-Expected result:</b> two list that they are equals, they also have the same hashcode.<br>
     */
    @Test
    public void hashcode() {
        list1.add("a");
        list1.add("b");
        list1.add("c");

        list2.add("a");
        list2.add("b");
        list2.add("c");

        int h1 = list1.hashCode();
        int h2 = list2.hashCode();

        assertTrue(h1 == h2);
        assertTrue(list1.equals(list2));
        assertTrue(list1.equals(list1));

        list2.add("e");
        list2.add("f");
        h2 = list2.hashCode();

        assertFalse( h1 == h2);
        assertFalse(list1.equals(list2));
        assertFalse(list1.equals(list2));
    }

    /***
     * <b>-Tests</b> the proper functioning of indexOf() method.<br>
     * <b>-Description:</b> This method checks if the ListAdapter return the right index of the elements
     * introduced.<br>
     * <b>-Pre-condition:</b> Two ListAdapter properly initialized, list1 and list2.<br>
     * <b>-Post-condition:</b> the index represents the position of that object at that time, if the list changes the index will be another.<br>
     * <b>-Expected result:</b> the method recognize the object inside the list and give back the right index.<br>
     */
    @Test
    public void indexOf() {
        list1.add("a");
        list1.add("b");
        list1.add("c");
        list1.add("d");

        assertEquals(0,list1.indexOf("a"));
        assertEquals(1,list1.indexOf("b"));
        assertEquals(2,list1.indexOf("c"));
        assertEquals(3,list1.indexOf("d"));
    }

    /***
     * <b>-Tests</b> the wrong functioning of indexOf() method.<br>
     * <b>-Description:</b> a null parameter was passed to indexOf() method.<br>
     * <b>-Pre-condition:</b> Two ListAdapter properly initialized, list1 and list2.<br>
     * <b>-Post-condition:</b> the exception is passed to the calling method , if this is not handled then the program ends.<br>
     * <b>-Expected result:</b> NullPointerException thrown.<br>
     */
    @Test (expected = NullPointerException.class)
    public void indexOfNull(){
        list1.indexOf(null);
    }

    /***
     * <b>-Tests</b> the proper functioning of isEmpty() method.<br>
     * <b>-Description:</b> first of all isEmpty() is tested on a object with no elements.<br>#
     * Before it is add an element an it is verified that the list is not empty. <br>
     * <b>-Pre-condition:</b> Two ListAdapter properly initialized, list1 and list2.<br>
     * <b>-Post-condition:</b> calling isEmpty() don't change the size of the list.<br>
     * <b>-Expected result:</b> isEmpty() recognize is the list is empty or not.<br>
     */
    @Test
    public void isEmpty() {
        assertTrue(list1.isEmpty());
        list1.add("a");
        assertFalse(list1.isEmpty());
    }

    /***
     * <b>-Tests</b> the proper functioning of lastIndexOf() method.<br>
     * <b>-Description:</b> 3 elements have been inserted in the list, finally it is verified that the lastindexof method recognizes the correct position of one of the elements included in the list.<br>
     * <b>-Pre-condition:</b> Two ListAdapter properly initialized, list1 and list2.<br>
     * <b>-Post-condition:</b> the index represents the position of a given element at a given time, if the list changes it is not guaranteed that the index is always that.<br>
     * <b>-Expected result:</b> the method recognize the right index of a object in the list.<br>
     */
    @Test
    public void lastIndexOf() {
        list1.add("a");
        list1.add("b");
        list1.add("a");
        assertEquals(2,list1.lastIndexOf("a"));
    }

    /***
     * <b>-Tests</b> the wrong functioning of indexOf() method.<br>
     * <b>-Description:</b> a null parameter was passed to indexOf() method.<br>
     * <b>-Pre-condition:</b> Two ListAdapter properly initialized, list1 and list2.<br>
     * <b>-Post-condition:</b> the exception is passed to the calling method , if this is not handled then the program ends.<br>
     * <b>-Expected result:</b> NullPointerException thrown.<br>
     */
    @Test (expected = NullPointerException.class)
    public void lastIndexOfNull(){
        list1.lastIndexOf(null);
    }

    /**
     * <b>-Tests</b> the proper functioning of remove() method.<br>
     * <b>-Description:</b> 3 elements are added to list 1, then the element in index 1 is removed and it is verified that the returned element corresponds to the one inserted.<br>
     * <b>-Pre-condition:</b> Two ListAdapter properly initialized, list1 and list2.<br>
     * An HIterator object hIt properly initialized on list1.<br> and two
     * Two HListIterator object, listIter1 initialized on list1, and listIter2 initialized on list2.<br>
     * <b>-Post-condition:</b> the list has less elements after the remove method.<br>
     * <b>-Expected result:</b> the list remove the right element.<br>
     */
    @Test
    public void removeFromIndex() {
        list1.add("a");
        list1.add("b");
        list1.add("c");

        assertEquals("b",list1.remove(1));
        assertTrue(list1.size() == 2);
    }

    /***
     * <b>-Tests</b> the wrong functioning of remove() method.<br>
     * <b>-Description:</b> a 0 parameter was passed to remove() method,but the list is empty.<br>
     * <b>-Pre-condition:</b> Two ListAdapter properly initialized, list1 and list2.<br>
     * <b>-Post-condition:</b> the exception is passed to the calling method , if this is not handled then the program ends.<br>
     * <b>-Expected result:</b> IndexOutOfBoundsException thrown.<br>
     */
    @Test (expected = IndexOutOfBoundsException.class)
    public void removeFromWrongIndex() {
        list1.remove(0);
    }

    /**
     * <b>-Tests</b> the proper functioning of remove() method.<br>
     * <b>-Description:</b> 3 items are added to the list and it is verified that the list removes them correctly and then<br>
     * it is verified that the list does not succeed in eliminating a fourth item not present.<br>
     * <b>-Pre-condition:</b> Two ListAdapter properly initialized, list1 and list2.<br>
     * <b>-Post-condition:</b> the list has less elements after the remove method.<br>
     * <b>-Expected result:</b> the list remove the right element.<br>
     */
    @Test
    public void removeObject() {
        list1.add("a");
        list1.add("b");
        list1.add("c");

        assertTrue(list1.remove("a"));
        assertTrue(list1.remove("b"));
        assertTrue(list1.remove("c"));
        assertFalse(list1.remove("d"));
        assertTrue(list1.size() == 0);
    }

    /***
     * <b>-Tests</b> the wrong functioning of remove() method.<br>
     * <b>-Description:</b> a null parameter was passed to remove() method.<br>
     * <b>-Pre-condition:</b> Two ListAdapter properly initialized, list1 and list2.<br>
     * <b>-Post-condition:</b> the exception is passed to the calling method , if this is not handled then the program ends.<br>
     * <b>-Expected result:</b> NullPointerException thrown.<br>
     */
    @Test (expected = NullPointerException.class)
    public void removeNull() {
        list1.remove(null);
    }

    /**
     * <b>-Tests</b> the proper functioning of removeAll() method.<br>
     * <b>-Description:</b> 3 elements are added to list1 and then the same to list2, a fourth element to list1 is added. remove the elements from list1 by passing list2, verify the dimensions of the two lists. check that at list2 you cannot delete elements of list1.
     * Finally, insert the missing element in list2 and delete the only remaining element from list1..<br>
     * <b>-Pre-condition:</b> Two ListAdapter properly initialized, list1 and list2.<br>
     * <b>-Post-condition:</b> list1 is empty and list2 have three elements.<br>
     * <b>-Expected result:</b> list1 is empty and list2 have the elements that were removed from list1.<br>
     */
    @Test
    public void removeAll() {
        list1.add("a");
        list1.add("b");
        list1.add("c");
        list2.addAll(list1);
        list1.add("d");
        /*
        remove the elments of list2 from list1
         */
        assertTrue(list1.removeAll(list2));
        assertTrue(list1.size() == 1);
        assertTrue(list2.size() == 3);
        /*
        list1 : [ d ]
        list2 : [ a b c ]
         */
        assertFalse(list2.removeAll(list1));
        assertTrue(list2.size() == 3);
        /*
        list2 remain the same
        add to list2 the element that list1 contain, and i delete it from list1.
         */
        list2.add("d");
        assertTrue(list1.removeAll(list2));
        assertTrue(list1.size() == 0);
    }

    /***
     * <b>-Tests</b> the wrong functioning of remove() method.<br>
     * <b>-Description:</b> a 0 parameter was passed to remove() method, but the list is empty.<br>
     * <b>-Pre-condition:</b> Two ListAdapter properly initialized, list1 and list2.<br>
     * <b>-Post-condition:</b> the exception is passed to the calling method , if this is not handled then the program ends.<br>
     * <b>-Expected result:</b> IndexOutOfBoundsException thrown.<br>
     */
    @Test (expected = IndexOutOfBoundsException.class)
    public void removeFromEmptyList() {
        list1.remove(0);
    }

    /***
     * <b>-Tests</b> the wrong functioning of removeAll() method.<br>
     * <b>-Description:</b> a null parameter was passed to removeAll() method.<br>
     * <b>-Pre-condition:</b> Two ListAdapter properly initialized, list1 and list2.<br>
     * <b>-Post-condition:</b> the exception is passed to the calling method , if this is not handled then the program ends.<br>
     * <b>-Expected result:</b> NullPointerException thrown.<br>
     */
    @Test ( expected = NullPointerException.class)
    public void removeAllNull() {
        list1.removeAll(null);
    }

    /**
     * <b>-Tests</b> the proper functioning of retainAll() method.<br>
     * <b>-Description:</b> 5 elements are added to list1, then 4 of the same 5 elements in different order are added to list2, the dimensions of both lists are checked for the presence of the elements.
     * Finally you keep the elements of list2 in list1 with the retain all method and you verify the size of list1..<br>
     * Finally is cleared list2 and check that ratainall of list1 with list2 empty as parameter does not change list1.<br>
     * <b>-Pre-condition:</b> Two ListAdapter properly initialized, list1 and list2.<br>
     * <b>-Post-condition:</b> the list has narrowed or not the number of items within.<br>
     * <b>-Expected result:</b>the list keeps the elements within it, of a non empty Hcollection passed by argument .<br>
     */
    @Test
    public void retainAll() {
        list1.add("a");
        list1.add("b");
        list1.add("b");
        list1.add("c");
        list1.add("e");

        list2.add("b");
        list2.add("c");
        list2.add("a");
        list2.add("b");

        assertTrue(list1.size() == 5);
        assertTrue(list2.size() == 4);

        assertTrue(list1.retainAll(list2));
        assertTrue(list1.size() == 4);

        list2.clear();
        assertFalse(list1.retainAll(list2));
    }

    /***
     * <b>-Tests</b> the wrong functioning of retainAll() method.<br>
     * <b>-Description:</b> a null parameter was passed to removeAll() method.<br>
     * <b>-Pre-condition:</b> Two ListAdapter properly initialized, list1 and list2.<br>
     * <b>-Post-condition:</b> the exception is passed to the calling method , if this is not handled then the program ends.<br>
     * <b>-Expected result:</b> NullPointerException thrown.<br>
     */
    @Test (expected = NullPointerException.class)
    public void retainAllNull(){
        list1.retainAll(null);
    }

    /**
     * <b>-Tests</b> the proper functioning of set() method.<br>
     * <b>-Description:</b> add 3 elements to the list, change the element to index 1 and verify that the correct index has been changed.<br>
     * <b>-Pre-condition:</b> Two ListAdapter properly initialized, list1 and list2.<br>
     * <b>-Post-condition:</b> the item that sets changes remains unchanged until a next change in the list.<br>
     * <b>-Expected result:</b> set changes the element to a valid index .<br>
     */
    @Test
    public void set() {
        list1.add("a");
        list1.add("b");
        list1.add("c");

        list1.set(1,"z");

        assertEquals("a",list1.get(0));
        assertEquals("z",list1.get(1));
        assertEquals("c",list1.get(2));
    }

    /***
     * <b>-Tests</b> the wrong functioning of set() method.<br>
     * <b>-Description:</b> a null parameter was passed to set() method.<br>
     * <b>-Pre-condition:</b> Two ListAdapter properly initialized, list1 and list2.<br>
     * <b>-Post-condition:</b> the exception is passed to the calling method , if this is not handled then the program ends.<br>
     * <b>-Expected result:</b> NullPointerException thrown.<br>
     */
    @Test (expected = NullPointerException.class)
    public void setNullElement() {
        list1.add("a");
        list1.set(0,null);
    }

    /**
     * <b>-Tests</b> the proper functioning of size() method.<br>
     * <b>-Description:</b> verify that the list1 has size 0, then add 2 elements and verify that it has size 2,
     * then delete the list and verify that it has size 0.<br>
     * <b>-Pre-condition:</b> Two ListAdapter properly initialized, list1 and list2.<br>
     * An HIterator object hIt properly initialized on list1.<br> and two
     * Two HListIterator object, listIter1 initialized on list1, and listIter2 initialized on list2.<br>
     * <b>-Post-condition:</b> size always shows the right number of items in the list.<br>
     * <b>-Expected result:</b> size shows the right number ot the items.<br>
     */
    @Test
    public void size() {
        assertTrue(list1.size() == 0);
        list1.add("a");
        list1.add("b");
        assertTrue(list1.size() == 2);
        list1.clear();
        assertTrue(list1.size() == 0);
    }

    /**
     * <b>-Tests</b> the proper functioning of toArray() method.<br>
     * <b>-Description:</b> 4 elements are added identical to list1 and an array, then a second array is made generated by list. <br>
     * It is verified that the two arrays have the same elements and that the second array generated by list has the same list elements.<br>
     * <b>-Pre-condition:</b> Two ListAdapter properly initialized, list1 and list2.<br>
     * <b>-Post-condition:</b> the array contains the list elements at that time, if the list changes it is not said that the array elements are those of the list.<br>
     * <b>-Expected result:</b> .<br>
     */
    @Test
    public void toArray() {
        Object[] a = new Object[4];
        for(int i = 0; i < 4; i++) {
            a[i] = i;
            list1.add(i);
        }
        Object[] b = list1.toArray();
        for(int i = 0; i < b.length;i++) {
            assertEquals(a[i],b[i]);
            assertEquals(b[i],list1.get(i));
        }
    }

    /**
     * <b>-Tests</b> the proper functioning of toArray() method.<br>
     * <b>-Description:</b> Two arrays one of dimension 2 and one of dimension 3 are created, three elements are added to the list and it is verified that the method to array
     * returns some arrays with a capacity at least equal to its number of elements.<br>
     * Finally the equality between the elements of the arrays and those contained in the list is verified.<br>
     * <b>-Pre-condition:</b> Two ListAdapter properly initialized, list1 and list2.<br>
     * An HIterator object hIt properly initialized on list1.<br> and two
     * Two HListIterator object, listIter1 initialized on list1, and listIter2 initialized on list2.<br>
     * <b>-Post-condition:</b> the array contains the list elements at that time, if the list changes it is not said that the array elements are those of the list.<br>
     * <b>-Expected result:</b> Arrays have a minimum size and contain the list items..<br>
     */
    @Test
    public void toArray2() {
        Object[] a1 = new Object[2];
        Object[] a2 = new Object[3];
        list1.add("a");
        list1.add("b");
        list1.add("c");

        a1 = list1.toArray(a1);
        a2 = list1.toArray(a2);

        assertTrue(a1.length == 3);
        assertTrue(a2.length == 3);

        for (int i = 0; i < 3; i++) {
            assertEquals(a1[i],a2[i]);
            assertEquals(a1[i],list1.get(i));
        }
    }

    /***
     * <b>-Tests</b> the wrong functioning of toArray() method.<br>
     * <b>-Description:</b> a null parameter was passed to toArray() method.<br>
     * <b>-Pre-condition:</b> Two ListAdapter properly initialized, list1 and list2.<br>
     * <b>-Post-condition:</b> the exception is passed to the calling method , if this is not handled then the program ends.<br>
     * <b>-Expected result:</b> NullPointerException thrown.<br>
     */
    @Test (expected = NullPointerException.class)
    public void ToNullArray(){
        list1.toArray(null);
    }

    /***
     * <b>-Tests</b> the wrong functioning of toArray() method.<br>
     * <b>-Description:</b> the array given as a parameter is not a supertype of ListAdapter.<br>
     * <b>-Pre-condition:</b> Two ListAdapter properly initialized, list1 and list2.<br>
     * <b>-Post-condition:</b> the exception is passed to the calling method , if this is not handled then the program ends.<br>
     * <b>-Expected result:</b> ArrayStoreException thrown.<br>
     */
    @Test (expected = ArrayStoreException.class)
    public void toArrayStoreException() {
        list1.add("a");
        list1.add("b");
        Integer[] array = new Integer[4];
        list1.toArray((Object[]) array);
    }


    /**
     * <b>-Tests</b> the proper functioning of subList() method.<br>
     * <b>-Description:</b> elements are added to list1 then to list2 the sublist of list1 is passed. <br>
     * It is verified that the sublist has no reference to null and that the elements of the sublist correspond to those of the list.<br>
     * <b>-Pre-condition:</b> Two ListAdapter properly initialized, list1 and list2.<br>
     * An HIterator object hIt properly initialized on list1.<br> and two
     * Two HListIterator object, listIter1 initialized on list1, and listIter2 initialized on list2.<br>
     * <b>-Post-condition:</b> .<br>
     * <b>-Expected result:</b> .<br>
     * @see SubListIdioms SubListIdioms
     */
    @Test
    public void sublist() {
        list1.add("a");
        list1.add("b");
        list1.add("c");
        list1.add("a");
        list1.add("b");
        list1.add("c");
        list2 = (ListAdapter) list1.subList(1,4);
        assertFalse(list2 == null);
        assertTrue(list2.size() == 3);
        assertEquals(list1.get(1),list2.get(0));
        assertEquals(list1.get(2),list2.get(1));
        assertEquals(list1.get(3),list2.get(2));
    }

    /***
     * <b>-Tests</b> the proper functioning of iterator() method.<br>
     * <b>-Description:</b> it is verified that the iterator don't have a reference to null.<br>
     * <b>-Pre-condition:</b> Two ListAdapter properly initialized, list1 and list2.<br>
     * An HIterator object h1 properly initialized on list1.<br> and two
     * <b>-Post-condition:</b> the iterator exist in the same time that the list on which was created still exist.<br>
     * <b>-Expected result:</b> the iterator don't have a reference to null.<br>
     */
    @Test
    public void iterator() {
        assertTrue(h1 != null);
    }

    /***
     * <b>-Tests</b> the proper functioning of HIterator.hasNext() method.<br>
     * <b>-Description:</b> it is verified that the iterator recognize when it has an element to iterate.<br>
     * <b>-Pre-condition:</b> Two ListAdapter properly initialized, list1 and list2.<br>
     * An HIterator object h1 properly initialized on list1.<br> and two
     * <b>-Post-condition:</b> the iterator could call next() if hasNext() return true.<br>
     * <b>-Expected result:</b> the iterator recognize when it has a element to iterate or not.<br>
     */
    @Test
    public void iteratorHasNext(){
        assertFalse(h1.hasNext());
        list1.add("a");
        assertTrue(h1.hasNext());
    }

    /***
     * <b>-Tests</b> the proper functioning of HIterator.next() method.<br>
     * <b>-Description:</b> it is verified that the iterator recognize that has an element to iterate, and when it is called next(), it returns the next element.<br>
     * <b>-Pre-condition:</b> Two ListAdapter properly initialized, list1 and list2.<br>
     * An HIterator object h1 properly initialized on list1.<br> and two
     * <b>-Post-condition:</b> the object return by next() could be manipulated.<br>
     * <b>-Expected result:</b> the iterator return the right element present in the list.<br>
     */
    @Test
    public void iteratorNext(){
        list1.add(1);
        list1.add(2);
        list1.add(3);
        int i = 1;
        while (h1.hasNext()) {
            assertEquals(i++,h1.next());
        }

    }

    /**
     * <b>-Tests</b> the proper functioning of listIterator() method.<br>
     * <b>-Description:</b> check that listIterator 1 and 2 do not have a null reference.<br>
     * <b>-Pre-condition:</b> Two ListAdapter properly initialized, list1 and list2.<br>
     * Two HListIterator object, listIter1 initialized on list1, and listIter2 initialized on list2.<br>
     * <b>-Post-condition:</b> iterators do not have a null reference until the list on which they were built exists.<br>
     * <b>-Expected result:</b> the iterators don't have a null reference.<br>
     */
    @Test
    public void listIterator() {
        assertTrue(hl1 != null);
        assertTrue(hl2 != null);
        assertFalse(hl1.hasNext());
        assertFalse(hl2.hasNext());
    }

    /**
     * <b>-Tests</b> the proper functioning of listIterator(int index) method.<br>
     * <b>-Description:</b> are added to list 2 and an iterator is created on it to a valid index, it is verified that the iterator has no null reference.<br>
     * <b>-Pre-condition:</b> Two ListAdapter properly initialized, list1 and list2.<br>
     * Two HListIterator object, listIter1 initialized on list1, and listIter2 initialized on list2.<br>
     * <b>-Post-condition:</b> iterators do not have a null reference until the list on which they were built exists.<br>
     * <b>-Expected result:</b> the iterators don't have a null reference.<br>
     */
    @Test
    public void listIteratorWithIndex() {
        assertFalse(hl2 == null);
        assertFalse(hl2.hasNext());

        list2.add("a");
        list2.add("b");
        list2.add("c");

        hl2 = list2.listIterator(1);
        assertFalse(hl2 == null);
        assertTrue(hl2.hasNext());
        assertTrue(hl2.hasPrevious());
    }

    /***
     * <b>-Tests</b> the wrong functioning of listIterator() method.<br>
     * <b>-Description:</b> a 0 parameter was passed to indexOf() method,but the list is empty.<br>
     * <b>-Pre-condition:</b> Two ListAdapter properly initialized, list1 and list2.<br>
     * <b>-Post-condition:</b> the exception is passed to the calling method , if this is not handled then the program ends.<br>
     * <b>-Expected result:</b> IndexOutOfBoundsException thrown.<br>
     */
    @Test (expected = IndexOutOfBoundsException.class)
    public void listIteratorWithWrongIndex() {
        hl2 = list2.listIterator(0);
    }


}