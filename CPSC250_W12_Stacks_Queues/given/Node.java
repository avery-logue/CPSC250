/**
 * Simple node for linked list demo
 * 
 * @author CS250 instructors
 * @version 0
 * 
 * @param <T>
 *            generic parameter for data type
 */
public final class Node<T> {

    /** reference to data we are storing */
    public final T value;

    /** Reference to the next node in our list */
    public Node<T> next;

    /**
     * Constructor for node given value; sets next to null
     * 
     * @param _value
     *            - reference to data to be stored
     */
    public Node(T _value) {
        this(_value, null); // use the two argument constructor with next = null
    }

    /**
     * Node constructor given reference to data and reference to the next node
     * in list
     * 
     * @param _value
     *            reference to data to be stored
     * @param _next
     *            reference to next node in list
     */
    public Node(T _value, Node<T> _next) {
        value = _value;
        next = _next;
    }

    /**
     * String representation of data stored by this node We don't care about how
     * stored, so ignore the next!
     * 
     * @return String representation of data
     */
    @Override
    public String toString() {
        return value.toString();
    }
}