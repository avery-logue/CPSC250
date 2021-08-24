import static org.junit.Assert.assertArrayEquals;
import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotNull;
import static org.junit.Assert.assertNotSame;
import static org.junit.Assert.assertNull;
import static org.junit.Assert.assertTrue;

import java.lang.reflect.Field;
import java.lang.reflect.Modifier;

import org.junit.Test;

public class Array2DTest {

    private class Array2DTester extends Array2D {

        private Array2DTester() {
            super();
        }

        private Array2DTester(int[][] inp) {
            super(inp);
        }

    }

    @Test
    public void testField() {
        Field[] allFields = Array2D.class.getDeclaredFields();
        assertEquals("Array2D should only have 1 field.", 1, allFields.length);
        assertTrue("Array2D instance variable should be protected",
                Modifier.isProtected(allFields[0].getModifiers()));

        // force failure without minimal effort
        Array2DTester test = new Array2DTester(); // use Array2DTest to get
        assertNotNull(test);
        assertNotNull(test.array);

    }

    @Test
    public void testConstructor() {
        Array2DTester test = new Array2DTester(); // use Array2DTest to get
                                                  // access to internal
                                                  // variables
        assertNotNull(test);
        assertNotNull(test.array);
    }

    @Test
    public void testConstructorSize() {
        Array2DTester test = new Array2DTester(); // use Array2DTest to get
                                                  // access to internal
                                                  // variables
        assertNotNull(test);
        assertNotNull(test.array);
        assertEquals("5 rows specified", 5, test.array.length);
        assertEquals("6 columns specified", 6, test.array[0].length);
    }

    @Test
    public void testConstructor1ArgA() {
        Array2DTester test = new Array2DTester(
                new int[][] { { 1, 2 }, { 3, 4 } });
        assertNotNull(test);
        assertNotNull(test.array);
    }

    @Test
    public void testConstructor1ArgB() {
        Array2DTester test = new Array2DTester(
                new int[][] { { 1, 2, 3, 4, 5, 6, 7, 8 },
                        { 11, 12, 13, 14, 15, 16, 17, 18 } });
        assertNotNull(test);
        assertNotNull(test.array);
    }

    @Test
    public void testConstructor1ArgNull() {
        Array2DTester test = new Array2DTester(null);
        assertNotNull(test);
        assertNull(test.array);

        // force failure without minimal effort
        test = new Array2DTester(); // use Array2DTest to get
        assertNotNull(test);
        assertNotNull(test.array);
    }

    @Test
    public void testConstructor1ArgValues() {
        int[][] expected = new int[][] { { 1, 2 }, { 3, 4 } };
        Array2DTester test = new Array2DTester(expected);

        assertNotNull(test);
        assertNotNull(test.array);
        assertNotSame(expected, test.array);
        assertArrayEquals(expected, test.array);
    }

    @Test
    public void testConstructor1ArgValuesB() {
        int[][] expected = new int[][] { { 1, 2, 3, 4, 5, 6, 7, 8 },
                { 11, 12, 13, 14, 15, 16, 17, 18 } };

        Array2DTester test = new Array2DTester(expected);

        assertNotNull(test);
        assertNotNull(test.array);
        assertNotSame(expected, test.array);
        assertArrayEquals(expected, test.array);
    }

    @Test
    public void testGetA() {

        Array2DTester test = new Array2DTester();
        // set the field variable directly for test
        test.array = new int[][] { { 1, 2, 3 }, { 4, 5, 6 } };
        assertEquals(2, test.array.length);
        assertEquals(3, test.array[0].length);
        assertEquals(1, test.getCell(0, 0));
        assertEquals(3, test.getCell(0, 2));
        assertEquals(5, test.getCell(1, 1));

    }

    @Test
    public void testGetInvalid() {

        Array2DTester test = new Array2DTester();
        // set the field variable directly for test
        test.array = new int[][] { { 1, 2, 3 }, { 4, 5, 6 } };
        assertEquals(Integer.MIN_VALUE, test.getCell(-1, 0));
        assertEquals(Integer.MIN_VALUE, test.getCell(3, 2));
        assertEquals(Integer.MIN_VALUE, test.getCell(1, 4));
        assertEquals(Integer.MIN_VALUE, test.getCell(1, 3));
        assertEquals(Integer.MIN_VALUE, test.getCell(1, -1));

    }

    @Test
    public void testSetDiagonal() {

        Array2DTester test = new Array2DTester();
        // set the field variable directly for test
        test.array = new int[][] { { 0, 0, 0 }, { 0, 0, 0 }, { 0, 0, 0 } };

        test.setDiagonal(1);
        assertEquals(1, test.getCell(0, 0));
        assertEquals(0, test.getCell(0, 1));
        assertEquals(0, test.getCell(0, 2));
        assertEquals(0, test.getCell(1, 0));
        assertEquals(1, test.getCell(1, 1));
        assertEquals(0, test.getCell(1, 2));
        assertEquals(0, test.getCell(2, 0));
        assertEquals(0, test.getCell(2, 1));
        assertEquals(1, test.getCell(2, 2));

    }

    @Test
    public void testSetDiagonalB() {

        Array2DTester test = new Array2DTester();
        // set the field variable directly for test
        test.array = new int[][] { { 0, 0, 0 }, { 0, 0, 0 }, { 0, 0, 0 } };

        test.setDiagonal(1273);
        assertEquals(1273, test.getCell(0, 0));
        assertEquals(0, test.getCell(0, 1));
        assertEquals(0, test.getCell(0, 2));
        assertEquals(0, test.getCell(1, 0));
        assertEquals(1273, test.getCell(1, 1));
        assertEquals(0, test.getCell(1, 2));
        assertEquals(0, test.getCell(2, 0));
        assertEquals(0, test.getCell(2, 1));
        assertEquals(1273, test.getCell(2, 2));

    }

    @Test
    public void testSetDiagonalC() {

        Array2DTester test = new Array2DTester();
        // set the field variable directly for test
        test.array = new int[][] { { 0, 0 }, { 0, 0 } };

        test.setDiagonal(-23);
        assertEquals(-23, test.getCell(0, 0));
        assertEquals(0, test.getCell(0, 1));
        assertEquals(0, test.getCell(1, 0));
        assertEquals(-23, test.getCell(1, 1));
    }

}
