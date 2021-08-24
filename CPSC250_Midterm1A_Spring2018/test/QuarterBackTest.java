import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotNull;
import static org.junit.Assert.assertTrue;

import java.lang.reflect.Constructor;
import java.lang.reflect.Field;
import java.lang.reflect.Method;
import java.lang.reflect.Modifier;

import org.junit.Test;

public class QuarterBackTest {

    @Test
    public void testConstructor() {
        QuarterBack player = new QuarterBack("Brady", 12);
        assertNotNull(player);
        assertTrue(player instanceof Player);
    }

    @Test
    public void testQuarterBackisPlayer() {
        QuarterBack player = new QuarterBack("Big Ben", 7);
        assertTrue(player instanceof Player);
    }

    @Test
    public void testQuarterBackisOffense() {
        QuarterBack player = new QuarterBack("Big Ben", 7);
        assertTrue(player instanceof Offense);
    }

    @Test
    public void testFields() {
        Field[] allFields = QuarterBack.class.getDeclaredFields();
        assertEquals(
                "QuarterBack should only have no field (instance) variables.",
                0, allFields.length);

        allFields = Player.class.getDeclaredFields();
        assertEquals(
                "Do NOT change Player - should only have 2 field (instance) variables.",
                2, allFields.length);
        assertTrue(
                "Do NOT change Player - instance variable should NOT be public or protected.",
                Modifier.isPrivate(allFields[0].getModifiers()));
        assertTrue(
                "Do NOT change Player - instance variable should NOT be public or protected.",
                Modifier.isPrivate(allFields[1].getModifiers()));

        // force basic test to fail if we don't fix class
        QuarterBack player = new QuarterBack("Brady", 12);
        String str = player.toString();
        assertTrue(str.contains("Brady"));
    }

    @Test
    public void testMethods() {
        Method[] allMethods = QuarterBack.class.getDeclaredMethods();
        assertEquals("QuarterBack should only have 0 method.", 0,
                allMethods.length);
        QuarterBack player = new QuarterBack("Brady", 12);
        String str = player.toString();
        assertTrue(str.contains("Brady"));
    }

    @Test
    public void testMethods2() {
        Method[] allMethods = QuarterBack.class.getDeclaredMethods();
        assertEquals("QuarterBack should only have 0 method.", 0,
                allMethods.length);
        QuarterBack player = new QuarterBack("Brady", 12);
        String str = player.toString();
        assertTrue(str.contains("Brady"));
    }

    @Test
    public void testConstructors2() {
        Constructor<?>[] allCons = QuarterBack.class.getDeclaredConstructors();
        assertEquals("QuarterBack should only have 1 constructor ().", 1,
                allCons.length);

        QuarterBack player = new QuarterBack("Brady", 12);
        String str = player.toString();
        assertTrue(str.contains("Brady"));
    }

    @Test
    public void testConstructors() {
        Constructor<?>[] allCons = QuarterBack.class.getDeclaredConstructors();
        assertEquals("QuarterBack should only have 1 constructor ().", 1,
                allCons.length);

        QuarterBack player = new QuarterBack("Brady", 12);
        String str = player.toString();
        assertTrue(str.contains("Brady"));
    }

    @Test
    public void testQuarterBackstrings1() {
        QuarterBack player = new QuarterBack("Brady", 12);
        String str = player.toString();
        assertTrue(str.contains("Brady"));
    }

    @Test
    public void testQuarterBackstrings2() {
        QuarterBack player = new QuarterBack("Brady", 12);
        String str = player.toString();
        assertTrue(str.contains("12"));
    }

    @Test
    public void testQuarterBackstrings3() {
        QuarterBack player = new QuarterBack("Brady", 12);
        String str = player.toString();
        assertTrue(str.contains("Brady"));
        assertTrue(str.contains("12"));
    }

    @Test
    public void testQuarterBackstrings4() {
        QuarterBack player = new QuarterBack("Brady", 12);
        String str = player.toString();
        assertTrue(str.contains("Brady"));
        assertTrue(str.contains("12"));
        assertTrue(str.contains("#"));
    }

    @Test
    public void testQuarterBackstringsPerfect() {
        QuarterBack player = new QuarterBack("Brady", 12);
        String str = player.toString();
        assertTrue(str.contains("Brady"));
        assertTrue(str.contains("12"));
        assertTrue(str.contains("Brady #12"));
    }

}
