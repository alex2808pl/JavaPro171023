package de.telran.module_4.lesson_2;

import java.io.File;
import java.io.IOException;

public class SimpleFileSystemIO {
    public static void main(String[] args) throws IOException {
        File file = new File("file.txt");

        //проверка существование
        boolean isExists = file.exists();
        System.out.println("file exists " + isExists);

        // создание файла
        boolean wasCreatedFile = file.createNewFile();
        System.out.println("created file " + wasCreatedFile);

        File filePath = new File("d:/1/file.txt");
        wasCreatedFile = filePath.createNewFile();
        System.out.println("created filePath " + wasCreatedFile);

        // Размер файла
        long length = file.length();
        System.out.println("size file " +length);

        // Удаление файла
        boolean success = file.delete();
        System.out.println("delete file - "+success);

        //создание папки
        File dir = new File("new_dir");
        boolean wasCreated = dir.mkdir();
        System.out.println("created dir " + wasCreated);

        // создание вложенного файла или директория
        File file1 = new File(dir, "file1.txt");
        if(!file1.exists()) {
            System.out.println("created file " + file1.createNewFile());
        }

        // удаление каталоги
        success = dir.delete(); // только пустые каталоги можно удалить
        System.out.println("delete dir - "+success);

        // удаление каталога с вложенными объектами
        success = deleteDir(dir);
        System.out.println("delete dir included - "+success);
    }

    public static boolean deleteDir(File dir){
        File[] files = dir.listFiles(); //возвращаем дочерние объекты
        if(files != null){
            for(File file : files){
                if(file.isDirectory()){ //это папка
                    deleteDir(file);
                } else {
                    file.delete(); // удаляем файл
                }
            }
        }
        return dir.delete();
    }
}
