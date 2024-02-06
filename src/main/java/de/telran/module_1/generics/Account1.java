package de.telran.module_1.generics;

import java.util.Objects;

public class Account1 {
    private int id;
    private int sum;

    public Account1(int id, int sum) {
        this.id = id;
        this.sum = sum;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
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
        return "Account1{" +
                "id=" + id +
                ", sum=" + sum +
                '}';
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Account1 account1 = (Account1) o;
        return id == account1.id && sum == account1.sum;
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, sum);
    }
}
