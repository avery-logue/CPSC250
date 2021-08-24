
// @TODO - fix this class to do what is needed to pass JUnit tests
public class CrazyNameAnimal extends Animal{

    /** This is the one and only field variable you SHOULD need */
    private String crazyName;

    // If you are struggling with getting the species
    // you may add another instance variable, but will loose some points.

    /** Don't modify this constructor */
    public CrazyNameAnimal() {
        // Providing a default constructor
        System.out.println(
                " CrazyNameAnimal() - If this called then something is wrong");
    }

    /**
     * This sets the species name of the animal, and stores a "better" name for
     * the animal
     * 
     * @param spec
     *            - the "muggle" species name
     * @param crazy
     *            - the new and improved name
     */
    public CrazyNameAnimal(String spec, String crazy) {
        super (spec);
        crazyName = crazy;
    }

    // You likely need another method here to output the instance string
    // properly
    // @TODO - method here
    public String toString() {
        return super.toString() + " (" + crazyName + ") ";
        
    }
}
