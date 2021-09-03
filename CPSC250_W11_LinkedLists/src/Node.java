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
     * @param val
     *            - reference to data to be stored
     */
    public Node(T val) {
        this(val, null);
    }

    /**
     * Node constructor given reference to data and reference to the next node
     * in list
     *
     * @param val
     *            reference to data to be stored
     * @param nxt
     *            reference to next node in list
     */
    public Node(T val, Node<T> nxt) {
        value = val;
        next = nxt;
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
