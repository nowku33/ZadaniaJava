package org.example;

import org.junit.Assert;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;

import java.time.DayOfWeek;

class DayCheckTest {

    @ParameterizedTest
    @CsvSource({"TUESDAY"})
    void getCurrentDayOfWeek(DayOfWeek dayOfWeek) {
        Assert.assertEquals(DayCheck.getCurrentDayOfWeek(), dayOfWeek);
    }
}