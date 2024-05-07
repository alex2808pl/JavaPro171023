package de.telran.module_7.lesson_2.dry;

public class Mechanic {
    public void serviceBus() {
        System.out.println("Servicing bus now");
//        System.out.println("Washing..."); // дублирование кода
    }
    public void serviceCar() {
        System.out.println("Servicing car now");
//        System.out.println("Washing..."); // дублирование кода
    }

    public void washVehicle() {
        System.out.println("Washing...!!!");
    }

    public static void main(String[] args) {
        Mechanic mechanic = new Mechanic();
        mechanic.serviceBus();
        mechanic.washVehicle();
        mechanic.serviceCar();
        mechanic.washVehicle();
    }
}