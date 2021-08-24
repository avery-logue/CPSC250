import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotNull;
import static org.junit.Assert.assertTrue;

import org.junit.Test;

public class MineFieldIOTest {

    /**
     * This local class uses inheritance to get access to instance variables for
     * test
     */
    class MineFieldTester extends MineField {
        MineFieldTester() {
            super();
        }

        MineFieldTester(int rows, int cols, int mines) {
            super(rows, cols, mines);
        }

        int[][] getMineField() {
            return field;
        }

        boolean[][] getExposed() {
            return exposed;
        }

        void printMineField() {
            System.out.print(" expectedMF = {");
            for (int i = 0; i < field.length; i++) {
                System.out.print("{");
                for (int j = 0; j < field[0].length; j++) {
                    System.out.print(field[i][j]);
                    if (j < field[0].length - 1) {
                        System.out.print(", ");
                    }
                }
                System.out.print("}");
                if (i < field.length - 1) {
                    System.out.print(", ");
                }
            }
            System.out.println("};");
        }

        void printExposed() {
            System.out.print(" expectedExposed = {");
            for (int i = 0; i < exposed.length; i++) {
                System.out.print("{");
                for (int j = 0; j < exposed[0].length; j++) {
                    System.out.print(exposed[i][j]);
                    if (j < exposed[0].length - 1) {
                        System.out.print(", ");
                    }
                }
                System.out.print("}");
                if (i < exposed.length - 1) {
                    System.out.print(", ");
                }
            }
            System.out.println("};");
        }
    }

    // 2 seconds max per test
    // @Rule
    // public Timeout globalTimeout = Timeout.seconds(2);

    @Test
    public void testConstruction() {
        MineFieldIO mf = new MineFieldIO();

        assertNotNull(mf);
        assertTrue(" hint: extend MineField", mf instanceof MineField);
    }

    @Test
    public void testConstruction2Arg() {

        MineFieldTester mft = new MineFieldTester();

        // We need a 2-arg constructor that lets us copy
        // array data into the protected member variables
        MineFieldIO mf = new MineFieldIO(mft.getMineField(), mft.getExposed());

        if (mf.equals(mft)) {
            System.out.println(" equal mf mft");
        }
        else {
            System.out.println(" not equal mf mft");

        }
        if (mft.equals(mf)) {
            System.out.println(" equal mft mf");
        }
        else {
            System.out.println(" not equal mft mf");

        }

        assertNotNull(mf);
        assertTrue(" hint: extend MineField", mf instanceof MineField);
        assertEquals("Can create MineFieldIO that equals MineField data", mf,
                mft);
    }

}
