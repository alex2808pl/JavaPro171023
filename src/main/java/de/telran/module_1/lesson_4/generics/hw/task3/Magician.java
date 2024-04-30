package de.telran.module_1.lesson_4.generics.hw.task3;

public class Magician extends Artist{
    public Magician(String name) {
        super(name);
    }

    @Override
    public void showTalent() {
        System.out.println(getClass().getSimpleName() + " " + getName() + " is showing tricks");
    }
}