package de.telran.module_1.lesson_4.generics.hw.task3;

import java.util.Arrays;
import java.util.List;

public class Concert <T extends Artist> {
    //Вы владелец концертного зала со сценой. Вы нанимаете артистов различного жанра, которые развлекают зрителей,
    // используя свои таланты. Реализуйте класс Концерт, в котором разные артисты будут выходить на сцену и развлекать зрителей используя свои умения и талант.
    // Подумайте, можно для класса Концерт применить Generiс подход к реализации?
    private List<T> t;

    public Concert(T... t) {
        this.t = Arrays.stream(t).toList();
    }

    public Concert(List<T> t) {
        this.t = t;
    }

    public void process() {
        for (T talant : t) {
            talant.showTalent();

        }
    }
}