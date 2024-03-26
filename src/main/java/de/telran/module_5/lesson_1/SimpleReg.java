package de.telran.module_5.lesson_1;

import java.util.Arrays;
import java.util.regex.Matcher;
import java.util.regex.Pattern;
import java.util.regex.PatternSyntaxException;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class SimpleReg {
    public static void main(String[] args) {
        // Многократное использование
        String regEx = "www.*"; // * - справа должны быть любые символы 0 или юолее раз
        Pattern pattern = Pattern.compile(regEx);
        Matcher matcher = pattern.matcher("www.telran.de");
//        boolean matches = matcher.matches();
//        System.out.println("Result RegEx = "+matches);
        while (matcher.find()) {
            System.out.println(matcher.start() + " --- " + matcher.end());
        }


        // Однократное
        System.out.println("Result RegEx2 = " + Pattern.matches("www.*", "www.telran.de"));

        String s = "www.telran.de";
        System.out.println("Result RegEx String = " + s.matches("www.*"));


        String text = "I1learned2about3Telran4College5and6now7I'm8studying9Java";

        String delimiter = "\\d";
        pattern = Pattern.compile(delimiter, Pattern.CASE_INSENSITIVE);
        String[] result = pattern.split(text);

        for (String temp : result) {
            System.out.print(temp + " ");
        }
        System.out.println();

        text = "Мама,мыла раму.Мокрой тряпкой?";
//        delimiter = "[\\s,\\.,\\?, \\\\]"; // \\s
        delimiter = "[\\s,.?]"; // на слова
        delimiter = ""; // на символы
        pattern = Pattern.compile(delimiter, Pattern.CASE_INSENSITIVE);
        result = pattern.split(text);
        System.out.println(text);
        System.out.println(Arrays.toString(result));

        //IP адрес
        try {
            String zeroTo255 = "(\\d{1,2}|(0|1)\\d{2}|2[0-4]\\d|25[0-5])";
            String IPAddress = zeroTo255 + "\\." + zeroTo255 + "\\." + zeroTo255 + "\\." + zeroTo255;

            String ip = "125.38.3.255";

            System.out.println("IP = " + Pattern.matches(IPAddress, ip));
        } catch (PatternSyntaxException ex) {
            System.out.println(ex.getIndex() + " ---> "+ex.getPattern());
        }

    }
}
