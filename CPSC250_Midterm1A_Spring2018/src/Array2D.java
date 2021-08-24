/**
 * 2D Array questions
 *
 * @author Avery Logue
 * @version 2/1/18
 */
public class Array2D {

    /** 2D array to hold integers */
    protected int[][] array;

    /**
     * Default constructor
     * 
     * Initialize the array instance variable to have
     * 
     * 5 rows and 6 columns.
     * 
     * All values are 0
     */
    public Array2D() {
        array = new int[5][6];

        for(int row = 0; row < array.length; row++) {
            for(int col = 0; col < array[row].length; col++) {
                array[row][col] = 0;
            }
        }
    }

    /**
     * One argument constructor
     *
     * @param inp
     *            array; create a deep copy and store in array instance variable
     *            if inp array is null, then set array = null
     */
    public Array2D(int[][] inp) {

        if(inp == null) {
            array = null;
        }
        else {
            array = new int[inp.length][inp[0].length];
            for(int row = 0; row < array.length; row++) {
                for(int col = 0; col < array[row].length; col++) {
                    array[row][col] = inp[row][col];
                }
            }
        }
    }

    /**
     * Set all data in the array instance variable to the given setValue
     * 
     * @param inp
     *            - value to set all element of array to
     */
    public void setValue(int inp) {
        for(int row = 0; row < array.length; row++) {
            for(int col = 0; col < array[row].length; col++) {
                array[row][col] = inp;
            }
        }
    }

    /**
     * Get the given cell
     * 
     * @param row
     *            - row in array
     * @param col
     *            - column in array
     * @return cell value, or minimum integer value (see Integer) if invalid
     *         request
     */
    public int getCell(int row, int col) {
        if(row > array.length - 1 || col > array[0].length - 1 || row < 0 || col < 0 || array == null) {
            return (Integer.MIN_VALUE);
        }
        return array[row][col];
    }

    /**
     * Set the diagonal to given value
     * 
     * Diagonal is where row and column have same index (e.g (0,0) (1,1), (2,2),
     * (3,3)
     * 
     * For simplicity, you can assume the array is square.
     * 
     * 
     * @param val
     *            - value to assign on the diagonal
     */
    public void setDiagonal(int val) {
        //		for(int row = 0; row < array.length; row++) {
        //				array[row][row] = val;
        //			}
        for(int row = 0; row < array.length; row++) {
            for(int col = 0; col < array[row].length; col++) {
                if(row == col)
                    array[row][col] = val;
            }
        }

    }

}
