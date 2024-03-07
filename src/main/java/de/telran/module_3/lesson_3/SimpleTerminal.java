package de.telran.module_3.lesson_3;

import java.util.*;
import java.util.function.Function;

import static java.util.stream.Collectors.*;
import static java.util.stream.Collectors.toUnmodifiableSet;

public class SimpleTerminal {
    public static void main(String[] args) {
        System.out.println("--------  Терминальные методы");

        List<String> givenList = Arrays.asList("a", "bb", "ccc", "dd");

        // == findFirst
        Optional<String> str = givenList.stream()
                .filter(x->!x.contains("c"))
                .findFirst();
        System.out.println(str.get());

        // == anyMatch
        boolean is = givenList.stream()
                .anyMatch(x -> x.startsWith("b"));
        System.out.println("anyMatch - "+is);

        // == allMatch
        is = givenList.stream()
                .allMatch(x -> x.startsWith("b"));
        System.out.println("allMatch - "+is);

        // == min / max
        System.out.println(givenList.stream()
                .min(String::compareTo));

        System.out.println(givenList.stream()
                .map(x -> x.length())
                .max(Comparator.naturalOrder()));

        System.out.println(givenList.stream()
                .max(Comparator.comparingInt(x -> x.length())));

        // == toArray
        String[] arrStr1 = givenList.stream()
                .map(String::toUpperCase)
                .toArray(String[]::new);
        System.out.println(Arrays.toString(arrStr1));

        // == collect ====

        // --- toList
        List<String> result = givenList.stream()
                .collect(toList());  // можно изменять
        result.add("sss");
        System.out.println(result);

        result = givenList.stream()
                .collect(toUnmodifiableList());  // нельзя изменять
//        result.add("sss"); //UnsupportedOperationException
        System.out.println(result);

        result = givenList.stream()
                .toList();  // можно изменять
        System.out.println(result);

        // --- toSet
        List<String> listWithDuplicates = Arrays.asList("a", "bb", "c", "d", "bb");
        Set<String> resultSet = listWithDuplicates.stream()
                .collect(toSet()); // можно изменять
        System.out.println(resultSet);

        resultSet = givenList.stream()
                .collect(toUnmodifiableSet());  // нельзя изменять
        System.out.println(resultSet);

        // --- toCollection
        result = givenList.stream()
                .collect(toCollection(LinkedList::new));
        System.out.println(result);

        // --- toMap
        Map<String, Integer> resultMap = givenList.stream()
                .collect(toMap(Function.identity(), String::length));
        System.out.println(resultMap);

        Map<String, String> resultMapStr = givenList.stream()
                .collect(toMap(Function.identity(), String::toUpperCase));
        System.out.println(resultMapStr);

        List<String> givenListNoDubl = Arrays.asList("a", "bb", "ccc", "dddd");
        Map<Integer, String> resultMapInt = givenListNoDubl.stream()
                .collect(toMap(String::length, Function.identity())); //
        System.out.println(resultMapInt);

        //.IllegalStateException (дуюликаты ключа)
//         resultMap = listWithDuplicates.stream().collect(toMap(Function.identity(), String::length));

        resultMap = listWithDuplicates.stream()
                .distinct()
                .collect(toMap(Function.identity(), String::length));
        System.out.println(resultMap);

        // --- toUnmodifiableMap
        resultMap = givenList.stream()
                .collect(toUnmodifiableMap(Function.identity(), String::length));
        // resultMap.put("foo", 3); //UnsupportedOperationException



    }
}
