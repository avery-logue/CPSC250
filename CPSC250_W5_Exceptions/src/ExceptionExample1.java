
public class ExceptionExample1 {
    public static void main(String args[]) {
        try {
            method_A();
            System.out.println("Yahoo!");
        }
        catch (RuntimeException e) {
            System.out.println("Runtime rules!");
            return;
        }
        catch (Exception e) {
            System.out.println("Exception first!");
            return;
        }
        finally { //always happens
            System.out.println(" finally!");
            // return;
        }
        System.out.println("I love Rock’n Roll");
    }

    public static void method_A() {
        int divbyzero = 12 / 0; 	// arithmetic
                                	// exception
        System.out.println("Tootles");
    }
}
