package de.telran.lesson_2;

public class SimpleExtends {
    public static void main(String[] args) {
        Horse horse1 = new Horse("Вася", 4, 50, "черная");
        horse1.run();
        horse1.transports(5);
        System.out.println();

        Pegasus pegasus1 = new Pegasus("Толя", 60, "белый", 2);
        pegasus1.run();
        pegasus1.fly();
        pegasus1.transports(10);
        System.out.println();

        Pegasus pegasus2 = new Pegasus("Коля", 4, 60, "белый", 2);
        pegasus2.transports(11.0);
        System.out.println();

        Unicorn unicorn1 = new Unicorn("Витя", 60, "гнедой", 1);
        unicorn1.run();
        unicorn1.transports(10);
        unicorn1.butt();
        System.out.println();

        UnicornRace unicornRace1 = new UnicornRace("Боря", 60, "гнедой", 2, 3);
        unicornRace1.run();
        unicornRace1.butt();
        unicornRace1.transportsPassenger();

    }
}

