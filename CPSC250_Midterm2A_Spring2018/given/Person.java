/**
 * Simple class used to name and age of a person
 * 
 * @author 250 instructor
 * @version 0
 */
public class Person {
    private String name;

    public Person(String name_) {
        name = name_;
    }

    public String getName() {
        return name;
    }

    public boolean equals(Object other) {
        if (other instanceof Person) { // Equal if their names are equal for
                                       // this test
                                       // Will ignore their race
            return name.equals(((Person) other).getName());
        }
        return false;
    }
}
