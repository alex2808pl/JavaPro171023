package de.telran.module_1.lesson_4.generics.hw.task3;

public class Singer extends Artist{
    public Singer(String name) {
        super(name);
    }

    @Override
    public void showTalent() {
        System.out.println(getClass().getSimpleName() + " " + getName() + " sings very well");
    }
}