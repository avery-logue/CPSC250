import static org.junit.Assert.assertTrue;

import org.junit.Test;

public class CatchSomeExceptionsTest {

    @Test
    public void testMethodReturnsString() {

        assertTrue("Incorrect result", CatchSomeExceptions
                .runIt(new TestException(0)) instanceof String);
    }

    @Test
    public void testNoException() {
        String actual = CatchSomeExceptions.runIt(new TestException(0));
        String expected = "all good";
        assertTrue("Incorrect result", expected.equalsIgnoreCase(actual));
    }

    @Test
    public void testRuntimeException1() {
        String actual = CatchSomeExceptions.runIt(new TestException(-4));
        String expected = "runtime";
        assertTrue("Incorrect result", expected.equalsIgnoreCase(actual));
    }

    @Test
    public void testArrayIndexOutOfBoundsException1() {
        String actual = CatchSomeExceptions.runIt(new TestException(-5));
        String expected = "OoB";
        assertTrue("Incorrect result", expected.equalsIgnoreCase(actual));
    }

    @Test
    public void testArithmeticException1() {
        String actual = CatchSomeExceptions.runIt(new TestException(6));
        String expected = "math!";
        assertTrue("Incorrect result", expected.equalsIgnoreCase(actual));
    }

    @Test
    public void testIOException1() {
        String actual = CatchSomeExceptions.runIt(new TestException(9));
        String expected = "busted";
        assertTrue("Incorrect result", expected.equalsIgnoreCase(actual));
    }

    @Test
    public void testException1() {
        String actual = CatchSomeExceptions.runIt(new TestException(25));
        String expected = "unknown";
        assertTrue("Incorrect result", expected.equalsIgnoreCase(actual));
    }

    //////
    @Test
    public void testNoException2() {
        String actual = CatchSomeExceptions.runIt(new TestException(0));
        String expected = "all good";
        assertTrue("Incorrect result", expected.equalsIgnoreCase(actual));
    }

    @Test
    public void testRuntimeException2() {
        String actual = CatchSomeExceptions.runIt(new TestException(-42));
        String expected = "runtime";
        assertTrue("Incorrect result", expected.equalsIgnoreCase(actual));
    }

    @Test
    public void testArrayIndexOutOfBoundsException2() {
        String actual = CatchSomeExceptions.runIt(new TestException(-9));
        String expected = "OoB";
        assertTrue("Incorrect result", expected.equalsIgnoreCase(actual));
    }

    @Test
    public void testArithmeticException2() {
        String actual = CatchSomeExceptions.runIt(new TestException(32));
        String expected = "math!";
        assertTrue("Incorrect result", expected.equalsIgnoreCase(actual));
    }

    @Test
    public void testIOException2() {
        String actual = CatchSomeExceptions.runIt(new TestException(27));
        String expected = "busted";
        assertTrue("Incorrect result", expected.equalsIgnoreCase(actual));
    }

    @Test
    public void testException2() {
        String actual = CatchSomeExceptions.runIt(new TestException(35));
        String expected = "unknown";
        assertTrue("Incorrect result", expected.equalsIgnoreCase(actual));
    }

}
