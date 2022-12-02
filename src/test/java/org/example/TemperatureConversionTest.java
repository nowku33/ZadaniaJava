package org.example;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import java.util.Random;

class TemperatureConversionTest {
    private static final int CONVERTING_OFFSET = 32;
    private static final double CONVERTING_CONSTANT = 1.8;

    @Test
    void getConvertedCelsiusToFahrenheit() {
        Random random = new Random();
        double generatedCelsiusValue = random.nextDouble();
        double expectedFahrenheitValue = CONVERTING_CONSTANT * generatedCelsiusValue + CONVERTING_OFFSET;
        double actualFahrenheitValue = TemperatureConversion.getConvertedCelsiusToFahrenheit(generatedCelsiusValue);
        Assertions.assertEquals(expectedFahrenheitValue, actualFahrenheitValue);
    }

    @Test
    void getConvertedFahrenheitToCelsius() {
        Random random = new Random();
        double generatedFahrenheitValue = random.nextDouble();
        double expectedCelsiusValue = (generatedFahrenheitValue - CONVERTING_OFFSET) / CONVERTING_CONSTANT;
        double actualCelsiusValue = TemperatureConversion.getConvertedFahrenheitToCelsius(generatedFahrenheitValue);
        Assertions.assertEquals(expectedCelsiusValue, actualCelsiusValue);
    }
}