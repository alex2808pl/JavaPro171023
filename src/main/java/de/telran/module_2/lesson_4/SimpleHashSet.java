package de.telran.module_2.lesson_4;

import java.util.*;

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

        Set<Integer> sets = new HashSet<>();
        sets.add(5);
        sets.add(2);
        sets.add(3);
        sets.add(9);
        sets.add(4);
        System.out.println(sets);

        Set<String> setsStr = new HashSet<>();
        setsStr.add("B");
        setsStr.add("A");
        setsStr.add("1C");
        setsStr.add("F");
        setsStr.add("AA");
        System.out.println(setsStr);

        SortedSet<String> setStr1 = new TreeSet<>();
        setStr1.addAll(setsStr);
        System.out.println(setStr1);

        Set<String> linkedHashSet = new LinkedHashSet<>();
        linkedHashSet.add("B");
        linkedHashSet.add("A");
        linkedHashSet.add("1C");
        linkedHashSet.add("F");
        linkedHashSet.add("AA");
        System.out.println(linkedHashSet);


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
