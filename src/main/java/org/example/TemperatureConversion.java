package org.example;

public class TemperatureConversion {
    private TemperatureConversion() {
    }

    private static final int CONVERTING_OFFSET = 32;
    private static final double CONVERTING_CONSTANT = 1.8;

    public static void printConvertedCelsiusToFahrenheit(double celsiusValue) {
        double fahrenheitValue = CONVERTING_CONSTANT * celsiusValue + CONVERTING_OFFSET;
        System.out.println(celsiusValue + " Celsius degrees is equal to " + fahrenheitValue + " Fahrenheit degrees");
    }

    public static void printConvertedFahrenheitToCelsius(double fahrenheitValue) {
        double celsiusValue = (fahrenheitValue - CONVERTING_OFFSET) / CONVERTING_CONSTANT;
        System.out.println(fahrenheitValue + " Fahrenheit degrees is equal to " + celsiusValue + " Celsius degrees");
    }
}
