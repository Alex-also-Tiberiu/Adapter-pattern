package myAdapter.Test;

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

    @Before
    public void setup(){
        list1 = new ListAdapter();
        list2 = new ListAdapter(15);
    }

    @Test
    public void testListAdapterInit() {
        assertTrue(list1.isEmpty());
        assertTrue(list1.size() == 0);

        assertTrue(list2.isEmpty());
        assertTrue(list2.size() == 0);
    }

    @Test (expected = IllegalArgumentException.class)
    public void testInvalidCapacity() {
        list1 = new ListAdapter(-1);
        list2 = new ListAdapter(-2);
    }

    @Test
    public void add() {
        assertTrue(list1.add("one"));
        assertTrue(list2.add("two"));
    }

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

    @Test
    public void addAll() {
        assertTrue(!(list1.addAll(list2)));

        list1.add("a");
        list1.add("b");
        list1.add("c");
        list1.add("d");

        assertTrue(!(list1.addAll(list2)));
        assertTrue(list2.addAll(list1));

        assertEquals("a",list2.get(0));
        assertEquals("b",list2.get(1));
        assertEquals("c",list2.get(2));
        assertEquals("d",list2.get(3));
    }

    @Test
    public void testAddAll() {
        assertTrue(!list1.addAll(0,list2));

        list1.add("a");
        list1.add("b");
        list1.add("c");
        list1.add("d");

        assertTrue(!list1.addAll(0,list2));

        list2.add("x");
        list2.add("y");
        list2.add("z");

        assertTrue(list1.addAll(2,list2));
        assertEquals("a",list1.get(0));
        assertEquals("b",list1.get(1));
        assertEquals("x",list1.get(2));
        assertEquals("y",list1.get(3));
        assertEquals("z",list1.get(4));
        assertEquals("c",list1.get(5));
        assertEquals("d",list1.get(6));
    }

    @Test (expected = NullPointerException.class)
    public void addAllNull() {
        list1.addAll(null);
    }

    @Test (expected = NullPointerException.class)
    public void testAddNullElement() {
        list1.add(1,null);
        list1.add(null);
        list2.add(3,null);
        list2.add(null);
    }

    @Test (expected = IndexOutOfBoundsException.class)
    public void testAddNegativeIndex() {
        list1.add(-1,"one");
        list2.add(-2,"two");
    }


    @Test
    public void clear() {
    }

    @Test
    public void contains() {
    }

    @Test
    public void containsAll() {
    }

    @Test
    public void get() {
    }

    @Test
    public void indexOf() {
    }

    @Test
    public void isEmpty() {
    }

    @Test
    public void iterator() {
    }

    @Test
    public void lastIndexOf() {
    }

    @Test
    public void listIterator() {
    }

    @Test
    public void testListIterator() {
    }

    @Test
    public void remove() {
        list1.add("a");
        list1.add("b");
        list1.add("c");

        assertEquals("b",list1.remove(1));
        assertTrue(list1.size() == 2);
    }

    @Test
    public void testRemove() {
    }

    @Test
    public void removeAll() {
    }

    @Test (expected = IndexOutOfBoundsException.class)
    public void testRemoveWithEmptyList() {
        list1.remove(0);
    }

    @Test
    public void retainAll() {
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
    }

    @Test
    public void toArray() {
    }

    @Test
    public void testToArray() {
    }
}