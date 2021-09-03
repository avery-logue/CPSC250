import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotNull;
import static org.junit.Assert.assertNull;
import static org.junit.Assert.assertTrue;

import org.junit.Test;

public class SimpleQueueTest {

    @Test
    public void testConstruction() {
        SimpleQueue<Integer> queue = new SimpleQueue<Integer>();

        assertNotNull(queue);
        assertTrue(queue instanceof SimpleLinkedList<?>);
        assertTrue(queue instanceof SimpleQueueInterface<?>);

    }

    @Test
    public void testEnqueue() {
        SimpleQueue<Integer> queue = new SimpleQueue<Integer>();
        queue.enqueue(5);

        assertEquals(" enqueued integer", new Integer(5), queue.first.value);
    }

    @Test
    public void testPeek() {
        SimpleQueue<Integer> queue = new SimpleQueue<Integer>();
        queue.enqueue(5);

        assertEquals(" enqueued integer", new Integer(5), queue.peek());
    }

    @Test
    public void testPop() {
        SimpleQueue<Integer> queue = new SimpleQueue<Integer>();
        queue.enqueue(5);

        assertEquals(" enqueueed integer", new Integer(5), queue.peek());
        Integer val = queue.dequeue();
        assertEquals(" dequeued integer", new Integer(5), val);
        assertNull(" dequeued integer", queue.first);
        assertTrue(" nothing should be left", queue.isEmpty());

    }

    @Test
    public void testMulti() {
        SimpleQueue<Integer> queue = new SimpleQueue<Integer>();
        queue.enqueue(4);
        queue.enqueue(queue.peek() + 5);
        queue.enqueue(10);

        assertEquals(" enqueued ", "4,9,10", queue.toString());
        Integer val = queue.dequeue();
        assertEquals(" dequeued ", "9,10", queue.toString());
        assertEquals(" dequeued integer", new Integer(4), val);

    }

}
