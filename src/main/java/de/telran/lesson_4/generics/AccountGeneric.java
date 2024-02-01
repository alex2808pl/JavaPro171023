package de.telran.lesson_4.generics;

public class AccountGeneric<T> {
    private T id;
    private int sum;

    public AccountGeneric(T id, int sum) {
        this.id = id;
        this.sum = sum;
    }

    public T getId() {
        return id;
    }

    public void setId(T id) {
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
        return "AccountGeneric{" +
                "id=" + id +
                ", sum=" + sum +
                '}';
    }
}
