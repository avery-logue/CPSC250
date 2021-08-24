/**
 * Some basic issues
 *
 * @author Avery Logue
 * @version 2/1/18
 */
public class CS150Stuff {

    /**
     * Change this instance variable from `public` so that it is only accessible
     * from within the class but is accessible from any class that inherits from
     * this class. (if you forget how, leave as public to pass most tests)
     */
    protected static String string;  // @TODO - fix this so it is not public or private

    /**
     * Default constructor initialize string to say "CNU"
     */
    public CS150Stuff() {
        string = "CNU";
    }

    /**
     * One argument constructor
     *
     * @param inp
     *            set the string instance variable to this
     */
    public CS150Stuff(String inp) {
        string = inp;
    }

    /** Define a getter (accessor) named getString 
     * @return */
    public static String getString() {
    	return string;
    }

    /**
     * Define a setter (mutator) named setString that takes a String argument
     * and assigns it to the instance variable
     */
    public static void setString(String inp) {
    	string = inp;
    }

}
