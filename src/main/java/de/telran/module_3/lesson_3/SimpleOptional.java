package de.telran.module_3.lesson_3;

import java.util.Arrays;
import java.util.Optional;

public class SimpleOptional {
    public static void main(String[] args) {
        String str = null;
        if(str!=null && !str.isEmpty()) {
            str.length();
        }
        str = getData();
//        str.length();

//        str = getDataOptional().get(); //тот же null
        str = getDataOptional().orElse("");

        str.length();

        str = getDataOptional().orElse("");

        String[] arrStr = new String[10];
        arrStr[1] = "Vfvf";
        System.out.println(Arrays.toString(arrStr));
        for (String el : arrStr) {
            Optional<String> strOpt = Optional.ofNullable(el);
            strOpt.orElse("").length();
        }
    }

    private static String getData() {
        String str = null;
        return str;
    }

    private static Optional<String> getDataOptional() {
        String str = null;
        return Optional.ofNullable(null);
    }
}
