package de.telran.module_1.lesson_4.generics.hw.task3;

import java.util.List;

public class Main {
    public static void main(String[] args) {
        Singer singer1 = new Singer("Elvis");
        Singer singer2 = new Singer("Madonna");
        Singer singer3 = new Singer("Beyonce");

        Magician dancer1 = new Magician("Peter");
        Magician dancer2 = new Magician("Mira");
        Magician dancer3 = new Magician("Ilina");

        List<Artist> concert1 = List.of(dancer1,dancer2,dancer3, singer1,singer2,singer3);
        Concert<Artist> concerts = new Concert<>(concert1);
        concerts.process();
        System.out.println("--------------");
        Concert <Artist> concert2 = new Concert<>(dancer1,singer3,dancer2);
        concert2.process();


//        Concert<Actor> concert =  new Concert<>(singer1);
//        Concert<Actor> concert2 =  new Concert<>(dancer2);
//        Concert<Actor> concert3 =  new Concert<>(dancer3);
//        concert.process();
//        concert2.process();
//        concert3.process();

    }
}