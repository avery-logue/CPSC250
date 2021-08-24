/**
 * Class to hold Sith information. Sith are Persons who are also ForceUsers.
 * Sith have red light sabers that are energized by the dark side of the force.
 *
 */

// @todo - fix this class
public class Sith extends Person implements ForceUser{
	public static String saberColor = "red";
	
	public Sith(String name) {
		super(name);
	}
	@Override
	public String lightSaberColor() {
		return "red";
	}


}
