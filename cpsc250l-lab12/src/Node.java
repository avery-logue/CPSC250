/*
 * This is a class for nodes of a linked list.
 * @author Your majestic lab TA.
 */
public final class Node<T> {
	public final T       value; // The value stored in the Node (can't be changed)
	public       Node<T> next;  // The reference to the next Node (null if there is no next)

	/*
	 * The constructor of a node that sets the value and sets next to null.
	 * @param _value The value to which we set the Node's value.
	 */
	public Node(T _value) {
		value = _value;
		next  = null;
	}
	/*
	 * The constructor of a node that sets the value and next node.
	 * @param _value The value to which we set the Node's value.
	 * @param _next The next Node.
	 */
	public Node(T _value, Node<T> _next) {
		value = _value;
		next  = _next;
	}
	/*
	 * Returns value as a String.
	 * @return A String containing the String representation of value.
	 */
	@Override
	public String toString() {
		return "" + value;
	}

	/*
	 * Determines if this Node is equal to another object.
	 * Two Nodes are equal if their values are the same.
	 * @param o The object to which we compare this Node.
	 * @return true if this and o are equal, false otherwise.
	 */
	 @Override
	 public boolean equals(Object o) {
		 if (o != null && this.getClass().equals(o.getClass()))
			return ((Node<T>) o).value.equals(value);

		 return false;
	 }
}
