package de.telran.module_2.lesson_5;

import java.util.*;

public class SimpleCompare {
    public static void main(String[] args) {
        List<Integer> list = new ArrayList<>(Arrays.asList(2, 7, 3, 9, 5, 2, 6));
        list.add(4);
        System.out.println(list);

        Collections.sort(list);  //сортируем
        System.out.println(list);


        List<Cat> listCats = new ArrayList<>();
        Cat cat1 = new Cat("Tom", 10);
        listCats.add(cat1);
        listCats.add(new Cat("Murka", 5));
        listCats.add(new Cat("Barsik", 7));
        listCats.add(new Cat("Vaska", 2));
        listCats.add(new Cat("Tom", 10));
        listCats.add(new Cat("Alisa", 10));

        System.out.println(listCats);
        System.out.println("Tom -> " + Integer.toHexString(cat1.hashCode()));

        Collections.sort(listCats);  //сортируем
        System.out.println(listCats);

        Collections.sort(listCats, new NameComparator());
        System.out.println(listCats);


        // анонимный класс Comparator с переменной
        Comparator<Cat> comparatorAgeRevers = new Comparator<Cat>() {
            @Override
            public int compare(Cat o1, Cat o2) {
                return o2.getAge() - o1.getAge(); //0 , -1, 1
            }
        };
        Collections.sort(listCats, comparatorAgeRevers);
        System.out.println(listCats);

        // чистый анонимный класс Comparator (одноразовое использование)
        Collections.sort(listCats, new Comparator<Cat>() {
            @Override
            public int compare(Cat o1, Cat o2) {
                return o1.getAge() - o2.getAge();
            }
        });
        System.out.println(listCats);

        // работаем с Set
        SortedSet<Cat> catsTree = new TreeSet<>(listCats);
        System.out.println(catsTree);

        SortedSet<Cat> catsTreeName = new TreeSet<>(new NameComparator());
        catsTreeName.addAll(listCats);
        catsTreeName.add(new Cat("Dunja",8));
        System.out.println(catsTreeName);
    }

}

class NameComparator implements Comparator<Cat> {
    @Override
    public int compare(Cat o1, Cat o2) {
        return o1.getName().compareTo(o2.getName()); // сравнение 1-го уровня
    }
}
