
// DO NOT change this class
public class Animal {

    private String species; // Do not change this to public or protected!

    /** Don't modify this constructor */
    public Animal() {
        // Default constructor
        System.out.println(" If this called - something is wrong");
    }

    public Animal(String spec) {
        species = spec;
    }

    @Override
    public String toString() {
        return species;
    }
}
