import static org.junit.Assert.assertEquals;

import org.junit.Rule;
import org.junit.Test;
import org.junit.rules.Timeout;

public class FactorialTest {
    @Rule
    public Timeout globalTimeout = Timeout.seconds(2); // 2 seconds max
                                                       // per method tested

    @Test
    public void testInvalidInputLoop() {
        assertEquals(" < 1", 1, Factorial.factorialLoop(0));
        assertEquals(" < 1", 1, Factorial.factorialLoop(-1));
        assertEquals(" < 1", 1, Factorial.factorialLoop(-100));

    }

    @Test
    public void testTooBigLoop() {
        assertEquals(" > 12", -1, Factorial.factorialLoop(13));
        assertEquals(" > 12", -1, Factorial.factorialLoop(100));
        assertEquals(" > 12", -1, Factorial.factorialLoop(Integer.MAX_VALUE));

    }

    @Test
    public void testOneLoop() {
        assertEquals(" 1!", 1, Factorial.factorialLoop(1));

    }

    @Test
    public void testTwoLoop() {
        assertEquals(" 2!", 2, Factorial.factorialLoop(2));

    }

    @Test
    public void testManyLoop() {
        assertEquals("  3!", 6, Factorial.factorialLoop(3));
        assertEquals("  4!", 24, Factorial.factorialLoop(4));
        assertEquals("  5!", 120, Factorial.factorialLoop(5));
        assertEquals(" 10!", 3628800, Factorial.factorialLoop(10));
        assertEquals(" 12!", 479001600, Factorial.factorialLoop(12));

    }

    // Recursion
    @Test
    public void testInvalidInputRecursion() {
        assertEquals(" < 1", 1, Factorial.factorialRecursion(0));
        assertEquals(" < 1", 1, Factorial.factorialRecursion(-1));
        assertEquals(" < 1", 1, Factorial.factorialRecursion(-100));

    }

    @Test
    public void testTooBigRecursion() {
        assertEquals(" > 12", -1, Factorial.factorialRecursion(13));
        assertEquals(" > 12", -1, Factorial.factorialRecursion(100));
        assertEquals(" > 12", -1,
                Factorial.factorialRecursion(Integer.MAX_VALUE));

    }

    @Test
    public void testOneRecursion() {
        assertEquals(" 1!", 1, Factorial.factorialRecursion(1));

    }

    @Test
    public void testTwoRecursion() {
        assertEquals(" 2!", 2, Factorial.factorialRecursion(2));

    }

    @Test
    public void testManyRecursion() {
        assertEquals("  3!", 6, Factorial.factorialRecursion(3));
        assertEquals("  4!", 24, Factorial.factorialRecursion(4));
        assertEquals("  5!", 120, Factorial.factorialRecursion(5));
        assertEquals(" 10!", 3628800, Factorial.factorialRecursion(10));
        assertEquals(" 12!", 479001600, Factorial.factorialRecursion(12));

    }

}
