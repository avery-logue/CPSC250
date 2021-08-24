/**
 * Class represents a time value in seconds since Jan 1, 1970, and fractional
 * nanoseconds.
 *
 * We need to compare two time references and be able to use in Collections.sort
 * method.
 * 
 * Hint: You might need to implement a particular interface
 */
public class Time implements Comparable<Time> {

    // vvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvv
    // --------------- Do not change this part ---------------
    /**
     * seconds since Jan 1, 1970
     */
    private int seconds;
    /**
     * nanoseconds since last whole second (0 -- 999,999,999)
     */
    private int nanoseconds;

    public Time(int sec, int nano) {
        seconds = sec;
        nanoseconds = nano;
    }
    // --------------- Do not change this part ---------------
    // ^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^
    //
    //
    // vvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvv
    // ------------------- Modify this part -------------------
    /**
     * Write method to compare two Time instances.
     * 
     * The method should allow me to use the Collections.sort to sort an array
     * list of Time references.
     * 
     * To sort, first consider the whole seconds.
     * 
     * If those are different, then sort on the whole seconds.
     * 
     * If whole seconds are equal then sort on nanoseconds. Thus Time(1, 20000)
     * < Time(1, 29999) < Time(2, 29999)
     */
    @Override
    public int compareTo(Time one) {
        if(seconds == one.seconds) {
            return nanoseconds - one.nanoseconds;
        }
        else {
            return seconds - one.seconds;
        }

    }

}
