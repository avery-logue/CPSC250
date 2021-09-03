/**
 * Calculate factorial using both loop and recursion
 * 
 * @author <your name here>
 * @version 0
 *
 */
public class Factorial {

    /**
     * Calculate factorial using a loop (150 style!)
     * 
     * @param n
     *            - input
     * @return n! for 0 < n < 13; or -1 if n > 12 (too big for int), or 1
     *         otherwise
     */
    public static int factorialLoop(int n) {
        int val = 1;     
        if (n > 12) {
            return -1;
        }
        if (n < 2) {
            return 1;
        }
        for (int i = 2; i <= n; i++) {
            val = val * i;
        }
        return val;
    }

/**
 * Calculate factorial using recursion (250 style!)
 * 
 * @param n
 *            - input
 * @return n! for 0 < n < 13; or -1 if n > 12 (too big for int), or 1
 *         otherwise
 */
public static int factorialRecursion(int n) {
    if (n > 12) {
        return -1;
    }
    if (n < 2) {
        return 1;
    }
    return n*factorialRecursion(n-1);
}

/**
 * Simple test program
 * 
 * @param args
 *            - not used by this method
 */
public static void main(String[] args) {
    // for (int i = 0; i < 16; i++)
    int i = 5;
    System.out.println(" " + i + "!=" + factorialLoop(i) + " "
            + factorialRecursion(i));

}

}
