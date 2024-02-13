package de.telran.module_2.lesson_3;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.ListIterator;

public class SimpleListIterator {
    public static void main(String[] args) {
        List<String> list = new ArrayList<>(Arrays.asList("А", "Б", "В", "Г", "Д", "Е", "Ж"));
        System.out.println(list);

        ListIterator<String> li = list.listIterator(); //двигаемся вперед
        while (li.hasNext()) {
            String str = li.next();
            System.out.print(str+",");
        }
        System.out.println();

        while (li.hasPrevious()) { //двигаемся назад
            String str = li.previous();
            System.out.print(str+",");
        }
        System.out.println();

        // позиционируемся перед
        li = list.listIterator(3);
        while (li.hasNext()) {
            String str = li.next();
            System.out.print(str+",");
        }
        System.out.println();

        li = list.listIterator(3);
        while (li.hasPrevious()) {
            String str = li.previous();

            System.out.print(str+"("+li.previousIndex()+"),");
        }
        System.out.println();

        li = list.listIterator(list.size()); //в конец списка
        while (li.hasPrevious()) {
            String str = li.previous();

            System.out.print(str+"("+li.previousIndex()+")("+li.nextIndex()+"),");
        }
        System.out.println();

        li = list.listIterator(3);
        while (li.hasNext()) {
            String str = li.next();
            if(str.equals("Е")) // добавление элемента
                li.add("Новый");

            if(str.equals("Г")) // удаление элемента
                li.remove();
            System.out.print(str+",");
        }
        System.out.println();
        System.out.println(list);

    }
}

