
import static org.junit.Assert.*;

import java.io.File;
import java.io.IOException;
import java.lang.reflect.Field;
import java.util.Scanner;
import java.util.concurrent.TimeUnit;

import org.junit.Rule;
import org.junit.Test;
import org.junit.rules.Timeout;
import org.junit.rules.TemporaryFolder;

public class LinkedListMethods2Test {

	@Rule
	public Timeout globalTimeout = new Timeout(2, TimeUnit.SECONDS);

	@Rule
	public TemporaryFolder folder = new TemporaryFolder();

	private final String EOL = System.getProperty("line.separator");

	@Test
	public void testReflection() {
		Class<?> iClass = LinkedListMethods2.class;
		Field[] iFields = iClass.getDeclaredFields();

		for (Field f : iFields) {
			if (!f.isSynthetic()) {
				fail("Class shouldn't have any fields [found: \"" + f.getName() + "\"]");
			}
		}
	}

	@Test
	public void testCreateListEmpty() {
		Scanner in = new Scanner("");

		Node<String> node = LinkedListMethods2.createListFromInput(in);

		assertEquals("Empty list is null", null, node);

	}

	@Test
	public void testCreateList1() {
		Scanner in = new Scanner("Chocolate" + EOL);

		Node<String> node = LinkedListMethods2.createListFromInput(in);

		assertEquals("First item is Chocolate", "Chocolate", node.value);
		assertEquals("List contains one item", null, node.next);

	}

	@Test
	public void testCreateList3() {
		Scanner in = new Scanner("Chocolate" + EOL + "Vanilla" + EOL + "Strawberry" + EOL);

		Node<String> node = LinkedListMethods2.createListFromInput(in);

		assertEquals("First item is Chocolate", "Chocolate", node.value);
		assertEquals("Second item is Vanilla", "Vanilla", node.next.value);
		assertEquals("Third item is Strawberry", "Strawberry", node.next.next.value);
		assertEquals("List contains 3 items", null, node.next.next.next);

	}

	@Test
	public void testCreateList5() {
		Scanner in = new Scanner(
				"Chocolate" + EOL + "Vanilla" + EOL + "Strawberry" + EOL + "Mint Chip" + EOL + "Moose Tracks" + EOL);

		Node<String> node = LinkedListMethods2.createListFromInput(in);

		assertEquals("First item is Chocolate", "Chocolate", node.value);
		assertEquals("Second item is Vanilla", "Vanilla", node.next.value);
		assertEquals("Third item is Strawberry", "Strawberry", node.next.next.value);
		assertEquals("Fourth item is Mint Chip", "Mint Chip", node.next.next.next.value);
		assertEquals("Fifth item is Moose Tracks", "Moose Tracks", node.next.next.next.next.value);
		assertEquals("List contains 5 items", null, node.next.next.next.next.next);

	}

	@Test
	public void testIsWordEmpty() {
		Node<Character> a = null;
		Scanner in = new Scanner("cat" + EOL + "dog" + EOL + "bird" + EOL + "fish" + EOL + "turtle" + EOL);

		boolean result = LinkedListMethods2.isWord(a, in);

		assertFalse("Empty list is not word", result);

	}

	@Test
	public void testIsWordYes1() {
		Node<Character> a = new Node<Character>('d');
		a.next = new Node<Character>('o');
		a.next.next = new Node<Character>('g');
		a.next.next.next = null;
		Scanner in = new Scanner("cat" + EOL + "dog" + EOL + "bird" + EOL + "fish" + EOL + "turtle" + EOL);

		boolean result = LinkedListMethods2.isWord(a, in);

		assertTrue("dog is a word", result);

	}

	@Test
	public void testIsWordYes2() {
		Node<Character> a = new Node<Character>('t');
		a.next = new Node<Character>('u');
		a.next.next = new Node<Character>('r');
		a.next.next.next = new Node<Character>('t');
		a.next.next.next.next = new Node<Character>('l');
		a.next.next.next.next.next = new Node<Character>('e');
		a.next.next.next.next.next.next = null;
		Scanner in = new Scanner("cat" + EOL + "dog" + EOL + "bird" + EOL + "fish" + EOL + "turtle" + EOL);

		boolean result = LinkedListMethods2.isWord(a, in);

		assertTrue("turtle is a word", result);

	}

	@Test
	public void testIsWordNo() {
		Node<Character> a = new Node<Character>('x');
		a.next = new Node<Character>('y');
		a.next.next = new Node<Character>('z');
		a.next.next.next = null;
		Scanner in = new Scanner("cat" + EOL + "dog" + EOL + "bird" + EOL + "fish" + EOL + "turtle" + EOL);

		boolean result = LinkedListMethods2.isWord(a, in);

		assertFalse("xyz is not a word", result);

	}

	@Test
	public void testIsWordListIsNotAltered() {
		Node<Character> a = new Node<Character>('d');
		a.next = new Node<Character>('o');
		a.next.next = new Node<Character>('g');
		a.next.next.next = null;
		Scanner in = new Scanner("cat" + EOL + "dog" + EOL + "bird" + EOL + "fish" + EOL + "turtle" + EOL);

		LinkedListMethods2.isWord(a, in);

		assertEquals("First item is cat", new Character('d'), a.value);
		assertEquals("Second item is dog", new Character('o'), a.next.value);
		assertEquals("Third item is bird", new Character('g'), a.next.next.value);
		assertEquals("Fourth item is fish", null, a.next.next.next);
	}

	@Test
	public void testReverse1() throws IOException {

		String file = "output1.txt";
		File output = folder.newFile(file);

		Node<Integer> x = new Node<Integer>(2);
		x.next = null;

		LinkedListMethods2.reverse(x, output);

		assertTrue("Data file does not exist", output.exists());
		Scanner in = new Scanner(output);
		int line = 0;
		for (String expected : new String[] { "2" }) {
			if (in.hasNextLine()) {
				String actual = in.nextLine();
				assertEquals(String.format("Incorrect data in file [line %d]", line), expected, actual);
			} else {
				fail(String.format("Unexpected end of file [line %d] expected: %s", line, expected));
			}
			line++;
		}
		if (in.hasNextLine()) {
			fail(String.format("File has more data than expected [line %d] found: %s", line, in.nextLine()));
		}
		in.close();

	}

	@Test
	public void testReverse3() throws IOException {
		String file = "output2.txt";
		File output = folder.newFile(file);

		Node<Integer> x = new Node<Integer>(2);
		x.next = new Node<Integer>(-3);
		x.next.next = new Node<Integer>(17);
		x.next.next.next = null;

		LinkedListMethods2.reverse(x, output);

		assertTrue("Data file does not exist", output.exists());
		Scanner in = new Scanner(output);
		int line = 0;
		for (String expected : new String[] { "17", "-3", "2" }) {
			if (in.hasNextLine()) {
				String actual = in.nextLine();
				assertEquals(String.format("Incorrect data in file [line %d]", line), expected, actual);
			} else {
				fail(String.format("Unexpected end of file [line %d] expected: %s", line, expected));
			}
			line++;
		}
		if (in.hasNextLine()) {
			fail(String.format("File has more data than expected [line %d] found: %s", line, in.nextLine()));
		}
		in.close();
	}

	@Test
	public void testReverse4() throws IOException {
		String file = "output3.txt";
		File output = folder.newFile(file);

		Node<Integer> x = new Node<Integer>(2);
		x.next = new Node<Integer>(-3);
		x.next.next = new Node<Integer>(17);
		x.next.next.next = new Node<Integer>(0);
		x.next.next.next.next = null;

		LinkedListMethods2.reverse(x, output);

		assertTrue("Data file does not exist", output.exists());
		Scanner in = new Scanner(output);
		int line = 0;
		for (String expected : new String[] { "0", "17", "-3", "2" }) {
			if (in.hasNextLine()) {
				String actual = in.nextLine();
				assertEquals(String.format("Incorrect data in file [line %d]", line), expected, actual);
			} else {
				fail(String.format("Unexpected end of file [line %d] expected: %s", line, expected));
			}
			line++;
		}
		if (in.hasNextLine()) {
			fail(String.format("File has more data than expected [line %d] found: %s", line, in.nextLine()));
		}
		in.close();
	}

	@Test
	public void testReverse5() throws IOException {
		String filename = "output4.txt";
		File output = folder.newFile(filename);

		Node<Integer> x = new Node<Integer>(2);
		x.next = new Node<Integer>(-3);
		x.next.next = new Node<Integer>(17);
		x.next.next.next = new Node<Integer>(0);
		x.next.next.next.next = new Node<Integer>(27);
		x.next.next.next.next.next = null;

		LinkedListMethods2.reverse(x, output);

		assertTrue("Data file does not exist", output.exists());
		Scanner in = new Scanner(output);
		int line = 0;
		for (String expected : new String[] { "27", "0", "17", "-3", "2" }) {
			if (in.hasNextLine()) {
				String actual = in.nextLine();
				assertEquals(String.format("Incorrect data in file [line %d]", line), expected, actual);
			} else {
				fail(String.format("Unexpected end of file [line %d] expected: %s", line, expected));
			}
			line++;
		}
		if (in.hasNextLine()) {
			fail(String.format("File has more data than expected [line %d] found: %s", line, in.nextLine()));
		}
		in.close();
	}

}
