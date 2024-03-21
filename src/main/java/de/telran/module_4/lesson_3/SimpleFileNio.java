package de.telran.module_4.lesson_3;

import java.io.*;
import java.nio.ByteBuffer;
import java.nio.channels.FileChannel;
import java.nio.charset.StandardCharsets;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.nio.file.StandardOpenOption;
import java.util.ArrayList;
import java.util.List;

public class SimpleFileNio {
    public static void main(String[] args) throws IOException {

        // Чтение для большийх файлов
        Path pathFile = Paths.get("testFile.txt");
        byte[] buf = new byte[1000];

        List<String> stringList = new ArrayList<>();

        if (Files.exists(pathFile)) {
            try (BufferedReader reader = Files.newBufferedReader(pathFile, StandardCharsets.UTF_8);
                 ByteArrayInputStream bais = new ByteArrayInputStream(buf) /*ByteArrayInputStream для теста*/
            ) {
                String line;
                while ((line = reader.readLine()) != null) {
                    System.out.println(line);
                    stringList.add(line);
                }
            } catch (IOException e) {
                throw new RuntimeException(e);
            }
        }
        // Сохранение для большийх файлов

        Path pathCopyFile = Paths.get("testCopyFile.txt");
        if (Files.notExists(pathCopyFile)) {
            pathCopyFile = Files.createFile(pathCopyFile);
        }

        try (BufferedWriter writer = Files.newBufferedWriter(pathCopyFile, StandardCharsets.UTF_8,
                StandardOpenOption.WRITE,  StandardOpenOption.APPEND)) {
            stringList.stream().forEach(s -> {
                try {
                    writer.write(s);
                } catch (IOException e) {
                    throw new RuntimeException(e);
                }
            });

        } catch (IOException e) {
            throw new RuntimeException(e);
        }

        // Альтернативные варианты для коротких файлов

        // Читаем из файла
        List<String> lists = Files.readAllLines(pathFile);
        System.out.println(lists);

        // Запись в файл
        Path outPath = Files.write(pathCopyFile, lists, StandardOpenOption.APPEND);

    }
}
