package org.example;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class OperationsOnNumbers {

    private OperationsOnNumbers() {
        throw new IllegalStateException("Utility class");
    }

    public static void printAllVariables() {

        boolean booleanVar = true;
        char charVar = 'A';
        int intVar = 2;
        long longVar = 100000000000L;
        float floatVar = 0.001f;
        double doubleVar = 0.00000000001;
        String str = "Hello World!";

        System.out.println("booleanVar: " + booleanVar);
        System.out.println("charVar: " + charVar);
        System.out.println("intVar: " + intVar);
        System.out.println("longVar: " + longVar);
        System.out.println("floatVar: " + floatVar);
        System.out.println("doubleVar: " + doubleVar);
        System.out.println("String: " + str);

    }

    public static void basicCalculations(int a, int b) {

        int addition = a+b;
        int subtraction = a-b;
        int multiplication = a*b;
        float division = (float) a/b;
        float percent = (float) b*100/a;


        System.out.println("a+b=" +addition);
        System.out.println("a-b=" +subtraction);
        System.out.println("a*b=" +multiplication);
        System.out.println("a:b=" +division);
        System.out.println("b is "+percent+"% of a");

    }

    public static void calculateSumOfDigits(int number) {

        long sum=0;

        while(number>0)
        {
            sum=sum+number%10;
            number=number/10;
        }

        System.out.println("Sum: "+sum);
    }

    public static void printGreatestAndSmallestDigit(int number) {

        List<Integer> digitList = new ArrayList<>();

        while(number>0)
        {
            int digit=number%10;
            digitList.add(digit);
            number=number/10;
        }
        
        Collections.sort(digitList);
        System.out.println("Greatest digit: "+ digitList.get(digitList.size()-1));
        System.out.println("Smallest digit: "+ digitList.get(0));

    }

    public static void calculator(int a, int b, char mathOperation) {

        switch (mathOperation) {
            case '+':
                int addition = a+b;
                System.out.println("a + b = "+ addition);
                break;
            case '-':
                int subtraction = a-b;
                System.out.println("a - b = "+ subtraction);
                break;
            case '*':
                int multiplication = a*b;
                System.out.println("a * b = "+ multiplication);
                break;
            case ':':
                float division = (float)a/b;
                System.out.println("a / b = "+ division);
                break;
            case '%':
                float percent = (float) b*100/a;
                System.out.println("a / b = "+ percent);
                break;
            default:
                System.out.println("Unknown math operation. Allowed operations: +, -, *, :, %");
                break;

        }

    }

}
