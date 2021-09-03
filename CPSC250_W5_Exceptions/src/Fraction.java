/**
 * Fraction
 * 
 * @author Flores + Conner
 * @version 1
 */
public class Fraction {

    /**
     * This method calculates fraction given index into divisor array
     * 
     * @param in
     *            string that we will use to convert to index
     * @return string output
     */
    public static String fractionString(String in) {
        int index;
        int y;
        double z = 0;
        int[] data = { -3, -1, 0, 2, 4 };

        String retVal = "";

        try {
            index = Integer.parseInt(in);
            y = data[index];
            z = Math.sqrt(1.0 / y);
            validateNumber(z);
        }
        
        catch (ArrayIndexOutOfBoundsException e) {
            retVal += "ERROR: " + in + " is not a valid array index";
            retVal += "\n" + String.format("Thanks for using \"printFraction\"!\n");
            return retVal;
        }
        
        catch (NumberFormatException e) {
            retVal += "ERROR: " + in + " is not a valid number";
            retVal += "\n" + String.format("Thanks for using \"printFraction\"!\n");
            return retVal;
        }
        
        catch (Exception e) {
            retVal += "ERROR: result is not a number";
            retVal += "\n" + String.format("Thanks for using \"printFraction\"!\n");
            return retVal;
        }
        
        retVal = String.format("Result = %5.3f\n", z);
        retVal += String.format("Thanks for using \"printFraction\"!\n");
        return retVal;
    }

    private static void validateNumber(double number) throws Exception {
        if (Double.isNaN(number)) {
            throw new Exception("not a number");
        }
        if (Double.isInfinite(number)) {
            throw new Exception("an infinite number");
        }
    }

    /**
     * print the string
     * 
     * @param arg
     *            string to print
     */
    public static void printFraction(String arg) {
        System.out.println(fractionString(arg));
    }

    /**
     * main for testing
     * 
     * @param args
     *            - command line arguments
     */
    public static void main(String[] args) {
        printFraction("-3");
        printFraction("0");
        printFraction("zero");
        printFraction("4");
    }
}
