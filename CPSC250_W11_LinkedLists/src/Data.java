
/**
 * Write a description of class Data here.
 * 
 * @author (your name)
 * @version (a version number or a date)
 */

public class Data<T> {
    // instance variables - replace the example below with your own
    protected T data;

    public Data(T newData) {
        data = newData;
    }

    public T getData() {
        return data;
    }

    public void setData(T newData) {
        data = newData;
    }

    @Override
    public boolean equals(Object other) {
        if (other == null)
            return false;

        if (this.getClass() != other.getClass()) {
            return false;
        }

        Data<T> otherData = (Data<T>) other;
        System.out.println("  data equals =" + data.equals(otherData.getData())
        + "  " + data + "  =?=" + otherData.getData());
        return data.equals(otherData.getData());
    }

    public static void main(String[] args) {
        Integer a = new Integer(43);
        Integer b = new Integer(43);
        Integer c = a;
        System.out.println("  c==a?" + (c == a));
        System.out.println("  a==b " + (a == b));
        a = 43;
        System.out.println("  a==b " + (a == b));
        System.out.println("  c==a?" + (c == a));

    }
}
