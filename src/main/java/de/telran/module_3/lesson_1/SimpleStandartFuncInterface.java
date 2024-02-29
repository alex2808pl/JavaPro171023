package de.telran.module_3.lesson_1;

import java.util.function.*;

public class SimpleStandartFuncInterface {
    public static void main(String[] args) {
        //void accept(T t);
        Consumer<Integer> cons = (x) -> System.out.println("Наше значение - "+x*x);
        cons.accept(12);
        cons = (x) -> System.out.println("Наше новое значение - "+x);
        cons.accept(12);

        //void accept(T t, U u);
        BiConsumer<Integer, Double> biConsumer = (x1, x2)-> System.out.println("Сумма - "+(x1+x2));
        biConsumer.accept(10,22.0);

        IntConsumer intCons = (x) -> System.out.println("Наше IntConsumer значение - "+x);
        intCons.accept(22);

        // boolean test(T t);
        Predicate<Integer> predicate = (x) -> x % 2 == 0;
        System.out.println(predicate.test(22));

        predicate = (x) -> {
            boolean res = x % 3 == 0;
            return res;
        };
        System.out.println(predicate.test(22));

        //boolean test(T t, U u);
        BiPredicate<Integer, Integer> biPredicate = (x1, x2) -> x1 > x2;
        System.out.println(biPredicate.test(8, 12));

//        R apply(T t);
        Function<Integer, Double> function = (x) -> x*2.0;
        System.out.println(function.apply(5));

        BiFunction<Integer, Double, Double> biFunction = (x1,x2) -> x1 / x2;
        System.out.println(biFunction.apply(5, 2.0));

        //T get();
        Supplier<Double> supplier = () -> Math.sqrt(9);
        System.out.println(supplier.get());
    }
}
