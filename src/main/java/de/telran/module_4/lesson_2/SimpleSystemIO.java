package de.telran.module_4.lesson_2;

import java.io.*;
import java.util.Scanner;

public class SimpleSystemIO {
    public static void main(String[] args)  {
        //Scanner
        Scanner scanner = new Scanner(System.in);
        System.out.print("Введите число: ");
        int num = scanner.nextInt();
        System.out.println("Scanner = "+num);

        // InputStream
        InputStream inputStream = System.in;
        Reader reader = new InputStreamReader(inputStream);
        BufferedReader bufferedReader = new BufferedReader(reader);
        boolean isError = false;
        String str = null;
        do {
            try {
                Thread.sleep(100);
                System.out.print("Введите число: ");
                str = bufferedReader.readLine();
                num = Integer.parseInt(str);
                isError = false;
            }
            catch (NumberFormatException | IOException e) {
                System.err.printf("Ошибка ввода данных!%n");
                isError = true;
            }
//            catch (IOException e) {
//                System.err.println("Ошибка ввода данных!%n");
//                isError = true;
//            }
            catch (InterruptedException e) {
                throw new RuntimeException(e);
            }
        } while (isError);


        System.out.println(String.format("ReadLine = %d", num));

        System.out.printf("Строка = %s будет преобразована в число = %d", str, num);



    }
}
