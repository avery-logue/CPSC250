import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotNull;
import static org.junit.Assert.assertTrue;

import java.lang.reflect.Constructor;
import java.lang.reflect.Field;
import java.lang.reflect.Method;

import org.junit.Test;

public class MammalTest {

    @Test
    public void testConstructor() {
        Mammal cna = new Mammal("Raccoon", "Trash Panda");
        assertNotNull(cna);
        assertTrue(cna instanceof CrazyNameAnimal);
    }

    @Test
    public void testMammalisAnimal() {
        Mammal cna = new Mammal("Raccoon", "Trash Panda");
        assertTrue(cna instanceof Animal);
    }

    @Test
    public void testMammalisCrazyNameAnimal() {
        Mammal cna = new Mammal("Raccoon", "Trash Panda");
        assertTrue(cna instanceof CrazyNameAnimal);
    }

    @Test
    public void testFields() {
        Field[] allFields = Mammal.class.getDeclaredFields();
        assertEquals("Mammal should only have 0 fields (instance variable).",
                0, allFields.length);
        // Force a basic test to fail it no changes made
        Mammal cna = new Mammal("squirrel", "tree rat");
        assertTrue(cna instanceof CrazyNameAnimal);
    }

    @Test
    public void testMethods() {
        Method[] allMethods = Mammal.class.getDeclaredMethods();
        assertEquals("Mammal should only have 1 method (to output a String).",
                1, allMethods.length);
        // Force a basic test to fail it no changes made
        Mammal cna = new Mammal("squirrel", "tree rat");
        assertTrue(cna instanceof CrazyNameAnimal);
    }

    @Test
    public void testConstructors() {
        Constructor<?>[] allCons = Mammal.class.getDeclaredConstructors();
        assertEquals("Mammal should only have 2 constructor ().", 2,
                allCons.length);
        // Force a basic test to fail it no changes made
        Mammal cna = new Mammal("squirrel", "tree rat");
        assertTrue(cna instanceof CrazyNameAnimal);
    }

    @Test
    public void testMammalstrings1() {
        Mammal cna = new Mammal("Raccoon", "Trash Panda");
        String str = cna.toString();
        assertTrue(str.contains("Mammal"));
        assertTrue(cna instanceof CrazyNameAnimal);
    }

    @Test
    public void testMammalstrings2() {
        Mammal cna = new Mammal("Raccoon", "Trash Panda");
        String str = cna.toString();
        assertTrue(str.contains("Mammal"));
        assertTrue(str.contains("Panda"));
    }

    @Test
    public void testMammalstrings3() {
        Mammal cna = new Mammal("Raccoon", "Trash Panda");
        String str = cna.toString();
        assertTrue(str.contains("Mammal"));
        assertTrue(str.contains("Raccoon"));
        assertTrue(str.contains("Trash"));
        assertTrue(str.contains("Panda"));
    }

    @Test
    public void testMammalstrings4() {
        Mammal cna = new Mammal("Raccoon", "Trash Panda");
        String str = cna.toString();
        assertTrue(str.contains("Mammal"));
        assertTrue(str.contains("Raccoon"));
        assertTrue(str.contains("Trash Panda"));
        assertTrue(str.contains("("));
        assertTrue(str.contains(")"));
    }

    @Test
    public void testMammalstringsPerfect() {
        Mammal cna = new Mammal("Raccoon", "Trash Panda");
        String str = cna.toString();
        assertTrue(str.contains("Raccoon (Trash Panda) Mammal"));
    }

}
