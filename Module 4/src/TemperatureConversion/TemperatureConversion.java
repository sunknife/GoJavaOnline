package TemperatureConversion;

public class TemperatureConversion {
    public double celsiusToFahrenheit(double temperatureInCelsius) {
        return temperatureInCelsius * 9 / 5 + 32;
    }

    public double fahrenheitToCelsius(double temperatureInFahrenheit) {
        return (temperatureInFahrenheit - 32) * 5 / 9;
    }
}
