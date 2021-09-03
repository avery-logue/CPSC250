import static org.junit.Assert.assertEquals;
import static org.junit.Assert.fail;

import org.junit.Test;

public class RecursionBTest {

    @Test(timeout = 1000, expected = IndexOutOfBoundsException.class)
    public void testInvalidNegative() {
        try {
            RecursionB.calcSeq(-1);
            fail("Failed to throw exception for negative index");
        }
        catch (IndexOutOfBoundsException e) {
            // Properly threw exception
        }
        RecursionB.calcSeq(33);

    }

    @Test(timeout = 1000)
    public void testIndex0() {
        assertEquals(0, RecursionB.calcSeq(0));
    }

    @Test(timeout = 1000)
    public void testIndex1() {
        assertEquals(1, RecursionB.calcSeq(1));
    }

    @Test(timeout = 1000)
    public void testIndex2() {
        assertEquals(2, RecursionB.calcSeq(2));
    }

    @Test(timeout = 1000)
    public void testIndex3() {
        assertEquals(1, RecursionB.calcSeq(3));
    }

    @Test(timeout = 1000)
    public void testIndex4() {
        assertEquals(-2, RecursionB.calcSeq(4));
    }

    @Test(timeout = 1000)
    public void testIndex5() {
        assertEquals(-5, RecursionB.calcSeq(5));
    }

    @Test(timeout = 1000)
    public void testIndex6() {
        assertEquals(-4, RecursionB.calcSeq(6));
    }

    @Test(timeout = 1000)
    public void testIndex7() {
        assertEquals(3, RecursionB.calcSeq(7));
    }

    @Test(timeout = 1000)
    public void testIndex8() {
        assertEquals(12, RecursionB.calcSeq(8));
    }

    @Test(timeout = 1000)
    public void testIndex15() {
        assertEquals(103, RecursionB.calcSeq(15));
    }

    @Test(timeout = 1000)
    public void testIndex22() {
        // for (int i = 0; i < 32; i++) {
        // System.out.println(" i=" + i + " = " + RecursionB.calcSeq(i));
        // }
        assertEquals(692, RecursionB.calcSeq(22));
    }

}
