package de.telran.module_1.lesson_2.polymorphism.dynamic.interfaces;

public class Bird implements DancerInterface{
    @Override
    public void dance() {
        System.out.println("Птичка танцует с помощью крыльев");
    }

    @Override
    public void eat() {
        System.out.println("Кушает с помощью клювика");
    }

    static void loveApplause() {
        System.out.println("Кланяются и машет крылышками");
    }
}
