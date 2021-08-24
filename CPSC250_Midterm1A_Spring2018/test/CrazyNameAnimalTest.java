import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotNull;
import static org.junit.Assert.assertTrue;

import java.lang.reflect.Constructor;
import java.lang.reflect.Field;
import java.lang.reflect.Method;
import java.lang.reflect.Modifier;

import org.junit.Test;

public class CrazyNameAnimalTest {

    @Test
    public void testConstructor() {
        CrazyNameAnimal cna = new CrazyNameAnimal("Raccoon", "Trash Panda");
        assertNotNull(cna);

        // force failure without minimal attempt
        assertTrue(cna instanceof Animal);
    }

    @Test
    public void testCNAisAnimal() {
        CrazyNameAnimal cna = new CrazyNameAnimal("Raccoon", "Trash Panda");
        assertTrue(cna instanceof Animal);
    }

    @Test
    public void testFields() {
        Field[] allFields = CrazyNameAnimal.class.getDeclaredFields();
        assertEquals(
                "CrazyNameAnimal should only have 1 field (instance variable).",
                1, allFields.length);
        assertTrue(
                "CrazyNameAnimal instance variable should NOT be public or protected.",
                Modifier.isPrivate(allFields[0].getModifiers()));

        allFields = Animal.class.getDeclaredFields();
        assertEquals(
                "Do NOT change Animal - should only have 1 field (instance variable).",
                1, allFields.length);
        assertTrue(
                "Do NOT change Animal - instance variable should NOT be public or protected.",
                Modifier.isPrivate(allFields[0].getModifiers()));

        // force failure without minimal attempt
        CrazyNameAnimal cna = new CrazyNameAnimal();
        assertTrue(cna instanceof Animal);
    }

    @Test
    public void testMethods() {
        Method[] allMethods = CrazyNameAnimal.class.getDeclaredMethods();
        assertEquals(
                "CrazyNameAnimal should only have 1 method (to output a String).",
                1, allMethods.length);
    }

    @Test
    public void testConstructors() {
        Constructor<?>[] allCons = CrazyNameAnimal.class
                .getDeclaredConstructors();
        assertEquals("CrazyNameAnimal should only have 2 constructor ().", 2,
                allCons.length);

        // force failure without minimal attempt
        CrazyNameAnimal cna = new CrazyNameAnimal();
        assertTrue(cna instanceof Animal);
    }

    @Test
    public void testCNAstrings1() {
        CrazyNameAnimal cna = new CrazyNameAnimal("Raccoon", "Trash Panda");
        String str = cna.toString();
        assertTrue(str.contains("Raccoon"));
    }

    @Test
    public void testCNAstrings2() {
        CrazyNameAnimal cna = new CrazyNameAnimal("Raccoon", "Trash Panda");
        String str = cna.toString();
        assertTrue(str.contains("Trash"));
        assertTrue(str.contains("Panda"));
    }

    @Test
    public void testCNAstrings3() {
        CrazyNameAnimal cna = new CrazyNameAnimal("Raccoon", "Trash Panda");
        String str = cna.toString();
        assertTrue(str.contains("Raccoon"));
        assertTrue(str.contains("Trash"));
        assertTrue(str.contains("Panda"));
    }

    @Test
    public void testCNAstrings4() {
        CrazyNameAnimal cna = new CrazyNameAnimal("Raccoon", "Trash Panda");
        String str = cna.toString();
        assertTrue(str.contains("Raccoon"));
        assertTrue(str.contains("Trash Panda"));
        assertTrue(str.contains("("));
        assertTrue(str.contains(")"));
    }

    @Test
    public void testCNAstringsPerfect() {
        CrazyNameAnimal cna = new CrazyNameAnimal("Raccoon", "Trash Panda");
        String str = cna.toString();
        assertTrue(str.contains("Raccoon (Trash Panda)"));
    }

}
