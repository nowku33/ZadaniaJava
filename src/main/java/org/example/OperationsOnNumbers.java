package org.example;

import java.util.Collections;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class OperationsOnNumbers {
    private OperationsOnNumbers() {
    }

    public static void printAddSubDivMultiModuloCalculations(List<Integer> numberList) {
        if (numberList.size() > 1) {
            int addition = numberList.get(0);
            int subtraction = numberList.get(0);
            int multiplication = numberList.get(0);
            int modulo = numberList.get(0);
            float division = numberList.get(0);
            for (int i = 1; i < numberList.size(); i++) {
                addition = addition + numberList.get(i);
                subtraction = subtraction - numberList.get(i);
                multiplication = multiplication * numberList.get(i);
                try {
                    modulo = modulo % numberList.get(i);
                    division = division / numberList.get(i);
                } catch (ArithmeticException e) {
                    System.out.println("You can not divide by 0!");
                }
            }
            System.out.println("addition of all numbers" + numberList + addition);
            System.out.println("a-b+...=" + subtraction);
            System.out.println("a*b-...=" + multiplication);
            System.out.println("a:b:...=" + division);
            System.out.println("a%b%...=" + modulo);
        } else {
            System.out.println("Please provide at least 2 numbers");
        }
    }

    public static Map<String, Number> getSumAndAverageOfDigits(int number) {
        long sum = 0;
        double average = 0;
        int numberOfDigits = 0;
        while (number > 0) {
            numberOfDigits++;
            int digit = number % 10;
            sum = sum + digit;
            number = number / 10;
        }
        try {
            average = sum / numberOfDigits;
        } catch (ArithmeticException e) {
            System.out.println("You can not divide by 0!");
        }
        Map<String, Number> sumAndAverageOfDigits = new HashMap<>();
        sumAndAverageOfDigits.put("sum", sum);
        sumAndAverageOfDigits.put("average", average);
        return sumAndAverageOfDigits;
    }

    public static Map<String, Number> getGreatestAndSmallestNumber(List<Integer> numberList) {
        Collections.sort(numberList);
        Map<String, Number> smallestAndGreatestNumber = new HashMap<>();
        smallestAndGreatestNumber.put("greatestDigit", numberList.get(numberList.size() - 1));
        smallestAndGreatestNumber.put("smallestDigit", numberList.get(0));
        return smallestAndGreatestNumber;
    }

    public static void calculator(int a, int b, char mathOperation) {
        switch (mathOperation) {
            case '+':
                int addition = a + b;
                System.out.println("a + b = " + addition);
                break;
            case '-':
                int subtraction = a - b;
                System.out.println("a - b = " + subtraction);
                break;
            case '*':
                int multiplication = a * b;
                System.out.println("a * b = " + multiplication);
                break;
            case ':':
                float division = (float) a / b;
                System.out.println("a / b = " + division);
                break;
            case '%':
                float percent = (float) b * 100 / a;
                System.out.println("a / b = " + percent);
                break;
            default:
                System.out.println("Unknown math operation. Allowed operations: +, -, *, :, %");
                break;
        }
    }
}
