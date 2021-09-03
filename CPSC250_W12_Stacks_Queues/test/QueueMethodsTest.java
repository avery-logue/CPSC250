import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertNotNull;
import static org.junit.Assert.assertTrue;

import org.junit.Test;

public class QueueMethodsTest {

    @Test
    public void testQueueConstructInterface() {
        SimpleQueue<String> expected = new SimpleQueue<String>();
        assertNotNull(expected);
        assertTrue(expected instanceof SimpleQueueInterface);
    }

    @Test
    public void test_copyQueueEmpty() {
        SimpleQueue<String> expected = new SimpleQueue<String>();

        SimpleQueue<String> original = new SimpleQueue<String>();
        String originalStr = original.toString();
        SimpleQueue<String> actual = QueueMethods.copyQueue(original);

        // check if copy matches
        assertEquals("Incorrect result", expected.toString(),
                actual.toString());
        // check if original still matches (method should not change original)
        assertEquals("Incorrect result", originalStr, original.toString());
        // check that copy is not same object as original
        assertFalse("Incorrect result", original == actual);
    }

    @Test
    public void test_copyQueueMany() {
        SimpleQueue<String> expected = new SimpleQueue<String>();
        expected.enqueue("Alice");
        expected.enqueue("Bob");
        expected.enqueue("Carol");

        SimpleQueue<String> original = new SimpleQueue<String>();
        original.enqueue("Alice");
        original.enqueue("Bob");
        original.enqueue("Carol");
        String originalStr = original.toString();
        SimpleQueue<String> actual = QueueMethods.copyQueue(original);
        // System.out.println(" copy expected=<" + expected + ">");
        // System.out.println(" copy original =<" + original + ">");
        // System.out.println(" copy actual =<" + actual + ">");

        // check if copy matches
        assertEquals("Incorrect result", expected.toString(),
                actual.toString());
        // check if original still matches (method should not change original)
        assertEquals("Incorrect result", originalStr, original.toString());
        // check that copy is not same object as original
        assertFalse("Incorrect result", original == actual);
    }

    @Test
    public void test_interleaveQueues() {
        SimpleQueue<String> expected = new SimpleQueue<String>();
        expected.enqueue("Alice");
        expected.enqueue("1");
        expected.enqueue("Bob");
        expected.enqueue("2");
        expected.enqueue("Carol");
        expected.enqueue("3");

        SimpleQueue<String> queue1 = new SimpleQueue<String>();
        queue1.enqueue("Alice");
        queue1.enqueue("Bob");
        queue1.enqueue("Carol");
        SimpleQueue<String> queue2 = new SimpleQueue<String>();
        queue2.enqueue("1");
        queue2.enqueue("2");
        queue2.enqueue("3");
        SimpleQueue<String> queue1t = new SimpleQueue<String>();
        queue1t.enqueue("Alice");
        queue1t.enqueue("Bob");
        queue1t.enqueue("Carol");
        SimpleQueue<String> queue2t = new SimpleQueue<String>();
        queue2t.enqueue("1");
        queue2t.enqueue("2");
        queue2t.enqueue("3");
        SimpleQueue<String> actual = QueueMethods.interleave(queue1, queue2);
        // System.out.println(" interleave queue1=<" + queue1t + ">");
        // System.out.println(" interleave queue2=<" + queue2t + ">");
        // System.out.println(" interleave expected =<" + expected + ">");
        // System.out.println(" interleave actual =<" + actual + ">");
        // System.out.println(" interleave queue1=<" + queue1 + ">");
        // System.out.println(" interleave queue2=<" + queue2 + ">");

        assertEquals("Incorrect result", expected.toString(),
                actual.toString());
        assertEquals("Incorrect result - changed source 1", queue1t.toString(),
                queue1.toString());
        assertEquals("Incorrect result - changed source 2", queue2t.toString(),
                queue2.toString());
    }

}
