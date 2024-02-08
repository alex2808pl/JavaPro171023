package de.telran.module_2.lesson_2;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class SimpleList {
    public static void main(String[] args) {
        List lst = new ArrayList(); //все равно, что <Object>
        lst.add("Вася");
        lst.add(1);
        lst.add(true);
        System.out.println(lst);

        List<String> lstStr = new ArrayList<>();
        System.out.println(lstStr.size());
        System.out.println(lstStr.isEmpty());
        lstStr.add("1");
        lstStr.add("Two"); // добавление в конец
        System.out.println(lstStr);
        lstStr.add(1,"New Two"); // вставка
        System.out.println(lstStr);

        lstStr.set(1, "2"); //изменение
        System.out.println(lstStr);

        // аналог литерального создания
        List<String> lstStr2 = List.of("5","6","7элемент");
        List<String> lstStr3 = Arrays.asList("8","9","10элемент");
        System.out.println(lstStr2);
        System.out.println(lstStr3);


        lstStr.addAll(lstStr2); // добавление списка
        System.out.println(lstStr);
        lstStr.addAll(2, lstStr3); //вставка списка
        System.out.println(lstStr);

        //удаление
        lstStr.remove(4); // по индексу
        System.out.println(lstStr);
        lstStr.remove("Two"); //по значению
        System.out.println(lstStr);
        System.out.println(lstStr.remove("88"));

        for (int i = 0; i < lstStr.size(); i++) {
            System.out.println(lstStr.get(i));
        }

        System.out.println();
        for (String el : lstStr) {
            System.out.println(el);
        }

        lstStr.sort(String::compareTo); //сортировка (String::compareTo) - это будем учить позже
        System.out.println(lstStr);

        //поиск
        System.out.println(lstStr.contains("6"));
        System.out.println(lstStr.contains("99"));


    }
}
