package de.telran.module_1.lesson_2.polymorphism.dynamic;

public class BallDancer extends Dancer{
    public BallDancer(String name, int age) {
        super(name, age);
    }

    @Override
    public void dance() {
        System.out.println(name + " я круто танцую ча-ча-ча в возрасте "+age);
    }

    public void dance(String nameDance) {
        System.out.println(name + " я круто танцую "+nameDance+" в возрасте "+age);
    }
}
