/**
 * Class to hold Jedi information. Jedi are Persons who are also ForceUsers.
 * Jedi have non-red light sabers, typically blue or green.
 *
 */

// @todo - fix this class

public class Jedi extends Person implements ForceUser{
	public static String saberColor = "";
	
	public Jedi(String name, String color) {
		super(name);
		saberColor = color;
	}

	@Override
	public String lightSaberColor() {
		return saberColor;
	}

}
