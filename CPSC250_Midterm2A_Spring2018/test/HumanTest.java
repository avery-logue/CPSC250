import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotNull;
import static org.junit.Assert.assertTrue;

import org.junit.Test;

public class HumanTest {

    @Test
    public void test0() {
        Human hum = new Human("Aragorn");
        assertNotNull(hum);
        assertTrue("Incorrect result - Humans are Persons too",
                hum instanceof Person);
    }

    @Test
    public void test3() {
        Human hum = new Human("Aragorn");
        assertNotNull(hum);
        assertTrue("Incorrect result - Humans are Persons too",
                hum instanceof Person);
        assertEquals(" name not set properly", "Aragorn", hum.getName());
    }

}
