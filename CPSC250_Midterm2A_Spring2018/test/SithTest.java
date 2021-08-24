import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertTrue;

import org.junit.Test;

public class SithTest {

    @Test
    public void test0() {
        Sith sith = new Sith("Darth Vadar");
        assertTrue("Incorrect result - Sith are (evil) people too",
                sith instanceof Person);
    }

    @Test
    public void test1() {
        Sith sith = new Sith("Darth Vadar");
        assertTrue("Incorrect result - Sith are also ForceUsers",
                sith instanceof ForceUser);
    }

    @Test
    public void test2() {
        Sith sith = new Sith("Darth Vadar");
        assertTrue("Incorrect result - Sith are people too",
                sith instanceof Person);
        assertTrue("Incorrect result - Sith are ForceUsers",
                sith instanceof ForceUser);
    }

    @Test
    public void test3() {
        Sith sith = new Sith("Darth Vadar");
        String name = sith.getName();
        String color = sith.lightSaberColor();
        assertEquals("Incorrect result", "Darth Vadar", name);
        assertEquals("Incorrect result", "red", color);
    }

    @Test
    public void testKylo() {
        Sith sith = new Sith("Kylo Ren");
        String name = sith.getName();
        String color = sith.lightSaberColor();
        assertEquals("Incorrect result", "Kylo Ren", name);
        assertEquals("Incorrect result", "red", color);
    }

    @Test
    public void testDooku() {
        Sith sith = new Sith("Dooku");
        String name = sith.getName();
        String color = sith.lightSaberColor();
        assertEquals("Incorrect result", "Dooku", name);
        assertEquals("Incorrect result", "red", color);
    }

}
