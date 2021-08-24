// Given code - do NOT change!
public class Player {

    private String playerName; // leave these as private!
    private int playerNumber;  // leave these as private!

    /** Don't modify this constructor */
    public Player() {
        // Default constructor
        System.out
                .println(" Player() - If this called then something is wrong");
    }

    /**
     * Set the private data for the player
     * 
     * @param name
     *            - player's name
     * @param number
     *            - player's jersey number
     */
    public Player(String name, int number) {
        playerName = name;
        playerNumber = number;
    }

    @Override
    public String toString() {
        return playerName + " #" + playerNumber;
    }

}
