package myAdapter.Test;
import myAdapter.HListIterator;
import myAdapter.ListAdapter;
import org.junit.Test;
import org.junit.Before;
import java.util.NoSuchElementException;
import static org.junit.Assert.*;

/***
 * This class tests the functionality of ListIterator which is returned by the ListAdapter class. <br>
 * Tests of this class are performed by the LITestRunner class.<br>
 * This class tries to demonstrate the correct behavior of the methods used on ListIterator . <br>
 * @see ListIteratorTestRunner ListIteratorTestRunner. <br>
 * @see ListAdapter ListAdapter. <br>
 */
public class ListIteratorTest {

    /***
     * instance variable of ListAdapter - list
     */
    private ListAdapter list;
    /***
     * instance variable of a HListIterator of ListAdapter list1. <br>#
     * It will be generated with the method : HMap.listIterator().
     */
    private HListIterator iter;

    /**
     * <b>-Before : </b> Setup test, this is done before every test.<br>
     * <b>-Description:</b> This method create an instance of ListAdapter and an instance of HListIterator on ListAdapter.<br>
     * <b>-Pre-condition:</b> the instance variable have been created without being instantiated.<br>
     * <b>-Post-condition:</b> the instance variable have been instantiated.<br>
     * <b>-Expected result:</b> the instance variable have been instantiated.<br>
     */
    @Before
    public void setup(){
        list = new ListAdapter();
        iter = list.listIterator();
    }

    /**
     * <b>-Tests</b> the proper functioning of () method.<br>
     * <b>-Description:</b> This method tests the right initialization of ListIterator and ListAdapter.<br>
     * <b>-Pre-condition:</b> ListAdapter properly initialized list .<br>
     * HListIterator object iter initialized on list<br>
     * <b>-Post-condition:</b> the instance variable have been correctly instantiated.<br>
     * <b>-Expected result:</b> the instance variable have not a reference to null.<br>
     */
    @Test
    public void listIteratorInit(){
        assertFalse(list == null);
        assertFalse(iter == null);
    }

    /**
     * <b>-Tests</b> the proper functioning of add() method.<br>
     * <b>-Description:</b> with the add method on the iterator new objects are added and it is verified in the list that they are present.<br>
     * <b>-Pre-condition:</b> ListAdapter properly initialized list1 .<br>
     * HListIterator object iter initialized on list<br>
     * <b>-Post-condition:</b> list contains the new elements added by the iterator.<br>
     * <b>-Expected result:</b> iterator add new elements.<br>
     */
    @Test
    public void add(){
        iter.add(1);
        iter.add(2);
        iter.add(3);
        assertTrue(list.contains(1));
        assertTrue(list.contains(2));
        assertTrue(list.contains(3));
        assertEquals(3,list.size());
    }

    /**
     * <b>-Tests</b> the wrong functioning of add() method.<br>
     * <b>-Description:</b> a null parameter is passed to the add() method .<br>
     * <b>-Pre-condition:</b> ListAdapter properly initialized list1 .<br>
     * HListIterator object iter initialized on list<br>
     * <b>-Post-condition:</b> the exception is passed to the calling method , if this is not handled then the program ends.<br>
     * <b>-Expected result:</b> NullPointerException thrown.<br>
     */
    @Test (expected = NullPointerException.class)
    public void addNull(){
        iter.add(null);
    }

    /**
     * <b>-Tests</b> the proper functioning of hasNext() method.<br>
     * <b>-Description:</b> verify that the iterated empty list does not have next element, then add an element and verify that the list has a next element.<br>
     * <b>-Pre-condition:</b> ListAdapter properly initialized list1 .<br>
     * HListIterator object iter initialized on list<br>
     * <b>-Post-condition:</b> the iterator has a next element if the list don't change.<br>
     * <b>-Expected result:</b> the iterator has a next element if the list don't change.<br>
     */
    @Test
    public void hasNext(){
        assertFalse(iter.hasNext());
        list.add(0);
        assertTrue(iter.hasNext());
    }

    /**
     * <b>-Tests</b> the proper functioning of hasPrevious() method.<br>
     * <b>-Description:</b> check that the iterator has no precedent when it is empty,
     * then add an element and slide the iterator to a position and verify that it has a previous element.<br>
     * <b>-Pre-condition:</b> ListAdapter properly initialized list1 .<br>
     * HListIterator object iter initialized on list<br>
     * <b>-Post-condition:</b> the iterator has a previous element if the list don't change.<br>
     * <b>-Expected result:</b> the iterator has a previous element if the list don't change.<br>
     */
    @Test
    public void hasPrevious(){
        assertFalse(iter.hasPrevious());
        assertFalse(iter.hasNext());
        list.add(0);
        assertTrue(iter.hasNext());
        iter.next();
        assertTrue(iter.hasPrevious());
        assertFalse(iter.hasNext());
    }

    /**
     * <b>-Tests</b> the proper functioning of next() method.<br>
     * <b>-Description:</b> two elements have been added to the list, and the iterator is scrolled on the list and verified that they are the same elements inserted.<br>
     * <b>-Pre-condition:</b> ListAdapter properly initialized list1 .<br>
     * HListIterator object iter initialized on list<br>
     * <b>-Post-condition:</b> next don't modify the list, it only inspect the list.<br>
     * <b>-Expected result:</b> the iterator return the next element present in the list.<br>
     */
    @Test
    public void next(){
        list.add(1);
        list.add(2);
        assertTrue(iter.hasNext());
        Object obj1 = iter.next();
        Object obj2 = iter.next();
        assertEquals(1,obj1);
        assertEquals(2,obj2);
    }

    /**
     * <b>-Tests</b> the wrong functioning of next() method.<br>
     * <b>-Description:</b> is called the iterator on a non-empty list, once the iterator has iterated the entire list, it is called next that throws an exception.<br>
     * <b>-Pre-condition:</b> ListAdapter properly initialized list1 .<br>
     * HListIterator object iter initialized on list<br>
     * <b>-Post-condition:</b> the exception is passed to the calling method , if this is not handled then the program ends.<br>
     * <b>-Expected result:</b> NoSuchElementException thrown.<br>
     */
    @Test (expected = NoSuchElementException.class)
    public void nextNull(){
        list.add(0);
        list.add(1);
        list.add(2);
        while(iter.hasNext())
            iter.next();
        iter.next();
    }

    /**
     * <b>-Tests</b> the proper functioning of nextIndex() method.<br>
     * <b>-Description:</b> elements are added to the list, the iterator is iterated and every iteration the next index that must return.<br>
     * <b>-Pre-condition:</b> ListAdapter properly initialized list1 .<br>
     * HListIterator object iter initialized on list<br>
     * <b>-Post-condition:</b> the index may be not right if the list change .<br>
     * <b>-Expected result:</b> the iterator return the current next index.<br>
     */
    @Test
    public void nextIndex(){
        assertEquals(0,iter.nextIndex());
        list.add(10);
        list.add(12);
        assertTrue(iter.hasNext());
        iter.next();
        assertEquals(1,iter.nextIndex());
    }

    /**
     * <b>-Tests</b> the proper functioning of previous() method.<br>
     * <b>-Description:</b> iterate the iterator on a non-empty list to the end and then it is sent back and the elements are verified.<br>
     * <b>-Pre-condition:</b> ListAdapter properly initialized list1 .<br>
     * HListIterator object iter initialized on list<br>#
     * <b>-Post-condition:</b> the element is on the current position returned.<br>
     * <b>-Expected result:</b> previous return the previous item.<br>
     */
    @Test
    public void previous(){
        list.add(0);
        list.add(1);
        list.add(2);
        list.add(3);
        assertTrue(iter.hasNext());
        assertEquals(0,iter.next());
        assertEquals(1,iter.next());
        assertEquals(2,iter.next());
        assertEquals(3,iter.next());
        assertFalse(iter.hasNext());
        assertTrue(iter.hasPrevious());
        assertEquals(3,iter.previous());
        assertEquals(2,iter.previous());
        assertEquals(1,iter.previous());
        assertEquals(0,iter.previous());
        assertFalse(iter.hasPrevious());
    }

    /**
     * <b>-Tests</b> the proper functioning of previous() method.<br>
     * <b>-Description:</b> is called the iterator on a empty list.<br>
     * <b>-Pre-condition:</b> ListAdapter properly initialized list1 .<br>
     * HListIterator object iter initialized on list<br>
     * <b>-Post-condition:</b> the exception is passed to the calling method , if this is not handled then the program ends.<br>
     * <b>-Expected result:</b> NoSuchElementException thrown.<br>
     */
    @Test (expected = NoSuchElementException.class)
    public void previousNull(){
        iter.previous();
    }

    /**
     * <b>-Tests</b> the proper functioning of previousIndex() method.<br>
     * <b>-Description:</b> iterate an iterator on an empty list and the indexes are checked.<br>
     * <b>-Pre-condition:</b> ListAdapter properly initialized list1 .<br>
     * HListIterator object iter initialized on list<br>
     * <b>-Post-condition:</b> the index may change if the list change.<br>
     * <b>-Expected result:</b> return the right index.<br>
     */
    @Test
    public void previousIndex(){
        list.add(0);
        list.add(1);
        list.add(2);
        list.add(3);
        assertTrue(iter.hasNext());
        assertEquals(0,iter.next());
        assertEquals(1,iter.next());
        assertEquals(2,iter.next());
        assertEquals(3,iter.next());

        assertEquals(4,iter.nextIndex());
        assertEquals(3,iter.previousIndex());
    }

    /**
     * <b>-Tests</b> the proper functioning of remove() method.<br>
     * <b>-Description:</b> iterate the iterator on a non-empty list, delete the last item returned by next and verify list items.<br>
     * <b>-Pre-condition:</b> ListAdapter properly initialized list1 .<br>
     * HListIterator object iter initialized on list<br>
     * <b>-Post-condition:</b> the list has fewer items.<br>
     * <b>-Expected result:</b> the element claimed by next has been deleted.<br>
     */
    @Test
    public void removeNext(){
        list.add("a");
        list.add("b");
        list.add("c");
        assertTrue(list.size() == 3);
        assertTrue(iter.hasNext());
        assertEquals("a",iter.next());
        assertEquals("b",iter.next());
        iter.remove();
        assertTrue(list.size() == 2);
        assertTrue(iter.hasNext());
        assertEquals("a",iter.next());
        assertEquals("c",iter.next());
    }

    /**
     * <b>-Tests</b> the proper functioning of remove() method.<br>
     * <b>-Description:</b> iterate the iterator on a non-empty list, delete the last item returned by next and verify list items.<br>
     * <b>-Pre-condition:</b> ListAdapter properly initialized list1 .<br>
     * HListIterator object iter initialized on list<br>
     * <b>-Post-condition:</b> the list has fewer items.<br>
     * <b>-Expected result:</b> the element claimed by previous has been deleted.<br>
     */
    @Test
    public void removePrevious(){
        list.add("a");
        list.add("b");
        list.add("c");
        assertTrue(list.size() == 3);
        assertTrue(iter.hasNext());
        assertEquals("a",iter.next());
        assertEquals("b",iter.next());
        assertEquals("c",iter.next());
        assertTrue(iter.hasPrevious());
        assertEquals("c",iter.previous());
        iter.remove();
        assertTrue(list.size() == 2);
        /*
        iterator is reseted from the beginning because the list changed its size.
         */
        assertFalse(iter.hasPrevious());
        assertTrue(iter.hasNext());
        assertEquals("a",iter.next());
        assertEquals("b",iter.next());
        assertFalse(iter.hasNext());
    }

    /**
     * <b>-Tests</b> the wrong functioning of remove() method.<br>
     * <b>-Description:</b> was called remove without calling next or previous.<br>
     * <b>-Pre-condition:</b> ListAdapter properly initialized list1 .<br>
     * HListIterator object iter initialized on list<br>
     * <b>-Post-condition:</b> the exception is passed to the calling method , if this is not handled then the program ends.<br>
     * <b>-Expected result:</b> IllegalArgumentException thrown.<br>
     */
    @Test (expected = IllegalArgumentException.class)
    public void removeWithoutClaimingNextOrPrevious(){
        iter.remove();
    }

    /**
     * <b>-Tests</b> the proper functioning of set() method.<br>
     * <b>-Description:</b> Iterate the iterator on a non-empty list, use the next method and replace an element. then use previous and replace the element. the presence and location of the items in the list occur during all operations.<br>
     * <b>-Pre-condition:</b> ListAdapter properly initialized list1 .<br>
     * HListIterator object iter initialized on list<br>
     * <b>-Post-condition:</b> the list change after set is claimed.<br>
     * <b>-Expected result:</b> set substitute the right element claimed by next or previous.<br>
     */
    @Test
    public void set(){
        list.add("a");
        list.add("b");
        list.add("c");
        assertTrue(list.size() == 3);
        assertTrue(iter.hasNext());
        assertEquals("a",iter.next());
        assertEquals("b",iter.next());
        iter.set("z");
        assertTrue(iter.hasPrevious());
        assertEquals("z",iter.previous());
        assertEquals("a",iter.previous());
        iter.set("x");
        assertTrue(iter.hasNext());
        assertEquals("x",iter.next());
        assertEquals("z",iter.next());
        assertEquals("c",iter.next());
    }

    /**
     * <b>-Tests</b> the wrong functioning of set() method.<br>
     * <b>-Description:</b> was called set without calling next or previous.<br>
     * <b>-Pre-condition:</b> ListAdapter properly initialized list1 .<br>
     * HListIterator object iter initialized on list<br>
     * <b>-Post-condition:</b> the exception is passed to the calling method , if this is not handled then the program ends.<br>
     * <b>-Expected result:</b> IllegalArgumentException thrown.<br>
     */
    @Test (expected = IllegalStateException.class)
    public void setWithoutClaimingNextOrPrevious(){
        iter.set(1);
    }

    /**
     * <b>-Tests</b> the wrong functioning of set() method.<br>
     * <b>-Description:</b> was called set after calling add.<br>
     * <b>-Pre-condition:</b> ListAdapter properly initialized list1 .<br>
     * HListIterator object iter initialized on list<br>
     * <b>-Post-condition:</b> the exception is passed to the calling method , if this is not handled then the program ends.<br>
     * <b>-Expected result:</b> IllegalArgumentException thrown.<br>
     */
    @Test (expected = IllegalStateException.class)
    public void setAfterAdd(){
        iter.add("a");
        iter.set("s");
    }

    /**
     * <b>-Tests</b> the wrong functioning of set() method.<br>
     * <b>-Description:</b> was called set after calling remove.<br>
     * <b>-Pre-condition:</b> ListAdapter properly initialized list1 .<br>
     * HListIterator object iter initialized on list<br>
     * <b>-Post-condition:</b> the exception is passed to the calling method , if this is not handled then the program ends.<br>
     * <b>-Expected result:</b> IllegalArgumentException thrown.<br>
     */
    @Test (expected = IllegalStateException.class)
    public void setAfterRemove() {
        iter.add("a");
        iter.add("b");
        assertTrue(iter.hasNext());
        assertEquals("b",iter.next());
        assertEquals("a",iter.next());
        assertTrue(iter.hasPrevious());
        assertEquals("a",iter.previous());
        iter.remove();
        iter.set("x");
    }
}
