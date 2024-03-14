package de.telran.module_3.lesson_3;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Stream;

public class SimpleReduce {
    public static void main(String[] args) {
        List<Integer> list = List.of(1,2,9,-3,6,4);

        System.out.println(
                list.stream()
                .reduce((a,b)-> a*b)
                .orElse(0)
        );

        List<String> listStr = List.of("Слоны", "ушли", "на", "север");
        System.out.println(
                listStr.stream()
                .reduce((a,b)->a+" "+b)
                        .get()
        );

        // перегруженный 2 метод
        Integer identity = 0;
        for (Integer el : list) {
            identity += el;
        }
        System.out.println("identity = "+identity);

        identity = 0;
        System.out.println(
        list.stream()
                .reduce(identity, (a,b)->a+b)
        );

        System.out.println(
                listStr.stream()
                        .reduce("=>", (a,b)->a+" "+b)
        );


        List<Person> personList = Arrays.asList(
                new Person("bob", 34),
                new Person("bob", 43),
                new Person("mary", 84),
                new Person("john", 84),
                new Person("john", 12),
                new Person("bob", 22));

        identity = 0;
        System.out.println(
        personList.stream()
                .reduce(identity,
                        (x,y) -> {
                            System.out.println("-- BF = "+x+"+"+y.getAge());
                            if(y.getAge()<50) {
                                return  x + y.getAge();
                            } else
                                return x + 0;
                        },
                        (x,y) -> {
                           System.out.println("== BO = "+x+"+"+y);
                           return x+y;
                        }
                        )
        );
    }
}
