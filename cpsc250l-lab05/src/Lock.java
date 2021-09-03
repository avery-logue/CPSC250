import java.util.Scanner;

import javax.swing.JOptionPane;

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
    public void resetNaive() {

        String comboStr = JOptionPane.showInputDialog("Type a new combination");

        if(comboStr == null){
            return;
        }

        Scanner scan = new Scanner(comboStr);
        int num1 = scan.nextInt();
        int num2 = scan.nextInt();
        int num3 = scan.nextInt();

        scan.close();

        Combination c = new Combination(num1, num2, num3);

        if(!c.isWithinRange(limit)){
            throw new InvalidLockCombinationException();
        }

        combo = new Combination(num1, num2, num3);
    }
    public void resetRetry(){
        int count = 0;
        while(!locked || count == 0){

            try{
                resetNaive();
            }
            catch(InvalidLockCombinationException e){
                JOptionPane.showMessageDialog(null, "Type 3 integers in the range [0.."+limit+"]");
                continue;
            }
            catch(Exception e){
                JOptionPane.showMessageDialog(null, "Type 3 integers separated by spaces");
                continue;
            }   
            locked = true;
            count++;
        }
    }
}
