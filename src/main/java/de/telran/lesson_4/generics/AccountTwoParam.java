package de.telran.lesson_4.generics;

public class AccountTwoParam<I , S extends Number>{
    private I id;
    private S sum;

    public AccountTwoParam(I id, S sum) {
        this.id = id;
        this.sum = sum;
    }

    public I getId() {
        return id;
    }

    public void setId(I id) {
        this.id = id;
    }

    public S getSum() {
        return sum;
    }

    public void setSum(S sum) {
        this.sum = sum;
    }

    @Override
    public String toString() {
        return "AccountTwoParam{" +
                "id=" + id +
                ", sum=" + sum +
                '}';
    }
}
