import calculatorLibrary.BaseCalculator;
import org.junit.BeforeClass;

public class BaseCalculatorTest {
    private static BaseCalculator example;
    @BeforeClass
    public static void setup() {

        example = new BaseCalculator();
    }

    @org.junit.Test
    public void testRead() throws Exception {
        example.read("6.5*7");
        System.out.println(example.getResult());
    }
}