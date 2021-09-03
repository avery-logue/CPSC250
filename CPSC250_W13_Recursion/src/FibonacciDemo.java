/**
 * Fibonacci with Loops and Recursion
 * 
 * @author <your name here>
 * @version 0
 *
 */
public class FibonacciDemo {

    public static int loopCount = 0;
    public static int recCount = 0;

    /**
     * Calculates the Fibonacci value for integer
     * 
     * @param n
     *            - element in sequence
     * @return Fibonacci value of this element; return 0 if n <= 0
     */
    public static int fibLoop(int n) {
        int a = 0;
        int b = 1;
        while (n > 0) {
            int oldA = a;
            a = b;
            b = oldA + b;
            --n;
            ++loopCount;
        }
        return a;

    }

    public static void printLevel(int level, String str) {
        for (int i = 0; i < level; i++)
            System.out.print("\t");
        System.out.println(" l(" + level + ") r(" + recCount + ")  >" + str);
    }

    /**
     * Calculates the Fibonacci value for integer
     * 
     * @param n
     *            - element in sequence
     * @return Fibonacci value of this element; ; return 0 if n <= 0
     */
    public static int fibRecursion(int n, int level) {
        recCount++;
        if (n < 1) {
            printLevel(level, " fibR(" + n + ")");
            return 0;
        }

        if (n == 1) {
            printLevel(level, " fibR(" + n + ")");
            return 1;
        }
        printLevel(level, String.format("fibR(%d) = fibR(%d) + fibR(%d)", n,
                n - 1, n - 2));
        int a = fibRecursion(n - 1, level + 1);
        int b = fibRecursion(n - 2, level + 1);
        printLevel(level, String.format(" fibR(%d) = %d + %d", n, a, b));
        return a + b;
    }

    /**
     * Demo program
     * 
     * @param args
     *            - not used by this method
     */
    public static void main(String[] args) {
        for (int i = 8; i < 9; i++) {
            // Reset counters for each top level call
            recCount = 0;
            loopCount = 0;

            System.out.println(i + " " + fibLoop(i) + " (" + loopCount + ") "
                    + fibRecursion(i, 0) + " (" + recCount + ") ");
        }
    }

}
