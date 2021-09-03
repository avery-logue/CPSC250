import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotNull;

import org.junit.Test;

/**
 * 
 * @author dconner
 * @version 0
 */
public class EggTest {

    /** test */
    @Test
    public void testDefault() {
        Egg egg = new Egg();
        assertNotNull("created egg using default", egg);
        assertEquals("output check", "Size(L) color(brown) boiled(false)",
                egg.toString());
    }

    /** test */
    @Test
    public void testArgCons() {
        Egg egg = new Egg('s', "blue", true);
        assertNotNull("created egg using default", egg);
        assertEquals("output check", "Size(s) color(blue) boiled(true)",
                egg.toString());
        Egg.printEgg(egg); // test static that calls toString;
    }

    /** test */
    @Test
    public void testCarton() {
        Egg[] carton = new Egg[2];
        carton[0] = new Egg('s', "blue", true);
        carton[1] = new Egg();
        assertNotNull("created egg0 ", carton[0]);
        assertNotNull("created egg1 ", carton[1]);
        Egg.printCarton(carton); // call the static method

    }

    /** test */
    @Test
    public void testPrintEggNull() {
        Egg.printEgg(null); // call the static method

    }

    /** test */
    @Test
    public void testPrintCartonNull() {
        Egg.printCarton(null); // call the static method

    }

}
