
/**
 * Get a number using GUI
 *
 * @author dconner
 * @version 0
 *
 */
import javax.swing.JOptionPane;

public class ExceptionDemo {

	/**
	 *
	 * @return
	 * @throws Exception
	 */
	//know all of the examples for the second midterm
	public static int getNumber() {
		String s = JOptionPane.showInputDialog(null, "Enter an integer");
//		 if (s == null) {
//		 // Almost but not quite
//		 System.out.println(" User canceled - return now!");
//		 }
		try {
			System.out.println(" As string it was <" + s.toString() + ">");
			int n = Integer.parseInt(s);
			JOptionPane.showMessageDialog(null, "The number is " + n);
			return n;
		}
		catch (NumberFormatException e) {
			System.out.println("NumberFormatException e = "+e.getMessage());
			return 0;
		}
		catch (NullPointerException e) {
			System.out.println("NullPointerException e = "+e.getMessage());
			return 420;
		}
		catch (Exception e) {
			System.out.println("Exception e = "+e.getMessage());
			return 0;
		}
	}

	/** Invoke the demo */
	public static void main(String[] args) {
		int val = ExceptionDemo.getNumber();
		System.out.println(" Your number is " + val);
	}

}
