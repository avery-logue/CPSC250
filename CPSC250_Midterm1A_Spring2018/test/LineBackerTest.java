import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotNull;
import static org.junit.Assert.assertTrue;

import java.lang.reflect.Constructor;
import java.lang.reflect.Field;
import java.lang.reflect.Method;
import java.lang.reflect.Modifier;

import org.junit.Test;

public class LineBackerTest {

    @Test
    public void testConstructor() {
        LineBacker player = new LineBacker("Jordan Hicks", 58);
        assertNotNull(player);
        assertTrue(player instanceof Player);
    }

    @Test
    public void testLineBackerisPlayer() {
        LineBacker player = new LineBacker("Jack Lambert", 58);
        assertTrue(player instanceof Player);
    }

    @Test
    public void testLineBackerisDefense() {
        LineBacker player = new LineBacker("Jack Lambert", 58);
        assertTrue(player instanceof Defense);
    }

    @Test
    public void testFields() {
        Field[] allFields = LineBacker.class.getDeclaredFields();
        assertEquals(
                "LineBacker should only have no field (instance) variables.",
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
        LineBacker player = new LineBacker("Jordan Hicks", 58);
        String str = player.toString();
        assertTrue(str.contains("Jordan Hicks"));
    }

    @Test
    public void testMethods() {
        Method[] allMethods = LineBacker.class.getDeclaredMethods();
        assertEquals("LineBacker should only have 0 method.", 0,
                allMethods.length);
        LineBacker player = new LineBacker("Jordan Hicks", 58);
        String str = player.toString();
        assertTrue(str.contains("Jordan Hicks"));
    }

    @Test
    public void testMethods2() {
        Method[] allMethods = LineBacker.class.getDeclaredMethods();
        assertEquals("LineBacker should only have 0 method.", 0,
                allMethods.length);
        LineBacker player = new LineBacker("Jordan Hicks", 58);
        String str = player.toString();
        assertTrue(str.contains("Jordan Hicks"));
    }

    @Test
    public void testConstructors2() {
        Constructor<?>[] allCons = LineBacker.class.getDeclaredConstructors();
        assertEquals("LineBacker should only have 1 constructor ().", 1,
                allCons.length);

        LineBacker player = new LineBacker("Jordan Hicks", 58);
        String str = player.toString();
        assertTrue(str.contains("Jordan Hicks"));
    }

    @Test
    public void testConstructors() {
        Constructor<?>[] allCons = LineBacker.class.getDeclaredConstructors();
        assertEquals("LineBacker should only have 1 constructor ().", 1,
                allCons.length);

        LineBacker player = new LineBacker("Jordan Hicks", 58);
        String str = player.toString();
        assertTrue(str.contains("Jordan Hicks"));
    }

    @Test
    public void testLineBackerstrings1() {
        LineBacker player = new LineBacker("Jordan Hicks", 58);
        String str = player.toString();
        assertTrue(str.contains("Jordan Hicks"));
    }

    @Test
    public void testLineBackerstrings2() {
        LineBacker player = new LineBacker("Jordan Hicks", 58);
        String str = player.toString();
        assertTrue(str.contains("58"));
    }

    @Test
    public void testLineBackerstrings3() {
        LineBacker player = new LineBacker("Jordan Hicks", 58);
        String str = player.toString();
        assertTrue(str.contains("Jordan Hicks"));
        assertTrue(str.contains("58"));
    }

    @Test
    public void testLineBackerstrings4() {
        LineBacker player = new LineBacker("Jordan Hicks", 58);
        String str = player.toString();
        assertTrue(str.contains("Jordan Hicks"));
        assertTrue(str.contains("58"));
        assertTrue(str.contains("#"));
    }

    @Test
    public void testLineBackerstringsPerfect() {
        LineBacker player = new LineBacker("Jordan Hicks", 58);
        String str = player.toString();
        assertTrue(str.contains("Jordan Hicks"));
        assertTrue(str.contains("58"));
        assertTrue(str.contains("Jordan Hicks #58"));
    }

}
