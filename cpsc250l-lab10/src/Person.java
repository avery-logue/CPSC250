
public class Person implements Comparable<Person>{
    private String name = "";
    
    public Person(String _name) {
        name = _name;
    }
    
    public String getName() {
        return name;
    }
    
    public void setName(String _name) {
        name = _name;
    }
    
    public Person copy() {
        Person copy = new Person(this.getName());
        return copy;
    }
    @Override
    public int compareTo(Person other) {
        //other = (Person)other;
        //String otherName = ((Person) other).getName();
        return name.compareTo(other.getName());
    }
    @Override
    public boolean equals (Object other) {
        if (other instanceof Person && this.getClass() == other.getClass()) {
            Person otherPerson = (Person) other;
            String otherName = otherPerson.getName();
            
            if (name.equals(otherName)) {
                return true;
            }
        }
        return false;
    }

}
