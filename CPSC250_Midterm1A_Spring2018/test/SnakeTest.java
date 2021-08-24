import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotNull;
import static org.junit.Assert.assertTrue;

import java.lang.reflect.Constructor;
import java.lang.reflect.Field;
import java.lang.reflect.Method;

import org.junit.Test;

public class SnakeTest {

    @Test
    public void testConstructor() {
        Snake cna = new Snake();
        assertNotNull(cna);
        assertTrue(cna instanceof Reptile);
    }

    @Test
    public void testSnakeisAnimal() {
        Snake cna = new Snake();
        assertTrue(cna instanceof Animal);
    }

    @Test
    public void testSnakeisCrazyNameAnimal() {
        Snake cna = new Snake();
        assertTrue(cna instanceof CrazyNameAnimal);
    }

    @Test
    public void testSnakeisReptile() {
        Snake cna = new Snake();
        assertTrue(cna instanceof Reptile);
    }

    @Test
    public void testFields() {
        Field[] allFields = Snake.class.getDeclaredFields();
        assertEquals("Snake should only have 0 fields (instance variable).", 0,
                allFields.length);

        // This should fail if we don't fix class
        Snake cna = new Snake();
        assertTrue(cna instanceof Reptile);

    }

    @Test
    public void testMethods() {
        Method[] allMethods = Snake.class.getDeclaredMethods();
        assertEquals("Snake should have 0 methods.", 0, allMethods.length);

        // This should fail if we don't fix class
        Snake cna = new Snake();
        assertTrue(cna instanceof Reptile);
    }

    @Test
    public void testMethods1() {
        Method[] allMethods = Snake.class.getDeclaredMethods();
        assertEquals("Snake should have 0 methods.", 0, allMethods.length);

        // This should fail if we don't fix class
        Snake cna = new Snake();
        String str = cna.toString();
        assertTrue(str.contains("Reptile"));
        assertTrue(cna instanceof Reptile);
    }

    @Test
    public void testMethods2() {
        Method[] allMethods = Snake.class.getDeclaredMethods();
        assertEquals("Snake should have 0 methods.", 0, allMethods.length);

        // This should fail if we don't fix class
        Snake cna = new Snake();
        String str = cna.toString();
        assertTrue(str.contains("Reptile"));
        assertTrue(cna instanceof Reptile);
    }

    @Test
    public void testMethods3() {
        Method[] allMethods = Snake.class.getDeclaredMethods();
        assertEquals("Snake should have 0 methods.", 0, allMethods.length);

        // This should fail if we don't fix class
        Snake cna = new Snake();
        String str = cna.toString();
        assertTrue(str.contains("Noodle"));
        assertTrue(cna instanceof Reptile);
    }

    @Test
    public void testMethods4() {
        Method[] allMethods = Snake.class.getDeclaredMethods();
        assertEquals("Snake should have 0 methods.", 0, allMethods.length);

        // This should fail if we don't fix class
        Snake cna = new Snake();
        String str = cna.toString();
        assertTrue(str.contains("Danger"));
        assertTrue(cna instanceof Reptile);
    }

    @Test
    public void testMethods5() {
        Method[] allMethods = Snake.class.getDeclaredMethods();
        assertEquals("Snake should have 0 methods.", 0, allMethods.length);

        // This should fail if we don't fix class
        Snake cna = new Snake();
        String str = cna.toString();
        assertTrue(str.contains("Snake"));
        assertTrue(cna instanceof Reptile);
    }

    @Test
    public void testConstructors() {
        Constructor<?>[] allCons = Snake.class.getDeclaredConstructors();
        assertEquals("Snake should only have 1 constructor ().", 1,
                allCons.length);

        // This should fail if we don't fix method
        Snake cna = new Snake();
        String str = cna.toString();
        assertTrue(str.contains("Reptile"));
        assertTrue(cna instanceof Reptile);

    }

    @Test
    public void testSnakestrings1() {
        Snake cna = new Snake();
        String str = cna.toString();
        assertTrue(str.contains("Snake"));
        assertTrue(cna instanceof Reptile);
    }

    @Test
    public void testSnakestrings2() {
        Snake cna = new Snake();
        String str = cna.toString();
        assertTrue(str.contains("Snake"));
        assertTrue(str.contains("Noodle"));
        assertTrue(cna instanceof Reptile);
    }

    @Test
    public void testSnakestrings3() {
        Snake cna = new Snake();
        String str = cna.toString();
        assertTrue(str.contains("Snake"));
        assertTrue(str.contains("Danger"));
        assertTrue(str.contains("Noodle"));
        assertTrue(cna instanceof Reptile);
    }

    @Test
    public void testSnakestrings4() {
        Snake cna = new Snake();
        String str = cna.toString();
        assertTrue(str.contains("Snake"));
        assertTrue(str.contains("Reptile"));
        assertTrue(str.contains("Danger Noodle"));
        assertTrue(str.contains("("));
        assertTrue(str.contains(")"));
        assertTrue(cna instanceof Reptile);
    }

    @Test
    public void testSnakestringsPerfect() {
        Snake cna = new Snake();
        String str = cna.toString();
        assertTrue(str.contains("Snake (Danger Noodle) Reptile"));
        assertTrue(cna instanceof Reptile);
    }

}
