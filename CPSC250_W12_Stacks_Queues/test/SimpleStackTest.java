import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotNull;
import static org.junit.Assert.assertNull;
import static org.junit.Assert.assertTrue;

import org.junit.Test;

public class SimpleStackTest {

    @Test
    public void testConstruction() {
        SimpleStack<Integer> stack = new SimpleStack<Integer>();

        assertNotNull(stack);
        assertTrue(stack instanceof SimpleLinkedList<?>);
        assertTrue(stack instanceof SimpleStackInterface<?>);

    }

    @Test
    public void testPush() {
        SimpleStack<Integer> stack = new SimpleStack<Integer>();
        stack.push(5);

        assertEquals(" pushed integer", new Integer(5), stack.first.value);
    }

    @Test
    public void testPeek() {
        SimpleStack<Integer> stack = new SimpleStack<Integer>();
        stack.push(5);

        assertEquals(" pushed integer", new Integer(5), stack.peek());
    }

    @Test
    public void testPop() {
        SimpleStack<Integer> stack = new SimpleStack<Integer>();
        stack.push(5);

        assertEquals(" pushed integer", new Integer(5), stack.peek());
        Integer val = stack.pop();
        assertEquals(" popped integer", new Integer(5), val);
        assertNull(" popped integer", stack.first);
        assertTrue(" nothing should be left", stack.isEmpty());

    }

    @Test
    public void testMulti() {
        SimpleStack<Integer> stack = new SimpleStack<Integer>();
        stack.push(4);
        stack.push(stack.peek() + 5);
        stack.push(10);

        assertEquals(" pushed ", "10,9,4", stack.toString());
        Integer val = stack.pop();
        assertEquals(" popped ", "9,4", stack.toString());
        assertEquals(" popped integer", new Integer(10), val);

    }

}
