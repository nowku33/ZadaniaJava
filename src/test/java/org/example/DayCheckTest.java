package org.example;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;

import java.time.Clock;
import java.time.Instant;
import java.time.LocalDateTime;
import java.time.ZoneId;
import java.util.Locale;

class DayCheckTest {
    @ParameterizedTest
    @CsvSource(delimiter = '|', textBlock = """
            2022-12-11T12:00:00Z    |   Sunday   | en
            2022-12-12T12:00:00Z    |   Monday   | en
            2022-12-13T12:00:00Z    |   wtorek   | pl
            """)
    void getDayOfWeek(String date, String expectedDayName, String language) {
        Clock clock = Clock.fixed(Instant.parse(date), ZoneId.of("UTC"));
        String actualDayName = DayCheck.getDayOfWeek(LocalDateTime.now(clock), new Locale(language));
        Assertions.assertEquals(expectedDayName, actualDayName);
    }
}