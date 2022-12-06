package org.example;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;

import java.util.Random;

class TemperatureConversionTest {

    @ParameterizedTest
    @CsvSource({"0,32", "200,392", "-100,-148"})
    void getConvertedCelsiusToFahrenheit(double celsiusValue, double expectedFahrenheitValue) {
        double actualFahrenheitValue = TemperatureConversion.getConvertedCelsiusToFahrenheit(celsiusValue);
        Assertions.assertEquals(expectedFahrenheitValue, actualFahrenheitValue);
    }

    @ParameterizedTest
    @CsvSource({"32,0", "392,200", "-148,-100"})
    void getConvertedFahrenheitToCelsius(double fahrenheitValue, double expectedCelsiusValue) {
        double actualCelsiusValue = TemperatureConversion.getConvertedFahrenheitToCelsius(fahrenheitValue);
        Assertions.assertEquals(expectedCelsiusValue, actualCelsiusValue);
    }
}