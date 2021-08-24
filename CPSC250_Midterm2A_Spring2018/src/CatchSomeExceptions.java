import java.io.IOException;

/**
 * Class to demonstrate catching exceptions
 *
 * @author <student>
 * @version 0
 */
public class CatchSomeExceptions {

	/**
	 * Take the reference a TestException instance and call the doIt() method
	 * inside the runIt method.
	 *
	 * The runIt method should return a string as follows based on the method
	 * execution: The runIt() should not throw any exceptions.
	 *
	 * If the doIt() runs without error return "all good"
	 *
	 * If doIt() throws: a RuntimeException, return "runtime"
	 *
	 * an ArrayIndexOutOfBoundsException, return "OoB"
	 *
	 * an ArithmeticException, return "math!"
	 *
	 * an IOException, return "busted"
	 *
	 * an Exception, return "unknown"
	 *
	 * @param ref
	 *            - reference to the ThrowSome class
	 * @return string based on method execution status
	 */
	public static String runIt(TestException ref) {
		try {
			ref.doIt();
		} 
		catch (ArrayIndexOutOfBoundsException e) {
			return "Oob";
		}
		catch (ArithmeticException e) {
			return "math!";
		}
		catch (RuntimeException e) {
			return "runtime";
		}
		catch (IOException e) {
			return "busted";
		}
		catch (Exception e) {
			return "unknown";
		}
		return "all good";
	}

}
