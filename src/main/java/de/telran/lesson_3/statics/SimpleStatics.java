package de.telran.lesson_3.statics;

public class SimpleStatics {

    static Cat cat6;
    static Cat cat7;

    static Cat cat8 =  new Cat("Вася", 7);

    static {
        cat6 = new Cat("Вася", 7);
        cat7 = new Cat("Том", 8);
        System.out.println("Запустился static блок инициализации");
    }

    public static void main(String[] args) {

        Cat cat1 = new Cat("Вася", 10);
        System.out.println(cat1); //вызывается сat1.toString()

//        Cat.countEars = 10; // private static
        Cat.setCountEars(10);
        System.out.println(cat1); //вызывается сat1.toString()

        Cat cat2 = new Cat("Том", 5);
        System.out.println(cat2);

        System.out.println(cat1); //вызывается сat1.toString()

        Math.abs(-225); //пример утилитного класса

        System.out.println(Cat.COUNT_LEGS);

        final Cat cat3 = new Cat("Петя", 10); // final тут работает только для ссылки на объект
        // cat3 = cat2; //нельзя переприсваивать ссылку, объект final
        cat3.setAge(5);
        System.out.println(cat3);

        System.out.println(cat6);
        System.out.println(cat7);
        System.out.println(cat8);
    }
}
