import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotNull;
import static org.junit.Assert.assertTrue;

import org.junit.Test;

public class ElfTest {

    @Test
    public void test2() {
        Elf elf = new Elf("Galadriel");
        assertNotNull(elf);
        assertTrue("Incorrect result - Elves are Persons too",
                elf instanceof Person);
        assertEquals(" name not set properly", "Galadriel", elf.getName());
    }

}
