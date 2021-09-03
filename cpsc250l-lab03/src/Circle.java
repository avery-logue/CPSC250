import java.awt.Point;

public class Circle extends Shape{
    private double aRadius;
    protected Circle (Point aCenter, double radius) {
        super("Circle");
        Point[] center = {aCenter};
        setPoints(center);
        
        if (radius < 0) {
            aRadius = 0.0;
        }
        else {
            aRadius = radius;
        }
    }
    public double getRadius() {
        return aRadius;
    }
    @Override
    public double getPerimeter() {
        double radius = 2*(Math.PI * aRadius);
        return radius;
    }
    @Override
    public double getArea() {
        double radius = Math.pow(aRadius, 2);
        return radius * Math.PI;
    }

}
