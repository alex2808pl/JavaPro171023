package de.telran.module_1.lesson_2.abstraction2;

public class Straus extends Bird{
    private int size;

    public Straus(String name, int age, int size) {
        super(name, age);
        this.size = size;
    }

    public Straus(int size) {
        this.size = size;
    }

    public int getSize() {
        return size;
    }

    public void setSize(int size) {
        this.size = size;
    }


    @Override
    public void fly() {
        System.out.println("Страус летать не умеет.");
    }

    @Override
    public void makeSound() {
        System.out.println("Орет!!!");
    }


}
