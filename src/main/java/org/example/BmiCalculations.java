package org.example;

public class BmiCalculations {

    private BmiCalculations() {
        throw new IllegalStateException("Utility class");
    }

    public static void calculateBmi (double weightInKg, double heightInMeters){

        double bmiMax=24.9;
        double bmiMin=18.5;

        double bmi = weightInKg/(heightInMeters*heightInMeters);

        System.out.println("your BMI is: "+bmi);

        if (bmi > bmiMax) {
            System.out.println("nadwaga");
        } else if (bmi<bmiMin) {
            System.out.println("niedowaga");
        } else {System.out.println("waga prawidłowa");}

    }
}
