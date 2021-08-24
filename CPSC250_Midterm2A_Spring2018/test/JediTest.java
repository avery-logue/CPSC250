import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertTrue;

import org.junit.Test;

public class JediTest {

    @Test
    public void test0() {
        Jedi jedi = new Jedi("Luke Skywalker", "blue");
        assertTrue("Incorrect result - Jedi are people too",
                jedi instanceof Person);
    }

    @Test
    public void test1() {
        Jedi jedi = new Jedi("Luke Skywalker", "blue");
        assertTrue("Incorrect result - Jedi are also ForceUsers",
                jedi instanceof ForceUser);
    }

    @Test
    public void test2() {
        Jedi jedi = new Jedi("Luke Skywalker", "blue");
        assertTrue("Incorrect result - Jedi are people too",
                jedi instanceof Person);
        assertTrue("Incorrect result - Jedi are ForceUsers",
                jedi instanceof ForceUser);
    }

    @Test
    public void test3() {
        Jedi jedi = new Jedi("Obiwan Kenobi", "blue");
        String name = jedi.getName();
        String color = jedi.lightSaberColor();
        assertEquals("Incorrect result", "Obiwan Kenobi", name);
        assertEquals("Incorrect result", "blue", color);
    }

    @Test
    public void testYoda() {
        Jedi jedi = new Jedi("Yoda", "green");
        String name = jedi.getName();
        String color = jedi.lightSaberColor();
        assertEquals("Incorrect result", "Yoda", name);
        assertEquals("Incorrect result", "green", color);
    }

    @Test
    public void testRey() {
        Jedi jedi = new Jedi("Rey", "blue");
        String name = jedi.getName();
        String color = jedi.lightSaberColor();
        assertEquals("Incorrect result", "Rey", name);
        assertEquals("Incorrect result", "blue", color);
    }

}
