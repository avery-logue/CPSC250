
// @TODO - fix this class to do what is needed to pass JUnit tests
public class Mammal extends CrazyNameAnimal {

    // You should not need any additional field variables

    /** Don't modify this constructor */
    public Mammal() {
        // Providing default constructor
        System.out
                .println(" Mammal() - If this called then something is wrong");
    }

    /**
     * This sets the classification of the animal to Mammal
     * 
     * @param spec
     *            - the "muggle" name
     * @param crazy
     *            - the new and improved name
     * @return 
     */
    public Mammal(String spec, String crazy) {
        super (spec, crazy);
    }
    
    public String toString() {
        return super.toString() + "Mammal";
    }
}
