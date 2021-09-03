/**
 *  This code does something lol
 * @author Avery Logue
 * @version 1/16/2018
 *
 */
public class BadCode {

    private final static int MAXCOUNT = 10;
    private int count;
    private String name;

    /**
     * Default constructor
     */
    public BadCode() {
        name = "negative 1";
        count = -1;
    }

    /**
     * Constructor
     * @param num the number you want
     * @param person the string you want
     */
    public BadCode(int num, String person) {
        count = num; // use this reference to disambiguate
        name = person;       // use different variable names
    }

    /**
     * This method gets the count and returns it
     * @return count
     */

    public int getCount() {
        return count;
    }

    /**
     * This gets the name and returns it
     * @return name
     */

    public String getName() {
        return name;
    }

    /**
     * This method sets name to newName
     * @param newName new string for name
     */

    public void setName(String newName) {
        name = newName;
    }

    /**
     * This sets count to cnt
     * @param cnt number going into count
     */
    public void setCount(int cnt) {
        count = cnt;
    }

    /**
     *  This prints out numbers with brackets
     * @param args arguments
     */
    public static void main(String[] args) {
        BadCode[] array = new BadCode[MAXCOUNT];

        array[0] = new BadCode();
        array[1] = new BadCode();
        array[1].setCount(1);
        array[1].setName("one");

        for (int i = 2; i < MAXCOUNT; i++) {
            array[i] = new BadCode(i, String.valueOf(i));
        }

        for (int i = 0; i < MAXCOUNT; i++) {
            System.out.println(" " + i + ">" + array[i].count + " - <"
                    + array[i].getName() + ">");
        }
    }

}
