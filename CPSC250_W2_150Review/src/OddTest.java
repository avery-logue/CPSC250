import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertTrue;
import static org.junit.Assert.assertNotNull;
import org.junit.Test;

/**
 * Test class
 * 
 * @author dconner
 * @version 2017-1-14
 */
public class OddTest {

    /**
     * Test we can construct the class Web-cat want use to exercise all code in
     * our JUnit tests
     */
    @Test
    public void testClass() {
        Odd ca = new Odd(); // default constructor
        assertNotNull(ca);
    }

    /** Test with odd */
    @Test
    public void testOdd() {
        assertTrue(Odd.isOdd(3));
    }

    /** Test with even */
    @Test
    public void testEven() {
        assertFalse(Odd.isOdd(2));
    }
    /**Test with zero
     * 
     */
    @Test
    public void testZero() {
        assertFalse(Odd.isOdd(0));
    }
    /**
     * Test with an odd negative
     */
    @Test
    public void testOddNeg() {
        assertTrue(Odd.isOdd(-33));
    }
    /**
     * Tests with an even negative
     */
    @Test
    public void testEvenNeg() {
        assertFalse(Odd.isOdd(-44));
    }
}
