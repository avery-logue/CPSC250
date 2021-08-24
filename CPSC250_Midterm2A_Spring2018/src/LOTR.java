import java.util.ArrayList;

/**
 * Class to define characters in Lord of the Rings.
 *
 */

public class LOTR {

    /**
     * Returns an array list of the following characters:
     * 
     * * "Aragorn" (Human)
     * 
     * * "Frodo" (Hobbit)
     * 
     * * "Boromir" (Human)
     * 
     * * "Legolas" (Elf)
     * 
     * * "Arwen" (Elf)
     *
     * @return array list of person instances with appropriate name and type
     */
    public static ArrayList<Person> getCharacters() {
        ArrayList<Person> list = new ArrayList<Person>();
        
        Human Aragorn = new Human("Aragorn");
        list.add(Aragorn);
        
        Hobbit Frodo = new Hobbit("Frodo");
        list.add(Frodo);
        
        Human Boromir = new Human("Boromir");
        list.add(Boromir);
        
        Elf Legolas = new Elf("Legolas");
        list.add(Legolas);
        
        Elf Arwen = new Elf("Arwen");
        list.add(Arwen);
        
        return list;
    }

    /**
     * Given array list of Person, return only the elves.
     * 
     * @param persons
     *            - array list of Persons
     * @return array list of elves only, or null if null persons Array
     */
    public static ArrayList<Elf> getElves(ArrayList<Person> persons) {
    	if (persons == null) {
    		return null;
    	}
    	
    	ArrayList <Elf> elves = new ArrayList<Elf>();
    	
    	for (int i = 0; i < persons.size(); i++) {
    		if (persons.get(i) instanceof Elf) {
    			elves.add((Elf) persons.get(i));
    		}
    	}
        return elves;
    }

}
