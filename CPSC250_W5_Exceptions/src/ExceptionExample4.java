
public class ExceptionExample4 {
    public static void main(String args[]) {
        try {
            method_A();
            System.out.println("Yahoo!");
        }
        catch (Exception e) {
            System.out.println("Exception first!");
        }
    }

    public static void method_A() {
        int a = 12;
        int b = 2;
        if (b != 0) {
            // arithmetic exception
            int divByZero = a / b;
            System.out.println(" division=" + divByZero);
        }
        else {
            System.out.println(" skip division if b==0");
            throw new RuntimeException();
        }
    }
}
