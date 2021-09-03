/**
 * A simple linked list demo
 *
 * @author CS 250 instructors
 * @version 0
 * @param <T>
 *            data type stored in this list
 */
public class SimpleLinkedList<T> {

    /** reference to the first node in our linked list */
    Node<T> first;
    /** reference to the size */
    int size;

    /**
     * Construct an empty list
     */
    public SimpleLinkedList() {
        first = null; //Empty list
        size = 0;
    }

    /**
     * Add value to list at given location
     *
     * @param index
     *            - where to add
     * @param value
     *            - reference to data we will add
     * @throws IndexOutOfBoundsException
     */
    public void add(int index, T value) {

        if (index == 0) {
            first = new Node<T>(value, first); //first = node
            return;
        }

        Node<T> current = first;
        int count = 0;
        while (current != null && count < index - 1) {
            current = current.next;
            count++;
        }
        if (current == null || index < 0) {
            throw new IndexOutOfBoundsException();
        }

        current.next = new Node<T>(value, current.next);

    }

    /**
     * Store value at the end of the list
     *
     * @param value
     *            value to store
     */
    public void add(T value) {
        if (first == null) { //if it's an empty list
            first = new Node<T>(value); // Or you could write add(0, value);
            return;
        }
        Node<T> current = first; 
        while (current.next != null) {
            current = current.next;
        }
        current.next = new Node<T>(value);
    }

    /**
     * Remove element at specified location in list
     *
     * @param index
     *            location to remove
     * @throws IndexOutOfBoundsException
     */
    public void remove(int index) {

        if (index < 0 || first == null) {
            throw new IndexOutOfBoundsException();
        }

        Node<T> current = first;
        int count = 0;
        while (current != null && count < index - 1) {
            current = current.next;
            count++;
        }
        if (current == null) {
            throw new IndexOutOfBoundsException();
        }
        if (index == 0) {
            first = current.next;
        }
        else {
            current.next = current.next.next;
        }
    }

    /**
     *
     * @return number of elements in the list
     */
    public int size() {
        Node<T> current = first;
        int count = 0;
        while (current != null) {
            current = current.next;
            count++;
        }
        return count;
    }

}
