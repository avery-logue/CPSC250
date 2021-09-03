import java.io.File;
import java.io.FileNotFoundException;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.Scanner;

public class LineNumbers {
    public static void process(File input, File output) {

        ArrayList <String> lines = new ArrayList<String>();

        try {
            Scanner text = new Scanner(input);
            
            while(text.hasNextLine()) {
                lines.add(text.nextLine());
            }
            text.close();
        }
        catch (FileNotFoundException e) {
            System.out.print(e.getMessage());
        }
        catch (Exception e) {
            System.out.print(e.getMessage());
        }
        try {
            PrintWriter out = new PrintWriter(output);
            
            for (int i = 0; i < lines.size(); i++) {
                if (i + 1 < 10) {
                    out.print("  " + (i + 1) + " | " + lines.get(i) + '\n');
                }
                else if (i + 1 >= 10 && i + 1 < 100) {
                    out.print(" " + (i + 1) + " | " + lines.get(i) + '\n');
                }
                else {
                    out.print((i + 1) + " | " + lines.get(i) + '\n');
                }
            }
            out.close();
        }
        catch (FileNotFoundException e) {
            System.out.println(e.getMessage());
        }
    }
}
