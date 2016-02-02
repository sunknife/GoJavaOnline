import org.junit.Assert;
import org.junit.BeforeClass;
import org.junit.Test;

import static org.junit.Assert.*;


public class ExtremumsAndSortingTest {
    private static ExtremumsAndSorting extremum;
    private static int[] array = {1,0,5,7,-2,9,3};

    @BeforeClass
    public static void setUp(){
        extremum=new ExtremumsAndSorting();

    }

    @Test
    public void testMinimalValue() throws Exception {
        Assert.assertEquals(-2,extremum.minimalValue(array));
    }

    @Test
    public void testMinimalValueWithBounds() throws Exception {
        Assert.assertEquals(0,extremum.minimalValue(array,0,2));
    }

    @Test
    public void testMaximumValue() throws Exception {
        Assert.assertEquals(9,extremum.maximumValue(array));
    }

    @Test
    public void testMaximumValueWithBounds() throws Exception {
        Assert.assertEquals(7,extremum.maximumValue(array,0,3));
    }
}