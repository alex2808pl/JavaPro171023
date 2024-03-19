package de.telran.module_4.lesson_2;

import java.io.*;

public class SimpleFileIO {
    public static void main(String[] args) {
        File testFile = new File("testFile.txt");
        try {
            if (!testFile.exists()) {  // если файл не существует
                if (testFile.createNewFile()) { // создаем файл
                    // запись в файл через байтовый поток
                    FileOutputStream streamOut = null;
                    streamOut = new FileOutputStream(testFile);
                    // создаем строку в виде байтового массива
                    String outStr = "This is my first experience when I myself work with IO API. \nI can do everything!";
                    byte[] output = outStr.getBytes();
                    streamOut.write(output);
                    streamOut.close();
                    System.out.println();
                }
            }
            //чтение из файла reader
            FileInputStream streamIn = null;
            try {
                streamIn = new FileInputStream(testFile);
            } catch (FileNotFoundException e) {
                throw new RuntimeException(e);
            }
            Reader reader = new InputStreamReader(streamIn);
            StringBuilder inStr = new StringBuilder(); // накопитель вычитанной информации
            int data = reader.read();
            while (data != -1) { // пока не конец файла
                inStr.append((char) data);
                System.out.print((char) data);
                data = reader.read(); // вычитываем символ в формате Unicode
            }
            reader.close();
            streamIn.close();
            System.out.println();
            System.out.println("Input from file --->> " + inStr);


            inStr.delete(0, inStr.length()); // чищу получатель
            //чтение из файла по байтам
            InputStream streamInI = new FileInputStream(testFile);
            data = streamInI.read();
            while (data != -1) { // пока не конец файла
                inStr.append((char) data);
//            System.out.print((char) data);
                data = streamInI.read();
            }
            streamInI.close();
            System.out.println();
            System.out.println("Получаю через InputStream ---> " + inStr);

            //чтение файла с помощью буфера построчно
            InputStream streamInBuf = new FileInputStream(testFile);
            BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(streamInBuf));
            String strIn = bufferedReader.readLine();
            while (strIn != null) { // пока есть строки
                System.out.println(strIn);
                strIn = bufferedReader.readLine();
            }
            bufferedReader.close();
            streamInBuf.close();

        } catch (FileNotFoundException | NullPointerException e) {
            System.out.println("Произошло исключение - " + e.getLocalizedMessage());
        } catch (IOException e) {
            System.out.println("Произошло исключение - " + e.getLocalizedMessage());
        } catch (Exception e) {
            System.out.println("Произошло исключение - " + e.getLocalizedMessage());
        } finally {
            System.out.println("Логика, которая отрабатывает всегда!!!");
        }

    }

}
