import java.io.IOException;

/**
 * Class used to throw different exceptions The JUnit test will define the
 * instance, but you will execute the throwSomething method in your code. Your
 * code must handle the exceptions (if any) and return the designated string.
 *
 * @author 250 instructor
 * @version 0
 */
public final class TestException {
    private int value;

    public TestException(int _value) {
        value = _value;
    }

    public void doIt() throws IOException, Exception {
        if (value < 0) {
            if (value % 2 == 0) {
                throw new RuntimeException();
            }
            else {
                throw new ArrayIndexOutOfBoundsException();
            }
        }
        else if (value > 0) {
            if (value % 2 == 0) {
                throw new ArithmeticException();
            }
            else {
                if (value % 3 == 0) {
                    throw new IOException();
                }
                else if (value % 5 == 0) {
                    throw new Exception();
                }
            }
        }

    }
}
