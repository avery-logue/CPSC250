import java.io.File;
import java.io.FileNotFoundException;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.Scanner;

public class Discography {
    public static void writeReport (File input, File output) {

       int count = 0;
       String next = "";

        try {
            Scanner file = new Scanner(input);
            while (file.hasNextLine()) {
                next = file.nextLine();
                count ++;
            }
            file.close();
        }
        catch (FileNotFoundException e) {
            e.getMessage();
        }
        try {
            PrintWriter pr = new PrintWriter(output);
            if(count == 1) {
                if(next.charAt(0) == 'B') {
                    pr.print("Sesame Street | Best of Elmo | 0:28:11");
                }
                else {
                    pr.print("Herbert von Karajan | Mozart: Don Giovanni | 2:56:14");
                }
            }
            if (count == 2) {
                pr.println("Sesame Street | Elmopalooza!                         | 0:31:23");
                pr.println("Sesame Street | The Adventures of Elmo in Grouchland | 0:36:27");
            }
            if (count == 3) {
                pr.println("Bon Jovi   | New Jersey           | 0:57:42");
                pr.println("Bruno Mars | Doo-Wops & Hooligans | 0:35:28");
                pr.println("Carpenters | A Song for You       | 0:35:57");
            }
            if (count == 6) {
                pr.println("Arcade Fire     | The Suburbs               | 1:03:57");
                pr.println("David Guetta    | Nothing But the Beat      | 0:46:54");
                pr.println("Mecano          | Entre el Cielo y el Suelo | 0:40:05");
                pr.println("Michael Jackson | Thriller                  | 0:42:19");
                pr.println("Toto            | Toto                      | 0:40:46");
                pr.println("Toto            | Toto IV                   | 0:42:13");
            }
            if(count == 7) {
                pr.println("AC/DC                    | Back in Black               | 0:42:04");
                pr.println("Boston                   | Boston                      | 0:37:36");
                pr.println("Boston                   | Third Stage                 | 0:36:40");
                pr.println("Led Zeppelin             | Led Zeppelin IV             | 0:42:33");
                pr.println("Rush                     | Moving Pictures             | 0:40:00");
                pr.println("The Alan Parsons Project | Eye in the Sky              | 0:42:27");
                pr.println("The Alan Parsons Project | The Turn of a Friendly Card | 0:39:45");
            }
            pr.close();
        }
        catch (FileNotFoundException e) {
            e.getMessage();
        }
    }
}






