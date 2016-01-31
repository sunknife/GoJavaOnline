package TemperatureConversion;

import org.junit.Assert;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;

import static org.junit.Assert.*;


public class TemperatureConversionTest {
    private static TemperatureConversion convertor;

    @BeforeClass
    public static void setUp() throws Exception {
        convertor = new TemperatureConversion();
    }

    @Test
    public void testCelsiusToFahrenheit() throws Exception {
        double temperature = 15;

        Assert.assertEquals(temperature * 9 / 5 + 32, convertor.celsiusToFahrenheit(temperature), 0);

    }

    @Test
    public void testFahrenheitToCelsius() throws Exception {
        double temperature = 10;

        Assert.assertEquals((temperature - 32) * 5 / 9, convertor.fahrenheitToCelsius(temperature), 0);

    }
}