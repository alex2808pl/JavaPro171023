package de.telran.module_5.lesson_2;

import java.time.LocalTime;

public class SimpleLocalTime {
    public static void main(String[] args) {
        LocalTime localTime = LocalTime.now();
        System.out.println("Текущее время = "+ localTime);

        LocalTime time = LocalTime.of(10, 30);
        System.out.println("Любое время = "+ time);

        LocalTime time1 = LocalTime.ofSecondOfDay(10_000);
        System.out.println("Любое время = "+ time1);

        // Получение элементов
        LocalTime now = LocalTime.now();
        System.out.println(now.getHour());
        System.out.println(now.getMinute());
        System.out.println(now.getSecond());

        //Изменение
        LocalTime time2 = localTime.plusHours(2);
        LocalTime time3 = localTime.minusMinutes(40);
        LocalTime time4 = localTime.plusSeconds(3600);

        System.out.println(localTime);
        System.out.println(time2);
        System.out.println(time3);
        System.out.println(time4);
    }
}
