import static org.junit.Assert.*;
import org.junit.Test;

/**
 * This is the test method
 * @author Avery Logue
 * @version 1/18/18
 */
public class CopyArrayTest {
    /**
     * Tests the object
     */
    @Test
    public void testCopyArray() {
        CopyArray test = new CopyArray();
        assertNotNull(test);
    }
    /**
     * Tests the shallowCopy method
     */
    @Test
    public void testShallowCopy() {
        double[] array = {0.0, 3.14, -1.1};
        double[] copy  = CopyArray.shallowCopy(array);
        assertArrayEquals(array, copy, 0.0001);
    }
    /**
     * Tests the deepCopy method
     */
    @Test
    public void testDeepCopy() {
        String[] array = {"jimbo", "jambo"};
        String[] copy  = CopyArray.deepCopy(array);

        assertArrayEquals(array, copy);
        assertNotSame(array, copy);
    }
    /**
     * Tests if the deepCopy method is empty
     */
    @Test
    public void testDeepCopyEmpty() {
        String[] array = {};
        String[] copy  = CopyArray.deepCopy(array);

        assertArrayEquals(array, copy);
        assertNotSame(array, copy);
    }
    /**
     * Tests if the deepCopy method is null
     */
    @Test
    public void testDeepCopyNull() {
        String[] copy  = CopyArray.deepCopy(null);
        assertNull(copy);
    }
    /**
     * Tests the deepCopyOdd method
     */
    @Test
    public void testDeepCopyOdd() {
        int[] array = {1, 2, 3, 4, 5, 6, 7};
        int [] result = CopyArray.deepCopyOdd(array);
        int[] expected = {1, 3, 5, 7};

        assertArrayEquals(result, expected);
        assertNotSame(array, result);
    }

}
