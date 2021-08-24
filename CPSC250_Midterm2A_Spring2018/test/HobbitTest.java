import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotNull;
import static org.junit.Assert.assertTrue;

import org.junit.Test;

public class HobbitTest {

    @Test
    public void test1() {
        Hobbit hob = new Hobbit("Sam");
        assertNotNull(hob);
        assertTrue("Incorrect result - Hobbits are Persons too",
                hob instanceof Person);
    }

    @Test
    public void test4() {
        Hobbit hob = new Hobbit("Sam");
        assertNotNull(hob);
        assertEquals(" name not set properly", "Sam", hob.getName());
    }

}
