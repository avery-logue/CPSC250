/**
 * Sample of copying array
 * @author Avery Logue
 * @version 1/18/18
 *
 *
 * For each method:
 *   . If the input array is null, return null
 *   . If input array is empty, then return an empty array.
 *       That is a valid reference with 0 elements in the array.
 */

public class CopyArray {

    /** shallow copy of double array
     * @param da 1D array of doubles
     * @return shallow copy (i.e. reference to same) 1D array of doubles
     */
    public static double[] shallowCopy(double[] da) {
        return da;
    }

    /** deep copy of string array
     * @param sa 1D array of String data
     * @return new 1D array of strings
     */
    public static String[] deepCopy(String[] sa) {
        if (sa == null) {
            return null;
        }
        else {
            String[] newArray = new String[sa.length];
            for (int i = 0; i < sa.length; i++) {
                newArray[i] = sa[i];
            }
            return newArray;
        }

    }

    /** deep copy of only the odd elements in int array
     *     Not the odd indices, odd values within the array
     * @param ia 1D array of integers
     * @return 1D  array of integers
     */
    public static int[] deepCopyOdd(int[] ia) {
        int count = 0;
        for (int i : ia) {
            if (Odd.isOdd(i)) {
                count++;
            }
        }
        int[] newArray = new int[count];
        int counttoo = 0;
        for (int i = 0; i < ia.length; i++) {
            if (Odd.isOdd(ia[i])) {
                newArray[counttoo] = ia[i];
                counttoo++;
            }
        }
        return newArray;
    }

}
