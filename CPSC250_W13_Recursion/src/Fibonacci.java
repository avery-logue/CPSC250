/**
 * Fibonacci with Loops and Recursion
 * 
 * @author <your name here>
 * @version 0
 *
 */
public class Fibonacci {

    /**
     * Calculates the Fibonacci value for integer
     * 
     * @param n
     *            - element in sequence
     * @return Fibonacci value of this element; return 0 if n <= 0
     */
    public static int fibLoop(int n) {
        if (n == 0) {  
            return 0;
        }
        int a = 0;
        int b = 1;
        while (n > 0) {
            int old = a;
            a = b;
            b = old + b;
            n--;
        }
        return a;     
    }

    /**
     * Calculates the Fibonacci value for integer
     * 
     * @param n
     *            - element in sequence
     * @return Fibonacci value of this element; ; return 0 if n <= 0
     */
    public static int fibRecursion(int n) {
        if (n <= 0) {
            return 0;
        }
        if (n == 1) {
            return 1;
        }
        return fibRecursion(n-1) + fibRecursion(n-2);
    }

    /**
     * Demo program
     * 
     * @param args
     *            - not used by this method
     */
    public static void main(String[] args) {
        for (int i = 0; i < 8; i++) {
            System.out.println(i + " " + fibLoop(i) + " " + fibRecursion(i));
        }
    }

}
