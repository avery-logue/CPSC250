
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

public class LinkedListMethodsTest {

	@Rule
	public Timeout globalTimeout = new Timeout(2, TimeUnit.SECONDS);

	@Rule
	public TemporaryFolder folder = new TemporaryFolder();

	private final String EOL = System.getProperty("line.separator");

	@Test
	public void testReflection() {
		Class<?> iClass = LinkedListMethods.class;
		Field[] iFields = iClass.getDeclaredFields();

		for (Field f : iFields) {
			if (!f.isSynthetic()) {
				fail("Class shouldn't have any fields [found: \"" + f.getName() + "\"]");
			}
		}
	}

	@Test
	public void testSizeNull() {
		assertEquals("Null has size 0", 0, LinkedListMethods.size(null));

	}

	@Test
	public void testSize1Node() {
		Node<String> a = new Node<String>("Test");
		a.next = null;

		assertEquals("1 Node is size 1", 1, LinkedListMethods.size(a));
	}

	@Test
	public void testSize3Node() {
		Node<String> a = new Node<String>("Take");
		Node<String> b = new Node<String>("the");
		Node<String> c = new Node<String>("test");
		a.next = b;
		b.next = c;
		c.next = null;

		assertEquals("3 Nodes is size 3", 3, LinkedListMethods.size(a));

	}

	@Test
	public void testSize5Node() {
		Node<String> a = new Node<String>("This");
		Node<String> b = new Node<String>("is");
		Node<String> c = new Node<String>("only");
		Node<String> d = new Node<String>("a");
		Node<String> e = new Node<String>("test");
		a.next = b;
		b.next = c;
		c.next = d;
		d.next = e;
		e.next = null;

		assertEquals("5 Nodes is size 5", 5, LinkedListMethods.size(a));
	}

	@Test
	public void testSizeListIsNotAltered() {
		Node<String> a = new Node<String>("Take");
		Node<String> b = new Node<String>("the");
		Node<String> c = new Node<String>("test");
		a.next = b;
		b.next = c;
		c.next = null;

		LinkedListMethods.size(a);

		try {
			assertEquals("List is no longer in correct order", "Take", a.value);
			assertEquals("List is no longer in correct order", "the", a.next.value);
			assertEquals("List is no longer in correct order", "test", a.next.next.value);
			assertEquals("List is no longer in correct order", null, a.next.next.next);
		} catch (Exception e) {
			fail("List is no longer correctly connected.");
		}
	}

	@Test
	public void testSumNull() {
		assertEquals("Null has sum 0.0", 0.0, LinkedListMethods.sum(null), 0.001);

	}

	@Test
	public void testSum1Node() {
		Node<Double> a = new Node<Double>(1.57);
		a.next = null;

		assertEquals("Sum is 1.57", 1.57, LinkedListMethods.sum(a), 0.001);
	}

	@Test
	public void testSum3Node() {
		Node<Double> a = new Node<Double>(1.57);
		Node<Double> b = new Node<Double>(1.86);
		Node<Double> c = new Node<Double>(3.0);
		a.next = b;
		b.next = c;
		c.next = null;

		assertEquals("Sum is 6.43", 6.43, LinkedListMethods.sum(a), 0.001);
	}

	@Test
	public void testSum5Node() {
		Node<Double> a = new Node<Double>(1.57);
		Node<Double> b = new Node<Double>(1.86);
		Node<Double> c = new Node<Double>(3.0);
		Node<Double> d = new Node<Double>(12.0);
		Node<Double> e = new Node<Double>(0.75);
		a.next = b;
		b.next = c;
		c.next = d;
		d.next = e;
		e.next = null;

		assertEquals("Sum is 19.18", 19.18, LinkedListMethods.sum(a), 0.001);
	}

	@Test
	public void testSum3ListIsNotAltered() {
		Node<Double> a = new Node<Double>(1.57);
		Node<Double> b = new Node<Double>(1.86);
		Node<Double> c = new Node<Double>(3.0);
		a.next = b;
		b.next = c;
		c.next = null;

		LinkedListMethods.sum(a);

		try {
			assertEquals("List is no longer in correct order", 1.57, a.value, 0.001);
			assertEquals("List is no longer in correct order", 1.86, a.next.value, 0.001);
			assertEquals("List is no longer in correct order", 3.0, a.next.next.value, 0.001);
			assertEquals("List is no longer in correct order", null, a.next.next.next);
		} catch (Exception e) {
			fail("List is no longer correctly connected.");
		}
	}

	@Test
	public void testUpperCaseNull() {
		Node<Character> actual = LinkedListMethods.getUppercaseList(null);
		// expected: NULL
		assertEquals("", null, actual);
	}

	@Test
	public void testUpperCase1of1() {
		Node<Character> A = new Node<Character>('A', null);
		// expected: A
		Node<Character> actual = LinkedListMethods.getUppercaseList(A);
		assertEquals("", A, actual);
		assertEquals("", null, actual.next);

		// Ensure list unchanged
		assertEquals("Do not change the list.", 'A', (char) A.value);
		assertEquals("Do not change the list.", null, A.next);
	}

	@Test
	public void testUpperCase0of1() {
		Node<Character> a = new Node<Character>('a', null);
		// expected: NULL
		Node<Character> actual = LinkedListMethods.getUppercaseList(a);
		assertEquals("", null, actual);

		assertEquals("Do not change the list.", 'a', (char) a.value);
		assertEquals("Do not change the list.", null, a.next);
	}

	@Test
	public void testUpperCase0of3() {
		Node<Character> b = new Node<Character>('b');
		Node<Character> a = new Node<Character>('a');
		Node<Character> r = new Node<Character>('r');
		b.next = a;
		a.next = r;
		r.next = null;
		// expected: NULL
		Node<Character> actual = LinkedListMethods.getUppercaseList(b);
		assertEquals("", null, actual);

		// Ensure list unchanged
		assertEquals("Do not change the list.", 'b', (char) b.value);
		assertEquals("Do not change the list.", a, b.next);
		assertEquals("Do not change the list.", 'a', (char) a.value);
		assertEquals("Do not change the list.", r, a.next);
		assertEquals("Do not change the list.", 'r', (char) r.value);
		assertEquals("Do not change the list.", null, r.next);
	}

	@Test
	public void testUpperCase3of3() {
		Node<Character> B = new Node<Character>('B');
		Node<Character> A = new Node<Character>('A');
		Node<Character> M = new Node<Character>('M');
		B.next = A;
		A.next = M;
		M.next = null;
		// expected: B -> A -> M
		Node<Character> actual = LinkedListMethods.getUppercaseList(B);
		Node<Character> now = actual;
		assertEquals("", B, now);
		assertEquals("", A, now.next);
		now = now.next;
		assertEquals("", M, now.next);
		now = now.next;
		assertEquals("", null, now.next);

		// Ensure list unchanged
		assertEquals("Do not change the list.", 'B', (char) B.value);
		assertEquals("Do not change the list.", A, B.next);
		assertEquals("Do not change the list.", 'A', (char) A.value);
		assertEquals("Do not change the list.", M, A.next);
		assertEquals("Do not change the list.", 'M', (char) M.value);
		assertEquals("Do not change the list.", null, M.next);
	}

	@Test
	public void testUpperCase2of4() {
		Node<Character> b = new Node<Character>('b');
		Node<Character> L = new Node<Character>('L');
		Node<Character> a = new Node<Character>('a');
		Node<Character> H = new Node<Character>('H');
		b.next = L;
		L.next = a;
		a.next = H;
		H.next = null;
		// expected: L -> H
		Node<Character> actual = LinkedListMethods.getUppercaseList(b);
		Node<Character> now = actual;
		assertEquals("", L, now);
		assertEquals("", H, now.next);
		now = now.next;
		assertEquals("", null, now.next);

		// Ensure list unchanged
		assertEquals("Do not change the list.", 'b', (char) b.value);
		assertEquals("Do not change the list.", L, b.next);
		assertEquals("Do not change the list.", 'L', (char) L.value);
		assertEquals("Do not change the list.", a, L.next);
		assertEquals("Do not change the list.", 'a', (char) a.value);
		assertEquals("Do not change the list.", H, a.next);
		assertEquals("Do not change the list.", 'H', (char) H.value);
		assertEquals("Do not change the list.", null, H.next);
	}

}
