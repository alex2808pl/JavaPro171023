package de.telran.module_3.lesson_2;

import java.util.Arrays;
import java.util.Comparator;
import java.util.List;
import java.util.Set;
import java.util.stream.Collectors;

public class SimpleIntermediate {
    public static void main(String[] args) {
        List<String> list = Arrays.asList("10","20","1", "10", "15", "50", "25");
        System.out.println(list);
        //filter & count
        long c = list.stream()
                .filter(p -> p.equals("10"))
                .count();
        System.out.println("count = "+c);

        //sorted
        List<String> listResult = list.stream()
                .sorted()
                .toList();
        System.out.println(listResult);

        listResult = list.stream()
                .sorted(Comparator.reverseOrder())
                .toList();
        System.out.println(listResult);

        //limit
        listResult =  list.stream()
                .sorted()
                .limit(5)
                .toList();

        System.out.println(listResult);

        //skip
        listResult = list.stream()
                .sorted()
                .skip(2)
                .toList();
        System.out.println(listResult);

        // от 3 по 5 включительно
        listResult = list.stream()
                .sorted()
                .skip(3)
                .limit(3)
                .toList();
        System.out.println(listResult);

        // distinct
        Set<String> setResult = list.stream()
                .distinct()
                .collect(Collectors.toSet());
        System.out.println(setResult);

        //peek
        listResult = list.stream()
                .peek(el -> System.out.println("Element = "+el))
                .toList();
        System.out.println(listResult);

        // map - изменяем тип потока
        List<Integer> listResultInt = list.stream()
                .map(x -> Integer.parseInt(x))
                .toList();
        System.out.println(listResultInt);

        list.stream()
                .mapToInt(x -> Integer.parseInt(x))
                .forEach(el -> {
                    int sum = el+10;
                    System.out.println(sum);
                });


    }
}
