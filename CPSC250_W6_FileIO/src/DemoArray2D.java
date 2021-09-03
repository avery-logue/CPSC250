/**
 * Demo for 2D array handling
 * 
 * @author 250 Instructors
 * @version Feb-2017
 *
 */
public class DemoArray2D {

    /**
     * @param args
     */
    public static void main(String[] args) {
        // TODO Auto-generated method stub
        String[][] array = Array2D.defineArray(10, 5);
        Array2D.writeArray(String.format("array_%d_%d.csv", array.length,
                array[0].length), array);  // assumes valid array

        String[][] fileArray = Array2D.readArray(String
                .format("array_%d_%d.csv", array.length, array[0].length));

        // Print out the file we just read in to compare (could compare element
        // by element for test)
        if (fileArray == null)
            System.out.println(" Invalid reading of file");
        else
            Array2D.writeArray(String.format("array_%d_%d_copy.csv",
                    fileArray.length, fileArray[0].length), fileArray);  // assumes
                                                                         // valid
                                                                         // array

    }

}
