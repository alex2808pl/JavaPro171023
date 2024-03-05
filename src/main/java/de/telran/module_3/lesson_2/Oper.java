package de.telran.module_3.lesson_2;

import java.util.function.Function;

class Oper implements Function<String, Integer> {
    @Override
    public Integer apply(String s) {
        return Integer.parseInt(s);
    }
}