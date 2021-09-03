/**
 * Create a custom exception
 * 
 * @author student
 * @version 0
 */
public class MyException extends RuntimeException {
    /**
     * Constructor
     * 
     */
    MyException() {
        super();
    }
    /**
     * Constructor with message
     * 
     * @param msg
     *            Message string
     */
    MyException(String msg) {
        super(msg);
    }
}
