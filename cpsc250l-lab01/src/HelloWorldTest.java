import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertNotNull;
import static org.junit.Assert.assertTrue;
import static org.junit.Assert.fail;

import java.io.ByteArrayOutputStream;
import java.io.PrintStream;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.lang.reflect.Modifier;
import java.net.URL;
import java.util.concurrent.TimeUnit;

import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Rule;
import org.junit.Test;
import org.junit.rules.Timeout;

public class HelloWorldTest {
	private static PrintStream console;
	private static ByteArrayOutputStream out;

	private Class<?> helloWorld;
	private Method main;

	@Rule
	public Timeout globalTimeout= new Timeout(2, TimeUnit.SECONDS);

	@BeforeClass
	public static void beforeTestsBegin() {
		console = System.out;
		out = new ByteArrayOutputStream();
		System.setOut(new PrintStream(out));
	}

	@AfterClass
	public static void afterTestsEnd() {
		System.setOut(console);
	}

	@Before
	public void beforeEachTest() {
		helloWorld = null;
		main = null;
	}

	@After
	public void afterEachTest() {
		out.reset();
	}

	private String getOutput() {
		return out.toString();
	}


	@Test
	public void testClassHasMainMethod() {
		//class exists
		try {
			Package pkg = getClass().getPackage();
			String path = pkg == null ? "" : pkg.getName() + ".";
			helloWorld = Class.forName(path + "HelloWorld");
		} catch (ClassNotFoundException e) {
			fail("File \"HelloWorld.class\" doesn't have a \"HelloWorld\" class. (is the class name spelled right?)");
		}

		//class has main method
		try {
			main = helloWorld.getMethod("main", String[].class);
		} catch (NoSuchMethodException | SecurityException e) {
			fail("Class \"HelloWorld\" doesn't have a \"main(String[])\" method. (is the method name spelled right? does it have only 1 parameter? is the parameter type correct?)");
		}
	}

	@Test
	public void testMainMethodIsPublicAndStatic() {
		testClassHasMainMethod();
		int mods = main.getModifiers();
		assertTrue("Method \"main\" should be 'public'", Modifier.isPublic(mods));
		assertTrue("Method \"main\" should be 'static'", Modifier.isStatic(mods));
	}


	@Test
	public void testMainMethodReturnsVoid() {
		testClassHasMainMethod();
		Class<?> type = main.getReturnType();
		assertEquals(
				String.format("Method \"main\" should return 'void' but returns '%s' instead", type.getSimpleName()),
				void.class, type);
	}

	@Test
	public void testSomethingWasPrinted() {
		testClassHasMainMethod();

		try {
			main.invoke( null, new Object[]{ new String[]{ }} );
		} catch (IllegalAccessException | IllegalArgumentException | InvocationTargetException e) {
			fail( "Method \"HelloWorld.main(String[])\" failed to execute. Ask your instructor for help." );
		}
		String actual = getOutput().replaceAll("\\r|\\n", "");

		String result = actual.toString().toLowerCase();

		assertFalse("Nothing was printed.", result.isEmpty());
	}

	@Test
	public void testHelloWasPrinted() {
		testClassHasMainMethod();

		try {
			main.invoke( null, new Object[]{ new String[]{ }} );
		} catch (IllegalAccessException | IllegalArgumentException | InvocationTargetException e) {
			fail( "Method \"HelloWorld.main(String[])\" failed to execute. Ask your instructor for help." );
		}
		String actual = getOutput().replaceAll("\\r|\\n", "");


		String result = actual.toString().toLowerCase();

		assertTrue("Print did not include \"Hello\".", result.contains("hello"));
	}

	@Test
	public void testWorldWasPrinted() {
		testClassHasMainMethod();

		try {
			main.invoke( null, new Object[]{ new String[]{ }} );
		} catch (IllegalAccessException | IllegalArgumentException | InvocationTargetException e) {
			fail( "Method \"HelloWorld.main(String[])\" failed to execute. Ask your instructor for help." );
		}
		String actual = getOutput().replaceAll("\\r|\\n", "");

		String result = actual.toString().toLowerCase();

		assertTrue("Print did not include \"World\".", result.contains("world"));

	}

	@Test
	public void testSpaceWasPrinted() {
		testClassHasMainMethod();

		try {
			main.invoke( null, new Object[]{ new String[]{ }} );
		} catch (IllegalAccessException | IllegalArgumentException | InvocationTargetException e) {
			fail( "Method \"HelloWorld.main(String[])\" failed to execute. Ask your instructor for help." );
		}
		String actual = getOutput().replaceAll("\\r|\\n", "");

		String result = actual.toString().toLowerCase();

		assertTrue("Print did not include a space.", result.contains(" "));

	}

	@Test
	public void testHelloSpaceWorldWasPrinted() {
		testClassHasMainMethod();

		try {
			main.invoke( null, new Object[]{ new String[]{ }} );
		} catch (IllegalAccessException | IllegalArgumentException | InvocationTargetException e) {
			fail( "Method \"HelloWorld.main(String[])\" failed to execute. Ask your instructor for help." );
		}
		String actual = getOutput().replaceAll("\\r|\\n", "");

		String result = actual.toString().toLowerCase();

		assertTrue("Print did not include \"Hello\", followed by space(s), followed by \"World\".",
				result.contains("hello world"));

	}

	@Test
	public void testHelloUsedPrintlnNotPrint() {
		testClassHasMainMethod();

		try {
			main.invoke( null, new Object[]{ new String[]{ }} );
		} catch (IllegalAccessException | IllegalArgumentException | InvocationTargetException e) {
			fail( "Method \"HelloWorld.main(String[])\" failed to execute. Ask your instructor for help." );
		}
		String actual = getOutput();

		String result = actual.toString().toLowerCase();

		assertTrue("println() was not used", result.contains(System.getProperty("line.separator")));

	}

	@Test
	public void testHelloWorldPerfectOutput() {
		testClassHasMainMethod();

		try {
			main.invoke( null, new Object[]{ new String[]{ }} );
		} catch (IllegalAccessException | IllegalArgumentException | InvocationTargetException e) {
			fail( "Method \"HelloWorld.main(String[])\" failed to execute. Ask your instructor for help." );
		}
		String actual = getOutput().replaceAll("\\r|\\n", "");

		String result = actual.toString();

		assertEquals("Print was not exactly \"Hello World\"", "Hello World" ,result);

	}
}
