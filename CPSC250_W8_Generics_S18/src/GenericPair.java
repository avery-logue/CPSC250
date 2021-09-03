/**
 * Class that holds refers to two objects of same type.
 * 
 * @author Avery Logue
 * @version 1
 * @param <T> meme
 */
public class GenericPair<T> {
    /** hold first element */
    private T one;
    /** hold the second element */
    private T two;
    /** Constructor for the pair
     * 
     * @param a the first
     * @param b the second
     */
    public GenericPair(T a, T b) {
        one = a;
        two = b;
    }
    /**
     * Get the first element
     * 
     * @return the first
     */
    public T getFirst() {
        return one;
    }
    /**
     * Get the second element
     * 
     * @return the second
     */
    public T getSecond() {
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
