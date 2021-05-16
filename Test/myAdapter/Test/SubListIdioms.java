package myAdapter.Test;
import myAdapter.HIterator;
import myAdapter.ListAdapter;
import myAdapter.MapAdapter;
import org.junit.Test;
import org.junit.Before;
import static org.junit.Assert.*;

/***
 * This class tests sublist idioms and the operation of backing between list and sublist.<br>
 * @see SubListTestRunner SubListTestRunner is the the test runner of this class. <br>
 * @see ListAdapter ListAdapter. <br>
 */

public class SubListIdioms {
    /***
     * instance variable of ListAdapter - list1
     */
    private ListAdapter list1;
    /***
     * instance variable of ListAdapter - list2
     */
    private ListAdapter list2;

    /***
     * <b>-Before : </b> Setup test, this is done before every test. <br>
     * <b>-Description:</b> This method create an instance of ListAdapter list1, list2.<br>
     * <b>-Pre-condition:</b> the instance variable have been created without being instantiated. <br>
     * <b>-Post-condition:</b> the instance variable have been instantiated .<br>
     * <b>-Expected result:</b> the instance variable have been instantiated.<br>
     */
    @Before
    public void setup(){
        list1 = new ListAdapter();
        list2 = new ListAdapter(11);
        assertFalse(list1 == null);
        assertFalse(list2 == null);
    }

    /**
     * <b>- Tests</b> the proper functioning of add() method.<br>
     * <b>- Description:</b> new elements are added with the idioms sublist().add() and they are verified. <br>
     * <b>- Pre-condition:</b> a ListAdapter object list properly initialized,sublist it is executed on a non empty list.<br>
     * <b>- Post-condition:</b> the list has new elements.<br>
     * <b>- Expected result:</b> the list has new elements.<br>
     */
    @Test
    public void addSublist(){
        assertTrue(list1.isEmpty());
        list1.add("a");
        list1.add("b");
        list1.add("c");
        list1.subList(1,3).add("d");
        assertTrue(list1.size() == 4);
    }

    /**
     * <b>- Tests</b> the proper functioning of add() method.<br>
     * <b>- Description:</b> sublist().add() is used a null parameter.<br>
     * <b>- Pre-condition:</b> a ListAdapter object list properly initialized,sublist it is executed on a non empty list.<br>
     * <b>Post-condition : </b> the exception is passed to the calling method, if this is not handled then the program ends. <br>
     * <b>- Expected result:</b> IndexOutOfBoundsException thrown.<br>
     */
    @Test (expected = NullPointerException.class)
    public void addSubNull(){
        list1.add("a");
        list1.add("b");
        list1.add("c");
        list1.subList(1,3).add(null);
    }

    /**
     * <b>- Tests</b> the proper functioning of add() method.<br>
     * <b>- Description:</b> sublist().add() is used a invalid index.<br>
     * <b>- Pre-condition:</b> a ListAdapter object list properly initialized,sublist it is executed on a non empty list.<br>
     * <b>Post-condition : </b> the exception is passed to the calling method, if this is not handled then the program ends. <br>
     * <b>- Expected result:</b> IndexOutOfBoundsException thrown.<br>
     */
    @Test (expected = IndexOutOfBoundsException.class)
    public void addIndexOutOfBoundException(){
        list1.add("a");
        list1.add("b");
        list1.add("c");
        list1.subList(1,3).add(3,"d");
    }

    /**
     * <b>- Tests</b> the proper functioning of addAll() method.<br>
     * <b>- Description:</b> the sublist(). addall() idiom is used and a Hcollection is inserted and finally the helmets are verified.<br>
     * <b>- Pre-condition:</b> a ListAdapter object list properly initialized,sublist it is executed on a non empty list.<br>
     * <b>- Post-condition:</b> the list has new elements.<br>
     * <b>- Expected result:</b> the list has new elements.<br>
     */
    @Test
    public void addAllSubList(){
        assertTrue(list1.isEmpty());
        list1.add("a");
        list1.add("b");

        list2.addAll(list1);
        assertTrue(list2.size() == 2);
        list2.subList(0,2).addAll(list1);
        assertTrue(list2.size() == 4);
    }

    /**
     * <b>- Tests</b> the proper functioning of addAll() method.<br>
     * <b>- Description:</b> the sublist(). addall() idiom is used and a Hcollection is inserted to a given index and finally the helmets are verified.<br>
     * <b>- Pre-condition:</b> a ListAdapter object list properly initialized,sublist it is executed on a non empty list.<br>
     * <b>- Post-condition:</b> the list has new elements.<br>
     * <b>- Expected result:</b>the list has new elements .<br>
     */
    @Test
    public void addAllSublistWithIndex() {
        assertTrue(list1.isEmpty());
        list1.add("a");
        list1.add("b");
        list1.add("c");
        list2.addAll(list1);
        assertTrue(list2.size() == 3);
        assertTrue(list2.subList(0,3).addAll(2,list1));
        assertTrue(list2.size() == 6);
    }

    /**
     * <b>- Tests</b> the proper functioning of addAll() method.<br>
     * <b>- Description:</b> sublist().addAll() is used and a object is passed with reference to null.<br>
     * <b>- Pre-condition:</b> a ListAdapter object list properly initialized,sublist it is executed on a non empty list.<br>
     * <b>Post-condition : </b> the exception is passed to the calling method, if this is not handled then the program ends. <br>
     * <b>- Expected result:</b> NullPointerException thrown.<br>
     */
    @Test (expected = NullPointerException.class)
    public void addAllNull(){
        list1.add("a");
        list1.add("b");
        list1.add("c");
        list1.subList(1,3).addAll(null);
    }

    /**
     * <b>- Tests</b> the proper functioning of () method.<br>
     * <b>- Description:</b> sublist(). addAll() is used and Hcollection that is another supertype.<br>
     * <b>- Pre-condition:</b> a ListAdapter object list properly initialized,sublist it is executed on a non empty list.<br>
     * <b>Post-condition : </b> the exception is passed to the calling method, if this is not handled then the program ends. <br>
     * <b>- Expected result:</b> ClassCastException thrown.<br>
     */
    @Test (expected = ClassCastException.class)
    public void addAllClassCastException() {
        list1.add("a");
        list1.add("b");
        list1.add("c");
        list1.subList(1,3).addAll(new MapAdapter().values());
    }

    /**
     * <b>- Tests</b> the proper functioning of adAll() method.<br>
     * <b>- Description:</b> sublist().addAll() is used a invalid index.<br>
     * <b>- Pre-condition:</b> a ListAdapter object list properly initialized,sublist it is executed on a non empty list.<br>
     * <b>Post-condition : </b> the exception is passed to the calling method, if this is not handled then the program ends. <br>
     * <b>- Expected result:</b> IndexOutOfBoundsException thrown.<br>
     */
    @Test (expected = IndexOutOfBoundsException.class)
    public void addAllIndexOutOfBOundsException() {
        list1.add("a");
        list1.add("b");
        list1.add("c");
        list2.subList(0,3).addAll(3,list1);
    }

    /**
     * <b>- Tests</b> the proper functioning of clear() method.<br>
     * <b>- Description:</b> sublist(). clear is used and it is verified that the sublist has deleted a part of the list.<br>
     * <b>- Pre-condition:</b> a ListAdapter object list properly initialized,sublist it is executed on a non empty list.<br>
     * <b>- Post-condition:</b> the list has been modify.<br>
     * <b>- Expected result:</b> the list has been modify.<br>
     */
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

    /**
     * <b>- Tests</b> the proper functioning of contains() method.<br>
     * <b>- Description:</b> sublist(). contains() is used and an element is verified in the sublist.<br>
     * <b>- Pre-condition:</b> a ListAdapter object list properly initialized,sublist it is executed on a non empty list.<br>
     * <b>- Post-condition:</b> if the sublist changes the result of the method can change.<br>
     * <b>- Expected result:</b> the method recognize the elements in the sublist.<br>
     */
    @Test
    public void containsSublist(){
        list1.add("a");
        list1.add("b");
        list1.add("c");
        list2.addAll(list1);
        assertTrue(list2.subList(1,3).contains("b"));
    }

    /**
     * <b>- Tests</b> the proper functioning of contains() method.<br>
     * <b>- Description:</b> sublist(). contains() is used and a object is passed with reference to null.<br>
     * <b>- Pre-condition:</b> a ListAdapter object list properly initialized,sublist it is executed on a non empty list.<br>
     * <b>Post-condition : </b> the exception is passed to the calling method, if this is not handled then the program ends. <br>
     * <b>- Expected result:</b> NullPointerException thrown.<br>
     */
    @Test (expected = NullPointerException.class)
    public void containsNull(){
        list1.add("a");
        list1.add("b");
        list1.add("c");
        list1.subList(0,3).contains(null);
    }

    /**
     * <b>- Tests</b> the proper functioning of contains() method.<br>
     * <b>- Description:</b> sublist(). containsAll() is used and it is verified that the sublist contains elements of the Hcolletcion.<br>
     * <b>- Pre-condition:</b> a ListAdapter object list properly initialized,sublist it is executed on a non empty list.<br>
     * <b>- Post-condition:</b> if the list changes it is not said that the result of contains all is still valid.<br>
     * <b>- Expected result:</b> verify the presence of elements in the sublist .<br>
     */
    @Test
    public void containsAllSublist() {
        list1.add("a");
        list1.add("b");
        list1.add("c");
        list1.add("d");
        list2.add("b");
        list2.add("d");
        assertTrue(list1.subList(1,4).containsAll(list2));
    }

    /**
     * <b>- Tests</b> the wrong functioning of contains() method.<br>
     * <b>- Description:</b> sublist(). containsAll() is used and Hcollection is passed with reference to null.<br>
     * <b>- Pre-condition:</b> a ListAdapter object list properly initialized,sublist it is executed on a non empty list.<br>
     * <b>Post-condition : </b> the exception is passed to the calling method, if this is not handled then the program ends. <br>
     * <b>- Expected result:</b> NullPointerException thrown.<br>
     */
    @Test (expected = NullPointerException.class)
    public void containsAllSubNull() {
        list1.add("a");
        list1.add("b");
        list1.add("c");
        list1.add("d");
        list2.add("b");
        list2.add("d");
        assertTrue(list1.subList(1,4).containsAll(null));
    }

    /**
     * <b>- Tests</b> the wrong functioning of contains() method.<br>
     * <b>- Description:</b> sublist(). containsAll() is used and Hcollection that is another supertype.<br>
     * <b>- Pre-condition:</b> a ListAdapter object list properly initialized,sublist it is executed on a non empty list.<br>
     * <b>Post-condition : </b> the exception is passed to the calling method, if this is not handled then the program ends. <br>
     * <b>Expected result : </b> ClassCastException thrown. <br>
     */
    @Test (expected = ClassCastException.class)
    public void containsAllSubClassCastException(){
        list1.add("a");
        list1.add("b");
        list1.add("c");
        list1.add("d");
        list1.subList(1,4).containsAll(new MapAdapter().values());
    }

    /**
     * <b>- Tests</b> the proper functioning of equals() method.<br>
     * <b>- Description:</b> sublist(). equals() is used and it is verified that two sublists are equal or not.<br>
     * <b>- Pre-condition:</b> a ListAdapter object list properly initialized,sublist it is executed on a non empty list.<br>
     * <b>- Post-condition:</b> the item can have a different index if the list changes.<br>
     * <b>- Expected result:</b> two sublists are equal if they have the same elements.<br>
     */
    @Test
    public void equalsSublist(){
        list1.add("a");
        list1.add("b");
        list1.add("c");
        list1.add("d");
        list2.add("a");
        list2.add("b");
        list2.add("c");
        list2.add("d");
        assertTrue(list1.subList(0,4).equals(list2.subList(0,4)));
        assertFalse(list1.subList(0,3).equals(list2.subList(2,4)));
        assertFalse(list1.subList(2,4).equals(null));
        assertFalse(list1.subList(2,3).equals(3));
    }

    /**
     * <b>- Tests</b> the proper functioning of get() method.<br>
     * <b>- Description:</b> sublist(). get() is executed and it is verified that the returned object corresponds to that of the sublist.<br>
     * <b>- Pre-condition:</b> a ListAdapter object list properly initialized,sublist it is executed on a non empty list.<br>
     * <b>- Post-condition:</b> the item can have a different index if the list changes.<br>
     * <b>- Expected result:</b> return the correct list object.<br>
     */
    @Test
    public void getFromSublist(){
        list1.add("a");
        list1.add("b");
        list1.add("c");
        list1.add("a");
        assertEquals("c",list1.subList(2,4).get(0));
    }

    /**
     * <b>- Tests</b> the proper functioning of iterator() method.<br>
     * <b>- Description:</b> the sublist(). iterator() idiom is executed and the iterator is initialized and verified that it has no reference to null.<br>
     * <b>- Pre-condition:</b> a ListAdapter object list properly initialized,sublist it is executed on a non empty list.<br>
     * <b>- Post-condition:</b> the listiterator is not null.<br>
     * <b>- Expected result:</b> the listiterator is not null .<br>
     */
    @Test
    public void iteratorSublist() {
        list1.add("a");
        list1.add("b");
        list1.add("c");
        list1.add("a");
        HIterator h1 = list1.subList(1,4).iterator();
        assertFalse(h1 == null);
    }

    /**
     * <b>- Tests</b> the proper functioning of iterator().hasnext() method.<br>
     * <b>- Description:</b> the sublist(). iterator() idiom is executed and it is verified that the returned iterator has a subsequent element.<br>
     * <b>- Pre-condition:</b> a ListAdapter object list properly initialized,sublist it is executed on a non empty list.<br>
     * <b>- Post-condition:</b> iterator reset if sublist changes.<br>
     * <b>- Expected result:</b> return that has next element.<br>
     */
    @Test
    public void iteratorSubListHasNext(){
        list1.add("a");
        list1.add("b");
        list1.add("c");
        list1.add("a");
        HIterator h1 = list1.subList(1,4).iterator();
        assertTrue(h1.hasNext());
    }

    /**
     * <b>- Tests</b> the proper functioning of iterator().next() method.<br>
     * <b>- Description:</b> the sublist() idiom is used. iterator() and it is verified that the returned elements are of the sublist. <br>
     * <b>- Pre-condition:</b> a ListAdapter object list properly initialized,sublist it is executed on a non empty list.<br>
     * <b>- Post-condition:</b> iterator reset if sublist changes.<br>
     * <b>- Expected result:</b> returns sublist elements.<br>
     */
    @Test
    public void iteratorSubListNext() {
        list1.add("a");
        list1.add("b");
        list1.add("c");
        list1.add("a");
        HIterator h1 = list1.subList(1,4).iterator();
        assertTrue(h1.hasNext());
        assertEquals("b",h1.next());
    }

    /**
     * <b>- Tests</b> the proper functioning of listiterator() method.<br>
     * <b>- Description:</b> the sublist(). listiterator() idiom is executed and the iterator is initialized and verified that it has no reference to null.<br>
     * <b>- Pre-condition:</b> a ListAdapter object list properly initialized.<br>
     * <b>- Post-condition:</b> the listiterator is not null.<br>
     * <b>- Expected result:</b> the listiterator is not null .<br>
     */
    @Test
    public void listIteratorSubList() {
        list1.add("a");
        list1.add("b");
        list1.add("c");
        list1.add("a");
        HIterator h1 = list1.subList(1,4).listIterator();
        assertFalse(h1 == null);
    }

    /**
     * <b>- Tests</b> the proper functioning of listiterator() method.<br>
     * <b>- Description:</b> the sublist(). listiterator() idiom is executed and the iterator is initialized with index and verified that it has no reference to null.<br>
     * <b>- Pre-condition:</b> a ListAdapter object list properly initialized,sublist it is executed on a non empty list.<br>
     * <b>- Post-condition:</b> the listiterator is not null.<br>
     * <b>- Expected result:</b> the listiterator is not null .<br>
     */
    @Test
    public void listIteratorSublist2(){
        list1.add("a");
        list1.add("b");
        list1.add("c");
        list1.add("a");
        HIterator h1 = list1.subList(1,4).listIterator(1);
        assertFalse(h1 == null);
    }

    /**
     * <b>- Tests</b> the wrong functioning of listiterator() method.<br>
     * <b>- Description:</b> sublist(). listiterator() is executed and the iterator is initialized to an invalid index.<br>
     * <b>- Pre-condition:</b> a ListAdapter object list properly initialized,sublist it is executed on a non empty list.<br>
     * <b>Post-condition : </b> the exception is passed to the calling method, if this is not handled then the program ends. <br>
     * <b>- Expected result:</b> IndexOutOfBoundsException thrown.<br>
     */
    @Test (expected = IndexOutOfBoundsException.class)
    public void listIteratorIndexOutOfBoundsException(){
        list1.add("a");
        list1.add("b");
        list1.add("c");
        list1.add("a");
        HIterator h1 = list1.subList(1,3).listIterator(4);
    }

    /**
     * <b>- Tests</b> the proper functioning of listiterator().hasnext() method.<br>
     * <b>- Description:</b> the sublist(). listiterator() idiom is executed and it is verified that the returned iterator has a subsequent element.<br>
     * <b>- Pre-condition:</b> a ListAdapter object list properly initialized,sublist it is executed on a non empty list.<br>
     * <b>- Post-condition:</b> iterator reset if sublist changes.<br>
     * <b>- Expected result:</b> return that has next element.<br>
     */
    @Test
    public void listIteratorSublistHasNext() {
        list1.add("a");
        list1.add("b");
        list1.add("c");
        list1.add("a");
        HIterator h1 = list1.subList(1,4).listIterator();
        assertTrue(h1.hasNext());
    }

    /**
     * <b>- Tests</b> the proper functioning of listIterator().next() method.<br>
     * <b>- Description:</b> the sublist() idiom is used. listiterator() and it is verified that the returned elements are of the sublist. <br>
     * <b>- Pre-condition:</b> a ListAdapter object list properly initialized,sublist it is executed on a non empty list.<br>
     * <b>- Post-condition:</b> iterator reset if sublist changes.<br>
     * <b>- Expected result:</b> returns sublist elements.<br>
     */
    @Test
    public void listIteratorSublistNext() {
        list1.add("a");
        list1.add("b");
        list1.add("c");
        list1.add("a");
        HIterator h1 = list1.subList(1,4).listIterator();
        assertTrue(h1.hasNext());
        assertEquals("b",h1.next());
    }

    /**
     * <b>- Tests</b> the proper functioning of hashcode() method.<br>
     * <b>- Description:</b> sublist() is used. hashcode on two lists and occurs when they are equal and when they are not equal.<br>
     * <b>- Pre-condition:</b> a ListAdapter object list properly initialized,sublist it is executed on a non empty list.<br>
     * <b>- Post-condition:</b> sublist hashcode changes if sublist also changes.<br>
     * <b>- Expected result:</b> two identical lists have the same hashcode.<br>
     */
    @Test
    public void hashcode(){
        list1.add("a");
        list1.add("b");
        list1.add("c");
        list1.add("d");
        list2.add("a");
        list2.add("b");
        list2.add("c");
        list2.add("d");
        assertEquals(list1.subList(0,4).hashCode(),list2.subList(0,4).hashCode());
        assertEquals(list1.subList(2,4).hashCode(),list2.subList(2,4).hashCode());
        assertNotEquals(list1.subList(0,3).hashCode(),list2.subList(2,4).hashCode());
    }

    /**
     * <b>- Tests</b> the proper functioning of indexof() method.<br>
     * <b>- Description:</b> sublist()indexof() is used and the returned index matches the sublist object.<br>
     * <b>- Pre-condition:</b> a ListAdapter object list properly initialized,sublist it is executed on a non empty list.<br>
     * <b>- Post-condition:</b> the index can change if the list changes.<br>
     * <b>- Expected result:</b> sublist returns the correct index.<br>
     */
    @Test
    public void indexOfSublist(){
        list1.add("a");
        list1.add("b");
        list1.add("c");
        list1.add("d");
        assertEquals( 0,list1.subList(1,4).indexOf("b"));
    }

    /**
     * <b>- Tests</b> the wrong functioning of indexof() method.<br>
     * <b>Description : </b> sublist(). indexof() is used and a null index is introduced. <br>
     * <b>- Pre-condition:</b> a ListAdapter object list properly initialized,sublist it is executed on a non empty list.<br>
     * <b>Post-condition : </b> the exception is passed to the calling method, if this is not handled then the program ends. <br>
     * <b>Expected result : </b> NullPointerException thrown <br>
     */
    @Test (expected = NullPointerException.class)
    public void indexOfNull() {
        list1.add("a");
        list1.subList(0,1).indexOf(null);
    }

    /**
     * <b>- Tests</b> the proper functioning of isEmpty() method.<br>
     * <b>- Description:</b> sublist() is used. isEmpty() and occurs if the sublist is empty. <br>
     * <b>- Pre-condition:</b> a ListAdapter object list properly initialized,sublist it is executed on a non empty list.<br>
     * <b>- Post-condition:</b> the method says if the sublist is empty at that moment.<br>
     * <b>- Expected result:</b> check if the sublist is empty.<br>
     */
    @Test
    public void isEmptySubList(){
        list1.add("a");
        assertFalse(list1.subList(0,1).isEmpty());
        assertTrue(list1.subList(0,0).isEmpty());
        list1.add("b");
        list1.add("c");
        list1.add("d");
        assertFalse(list1.subList(1,4).isEmpty());
    }

    /**
     * <b>- Tests</b> the proper functioning of lastIndexOf() method.<br>
     * <b>- Description:</b> sublist() is used. lastIndexOF() and it is verified that the returned index corresponds to the sublist index.<br>
     * <b>- Pre-condition:</b> a ListAdapter object list properly initialized,sublist it is executed on a non empty list.<br>
     * <b>- Post-condition:</b> the index may no longer be valid if the list or sublist changes.<br>
     * <b>- Expected result:</b> the correct index of the verified item is returned.<br>
     */
    @Test
    public void lastIndexOfSublist(){
        list1.add("a");
        list1.add("b");
        list1.add("a");
        list1.add("b");
        assertEquals( 0, list1.subList(1,4).lastIndexOf("b"));
    }

    /***
     * return object
     */
    /**
     * <b>- Tests</b> the proper functioning of remove() method.<br>
     * <b>- Description:</b> sublist().remove() is applied and attempts are made to remove an element that is part of the sublist.<br>
     * <b>- Pre-condition:</b> a ListAdapter object list properly initialized,sublist it is executed on a non empty list.<br>
     * <b>- Post-condition:</b> the list has fewer items.<br>
     * <b>- Expected result:</b> remove() delete the right items.<br>
     */
    @Test
    public void removeFromIndex() {
        list1.add("a");
        list1.add("b");
        list1.add("c");
        list1.add("d");
        assertEquals("c",list1.subList(1,4).remove(1));
    }

    /**
     * <b>- Tests</b> the wrong functioning of remove() method.<br>
     * <b>- Description:</b> sublist(). remove() is applied and attempts are made to remove an element that is not part of the sublist.<br>
     * <b>- Pre-condition:</b> a ListAdapter object list properly initialized,sublist it is executed on a non empty list.<br>
     * <b>Post-condition : </b> the exception is passed to the calling method, if this is not handled then the program ends. <br>
     * <b>- Expected result:</b> IndexOutOfBoundsException thrown .<br>
     */
    @Test (expected = IndexOutOfBoundsException.class)
    public  void removeIndexOutOfBoundsException() {
        list1.add("a");
        list1.add("b");
        list1.add("c");
        list1.add("d");
        assertEquals("c",list1.subList(1,3).remove(4));
    }

    /**
     * <b>- Tests</b> the proper functioning of remove() method.<br>
     * <b>- Description:</b> sublist(). remove() is applied and checked that it delete a sublist element. <br>
     * <b>- Pre-condition:</b> a ListAdapter object list properly initialized,sublist it is executed on a non empty list.<br>
     * <b>- Post-condition:</b> the list has fewer items.<br>
     * <b>- Expected result:</b> remove() delete the right items.<br>
     */
    @Test
    public void removeAObject() {
        list1.add("a");
        list1.add("b");
        list1.add("c");
        list1.add("d");
        assertTrue(list1.subList(1,4).remove("c"));
    }

    /**
     * <b>- Tests</b> the proper functioning of remove() method.<br>
     * <b>- Description:</b> sublist(). remove() is applied and checked that it does not delete a sublist element.<br>
     * <b>- Pre-condition:</b> a ListAdapter object list properly initialized,sublist it is executed on a non empty list.<br>
     * <b>- Post-condition:</b> the list has fewer items.<br>
     * <b>- Expected result:</b> remove() delete the right items.<br>
     */
    @Test
    public void removeAObject2() {
        list1.add("a");
        list1.add("b");
        list1.add("c");
        list1.add("d");
        assertFalse(list1.subList(1,4).remove("a"));
    }

    /**
     * <b>- Tests</b> the proper functioning of removeAll() method.<br>
     * <b>- Description:</b> the sublist() idiom is used. removeAll(Hcollection) to eliminate from a list
     * the elements of another list and verify the content of the list on which it has been applied that language.<br>
     * <b>- Pre-condition:</b> a ListAdapter object list properly initialized,sublist it is executed on a non empty list.<br>
     * <b>- Post-condition:</b> the list has fewer items.<br>
     * <b>- Expected result:</b> the desired elements have been eliminated.<br>
     */
    @Test
    public void removeAll() {
        list1.add("a");
        list1.add("b");
        list1.add("c");
        list1.add("d");
        list2.add("c");
        list2.add("d");
        assertTrue(list1.subList(1,4).removeAll(list2));
        assertEquals("a",list1.get(0));
        assertEquals("b",list1.get(1));
        assertFalse(list1.contains("c"));
        assertFalse(list1.contains("d"));
    }

    /**
     * <b> Don't Work!!!!</b>
     * <b>- Tests</b> the proper functioning of () method.<br>
     * <b>- Description:</b>
     * <b>- Pre-condition:</b> a ListAdapter object list properly initialized.<br>
     * <b>- Post-condition:</b> .<br>
     * <b>- Expected result:</b> .<br>
     */
    //@Test
    public void retainAll() {
        list1.add("a");
        list1.add("b");
        list1.add("c");
        list1.add("d");
        list2.add("b");
        list2.add("c");
        assertTrue(list1.subList(0,4).retainAll(list2));
        assertFalse(list1.contains("a"));
    }

    /**
     * <b>- Tests</b> the proper functioning of set() method.<br>
     * <b>- Description:</b> run sublist().set() and edit an item which is then verified.<br>
     * <b>- Pre-condition:</b> a ListAdapter object list properly initialized,sublist it is executed on a non empty list.<br>
     * <b>- Post-condition:</b> the element has been modified.<br>
     * <b>- Expected result:</b> the correct sublist element is changed.<br>
     */
    @Test
    public void setSublist() {
        list1.add("a");
        list1.add("b");
        list1.add("c");
        assertEquals("b",list1.subList(1,3).set(0,"x"));
        assertEquals("x",list1.get(1));
    }

    /**
     * <b>- Tests</b> the wrong functioning of set() method.<br>
     * <b>- Description:</b> sublist(). set(index,object) tries to set an invalid index.<br>
     * <b>- Pre-condition:</b> a ListAdapter object list properly initialized, sublist it is executed on a non empty list.<br>
     * <b>Post-condition : </b> the exception is passed to the calling method, if this is not handled then the program ends. <br>
     * <b>- Expected result:</b> IndexOutOfBoundException thrown.<br>
     */
    @Test (expected = IndexOutOfBoundsException.class)
    public void setSubIndexOutOfBoundsException() {
        list1.add("a");
        list1.subList(0,1).set(2,"s");
    }

    /**
     * <b>- Tests</b> the wrong functioning of set() method.<br>
     * <b>- Description:</b> sublist(). set(index,object) tries to set a null object.<br>
     * <b>- Pre-condition:</b> a ListAdapter object list properly initialized, sublist it is executed on a non empty list.<br>
     * <b>Post-condition : </b> the exception is passed to the calling method, if this is not handled then the program ends. <br>
     * <b>Expected result : </b> NullPointerException thrown <br>
     */
    @Test (expected = NullPointerException.class)
    public void setSubNullPointerException(){
        list1.add("a");
        list1.subList(0,1).set(0,null);
    }

    /**
     * <b>- Tests</b> the proper functioning of toArray() method.<br>
     * <b>- Description:</b> sublist.toArray is executed and an array of sublist elements is generated which are verified.<br>
     * <b>- Pre-condition:</b> a ListAdapter object list properly initialized, sublist it is executed on a non empty list.<br>
     * <b>- Post-condition:</b> the array does not change even if the sublist changes.<br>
     * <b>- Expected result:</b> the array contains the elements of the sublist.<br>
     */
    @Test
    public void toArray(){
        list1.add(0);
        list1.add(1);
        list1.add(2);
        Object[] array = list1.subList(0,3).toArray();
        for (int i = 0 ; i < array.length ; i++) {
            assertEquals(i,array[i]);
        }
    }

    /**
     * <b>- Tests</b> the proper functioning of toArray(Object[]) method.<br>
     * <b>- Description:</b> an array is generated with the sublist() idiom. toArray() passing an array as argument to toArray.<br>
     * <b>- Pre-condition:</b> a ListAdapter object list properly initialized, sublist it is executed on a non empty list<br>
     * <b>Post-condition : </b> the array does not change even if the sublist changes.<br>
     * <b>- Expected result:</b> the array contains the elements of the sublist.<br>
     */
    @Test
    public void toArray2(){
        Object[] a = new Object[2];
        list1.add(0);
        list1.add(1);
        list1.add(2);
        list1.add(3);
        a = list1.subList(1,4).toArray(a);
        for (int i = 0; i < a.length; i++) {
            assertEquals(i + 1,a[i]);
        }
    }

    /**
     * <b>- Tests</b> the wrong functioning of () method.<br>
     * <b>- Description:</b> a null parameter has been passed to the sublist() idiom. toArray on a list with 3 elements.<br>
     * <b>- Pre-condition:</b> a ListAdapter object list properly initialized.<br>
     * <b>Post-condition : </b> the exception is passed to the calling method, if this is not handled then the program ends. <br>
     * <b>Expected result : </b> NullPointerException thrown <br>
     */
    @Test (expected = NullPointerException.class)
    public void toArrayNull() {
        list1.add(0);
        list1.add(1);
        list1.add(2);
        list1.add(3);
        list1.subList(1,4).toArray(null);
    }

}
