import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNull;
import static org.junit.Assert.assertTrue;

import org.junit.Test;

public class CalculateStringTest {

    @Test
    public void testInvalidCommandNull() {
        assertNull("null should return null", CalculateString.calculate(null));

        // Force failure of just null values
        Integer val = CalculateString.calculate("ADD 1 4 ");
        assertTrue(" should return Number ", val instanceof Number);
        assertEquals("ADD 1 4 = 5", 5, val.intValue());
    }

    @Test
    public void testInvalidCommand() {
        assertNull("should return null", CalculateString.calculate("Delci"));

        // Force failure of just null values
        Integer val = CalculateString.calculate("ADD 1 4 ");
        assertTrue(" should return Number ", val instanceof Number);
        assertEquals("ADD 1 4 = 5", 5, val.intValue());
    }

    @Test
    public void testSum1() {
        Number val = CalculateString.calculate("ADD");
        assertNull(" should return null", val);

        // Force failure of just null values
        val = CalculateString.calculate("ADD 1 4 ");
        assertTrue(" should return Number ", val instanceof Number);
        assertEquals("ADD 1 4 = 5", 5, val.intValue());
    }

    @Test
    public void testSum2() {
        Number val = CalculateString.calculate("ADD 1 3");
        assertTrue(" should return Number ", val instanceof Number);
        assertEquals(4, val.intValue());
    }

    @Test
    public void testSum3() {
        Number val = CalculateString.calculate("ADD 1 -4");
        assertTrue(" should return Number ", val instanceof Number);
        assertEquals(-3, val.intValue());

    }

    @Test
    public void testSum4() {
        Number val = CalculateString.calculate("ADD 1 -4 6 4");
        assertTrue(" should return Number ", val instanceof Number);
        assertEquals(7, val.intValue());
    }

    @Test
    public void testSum5() {
        Number val = CalculateString.calculate("ADD 1 4 5 3");
        assertTrue(" should return Number ", val instanceof Number);
        assertEquals("ADD 1 4 5 3 = 13", 13, val.intValue());

    }

    @Test
    public void testInvalidSum0() {
        Number val = CalculateString.calculate("ADD 1 Joe");
        assertNull("Not number should return null", val);

        // Force failure of just null values
        val = CalculateString.calculate("ADD 1 4 ");
        assertTrue(" should return Number ", val instanceof Number);
        assertEquals("ADD 1 4 = 5", 5, val.intValue());
    }

    //////
    @Test
    public void testProduct1() {
        Number val = CalculateString.calculate("MULTIPLY");
        assertNull("no numbers should return null", val);

        // Force failure of just null values
        val = CalculateString.calculate("ADD 1 4 ");
        assertTrue(" should return Number ", val instanceof Number);
        assertEquals("ADD 1 4 = 5", 5, val.intValue());
    }

    @Test
    public void testProduct2() {
        Number val = CalculateString.calculate("MULTIPLY,2\t3");
        assertTrue(" should return Number ", val instanceof Number);
        assertEquals(6, val.intValue());
    }

    @Test
    public void testProduct3() {
        Number val = CalculateString.calculate("MULTIPLY 1 -4");
        assertTrue(" should return Number ", val instanceof Number);
        assertEquals(-4, val.intValue());

    }

    @Test
    public void testProduct4() {
        Number val = CalculateString.calculate("MULTIPLY 1 -4 2");
        assertTrue(" should return Number ", val instanceof Number);
        assertEquals(-8, val.intValue());

    }

    @Test
    public void testProduct5() {
        Number val = CalculateString.calculate("MULTIPLY,1,4,0");
        assertTrue(" should return Number ", val instanceof Number);
        assertEquals(0, val.intValue());
    }

    @Test
    public void testProduct6() {
        Number val = CalculateString.calculate("MULTIPLY\t1\t4\t2\t3\t1");
        assertTrue(" should return Number ", val instanceof Number);
        assertEquals(24, val.intValue());

    }

    @Test
    public void testInvalidProduct0() {
        Number val = CalculateString.calculate("MULTIPLY 2 Joe 3");
        assertNull("null should return null", val);

        // Force failure of just null values
        val = CalculateString.calculate("ADD 1 4 ");
        assertTrue(" should return Number ", val instanceof Number);
        assertEquals("ADD 1 4 = 5", 5, val.intValue());
    }

}
