package de.telran.module_5.lesson_1;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class SimpleRegGreedy {
    public static void main(String[] args) {
        String str = "Егор Анна Александр";
        String regEx = "А.+а"; //жадный используется по умолчанию
//        String regEx = "А.+?а"; //ленивый
//        String regEx = "А.++а"; //сверхжадный
//        String regEx = "А.++$"; //сверхжадный корректный для данной строки
        Pattern pattern = Pattern.compile(regEx);
        Matcher matcher = pattern.matcher(str);
        while (matcher.find()) {
            System.out.println(matcher.start()+" --- "+matcher.end());
            System.out.println(str.substring(matcher.start(), matcher.end()));
        }

        System.out.println(Pattern.matches(regEx, "Анна"));

    }
}
