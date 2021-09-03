import org.junit.Rule;
import org.junit.Test;
import org.junit.rules.Timeout;

import java.awt.*;
import java.lang.reflect.Field;
import java.lang.reflect.Modifier;
import java.util.concurrent.TimeUnit;

import static org.junit.Assert.*;

public class ShapeTest {
    @Rule
    public Timeout globalTimeout = new Timeout(2, TimeUnit.SECONDS);

    @Test
    public void testReflection() {
        Class<?> iClass = Shape.class;
        Field[] iFields = iClass.getDeclaredFields();

        for (Field f : iFields) {
            if (!f.isSynthetic()) {
                assertTrue("Field \"" + f.getName() + "\" should be private", Modifier.isPrivate(f.getModifiers()));
                assertFalse("Field \"" + f.getName() + "\" can't be static", Modifier.isStatic(f.getModifiers()));
            }
        }
    }

    @Test
    public void testGetDistanceSamePoint() {
        Point point = new Point(2, -2);
        double actual = Shape.getDistance(point, point);
        double expected = 0.0;
        assertEquals("Incorrect distance", expected, actual, 0.0001);
    }

    @Test
    public void testGetDistanceVerticalPositive() {
        Point pointA = new Point(3, -3);
        Point pointB = new Point(3, 3);
        double actual = Shape.getDistance(pointA, pointB);
        double expected = 6.0;
        assertEquals("Incorrect distance", expected, actual, 0.0001);
    }

    @Test
    public void testGetDistanceHorizontalNegative() {
        Point pointA = new Point(-4, 4);
        Point pointB = new Point(4, 4);
        double actual = Shape.getDistance(pointA, pointB);
        double expected = 8.0;
        assertEquals("Incorrect distance", expected, actual, 0.0001);
    }

    @Test
    public void testGetDistanceInclinedRightPositive() {
        Point pointA = new Point(-5, 1);
        Point pointB = new Point(5, -1);
        double actual = Shape.getDistance(pointA, pointB);
        double expected = 10.198039027185569660056448218046;
        assertEquals("Incorrect distance", expected, actual, 0.0001);
    }

    @Test
    public void testGetDistanceInclinedLeftNegative() {
        Point pointA = new Point(-1, -2);
        Point pointB = new Point(3, 4);
        double actual = Shape.getDistance(pointA, pointB);
        double expected = 7.211102550927978586238442534941;
        assertEquals("Incorrect distance", expected, actual, 0.0001);
    }

    @Test
    public void testGetPerimeter() {
        Shape a = new Shape("LOL");
        double expected = -1.0;
        double actual = a.getPerimeter();
        assertEquals("Shape's getPerimeter returns an incorrect value of " + actual, expected, actual, 0.0000001);
    }

    @Test
    public void testGetArea() {
        Shape a = new Shape("LOL");
        double expected = -1.0;
        double actual = a.getArea();
        assertEquals("Shape's getArea returns an incorrect value of " + actual, expected, actual, 0.0000001);
    }
}
