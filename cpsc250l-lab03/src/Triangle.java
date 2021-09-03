import java.awt.Point;

public class Triangle extends Shape{
    
    protected Triangle (Point[] aPoints) {
        super("Triangle");
        Point[] three = {aPoints[0], aPoints[1], aPoints[2]};
        setPoints(three);
    }
    @Override
    public double getPerimeter() {
        
        Point[] three = getPoints();
        
        double a = getDistance(three[0], three[1]);
        double b = getDistance(three[1], three[2]);
        double c = getDistance(three[2], three[0]);
        
        return a + b + c;
    }
    @Override
    public double getArea() {
        Point[] ar = getPoints();
        double one = ar[0].getX()*(ar[1].getY() - ar[2].getY());
        double two = ar[1].getX()*(ar[2].getY() - ar[0].getY());
        double three = ar[2].getX()*(ar[0].getY() - ar[1].getY());
        
        double finale = (one + two + three) * 1/2;
        
        Math.abs(finale);
        
        return Math.abs(finale);
    }
}
