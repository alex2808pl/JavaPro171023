package de.telran.module_1.generics;

public class SimpleGeneric {
    public static void main(String[] args) {
        Account1 acc1 = new Account1(12345, 100);
        System.out.println(acc1);

        // работаем с Object
        AccountObject accObj1 = new AccountObject(1111, 200);
        System.out.println(accObj1);
        AccountObject accObj2 = new AccountObject("234RS37", 200);
        System.out.println(accObj2);
        AccountObject accObj3 = new AccountObject(true, 200);
        System.out.println(accObj3);

        Object obj1 = accObj3;
        System.out.println(obj1);

        int id = (int) accObj1.getId();
        System.out.println(id);

        // Этого делать нельзя, получите ошибку cannot be cast
//        id = (int) accObj2.getId();
//        id = (int) accObj3.getId();

        AccountGeneric<Integer> accGen1 = new AccountGeneric<>(12345, 100);
        System.out.println(accGen1);

        AccountGeneric<String> accGen2 = new AccountGeneric<>("1234gfd656", 200);
        System.out.println(accGen2);

        // AccountGeneric<int> accGen3; //запрещено работать с примитивными типами

        int[] arr = {1,2,3,4,5}; // но массив в Java объектный тип, значит можно
        AccountGeneric<int[]> accGen3 = new AccountGeneric<>(arr, 100);
        System.out.println(accGen3);


        Accountable<Integer> accInt = new AccountInt(123455678, 200);
        System.out.println(accInt);

        Accountable<String> accStr = new AccountString("saff34536", 200);
        System.out.println(accStr);

        Accountable<String> accGenInterf = new AccountGenericInt<>("32sfg345", 100);
        System.out.println(accGenInterf);


        AccountTwoParam<String, Double> acc2Par1 = new AccountTwoParam<>("erwe324435", 45.0);
        System.out.println(acc2Par1);

        AccountTwoParam<Integer, Integer> acc2Par2 = new AccountTwoParam<>(1234, 100);
        System.out.println(acc2Par2);

        AccountTwoParam<Integer, Number> acc2Par3 = new AccountTwoParam<>(12345, 200);
        System.out.println(acc2Par3);

        AccountTwoParam<Integer, Double> acc2Par4 = new AccountTwoParam<>(12345, 100.0);
        System.out.println(acc2Par4);


        // Используем шаблонизированные методы
        Printer printer = new Printer();
        printer.print();
        Integer[] ints = {1,2,3,4,5,6,7,8,9};
        printer.print(ints);
        String[] strings = {"Tom", "Alice", "Sam", "Kate", "Bob", "Helen"};
        printer.print(strings);
        Boolean[] bools = {true, false};
        printer.print(bools);

        // Уточняющий вызов, применяется очень редко
        printer.<Integer>print(ints);
        printer.<String>print(strings);
        printer.<Boolean>print(bools);



    }

}
