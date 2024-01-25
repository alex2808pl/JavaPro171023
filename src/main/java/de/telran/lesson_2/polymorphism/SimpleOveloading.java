package de.telran.lesson_2.polymorphism;

public class SimpleOveloading {
    public static void main(String[] args) {
        System.out.println(add(2,5));

        float resultFloat = add(5.0F ,7);  // 5
        System.out.println(resultFloat);

        System.out.println(add(5));



    }


    public static int add(int arg1, int arg2) {
        int result = arg1 + arg2;
        return result;
    }

    public static float add(float arg1, int arg2) {
        float result = arg1 + arg2;
        return result;
    }

    public static int add(int arg1) {
        return arg1+arg1;
    }
}
