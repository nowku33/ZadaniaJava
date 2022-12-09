package org.example;

import lombok.Getter;
import lombok.extern.log4j.Log4j2;

import java.time.LocalDateTime;
import java.util.*;

import static org.example.BmiOperations.getBmi;
import static org.example.BmiOperations.getBmiVerdict;
import static org.example.DayCheck.getDayOfWeek;
import static org.example.OperationsOnNumbers.*;
import static org.example.TemperatureConversion.getConvertedCelsiusToFahrenheit;
import static org.example.TemperatureConversion.getConvertedFahrenheitToCelsius;

@Log4j2
public class MainApp {
    static final List<String> AVAILABLE_LANGUAGES = Arrays.asList("en", "pl");
    @Getter
    static Locale locale = Locale.getDefault();
    @Getter
    static ResourceBundle languageBundle = ResourceBundle.getBundle("language", locale);

    public static void main(String[] args) {
        chooseAndSetLanguage();
        languageBundle = ResourceBundle.getBundle("language", locale);
        Scanner scanner = new Scanner(System.in);
        int option = printMenuAndReturnOptionNumber();
        switch (option) {
            case 1 -> calculatorOperationsMenu();
            case 2 -> temperatureConversionMenu();
            case 3 -> {
                Map<String, Number> sumAndAverageOfDigits = getSumAndAverageOfDigits(readInputAndReturnIntNumber());
                log.info("{} {}", languageBundle.getString("sumTxt"), sumAndAverageOfDigits.get("sum"));
                log.info("{} {}", languageBundle.getString("averageTxt"),
                        sumAndAverageOfDigits.get("average"));
            }
            case 4 -> {
                Map<String, Number> greatestAndSmallestNumber = getGreatestAndSmallestNumber(getNumberListFromConsole());
                log.info(languageBundle.getString("smallestNumberMsg") + greatestAndSmallestNumber.get("smallestNumber"));
                log.info(languageBundle.getString("greatestNumberMsg") + greatestAndSmallestNumber.get("greatestNumber"));
            }
            case 5 -> {
                log.info(languageBundle.getString("provideWeightMsg"));
                double weight = scanner.nextDouble();
                log.info(languageBundle.getString("provideHeightMsg"));
                double height = scanner.nextDouble();
                double bmi = getBmi(weight, height);
                log.info(getBmiVerdict(bmi));
            }
            case 6 -> {
                LocalDateTime currentDay = LocalDateTime.now();
                log.info("{} {}", languageBundle.getString("todayMsg"), getDayOfWeek(currentDay, locale));
            }
            case 0 -> {
                log.info(languageBundle.getString("mainMenuExit"));
                System.exit(0);
            }
            default -> log.info(languageBundle.getString("mainMenuIncorrectValue"));
        }
    }

    private static List<Integer> getNumberListFromConsole() {
        List<Integer> digitList = new ArrayList<>();
        Scanner scanner = new Scanner(System.in);
        do {
            log.info(languageBundle.getString("provideIntOrPressCharMsg"));
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
            log.info(languageBundle.getString("mainMenu"));
            try {
                option = scanner.nextInt();
            } catch (InputMismatchException e) {
                log.info(languageBundle.getString("mainMenuMismatchExceptionText"));
                scanner.nextLine();
            }
        } while (option < 0 || option > 7);
        return option;
    }

    private static int printTempConvertMenuAndReturnOption() {
        int option = -1;
        Scanner scanner = new Scanner(System.in);
        do {
            log.info(languageBundle.getString("tempConversionMenu"));
            try {
                option = scanner.nextInt();
            } catch (InputMismatchException e) {
                log.info(languageBundle.getString("provideNumberMsg"));
                scanner.nextLine();
            }
        } while (option != 1 && option != 2);
        return option;
    }

    private static int readInputAndReturnIntNumber() {
        Scanner scanner = new Scanner(System.in);
        do {
            try {
                log.info(languageBundle.getString("provideDigitsMsg"));
                String inputStr = scanner.nextLine();
                return Integer.parseInt(inputStr.replaceAll("[^\\d]", ""));

            } catch (NumberFormatException e) {
                log.info(languageBundle.getString("provideIntMsg"));
            }
        } while (true);
    }

    private static void temperatureConversionMenu() {
        Scanner scanner = new Scanner(System.in);
        int convertOption = printTempConvertMenuAndReturnOption();
        if (convertOption == 1) {
            log.info(languageBundle.getString("provideCelsiusDegreesMsg"));
            double celsiusValue = scanner.nextDouble();
            double fahrenheitValue = getConvertedCelsiusToFahrenheit(celsiusValue);
            log.info("{} {} {} {}", celsiusValue, languageBundle.getString("celsiusIsEqualMsg"),
                    fahrenheitValue, languageBundle.getString("fahrenheitDegreesText"));
        } else {
            log.info(languageBundle.getString("provideFahrenheitDegreesMsg"));
            double fahrenheitValue = scanner.nextDouble();
            double celsiusValue = getConvertedFahrenheitToCelsius(fahrenheitValue);
            log.info("{} {} {} {}", fahrenheitValue, languageBundle.getString("fahrenheitIsEqualMsg"),
                    celsiusValue, languageBundle.getString("celsiusDegreesText"));
        }
    }

    private static void calculatorOperationsMenu() {
        List<Integer> numberlist = getNumberListFromConsole();
        if (numberlist.size() > 1) {
            log.info("a+b+...=" + getAdditionResult(numberlist));
            log.info("a-b-...=" + getSubtractionResult(numberlist));
            log.info("a*b-...=" + getMultiplicationResult(numberlist));
            log.info("a:b:...=" + getDivisionResult(numberlist));
            log.info("a%b%...=" + getModuloResult(numberlist));
        } else {
            log.info(languageBundle.getString("calcOperationsMenuErrorMsg"));
        }
    }

    private static void chooseAndSetLanguage() {
        Scanner scanner = new Scanner(System.in);
        String appLanguage = null;
        String country = null;
        do {
            log.info("{} {}}", languageBundle.getString("chooseLangMsg"), AVAILABLE_LANGUAGES);
            String selectedLanguage = scanner.nextLine();
            for (String language : AVAILABLE_LANGUAGES) {
                if (language.contains(selectedLanguage)) {
                    appLanguage = selectedLanguage;
                    country = selectedLanguage.toUpperCase();
                    break;
                }
            }
        } while (appLanguage == null);
        locale = new Locale(appLanguage, country);
    }
}
