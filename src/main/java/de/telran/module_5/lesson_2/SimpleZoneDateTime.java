package de.telran.module_5.lesson_2;

import java.time.LocalDate;
import java.time.LocalTime;
import java.time.ZoneId;
import java.time.ZonedDateTime;

public class SimpleZoneDateTime {
    public static void main(String[] args) {
        ZonedDateTime zone = ZonedDateTime.now();
        System.out.println(zone);

        String text = "2022-12-20T00:35:47.023323700+02:00[Europe/Helsinki]";
        zone = ZonedDateTime.parse(text);
        System.out.println(zone);


        // Ручное создание
        LocalDate date = LocalDate.now();

        // getting current time
        LocalTime time = LocalTime.now();

        // getting system default zone id
        ZoneId zoneId = ZoneId.systemDefault();

        // creating a new ZonedDateTime object
        ZonedDateTime zoneDateTime = ZonedDateTime.of(date, time, zoneId);
        System.out.println(zoneDateTime);

        // getting a new ZonedDateTime object
        ZoneId newZoneId = ZoneId.of("Australia/Lindeman");
        zone = ZonedDateTime.now(newZoneId);
        System.out.println(zone);

        // getting list all zones
        for (String s: ZoneId.getAvailableZoneIds()) {
            newZoneId = ZoneId.of(s);
            System.out.println(s + " --- текущее время ---> "+ZonedDateTime.now(newZoneId));
        }

    }
}
