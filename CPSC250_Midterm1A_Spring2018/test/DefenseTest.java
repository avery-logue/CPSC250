import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotNull;
import static org.junit.Assert.assertTrue;

import java.lang.reflect.Constructor;
import java.lang.reflect.Field;
import java.lang.reflect.Method;
import java.lang.reflect.Modifier;

import org.junit.Test;

public class DefenseTest {

    @Test
    public void testConstructor() {
        Defense player = new Defense("Jordan Hicks", 58);
        assertNotNull(player);
    }

    @Test
    public void testDefenseisPlayer() {
        Defense player = new Defense("Harrison", 92);
        assertTrue(player instanceof Player);
    }

    @Test
    public void testFields() {
        Field[] allFields = Defense.class.getDeclaredFields();
        assertEquals("Defense should only have no field (instance) variables.",
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

        // Fail the basic tests if we don't fix class
        Defense player = new Defense("Harrison", 92);
        assertTrue(player instanceof Player);
        String str = player.toString();
        assertTrue(str.contains("Harrison"));

    }

    @Test
    public void testMethods() {
        Method[] allMethods = Defense.class.getDeclaredMethods();
        assertEquals("Defense should only have 0 methods.", 0,
                allMethods.length);

        // Fail the basic tests if we don't fix class
        Defense player = new Defense("Harrison", 92);
        assertTrue(player instanceof Player);
        String str = player.toString();
        assertTrue(str.contains("Harrison"));
    }

    @Test
    public void testMethods2() {
        Method[] allMethods = Defense.class.getDeclaredMethods();
        assertEquals("Defense should only have 0 methods.", 0,
                allMethods.length);

        // Fail the basic tests if we don't fix class
        Defense player = new Defense("Harrison", 92);
        assertTrue(player instanceof Player);
        String str = player.toString();
        assertTrue(str.contains("Harrison"));
    }

    @Test
    public void testConstructors2() {
        Constructor<?>[] allCons = Defense.class.getDeclaredConstructors();
        assertEquals("Defense should only have 2 constructor ().", 2,
                allCons.length);

        // Fail the basic tests if we don't fix class
        Defense player = new Defense("Harrison", 92);
        assertTrue(player instanceof Player);
    }

    @Test
    public void testConstructors() {
        Constructor<?>[] allCons = Defense.class.getDeclaredConstructors();
        assertEquals("Defense should only have 2 constructor ().", 2,
                allCons.length);

        // Fail the basic tests if we don't fix class
        Defense player = new Defense("Harrison", 92);
        assertTrue(player instanceof Player);
    }

    @Test
    public void testDefensestrings1() {
        Defense player = new Defense("Jordan Hicks", 58);
        String str = player.toString();
        assertTrue(str.contains("Jordan Hicks"));
    }

    @Test
    public void testDefensestrings2() {
        Defense player = new Defense("Jordan Hicks", 58);
        String str = player.toString();
        assertTrue(str.contains("58"));
    }

    @Test
    public void testDefensestrings3() {
        Defense player = new Defense("Jordan Hicks", 58);
        String str = player.toString();
        assertTrue(str.contains("Jordan Hicks"));
        assertTrue(str.contains("58"));
    }

    @Test
    public void testDefensestrings4() {
        Defense player = new Defense("Jordan Hicks", 58);
        String str = player.toString();
        assertTrue(str.contains("Jordan Hicks"));
        assertTrue(str.contains("58"));
        assertTrue(str.contains("#"));
    }

    @Test
    public void testDefensestringsPerfect() {
        Defense player = new Defense("Jordan Hicks", 58);
        String str = player.toString();
        assertTrue(str.contains("Jordan Hicks"));
        assertTrue(str.contains("58"));
        assertTrue(str.contains("Jordan Hicks #58"));
    }

}
