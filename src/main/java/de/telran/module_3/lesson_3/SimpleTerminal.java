package de.telran.module_3.lesson_3;

import java.util.*;
import java.util.function.Function;
import java.util.stream.IntStream;
import java.util.stream.Stream;

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

        // --- joining
        String resultString = givenList.stream().collect(joining());
        System.out.println(resultString);

        resultString = givenList.stream().collect(joining(","));
        System.out.println(resultString);

        resultString = givenList.stream().collect(joining(" ", "PRE-", "-POST"));
        System.out.println(resultString);

        // стандарт toString
        resultString = givenList.stream().collect(joining(", ", "[", "]"));
        System.out.println(resultString);
        System.out.println(givenList);

        // --- counting
        Long resultLong = givenList.stream().collect(counting());
        System.out.println(resultLong);

        resultLong = givenList.stream().count(); // аналог
        System.out.println(resultLong);

        // --- summarizingDouble
        DoubleSummaryStatistics resultStat = givenList.stream()
                .collect(summarizingDouble(String::length));
        System.out.println(resultStat);
        System.out.println("Среднее значение = "+resultStat.getAverage());

        // --- averagingDouble
        Double resultDouble = givenList.stream()
                .collect(averagingDouble(String::length));
        System.out.println(resultDouble);

        // --- summingDouble
        resultDouble = givenList.stream()
                .collect(summingDouble(String::length));
        System.out.println(resultDouble);

        System.out.println(givenList.stream() // аналог
                .mapToInt(String::length)
                .sum());

        // --- maxBy()/minBy()
        Optional<String> resultOpt = givenList.stream()
                .collect(maxBy(Comparator.naturalOrder()));
        System.out.println("maxBy = "+resultOpt);

        resultOpt = givenList.stream()
                .collect(maxBy(String::compareTo)); // аналог
        System.out.println("maxBy = "+resultOpt);

        System.out.println(givenList.stream() // аналог
                .max(String::compareTo));

        resultOpt = givenList.stream()
                .collect(minBy(Comparator.naturalOrder()));
        System.out.println(resultOpt);

        System.out.println(givenList.stream() // аналог
                .min(String::compareTo));

// --- groupingBy
        Map<Integer, Set<String>> resultMap1 = givenList.stream()
                .collect(groupingBy(String::length, toSet()));
        System.out.println(resultMap1);

        List<String> list = List.of("bb", "ccc", "dd", "aj", "uiu", "aa", "bb");
        Map<Integer, List<String>> resultMap2 = list.stream()
                .collect(groupingBy(String::length, toList()));
        System.out.println(resultMap2);

        resultMap1 = list.stream() // уберутся дубликаты
                .collect(groupingBy(String::length, toSet()));
        System.out.println(resultMap1);

        resultMap1 = list.stream() // уберутся дубликаты
                .collect(groupingBy(String::length, toCollection(TreeSet::new)));
        System.out.println(resultMap1);

        Map<Integer, Optional<String>> resultMapString = list.stream()  //минимальное значение
                .collect(groupingBy(String::length, minBy(String::compareTo)));
        System.out.println(resultMapString);

        resultMapString = givenList.stream()
                .collect(groupingBy(String::length, maxBy(String::compareTo))); //максимальное значение
        System.out.println(resultMapString);

        // --- partitioningBy
        Map<Boolean, List<String>> resultMap3 = givenList.stream()
                .collect(partitioningBy(s -> s.length() > 2));
        System.out.println(resultMap3);

        Map<Boolean, List<Integer>> mapInt = IntStream.range(0, 100).boxed()
                .limit(10)
                .collect(partitioningBy(i -> (i % 3) == 0));
        System.out.println(mapInt);

        mapInt = IntStream.range(0, 100).boxed() //дубликат
                .limit(10)
                .collect(groupingBy(i -> (i % 3) == 0, mapping(i -> i, toList())));
        System.out.println(mapInt);

        // --- teeing
        List<Integer> numbers = Arrays.asList(42, 4, 2, 24);
        int sum = numbers.stream().collect(teeing(
                minBy(Integer::compareTo), // The first collector
                maxBy(Integer::compareTo), // The second collector
                (min, max) -> min.get()+max.get()// Receives the result from those collectors and combines them
        ));
        System.out.println(sum);

        String resultStr = list.stream().collect(teeing(
                minBy(String::compareTo), // The first collector
                maxBy(String::compareTo), // The second collector
                (min, max) -> min.get()+" -- "+max.get()// Receives the result from those collectors and combines them
        ));

        Collection<String> resultCollection = list.stream().collect(teeing(
                toList(), // The first collector
                toSet(), // The second collector
                (v1, v2) -> (v1.size() > v2.size()) ? v2 : v1
        ));
        System.out.println(resultCollection);


        // mapping
        List<Person> personList = Arrays.asList(
                new Person("bob", 34),
                new Person("bob", 43),
                new Person("mary", 84),
                new Person("john", 84),
                new Person("john", 12),
                new Person("bob", 22));

        System.out.println("Person list - " + personList);


        System.out.println(personList.stream()
                .collect(mapping(Person::getName, toList())));

        System.out.println(personList.stream()
                .collect(mapping(Person::getAge, maxBy(Integer::compareTo))));

        Stream<Person> personStream = personList.stream();

        System.out.println(personList.stream()
                .collect(groupingBy(Person::getName, toList())));

        System.out.println(personList.stream()
                .collect(mapping(Person::getAge,toList())));

        System.out.println(personList.stream()
                .collect(groupingBy(Person::getName,
                        mapping(Person::getName, toList()))));

        System.out.println(personList.stream()
                .collect(groupingBy(Person::getName,
                        mapping(Person::getAge, maxBy(Integer::compareTo)))));

       Map<String, List<Integer>> resultMapInt1 =
        personList.stream()
                .collect(groupingBy(Person::getName,
                    mapping(Person::getAge, toList())));

        System.out.println("Mapping result - " + resultMapInt1);

        }
}
