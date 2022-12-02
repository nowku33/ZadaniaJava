package org.example;

public class TemperatureConversion {
    private TemperatureConversion() {
    }

    private static final int CONVERTING_OFFSET = 32;
    private static final double CONVERTING_CONSTANT = 1.8;

    public static double getConvertedCelsiusToFahrenheit(double celsiusValue) {
        return CONVERTING_CONSTANT * celsiusValue + CONVERTING_OFFSET;
    }

    public static double getConvertedFahrenheitToCelsius(double fahrenheitValue) {
        return (fahrenheitValue - CONVERTING_OFFSET) / CONVERTING_CONSTANT;
    }
}
