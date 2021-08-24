import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotNull;
import static org.junit.Assert.assertTrue;

import java.lang.reflect.Constructor;
import java.lang.reflect.Field;
import java.lang.reflect.Method;

import org.junit.Test;

public class RaccoonTest {

    @Test
    public void testConstructor() {
        Raccoon cna = new Raccoon();
        assertNotNull(cna);
        assertTrue(cna instanceof Animal);
    }

    @Test
    public void testRaccoonisAnimal() {
        Raccoon cna = new Raccoon();
        assertTrue(cna instanceof Animal);
    }

    @Test
    public void testRaccoonisCrazyNameAnimal() {
        Raccoon cna = new Raccoon();
        assertTrue(cna instanceof CrazyNameAnimal);
    }

    @Test
    public void testRaccoonisMammal() {
        Raccoon cna = new Raccoon();
        assertTrue(cna instanceof Mammal);
    }

    @Test
    public void testFields() {
        Field[] allFields = Raccoon.class.getDeclaredFields();
        assertEquals("Raccoon should only have 0 fields (instance variable).",
                0, allFields.length);

        // fail test unless complete
        Raccoon cna = new Raccoon();
        String str = cna.toString();
        assertTrue(str.contains("Raccoon"));
        assertTrue(cna instanceof Animal);
    }

    @Test
    public void testMethods1() {
        Method[] allMethods = Raccoon.class.getDeclaredMethods();
        assertEquals("Raccoon should have 0 methods.", 0, allMethods.length);

        // fail test unless complete
        Raccoon cna = new Raccoon();
        String str = cna.toString();
        assertTrue(str.contains("Raccoon"));
        assertTrue(cna instanceof Animal);

    }

    @Test
    public void testMethods2() {
        Method[] allMethods = Raccoon.class.getDeclaredMethods();
        assertEquals("Raccoon should have 0 methods.", 0, allMethods.length);

        // fail test unless complete
        Raccoon cna = new Raccoon();
        String str = cna.toString();
        assertTrue(str.contains("Raccoon"));
        assertTrue(cna instanceof Animal);

    }

    @Test
    public void testMethods3() {
        Method[] allMethods = Raccoon.class.getDeclaredMethods();
        assertEquals("Raccoon should have 0 methods.", 0, allMethods.length);

        // fail test unless complete
        Raccoon cna = new Raccoon();
        String str = cna.toString();
        assertTrue(str.contains("Mammal"));

    }

    @Test
    public void testMethods4() {
        Method[] allMethods = Raccoon.class.getDeclaredMethods();
        assertEquals("Raccoon should have 0 methods.", 0, allMethods.length);

        // fail test unless complete
        Raccoon cna = new Raccoon();
        String str = cna.toString();
        assertTrue(str.contains("Panda"));

    }

    @Test
    public void testMethods5() {
        Method[] allMethods = Raccoon.class.getDeclaredMethods();
        assertEquals("Raccoon should have 0 methods.", 0, allMethods.length);

        // fail test unless complete
        Raccoon cna = new Raccoon();
        String str = cna.toString();
        assertTrue(str.contains("Trash"));

    }

    @Test
    public void testConstructors() {
        Constructor<?>[] allCons = Raccoon.class.getDeclaredConstructors();
        assertEquals("Raccoon should only have 1 constructor ().", 1,
                allCons.length);
        // fail test unless complete
        Raccoon cna = new Raccoon();
        String str = cna.toString();
        assertTrue(str.contains("Raccoon"));
        assertTrue(cna instanceof Animal);
    }

    @Test
    public void testRaccoonstrings1() {
        Raccoon cna = new Raccoon();
        String str = cna.toString();
        assertTrue(str.contains("Raccoon"));
        assertTrue(cna instanceof Animal);
    }

    @Test
    public void testRaccoonstrings2() {
        Raccoon cna = new Raccoon();
        String str = cna.toString();
        assertTrue(str.contains("Raccoon"));
        assertTrue(str.contains("Panda"));
        assertTrue(cna instanceof Animal);
    }

    @Test
    public void testRaccoonstrings3() {
        Raccoon cna = new Raccoon();
        String str = cna.toString();
        assertTrue(str.contains("Raccoon"));
        assertTrue(str.contains("Trash"));
        assertTrue(str.contains("Panda"));
    }

    @Test
    public void testRaccoonstrings4() {
        Raccoon cna = new Raccoon();
        String str = cna.toString();
        assertTrue(str.contains("Raccoon"));
        assertTrue(str.contains("Mammal"));
        assertTrue(str.contains("Trash Panda"));
        assertTrue(str.contains("("));
        assertTrue(str.contains(")"));
    }

    @Test
    public void testRaccoonstringsPerfect() {
        Raccoon cna = new Raccoon();
        String str = cna.toString();
        assertTrue(str.contains("Raccoon (Trash Panda) Mammal"));
    }

}
