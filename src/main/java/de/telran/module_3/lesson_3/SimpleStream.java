package de.telran.module_3.lesson_3;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class SimpleStream {
    public static void main(String[] args) {

        // flatMap
        String[][] arrStr = { {"a", "b", "c"},
                {"d", "e", "f"},
                {"g", "o", "y"}};

        List<String> lists = Arrays.stream(arrStr)
                .flatMap(x->Arrays.stream(x))
                .collect(Collectors.toList());
        System.out.println(lists);

        lists = Arrays.stream(arrStr)
                .flatMap(Arrays::stream)
                .collect(Collectors.toList());
        System.out.println(lists);

        // Убираем ряд
        Arrays.stream(arrStr)
                .filter(el ->
                        !Arrays.stream(el)
                        .anyMatch(x->x.contains("a"))
                )
                .flatMap(x->Arrays.stream(x))
                .forEach(x-> System.out.print(x+","));
        System.out.println();


        Stream.of(1, 2, 3, 4, 5, 6)
                .flatMap(x -> {
                    if (x % 2 == 0) {
                        return Stream.of(-x, x, x*10);
                    }
                    return Stream.empty();
                })
                .forEach(x-> System.out.print(x+","));
        System.out.println();

        List<String> specific = List.of("Specific", "Measurable", "Achievable", "Relevant", "Time-bound");
        String string1 = specific.stream()
                .map(s -> s.charAt(0) + ".")
                .reduce(String::concat).get();
        System.out.println(string1);

        String string = specific.stream()
                .map(s -> s.substring(0, 1))
                .reduce((c1, c2) -> c1 + "." + c2)
                .get();
        System.out.println(string + ".");
    }
}
