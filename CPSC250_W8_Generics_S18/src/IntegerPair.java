/**
 * Class that holds references to two Integers
 * 
 * @author <student>
 * @version 0
 */
public class IntegerPair {

    /** Hold the first */
    Integer first = 0;
    /** Hold the second */
    Integer second = 0;
    /**
     * Constructor
     * 
     * @param one first
     * @param two second
     */
    public IntegerPair(Integer one, Integer two) {
        first = one;
        second = two;
    }
    /**
     * Get the first element
     * 
     * @return first
     */
    public Integer getFirst() {
        return first;
    }
    /**
     * Get the second element
     * 
     * @return second
     */
    public Integer getSecond() {
        return second;
    }
    /**
     * @return the formatted string
     */
    @Override
    public String toString() {
        return String.format("%s\t%s", first, second);
        //return first.toString() + "\t" + second.toString();
    }
}
