import static org.junit.Assert.*;

import java.util.concurrent.TimeUnit;

import org.junit.Rule;
import org.junit.Test;
import org.junit.rules.Timeout;

public class DebuggingTest {

	@Rule
	public Timeout globalTimeout= new Timeout(2, TimeUnit.SECONDS);

	@Test
	public void testFindMaximumWhenHighestIsFirst() {
		int[] array    = { 5, 4, 3 };
		int   expected = 5;
		int   actual   = Debugging.findMaximum( array );
		assertEquals( "Incorrect result", expected, actual );
	}

	@Test
	public void testFindMaximumOfOneValue() {
		int[] array    = { 2012 };
		int   expected = 2012;
		int   actual   = Debugging.findMaximum( array );
		assertEquals( "Incorrect result", expected, actual );
	}

	@Test
	public void testFindMaximumWhenHighestInBetween() {
		int[] array    = { 1, 4, 2, 0 };
		int   expected = 4;
		int   actual   = Debugging.findMaximum( array );
		assertEquals( "Incorrect result", expected, actual );
	}

	@Test
	public void testFindMaximumWhenHighestIsLast() {
		int[] array    = { 1, 2 };
		int   expected = 2;
		int   actual   = Debugging.findMaximum( array );
		assertEquals( "Incorrect result", expected, actual );
	}

	@Test
	public void testFindMaximumAmongNegativeNumbers() {
		int[] array    = { -9, -8, -7, -16, -42 };
		int   expected = -7;
		int   actual   = Debugging.findMaximum( array );
		assertEquals( "Incorrect result", expected, actual );
	}

	@Test
	public void testFindMaximumInMinValueNumbers() {
		int[] array    = { Integer.MIN_VALUE, Integer.MIN_VALUE };
		int   expected = Integer.MIN_VALUE;
		int   actual   = Debugging.findMaximum( array );
		assertEquals( "Incorrect result", expected, actual );
	}
}
