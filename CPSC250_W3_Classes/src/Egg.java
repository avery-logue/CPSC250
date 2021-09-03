
/**
 * Egg handles stats for a single egg using multi-dimensional Arrays and
 * ArrayLists demo for CPSC 250 Fall 2017
 * 
 * @author David Conner (david.conner@cnu.edu)
 * @version 0
 *
 */
public class Egg {

    /** Size of the egg L=Large, s=small */
    private char size;

    /** Color of the egg shell */
    private String color;

    /** Is it already boiled? */
    private boolean boiled;

    /**
     * Convert egg data to a String /**
     * 
     * @return formated string containing the egg data
     */
    public String toString() {
        return "Size(" + size + ") color(" + color + ") boiled(" + boiled
                + ")";

    }

    /**
     * Prints data for a given egg instance We will need to fix this by checking
     * for a valid reference
     * 
     * @param egg
     *            - reference to Egg instance
     */
    public static void printEgg(Egg egg) {
        if (egg == null) {
            System.out.println("Not an egg!");
            return;
        }
        
        System.out.println(egg.toString());
    }

    /**
     * Prints the list of eggs in a carton
     * 
     * @param carton
     */
    public static void printCarton(Egg[] carton) {
        if(carton == null) {
            System.out.println("Not a carton");
            return;
        }
        System.out.println(" ----------- Carton ---------");
        for (int i = 0; i < carton.length; ++i) {
            System.out.print(" " + i + " > "); // print index and leave on line
            printEgg(carton[i]);

        }
        System.out.println(" ----------------------------");
        System.out.println("");                              // Block off the
                                                             // output carton by
                                                             // carton
    }

    /**
     * Default constructor for the egg
     */
    public Egg() {
        size = 'L';
        color = "brown";
        boiled = false;
    }

    /**
     * Constructor for a specialized egg
     * 
     * @param size
     *            size of egg ('S','M','L')
     * @param color
     *            color string (e.g. "brown", "white", "blue")
     * @param boiled
     *            has the egg already been boiled?
     */
    public Egg(char size, String color, boolean boiled) {
        this.size = size;
        this.color = color;
        this.boiled = boiled;
    }

}
