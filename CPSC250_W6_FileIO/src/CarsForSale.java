import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Scanner;

/**
 * Practice reading CSV files
 * 
 * @author 250 Instructors
 * @version Feb 2017
 *
 */
public class CarsForSale {

    /**
     * Read an array from CSV file
     * 
     * @param aFile
     *            - string pointing to file
     * @return the array list of Cars; return null if error encountered
     */
    public static ArrayList<Car> getCarsFromCSVFile(String aFile) {

        try{

            File file = new File(aFile);
            Scanner fin = new Scanner(file);
            ArrayList<Car> list = new ArrayList<Car>();
            
            while(fin.hasNextLine()){
                String line = fin.nextLine();
                System.out.println(line);
                Scanner data = new Scanner(line);
                data.useDelimiter(",");
                Car car = new Car(data.nextInt(), data.next(), data.next(), data.nextDouble());
                list.add(car);
            }
            fin.close();
            return list;
        }
        catch(IOException e){
            System.out.println(" IO Exception - for file " + aFile);
            return null;
        }
        catch(Exception e){
            System.out.println(" Unknown exception " + e.getMessage());
            return null;
        }
    }
}
