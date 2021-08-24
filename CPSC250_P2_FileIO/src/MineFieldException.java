/**
 * 
 * This should be a runtime exception that contains a message saying what the
 * error was.
 * 
 * @author William Dzubak
 * @author Avery Logue
 * @version 3/14/18
 *
 */
public class MineFieldException extends RuntimeException {

    /**
     * MineFieldException
     */
    MineFieldException() {
        super();
    }

    /**
     * MineFieldException
     * 
     * @param m
     *            the message
     */
    MineFieldException(String m) {
        super(m);
    }

}