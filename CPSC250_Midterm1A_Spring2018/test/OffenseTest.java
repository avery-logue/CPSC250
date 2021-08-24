import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotNull;
import static org.junit.Assert.assertTrue;

import java.lang.reflect.Constructor;
import java.lang.reflect.Field;
import java.lang.reflect.Method;
import java.lang.reflect.Modifier;

import org.junit.Test;

public class OffenseTest {

    @Test
    public void testConstructor() {
        Offense player = new Offense("Brady", 12);
        assertNotNull(player);
    }

    @Test
    public void testOffenseisPlayer() {
        Offense player = new Offense("Big Ben", 7);
        assertTrue(player instanceof Player);
    }

    @Test
    public void testFields() {
        Field[] allFields = Offense.class.getDeclaredFields();
        assertEquals("Offense should only have no field (instance) variables.",
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
        // force basic test to fail
        Offense player = new Offense("Brady", 12);
        String str = player.toString();
        assertTrue(str.contains("Brady"));
    }

    @Test
    public void testMethods() {
        Method[] allMethods = Offense.class.getDeclaredMethods();
        assertEquals("Offense should only have 0 method.", 0,
                allMethods.length);
        // force basic test to fail
        Offense player = new Offense("Brady", 12);
        String str = player.toString();
        assertTrue(str.contains("Brady"));
    }

    @Test
    public void testMethods2() {
        Method[] allMethods = Offense.class.getDeclaredMethods();
        assertEquals("Offense should only have 0 method.", 0,
                allMethods.length);
        // force basic test to fail
        Offense player = new Offense("Brady", 12);
        String str = player.toString();
        assertTrue(str.contains("Brady"));
    }

    @Test
    public void testConstructors2() {
        Constructor<?>[] allCons = Offense.class.getDeclaredConstructors();
        assertEquals("Offense should only have 2 constructor ().", 2,
                allCons.length);

        // force basic test to fail
        Offense player = new Offense("Brady", 12);
        String str = player.toString();
        assertTrue(str.contains("Brady"));
    }

    @Test
    public void testConstructors() {
        Constructor<?>[] allCons = Offense.class.getDeclaredConstructors();
        assertEquals("Offense should only have 2 constructor ().", 2,
                allCons.length);

        // force basic test to fail
        Offense player = new Offense("Brady", 12);
        String str = player.toString();
        assertTrue(str.contains("Brady"));
    }

    @Test
    public void testOffensestrings1() {
        Offense player = new Offense("Brady", 12);
        String str = player.toString();
        assertTrue(str.contains("Brady"));
    }

    @Test
    public void testOffensestrings2() {
        Offense player = new Offense("Brady", 12);
        String str = player.toString();
        assertTrue(str.contains("12"));
    }

    @Test
    public void testOffensestrings3() {
        Offense player = new Offense("Brady", 12);
        String str = player.toString();
        assertTrue(str.contains("Brady"));
        assertTrue(str.contains("12"));
    }

    @Test
    public void testOffensestrings4() {
        Offense player = new Offense("Brady", 12);
        String str = player.toString();
        assertTrue(str.contains("Brady"));
        assertTrue(str.contains("12"));
        assertTrue(str.contains("#"));
    }

    @Test
    public void testOffensestringsPerfect() {
        Offense player = new Offense("Brady", 12);
        String str = player.toString();
        assertTrue(str.contains("Brady"));
        assertTrue(str.contains("12"));
        assertTrue(str.contains("Brady #12"));
    }

}
