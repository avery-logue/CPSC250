import static org.junit.Assert.assertArrayEquals;
import static org.junit.Assert.assertNotNull;
import static org.junit.Assert.assertNull;
import static org.junit.Assert.assertTrue;
import static org.junit.Assert.fail;

import java.io.IOException;

import org.junit.Rule;
import org.junit.Test;
import org.junit.rules.TemporaryFolder;

public class Array2DTest {
    private static final String SLASH = System.getProperty("file.separator");
    private static final String INPUT = "input.txt";

    @Rule
    public TemporaryFolder folder = new TemporaryFolder();

    @Test
    public void testNewArray2D() {
        Array2D arr = new Array2D();
        assertNotNull(arr);

        String[][] aStr = arr.defineArray(3, 4);
        assertNotNull(aStr);
        arr.hashCode();

    }

    @Test
    public void testInputFileEmpty() {
        try {
            // create file
            String path = folder.getRoot().getPath();
            folder.newFile(INPUT);

            // invoke program
            String[][] actual = Array2D.readArray(path + SLASH + INPUT);
            assertNull("Should have returned null for empty file", actual);
        }
        catch (IOException e) {
            fail("No exception should be thrown");
        }
    }

    @Test
    public void testInputFileWith3x4() {
        try {
            // create file
            String path = folder.getRoot().getPath();
            String fileNameWithPath = path + SLASH + INPUT;

            String[][] test = Array2D.defineArray(3, 4);

            assertTrue("Failed to write the file",
                    Array2D.writeArray(fileNameWithPath, test));

            String[][] array = Array2D.readArray(fileNameWithPath);

            // assert
            assertArrayEquals("Incorrect result after reading array", test,
                    array);
        }
        catch (Exception e) {
            fail("No exception should be thrown");
        }
    }

    @Test
    public void testInputFileWith6x1() {
        try {
            // create file
            String path = folder.getRoot().getPath();
            String fileNameWithPath = path + SLASH + INPUT;

            String[][] test = Array2D.defineArray(6, 1);

            assertTrue("Failed to write the file",
                    Array2D.writeArray(fileNameWithPath, test));

            String[][] array = Array2D.readArray(fileNameWithPath);

            // assert
            assertArrayEquals("Incorrect result after reading array", test,
                    array);
        }
        catch (Exception e) {
            fail("No exception should be thrown");
        }
    }

    @Test
    public void testInputFileWith1x6() {
        try {
            // create file
            String path = folder.getRoot().getPath();
            String fileNameWithPath = path + SLASH + INPUT;

            String[][] test = Array2D.defineArray(1, 6);

            assertTrue("Failed to write the file",
                    Array2D.writeArray(fileNameWithPath, test));

            String[][] array = Array2D.readArray(fileNameWithPath);

            // assert
            assertArrayEquals("Incorrect result after reading array", test,
                    array);
        }
        catch (Exception e) {
            fail("No exception should be thrown");
        }
    }

}
