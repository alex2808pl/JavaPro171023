package de.telran.module_1.generics;

public class AccountString implements Accountable<String>{
    private String id;
    private int sum;

    public AccountString(String id, int sum) {
        this.id = id;
        this.sum = sum;
    }

    @Override
    public String getId() {
        return id;
    }

    @Override
    public void setId(String id) {
        if(id != null && !id.isEmpty())
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

}
