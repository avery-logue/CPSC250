import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertTrue;
import static org.junit.Assert.fail;

import java.io.File;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;

import org.junit.Rule;
import org.junit.Test;
import org.junit.rules.TemporaryFolder;

public class CarsForSaleTest {
    private static final String SLASH = System.getProperty("file.separator");
    private static final String INPUT = "input.txt";

    @Rule
    public TemporaryFolder folder = new TemporaryFolder();

    @Test
    public void testNewCar() {
        int year = 1996;
        String make = "Jeep";
        String model = "Grand Cherokee";
        double price = 890;

        Car car = new Car(year, make, model, price);

        assertEquals("getYear() should return 1996.", year, car.getYear());
        assertEquals("getMake() should return \"Jeep\".", make, car.getMake());
        assertEquals("getModel() should return \"Grand Cherokee\".", model,
                car.getModel());
        assertEquals("getPrice() should return 890.", price, car.getPrice(),
                0.005);
    }

    @Test
    public void testEquals() {
        Car one, two;

        one = new Car(2005, "BMW", "M3 Sport Package", 29995);
        assertFalse("equals() with a non-car should be false.",
                one.equals(""));

        one = new Car(2005, "BMW", "M3 Sport Package", 29995);
        assertEquals("equals() with itself should be true.", one, one);

        one = new Car(2005, "BMW", "M3 Sport Package", 29995);
        two = new Car(2006, "BMW", "M3 Sport Package", 29995);
        assertFalse("equals() with a car of different year should be false.",
                one.equals(two));

        one = new Car(2005, "BMW", "M3 Sport Package", 29995);
        two = new Car(2005, "VW", "M3 Sport Package", 29995);
        assertFalse("equals() with a car of different make should be false.",
                one.equals(two));

        one = new Car(2005, "BMW", "M3 Sport Package", 29995);
        two = new Car(2005, "BMW", "Z1", 29995);
        assertFalse("equals() with a car of different model should be false.",
                one.equals(two));

        one = new Car(2005, "BMW", "M3 Sport Package", 29995);
        two = new Car(2005, "BMW", "M3 Sport Package", 30000);
        assertFalse("equals() with a car of different price should be false.",
                one.equals(two));

        one = new Car(2005, "BMW", "M3 Sport Package", 29995);
        two = new Car(2005, "BMW", "M3 Sport Package", 29995);
        assertEquals("equals() with a same car should be true.", one, two);

        one = new Car(2005, "Honda", "Accord", 21000);
        two = new Car(2005, "Honda", "Accord", 21000);
        assertEquals("equals() with a same car should be true.", one, two);
    }

    @Test
    public void testInputFileEmpty() {
        try {
            // create file
            String path = folder.getRoot().getPath();
            folder.newFile(INPUT);

            // invoke program
            ArrayList<Car> actual = CarsForSale
                    .getCarsFromCSVFile(path + SLASH + INPUT);
            // assert
            assertEquals("Incorrect result", 0, actual.size());
        }
        catch (IOException e) {
            fail("No exception should be thrown");
        }
    }

    @Test
    public void testInputFileWithOneCar() {
        try {
            // create file
            String path = folder.getRoot().getPath();
            File file = folder.newFile(INPUT);
            PrintWriter write = new PrintWriter(file);
            write.println("2002,Ferrari,360 Modena,89984");
            write.close();

            Car one = new Car(2002, "Ferrari", "360 Modena", 89984);

            // invoke program
            ArrayList<Car> actual = CarsForSale
                    .getCarsFromCSVFile(path + SLASH + INPUT);
            // assert
            assertEquals("Incorrect result", 1, actual.size());
            assertTrue("Incorrect result", actual.contains(one));
        }
        catch (IOException e) {
            fail("No exception should be thrown");
        }
    }

    @Test
    public void testInputFileWithSeveralCars() {
        try {
            // create file
            String path = folder.getRoot().getPath();
            File file = folder.newFile(INPUT);
            PrintWriter write = new PrintWriter(file);
            write.println("2005,BMW,M3 Sport Package,29995");
            write.println("2002,Ferrari,360 Modena,89984");
            write.println("2003,Porsche,Boxster,13900");
            write.println("2000,Mercedes-Benz,ML320,19115");
            write.close();

            Car one = new Car(2005, "BMW", "M3 Sport Package", 29995);
            Car two = new Car(2002, "Ferrari", "360 Modena", 89984);
            Car three = new Car(2003, "Porsche", "Boxster", 13900);
            Car four = new Car(2000, "Mercedes-Benz", "ML320", 19115);

            // invoke program
            ArrayList<Car> actual = CarsForSale
                    .getCarsFromCSVFile(path + SLASH + INPUT);
            // assert
            assertEquals("Incorrect result", 4, actual.size());
            assertTrue("Incorrect result", actual.contains(one)); // if equal to
            assertTrue("Incorrect result", actual.contains(two));
            assertTrue("Incorrect result", actual.contains(three));
            assertTrue("Incorrect result", actual.contains(four));
        }
        catch (IOException e) {
            fail("No exception should be thrown");
        }
    }

}
