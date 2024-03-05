package de.telran.module_3.lesson_2;

import java.util.Arrays;
import java.util.List;
import java.util.function.Predicate;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class SimpleStream {
    public static void main(String[] args) {
        List<Integer> list = Arrays.asList(1,5,3,8,9,4,3,1);
        list.stream()
                .filter(i-> i % 2 != 0)
                .limit(3)
                .forEach(System.out::println);

        System.out.println(list.stream().count());

        System.out.println();
        Stream<Integer> streamInt = Stream.of(1,5,3,8,9,4,3,1);
        streamInt.filter(i-> i % 2 != 0)
                .limit(3)
                .forEach(System.out::println);

        Stream<Integer> st1 = list.stream()
                .filter(i-> i % 2 != 0);
        Stream<Integer> st2 = st1.limit(3);
        List<Integer> outList = st2.collect(Collectors.toList());
        System.out.println(outList);

        st1 = list.stream();
        System.out.println(st1.count());




        //streamInt.count();  //Stream не может использоваться повторно



    }
}
