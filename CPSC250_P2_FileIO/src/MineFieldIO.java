/**
 * We need to set both field and exposed data,
 * 
 * but MineField doesn't give us a way to set both from outside the class.
 * 
 * We also need to access the field and exposed array to save. But the protected
 * data is not accessible from outside of MineField.
 * 
 * If only there were a way to to extend the MineField class to allow this.
 * 
 * I'm leaving this class relatively wide open. If these hints are not enough,
 * look at the MineFieldIOTest.java unit test that I gave you to get you started
 * with how I constructed my solution.
 * 
 * You are free to do another way, and only the MineFieldFileIOTests are used on
 * WebCat. (But make sure this class still compiles, even if you don't follow
 * the exact approach that I used.)
 * 
 * @author William Dzubak
 * @author Avery Logue
 * 
 * @version 3/14/18
 * 
 */

public class MineFieldIO extends MineField {

    /**
     * Default constructor
     */
    MineFieldIO() {
        super();
    }

    /**
     * two arg constructor
     * 
     * @param aField
     *            the field array
     * @param aExposed
     *            the exposed array
     */
    MineFieldIO(int[][] aField, boolean[][] aExposed) {
        // set the field and exposed arrays via double for loop

        for (int i = 0; i < aField.length; i++) {
            for (int j = 0; j < aField[0].length; j++) {
                field[i][j] = aField[i][j];
                exposed[i][j] = aExposed[i][j];
            }
        }
    }

    /**
     * the getter for field
     * 
     * @param mf
     *            the minefield that you want to get the field array from
     * @return the field array
     */
    static int[][] getField(MineField mf) {

        int[][] copy = new int[mf.field.length][mf.field[0].length];

        for (int i = 0; i < copy.length; i++) {
            for (int j = 0; j < copy[0].length; j++) {
                copy[i][j] = mf.field[i][j];
            }
        }

        return copy;
    }

    /**
     * the getter for exposed
     * 
     * @param mf
     *            the minefield that you want to get the exposed array from
     * @return the exposed array
     */
    static boolean[][] getExposed(MineField mf) {

        boolean[][] copy = new boolean[mf.exposed.length][mf.exposed[0].length];

        for (int i = 0; i < copy.length; i++) {
            for (int j = 0; j < copy[0].length; j++) {
                copy[i][j] = mf.exposed[i][j];
            }
        }
        return copy;
    }
}
