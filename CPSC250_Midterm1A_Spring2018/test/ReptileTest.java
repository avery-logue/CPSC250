import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotNull;
import static org.junit.Assert.assertTrue;

import java.lang.reflect.Constructor;
import java.lang.reflect.Field;
import java.lang.reflect.Method;

import org.junit.Test;

public class ReptileTest {

    @Test
    public void testConstructor() {
        Reptile cna = new Reptile("Turtle", "Yertle");
        assertNotNull(cna);
        assertTrue(cna instanceof Animal);
    }

    @Test
    public void testReptileisAnimal() {
        Reptile cna = new Reptile("Turtle", "Yertle");
        assertTrue(cna instanceof Animal);
    }

    @Test
    public void testReptileisCrazyNameAnimal() {
        Reptile cna = new Reptile("Turtle", "Yertle");
        assertTrue(cna instanceof CrazyNameAnimal);
    }

    @Test
    public void testFields() {
        Field[] allFields = Reptile.class.getDeclaredFields();
        assertEquals("Reptile should only have 0 fields (instance variable).",
                0, allFields.length);

        // Force a basic test to fail it no changes made
        Reptile cna = new Reptile("Turtle", "Yertle");
        assertTrue(cna instanceof CrazyNameAnimal);
    }

    @Test
    public void testMethods() {
        Method[] allMethods = Reptile.class.getDeclaredMethods();
        assertEquals("Reptile should only have 1 method (to output a String).",
                1, allMethods.length);
        // Force a basic test to fail it no changes made
        Reptile cna = new Reptile("Turtle", "Yertle");
        assertTrue(cna instanceof CrazyNameAnimal);
    }

    @Test
    public void testConstructors() {
        Constructor<?>[] allCons = Reptile.class.getDeclaredConstructors();
        assertEquals("Reptile should only have 2 constructor ().", 2,
                allCons.length);
        // Force a basic test to fail it no changes made
        Reptile cna = new Reptile("Turtle", "Yertle");
        assertTrue(cna instanceof CrazyNameAnimal);
    }

    @Test
    public void testReptilestrings1() {
        Reptile cna = new Reptile("Turtle", "Yertle");
        String str = cna.toString();
        assertTrue(str.contains("Reptile"));
        assertTrue(cna instanceof Animal);
    }

    @Test
    public void testReptilestrings2() {
        Reptile cna = new Reptile("Turtle", "Yertle");
        String str = cna.toString();
        assertTrue(str.contains("Reptile"));
        assertTrue(str.contains("Yertle"));
    }

    @Test
    public void testReptilestrings3() {
        Reptile cna = new Reptile("Turtle", "Yertle");
        String str = cna.toString();
        assertTrue(str.contains("Reptile"));
        assertTrue(str.contains("Turtle"));
        assertTrue(str.contains("Yertle"));
    }

    @Test
    public void testReptilestrings4() {
        Reptile cna = new Reptile("Turtle", "Yertle");
        String str = cna.toString();
        assertTrue(str.contains("Reptile"));
        assertTrue(str.contains("Turtle"));
        assertTrue(str.contains("Yertle"));
        assertTrue(str.contains("("));
        assertTrue(str.contains(")"));
    }

    @Test
    public void testReptilestringsPerfect() {
        Reptile cna = new Reptile("Turtle", "Yertle");
        String str = cna.toString();
        assertTrue(str.contains("Turtle (Yertle) Reptile"));
    }

}
