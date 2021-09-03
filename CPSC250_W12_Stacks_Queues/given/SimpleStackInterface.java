/**
 * Interface for a SimpleStack implementation
 * 
 * @author CS250
 * @version 0
 * @param <T>
 *            data type
 */

public interface SimpleStackInterface<T> {

    /**
     * Adds element to top os the stack
     * 
     * @param value
     */
    public void push(T value);

    /**
     * Removes reference to element from the top of stack and returns that
     * reference
     * 
     * @return element previously on the top of stack
     */
    public T pop();

    /**
     * Returns reference to element currently at top of stack without removing
     * from the stack
     * 
     * @return element currently on the top of stack
     */
    public T peek();

}
