
import static org.junit.Assert.*;

import java.lang.reflect.Field;
import java.lang.reflect.Modifier;
import java.util.concurrent.TimeUnit;

import javax.swing.JDialog;
import javax.swing.JTextField;

import org.junit.Rule;
import org.junit.Test;
import org.junit.rules.Timeout;

import edu.cnu.cs.gooey.Gooey;
import edu.cnu.cs.gooey.GooeyDialog;

public class LockWithResetTest {
	@Rule
	public Timeout globalTimeout= new Timeout(5, TimeUnit.SECONDS);

	@Test
	public void testReflection() {
		Class<?> iClass     = Lock.class;
		Field[]  iFields    = iClass.getDeclaredFields();

		for (Field f : iFields) {
			if (!f.isSynthetic()) {
				assertFalse( "Field \""+f.getName()+"\" can't be static",   Modifier.isStatic ( f.getModifiers() ));
				assertFalse( "Field \""+f.getName()+"\" can't be public",   Modifier.isPublic ( f.getModifiers() ));
				if (!(Modifier.isPrivate( f.getModifiers() ) || Modifier.isProtected( f.getModifiers() ))) {
					fail( "Field \""+f.getName()+"\" should be private or protected" );
				}
			}
		}
	}



	@Test(expected=InvalidLockCombinationException.class)
	public void testNewLockThrowsExceptionWhenCombinationNotWithinLimits() {
		Combination comb = new Combination( 1, 2, 3 );
		new Lock( 2, comb ); // invalid combination. should throw exception.
	}

	/**
	 * Testing "resetNaive" method
	 */
	@Test
	public void testResetNaive_ValidCombinationChangesExistingCombination() {
		Combination         comb = new Combination  ( 7, 8, 9 );
		final Lock lock = new Lock( 10, comb );
		// dialog with input "0 9 2": input OK
		Gooey.capture( new GooeyDialog() {
			@Override
			public void invoke() {
				lock.resetNaive();
			}
			@Override
			public void test(JDialog dialog) {
				Gooey.getComponent( dialog, JTextField.class ).setText( "0 9 2" );
				Gooey.getButton   ( dialog, "OK" ).doClick();
			}
		});
		// new combination should open lock
		lock.close();
		Combination now = new Combination( 0, 9, 2 );
		lock.open ( now );
		assertTrue( "Incorrect result", lock.isOpen() );
	}
	@Test
	public void testResetNaive_ClosingDialogDoesNotChangeCombination() {
		Combination         now  = new Combination( 1, 2, 3 );
		final Lock lock = new Lock( 5, now );
		// dialog with empty input
		Gooey.capture( new GooeyDialog() {
			@Override
			public void invoke() {
				lock.resetNaive();
			}
			@Override
			public void test(JDialog dialog) {
				Gooey.getLabel ( dialog, "Type a new combination" );
				Gooey.getButton( dialog, "Cancel" ).doClick();
			}
		});
		// combination shouldn't change
		lock.close();
		lock.open ( now );
		assertTrue( "Incorrect result", lock.isOpen() );
	}
	@Test(expected=java.util.NoSuchElementException.class)
	public void testResetNaive_CombinationWithLessThanThreeNumbersThrowsException() {
		Combination         comb = new Combination  ( 42, 16, 72 );
		final Lock lock = new Lock( 100, comb );
		// dialog with input "42 88": missing one number throws exception
		Gooey.capture( new GooeyDialog() {
			@Override
			public void invoke() {
				lock.resetNaive();
			}
			@Override
			public void test(JDialog dialog) {
				Gooey.getLabel    ( dialog, "Type a new combination" );
				Gooey.getComponent( dialog, JTextField.class ).setText( "42 88" );
				Gooey.getButton   ( dialog, "OK" ).doClick();
			}
		});
		fail( "Exception should have been thrown" );
	}
	@Test(expected=java.util.NoSuchElementException.class)
	public void testResetNaive_CombinationWithNonNumbericValuesThrowsException() {
		Combination         comb = new Combination  ( 42, 16, 72 );
		final Lock lock = new Lock( 100, comb );
		// dialog with input "1 two 3": non-numeric input throws exception
		Gooey.capture( new GooeyDialog() {
			@Override
			public void invoke() {
				lock.resetNaive();
			}
			@Override
			public void test(JDialog dialog) {
				Gooey.getLabel    ( dialog, "Type a new combination" );
				Gooey.getComponent( dialog, JTextField.class ).setText( "1 two 3" );
				Gooey.getButton   ( dialog, "OK" ).doClick();
			}
		});
		fail( "Exception should have been thrown" );
	}
	@Test
	public void testResetNaive_InvalidCombinationThrowsExceptionAndDoesNotChangeExistingCombination() {
		Combination         old  = new Combination  ( 9, 8, 7 );
		final Lock lock = new Lock( 10, old );
		// dialog with input "10 11 12": input outside lock dial throws exception
		try {
			Gooey.capture( new GooeyDialog() {
				@Override
				public void invoke() {
					lock.resetNaive();
				}
				@Override
				public void test(JDialog dialog) {
					Gooey.getLabel    ( dialog, "Type a new combination" );
					Gooey.getComponent( dialog, JTextField.class ).setText( "10 11 12" );
					Gooey.getButton   ( dialog, "OK" ).doClick();
				}
			});
			fail( "Exception should have been thrown" );
		} catch (InvalidLockCombinationException e) {
			// combination shouldn't change
			lock.close();
			lock.open ( old );
			assertTrue( "Incorrect result", lock.isOpen() );
		}
	}

	/**
	 * Testing "resetRetry" method
	 */
	@Test
	public void testResetRetry_ClosingDialogDoesNotChangeCombination() {
		Combination         now  = new Combination( 1, 2, 3 );
		final Lock lock = new Lock( 5, now );
		// dialog with empty input
		Gooey.capture( new GooeyDialog() {
			@Override
			public void invoke() {
				lock.resetRetry();
			}
			@Override
			public void test(JDialog dialog) {
				Gooey.getButton( dialog, "Cancel" ).doClick();
			}
		});
		// combination shouldn't change
		lock.close();
		lock.open ( now );
		assertTrue( "Incorrect result", lock.isOpen() );
	}
	@Test
	public void testResetRetry_SeveralDialogsDoNotChangeExistingCombination() {
		Combination         now  = new Combination  ( 1, 2, 3 );
		final Lock lock = new Lock( 5, now );
		// dialog with input "42" (but two other numbers needed): error dialog displayed
		Gooey.capture( new GooeyDialog() {
			@Override
			public void invoke() {
				lock.resetRetry();
			}
			@Override
			public void test(final JDialog dialog) {
				Gooey.getComponent( dialog, JTextField.class ).setText( "42" );
				Gooey.capture( new GooeyDialog() {
					@Override
					public void invoke() {
						Gooey.getButton( dialog, "OK" ).doClick();
					}
					@Override
					public void test(final JDialog dialog) {
						Gooey.getLabel ( dialog, "Type 3 integers separated by spaces" );
						Gooey.capture( new GooeyDialog() {
							@Override
							public void invoke() {
								Gooey.getButton( dialog, "OK" ).doClick();
							}
							@Override
							public void test(JDialog dialog) {
								Gooey.getLabel ( dialog, "Type a new combination" );
								Gooey.getButton( dialog, "Cancel" ).doClick();
							}
						});
					}
				});
			}
		});
		// combination shouldn't change
		lock.close();
		lock.open ( now );
		assertTrue( "Incorrect result", lock.isOpen() );
	}
	@Test
	public void testResetRetry_ClosingDialogAfterNonNumericInputDoesNotChangeExistingCombination() {
		Combination         now  = new Combination( 1, 2, 3 );
		final Lock lock = new Lock( 5, now );
		// dialog with input "3 2 one" (last one is non-numeric): error dialog displayed
		Gooey.capture( new GooeyDialog() {
			@Override
			public void invoke() {
				lock.resetRetry();
			}
			@Override
			public void test(final JDialog dialog) {
				Gooey.getComponent( dialog, JTextField.class ).setText( "3 2 one" );
				Gooey.capture( new GooeyDialog() {
					@Override
					public void invoke() {
						Gooey.getButton( dialog, "OK" ).doClick();
					}
					@Override
					public void test(final JDialog dialog) {
						Gooey.getLabel ( dialog, "Type 3 integers separated by spaces" );
						Gooey.capture( new GooeyDialog() {
							@Override
							public void invoke() {
								Gooey.getButton( dialog, "OK" ).doClick();
							}
							@Override
							public void test(JDialog dialog) {
								Gooey.getLabel ( dialog, "Type a new combination" );
								Gooey.getButton( dialog, "Cancel" ).doClick();
							}
						});
					}
				});
			}
		});
		// combination shouldn't change
		lock.close();
		lock.open ( now );
		assertTrue( "Incorrect result", lock.isOpen() );
	}
	@Test
	public void testResetRetry_ValidCombinationAfterInvalidCombinationChangesExistingCombination() {
		Combination         comb = new Combination  ( 4, 4, 4 );
		final Lock lock = new Lock( 5, comb );
		// dialog with input "9 8 2" (first two are not valid): error dialog displayed
		Gooey.capture( new GooeyDialog() {
			@Override
			public void invoke() {
				lock.resetRetry();
			}
			@Override
			public void test(final JDialog dialog) {
				Gooey.getComponent( dialog, JTextField.class ).setText( "9 8 2" );
				Gooey.capture( new GooeyDialog() {
					@Override
					public void invoke() {
						Gooey.getButton( dialog, "OK" ).doClick();
					}
					@Override
					public void test(final JDialog dialog) {
						Gooey.getLabel( dialog, "Type 3 integers in the range [0..5]" );
						Gooey.capture( new GooeyDialog() {
							@Override
							public void invoke() {
								Gooey.getButton( dialog, "OK" ).doClick();
							}
							@Override
							public void test(JDialog dialog) {
								Gooey.getComponent( dialog, JTextField.class ).setText( "3 2 1" );
								Gooey.getButton   ( dialog, "OK" ).doClick();
							}
						});
					}
				});
			}
		});
		// new combination should open lock
		lock.close();
		Combination now = new Combination( 3, 2, 1 );
		lock.open ( now );
		assertTrue( "Incorrect result", lock.isOpen() );
	}
	@Test
	public void testResetRetry_ValidCombinationAfterTwoInvalidCombinations() {
		Combination         comb = new Combination  ( 8, 0, 1 );
		final Lock lock = new Lock( 9, comb );
		// dialog with input "0 10 0" (second is not valid): error dialog displayed
		Gooey.capture( new GooeyDialog() {
			@Override
			public void invoke() {
				lock.resetRetry();
			}
			@Override
			public void test(final JDialog dialog) {
				Gooey.getComponent( dialog, JTextField.class ).setText( "0 10 0" );
				Gooey.capture( new GooeyDialog() {
					@Override
					public void invoke() {
						Gooey.getButton( dialog, "OK" ).doClick();
					}
					@Override
					public void test(final JDialog dialog) {
						Gooey.getLabel( dialog, "Type 3 integers in the range [0..9]" );
						Gooey.capture( new GooeyDialog() {
							@Override
							public void invoke() {
								Gooey.getButton( dialog, "OK" ).doClick();
							}
							@Override
							public void test(final JDialog dialog) {
								Gooey.getComponent( dialog, JTextField.class ).setText( "5 2 4" );
								Gooey.getButton   ( dialog, "OK" ).doClick();
							}
						});
					}
				});
			}
		});
		// new combination should open lock
		lock.close();
		Combination now = new Combination( 5, 2, 4 );
		lock.open ( now );
		assertTrue( "Incorrect result", lock.isOpen() );
	}
}
