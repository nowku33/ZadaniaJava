package org.example;

import lombok.extern.log4j.Log4j2;

import java.time.DayOfWeek;
import java.time.LocalDateTime;
import java.time.format.TextStyle;
import java.util.Locale;

@Log4j2
public class DayCheck {

    private DayCheck() {
    }

    public static void printDayOfWeek(int dayOfWeek) {
        switch (dayOfWeek) {
            case 1 -> log.info(DayOfWeek.MONDAY);
            case 2 -> log.info(DayOfWeek.TUESDAY);
            case 3 -> log.info(DayOfWeek.WEDNESDAY);
            case 4 -> log.info(DayOfWeek.THURSDAY);
            case 5 -> log.info(DayOfWeek.FRIDAY);
            case 6 -> log.info(DayOfWeek.SATURDAY);
            case 7 -> log.info(DayOfWeek.SUNDAY);
            default -> log.info(MainApp.getLanguageBundle().getString("dayOfWeekDefaultMsg"));
        }
    }

    public static String getDayOfWeek(LocalDateTime localDateTime, Locale locale) {
        return localDateTime.getDayOfWeek().getDisplayName(TextStyle.FULL, locale);
    }
}
