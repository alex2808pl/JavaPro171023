package de.telran.module_1.lesson_3.enums;

public class SimpleEnum {
    public static void main(String[] args) {
        DayOfWeekOld d1 = DayOfWeekOld.FRIDAY;
        System.out.println(d1);

        DayOfWeek d2 = DayOfWeek.FRIDAY;
        System.out.println(d2);

        DayOfWeek d3 = DayOfWeek.SUNDAY;
        System.out.println(d3);

        d2 = DayOfWeek.SATURDAY;
        System.out.println(d2);

        switch (d3) {
            case SATURDAY:
            case SUNDAY:
                System.out.println("Ура, выходной!");
                break;
            default:
                System.out.println("Надо топать на работу!");
        }

        // Новый подход при работе со SWITCH
        switch (d3) {
            case SATURDAY, SUNDAY -> System.out.println("Ура, выходной!");
            default -> System.out.println("Надо топать на работу!");
        }

        // values()
        for (DayOfWeek d : DayOfWeek.values()) {
            System.out.println(d);
        }

        // ordinal
        System.out.println("ordinal = "+d2.ordinal()+" "+d2.name());
        System.out.println("ordinal = "+d3.ordinal()+" "+d3.name());

        //valueOf
        d2 = DayOfWeek.valueOf("MONDAY");  //аналог DayOfWeek.MONDAY
        System.out.println(d2);

        // d2 = DayOfWeek.valueOf("monday");  // нельзя, MONDAY строго писать большими буквами

    }
}
