package de.telran.lesson_2.agregation;

import de.telran.lesson_1.Car;

public class VehicleCargo { //агрегация
    private Cargo cargo = new Cargo("Mul", 0); //ЯВЛЯЕТСЯ ЧАСТЬЮ (Композиция)
    private Vehicle vehicle = new Vehicle(); //ЯВЛЯЕТСЯ ЧАСТЬЮ (Композиция)

    private Passenger[] passengers = new Passenger[5]; //ЯВЛЯЕТСЯ ЧАСТЬЮ (Агрегация)

    public void inputVolumeAndPassenger(int volume, int countPassenger) {
        cargo.input(volume);
        vehicle.setInto(countPassenger);

        System.out.println("Груз = "+cargo.getVolume()+", пассажиров = "+vehicle.getCountPassenger());
        System.out.println(cargo);
        System.out.println(vehicle);
    }

    public Cargo getCargo() {
        return cargo;
    }

    public Passenger[] getPassengers() {
        return passengers;
    }

    public void setPassengers(Passenger[] passengers) {
        this.passengers = passengers;
    }
}
