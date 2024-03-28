package de.telran.module_5.lesson_2;

import java.time.DayOfWeek;
import java.time.LocalDate;
import java.time.Month;

public class SimpleLocalDate {
    public static void main(String[] args) {
        // Создание объекта
        LocalDate date = LocalDate.now();
        System.out.println(date);

        LocalDate date2 = LocalDate.of(2024, Month.MARCH, 27);
        System.out.println(date2);

        // получение элементов из даты
        int year = date.getYear();
        int month = date.getMonthValue(); //1...12
        System.out.println(month);
        Month monthEnum = date.getMonth();
        System.out.println(monthEnum);

        int dayOfMonth = date.getDayOfMonth(); // номер дня в неделе
        DayOfWeek dayOfWeek = date.getDayOfWeek(); // день недели как элемент перечисления
        System.out.println(date);
        System.out.println(dayOfWeek);
        System.out.printf("%d.%d.%d \n", dayOfMonth, month, year);


        LocalDate date1 = LocalDate.of(1996, 1, 1);
        System.out.println(date1);

        // добавление или удаление любого элемента даты
        date1 = date1.plusYears(4);
        date1 = date1.plusMonths(3);
        date1 = date1.plusDays(14);
        System.out.println(date1);

        date1 = date1.minusMonths(10);
        date1 = date1.minusDays(3);
        System.out.println(date1);

        // сравнение даты
        System.out.println("isAfter = "+date.isAfter(date1));
        System.out.println("isBefore = "+date.isBefore(date1));
        System.out.println("equals = "+date.equals(date1));
        System.out.println("compareTo = "+date.compareTo(date1));
        System.out.println("compareTo = "+date1.compareTo(date));

    }
}
