import static org.junit.Assert.assertEquals;

import java.util.ArrayList;
import java.util.Arrays;

import org.junit.Rule;
import org.junit.Test;
import org.junit.rules.Timeout;

public class RecursiveMethodsTest {
    @Rule
    public Timeout globalTimeout = Timeout.seconds(2); // 2 seconds max
                                                       // per method tested

    @Test
    public void testMaxEmpty() {
        Integer[] anArray = {};
        ArrayList<Integer> aList = new ArrayList<Integer>(
                Arrays.asList(anArray));

        int expected = Integer.MIN_VALUE;
        int actual = RecursiveMethods.max(aList);

        assertEquals(expected, actual);
    }

    @Test
    public void testMaxOne() {
        Integer[] anArray = { 11 };
        ArrayList<Integer> aList = new ArrayList<Integer>(
                Arrays.asList(anArray));

        int expected = 11;
        int actual = RecursiveMethods.max(aList);

        assertEquals(expected, actual);
    }

    @Test
    public void testMaxPositives() {
        Integer[] anArray = { 1, 3, 13, 2, 4, 42, 0, 99 };
        ArrayList<Integer> aList = new ArrayList<Integer>(
                Arrays.asList(anArray));

        int expected = 99;
        int actual = RecursiveMethods.max(aList);

        assertEquals(expected, actual);
    }

    @Test
    public void testMaxNegatives() {
        Integer[] anArray = { -3, -13, -2, -4, -42, -99, -6 };
        ArrayList<Integer> aList = new ArrayList<Integer>(
                Arrays.asList(anArray));

        int expected = -2;
        int actual = RecursiveMethods.max(aList);

        assertEquals(expected, actual);
    }

    @Test
    public void testMaxMixed() {
        Integer[] anArray = { -1, 3, -13, 2, -4, 42, 0, -6 };
        ArrayList<Integer> aList = new ArrayList<Integer>(
                Arrays.asList(anArray));

        int expected = 42;
        int actual = RecursiveMethods.max(aList);

        assertEquals(expected, actual);
    }

    @Test
    public void testSumEmpty() {
        Integer[] anArray = {};
        ArrayList<Integer> aList = new ArrayList<Integer>(
                Arrays.asList(anArray));

        int expected = 0;
        int actual = RecursiveMethods.sum(aList);

        assertEquals(expected, actual);
    }

    @Test
    public void testSumOne() {
        Integer[] anArray = { 11 };
        ArrayList<Integer> aList = new ArrayList<Integer>(
                Arrays.asList(anArray));

        int expected = 11;
        int actual = RecursiveMethods.sum(aList);

        assertEquals(expected, actual);
    }

    @Test
    public void testSumPositives() {
        Integer[] anArray = { 1, 3, 13, 2, 4, 42, 0, 99 };
        ArrayList<Integer> aList = new ArrayList<Integer>(
                Arrays.asList(anArray));

        int expected = 164;
        int actual = RecursiveMethods.sum(aList);

        assertEquals(expected, actual);
    }

    @Test
    public void testSumNegatives() {
        Integer[] anArray = { -1, -3, -13, -2, -4, -42, 0, -99, -6 };
        ArrayList<Integer> aList = new ArrayList<Integer>(
                Arrays.asList(anArray));

        int expected = -170;
        int actual = RecursiveMethods.sum(aList);

        assertEquals(expected, actual);
    }

    @Test
    public void testSumMixed() {
        Integer[] anArray = { -1, 3, -13, 2, -4, 42, 0, 99, -6 };
        ArrayList<Integer> aList = new ArrayList<Integer>(
                Arrays.asList(anArray));

        int expected = 122;
        int actual = RecursiveMethods.sum(aList);

        assertEquals(expected, actual);
    }

    @Test
    public void testReverseEmpty() {
        String aString = "";
        String expected = "";
        String actual = RecursiveMethods.reverse(aString);

        assertEquals(expected, actual);
    }

    @Test
    public void testReverseOneLetter() {
        String aString = "a";
        String expected = "a";
        String actual = RecursiveMethods.reverse(aString);

        assertEquals(expected, actual);
    }

    @Test
    public void testReverseOneWord() {
        String aString = "abracadabra";
        String expected = "arbadacarba";
        String actual = RecursiveMethods.reverse(aString);

        assertEquals(expected, actual);
    }

    @Test
    public void testReverseSeveralWords() {
        String aString = "Once upon a time";
        String expected = "emit a nopu ecnO";
        String actual = RecursiveMethods.reverse(aString);

        assertEquals(expected, actual);
    }

    @Test
    public void testReversePalindrome() {
        String aString = "tenet";
        String expected = "tenet";
        String actual = RecursiveMethods.reverse(aString);

        assertEquals(expected, actual);
    }

    @Test
    public void testReverseSemordnilaps() {
        String aString = "gateman";
        String expected = "nametag";
        String actual = RecursiveMethods.reverse(aString);

        assertEquals(expected, actual);
    }

}
