import java.util.Scanner;

/**
 * Class to process line of text given as single string
 *
 */

public class CalculateString {

    /**
     * Process a line of text with either a ADD or MULTIPLY command and two or
     * more numeric values. Numbers are delimited by either comma, tab, or
     * space.
     *
     * @param string
     *            - line of text to process
     * @return output of command returned as int if invalid command or not
     *         integer data return null
     */
    public static Integer calculate(String string) {
        if (string == null) {
            return null;
        }
        Scanner linescan = new Scanner(string);
        linescan.useDelimiter(",|\t| ");
        String s = linescan.next();

        if(s.equalsIgnoreCase("ADD")) {
            Integer sum = 0;
            if (!linescan.hasNext()) {
                linescan.close();
                return null;
            }
            while(linescan.hasNext()) {
                if (!linescan.hasNextInt()) {
                    linescan.close();
                    return null;
                }
                else {
                    sum += linescan.nextInt();
                }
            }
            linescan.close();
            return sum;
        }
        if(s.equalsIgnoreCase("MULTIPLY")) {
            Integer product = 1;
            if (!linescan.hasNext()) {
                linescan.close();
                return null;
            }
            while(linescan.hasNext()) {
                if (!linescan.hasNextInt()) {
                    linescan.close();
                    return null;
                }
                else {
                    product *= linescan.nextInt();
                }
            }
            linescan.close();
            return product;
        }
        linescan.close();
        return null;
    }
}
