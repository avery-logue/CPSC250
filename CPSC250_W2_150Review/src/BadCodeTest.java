import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotNull;
import org.junit.Test;
/**
 * Tests for BadCode
 * @author Avery's PC
 * @version 1/18/18
 */
public class BadCodeTest {
    /**
     * Tests the default constructor
     */
    @Test
    public void testDefaultConstructor() {
        BadCode bc = new BadCode();
        assertNotNull("valid Instance", bc);
        assertEquals("negative 1", bc.getName());
        assertEquals(-1, bc.getCount());
    }
    /**
     * Tests the other constructor
     */
    @Test
    public void testConstructorOne() {
        BadCode bc = new BadCode(2, "jimbo");
        assertNotNull("valid Instance", bc);
        assertEquals("jimbo", bc.getName());
        assertEquals(2, bc.getCount());
    }
    /**
     * Tests the getName method
     */
    @Test
    public void testSetName() {
        BadCode bc = new BadCode();
        assertNotNull("valid Instance", bc);
        assertEquals("negative 1", bc.getName());
        assertEquals(-1, bc.getCount());

        bc.setName("Jimmy");
        assertEquals("Jimmy", bc.getName());
    }
    /**
     * Tests the setCount
     */
    @Test
    public void testSetCount() {
        BadCode bc = new BadCode();
        assertNotNull("valid Instance", bc);
        assertEquals("negative 1", bc.getName());
        assertEquals(-1, bc.getCount());

        bc.setCount(3);
        assertEquals(3, bc.getCount());
    }
    /**
     * Tests the main
     */
    @Test
    public void testMain() {
        BadCode.main(null);
        BadCode bc = new BadCode();
        assertNotNull("valid Instance", bc);
    }
}
