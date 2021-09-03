import static org.junit.Assert.assertEquals;

import org.junit.Rule;
import org.junit.Test;
import org.junit.rules.Timeout;

public class FibonacciTest {

    @Rule
    public Timeout globalTimeout = Timeout.seconds(2); // 2 seconds max
                                                       // per method tested

    @Test
    public void testInvalidLoop() {
        assertEquals(0, Fibonacci.fibLoop(-1));
        assertEquals(0, Fibonacci.fibLoop(-10));
        assertEquals(0, Fibonacci.fibLoop(-1000));

    }

    @Test
    public void testZeroLoop() {
        assertEquals(0, Fibonacci.fibLoop(0));

    }

    @Test
    public void testOneLoop() {
        assertEquals(1, Fibonacci.fibLoop(1));

    }

    @Test
    public void testTwoLoop() {
        assertEquals(1, Fibonacci.fibLoop(2));

    }

    @Test
    public void testThreeLoop() {
        assertEquals(2, Fibonacci.fibLoop(3));

    }

    @Test
    public void testManyLoop() {
        assertEquals(3, Fibonacci.fibLoop(4));
        assertEquals(5, Fibonacci.fibLoop(5));
        assertEquals(13, Fibonacci.fibLoop(7));
        assertEquals(21, Fibonacci.fibLoop(8));
        assertEquals(144, Fibonacci.fibLoop(12));
        assertEquals(233, Fibonacci.fibLoop(13));
        assertEquals(4181, Fibonacci.fibLoop(19));
        assertEquals(6765, Fibonacci.fibLoop(20));

    }

    // Recursion
    @Test
    public void testInvalidRecursion() {
        assertEquals(0, Fibonacci.fibRecursion(-1));
        assertEquals(0, Fibonacci.fibRecursion(-10));
        assertEquals(0, Fibonacci.fibRecursion(-1000));

    }

    @Test
    public void testZeroRecursion() {
        assertEquals(0, Fibonacci.fibRecursion(0));

    }

    @Test
    public void testOneRecursion() {
        assertEquals(1, Fibonacci.fibRecursion(1));

    }

    @Test
    public void testTwoRecursion() {
        assertEquals(1, Fibonacci.fibRecursion(2));

    }

    @Test
    public void testThreeRecursion() {
        assertEquals(2, Fibonacci.fibRecursion(3));

    }

    @Test
    public void testManyRecursion() {
        assertEquals(3, Fibonacci.fibRecursion(4));
        assertEquals(5, Fibonacci.fibRecursion(5));
        assertEquals(13, Fibonacci.fibRecursion(7));
        assertEquals(21, Fibonacci.fibRecursion(8));
        assertEquals(144, Fibonacci.fibRecursion(12));
        assertEquals(233, Fibonacci.fibRecursion(13));
        assertEquals(4181, Fibonacci.fibRecursion(19));
        assertEquals(6765, Fibonacci.fibRecursion(20));

    }

}
