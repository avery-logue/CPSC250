import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotNull;

import org.junit.Test;

public class CS150StuffTestMethods {

    private class CS150Tester extends CS150Stuff {

        private CS150Tester() {
            super();
        }

        private CS150Tester(String inp) {
            super(inp);
        }

    }

    @Test
    public void testGetter() {
        CS150Tester test = new CS150Tester();
        test.string = "hello";
        assertNotNull(test);
        assertEquals("hello", test.getString());

    }

    @Test
    public void testGetter2() {
        CS150Tester test = new CS150Tester();
        test.string = "Joe";
        assertNotNull(test);
        assertEquals("Joe", test.getString());

    }

    @Test
    public void testSetter() {
        CS150Tester test = new CS150Tester();
        test.setString("hello");
        assertEquals("hello", test.string);

    }

    @Test
    public void testSetter2() {
        CS150Tester test = new CS150Tester();
        test.setString("Joe");
        assertEquals("Joe", test.string);

    }

}
