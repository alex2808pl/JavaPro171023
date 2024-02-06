package de.telran.module_1.lesson_2.interfaces;

public class Account implements Cashier, Manager, Client{
    private String num;
    private double sum;
    private String name;
    private String dateCreate;

    public Account(String num, double sum, String name, String dateCreate) {
        this.num = num;
        this.sum = sum;
        this.name = name;
        this.dateCreate = dateCreate;
    }

    public String getNum() {
        return num;
    }

    public void setNum(String num) {
        this.num = num;
    }

    public double getSum() {
        return sum;
    }

    public void setSum(double sum) {
        this.sum = sum;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getDateCreate() {
        return dateCreate;
    }

    public void setDateCreate(String dateCreate) {
        this.dateCreate = dateCreate;
    }
}
