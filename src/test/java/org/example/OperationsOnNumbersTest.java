package org.example;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;

import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;
import java.util.stream.Stream;

class OperationsOnNumbersTest {

    @ParameterizedTest
    @CsvSource(delimiter = '|', textBlock = """
            1111       |  4  | 1
            0000       |  0  | 0
            124567     |  25 | 4.166666666666667
            2147483647 |  46 | 4.6
            1090       |  10 | 2.5
            """)
    void getSumAndAverageOfDigits(int number, int expectedSum, double expectedAverage) {
        Map<String, Number> expectedSumAndAverageOfDigits = new HashMap<>();
        expectedSumAndAverageOfDigits.put("sum", expectedSum);
        expectedSumAndAverageOfDigits.put("average", expectedAverage);
        Map<String, Number> actualSumAndAverageOfDigits = OperationsOnNumbers.getSumAndAverageOfDigits(number);
        Assertions.assertEquals(expectedSumAndAverageOfDigits, actualSumAndAverageOfDigits);
    }

    @ParameterizedTest
    @CsvSource(delimiter = '|', textBlock = """
            1,1,1,1                 |   1   | 1
            0,1,2,3,4,5,6,7         |   7   | 0
            -1,2,100,1000,-2000,6,7 |  1000 | -2000
            """)
    void getGreatestAndSmallestNumber(String numbersString, int expectedGreatestNumber, int expectedSmallestNumber) {
        List<Integer> numberList = Stream.of(numbersString.split(","))
                .map(Integer::parseInt).collect(Collectors.toList());
        Map<String, Number> expectedSmallestAndGreatestNumber = new HashMap<>();
        expectedSmallestAndGreatestNumber.put("greatestNumber", expectedGreatestNumber);
        expectedSmallestAndGreatestNumber.put("smallestNumber", expectedSmallestNumber);
        Map<String, Number> actualSmallestAndGreatestNumber = OperationsOnNumbers.getGreatestAndSmallestNumber(numberList);
        Assertions.assertEquals(expectedSmallestAndGreatestNumber, actualSmallestAndGreatestNumber);
    }
}