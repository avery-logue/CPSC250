import java.util.ArrayList;

/**
 * RecursiveMethods demo
 * 
 * @author <your name here>
 * @version 0
 *
 */
public class RecursiveMethods {

    /**
     * recursive method to find maximum in a list
     * 
     * @param list
     *            - ArrayList of Integers
     * @return the maximum within the list; Integer.MIN_VALUE if list is empty
     */
    public static int max(ArrayList<Integer> list) {
        ArrayList<Integer> copy = list;
        if (list.size() == 0) {
            return Integer.MIN_VALUE;
        }
        Integer val = copy.remove(0);
        Integer temp = max(copy);
        if (val > temp) {
            return val;
        }
        else {
            return temp;
        }
    }

    /**
     * recursive method to find sum of a list
     * 
     * @param list
     *            - ArrayList of Integers
     * @return sum of all elements; 0 if empty
     */
    public static int sum(ArrayList<Integer> list) {
        if (list.size() == 0) {
            return 0;
        }
        int val = list.remove(0);
        int sum = val + sum(list);
        list.add(0);
        return sum;
    }

    /**
     * recursive method to reverse a String
     * 
     * @param str
     *            - string to reverse
     * @return String containing letters in reverse order from input str
     */
    public static String reverse(String str) {
        if (str.length() < 2) {
            return str;
        }
        return reverse(str.substring(1)) + str.charAt(0);
    }

}
