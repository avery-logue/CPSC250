import java.awt.Point;
public class Shape {
    
    private String name;
    private Point[] points;

    protected Shape(String aName) {
        name = aName;
    }
    public final String getName() {
        return name;
    }
    protected final void setPoints(Point[] thePoints) {
        points = thePoints;
    }
    public final Point[] getPoints() {
        return points;
    }
    public double getPerimeter() {
        return -1;
    }
    public double getArea() {
        return -1;
    }
    public static double getDistance(Point p1, Point p2) {
        double one = Math.pow(p1.getX() - p2.getX(), 2);
        double two = Math.pow(p1.getY() - p2.getY(), 2);
        double a = one + two;
        return Math.sqrt(a);
    }
}
