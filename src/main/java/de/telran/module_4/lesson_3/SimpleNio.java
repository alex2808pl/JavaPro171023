package de.telran.module_4.lesson_3;

import de.telran.module_1.lesson_2.abstraction2.Soundable;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.nio.file.StandardCopyOption;

public class SimpleNio {
    public static void main(String[] args) throws IOException {
        Path pathDefault = Paths.get("testFile.txt");
        Path pathAbsolut = Paths.get("D:/java/projects/students/JavaPro171023/src/main/resources");
        Path path = Paths.get("src/main/resources/testResourceFile.txt");
        System.out.println(path.toAbsolutePath());
        System.out.println(pathDefault.toAbsolutePath());
        System.out.println(path.getNameCount()); // сколько элементов в пути
        System.out.println(path.getName(0));
        System.out.println(path.getName(path.getNameCount()-1));
        System.out.println(path.getParent());

        //Существование
        System.out.println("testFile.txt -> "+Files.exists(pathDefault)); // default
        System.out.println("testResourceFile.txt -> "+Files.exists(path)); //src/main/resources/testFile.txt
        if (Files.notExists(path)) {
            path = Files.createFile(path); //создаем файл
            System.out.println("testResourceFile.txt -> "+Files.exists(path));
        }

        // это папка? есть аналогичные для других объектов
        System.out.println(Files.isDirectory(path));
        System.out.println(Files.isDirectory(pathAbsolut));

        // Метаданные - свойства элемента
        System.out.println("Метаданные - свойства элемента");
        System.out.println(Files.isHidden(path));
        System.out.println(Files.isExecutable(path));
        System.out.println(Files.isWritable(path));
        System.out.println(Files.isReadable(path));
        System.out.println(Files.getOwner(path));

        System.out.println("Один и тот же файл? ->" +Files.isSameFile(path, pathDefault));

        //Копирование
        //        StandardCopyOption.REPLACE_EXISTING заменять существующие файлы.
        //        StandardCopyOption.COPY_ATTRIBUTES копирует атрибуты файла.
        path = Files.copy(pathDefault, path, StandardCopyOption.REPLACE_EXISTING, StandardCopyOption.COPY_ATTRIBUTES);

        // Перенос
        //        StandardCopyOption.REPLACE_EXISTING заменяет существующий файл, если он существует.
        //        StandardCopyOption.ATOMIC_MOVE попытка осуществить перемещение файла как единую атомарную операцию. Все остальные опции игнорируются.
        Path newPath = Files.move(path,
                Paths.get("D:/java/projects/students/JavaPro171023/"+path.getName(path.getNameCount()-1)),
                StandardCopyOption.REPLACE_EXISTING);

        // Удаление
        System.out.println("Удаление - "+Files.deleteIfExists(path));
        // System.out.println("Удаление - "+Files.deleteIfExists(pathAbsolut)); //удалять мы можем только пустой каталог





    }
}
