package PointsDistance;

import org.junit.Assert;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;

import static org.junit.Assert.*;


public class DistanceTest {
    private static Distance distance;

    @BeforeClass
    public static void setUp() throws Exception {
        distance=new Distance();

    }

    @Test
    public void testDistanceBetweenTwoPoints() throws Exception {
        int x1=5;
        int x2=6;
        int y1=2;
        int y2=3;

        Assert.assertEquals(Math.sqrt((x2 - x1) * (x2 - x1) + (y2 - y1) * (y2 - y1)),distance.distanceBetweenTwoPoints(x1,y1,x2,y2),0);

    }
}