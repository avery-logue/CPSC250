
// @TODO - fix this class to do what is needed to pass JUnit tests
public class Reptile extends CrazyNameAnimal{

    /** Don't modify this constructor */
    public Reptile() {
        // Providing default constructor
        System.out.println(
                " Reptile() - If this called then something is wrong");
    }

    // You should not need any additional field variables

    /**
     * This sets the classification of the animal to Reptile
     * 
     * @param spec
     *            - the "muggle" name
     * @param crazy
     *            - the new and improved name
     */
    public Reptile(String spec, String crazy) {
        super(spec, crazy);
    }
    public String toString() {
        return super.toString() + "Reptile";
    }


}
