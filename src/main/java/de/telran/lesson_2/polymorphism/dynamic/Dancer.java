package de.telran.lesson_2.polymorphism.dynamic;

public class Dancer {
    protected String name;
    protected final int age;

    public Dancer(String name, int age) {
        this.name = name;
        this.age = age;
    }

    protected void dance() {
        System.out.println(name + " я танцую как все в возрасте "+age);
        // age +=1; //при final это операция невозможна.
    }

    static int salary = 3;
    static void loveApplause() {
        System.out.println("Кланяются");
    }
}
