import java.awt.Point;
import java.util.Random;
/**
 * Class to define MineField for eventual MineSweeper game
 *
 * @author Avery Logue
 * @author William Dzubak
 * 
 * @version February 6th, 2018
 */
public class MineField {
    /**
     * array of mine field data
     * 
     * mines are -1
     * 
     * other values represent the number (eight connected) of neighboring mines
     */
    protected int[][] field;
    /**
     * Has this cell been exposed
     */
    protected boolean[][] exposed;
    /** Private instance of random number generator */
    private static Random rand = new Random();
    /**
     * Helper method to create random point within array bounds
     * 
     * @return random location within array
     */
    public Point getRandomCell() {
        if (field == null) {
            return null;
        }
        Point cell = new Point();
        // nextInt returns number from [0, length)
        // that is, not including length
        cell.x = rand.nextInt(field.length);
        cell.y = rand.nextInt(field[0].length);
        return cell;
    }
    /**
     * Default No argument constructor
     * 
     * Creates a defined 3x3 field with single mine in upper left corner
     *
     * Requires setHint() to set the hint data correctly
     */
    public MineField() {
        field = new int[3][3]; // defaults to 0
        field[0][0] = -1;
        exposed = new boolean[3][3]; // defaults to false
        setHint();
    }
    /**
     * 3 argument constructor Creates mine field with defined size and number of
     * mines
     * 
     * @param rows
     *            number of rows in the mine field
     * @param cols
     *            number of columns in the mine field
     * @param mines
     *            number of mines at random positions in the mine field
     */
    public MineField(int rows, int cols, int mines) {
        field = new int[rows][cols];
        exposed = new boolean[rows][cols];
        if (mines > rows * cols) { // if randomly generated number of mines is
            // greater than total number of spaces
            for (int i = 0; i < rows; i++) {
                for (int j = 0; j < cols; j++) {
                    field[i][j] = -1;
                }
            }
        }
        else { // if randomly generated number of mines is less than or equal to
            // total number of spaces
            while (mines > 0) {
                Point rando = getRandomCell();
                while (field[(int) rando.getX()][(int) rando.getY()] == -1) {
                    rando = getRandomCell();
                }
                field[(int) rando.getX()][(int) rando.getY()] = -1;
                mines--;
            }
        }
    }
    /**
     * create a mine field from the given array Define mine field with hints,
     * and properly initialize the exposed array
     * 
     * @param array
     *            - array of mines only (-1 or 0)
     */
    public void setMineField(int[][] array) {
        field = new int[array.length][array[0].length];
        for (int i = 0; i < field.length; i++) {
            for (int j = 0; j < field.length; j++) {
                field[i][j] = array[i][j];
            }
        }
        setHint();
        exposed = new boolean[array.length][array[0].length];
    }
    /**
     * Given a minefield (-1 for mines) set all non negative cells to count the
     * number of adjacent cells that contain mines (8-connected including
     * diagonal corners)
     */
    public void setHint() {
        int numMines = 0;
        for (int i = 0; i < field.length; i++) {
            for (int j = 0; j < field.length; j++) {
                // top left
                if (i == 0 && j == 0) {
                    if (field[i][j] == 0) {
                        if (field[0][1] == -1) {
                            numMines++;
                        }
                        if (field[1][1] == -1) {
                            numMines++;
                        }
                        if (field[1][0] == -1) {
                            numMines++;
                        }
                        field[i][j] = numMines;
                        numMines = 0;
                    }
                }
                // top edges
                else if (j > 0 && j < field.length - 1 && i == 0) {
                    if (field[i][j] == 0) {
                        if (field[i][j - 1] == -1) {
                            numMines++;
                        }
                        if (field[i + 1][j - 1] == -1) {
                            numMines++;
                        }
                        if (field[i + 1][j] == -1) {
                            numMines++;
                        }
                        if (field[i + 1][j + 1] == -1) {
                            numMines++;
                        }
                        if (field[i][j + 1] == -1) {
                            numMines++;
                        }
                        field[i][j] = numMines;
                    }
                    numMines = 0;
                }
                // top right
                else if (i == 0 && j == field[0].length - 1) {
                    if (field[i][j] == 0) {
                        if (field[0][field[i].length - 2] == -1) {
                            numMines++;
                        }
                        if (field[1][field[i].length - 2] == -1) {
                            numMines++;
                        }
                        if (field[1][field[i].length - 1] == -1) {
                            numMines++;
                        }
                        field[i][j] = numMines;
                    }
                    numMines = 0;
                }
                // bottom left
                else if (i == field.length - 1 && j == 0) {
                    if (field[i][j] == 0) {
                        if (field[field.length - 2][j] == -1) {
                            numMines++;
                        }
                        if (field[field.length - 2][j + 1] == -1) {
                            numMines++;
                        }
                        if (field[field.length - 1][j + 1] == -1) {
                            numMines++;
                        }
                        field[i][j] = numMines;
                    }
                    numMines = 0;
                }
                // bottom edges
                else if (j > 0 && j < field.length - 1
                        && i == field.length - 1) {
                    if (field[i][j] == 0) {
                        if (field[i][j - 1] == -1) {
                            numMines++;
                        }
                        if (field[i - 1][j - 1] == -1) {
                            numMines++;
                        }
                        if (field[i - 1][j] == -1) {
                            numMines++;
                        }
                        if (field[i - 1][j + 1] == -1) {
                            numMines++;
                        }
                        if (field[i][j + 1] == -1) {
                            numMines++;
                        }
                        field[i][j] = numMines;
                    }
                    numMines = 0;
                }
                // bottom right
                else if (i == field.length - 1 && j == field.length - 1) {
                    if (field[i][j] == 0) {
                        if (field[field.length - 2][field.length - 1] == -1) {
                            numMines++;
                        }
                        if (field[field.length - 2][field.length - 2] == -1) {
                            numMines++;
                        }
                        if (field[field.length - 1][field.length - 2] == -1) {
                            numMines++;
                        }
                        field[i][j] = numMines;
                    }
                    numMines = 0;
                }
                // left edges
                else if (i > 0 && i < field.length - 1 && j == 0) {
                    if (field[i][j] == 0) {
                        if (field[i - 1][j] == -1) {
                            numMines++;
                        }
                        if (field[i - 1][j + 1] == -1) {
                            numMines++;
                        }
                        if (field[i][j + 1] == -1) {
                            numMines++;
                        }
                        if (field[i + 1][j + 1] == -1) {
                            numMines++;
                        }
                        if (field[i + 1][j] == -1) {
                            numMines++;
                        }
                        field[i][j] = numMines;
                    }
                    numMines = 0;
                }
                // right edges
                else if (i > 0 && i < field.length - 1
                        && j == field.length - 1) {
                    if (field[i][j] == 0) {
                        if (field[i - 1][j] == -1) {
                            numMines++;
                        }
                        if (field[i - 1][j - 1] == -1) {
                            numMines++;
                        }
                        if (field[i][j - 1] == -1) {
                            numMines++;
                        }
                        if (field[i + 1][j - 1] == -1) {
                            numMines++;
                        }
                        if (field[i + 1][j] == -1) {
                            numMines++;
                        }
                        field[i][j] = numMines;
                    }
                    numMines = 0;
                }
                // regular tiles
                else if (i > 0 && i < field.length - 1 && j > 0
                        && j < field.length - 1) {
                    if (field[i][j] == 0) {
                        if (field[i - 1][j - 1] == -1) {
                            numMines++;
                        }
                        if (field[i - 1][j] == -1) {
                            numMines++;
                        }
                        if (field[i - 1][j + 1] == -1) {
                            numMines++;
                        }
                        if (field[i][j + 1] == -1) {
                            numMines++;
                        }
                        if (field[i + 1][j + 1] == -1) {
                            numMines++;
                        }
                        if (field[i + 1][j] == -1) {
                            numMines++;
                        }
                        if (field[i + 1][j - 1] == -1) {
                            numMines++;
                        }
                        if (field[i][j - 1] == -1) {
                            numMines++;
                        }
                        field[i][j] = numMines;
                    }
                    numMines = 0;
                }
                numMines = 0;
            }
        }
    }
    /**
     * Expose cell exposes specified cell if a mine, returns false (i.e. we
     * dead)
     * 
     * if a hint, returns true
     * 
     * if zero, then exposes all neighbors until hints are exposed
     * 
     * @param row
     *            - cell row
     * @param col
     *            - cell column
     * @return false if we hit a mine, true otherwise
     */
    public boolean exposeCell(int row, int col) {
        // if a mine
        if (field[row][col] == -1) {
            exposed[row][col] = true;
            return false;
        }
        // if a hint
        else if (field[row][col] > 0) {
            exposed[row][col] = true;
            return true;
        }
        // for hints bordering other hints, use exposed's boolean
        // for edges, use row[0] or row.length
        else {
            exposed[row][col] = true;
            // top left
            if (row == 0 && col == 0) {
                if (!exposed[0][1]) {
                    exposeCell(0, 1);
                }
                if (!exposed[1][1]) {
                    exposeCell(1, 1);
                }
                if (!exposed[1][0]) {
                    exposeCell(1, 0);
                }
            }
            // top right
            if (row == 0 && col == field.length - 1) {
                if (!exposed[0][field.length - 2]) {
                    exposeCell(0, field.length - 2);
                }
                if (!exposed[1][field.length - 2]) {
                    exposeCell(1, field.length - 2);
                }
                if (!exposed[1][field.length - 1]) {
                    exposeCell(1, field.length - 1);
                }
            }
            //top edges
            if (col > 0 && col < field.length - 1 && row == 0) {
                if (!exposed[row][col - 1]) {
                    exposeCell(row, col - 1);
                }
                if (!exposed[row + 1][col - 1]) {
                    exposeCell(row + 1, col - 1);
                }
                if (!exposed[row + 1][col]) {
                    exposeCell(row + 1, col);
                }
                if (!exposed[row + 1][col + 1]) {
                    exposeCell(row + 1, col + 1);
                }
                if (!exposed[row][col + 1]) {
                    exposeCell(row, col + 1);
                }
            }
            //left edges
            if (row > 0 && row < field.length - 1 && col == 0) {
                if (!exposed[row - 1][col]) {
                    exposeCell(row - 1, col);
                }
                if (!exposed[row - 1][col + 1]) {
                    exposeCell(row - 1, col + 1);
                }
                if (!exposed[row][col + 1]) {
                    exposeCell(row, col + 1);
                }
                if (!exposed[row + 1][col + 1]) {
                    exposeCell(row + 1, col + 1);
                }
                if (!exposed[row + 1][col]) {
                    exposeCell(row + 1, col);
                }
            }
            //right edges
            if (row > 0 && row < field.length - 1 && col == field.length - 1) {
                if (!exposed[row - 1][col]) {
                    exposeCell(row - 1, col);
                }
                if (!exposed[row - 1][col - 1]) {
                    exposeCell(row - 1, col - 1);
                }
                if (!exposed[row][col - 1]) {
                    exposeCell(row, col - 1);
                }
                if (!exposed[row + 1][col - 1]) {
                    exposeCell(row + 1, col - 1);
                }
                if (!exposed[row + 1][col]) {
                    exposeCell(row + 1, col);
                }
            }
            // bottom left
            if (row == field.length - 1 && col == 0) {
                if (!exposed[field.length - 2][col]) {
                    exposeCell(field.length - 2, col);
                }
                if (!exposed[field.length - 2][col + 1]) {
                    exposeCell(field.length - 2, col + 1);
                }
                if (!exposed[field.length - 1][col + 1]) {
                    exposeCell(field.length - 1, col + 1);
                }
            }
            // bottom edges
            if (col > 0 && col < field.length - 1 && row == field.length - 1) {
                if (!exposed[row][col - 1]) {
                    exposeCell(row, col - 1);
                }
                if (!exposed[row - 1][col - 1]) {
                    exposeCell(row - 1, col - 1);
                }
                if (!exposed[row - 1][col]) {
                    exposeCell(row - 1, col);
                }
                if (!exposed[row - 1][col + 1]) {
                    exposeCell(row - 1, col + 1);
                }
                if (!exposed[row][col + 1]) {
                    exposeCell(row, col + 1);
                }
            }
            //bottom right
            if (row == field.length - 1 && col == field.length - 1) {
                if (!exposed[field.length - 2][field.length - 1]) {
                    exposeCell(field.length - 2, field.length - 1);
                }
                if (!exposed[field.length - 2][field.length - 2]) {
                    exposeCell(field.length - 2, field.length - 2);
                }
                if (!exposed[field.length - 1][field.length - 2]) {
                    exposeCell(field.length - 1, field.length - 2);
                }
            }
            //regular tiles
            if (row > 0 && row < field.length - 1 &&
                    col > 0 && col < field.length - 1) {
                if (!exposed[row - 1][col - 1]) {
                    exposeCell(row - 1, col - 1);
                }
                if (!exposed[row - 1][col]) {
                    exposeCell(row - 1, col);
                }
                if (!exposed[row - 1][col + 1]) {
                    exposeCell(row - 1, col + 1);
                }
                if (!exposed[row][col + 1]) {
                    exposeCell(row, col + 1);
                }
                if (!exposed[row + 1][col + 1]) {
                    exposeCell(row + 1, col + 1);
                }
                if (!exposed[row + 1][col]) {
                    exposeCell(row + 1, col);
                }
                if (!exposed[row + 1][col - 1]) {
                    exposeCell(row + 1, col - 1);
                }
                if (!exposed[row][col - 1]) {
                    exposeCell(row, col - 1);
                }
            }
            return true;
        }
    }
    /**
     * toString with each row in separate line, newline between Use 3 characters
     * per cell
     *
     * ' * ' if not exposed
     *
     * ' -1' if mine
     *
     * ' # ' where # is hint - the number of adjacent mines
     *
     * @return single string
     */
    @Override
    public String toString() {
        String o = "";
        for (int i = 0; i < field.length; i++) {
            for (int j = 0; j < field.length; j++) {
                if (!exposed[i][j]) {
                    o += " * ";
                }
                else if (exposed[i][j] && field[i][j] == -1) {
                    o += " " + field[i][j];
                }
                else if (exposed[i][j] && field[i][j] != 0) {
                    o += " " + field[i][j] + " ";
                }
                else if (exposed[i][j] && field[i][j] == 0) {
                    o += "   ";
                }
            }
            o += '\n';
        }
        return o;
    }
}