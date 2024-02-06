package de.telran.module_1.lesson_2.polymorphism.dynamic;

public class FolkDance extends Dancer{
    public FolkDance(String name, int age) {
        super(name, age);
    }
    @Override
    public void dance() {
        System.out.println(name + " я круто танцую Краковяк и Калинку в возрасте "+age);
    }
}
