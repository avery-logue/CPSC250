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
    protected Node<T> first;
    /** reference to the last node in our linked list */
    protected Node<T> last;
    /** reference to the size of our linked list */
    protected int size;

    /**
     * Construct an empty list
     */
    public SimpleLinkedList() {
        first = null;
        last = null;
        size = 0;
    }

    /**
     * Add value to list at given location
     *
     * For this version, we will make the method protected, and require access
     * via other methods
     *
     * @param index
     *            - where to add
     * @param value
     *            - reference to data we will add
     * @throws IndexOutOfBoundsException
     */
    protected void add(int index, T value) {
        // create a "box" to store new data
        Node<T> node = new Node<T>(value);

        if (index == 0) { // adding at index 0
            if (first == null) { // list is empty
                first = node;
                size++;
            }
            else { // list is not empty
                   // node links to first
                node.next = first; // don't loose the first reference
                first = node;
                size++;
            }
        }
        else { // adding to non-zero index
            if (index < 0) {
                // Invalid
                throw new IndexOutOfBoundsException();
            }
            Node<T> current = first;  // get reference to first node (we don't
                                      // change first!)
            
            // take current to the node at index - 1
            for (int i = 0; i < index - 1; i++) {
                current = current.next;
                if (current == null) {
                    throw new IndexOutOfBoundsException();
                }
            }

            // node links to node at index (current.next)
            node.next = current.next;
            
            // node at index-1 (current) links to node
            current.next = node;
            size++;
        }
    }

    /**
     * Store value at the end of the list
     *
     * For this version, we will make the method protected, and require access
     * via other methods
     *
     * @param value
     *            value to store
     */
    protected void add(T value) {
        // Need to write this one
        if (first == null) {
            first = new Node<T>(value);
            last = first;
            size = 1;
            return;
        }

        last.next = new Node<T>(value);
        last = last.next;
        size++;
    }

    /**
     * Remove element at specified location in list
     *
     * For this version, we will make the method protected, and require access
     * via other methods
     *
     * @param index
     *            location to remove
     * @throws IndexOutOfBoundsException
     */
    protected T remove(int index) {

        if (first == null || index < 0) {
            throw new IndexOutOfBoundsException();
        }
        
       
        if (index == 0) { // removing from index 0
            if (first == null) {
                return null;
            }
            T tmp = first.value;
            first = first.next;
            size--;
            if (first == null || first.next == null) {
            	last = first;
            }
            return tmp;

        }
        else { // removing from any other index
            Node<T> current = first;

            // take current to the node at index-1
            for (int i = 0; i < index - 1; i++) {
                current = current.next;
                if (current == null) {
                    throw new IndexOutOfBoundsException();
                }
            }

            // have the node at index-1 (current) link to
            // the node at index+1 (current.next.next)
            if (current.next != null) {
                T tmp = current.next.value;
                current.next = current.next.next;
                size--;
                return tmp;
            }
        }
        return null;
    }

    /**
     *
     * @return number of elements in the list
     */
    public int size() {
        return size;
    }

    /**
     * @return true if list is empty; false otherwise
     */
    public boolean isEmpty() {
        return first == null;
    }

    /**
     * @return string with all elements
     */
    @Override
    public String toString() {
        String str = "";
        Node<T> current = first;
        while (current != null) {
            str += current; // Use the node toString
            current = current.next;
            if (current != null) {
                str += ",";
            }
        }
        return str;
    }
}
