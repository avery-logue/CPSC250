import static org.junit.Assert.assertNotNull;
import static org.junit.Assert.fail;

import java.io.IOException;

import org.junit.Test;

/**
 * Test class for Exceptions
 * 
 * @author dconner
 * @version 0
 */
public class ExceptionsTest {

    /** test my exception */
    @Test
    public void testMyException() {
        MyException mine = new MyException();
        assertNotNull(mine);
    }

    /**
     * This will test that our method call actually throws an IOException if we
     * pass argument 0
     * 
     * @throws IOException
     */
    @Test(expected = IOException.class)
    public void testIOException() throws Exception {
        Exceptions excpt = new Exceptions();
        assertNotNull(excpt);
        Exceptions.throwSomething(0);
    }

    /**
     * This will test that our method call actually throws an
     * NullPointerException if we pass argument 0
     * 
     * @throws IllegalArgumentException
     */
    @Test(expected = IllegalArgumentException.class)
    public void testIAException() throws Exception {
        Exceptions excpt = new Exceptions();
        assertNotNull(excpt);
        Exceptions.throwSomething(1);
    }

    /**
     * Another test for NP test that our method call actually throws an
     * NullPointerException if we pass argument 0
     * 
     * @throws IllegalArgumentException
     */
    @Test
    public void testIAException2() throws Exception {
        Exceptions excpt = new Exceptions();
        assertNotNull(excpt);
        try {
            Exceptions.throwSomething(1);
        }
        catch (IllegalArgumentException e) {
            // This is what we expect
            return;
        }
        catch (Exception e) {
            fail("  caught wrong exception = <" + e.getMessage() + ">");
        }

        fail(" Did not throw an exception as expected!");
    }

}
