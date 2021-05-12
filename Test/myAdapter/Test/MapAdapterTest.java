package myAdapter.Test;

import myAdapter.HIterator;
import myAdapter.HListIterator;
import myAdapter.MapAdapter;
import org.junit.Test;
import org.junit.Before;
import static org.junit.Assert.*;

/***
 * Testing MapAdapter
 */
public class MapAdapterTest {
    private MapAdapter map1;
    private MapAdapter map2;

    /***
     * This method create an instance of MapAdapter with a default capacity
     * and another MapAdapter with an initial
     */
    @Before
    public void setup() {
        map1 = new MapAdapter();
        map2 = new MapAdapter(12);
    }

    /***
     * This method tests the right initialization of MapAdapter
     */
    @Test
    public void testMapAdapterInit() {
        assertTrue(map1.isEmpty());
        assertTrue(map1.size() == 0);

        assertTrue(map2.isEmpty());
        assertTrue(map2.size() == 0);
    }

    /***
     * This method tests the wrong initialization of MapAdapter
     */
    @Test (expected = IndexOutOfBoundsException.class)
    public void testInvalidCapacity() {
        map1 = new MapAdapter( - 1);
    }
}
