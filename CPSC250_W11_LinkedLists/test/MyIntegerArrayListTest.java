import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertTrue;
import static org.junit.Assert.fail;

import org.junit.Test;

public class MyIntegerArrayListTest {

    @Test
    public void testAdd2() {
        MyIntegerArrayList list = new MyIntegerArrayList();
        int actual = list.size();
        assertEquals("Incorrect result", 0, actual);
        list.add(new Integer(42));
        list.add(new Integer(43));
        assertEquals("Incorrect size after adding 2", 2, list.size());
        assertEquals("Incorrect result for get(0)", new Integer(42),
                list.get(0));
        assertEquals("Incorrect result for get(1)", new Integer(43),
                list.get(1));
        assertEquals("Incorrect capacity", MyIntegerArrayList.DEFAULT_SIZE,
                list.capacity());

    }

    @Test
    public void testAddIndex() {
        MyIntegerArrayList list = new MyIntegerArrayList();
        int actual = list.size();
        assertEquals("Incorrect result", 0, actual);
        list.add(new Integer(42));
        list.add(new Integer(43));
        list.add(1, new Integer(44));
        assertEquals("Incorrect size after adding 3", 3, list.size());
        assertEquals("Incorrect result for get(0)", new Integer(42),
                list.get(0));
        assertEquals("Incorrect result for get(1)", new Integer(44),
                list.get(1));
        assertEquals("Incorrect result for get(1)", new Integer(43),
                list.get(2));
        assertEquals("Incorrect capacity", MyIntegerArrayList.DEFAULT_SIZE,
                list.capacity());

    }

    @Test
    public void testAdd150Capacity() {
        MyIntegerArrayList list = new MyIntegerArrayList();
        int actual = list.size();
        final int test_size = (int) (1.5 * MyIntegerArrayList.DEFAULT_SIZE);

        assertTrue("Test limits", test_size > list.capacity());

        for (int i = 0; i < test_size; i++) {
            list.add(new Integer(i));
        }

        assertEquals("Incorrect size", test_size, list.size());
        assertEquals("Incorrect capacity", 2 * MyIntegerArrayList.DEFAULT_SIZE,
                list.capacity());

    }

    @Test
    public void testRemove2() {
        MyIntegerArrayList list = new MyIntegerArrayList();
        int actual = list.size();
        assertEquals("Incorrect result", 0, actual);
        list.add(new Integer(42));
        list.add(new Integer(43));
        assertEquals("Incorrect size after adding 2", 2, list.size());
        assertEquals("Incorrect result for get(0)", new Integer(42),
                list.get(0));
        assertEquals("Incorrect result for get(1)", new Integer(43),
                list.get(1));
        assertEquals("Incorrect capacity", MyIntegerArrayList.DEFAULT_SIZE,
                list.capacity());

        list.remove(0);
        assertEquals("Incorrect result for get(0) after removing first",
                new Integer(43), list.get(0));
        list.remove(0);
        assertEquals("Incorrect result removing all", 0, list.size());

        try {
            list.remove(0);
        }
        catch (IndexOutOfBoundsException e) {
            assertEquals(" size still 0 even after too many removes", 0,
                    list.size());

            return;
        }
        catch (Exception e) {
            fail("Failed to throw IndexOutOfBoundsException - "
                    + e.getCause().getMessage() + " instead!");

        }
        assertEquals(" failed to catch removing too many elements", 0,
                list.size());
        fail("Failed to throw IndexOutOfBoundsException after removing too many!");
    }

    @Test
    public void testCopyConstructorShallowOK() {
        MyIntegerArrayList list = new MyIntegerArrayList();
        int actual = list.size();
        assertEquals("Incorrect result", 0, actual);
        list.add(new Integer(42));
        list.add(new Integer(43));

        MyIntegerArrayList copyList = new MyIntegerArrayList(list);

        assertEquals(" copies should be the same size", list.size(),
                copyList.size());
        for (int i = 0; i < list.size(); i++) {
            assertEquals(" Each element must be equivalent", list.get(i),
                    copyList.get(i));

        }
    }

    @Test
    public void testCopyConstructorShallowNotEnough() {
        MyIntegerArrayList origList = new MyIntegerArrayList();
        int actual = origList.size();
        assertEquals("Incorrect result", 0, actual);
        origList.add(new Integer(42));
        origList.add(new Integer(43));

        MyIntegerArrayList testList = new MyIntegerArrayList();
        actual = testList.size();
        assertEquals("Incorrect result", 0, actual);
        testList.add(new Integer(42));
        testList.add(new Integer(43));

        // Confirm the test setup
        assertEquals(" copies should be the same size", testList.size(),
                origList.size());
        for (int i = 0; i < origList.size(); i++) {
            assertEquals(" Each element must be equivalent", origList.get(i),
                    testList.get(i));
        }
        // Create our copy
        MyIntegerArrayList copyList = new MyIntegerArrayList(origList);

        // Change the first list
        origList.remove(0);
        origList.add(new Integer(44));

        assertEquals(" copies should be the same size", testList.size(),
                copyList.size());
        for (int i = 0; i < copyList.size(); i++) {
            assertEquals(" Each element must be equivalent", testList.get(i),
                    copyList.get(i));

        }

    }

    @Test
    public void testCopyConstructorCanWeGetDeepCopy() {
        MyIntegerArrayList origList = new MyIntegerArrayList();
        int actual = origList.size();
        assertEquals("Incorrect result", 0, actual);
        origList.add(new Integer(42));
        origList.add(new Integer(43));

        MyIntegerArrayList testList = new MyIntegerArrayList();
        actual = testList.size();
        assertEquals("Incorrect result", 0, actual);
        testList.add(new Integer(42));
        testList.add(new Integer(43));

        // Confirm the test setup
        assertEquals(" copies should be the same size", testList.size(),
                origList.size());
        for (int i = 0; i < origList.size(); i++) {
            assertEquals(" Each element must be equivalent", origList.get(i),
                    testList.get(i));
        }
        // Create our copy
        MyIntegerArrayList copyList = new MyIntegerArrayList(origList);

        // Change the first list by changing its data
        origList.add(0, new Integer(52));

        // Test that we copy is equal
        assertEquals(" copies should be the same size", testList.size(),
                copyList.size());

        for (int i = 0; i < copyList.size(); i++) {
            assertEquals(" Each element must be equivalent", testList.get(i),
                    copyList.get(i));

        }
    }

}
