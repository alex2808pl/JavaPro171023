package de.telran.lesson_2;

public class Unicorn extends Horse{
    int countHorn;

    public Unicorn() {
    }


    public Unicorn(String name, int weight, String color, int countHorn) {
        super(name, 0, weight, color);
        this.countHorn = countHorn;
    }

    public void butt() {
        System.out.println(name+" при защите бодается "+countHorn+" рогами");
    }
}
