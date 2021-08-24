/**
 * Class handles ArrayListProcessing
 * 
 * @author <student>
 * @version 0
 */
public class ArrayStuff {

    /**
     * method to remove reference from an array and keep the remaining valid
     * data in consecutive order.
     *
     * Return the reference to the item that was removed.
     *
     * Set all the unused references in the array to null
     *
     * You do NOT need to create a new array or modify the size of the existing
     * array. Just modify the array in place.
     *
     * For simplicity you may assume the array and index is valid.
     *
     * @param array
     *            - to Modify
     * @param index
     *            - index to remove
     */
    public static Integer remove(Integer[] array, int index) {
        Integer a = array[index];
        for (int i = index; i < array.length - 1; i ++) {
            array[i] = array[i + 1];
        }
        array[array.length - 1] = null;
        return a;
    }
}
