package de.telran.module_2.lesson_4;

import java.util.*;

public class SimpleTreeSet {
    public static void main(String[] args) {
        Set<String> set = new TreeSet<>();
        set.add("A");
        set.add("C");
        set.add("B");
        System.out.println(set);

        Set<String> set1 = Set.of("G", "D", "K", "E"); // храниться не в отсортированном виде, потому что не TreeSet
        System.out.println(set1);
        System.out.println(set1);
//        set1.add("H"); //Set неизменяемый, ошибка

        set.addAll(set1);
        System.out.println(set);


//        SortedSet<String> sortedSet = (SortedSet<String>) set1; //Set неизменяемый, ошибка
        SortedSet<String> sortedSet = (SortedSet<String>)set;
        System.out.println(sortedSet);
        System.out.println(sortedSet.first());
        System.out.println(sortedSet.last());

        NavigableSet<String> navigableSet = (NavigableSet<String>) set;
        Iterator it = navigableSet.descendingIterator();
        while (it.hasNext()) {
            System.out.print(it.next()+",");
        }
        System.out.println();

        it = navigableSet.iterator();
        while (it.hasNext()) {
            System.out.print(it.next()+",");
        }
        System.out.println();

        System.out.println(set.remove("G")); //удаление
        System.out.println(set);

    }
}
