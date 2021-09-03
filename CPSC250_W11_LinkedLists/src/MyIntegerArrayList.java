/**
 * Demonstrate an array list implementation
 * 
 * @author <student>
 * @version 0
 *
 */
public class MyIntegerArrayList {

    /** array to store the data */
    Integer[] list;

    /** Size of our list */
    int size;

    /** how big to make initial capacity */
    static final int DEFAULT_SIZE = 10;

    /**
     * Default constructor
     */
    public MyIntegerArrayList() {
        list = new Integer[DEFAULT_SIZE];
        size = 0;
    }

    /**
     * Copy constructor performs a deep copy of other list
     * 
     * @param other
     *            - existing list
     */
    public MyIntegerArrayList(MyIntegerArrayList other) {

        // @todo - This is not what we want for deep copy
        list = other.list; // not what we want
        size = other.size;

    }

    /**
     * add item to the end of the list
     * 
     * @param item
     *            to add to list
     */
    public void add(Integer item) {

        // @todo - what happens if we run out of memory
        list[size++] = item;
    }

    /**
     * Insert item within list, shifting existin items as needed
     * 
     * @param item
     *            - reference to item to add
     * @param index
     *            - where to add
     * @throws IndexOutOfBoundsException
     */
    public void add(int index, Integer item) {

        // @todo - fix missing protection with IndexOutOfBoundsException

        // @todo - fix missing expand capacity

        // @todo - better shift things out of the way first

        list[index] = item;
        size++;
    }

    /**
     * Get reference to item at index i
     * 
     * @param i
     *            - index of value
     * @return reference at index i
     * @throws IndexOutOfBoundsException
     */
    public Integer get(int i) {
        // @todo - fix missing protection with IndexOutOfBoundsException

        return list[i];
    }

    /**
     * Remove element from list and return its reference
     * 
     * @param i
     *            - index to remote
     * @return reference that was removed
     * @throws IndexOutOfBoundsException
     */
    public Integer remove(int i) {

        // @todo - missing protection with IndexOutOfBoundsException

        Integer tmp = get(i);

        if (size == 0 || i < 0 || i >= size) {
            throw new IndexOutOfBoundsException();
        }
        for (int j = i; j < size - 1; j++) {
            list[j] = list[j + 1];
        }
        --size;
        return tmp;
    }

    /**
     * 
     * @return current size of the list
     */
    public int size() {
        return size;
    }

    /**
     * 
     * @return current capacity of list (capacity >= size)
     */
    public int capacity() {
        return list.length;
    }
}
