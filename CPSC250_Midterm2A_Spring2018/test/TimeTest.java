import static org.junit.Assert.assertArrayEquals;
import static org.junit.Assert.assertTrue;

import java.util.ArrayList;
import java.util.Collections;

import org.junit.Test;

public class TimeTest {

    @Test
    public void test0() {
        Time time0 = new Time(0, 0);
        Time time1 = new Time(1, 0);
        assertTrue("invalid compare", time0.compareTo(time1) < 0);

    }

    @Test
    public void test1() {
        Time time0 = new Time(0, 0);
        Time time1 = new Time(1, 0);
        assertTrue("invalid compare", time1.compareTo(time0) > 0);
    }

    @Test
    public void test2() {
        Time time0 = new Time(1, 12);
        Time time1 = new Time(1, 12);
        assertTrue("invalid compare", time1.compareTo(time0) == 0);
    }

    @Test
    public void test3() {
        Time time0 = new Time(1235, 120129130);
        Time time1 = new Time(1235, 120129129);
        assertTrue("invalid compare", time1.compareTo(time0) < 0);
    }

    @Test
    public void test4() {
        Time time0 = new Time(1235, 120129130);
        Time time1 = new Time(1235, 120129131);
        assertTrue("invalid compare", time1.compareTo(time0) > 0);
    }

    @Test
    public void test5() {
        Time time0 = new Time(1235, 120129130);
        Time time1 = new Time(1235, 120129130);
        assertTrue("invalid compare", time1.compareTo(time0) == 0);
    }

    @Test
    public void testSort1() {
        Time time0 = new Time(2, 120129130);
        Time time1 = new Time(1235, 120129131);
        Time time2 = new Time(1235, 120129130);
        Time time3 = new Time(2236, 120129130);
        ArrayList<Time> test = new ArrayList<Time>();
        ArrayList<Time> expected = new ArrayList<Time>();
        test.add(time0);
        test.add(time1);
        test.add(time2);
        test.add(time3);
        expected.add(time0);
        expected.add(time2);
        expected.add(time1);
        expected.add(time3);
        Collections.sort(test);
        assertArrayEquals("failed to sort", expected.toArray(),
                test.toArray());
    }

    @Test
    public void testSort2() {
        Time time0 = new Time(2, 120129130);
        Time time1 = new Time(1235, 120129131);
        Time time2 = new Time(1235, 120129130);
        Time time3 = new Time(1, 120129130);
        ArrayList<Time> test = new ArrayList<Time>();
        ArrayList<Time> expected = new ArrayList<Time>();
        test.add(time0);
        test.add(time1);
        test.add(time2);
        test.add(time3);
        expected.add(time3);
        expected.add(time0);
        expected.add(time2);
        expected.add(time1);
        Collections.sort(test);
        assertArrayEquals("failed to sort", expected.toArray(),
                test.toArray());
    }

    @Test
    public void testSort3() {
        Time time0 = new Time(2, 120129130);
        Time time1 = new Time(0, 120129131);
        Time time2 = new Time(1235, 120129130);
        Time time3 = new Time(1, 120129130);
        ArrayList<Time> test = new ArrayList<Time>();
        ArrayList<Time> expected = new ArrayList<Time>();
        test.add(time0);
        test.add(time1);
        test.add(time2);
        test.add(time3);
        expected.add(time1);
        expected.add(time3);
        expected.add(time0);
        expected.add(time2);
        Collections.sort(test);
        assertArrayEquals("failed to sort", expected.toArray(),
                test.toArray());
    }

}
