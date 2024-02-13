package de.telran.module_2.lesson_3;

import java.util.Enumeration;
import java.util.Vector;

public class SimpleEnumerator {
    public static void main(String[] args) {
        // считается устаревшим, не рекомендуется к использованию
        Vector<Integer> vector = new Vector<>();
        for (int i = 0; i < 10; i++) {
            vector.addElement(i);
        }
        System.out.println(vector);
        Enumeration<Integer> enumeration = vector.elements();
        while (enumeration.hasMoreElements()) {
            int el = enumeration.nextElement();
            System.out.print(el+",");

        }



    }
}
