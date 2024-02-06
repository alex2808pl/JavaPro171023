package de.telran.module_1.lesson_3.enums;

public enum DayOfWeek {
    SUNDAY("Воскресенье"),
    MONDAY,  //new DayOfWeek()
    TUESDAY,
    WEDNESDAY,
    THURSDAY,
    FRIDAY,
    SATURDAY ("Суббота");

    private String title;

    DayOfWeek(String title) {
        this.title = title;
    }

    DayOfWeek() {
    }

    @Override
    public String toString() {
        return "DayOfWeek{" +
                "  title='" + title + '\'' +
                "} " + super.toString();
    }
}
