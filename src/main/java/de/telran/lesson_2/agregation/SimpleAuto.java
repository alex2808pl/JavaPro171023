package de.telran.lesson_2.agregation;

import java.util.Arrays;

public class SimpleAuto {
    public static void main(String[] args) {
        Cargo c1 = new Cargo("BMW", 10);
        c1.input(5);
        c1.run();
        System.out.println("Он везет груз весом = "+c1.getVolume());

        Vehicle v1 = new Vehicle("VW",1);
        v1.setInto(2);
        v1.run();
        System.out.println("Он везет пассажиров = "+v1.getCountPassenger());

        Passenger pas1 = new Passenger("Вася", 20);
        Passenger pas2 = new Passenger("Петя", 30);


        VehicleCargo vc1 = new VehicleCargo();
        vc1.inputVolumeAndPassenger(5, 3);
        vc1.getCargo().run();
        Passenger[] passengers = new Passenger[5];
        passengers[0] = pas1;
        passengers[1] = pas2;
        vc1.setPassengers(passengers);
        System.out.println(Arrays.toString(vc1.getPassengers()));


        VehicleCargo vc2 = new VehicleCargo();
        vc2.inputVolumeAndPassenger(8, 1);
        vc2.getCargo().run();
        passengers = new Passenger[5];
        passengers[0] = pas1;
        vc2.setPassengers(passengers);
        System.out.println(Arrays.toString(vc2.getPassengers()));


    }
}
