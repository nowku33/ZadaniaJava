package org.example;

import lombok.extern.log4j.Log4j2;

import java.util.Collections;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Log4j2
public class OperationsOnNumbers {
    private OperationsOnNumbers() {
    }

    public static Map<String, Number> getSumAndAverageOfDigits(int number) {
        int sum = 0;
        double average = 0;
        int numberOfDigits = 0;
        while (number > 0) {
            numberOfDigits++;
            int digit = number % 10;
            sum = sum + digit;
            number = number / 10;
        }
        if (numberOfDigits != 0) {
            average = (double) sum / numberOfDigits;
        } else {
            log.info(MainApp.getLanguageBundle().getString("divisionByZeroMsg"));
        }
        Map<String, Number> sumAndAverageOfDigits = new HashMap<>();
        sumAndAverageOfDigits.put("sum", sum);
        sumAndAverageOfDigits.put("average", average);
        return sumAndAverageOfDigits;
    }

    public static Map<String, Number> getGreatestAndSmallestNumber(List<Integer> numberList) {
        Collections.sort(numberList);
        Map<String, Number> smallestAndGreatestNumber = new HashMap<>();
        smallestAndGreatestNumber.put("greatestNumber", numberList.get(numberList.size() - 1));
        smallestAndGreatestNumber.put("smallestNumber", numberList.get(0));
        return smallestAndGreatestNumber;
    }

    public static void calculator(int a, int b, char mathOperation) {
        switch (mathOperation) {
            case '+' -> {
                int addition = a + b;
                log.info("a + b = " + addition);
            }
            case '-' -> {
                int subtraction = a - b;
                log.info("a - b = " + subtraction);
            }
            case '*' -> {
                int multiplication = a * b;
                log.info("a * b = " + multiplication);
            }
            case ':' -> {
                float division = (float) a / b;
                log.info("a / b = " + division);
            }
            case '%' -> {
                float percent = (float) b * 100 / a;
                log.info("a / b = " + percent);
            }
            default -> log.info(MainApp.getLanguageBundle().getString("unknownMathOperationMsg"));
        }
    }

    public static int getAdditionResult(List<Integer> numberList) {
        int additionResult = numberList.get(0);
        for (int i = 1; i < numberList.size(); i++) {
            additionResult = additionResult + numberList.get(i);
        }
        return additionResult;
    }

    public static int getSubtractionResult(List<Integer> numberList) {
        int subtractionResult = numberList.get(0);
        for (int i = 1; i < numberList.size(); i++) {
            subtractionResult = subtractionResult - numberList.get(i);
        }
        return subtractionResult;
    }

    public static int getMultiplicationResult(List<Integer> numberList) {
        int multiplicationResult = numberList.get(0);
        for (int i = 1; i < numberList.size(); i++) {
            multiplicationResult = multiplicationResult * numberList.get(i);
        }
        return multiplicationResult;
    }

    public static int getModuloResult(List<Integer> numberList) {
        int moduloResult = numberList.get(0);
        for (int i = 1; i < numberList.size(); i++) {
            moduloResult = moduloResult * numberList.get(i);
        }
        return moduloResult;
    }

    public static float getDivisionResult(List<Integer> numberList) {
        float divisionResult = numberList.get(0);
        for (int i = 1; i < numberList.size(); i++) {
            divisionResult = divisionResult / numberList.get(i);
        }
        return divisionResult;
    }
}
