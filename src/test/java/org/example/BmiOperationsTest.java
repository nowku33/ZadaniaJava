package org.example;

import org.junit.Assert;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import java.util.Random;

class BmiOperationsTest {

    @Test
    void getBmi() {
        Random random = new Random();
        double maxHeight = 2.4;
        double minHeight = 1.4;
        double heightInMeters = minHeight + (maxHeight - minHeight) * random.nextDouble();
        double maxWeight = 2.4;
        double minWeight = 1.4;
        double weightInKg = minWeight + (maxWeight - minWeight) * random.nextDouble();
        double expectedBmi = weightInKg / (heightInMeters * heightInMeters);
        double bmi = BmiOperations.getBmi(weightInKg, heightInMeters);
        Assertions.assertEquals(expectedBmi, bmi);
    }

    @Test
    void getBmiVerdict() {
        double correctWeightBmiMax = 24.9;
        double correctWeightBmiMin = 18.5;
        double generatedBmiMax = 40;
        double generatedBmiMin = 9;
        String expectedVerdict;
        Random random = new Random();
        double generatedBmi = generatedBmiMin + (generatedBmiMax - generatedBmiMin) * random.nextDouble();
        if (generatedBmi > correctWeightBmiMax) {
            expectedVerdict = "overweight";
        } else if (generatedBmi < correctWeightBmiMin) {
            expectedVerdict = "underweight";
        } else {
            expectedVerdict = "correct weight";
        }
        String verdict = BmiOperations.getBmiVerdict(generatedBmi);
        Assert.assertEquals(expectedVerdict, verdict);
    }

}