/**
 * This class inherits the name and number from the Player class
 * 
 * @author <you>
 * @version 0
 *
 */


public class Defense extends Player {

    /** Don't modify this constructor */
    public Defense() {
        // Default constructor
        System.out.println(
                " Defense() - If this called then something is wrong");
    }

    // @TODO - you will need 1 two argument constructor that lets you
    // set the player name and number

    public Defense(String name, int num) {
        super(name, num);

    }

    // No new instance variables or methods are needed

}
