import java.util.Scanner;

/**
 * This is the class that will play the mine sweeper game
 *
 * @author William Dzubak
 * @author Avery Logue
 * 
 * @version 4/3/18
 *
 */

//pushing Avery's clone

// @todo - write this class as needed
public class MineSweeper {

    // @todo -
    // MineField createMineField(String[] args)
    // boolean checkWin(MineField mf)

    //
    /**
     * The game play will be handled in the main method
     * 
     * @param args
     *            - command line arguments
     */
    public static void main(String[] args) {

        MineField mf = null;
        boolean validMF = false;
        // boolean won = false;

        try {

            if (args.length == 0) {
                mf = createMineField(args);
                validMF = true;
            }

            else if (args[0].equals("-h")) {
                System.out.println();
                printUsage();
            }

            else if (args[0].equals("-m") || args[0].equals("-l")
                    || args[0].equals("-d") || args[0].equals("-g")) {
                mf = createMineField(args);

                if (mf == null) {
                    throw new NumberFormatException("MineField is null");
                }
                else {
                    validMF = true;
                }
            }
        }
        catch (MineFieldException e) {
            printUsage();
        }
        catch (NumberFormatException e) {
            printUsage();
        }
        catch (NullPointerException e) {
            printUsage();
        }
        catch (Exception e) {
            printUsage();
        }

        // if (validMF) {
        // System.out.println("MineField is valid");
        // }
        // else {
        // System.out.println("MineField is invalid");
        // }

        // start playing game

        do {

            if (!validMF) {
                break;
            }

            System.out.println(mf.toString());

            System.out.print("Enter coordinates >> ");

            Scanner s = new Scanner(System.in);

            String in = s.nextLine();

            if (in.equalsIgnoreCase("quit")) {
                System.out.println("You lose!");
                break;
            }

            String[] commands = null;

            if (in.contains("\t")) {
                commands = in.split("\t");
            }

            if (in.contains(" ")) {
                commands = in.split(" ");
            }

            if (in.contains(",")) {
                commands = in.split(",");
            }

            try {
                if (commands[0].equalsIgnoreCase("save")) {
                    MineFieldFileIO.saveMineSweeperGame(mf, commands[1]);
                    System.out.println("Game saved! Quitting...");
                    break;
                }
            }
            catch (NullPointerException e) {
                System.out.println("Invalid file name, please enter again.");
            }

            try {
                boolean mine = mf.exposeCell(Integer.parseInt(commands[0]),
                        Integer.parseInt(commands[1]));
                if (!mine) {
                    System.out.println("You Lose!");
                    break;
                }
            }
            catch (NullPointerException e) {
                System.out.println("Incorrect amount of arguments, "
                        + "please enter again.");
                // (NPE)
            } //
            catch (ArrayIndexOutOfBoundsException e) {
                System.out.println(
                        "Commands out of bounds, " + "please enter again.");
                // (AIOOBE)
            }
            catch (NumberFormatException e) {
                System.out.println("Not a number, " + "please enter again.");
                // (NFE)
            }

            System.out.println();

        } while (!checkWin(mf));

        if (validMF) {
            System.out.println(mf.toString());
        }
        // end of program
    }

    /**
     * prints a description of how to use the program
     */
    public static void printUsage() {

        System.out.println("Enter java MineSweeper -h to display help");
        System.out.println();

        System.out.println("Enter java MineSweeper -m <rows cols mines> "
                + '\n' + "to create a MineField" + "instance with the " + '\n'
                + "specified number" + "of rows, columns, and mines");
        System.out.println();

        System.out.println("Enter java MineSweeper -l <filename> to load "
                + "a saved " + '\n'
                + "MineField from a file and create a MineField instance");
        System.out.println();

        System.out.println(
                "Enter java MineSweeper -d to create a default MineField game");
        System.out.println();

        System.out.println("Enter java MineSweeper -g <filename> to "
                + "load a game in progress");
        System.out.println();
    }

    /**
     * Creates a MineField. This is called after a user inputs "-m"
     * 
     * @param args
     *            command line arguments from main
     * 
     * @return a valid minefield or null if args are invalid
     */
    public static MineField createMineField(String[] args) {

        if (args.length == 0) {
            MineField mf = new MineField(8, 8, 8);
            return mf; // dont we do this in main?
        }

        else if (args[0].equals("-m")) {

            if (args.length != 4) {
                throw new MineFieldException("MineFieldException Thrown");
            }

            try {
                int rows = Integer.parseInt(args[1]);
                int cols = Integer.parseInt(args[2]);
                int mines = Integer.parseInt(args[3]);

                MineField mf = new MineField(rows, cols, mines);
                return mf;
            }
            catch (MineFieldException e) {
                System.out.println("caught MFE in CreateMineField");
                return null;
            }
            catch (NumberFormatException e) {
                System.out.println("caught NFE in CreateMineField");
                return null;
            }
        }

        else if (args[0].equals("-l")) {

            if (args.length != 2) {
                System.out.println("incorrect number of args");
                return null;
            }

            try {
                if (args[1] != null) {
                    MineField mf = MineFieldFileIO
                            .readMineSweeperGame(args[1]);
                    return mf;
                }
            }
            catch (Exception e) {
                return null;
            }
        }

        else if (args[0].equals("-d")) {
            if (args.length != 1) {
                System.out.println("Incorrect number of args");
                return null;
            }
            return new MineField();
        }

        else if (args[0].equals("-g")) {
            if (args.length != 2) {
                System.out.println("Incorrect number of args");
                return null;
            }

            MineField mf = MineFieldFileIO.readMineSweeperGame(args[1]);
            return mf;
        }

        return null;
    }

    /**
     * Check to see if you've won the game
     * 
     * @param mf
     *            - the MineField to check if won
     * @return true if the MineField is won, false otherwise
     */
    public static boolean checkWin(MineField mf) {
        int numMines = 0;

        // count total number of mines
        for (int i = 0; i < mf.field.length; i++) {
            for (int j = 0; j < mf.field[i].length; j++) {
                if (mf.field[i][j] == -1) {
                    numMines++;
                }
            }
        }

        // double for loop to count number of unexposed mines
        int count = 0;
        for (int i = 0; i < mf.exposed.length; i++) {
            for (int j = 0; j < mf.exposed[i].length; j++) {
                if (!mf.exposed[i][j]) { // unexposed
                    count++;
                }
            }
        }

        if (count == numMines) {

            System.out.println("You win!");

            return true;
        }
        else {
            return false;
        }

    }
}