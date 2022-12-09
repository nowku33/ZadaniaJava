package org.example;

public class BmiOperations {
    private BmiOperations() {
    }

    public static double getBmi(double weightInKg, double heightInMeters) {
        return weightInKg / (heightInMeters * heightInMeters);
    }

    public static String getBmiVerdict(double bmi) {
        double bmiMax = 24.9;
        double bmiMin = 18.5;
        String verdict;
        if (bmi > bmiMax) {
            verdict = MainApp.getLanguageBundle().getString("overweightTxt");
        } else if (bmi < bmiMin) {
            verdict = MainApp.getLanguageBundle().getString("underweightTxt");
        } else {
            verdict = MainApp.getLanguageBundle().getString("correctWeightTxt");
        }
        return verdict;
    }
}
