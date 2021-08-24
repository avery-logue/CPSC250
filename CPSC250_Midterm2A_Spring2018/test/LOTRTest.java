import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotNull;
import static org.junit.Assert.assertNull;
import static org.junit.Assert.assertTrue;

import java.util.ArrayList;

import org.junit.Test;

public class LOTRTest {

    @Test
    public void test5() {
        ArrayList<Person> persons = LOTR.getCharacters();
        // get one point for simply creating a valid array list
        assertNotNull("Incorrect result", persons);
    }

    @Test
    public void test6() {
        ArrayList<Person> persons = LOTR.getCharacters();
        assertNotNull("Incorrect result", persons);
        assertTrue(persons.contains(new Person("Aragorn")));
        int index = persons.indexOf(new Person("Aragorn"));
        Person person = persons.get(index);
        assertTrue(person instanceof Human);
    }

    @Test
    public void test7() {
        ArrayList<Person> persons = LOTR.getCharacters();
        assertNotNull("Incorrect result", persons);
        assertTrue(persons.contains(new Person("Arwen")));
        int index = persons.indexOf(new Person("Arwen"));
        Person person = persons.get(index);
        assertTrue(person instanceof Elf);
    }

    @Test
    public void test8() {
        ArrayList<Person> persons = LOTR.getCharacters();
        assertNotNull("Incorrect result", persons);
        assertTrue(persons.contains(new Person("Frodo")));
        int index = persons.indexOf(new Person("Frodo"));
        Person person = persons.get(index);
        assertTrue(person instanceof Hobbit);
    }

    @Test
    public void testCharactersInOrder() {
        ArrayList<Person> persons = LOTR.getCharacters();
        assertNotNull("Incorrect result", persons);
        assertEquals("Aragorn", persons.get(0).getName());
        assertTrue(persons.get(0) instanceof Human);
        assertEquals("Frodo", persons.get(1).getName());
        assertTrue(persons.get(1) instanceof Hobbit);
        assertEquals("Boromir", persons.get(2).getName());
        assertTrue(persons.get(2) instanceof Human);
        assertEquals("Legolas", persons.get(3).getName());
        assertTrue(persons.get(3) instanceof Elf);
        assertEquals("Arwen", persons.get(4).getName());
        assertTrue(persons.get(4) instanceof Elf);
        assertEquals(5, persons.size());
    }

    @Test
    public void test10() {
        ArrayList<Elf> elves = LOTR.getElves(new ArrayList<Person>());
        // get one point for simply creating a valid array list
        assertNotNull(
                "No elves in empty list, but empty list should be returned",
                elves);
        elves = LOTR.getElves(null);
        assertNull("Return null array if given null", elves);
    }

    @Test
    public void test11() {
        ArrayList<Person> persons = new ArrayList<Person>();
        persons.add(new Human("A")); // yeah I'm giving away solution to one,
                                     // but
        persons.add(new Elf("B"));   // good on you for looking at the JUNit
        ArrayList<Elf> elves = LOTR.getElves(persons);
        // get one point for simply creating a valid array list
        assertNotNull("One elf should be returned", elves);
        assertEquals(1, elves.size());
    }

    @Test
    public void test12() {
        ArrayList<Person> persons = new ArrayList<Person>();
        persons.add(new Human("A")); // yeah I'm giving away solution to one,
                                     // but
        persons.add(new Elf("B"));   // good on you for looking at the JUNit
        persons.add(new Human("AA")); // yeah I'm giving away solution to one,
                                      // but
        persons.add(new Elf("BB"));   // good on you for looking at the JUNit
        ArrayList<Elf> elves = LOTR.getElves(persons);
        // get one point for simply creating a valid array list
        assertNotNull("Two elves should be returned", elves);
        assertEquals(2, elves.size());
        assertEquals("B", elves.get(0).getName());
        assertEquals("BB", elves.get(1).getName());
    }

    @Test
    public void test13() {
        // Repeated test for getting point balance correct
        ArrayList<Person> persons = new ArrayList<Person>();
        persons.add(new Elf("B"));
        persons.add(new Elf("BB"));
        ArrayList<Elf> elves = LOTR.getElves(persons);
        // get one point for simply creating a valid array list
        assertNotNull("Two elves should be returned", elves);
        assertEquals(2, elves.size());
        assertEquals("B", elves.get(0).getName());
        assertEquals("BB", elves.get(1).getName());
    }

    @Test
    public void test14() {
        // Repeated test for getting point balance correct
        ArrayList<Person> persons = new ArrayList<Person>();
        persons.add(new Human("A"));
        persons.add(new Human("AA"));
        ArrayList<Elf> elves = LOTR.getElves(persons);
        // get one point for simply creating a valid array list
        assertNotNull("No elves, but empty list should be returned", elves);
        assertEquals(0, elves.size());
    }

}
