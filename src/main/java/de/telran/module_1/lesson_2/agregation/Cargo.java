package de.telran.module_1.lesson_2.agregation;

public class Cargo extends Auto{ //наследование (ЯВЛЯЕТСЯ)
    private int volume = 0;

    public Cargo(String name, int volume) {
        super(name);
        this.volume = volume;
    }

    public Cargo() {
    }

    public void input(int volume) {
        this.volume += volume;
    }

    public void output(int volume) {
        this.volume -= volume;
    }

    public int getVolume() {
        return volume;
    }

}
