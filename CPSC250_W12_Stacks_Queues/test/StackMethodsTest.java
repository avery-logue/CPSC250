import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertTrue;

import org.junit.Test;

public class StackMethodsTest {

    @Test
    public void test_copyStackEmpty() {
        SimpleStack<String> expected = new SimpleStack<String>();

        SimpleStack<String> original = new SimpleStack<String>();
        String originalStr = original.toString();
        SimpleStack<String> actual = StackMethods.copyStack(original);

        // check if copy matches
        assertEquals("Incorrect result", expected.toString(),
                actual.toString());
        // check if original still matches (method should not change original)
        assertEquals("Incorrect result", originalStr, original.toString());
        // check that copy is not same object as original
        assertFalse("Incorrect result", original == actual);
    }

    @Test
    public void test_copyStackMany() {
        SimpleStack<String> expected = new SimpleStack<String>();
        expected.push("Alice");
        expected.push("Bob");
        expected.push("Carol");

        SimpleStack<String> original = new SimpleStack<String>();
        original.push("Alice");
        original.push("Bob");
        original.push("Carol");
        String originalStr = original.toString();
        SimpleStack<String> actual = StackMethods.copyStack(original);

        // check if copy matches
        assertEquals("Incorrect result", expected.toString(),
                actual.toString());
        // check if original still matches (method should not change original)
        assertEquals("Incorrect result", originalStr, original.toString());
        // check that copy is not same object as original
        assertFalse("Incorrect result", original == actual);
    }

    @Test
    public void testContainsMany() {
        SimpleStack<String> original = new SimpleStack<String>();
        original.push("Alice");
        original.push("Bob");
        original.push("Carol");
        String originalStr = original.toString();

        boolean actual = StackMethods.contains(original, "Alice");
        assertTrue("Incorrect result", actual);
        // check if original still matches (method should not change original)
        assertEquals("Incorrect result", originalStr, original.toString());
        actual = StackMethods.contains(original, "Fred");
        assertFalse("Incorrect result", actual);

        // check if original still matches (method should not change original)
        assertEquals("Incorrect result", originalStr, original.toString());
    }

}
