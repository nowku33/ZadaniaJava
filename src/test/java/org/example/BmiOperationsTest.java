package org.example;

import org.junit.Assert;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;

class BmiOperationsTest {

    @ParameterizedTest
    @CsvSource({"78,1.7,26.989619377162633", "200,1.8,61.72839506172839"})
    void getBmi(double weightInKg, double heightInMeters, double expectedBmi) {
        double actualBmi = BmiOperations.getBmi(weightInKg, heightInMeters);
        Assertions.assertEquals(expectedBmi, actualBmi);
    }

    @ParameterizedTest
    @CsvSource({"24.9,'correct weight'", "18.5,'correct weight'", "24.91,'overweight'", "18.49,'underweight'"})
    void getBmiVerdict(double bmi, String expectedVerdict) {
        String verdict = BmiOperations.getBmiVerdict(bmi);
        Assert.assertEquals(expectedVerdict, verdict);
    }

}