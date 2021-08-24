/**
 * This class inherits the name and number from the Player class
 * 
 * @author <you>
 * @version 0
 *
 */

// @TODO - fix this so that it "is a" Player
public class Offense extends Player {

    /** Don't modify this constructor */
    public Offense() {
        // Default constructor
        System.out.println(
                " Offense() - If this called then something is wrong");
    }

    // @TODO - you will need 1 two argument constructor that lets you
    // set the player name and number
    public Offense(String name, int num) {
    	 super(name, num);
    }

    // No new instance variable are needed

}
