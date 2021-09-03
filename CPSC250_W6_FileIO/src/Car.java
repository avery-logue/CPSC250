/* This class is missing JavaDoc, but that is OK */
public class Car {
    private int year;
    private String make;
    private String model;
    private double price;

    public Car(int aYear, String aMake, String aModel, double aPrice) {
        year = aYear;
        make = aMake;
        model = aModel;
        price = aPrice;
    }

    public int getYear() {
        return year;
    }

    public String getMake() {
        return make;
    }

    public String getModel() {
        return model;
    }

    public double getPrice() {
        return price;
    }

    /* safe equals check */
    @Override
    public boolean equals(Object anObject) {
        if ((anObject == null) || (this.getClass() != anObject.getClass())) {
            return false;
        }

        Car aCar = (Car) anObject;
        int aYear = aCar.getYear();
        String aMake = aCar.getMake();
        String aModel = aCar.getModel();
        double aPrice = aCar.getPrice();

        if (year == aYear && make.equals(aMake) && price == aPrice
                && model.equals(aModel)) {
            // Equal only if all field variables are equal
            return true;
        }

        return false;
    }

    /* Create a hash code to let us sort cars */
    @Override
    public int hashCode() {
        final int prime = 31;
        int result = 1;
        result = prime * result + ((make == null) ? 0 : make.hashCode());
        result = prime * result + ((model == null) ? 0 : model.hashCode());
        long temp;
        temp = Double.doubleToLongBits(price);
        result = prime * result + (int) (temp ^ (temp >>> 32));
        result = prime * result + year;
        return result;
    }
}
