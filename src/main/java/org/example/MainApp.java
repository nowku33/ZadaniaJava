package org.example;

import java.util.*;

import static org.example.OperationsOnNumbers.*;
import static org.example.TemperatureConversion.*;
import static org.example.BmiOperations.*;
import static org.example.DayCheck.*;

public class MainApp {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int option = printMenuAndReturnOptionNumber();
        switch (option) {
            case 1:
                printAddSubDivMultiModuloCalculations(getNumberListFromConsole());
                break;
            case 2:
                int convertOption = printTempConvertMenuAndReturnOption();
                if (convertOption == 1) {
                    System.out.println("Provide temperature in Celsius degrees:");
                    double celsiusValue = scanner.nextDouble();
                    double fahrenheitValue = getConvertedCelsiusToFahrenheit(celsiusValue);
                    System.out.println(celsiusValue + " Celsius degrees is equal to " + fahrenheitValue + " Fahrenheit degrees");
                } else {
                    System.out.println("Provide temperature in Fahrenheit degrees:");
                    double fahrenheitValue = scanner.nextDouble();
                    double celsiusValue = getConvertedFahrenheitToCelsius(fahrenheitValue);
                    System.out.println(fahrenheitValue + " Fahrenheit degrees is equal to " + celsiusValue + " Celsius degrees");
                }
                break;
            case 3:
                Map<String, Number> sumAndAverageOfDigits = getSumAndAverageOfDigits(readInputAndReturnIntNumber());
                System.out.println(sumAndAverageOfDigits);
                break;
            case 4:
                Map<String, Number> greatestAndSmallestNumber = getGreatestAndSmallestNumber(getNumberListFromConsole());
                System.out.println(greatestAndSmallestNumber);
                break;
            case 5:
                System.out.println("Weight [kg]:");
                double weight = scanner.nextDouble();
                System.out.println("Height [m]:");
                double height = scanner.nextDouble();
                double bmi = getBmi(weight, height);
                System.out.println(getBmiVerdict(bmi));
                break;
            case 6:
                System.out.println("Today is " + getCurrentDayOfWeek());
                break;
            case 0:
                System.out.println("exit the program");
                System.exit(0);
                break;
            default:
                System.out.println("Incorrect value. Please provide number from 0 to 7");
                break;
        }
    }

    private static List<Integer> getNumberListFromConsole() {
        List<Integer> digitList = new ArrayList<>();
        Scanner scanner = new Scanner(System.in);
        do {
            System.out.println("Please provide integer number or press any letter to stop:");
            try {
                int option = scanner.nextInt();
                digitList.add(option);
            } catch (InputMismatchException e) {
                break;
            }
        } while (true);
        return digitList;
    }

    private static int printMenuAndReturnOptionNumber() {
        Scanner scanner = new Scanner(System.in);
        int option = -1;
        do {
            System.out.println("Welcome choose an action from the following by entering the number: ");
            System.out.println("1 – perform calculator operation on some amount of numbers");
            System.out.println("2 – convert Fahrenheit to Celsius (or reverse)");
            System.out.println("3 – calculate the sum and average of digits for provided number ");
            System.out.println("4 – choose the biggest and the smallest number for provided number list");
            System.out.println("5 – calculate BMI (Body mass index) and interpret the result");
            System.out.println("6 - get the current day of week");
            System.out.println("Please select what you want to do:");
            try {
                option = scanner.nextInt();
            } catch (InputMismatchException e) {
                System.out.println("Please provide a number.");
                scanner.nextLine();
            }
        } while (option < 0 || option > 7);
        return option;
    }

    private static int printTempConvertMenuAndReturnOption() {
        int option = -1;
        Scanner scanner = new Scanner(System.in);
        do {
            System.out.println("1 - Convert Celsius degree to Fahrenheit.");
            System.out.println("2 - Convert Fahrenheit degree to Celsius");
            try {
                option = scanner.nextInt();
            } catch (InputMismatchException e) {
                System.out.println("Please provide a number.");
                scanner.nextLine();
            }
        } while (option != 1 && option != 2);
        return option;
    }

    private static int readInputAndReturnIntNumber() {
        Scanner scanner = new Scanner(System.in);
        do {
            try {
                System.out.println("Your digits:");
                String inputStr = scanner.nextLine();
                return Integer.parseInt(inputStr.replaceAll("[^\\d]", ""));

            } catch (NumberFormatException e) {
                System.out.println("Please provide integer value");
            }
        } while (true);
    }
}
