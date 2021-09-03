/**
 * More practice for linked lists
 * 
 * @author CS250 instructors
 * @version 0
 * @param <T>
 *            data type to store
 */

public class SomeLinkedList<T> extends SimpleLinkedList<T> {

    /**
     * Duplicate all occurrences within the linked list to generate a list twice
     * as long with duplicates adjacent to source in list.
     */
    public void doubleList() {
        // create a node to go through the list

        // for each node in the list
        // 1. remember the next node

        // 2. create a copy of the current node

        // 3. current node link to copy
        // copy link to the next node

        // 4. move to the next node
        Node<T> current = first;
        while (current != null) {
            Node<T> next = current.next; //gets the next index
            //gets the index after that (the middle of the 2 nodes)
            current.next = new Node<T>(current.value, current.next); 
            current = next;
        }
    }

    /**
     * Remove all equivalent occurrences from list
     * 
     * @param item
     *            - equivalent items to remove
     */
    public void removeAll(T item) {
        // remove all matching items from the beginning of the list
        if (first == null) {
            return;
        }

        Node<T> current = first;
        while (current != null && current.next != null) {
            if (item.equals(current.next.value)) {
                current.next = current.next.next;
            }
            current = current.next;
        }
        if (item.equals(first.value)) {
            first = first.next;
        }

    }

}
