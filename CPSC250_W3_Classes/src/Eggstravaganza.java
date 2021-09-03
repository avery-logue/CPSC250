/**
 * Class used to demonstrate our 2D arrays for CPSC 250 Spring 2017
 * 
 * @author David Conner (david.conner@cnu.edu)
 * @version 0
 *
 */

public class Eggstravaganza {

    /**
     * The main method that depends on Egg class
     * 
     * @param args
     */
    public static void main(String[] args) {

        // Create some eggs
        Egg egg1 = new Egg();
        Egg egg2 = new Egg('s', "white", true);

        System.out.println(" --- Print individual egg data ---");
        Egg.printEgg(egg1);
        Egg.printEgg(egg2);
        
        Egg[] carton = new Egg[4];
        carton[0] = egg1;
        carton[1] = egg2;
        System.out.println("Carton " + carton);
        Egg.printCarton(carton);

        Egg[][] bag = new Egg[3][];

        bag[1] = carton;
        bag[0] = carton;
        bag[2] = carton;

        bag[1][2] = new Egg('l', "purple", false);
        System.out.println("");
        System.out.println("   -- bag o' cartons --");
        for (int i = 0; i < bag.length; i++) {
            Egg.printCarton(bag[i]);
            //System.out.println(bag[i]);
        }
    }

}
