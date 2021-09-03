/**
 * Demo for 2D array handling
 * 
 * @author 250 Instructors
 * @version Feb-2017
 *
 */
import java.io.File;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.Scanner;

public class Array2D {

    /**
     * This method returns an array of strings with the (row, col) indices
     * 
     * @param height
     *            number of rows in array
     * @param width
     *            number of columns in array
     * @return the array
     */
    public static String[][] defineArray(int height, int width) {
        String[][] array = new String[height][width];

        // Fill in date with (row, column) index string
        for (int row = 0; row < height; ++row) {
            for (int col = 0; col < width; ++col) {
                array[row][col] = String.format("(% 2d, % 2d)", row, col);
            }
        }

        return array;
    }

    /**
     * 
     * @param fileName
     *            - path to the output file
     * @param array
     *            - array to store in file
     * @return true if successful, false otherwise
     */
    public static boolean writeArray(String fileName, String[][] array) {

        if (array == null) {
            System.out.println(" Null array - no output!");
            return false;
        }

        try {
            //System.out.println(" file <" + fileName + ">");
            File file = new File(fileName);
            PrintWriter fout = new PrintWriter(file);

            fout.println(array.length + "\t" + array[0].length);
            System.out.println(array.length + " " + array[0].length);

            for (int i = 0; i < array.length; i++) {
                for (int j = 0; j < array[0].length; j++) {
                    System.out.print(array[i][j]);
                    fout.print(array[i][j] + "\t");
                }
                System.out.println();
                fout.println();
            }
            fout.close();

        }
        catch (IOException e) {
            System.out.println("IO Exception " + e.getMessage());
            return false;
        }
        return true;
    }

    /**
     * Reads a 2D array from a file (your format), and returns the array
     * 
     * @param fileName
     *            - file name (with path) containing 2D array data
     * @return reference to the 2D array of strings, or null if error
     */
    public static String[][] readArray(String fileName) {
        try {
            File file = new File(fileName);
            Scanner fin = new Scanner(file);

            String line = fin.nextLine();
            Scanner scan = new Scanner(line);
            //scan.useDelimiter("\t");
            int rows = scan.nextInt();
            int cols = scan.nextInt();

            double[][] array = new double[rows][cols];
            System.out.println("rows: " + rows + " cols: " + cols);

            while (fin.hasNextLine()) {

                line = fin.nextLine();
                scan = new Scanner(line);

                scan.useDelimiter("\\(|,|\\)|\t");
                //System.out.print("the next double " + fin.next());
                System.out.print("first array");
                for (int i = 0; i < array.length; i++) {
                    for (int j = 0; j < array[0].length; j++) {
                        System.out.print(array[i][j] + " ");
                    }
                    System.out.println();
                }

                for (int i = 0; i < array.length; i++) {
                    for (int j = 0; j < array[0].length; j++) {
                        String x = scan.next();
                        array[i][j] = Double.parseDouble(x);
                    }
                }
            } // end of reading row loop
            for (int i = 0; i < array.length; i++) {
                for (int j = 0; j < array[0].length; j++) {
                    System.out.print(array[i][j] + " ");
                }
                System.out.println();
            }
            fin.close();
            String[][] arr = new String[1][1];
            return arr;

        }
        catch (IOException e) {
            return null;
        }
    }
    public static void main(String[] args) {
        try {
            File file = new File("average.txt");
            Scanner fin = new Scanner(file);
            String lines = "";
            double total = 0;
            double nums = 0;
            double aver = 0.0;
            
            while(fin.hasNextLine()) {
                String line = fin.nextLine();
                Scanner scan = new Scanner(line);
                scan.useDelimiter(", ");
                while (scan.hasNext()) {
                    total += Double.parseDouble(scan.next());
                    nums++;
                }
                aver = total / nums;
                total = 0;
                nums = 0;
                System.out.println("average; " + aver);
                aver = 0;
            }

            fin.close();

        }
        catch (IOException e) {
        }
    }
}
