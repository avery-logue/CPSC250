import static org.junit.Assert.*;

import java.lang.reflect.Field;
import java.lang.reflect.Method;
import java.lang.reflect.Modifier;
import java.util.Arrays;
import java.util.concurrent.TimeUnit;

import org.junit.Rule;
import org.junit.Test;
import org.junit.rules.Timeout;

public class PersonTest {
	private static final String FLEETWOOD_MAC = "Fleetwood Mac";
	private static final String LYNYARD_SKYNYRD = "Lynyard Skynyrd";
	private static final String LED_ZEPPELIN = "Led Zeppelin";
	private static final String VAN_HALEN = "Van Halen";

	@Rule
	public Timeout globalTimeout = new Timeout(2, TimeUnit.SECONDS);

	@Test
	public void testReflection() {
		Class<?> cls = Person.class;
		Field[] fields = cls.getDeclaredFields();

		for (Field f : fields) {
			if (!f.isSynthetic()) {
				assertTrue("Field \"" + f.getName() + "\" should be private", Modifier.isPrivate(f.getModifiers()));
				assertFalse("Field \"" + f.getName() + "\" can't be static", Modifier.isStatic(f.getModifiers()));
			}
		}

		Method[] methods = cls.getDeclaredMethods();
		Class<?>[] params = null;
		Class<?> returnType = null;
		
		for (Method m : methods) {
			if (!m.isSynthetic()) {
				switch (m.getName()) {
				case "Person":
					params = new Class<?>[] {String.class};
					assertFalse("Method \"" + m.getName() + "\" can't be private", Modifier.isPrivate(m.getModifiers()));
					assertFalse("Method \"" + m.getName() + "\" can't be static", Modifier.isStatic(m.getModifiers()));
					assertArrayEquals("Method \"" + m.getName() + "\"'s parameters should be " + Arrays.toString(params), 
							params, m.getParameterTypes());
					break;
				case "getName":
					params = new Class<?>[] {};
					returnType = String.class;
					assertFalse("Method \"" + m.getName() + "\" can't be private", Modifier.isPrivate(m.getModifiers()));
					assertFalse("Method \"" + m.getName() + "\" can't be static", Modifier.isStatic(m.getModifiers()));
					assertArrayEquals("Method \"" + m.getName() + "\"'s parameters should be " + Arrays.toString(params), 
							params, m.getParameterTypes());
					assertEquals("Method \"" + m.getName() + "\" should return " + returnType.toString(), 
							returnType, m.getReturnType());
					break;
				case "setName":
					params = new Class<?>[] {String.class};
					returnType = void.class;
					assertFalse("Method \"" + m.getName() + "\" can't be private", Modifier.isPrivate(m.getModifiers()));
					assertFalse("Method \"" + m.getName() + "\" can't be static", Modifier.isStatic(m.getModifiers()));
					assertArrayEquals("Method \"" + m.getName() + "\"'s parameters should be " + Arrays.toString(params), 
							params, m.getParameterTypes());
					assertEquals("Method \"" + m.getName() + "\" should return " + returnType.toString(), 
							returnType, m.getReturnType());
					break;
				case "copy":
					params = new Class<?>[] {};
					returnType = Person.class;
					assertFalse("Method \"" + m.getName() + "\" can't be private", Modifier.isPrivate(m.getModifiers()));
					assertFalse("Method \"" + m.getName() + "\" can't be static", Modifier.isStatic(m.getModifiers()));
					assertArrayEquals("Method \"" + m.getName() + "\"'s parameters should be " + Arrays.toString(params), 
							params, m.getParameterTypes());
					assertEquals("Method \"" + m.getName() + "\" should return " + returnType.toString(), 
							returnType, m.getReturnType());
					break;
				case "equals":
					params = new Class<?>[] {Object.class};
					returnType = boolean.class;
					assertFalse("Method \"" + m.getName() + "\" can't be private", Modifier.isPrivate(m.getModifiers()));
					assertFalse("Method \"" + m.getName() + "\" can't be static", Modifier.isStatic(m.getModifiers()));
					assertArrayEquals("Method \"" + m.getName() + "\"'s parameters should be " + Arrays.toString(params), 
							params, m.getParameterTypes());
					assertEquals("Method \"" + m.getName() + "\" should return " + returnType.toString(), 
							returnType, m.getReturnType());
					break;
				case "compareTo":
					params = new Class<?>[] {Person.class};
					returnType = int.class;
					assertFalse("Method \"" + m.getName() + "\" can't be private", Modifier.isPrivate(m.getModifiers()));
					assertFalse("Method \"" + m.getName() + "\" can't be static", Modifier.isStatic(m.getModifiers()));
					assertArrayEquals("Method \"" + m.getName() + "\"'s parameters should be " + Arrays.toString(params), 
							params, m.getParameterTypes());
					assertEquals("Method \"" + m.getName() + "\" should return " + returnType.toString(), 
							returnType, m.getReturnType());
					break;
				default:
					assertTrue("Method \"" + m.getName() + "\" must be private", Modifier.isPrivate(m.getModifiers()));
				}
			}
		}
	}

	@Test
	public void testGetName() {
		Person person = new Person(new String(FLEETWOOD_MAC));
		String expected = new String(FLEETWOOD_MAC);
		String actual = person.getName();
		assertEquals("Incorrect name", expected, actual);
	}

	@Test
	public void testSetName() {
		Person person = new Person("");
		String expected = new String(LED_ZEPPELIN);

		person.setName(new String(LED_ZEPPELIN));
		String actual = person.getName();
		assertEquals("Incorrect name", expected, actual);
	}

	@Test
	public void testEqualsWithSameName() {
		Object a = new Person(new String(LYNYARD_SKYNYRD));
		Object b = new Person(new String(LYNYARD_SKYNYRD));
		assertEquals("Incorrect equality result", a, b);
	}

	@Test
	public void testEqualsWithDifferentName() {
		Object a = new Person(new String(LYNYARD_SKYNYRD));
		Object b = new Person(new String(LED_ZEPPELIN));
		assertNotEquals("Incorrect equality result", a, b);
	}

	@Test
	public void testEqualsWithOtherObjects() {
		Object a = new Person(new String(LYNYARD_SKYNYRD));
		assertNotEquals("Incorrect equality result", a, new Integer(42));
		assertNotEquals("Incorrect equality result", a, new Character('A'));
		assertNotEquals("Incorrect equality result", a, "abracadabra");
	}

	@Test
	public void testEqualsWithNull() {
		Object a = new Person(new String(VAN_HALEN));
		assertNotEquals("Incorrect equality result", a, null);
	}

	@Test
	public void testCompareToLessThan() {
		Person a = new Person(new String(LED_ZEPPELIN));
		Person b = new Person(new String(LYNYARD_SKYNYRD));
		// They differ in the 2nd character, where 'e'
		// is 20 alphabetic positions earlier than 'y'
		int actual = a.compareTo(b);
		assertTrue("Incorrect comparison result", actual < 0);
	}

	@Test
	public void testCompareToEqual() {
		Person a = new Person(new String(FLEETWOOD_MAC));
		Person b = new Person(new String(FLEETWOOD_MAC));
		int actual = a.compareTo(b);
		assertTrue("Incorrect comparison result", actual == 0);
	}

	@Test
	public void testCompareToGreaterThan() {
		Person a = new Person(new String(VAN_HALEN));
		Person b = new Person(new String(LYNYARD_SKYNYRD));
		// They differ in the 1st character, where 'v'
		// is 10 alphabetic positions earlier than 'l'
		int actual = a.compareTo(b);
		assertTrue("Incorrect comparison result", actual > 0);
	}

	@SuppressWarnings("unchecked")
	@Test(expected = ClassCastException.class)
	public void testComparableShouldUseGenericsAndThrowException() {
		@SuppressWarnings("rawtypes")
		Comparable a = new Person(new String(LYNYARD_SKYNYRD));
		@SuppressWarnings("rawtypes")
		Comparable b = new String(LED_ZEPPELIN);
		// Person cannot be compared with String
		// Person.compareTo should automatically throw an exception when called
		a.compareTo(b);
	}

	@Test
	public void testCopy() {
		Person a = new Person(FLEETWOOD_MAC);
		Person b = a.copy();

		assertFalse("Reference of copied object should be different.", a == b);
		assertEquals("Copy should have same attributes", FLEETWOOD_MAC, a.getName());

		b.setName(LED_ZEPPELIN);
		assertEquals("Changing name of copy should not change name of original", FLEETWOOD_MAC, a.getName());
	}
}
