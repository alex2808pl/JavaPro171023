package de.telran.module_4.lesson_3;

import java.io.IOException;
import java.nio.ByteBuffer;
import java.nio.channels.FileChannel;
import java.nio.file.Path;
import java.nio.file.Paths;

import static java.nio.file.StandardOpenOption.READ;
import static java.nio.file.StandardOpenOption.WRITE;

public class SimpleChannel {
    public static void main(String[] args) {
        Path pathDefault = Paths.get("testFile.txt");

        String s = "I was here!\n";
        byte data[] = s.getBytes();
        ByteBuffer out = ByteBuffer.wrap(data);

        ByteBuffer copy = ByteBuffer.allocate(12);

        try (FileChannel fc = (FileChannel.open(pathDefault, READ, WRITE))) {
            // Читаем первые 12 байт из файла.
            int nread;
            do {
                nread = fc.read(copy);
            } while (nread != -1 && copy.hasRemaining());

            // Пишем "I was here!" в начало файла.
            fc.position(0);
            while (out.hasRemaining())
                fc.write(out);
            out.rewind();

            // Перемещаемся в конец файла. Копируем первые 12 байт в
            // конец файла.  Пишем "I was here!" снова.
            long length = fc.size();
            fc.position(length-1);
            copy.flip();
            while (copy.hasRemaining())
                fc.write(copy);
            while (out.hasRemaining())
                fc.write(out);
        } catch (IOException x) {
            System.out.println("I/O Exception: " + x);
        }
    }
}
