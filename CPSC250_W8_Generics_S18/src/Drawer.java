import java.util.ArrayList;

/**
 * Drawer holds a bunch of stuff
 * 
 * @author <student>
 * @version 0
 * @param <T>
 */
public class Drawer<T> {

    /** Field variable to hold instances of stuff in drawer */
    private ArrayList<T> stuff;

    /** Construct empty drawer */
    public Drawer() {
        stuff = new ArrayList<T>();
    }

    /**
     * Remove the first item from drawer and return
     * 
     * @return reference to the former first item
     */
    public T getItem() {
        if (stuff == null || stuff.isEmpty()) {
            return null;
        }
        T a = stuff.get(0);
        stuff.remove(0);
        return a;
    }

    /**
     * Add an item to the drawer
     * 
     * @param anItem
     *            - instance to be added to drawer
     */
    public void putItem(T anItem) {
        if (stuff == null) {
            return;
        }
        stuff.add(anItem);
    }

    /**
     * anything in our drawer?
     * 
     * @return true if something is there; false if empty
     */
    public boolean hasStuff() {
        return !stuff.isEmpty();
    }
}
