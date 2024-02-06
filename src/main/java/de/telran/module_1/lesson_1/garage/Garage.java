package de.telran.module_1.lesson_1.garage;

import de.telran.module_1.lesson_1.Car;

public class Garage {
    public static void main(String[] args) {
        Car car = new Car("VW", 3, "желтый");
        car.setCountPassenger(2);
        car.run();
    }

}
