import java.awt.Point;

public class Quadrilateral extends Shape{

    protected Quadrilateral (Point[] aPoints) {
        super("Quadrilateral");
        Point[] four = {aPoints[0], aPoints[1], aPoints[2], aPoints[3]};
        setPoints(four);
    }
    @Override
    public double getPerimeter() {

        Point[] three = getPoints();

        double a = getDistance(three[0], three[1]);
        double b = getDistance(three[1], three[2]);
        double c = getDistance(three[2], three[3]);
        double d = getDistance(three[3], three[0]);

        return a + b + c + d;
    }
    @Override
    public double getArea() {
        Point[] ar = getPoints();
        
        double one = ar[0].getX()*ar[1].getY() - ar[0].getY()*ar[1].getX();
        double two = ar[1].getX()*ar[2].getY() - ar[1].getY()*ar[2].getX();
        double three = ar[2].getX()*ar[3].getY() - ar[2].getY()*ar[3].getX();
        double four = ar[3].getX()*ar[0].getY() - ar[3].getY()*ar[0].getX();
        
        double finale = (one + two + three + four) * 1/2;
        
        Math.abs(finale);
        
        return Math.abs(finale);
    }
}
