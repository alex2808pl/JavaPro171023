package de.telran.lesson_2.polymorphism.dynamic.interfaces;

public class SimpleZoo {
    public static void main(String[] args) {

        DancerInterface.loveApplause();
        // DancerInterface.salary = 5; //изменять нельзя
        System.out.println("Содержание актера = "+DancerInterface.salary);


        DancerInterface actor = new Dog();
        actor.dance();
        actor.eat();
        actor.drink();
        System.out.println();

        actor = new Bird();
        actor.dance();
        actor.eat();
        actor.drink();
        // actor.loveApplause(); //не получаю доступ к static
        Bird.loveApplause();
        System.out.println();

        actor = new Fish();
        actor.dance();
        actor.eat();
        actor.drink();

        // нельзя создать объект интерфейса
//        DancerInterface actor1 = new DancerInterface();

        System.out.println("--- Аплодисменты ---");

    }
}
