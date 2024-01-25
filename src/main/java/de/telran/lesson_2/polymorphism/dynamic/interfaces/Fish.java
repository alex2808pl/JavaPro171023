package de.telran.lesson_2.polymorphism.dynamic.interfaces;

import de.telran.lesson_2.polymorphism.dynamic.Dancer;

public class Fish implements DancerInterface {
    @Override
    public void dance() {
        System.out.println("Рыбка танцует с помощью плавников");
    }

}
