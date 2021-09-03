/**
 * @author Avery's PC
 * @version 1
 * @param <T>
 * @param <S>
 */
public class Generic2Pair<T, S> {
    /** hold first element */
    private T one;
    /** hold the second element */
    private S two;
    /** Constructor for the pair
     * 
     * @param a the first parameter
     * @param b the second parameter
     */
    public Generic2Pair(T a, S b) {
        one = a;
        two = b;
    }
    /**
     * Get the first element
     * 
     * @return the first element
     */
    public T getFirst() {
        return one;
    }
    /**
     * Get the second element
     * 
     * @return the second element
     */
    public S getSecond() {
        return two;
    }
    /**
     * This depends upon type having a valid toString
     * 
     * @return the formatted string
     */
    @Override
    public String toString() {
        return String.format("%s\t%s", one, two);
    }

}
