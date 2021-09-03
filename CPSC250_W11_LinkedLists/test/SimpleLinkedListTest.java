import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertTrue;
import static org.junit.Assert.fail;

import org.junit.Test;

public class SimpleLinkedListTest {

    @Test
    public void testAdd() {
        SimpleLinkedList<String> list = new SimpleLinkedList<String>();
        list.add(0, "Hello");

        assertEquals("Hello", list.first.value);
        assertTrue(list.first.next == null);

        list.add(0, "Hi");

        assertEquals("Hi", list.first.value);
        assertEquals("Hello", list.first.next.value);
        assertTrue(list.first.next.next == null);

        list.add(1, "Hey");

        assertEquals("Hi", list.first.value);
        assertEquals("Hey", list.first.next.value);
        assertEquals("Hello", list.first.next.next.value);
        assertTrue(list.first.next.next.next == null);

    }

    @Test
    public void testAddEnd() {
        SimpleLinkedList<String> list = new SimpleLinkedList<String>();
        list.add("Hello");

        assertEquals("Hello", list.first.value);
        assertTrue(list.first.next == null);

        list.add("Hi");

        assertEquals("Hello", list.first.value);
        assertEquals("Hi", list.first.next.value);
        assertTrue(list.first.next.next == null);

        list.add("Hey");

        assertEquals("Hello", list.first.value);
        assertEquals("Hi", list.first.next.value);
        assertEquals("Hey", list.first.next.next.value);
        assertTrue(list.first.next.next.next == null);

    }

    @Test
    public void testAddInvalid() {
        SimpleLinkedList<String> list = new SimpleLinkedList<String>();
        list.add(0, "Hello");
        list.add(0, "Hi");
        list.add(1, "Hey");

        assertEquals("Hi", list.first.value);
        assertEquals("Hey", list.first.next.value);
        assertEquals("Hello", list.first.next.next.value);
        assertTrue(list.first.next.next.next == null);
        list.add(3, "Last");
        assertEquals("Can add at end of list", "Last",
                list.first.next.next.next.value);

        boolean failed = true;
        try {
            list.add(5, "Cannot skip!");
        }
        catch (IndexOutOfBoundsException e) {
            // caught properly
            failed = false;
        }
        catch (Exception e) {
            fail(" Should be IndexOutOfBoundsException! instead of "
                    + e.getClass().getSimpleName());
        }
        if (failed) {
            fail(" Should have thrown IndexOutOfBoundsException with add and skip!");

        }
        failed = true;
        try {
            list.add(-1, "Bad add!");
        }
        catch (IndexOutOfBoundsException e) {
            failed = false;
        }
        catch (Exception e) {
            fail(" Should be IndexOutOfBoundsException! instead of "
                    + e.getClass().getSimpleName());
        }
        if (failed) {
            fail(" Should have thrown IndexOutOfBoundsException with add and negative index!");

        }

        try {
            list.add(42, "Bad add!");
        }
        catch (IndexOutOfBoundsException e) {
            // Last one, so just return if successfully caught
            return;
        }
        catch (Exception e) {
            fail(" Should be IndexOutOfBoundsException! instead of "
                    + e.getCause().getClass().getSimpleName());
        }
        fail("Should have thrown IndexOutOfBoundsException with bad index in add");
    }

    @Test
    public void testRemove() {
        SimpleLinkedList<String> list = new SimpleLinkedList<String>();
        list.add(0, "Hello");
        list.add(0, "Hi");
        list.add(1, "Hey");

        list.remove(1);

        assertEquals("Hi", list.first.value);
        assertEquals("Hello", list.first.next.value);
        assertTrue(list.first.next.next == null);

        list.remove(0);

        assertEquals("Hello", list.first.value);
        assertTrue(list.first.next == null);

    }

    @Test
    public void testSize() {
        SimpleLinkedList<String> list = new SimpleLinkedList<String>();
        assertEquals("nothing in list ==> size = 0", 0, list.size());
        list.add(0, "Hello");
        list.add(0, "Hi");
        list.add(1, "Hey");

        assertEquals("added 3 to list", 3, list.size());

        list.remove(1);

        assertEquals("added 3 to list, then removed 1, size ==2", 2,
                list.size());
        list.remove(0);
        list.remove(0);
        assertEquals("added 3 to list, then removed 3, size ==0", 0,
                list.size());

        try {
            list.remove(0);
        }
        catch (IndexOutOfBoundsException e) {
            System.out
                    .println(" Correctly threw index out of bounds exception");
            return;
        }
        System.out.println(
                " Did not throw index out of bounds exception after removing to many");
        fail("Should have thrown index out of bounds exception!");

    }

}
