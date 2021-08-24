import java.io.File;
import java.io.FileNotFoundException;
import java.io.PrintWriter;
import java.util.Scanner;

/**
 * Class to handle loading and saving of data
 * 
 * You must write 4 methods
 * 
 * loadMineField - loads mine field definition
 * 
 * saveMineField - saves minefield
 * 
 * Here the only concern is loading/saving a mine field definition file where -1
 * denotes a mine, and any non-negative number is safe.
 * 
 * saveGame - saves the entire game state
 * 
 * loadGame - loads the game state
 * 
 * For a game we need both the mines and the exposed array data. Unfortunately
 * the given MineField class (which you cannot change) does not provide a way to
 * set that.
 * 
 * Take a look at documentation for MineFieldIO and see if you can think of a
 * way to use that shell class to help you.
 * 
 * 
 * @author William Dzubak
 * @author Avery Logue
 * 
 * @version 3/12/18
 * 
 */
public class MineFieldFileIO extends MineFieldIO {

    /**
     * Saves a mine field definition to a file (You decide the format)
     * 
     * @param mf
     *            - reference to a mine field
     * @param fileName
     *            - string to path to minefield
     * @return true if successfully saved, false otherwise
     * 
     */
    public static boolean saveMineFile(MineField mf, String fileName) {

        if (mf == null) {
            return false;
        }

        File save = new File(fileName);

        try {
            PrintWriter pr = new PrintWriter(save);

            // pr.println("PRINT FIELD");

            int[][] fie = getField(mf);

            for (int i = 0; i < fie.length; i++) {
                for (int j = 0; j < fie[0].length; j++) {
                    pr.print(fie[i][j] + " ");
                }
                pr.println();
            }

            // USE FOR SAVE GAME

            // pr.println("PRINT EXPOSED");
            //
            // boolean[][] exp = getExposed(mf);
            //
            // for (int i = 0; i < exp.length; i++) {
            // for (int j = 0; j < exp[0].length; j++) {
            // pr.print(exp[i][j] + " ");
            // }
            // pr.println();
            // }

            pr.close();
        }
        catch (

        MineFieldException e) {
            System.out.println(e.getMessage());
            return false;
        }
        catch (FileNotFoundException e) {
            System.out.println(e.getMessage());
            return false;
        }

        return true;

    }

    /**
     * Reads the minefield definition from a file format of your choosing.
     * 
     * A complete minefield with initialized hints and exposed array should be
     * returned.
     * 
     * Throws a MineFieldException if the file is opened, but the data is
     * invalid.
     * 
     * Valid games should have at least 1 mine, and at least one empty cell.
     * 
     * @param fileName
     *            - string to path to minefield
     * @return valid instance to minefield instance or null if file has
     *         IOException
     * @throw invalid MineFieldException if data in file is invalid for any
     *        reason other than IOException
     */
    public static MineField readMineFile(String fileName) {

        try {
            File file = new File(fileName);
            Scanner s = new Scanner(file);

            int rows = 0;
            int cols = 0;
            int mines = 0;
            String line = "";

            // getting the number of rows
            while (s.hasNextLine()) {
                line = s.nextLine();
                rows++;
            }

            s.close();

            Scanner lineScanner = new Scanner(line);

            int num = 0;

            // getting the number of columns
            while (lineScanner.hasNextInt()) {
                num = lineScanner.nextInt();
                cols++;
            }
            num = num + cols;
            lineScanner.close();

            int[][] dimensions = new int[rows][cols];

            // getting the number of mines
            int mineNum = 0;
            Scanner mineCounter = new Scanner(file);
            while (mineCounter.hasNextInt()) {
                mineNum = mineCounter.nextInt();
                if (mineNum == -1) {
                    mines++;
                }
            }
            mineCounter.close();

            if (mines == 0) {
                throw new MineFieldException();
            }

            // CREATE MINEFIELD

            MineField m = new MineField(rows, cols, mines);

            Scanner last = new Scanner(file);

            for (int i = 0; i < rows; i++) {
                for (int j = 0; j < cols; j++) {
                    dimensions[i][j] = last.nextInt();
                }
            }

            last.close();

            m.setMineField(dimensions);

            return m;

        }
        catch (MineFieldException e) {
            System.out.println(e.getMessage());
            throw new MineFieldException();
        }
        catch (FileNotFoundException e) {
            System.out.println(e.getMessage());
            return null;
        }
    }

    /**
     * 
     * Saves the current game state to file including both minefield and current
     * exposed array information.
     * 
     * The format is of your choosing.
     * 
     * @param mineField
     *            - reference to a mine field
     * @param fileName
     *            - string to path to minefield
     * @return true if successfully saved, false otherwise
     * 
     */
    public static boolean saveMineSweeperGame(MineField mineField,
            String fileName) {
        if (mineField == null) {
            return false;
        }

        File save = new File(fileName);

        try {
            PrintWriter pr = new PrintWriter(save);

            // pr.println("PRINT FIELD");

            int[][] fie = getField(mineField);

            for (int i = 0; i < fie.length; i++) {
                for (int j = 0; j < fie[0].length; j++) {
                    pr.print(fie[i][j] + " ");
                }
                pr.println();
            }

            // pr.println("PRINT EXPOSED");

            boolean[][] exp = getExposed(mineField);

            for (int i = 0; i < exp.length; i++) {
                for (int j = 0; j < exp[0].length; j++) {
                    pr.print(exp[i][j] + " ");
                }
                pr.println();
            }

            pr.close();
        }
        catch (MineFieldException e) {
            System.out.println(e.getMessage());
            return false;
        }
        catch (FileNotFoundException e) {
            System.out.println(e.getMessage());
            return false;
        }

        return true;

    }

    /**
     * Reads the saved game state, both field and exposed status, from a file
     * format of your choosing.
     * 
     * A complete minefield with initialized hints and exposed array should be
     * returned.
     * 
     * Throws a MineFieldException if the file is read, but the data is invalid.
     * 
     * Valid games should have at least 1 mine, at least one empty cell, and at
     * least 1 unexposed cell that is either a 0 or hint.
     * 
     * @param fileName
     *            - string to path to minefield
     * @return valid instance to minefield instance or null if file has
     *         IOException
     * @throw invalid MineFieldException if data is invalid for any reason other
     *        than a file IOException
     */
    public static MineField readMineSweeperGame(String fileName) {

        try {
            File file = new File(fileName);
            Scanner s = new Scanner(file);

            int rows = 0;
            int cols = 0;
            int mines = 0;
            String scanThisLine = "";

            // getting the number of rows
            while (s.hasNextLine()) {
                if (rows == 0) {
                    scanThisLine = s.nextLine();
                }
                else {
                    s.nextLine();
                }
                rows++;
            }
            rows = rows / 2;

            s.close();

            Scanner lineScanner = new Scanner(scanThisLine);

            // getting the number of columns
            while (lineScanner.hasNext()) {
                lineScanner.next();
                cols++;
            }

            lineScanner.close();

            // getting the number of mines
            int mineNum = 0;
            Scanner mineCounter = new Scanner(file);
            while (mineCounter.hasNextInt()) {
                mineNum = mineCounter.nextInt();
                if (mineNum == -1) {
                    mines++;
                }
            }
            mineCounter.close();

            if (mines == 0) {
                throw new MineFieldException();
            }

            // CREATE MINEFIELD

            MineField m = new MineField(rows, cols, mines);

            Scanner last = new Scanner(file);

            for (int i = 0; i < rows; i++) {
                for (int j = 0; j < cols; j++) {
                    m.field[i][j] = last.nextInt();
                }
            }

            for (int i = 0; i < rows; i++) {
                for (int j = 0; j < cols; j++) {
                    m.exposed[i][j] = last.nextBoolean();
                }
            }

            last.close();

            return m;

        }
        catch (MineFieldException e) {
            System.out.println(e.getMessage());
            throw new MineFieldException();
        }
        catch (FileNotFoundException e) {
            System.out.println(e.getMessage());
            return null;
        }
    }
}