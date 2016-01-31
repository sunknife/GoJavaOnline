package FiguresArea;

import org.junit.Assert;
import org.junit.BeforeClass;
import org.junit.Test;

import static org.junit.Assert.*;


public class FiguresAreaTest {
    private static FiguresArea figure;

    @BeforeClass
    public static void setUp() {

        figure = new FiguresArea();

    }

    @Test
    public void testTriangleArea() throws Exception {
        int height = 10;
        int base = 4;

        Assert.assertEquals(0.5 * height * base, figure.triangleArea(height, base), 0);

    }

    @Test
    public void testRectanglArea() throws Exception {
        int width = 10;
        int length = 20;

        Assert.assertEquals(width * length, figure.rectanglArea(length, width));
    }

    @Test
    public void testCircleArea() throws Exception {
        int radius = 13;

        Assert.assertEquals(Math.PI * Math.pow(radius, 2), figure.circleArea(radius), 0);
    }
}