package org.example;

public class TemperatureConversion {

    private TemperatureConversion() {
        throw new IllegalStateException("Utility class");
    }

    private static final int CONVERTING_OFFSET = 32;
    private static final double CONVERTING_CONSTANT = 1.8;

    public static void convertCelsiusToFarenheit(double celsiusValue) {

        double farenheitValue = CONVERTING_CONSTANT *celsiusValue+ CONVERTING_OFFSET;

        System.out.println(celsiusValue + " Celsius dagrees is equal to " + farenheitValue + " Farenheit degres");

    }

    public static void convertFarenheitToCelsius(double farenheitValue) {

        double celsiusValue = (farenheitValue- CONVERTING_OFFSET)/ CONVERTING_CONSTANT;

        System.out.println(farenheitValue + " Farenheit dagrees is equal to " + celsiusValue + " Celsius degres");

    }


}
