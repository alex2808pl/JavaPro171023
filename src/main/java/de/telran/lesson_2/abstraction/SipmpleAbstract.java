package de.telran.lesson_2.abstraction;

public class SipmpleAbstract {
    public static void main(String[] args) {
       // Printer printer = new Printer(); // это абстракный класс, объект создавать нельзя

        LaserPrinter laserPrinter = new LaserPrinter();
        laserPrinter.print();

        MatrixPrinter matrixPrinter = new MatrixPrinter();
        matrixPrinter.print();

        JetPrinter jetPrinter = new JetPrinter();
        jetPrinter.print();
      }
}
