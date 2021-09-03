import java.io.IOException;

/**
 * We will use this to test some different exception types
 * 
 * @author dconner
 * @version 0
 *
 */
public class Exceptions {

    /**
     * 
     * @param val
     *            number we will use to change the exception thrown
     * @return integer same as value
     * @throws Exception
     *             (and other more precise exceptions)
     */
    public static int throwSomething(int val) throws Exception {
        switch (val) {
            case 0:
                throw new IOException("Simple IO exception");
            case 1:
                throw new IllegalArgumentException("Null pointer exception");
            case 2:
                throw new MyException("My very own message");
            default:
                System.out.println("  val=" + val);
        }
        return val;
    }
}
