import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertNotNull;

import java.lang.reflect.Field;
import java.lang.reflect.Modifier;

import org.junit.Test;

public class CS150StuffTest {

    private class CS150Tester extends CS150Stuff {

        private CS150Tester() {
            super();
        }

        private CS150Tester(String inp) {
            super(inp);
        }

    }

    @Test
    public void testField() {
        Field[] allFields = CS150Tester.class.getDeclaredFields();
        assertEquals("CS150Stuff should only have 1 field.", 1,
                allFields.length);
        assertFalse(
                "CS150Stuff instance variable should NOT be private or public.",
                Modifier.isPublic(allFields[0].getModifiers()));
        assertFalse(
                "CS150Stuff instance variable should NOT be private or public.",
                Modifier.isPrivate(allFields[0].getModifiers()));

        CS150Tester test = new CS150Tester();
        assertNotNull(test);
        assertNotNull("some string set", test.string);

    }

    @Test
    public void testConstructor() {
        CS150Tester test = new CS150Tester();
        assertNotNull(test);
        assertEquals("CNU", test.string);
    }

    @Test
    public void testConstructor1ArgA() {
        CS150Tester test = new CS150Tester("Christopher Newport University");
        assertNotNull(test);
        assertEquals("Christopher Newport University", test.string);
    }

    @Test
    public void testConstructor1ArgB() {
        CS150Tester test = new CS150Tester("squirrels");
        assertNotNull(test);
        assertEquals("squirrels", test.string);
    }

}
