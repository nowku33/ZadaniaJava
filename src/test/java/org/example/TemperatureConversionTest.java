package org.example;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;

import java.util.stream.Stream;

import static org.junit.jupiter.params.provider.Arguments.arguments;

class TemperatureConversionTest {
    static Stream<Arguments> tempConversionArgumentProvider() {
        return Stream.of(
                arguments(0, 32),
                arguments(200, 392),
                arguments(-100, -148)
        );
    }

    @ParameterizedTest
    @MethodSource("tempConversionArgumentProvider")
    void getConvertedCelsiusToFahrenheit(double celsiusValue, double expectedFahrenheitValue) {
        double actualFahrenheitValue = TemperatureConversion.getConvertedCelsiusToFahrenheit(celsiusValue);
        Assertions.assertEquals(expectedFahrenheitValue, actualFahrenheitValue);
    }

    @ParameterizedTest
    @MethodSource("tempConversionArgumentProvider")
    void getConvertedFahrenheitToCelsius(double expectedCelsiusValue, double fahrenheitValue) {
        double actualCelsiusValue = TemperatureConversion.getConvertedFahrenheitToCelsius(fahrenheitValue);
        Assertions.assertEquals(expectedCelsiusValue, actualCelsiusValue);
    }
}