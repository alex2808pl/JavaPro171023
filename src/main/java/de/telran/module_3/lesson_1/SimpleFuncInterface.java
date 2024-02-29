package de.telran.module_3.lesson_1;

import java.util.HashMap;
import java.util.Map;
import java.util.TreeMap;

public class SimpleFuncInterface {
    public static void main(String[] args) {
        MyOperation op = new Calc();
        System.out.println(op.operation(10,12));
        // op.method1(); //недоступен
        op.print();

        Calc calc = new Calc();
        System.out.println(calc.operation(1,3));
        calc.method1();
        calc.print();

        System.out.println(sum(10, op, 5, 6)); // x1+x2

        MyOperation op1 = new MyOperation() {
            @Override
            public int operation(int x, int y) {
                return x - y;
            }
        };

        System.out.println(sum(10, op1, 5, 6)); //x1-x2

        System.out.println(sum(10, new Multi(), 5, 6)); //x1*x2

        MyOperation op2 = (x1,x2) -> { return x2/x1;};  // лямбда выражение
        System.out.println(sum(10, op2, 5, 6));

        System.out.println(sum(10, (x1,x2) -> x1 % x2, 5, 6)); // лямбда выражение

        MyOperation op3 = (x1,x2) -> {
            int sum = x1+x2;
            return sum;
        };  // лямбда выражение многострочного кода

        System.out.println(sum(10, op3, 5, 6)); // лямбда выражение

        // Работа с Map
        Map<Integer, MyOperation> map1 = new TreeMap<>();
        map1.put(1, (x1,x2) -> x1 % x2);
        map1.put(2, (x1,x2) -> x1 + x2);

        MyOperation opMap = map1.get(1);
        System.out.println(opMap.operation(7,3));
        System.out.println(map1.get(2).operation(10, 33));


        // другой интерфейс MyVoid
        MyVoid myVoid = () -> System.out.println("Я вывожусь на консоль");
        myVoid.print();

        myVoid = () -> {
            System.out.println("Я вывожусь в файл");
            System.out.println("Я вывожусь на принтер");
        };
        myVoid.print();
    }

    static int sum (int k, MyOperation op, int x1, int x2) {
        int sumL = k + op.operation(x1, x2);
        return sumL;
    }
}

@FunctionalInterface
interface MyOperation {
    int operation(int x, int y);
//    void met1(); //только один абстрактный метод
    default void print() {
        System.out.println("Default print");
    };
}

@FunctionalInterface
interface MyVoid {
    void print();
}

class Multi implements MyOperation {

    @Override
    public int operation(int x, int y) {
        return x*y;
    }
}

class Calc implements MyOperation {
    @Override
    public int operation(int x, int y) {
        return x+y;
    }

    @Override
    public void print() {
       // MyOperation.super.print();
        System.out.println("Calc print");
    }

    public void method1(){
        System.out.println("method1()");
    }
}
