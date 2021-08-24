import static org.junit.Assert.assertArrayEquals;
import static org.junit.Assert.assertEquals;

import org.junit.Test;

public class ArrayStuffTest {

    @Test
    public void test1() {
        Integer[] actual = new Integer[] { 18, 29, 12, 7, 25, -2 };
        Integer val = ArrayStuff.remove(actual, 2);
        Integer[] expected = new Integer[] { 18, 29, 7, 25, -2, null };
        assertArrayEquals("Incorrect result", expected, actual);
        assertEquals(new Integer(12), val);
    }

    @Test
    public void test2() {
        Integer[] actual = new Integer[] { 4, 32, 5, 9 };
        Integer val = ArrayStuff.remove(actual, 1);
        Integer[] expected = new Integer[] { 4, 5, 9, null };
        assertArrayEquals("Incorrect result", expected, actual);
        assertEquals(new Integer(32), val);
    }

    @Test
    public void test3() {
        Integer[] actual = new Integer[] { 9, 1, 6, 9, 2, 4 };
        Integer val = ArrayStuff.remove(actual, 0);
        Integer[] expected = new Integer[] { 1, 6, 9, 2, 4, null };
        assertArrayEquals("Incorrect result", expected, actual);
        assertEquals(new Integer(9), val);
    }

    @Test
    public void test4() {
        Integer[] actual = new Integer[] { 8, 11, 3 };
        Integer val = ArrayStuff.remove(actual, 1);
        Integer[] expected = new Integer[] { 8, 3, null };
        assertArrayEquals("Incorrect result", expected, actual);
        assertEquals(new Integer(11), val);
    }

    @Test
    public void test5() {
        Integer[] actual = new Integer[] { -1 };
        Integer val = ArrayStuff.remove(actual, 0);
        Integer[] expected = new Integer[] { null };
        assertArrayEquals("Incorrect result", expected, actual);
        assertEquals(new Integer(-1), val);
    }
}
