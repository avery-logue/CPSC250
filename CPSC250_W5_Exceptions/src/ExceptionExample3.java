
public class ExceptionExample3 {
    public static void main(String args[]) {
        try {
            method_A();
            System.out.println("Yahoo!");
        }
        catch (RuntimeException e) {
            System.out.println("Runtime rules!");
        }
        System.out.println("I love Rock’n Roll");
    }

    public static void method_A() {
        try {
            // arithmetic exception
            int divByZero = 12 / 0;
            System.out.println(" divByZero=" + divByZero);
        }
        catch (Exception e) {
            System.out.println(e);
            throw new MyException(e.getMessage());
        }
        finally {
            System.out.println("Tootles");
        }
    }
}
