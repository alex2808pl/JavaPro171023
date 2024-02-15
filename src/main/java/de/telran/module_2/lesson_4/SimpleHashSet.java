package de.telran.module_2.lesson_4;

import java.util.HashSet;
import java.util.Set;

public class SimpleHashSet {
    public static void main(String[] args) {
        Integer intVal1 = 25;
        System.out.println(intVal1.hashCode());
        Integer intVal2 = 41;
        System.out.println(intVal2.hashCode());

        String str = "123456";
        System.out.println(str.hashCode());

        Set<Cat> cats = new HashSet<>(); //16
        cats.add(new Cat("Tom", 10));
        cats.add(new Cat("Jack", 10));

        System.out.println(cats);


    }
}

class Cat {
    String name;
    int age;

    public String talk() {
        return "Meow";
    }

    public Cat(String name, int age) {
        this.name = name;
        this.age = age;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        Cat cat = (Cat) o;

        if (age != cat.age) return false;
        return name.equals(cat.name);
    }

    @Override
    public int hashCode() {
        int result = name.hashCode();
        result = 31 * result + age;
        return result;
    }
}
