package de.telran.module_5.lesson_2;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.Locale;

public class SimpleLocalDateTime {
    public static void main(String[] args) {
        LocalDateTime now = LocalDateTime.now();
        System.out.println(now);

        // Adding 1 year, 1 month, 1 week and 1 day
        LocalDateTime localDateTime = now
                .plusYears(1)
                .plusMonths(1)
                .plusWeeks(1)
                .plusDays(1);

        System.out.println(localDateTime);

        // Subtracting 1 year, 1 month, 1 week and 1 day
        localDateTime = localDateTime.minusYears(1)
                .minusMonths(1)
                .minusWeeks(1)
                .minusDays(1);

        System.out.println(localDateTime);

        // Adding 1 hour, 1 minute, 1 second and 10000 nanoseconds
        localDateTime = localDateTime.plusHours(1)
                .plusMinutes(1)
                .plusSeconds(1)
                .plusNanos(10000);

        System.out.println(localDateTime);

        // Subtracting 1 hour, 1 minute, 1 second and 10000 nanoseconds
        localDateTime = localDateTime.minusHours(1)
                .minusMinutes(1)
                .minusSeconds(1)
                .minusNanos(10000);

        System.out.println(localDateTime);

        // вывод в строку используя форматтер
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyy-MMM-dd HH:mm:ss a");
        LocalDateTime time = LocalDateTime.now();

//        time = time.minusHours(3);

        // Formatting LocalDateTime to string
        String dateTimeString = time.format(formatter);

        System.out.println(dateTimeString);

//        Locale locale = new Locale("en");
    }
}
