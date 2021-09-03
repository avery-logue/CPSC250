/**
 * Interface for a SimpleQueue implementation
 * 
 * @author CS250
 * @version 0
 * @param <T>
 *            data type
 */
public interface SimpleQueueInterface<T> {

    /**
     * Adds element to back of the line
     * 
     * @param value
     */
    public void enqueue(T value);

    /**
     * Removes element from the front of the line, and returns it
     * 
     * @return element removed; null if no element exists
     */
    public T dequeue();

    /**
     * Returns reference to the element at front of queue, but does not remove
     * 
     * @return element at front; null if no element exists
     */
    public T peek();

}