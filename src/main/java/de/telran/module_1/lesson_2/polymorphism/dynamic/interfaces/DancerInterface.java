package de.telran.module_1.lesson_2.polymorphism.dynamic.interfaces;

public interface DancerInterface {
    void dance();
    default void eat() {
        System.out.println("Кушает с помощью головы");
    }
    default void drink() {
        System.out.println("Пьет  с помощью головы воду");
    };

    static int salary = 3; // автоматически добавляется final
    static void loveApplause() {
        System.out.println("Кланяются");
    }
}
