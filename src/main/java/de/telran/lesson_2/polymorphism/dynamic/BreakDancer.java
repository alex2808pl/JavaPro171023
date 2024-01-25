package de.telran.lesson_2.polymorphism.dynamic;

public class BreakDancer extends Dancer{
    public BreakDancer(String name, int age) {
        super(name, age);
    }

    @Override
    public void dance() {
        System.out.println(name + " я круто танцую BreakDance в возрасте "+age);


    }
}
