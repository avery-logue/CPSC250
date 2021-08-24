
import static org.junit.Assert.assertArrayEquals;
import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNull;

import java.util.ArrayList;

import org.junit.Test;

/**
 * Test class for GetOffense
 * 
 * @author previous 250 instructors
 * @version 1
 *
 */
public class GetOffenseTest {

    /** Test with offense */
    @Test
    public void testGetOffenseWithNoOffense() {
        ArrayList<Player> list = new ArrayList<Player>();
        list.add(new LineBacker("Jack Lambert", 58));
        list.add(new Defense("Bruce Smith", 76));
        list.add(new Defense("Cam Chancellor", 58));

        ArrayList<Offense> actual = GetOffense.getOffense(list);

        assertEquals("Incorrect result", 0, actual.size());
    }

    /** Test with some offense */
    @Test
    public void testGetOffensesWithSeveralOffenses() {
        ArrayList<Player> list = new ArrayList<Player>();

        list.add(new LineBacker("Jack Lambert", 58));
        list.add(new Defense("Bruce Smith", 76));
        list.add(new Defense("Cam Chancellor", 58));
        list.add(new QuarterBack("Big Ben", 7));
        list.add(new Offense("Stallworth", 82));
        list.add(new Offense("Swann", 88));
        list.add(new QuarterBack("Foles", 9));
        list.add(new Defense("Bruce Smith", 76));
        list.add(new QuarterBack("Some guy in New England", 12));

        ArrayList<Offense> actual = GetOffense.getOffense(list);
        assertEquals("Incorrect result", 5, actual.size());
    }

    /** Test with empty list */
    @Test
    public void testGetOffensesWithEmptyList() {
        ArrayList<Player> list = new ArrayList<Player>();

        ArrayList<Offense> actual = GetOffense.getOffense(list);

        assertEquals("Incorrect result", 0, actual.size());
    }

    /** Test with no list */
    @Test
    public void testGetOffensesWithNullList() {
        ArrayList<Offense> actual = GetOffense.getOffense(null);

        assertNull("Incorrect result", actual);

        // Force failure without minimal attempt
        ArrayList<Player> list = new ArrayList<Player>();

        actual = GetOffense.getOffense(list);
        assertEquals("Incorrect result", 0, actual.size());

    }

    /** Test with some offense */
    @Test
    public void testGetOffensesWithSeveralOffenses2() {
        ArrayList<Player> list = new ArrayList<Player>();

        list.add(new LineBacker("Jack Lambert", 58));
        list.add(new Defense("Bruce Smith", 76));
        list.add(new Defense("Cam Chancellor", 58));
        list.add(new QuarterBack("Big Ben", 7));
        list.add(new Offense("Stallworth", 82));
        list.add(new Offense("Swann", 88));
        list.add(new QuarterBack("Foles", 9));
        list.add(new Defense("Bruce Smith", 76));
        list.add(new QuarterBack("Some guy in New England", 12));
        list.add(new LineBacker("Jack Lambert", 58));
        list.add(new Defense("Bruce Smith", 76));
        list.add(new Defense("Cam Chancellor", 58));
        list.add(new QuarterBack("Big Ben", 7));
        list.add(new Offense("Stallworth", 82));
        list.add(new Offense("Swann", 88));
        list.add(new QuarterBack("Foles", 9));
        list.add(new Defense("Bruce Smith", 76));
        list.add(new QuarterBack("Some guy in New England", 12));

        ArrayList<Offense> actual = GetOffense.getOffense(list);
        assertEquals("Incorrect result", 10, actual.size());
    }

    @Test
    public void testGetOffensesWithAllOffenses() {
        ArrayList<Player> list = new ArrayList<Player>();

        list.add(new QuarterBack("Big Ben", 7));
        list.add(new QuarterBack("Foles", 9));
        list.add(new QuarterBack("Brady", 12));

        ArrayList<Offense> actual = GetOffense.getOffense(list);
        assertEquals("Incorrect result", 3, actual.size());
    }

    @Test
    public void testGetOffensesWithSeveralOffensesExact() {
        ArrayList<Player> list = new ArrayList<Player>();

        list.add(new LineBacker("Jack Lambert", 58));
        list.add(new Defense("Bruce Smith", 76));
        list.add(new Defense("Cam Chancellor", 58));
        list.add(new QuarterBack("Big Ben", 7));
        list.add(new Offense("Stallworth", 82));
        list.add(new Offense("Swann", 88));
        list.add(new QuarterBack("Foles", 9));
        list.add(new Defense("Bruce Smith", 76));
        list.add(new QuarterBack("Some guy in New England", 12));

        ArrayList<Offense> expected = new ArrayList<Offense>();
        expected.add((Offense) list.get(3));
        expected.add((Offense) list.get(4));
        expected.add((Offense) list.get(5));
        expected.add((Offense) list.get(6));
        expected.add((Offense) list.get(8));

        ArrayList<Offense> actual = GetOffense.getOffense(list);
        assertEquals("Incorrect result", 5, actual.size());
        assertArrayEquals(expected.toArray(), actual.toArray());
    }

}
