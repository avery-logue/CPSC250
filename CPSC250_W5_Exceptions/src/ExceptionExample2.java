public class ExceptionExample2 {
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
        }
        System.out.println("TTFN!");
    }

    public static void method_A() throws Exception {
        throw new Exception();

        // int divByZero = 12 / 0;
        // System.out.println(" divByZero=" + divByZero);
    }
}
