/**
 * Recursion file
 * 
 * @author <Your name here>
 * @version 0
 *
 */
public class RecursionB {

    /**
     * Write a function `calcSeq` that returns the value of a sequence at a
     * given index. The sequence is defined as the prior element minus the
     * second and third prior elements .
     * 
     * The 0th element returns 0, element 1 returns 1, and element 2 returns 2.
     * The calculation for element 3 returns 1 (i.e. 2-1-0=1)
     *
     * The first seven elements are:
     * 
     * element: 0 1 2 3 4 5 6 7 ...
     *
     * value: 0 1 2 1 -2 -5 -4 3 ...
     * 
     * @param index
     *            in sequence
     * @return value at index
     * @throws IndexOutOfBoundsException
     *             if index < 0 or > 32
     */
    public static int calcSeq(int index) {
        if (index == 0) {
            return 0;     
        }
        if (index == 1) {
            return 1;
        }
        if (index == 2) {
            return 2;
        }
        if (index < 0 || index > 32) {
            throw new IndexOutOfBoundsException();
        }
        return calcSeq(index - 1) - (calcSeq(index - 3) + calcSeq(index - 2)) ;
    }
}
