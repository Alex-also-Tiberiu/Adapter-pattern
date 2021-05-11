package myAdapter.Test;

import myAdapter.HIterator;
import myAdapter.HListIterator;
import myAdapter.ListAdapter;
import org.junit.Test;
import org.junit.Before;
import static org.junit.Assert.*;

/***
 * Testing ListAdapter and ListIterator and Iterator
 * Some methods of ListAdapter use ListIterator and Iterator
 */
public class ListAdapterTest {

    private ListAdapter list1;
    private ListAdapter list2;
    private HIterator h1;
    private HListIterator hl1;
    private HListIterator hl2;

    /***
     * This method create an instance of ListAdapter and ListAdapter with 15 rows
     */
    @Before
    public void setup(){
        list1 = new ListAdapter();
        list2 = new ListAdapter(15);
        h1 = list1.iterator();
        hl1 = list1.listIterator();
        hl2 = list2.listIterator();
    }

    /***
     * This method tests the right initialization of ListAdapter
     */
    @Test
    public void testListAdapterInit() {
        assertTrue(list1.isEmpty());
        assertTrue(list1.size() == 0);

        assertTrue(list2.isEmpty());
        assertTrue(list2.size() == 0);
    }

    /***
     * This method tests the wrong initialization of ListAdapter
     */
    @Test (expected = IllegalArgumentException.class)
    public void testInvalidCapacity() {
        list1 = new ListAdapter(-1);
        list2 = new ListAdapter(-2);
    }

    /***
     * This method tests two adds of ListAdapter.
     * It adds only two object.
     */
    @Test
    public void add() {
        assertTrue(list1.add("one"));
        assertTrue(list2.add("two"));
        assertTrue(list1.size() == 1);
        assertTrue(list2.size() == 1);
    }

    /***
     * This method tests the add method of ListAdapter, using the index,
     * and also add an object where is already present an object, to see
     * if the object in the ListAdapter shifts on the right of their index.
     */
    @Test
    public void testAdd() {
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
     * This method inserts a HCollection in the ListAdapter, and check
     * the boolean condition that says if the ListAdapter changes its content.
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
     * This method insert a HCollection in the ListAdapter with an index, and check
     * the boolean condition that says if the ListAdapter changes its content.
     */
    @Test
    public void testAddAll() {
        assertTrue(!list1.addAll(0,list2));

        list1.add("a");
        list1.add("b");
        list1.add("c");
        list1.add("d");

        assertTrue(!list1.addAll(0,list2));
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
     * This method tests the expected NullPointerException if someone inserts
     * a null HCollection in ListAdapter.
     * Null elements in the HCollection can't be tested, because ListAdapter
     * do not allow to insert null elements.
     * Otherwise, both addAll methods are implemented to throw a NullPointerException,
     * in case will be introduced a different HCollection that accept null elements.
     */
    @Test (expected = NullPointerException.class)
    public void addAllNull() {
        list1.addAll(null);
    }

    /***
     * This method excepts to introduce a null HCollection in the ListAdapter with an index.
     * At last NullPointerException must be throw
     */
    @Test (expected = NullPointerException.class)
    public void testAddNullElement() {
        list1.add(1,null);
        list1.add(null);
        list2.add(3,null);
        list2.add(null);
    }

    /***
     * This method excepts to introduce a negative index when it is added an HCollection.
     * At last IndexOutOfBoundsException must be throw.
     */
    @Test (expected = IndexOutOfBoundsException.class)
    public void testAddNegativeIndex() {
        list1.add(-1,"one");
        list2.add(-2,"two");
    }

    /***
     * This method checks if the List is Empty after the clear() method
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
     * This method checks if the ListAdapter recognize an object already present.
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
     * this method checks if the ListAdapter contains all the elements of the HCollection introduced.
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
     * this method expects a null element in the contains() to throw NullPointerException.
     */
    @Test (expected = NullPointerException.class)
    public void containsAllNullElement() {
        list1.contains(null);
    }

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

        assertTrue(!list1.equals(list2));
        assertTrue(!list1.equals(s));

        list2.clear();
        list2.add(1);
        list2.add(2);
        list2.add(3);
        list2.add(4);

        assertTrue(list1.equals(list2));
    }

    /***
     * this method check the getter of ListAdapter
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

    @Test (expected = IndexOutOfBoundsException.class)
    public void getFromWrongIndex() {
        list1.get(0);
    }

    /***
     * This method tests the fact that two ListAdapter must have the same hashcode
     * if they are equals.
     */
    @Test
    public void testhashCode() {
        list1.add("a");
        list1.add("b");
        list1.add("c");

        list2.add("a");
        list2.add("b");
        list2.add("c");

        int h1 = list1.hashCode();
        int h2 = list2.hashCode();

        assertTrue(h1 == h2);

        list2.add("e");
        list2.add("f");
        h2 = list2.hashCode();

        assertTrue( h1 != h2);
    }

    /***
     * This method checks if the ListAdapter return the right index of the elements
     * introduced.
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

    @Test (expected = NullPointerException.class)
    public void nullindexOf(){
        list1.indexOf(null);
    }

    @Test
    public void isEmpty() {
        assertTrue(list1.isEmpty());
        list1.add("a");
        assertTrue(!list1.isEmpty());
    }

    @Test
    public void iterator() {
        assertTrue(!h1.hasNext());
        list1.add("a");
        assertTrue(h1.hasNext());
    }

    @Test
    public void lastIndexOf() {
        list1.add("a");
        list1.add("b");
        list1.add("a");
        assertEquals(2,list1.lastIndexOf("a"));
    }

    @Test (expected = NullPointerException.class)
    public void lastIndexOfNull(){
        list1.lastIndexOf(null);
    }

    @Test
    public void listIterator() {
        assertTrue(!hl1.hasNext());
    }

    @Test
    public void testListIterator() {
        assertTrue(!hl2.hasNext());

        list2.add("a");
        list2.add("b");
        list2.add("c");

        hl2 = list2.listIterator(1);
        assertTrue(hl2.hasNext());
        assertTrue(hl2.hasPrevious());
    }

    @Test (expected = IndexOutOfBoundsException.class)
    public void testWrongIndexListIterator() {
        hl2 = list2.listIterator(0);
    }

    @Test
    public void remove() {
        list1.add("a");
        list1.add("b");
        list1.add("c");

        assertEquals("b",list1.remove(1));
        assertTrue(list1.size() == 2);
    }

    @Test (expected = IndexOutOfBoundsException.class)
    public void removeFromWrongIndex() {
        list1.remove(0);
    }

    @Test
    public void testRemove() {
        list1.add("a");
        list1.add("b");
        list1.add("c");

        assertTrue(list1.remove("a"));
        assertTrue(list1.remove("b"));
        assertTrue(list1.remove("c"));
        assertTrue(!list1.remove("d"));
        assertTrue(list1.size() == 0);
    }

    @Test (expected = NullPointerException.class)
    public void removeNull() {
        list1.remove(null);
    }

    @Test
    public void removeAll() {
        list1.add("a");
        list1.add("b");
        list1.add("c");
        list2.addAll(list1);
        list1.add("d");

        /*
        elimino gli elementi di list2 da list1
         */
        assertTrue(list1.removeAll(list2));
        assertTrue(list1.size() == 1);
        assertTrue(list2.size() == 3);
        /*
        list1 : [ d ]
        list2 : [ a b c ]
         */

        assertTrue(!list2.removeAll(list1));
        assertTrue(list2.size() == 3);
        /*
        list2 rimane invariata
        sotto aggiungo a list2 l'elemento che anche list1 contiene, e lo elimino da list1
         */

        list2.add("d");
        assertTrue(list1.removeAll(list2));
        assertTrue(list1.size() == 0);
    }

    @Test (expected = IndexOutOfBoundsException.class)
    public void testRemoveFromEmptyList() {
        list1.remove(0);
    }

    @Test ( expected = NullPointerException.class)
    public void testRemoveAllNull() {
        list1.removeAll(null);
    }

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
        assertTrue(!list1.retainAll(list2));
    }

    @Test (expected = NullPointerException.class)
    public void retainAllNull(){
        list1.retainAll(null);
    }

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

    @Test (expected = NullPointerException.class)
    public void testSetNullElement() {
        list1.add("a");
        list1.set(0,null);
    }

    @Test
    public void size() {
        assertTrue(list1.size() == 0);
        list1.add("a");
        list1.add("b");
        assertTrue(list1.size() == 2);
        list1.clear();
        assertTrue(list1.size() == 0);
    }

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

    @Test
    public void testToArray() {
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

    @Test (expected = NullPointerException.class)
    public void testToNullArray(){
        list1.toArray(null);
    }

    @Test (expected = ArrayStoreException.class)
    public void testToArrayStoreException() {
        list1.add("a");
        list1.add("b");
        Integer[] array = new Integer[4];
        list1.toArray((Object[]) array);
    }

    @Test
    public void sublist() {
        list1.add("a");
        list1.add("b");
        list1.add("c");
        list1.add("a");
        list1.add("b");
        list1.add("c");
        list2 = list1.subList(1,4);

        assertTrue(list2.size() == 3);
        assertEquals(list1.get(1),list2.get(0));
        assertEquals(list1.get(2),list2.get(1));
        assertEquals(list1.get(3),list2.get(2));
    }

    @Test
    public void clearSubList() {
        list1.add("a");
        list1.add("b");
        list1.add("c");
        list1.add("a");
        list1.add("b");
        list1.add("c");
        list1.subList(1,4).clear();

        assertTrue(list1.size() == 3);
        assertTrue(list2.size() == 0);
        assertEquals("a",list1.get(0));
        assertEquals("b",list1.get(1));
        assertEquals("c",list1.get(2));
    }


}