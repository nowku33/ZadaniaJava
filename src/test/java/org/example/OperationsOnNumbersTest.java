package org.example;

import org.junit.Assert;
import org.junit.jupiter.api.Test;

import java.util.*;

class OperationsOnNumbersTest {

    @Test
    void getSumAndAverageOfDigits() {
        int minRandomNumberValue = 1;
        int maxRandomNumberValue = 20000;
        Random random = new Random();
        int generatedRandomNumber = random.nextInt(maxRandomNumberValue - minRandomNumberValue) + minRandomNumberValue;
        int numberToPassToTestedMethod = generatedRandomNumber;
        int numberOfDigits = 0;
        long expectedSum = 0;
        double expectedAverage;
        while (generatedRandomNumber > 0) {
            numberOfDigits++;
            int digit = generatedRandomNumber % 10;
            expectedSum = expectedSum + digit;
            generatedRandomNumber = generatedRandomNumber / 10;
        }
        expectedAverage = expectedSum / numberOfDigits;
        Map<String, Number> expectedSumAndAverageOfDigits = new HashMap<>();
        expectedSumAndAverageOfDigits.put("sum", expectedSum);
        expectedSumAndAverageOfDigits.put("average", expectedAverage);
        Map<String, Number> actualSumAndAverageOfDigits = OperationsOnNumbers.getSumAndAverageOfDigits(numberToPassToTestedMethod);
        Assert.assertEquals(expectedSumAndAverageOfDigits, actualSumAndAverageOfDigits);

    }

    @Test
    void getGreatestAndSmallestNumber() {
        int generatedListSize = 3;
        List<Integer> generatedNumberList = getRandomNumberList(generatedListSize);
        Collections.sort(generatedNumberList);
        Map<String, Number> expectedSmallestAndGreatestNumber = new HashMap<>();
        expectedSmallestAndGreatestNumber.put("greatestDigit", generatedNumberList.get(generatedNumberList.size() - 1));
        expectedSmallestAndGreatestNumber.put("smallestDigit", generatedNumberList.get(0));
        Map<String, Number> actualSmallestAndGreatestNumber = OperationsOnNumbers.getGreatestAndSmallestNumber(generatedNumberList);
        Assert.assertEquals(expectedSmallestAndGreatestNumber, actualSmallestAndGreatestNumber);
    }

    private List<Integer> getRandomNumberList(int listSize) {
        List<Integer> randomNumberList = new ArrayList<>();
        Random random = new Random();
        for (int i = 0; i < listSize; i++) {
            randomNumberList.add(random.nextInt());
        }
        return randomNumberList;
    }
}