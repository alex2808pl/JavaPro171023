package de.telran.module_1.lesson_2.polymorphism.dynamic.interfaces;

public class Fish implements DancerInterface {
    @Override
    public void dance() {
        System.out.println("Рыбка танцует с помощью плавников");
    }

}
