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
            verdict = "overweight";
        } else if (bmi < bmiMin) {
            verdict = "underweight";
        } else {
            verdict = "correct weight";
        }
        return verdict;
    }
}
