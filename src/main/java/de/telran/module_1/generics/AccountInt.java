package de.telran.module_1.generics;

public class AccountInt implements Accountable<Integer>{
    private Integer id;
    private int sum;

    public AccountInt(Integer id, int sum) {
        this.id = id;
        this.sum = sum;
    }

    @Override
    public Integer getId() {
        return id;
    }

    @Override
    public void setId(Integer id) {
        if(id>0)
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
        return "AccountInt{" +
                "id=" + id +
                ", sum=" + sum +
                '}';
    }
}
