import static org.junit.Assert.*;

import java.io.ByteArrayOutputStream;
import java.io.File;
import java.io.PrintStream;
import java.util.Scanner;
import java.util.concurrent.TimeUnit;

import org.junit.Rule;
import org.junit.Test;
import org.junit.rules.Timeout;

public class ArgumentsTest {

	@Rule
	public Timeout globalTimeout= new Timeout(2, TimeUnit.SECONDS);

	@Test
	public void testNoArgs() {

		// redirect output to a stream
		PrintStream console = System.out;
		ByteArrayOutputStream buffer = new ByteArrayOutputStream();
		System.setOut(new PrintStream(buffer));

		Arguments.main(new String[] {});

		Scanner read = new Scanner(buffer.toString());

		assertFalse(read.hasNext());

		// return console to its rightful owner
		System.setOut(console);
	}

	@Test
	public void test1Arg() {

		// redirect output to a stream
		PrintStream console = System.out;
		ByteArrayOutputStream buffer = new ByteArrayOutputStream();
		System.setOut(new PrintStream(buffer));

		Arguments.main(new String[] {"blue"});

		Scanner read = new Scanner(buffer.toString());

		String[]  expected  =  { "blue" };
		for (String exp : expected) {
			if (!read.hasNext()) {
				fail( "expected " + exp + "but results ended prematurely" );
			}
			String act = read.nextLine();
			assertEquals( "Incorrect result", exp, act);
		}
		if (read.hasNext()) {
			fail( "result had unexpected additional data" );
		}

		// return console to its rightful owner
		System.setOut(console);
	}

	@Test
	public void test3Args() {

		// redirect output to a stream
		PrintStream console = System.out;
		ByteArrayOutputStream buffer = new ByteArrayOutputStream();
		System.setOut(new PrintStream(buffer));

		Arguments.main(new String[] {"blue", "green", "purple"});

		Scanner read = new Scanner(buffer.toString());

		String[]  expected  =  { "blue", "green", "purple" };
		for (String exp : expected) {
			if (!read.hasNext()) {
				fail( "expected " + exp + "but results ended prematurely" );
			}
			String act = read.nextLine();
			assertEquals( "Incorrect result - did you use println()?", exp, act);
		}
		if (read.hasNext()) {
			fail( "result had unexpected additional data" );
		}

		// return console to its rightful owner
		System.setOut(console);
	}

	@Test
	public void test5Args() {

		// redirect output to a stream
		PrintStream console = System.out;
		ByteArrayOutputStream buffer = new ByteArrayOutputStream();
		System.setOut(new PrintStream(buffer));

		Arguments.main(new String[] {"blue", "green", "purple", "orange yellow", "magenta"});

		Scanner read = new Scanner(buffer.toString());

		String[]  expected  =  { "blue", "green", "purple", "orange yellow", "magenta" };
		for (String exp : expected) {
			if (!read.hasNext()) {
				fail( "expected " + exp + "but results ended prematurely" );
			}
			String act = read.nextLine();
			assertEquals( "Incorrect result - did you use println()?", exp, act);
		}
		if (read.hasNext()) {
			fail( "result had unexpected additional data" );
		}

		// return console to its rightful owner
		System.setOut(console);
	}

}
