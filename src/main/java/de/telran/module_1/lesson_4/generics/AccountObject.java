package de.telran.module_1.lesson_4.generics;

public class AccountObject {
    private Object id;
    private int sum;

    public AccountObject(Object id, int sum) {
        this.id = id;
        this.sum = sum;
    }

    public Object getId() {
        return id;
    }

    public void setId(Object id) {
        this.id = id;
    }

    public int getSum() {
        return sum;
    }

    public void setSum(int sum) {
        this.sum = sum;
    }

    @Override
    public String toString() {
        return "AccountObject{" +
                "id=" + id +
                ", sum=" + sum +
                '}';
    }
}
