/**
 * Simple Queue based on linked list
 * 
 * @author <student>
 * @version 0
 * @param <T>
 *            generic data type
 */

// NOTE: By extending from SimpleLinkedList, we also inherit the LinkedLists
// methods.
// Thus , our SimpleQueue is also a SimpleLinkedList with direct access to
// linked list methods.
// To truly hide the linked list, we would need to make the linked
// list a member instead of extending.

// @todo - fix this by making this class implement interface and
// inherit form SimpleLinkedList
public class SimpleQueue<T> extends SimpleLinkedList<T> implements SimpleQueueInterface<T> {

    /**
     * Adds element to back of the line
     * 
     * @param value
     *            to store
     */
    public void enqueue(T value) {
    	add(value);
    }

    /**
     * Removes element from the front of the line, and returns it
     * 
     * @return element removed; null if no element exists
     */
    public T dequeue() {
        return remove(0);
    }

    /**
     * Returns reference to the element at front of queue, but does not remove
     * 
     * @return element at front; null if no element exists
     */
    public T peek() {
    	if (first == null) {
    		return null;
    	}
    	else {
        return first.value;
    	}
    }
}