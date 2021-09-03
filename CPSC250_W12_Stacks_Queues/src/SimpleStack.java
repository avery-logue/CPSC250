/**
 * Simple Stack based on linked list
 * 
 * @author <student>
 * @version 0
 * @param <T>
 */

// NOTE: By extending from SimpleLinkedList, we also inherit the LinkedLists
// methods
// Thus , our SimpleStack is also a SimpleLinkedList with direct access to
// linked list methods.
// To truly hide the linked list, we would need to make the linked
// list a member instead of extending.
// @todo - fix this by making this class implement interface and
// inherit form SimpleLinkedList
public class SimpleStack<T> extends SimpleLinkedList<T>
     implements SimpleStackInterface<T> {

	/**
	 * Adds element to top of the stack
	 * 
	 * @param value
	 *            to store
	 */
	public void push(T value) {
		add(0, value);
	}

	/**
	 * Pop top off the stack and return
	 * 
	 * @return value removed from top of stack
	 */
	public T pop() {;
		return remove(0);
	}

	/**
	 * Returns reference to the element at top of stack, but does not remove
	 * 
	 * @return element at top; null if no element exists
	 */
	public T peek() {
		return first.value;
	}
}
