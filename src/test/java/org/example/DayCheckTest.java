package org.example;

import org.junit.Assert;
import org.junit.jupiter.api.Test;

import java.time.DayOfWeek;
import java.time.LocalDate;

class DayCheckTest {

    @Test
    void getCurrentDayOfWeek() {
        DayOfWeek expectedDay = LocalDate.now().getDayOfWeek();
        Assert.assertEquals(DayCheck.getCurrentDayOfWeek(), expectedDay);
    }
}