/**
 * @author Avery's PC
 * @version 2/9/18
 */
public class Lock extends InvalidLockCombinationException {
    protected Combination combo;
    protected int limit;
    protected boolean locked;
    /**
     * default constructors
     * @param aLimit
     * @param myCombo
     */
    public Lock (int aLimit, Combination myCombo) {
        limit = aLimit;
        locked = true;
        if (myCombo.isWithinRange(limit)) {
            combo = myCombo;
        }
        else {
            throw new InvalidLockCombinationException();
        }
    }
    /**
     * gets the dial limit
     * @return limit
     */
    public int getDialLimit() {
        return limit;
    }
    /**
     * tests the combination
     * @param testMe
     * @return open
     */
    public boolean open(Combination testMe) {
        boolean open  = false;
        if (locked == true) {
            open = true;
        }
        if (combo.equals(testMe)) {
            locked = true;
            open = true;
        }
        return open;
    }
    /**
     * checks to see if lock is locked
     */
    public void close() {
        locked = false;
    }
    /**
     * checks to see if open
     * @return locked
     */
    public boolean isOpen() {
        return locked;
    }
}
