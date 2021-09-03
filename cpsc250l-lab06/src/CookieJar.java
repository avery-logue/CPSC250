import java.io.File;
import java.io.FileNotFoundException;
import java.io.PrintWriter;
import java.text.DecimalFormat;
import java.util.ArrayList;
import java.util.Scanner;

public class CookieJar {
    public static void cashingIn(File input, File output) {

        ArrayList <String> lines = new ArrayList<String>();
        ArrayList <String> nums = new ArrayList<String>();
        ArrayList <String> coins = new ArrayList<String>();
        ArrayList <Integer> rnums = new ArrayList<Integer>();
        double total = 0.0;
        try {
            Scanner text = new Scanner(input);

            while(text.hasNext()) {
                lines.add(text.next());
            }
            text.close();
        }
        catch (FileNotFoundException e) {
            System.out.print(e.getMessage());
        }
        catch (Exception e) {
            System.out.print(e.getMessage());
        }

        for (int i = 0; i < lines.size(); i ++) {
            if (i% 2 == 0) {
                nums.add(lines.get(i));
            }
            else {
                coins.add(lines.get(i));
            }
        }


        for (int i = 0; i < nums.size(); i ++) {
            rnums.add(Integer.parseInt(nums.get(i)));
        }


        for (int i = 0; i < coins.size(); i ++) {
            if (coins.get(i).charAt(0) == 'p') {
                for (int j = 0; j < rnums.get(i); j++)
                    total += 0.01;
            }
            else if (coins.get(i).charAt(0) == 'n') {
                for (int j = 0; j < rnums.get(i); j++)
                    total += 0.05;
            }
            else if (coins.get(i).charAt(0) == 'd') {
                for (int j = 0; j < rnums.get(i); j++)
                    total += 0.10;
            }
            else if (coins.get(i).charAt(0) == 'q') {
                for (int j = 0; j < rnums.get(i); j++)
                    total += 0.25;
            }
            else {
                total += 0;
            }
        }
        try {
            total = Math.round(total * 10000.0) / 10000.0;
            
            String pattern = "#,###.##";
            DecimalFormat decimalFormat = new DecimalFormat(pattern);

            String format = decimalFormat.format(total);

            PrintWriter wrtr = new PrintWriter(output);
            
            if (total == 0.0) {
                wrtr.print("You have no money in the jar");
            }
            else {
                wrtr.print("You have $" + format + " in the jar");
            }
            wrtr.close();
        }
        catch (FileNotFoundException e) {
            System.out.print(e.getMessage());
        }
        catch (Exception e) {
            System.out.print(e.getMessage());
        }


    }
}
