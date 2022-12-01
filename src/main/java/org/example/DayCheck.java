package org.example;

import java.time.DayOfWeek;
import java.time.LocalDate;

public class DayCheck {

    private DayCheck() {
    }

    public static void dayOfWeek(int dayOfWeek) {
        switch (dayOfWeek) {
            case 1:
                System.out.println(DayOfWeek.MONDAY);
                break;
            case 2:
                System.out.println(DayOfWeek.TUESDAY);
                break;
            case 3:
                System.out.println(DayOfWeek.WEDNESDAY);
                break;
            case 4:
                System.out.println(DayOfWeek.THURSDAY);
                break;
            case 5:
                System.out.println(DayOfWeek.FRIDAY);
                break;
            case 6:
                System.out.println(DayOfWeek.SATURDAY);
                break;
            case 7:
                System.out.println(DayOfWeek.SUNDAY);
                break;
            default:
                System.out.println("Only values 1-7 are accepted");
                break;
        }
    }

    public static DayOfWeek getCurrentDayOfWeek() {
        return LocalDate.now().getDayOfWeek();
    }
}
