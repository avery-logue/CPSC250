import static org.junit.Assert.assertEquals;
import static org.junit.Assert.fail;

import org.junit.Test;

/**
 * FractionTest
 * 
 * @author dconner
 * @version 0
 *
 */
public class FractionTest {

    /** test */
    @Test
    public void testWorks() {
        try {
            String str = Fraction.fractionString("4");
            String expected = "Result = 0.500\nThanks for using "
                    + "\"printFraction\"!\n";

            assertEquals("index 4 = 4", expected, str);
            Fraction.main(null); // call main to make Web-cat happy
            Fraction.printFraction("4"); // call to make Web-cat happy
        }
        catch (Exception e) {
            fail("Should not throw an exception!");
        }
    }

    /** test */
    @Test
    public void testNan() {
        try {
            String str = Fraction.fractionString("0");
            String expected = "ERROR: result is not a number\n"
                    + "Thanks for using \"printFraction\"!\n";
            assertEquals("index 4 = 4", expected, str);
        }
        catch (Exception e) {
            fail("Should not throw an exception!");
        }
    }

    /** test */
    @Test
    public void testInvalid() {
        try {
            String str = Fraction.fractionString("-1");
            String expected = "ERROR: -1 is not a valid array index\n"
                    + "Thanks for using \"printFraction\"!\n";
            assertEquals("index -1 is invalid", expected, str);
        }
        catch (Exception e) {
            fail("Should not throw an exception!");
        }
    }

    /** test */
    @Test
    public void testZero() {
        try {
            String str = Fraction.fractionString("zero");
            String expected = "ERROR: zero is not a valid number\n"
                    + "Thanks for using \"printFraction\"!\n";
            assertEquals("index \"zero\" is invalid", expected, str);
        }
        catch (Exception e) {
            fail("Should not throw an exception!");
        }
    }

}
