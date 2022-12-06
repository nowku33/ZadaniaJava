package org.example;

import org.junit.Assert;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;

import java.util.*;
import java.util.stream.Collectors;
import java.util.stream.Stream;

class OperationsOnNumbersTest {

    @ParameterizedTest
    @CsvSource({"1111,4,1", "0000,0,0", "124567,25,4", "2147483647,46,4"})
    void getSumAndAverageOfDigits(int number, int expectedSum, double expectedAverage) {
        Map<String, Number> expectedSumAndAverageOfDigits = new HashMap<>();
        expectedSumAndAverageOfDigits.put("sum", expectedSum);
        expectedSumAndAverageOfDigits.put("average", expectedAverage);
        Map<String, Number> actualSumAndAverageOfDigits = OperationsOnNumbers.getSumAndAverageOfDigits(number);
        Assert.assertEquals(expectedSumAndAverageOfDigits, actualSumAndAverageOfDigits);

    }

    @ParameterizedTest
    @CsvSource({"'1,1,1,1',1,1", "'0,1,2,3,4,5,6,7',7,0", "'-1,2,100,1000,-2000,6,7',1000,-1000"})
    void getGreatestAndSmallestNumber(String numbersString, int expectedGreatestNumber, int expectedSmallestNumber) {
        List<Integer> numberList = Stream.of(numbersString.split(","))
                .map(Integer::parseInt)
                .collect(Collectors.toList());
        Collections.sort(numberList);
        Map<String, Number> expectedSmallestAndGreatestNumber = new HashMap<>();
        expectedSmallestAndGreatestNumber.put("greatestDigit", numberList.get(numberList.size() - 1));
        expectedSmallestAndGreatestNumber.put("smallestDigit", numberList.get(0));
        Map<String, Number> actualSmallestAndGreatestNumber = OperationsOnNumbers.getGreatestAndSmallestNumber(numberList);
        Assert.assertEquals(expectedSmallestAndGreatestNumber, actualSmallestAndGreatestNumber);
    }
}