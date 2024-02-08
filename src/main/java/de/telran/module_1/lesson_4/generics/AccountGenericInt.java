package de.telran.module_1.lesson_4.generics;

public class AccountGenericInt<T> implements Accountable<T>{
    private T id;
    private int sum;

    public AccountGenericInt(T id, int sum) {
        this.id = id;
        this.sum = sum;
    }

    @Override
    public T getId() {
        return id;
    }

    @Override
    public void setId(T id) {
        this.id = id;
    }

    @Override
    public int getSum() {
        return sum;
    }

    @Override
    public void setSum(int sum) {
        this.sum = sum;
    }

    @Override
    public String toString() {
        return "AccountGenericInt{" +
                "id=" + id +
                ", sum=" + sum +
                '}';
    }
}
