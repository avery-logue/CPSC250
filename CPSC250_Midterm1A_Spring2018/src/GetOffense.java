import java.util.ArrayList;

/**
 * Write the method according to description below
 * 
 * @author <you>
 * @version 0
 *
 */
public class GetOffense {

    /**
     * getOffense takes an ArrayList of Player instances, and returns an
     * ArrayList of only Offense players
     * 
     * @param list
     *            - of player instances
     * @return ArrayList of Offense players; or null if null list
     */
    public static ArrayList<Offense> getOffense(ArrayList<Player> list) {
        if(list == null) {
            return null;
        }
        ArrayList<Offense> offense = new ArrayList<Offense>();
        for(int i = 0; i < list.size(); i ++) {
            if(list.get(i) instanceof Offense) {
                offense.add((Offense) list.get(i));
            }
        }
        return offense;

    }
}
