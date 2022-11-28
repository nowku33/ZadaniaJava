package org.example;

import static org.example.OperationsOnNumbers.*;
import static org.example.TemperatureConversion.*;
import static org.example.BmiCalculations.*;
import static org.example.DayCheck.*;

/**
 * Hello world!
 *
 */
public class MainApp
{
    public static void main( String[] args )
    {

        printAllVariables();
        basicCalculations(8, 3);
        convertCelsiusToFarenheit(14);
        convertFarenheitToCelsius(57.2);
        calculateSumOfDigits(2222);
        printGreatestAndSmallestDigit(1234);
        calculateBmi(78, 1.77);
        dayOfWeek(1);
        calculator(1,2, '+');

    }


}
