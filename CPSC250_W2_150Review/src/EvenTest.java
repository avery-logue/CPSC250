import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertTrue;
import static org.junit.Assert.assertNotNull;
import org.junit.Test;

/**
 * Test class
 * 
 * @author Avery Logue
 * @version 1/23/18
 */
public class EvenTest {

    /**
     * Test we can construct the class Web-cat want use to exercise all code in
     * our JUnit tests
     */
    @Test
    public void testClass() {
        Even ca = new Even(); // default constructor
        assertNotNull(ca);
    }

    /** Test with Even */
    @Test
    public void testEven() {
        assertTrue(Even.isEven(2));
    }

    /** Test with even */
    @Test
    public void testOdd() {
        assertFalse(Even.isEven(3));
    }
    /**Test with zero
     * 
     */
    @Test
    public void testZero() {
        assertTrue(Even.isEven(0));
    }
    /**
     * Test with an Even negative
     */
    @Test
    public void testEvenNeg() {
        assertTrue(Even.isEven(-32));
    }
    /**
     * Tests with an even negative
     */
    @Test
    public void testOddNeg() {
        assertFalse(Even.isEven(-43));
    }
}