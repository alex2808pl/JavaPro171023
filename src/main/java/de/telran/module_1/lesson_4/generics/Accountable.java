package de.telran.module_1.lesson_4.generics;

public interface Accountable <T>{
    T getId();
    void setId(T id);
    int getSum();
    void setSum(int sum);
}
