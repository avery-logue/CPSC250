/**
 * Class to test generic methods
 * 
 * @author <student>
 * @version 0
 *
 */
public class GenericMethods {

    /**
     * Initialize array of Integers with same Integer reference
     * 
     * @param array
     *            of Integer types
     * @param object
     *            reference to Integer object
     */
    public static void initIntegers(Integer[] array, Integer object) {
        if (array == null) {
            return;
        }
        for (int i = 0; i < array.length; i++) {
            array[i] = object;
        }
    }

    /**
     * Initialize a generic array with same object reference
     * 
     * @param array
     *            of generic type T
     * @param object
     *            - reference to instance of T
     * @param <T>
     *            - The generic type of the object
     */
    public static <T> void init(T[] array, T object) {
        if (array == null) {
            return;
        }
        for (int i = 0; i < array.length; i++) {
            array[i] = object;
        }
    }

}
