package de.telran.module_6.lesson_3.lock;

import java.util.Arrays;
import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

public class SimpleBankLock {
    public static final int NACCOUNTS = 100;
    public static final double INITIAL_BALANCE = 1000;
    public static final double MAX_AMOUNT = 1000;
    public static final int DELAY = 10;

    public static void main(String[] args) {
        var bank = new Bank(NACCOUNTS, INITIAL_BALANCE);
        for (int i = 0; i < NACCOUNTS; i++) {
            int fromAccount = i;
            Runnable r = () ->
            {
                try {
                    while (true) {
                        int toAccount = (int) (bank.size() * Math.random());
                        double amount = MAX_AMOUNT * Math.random();
                        bank.transfer(fromAccount, toAccount, amount);
                        Thread.sleep((int) (DELAY * Math.random()));
                    }
                } catch (InterruptedException e) {
                }
            };
            var t = new Thread(r);
            t.start();
        }
    }
}

class Bank
{
    private final double[] accounts;
    private final Lock bankLock = new ReentrantLock();

    /**
     * Конструктор.
     * @param n — количество счетов
     * @param initialBalance — изначальный баланс на каждом счете
     */

    public Bank(int n, double initialBalance)
    {
        accounts = new double[n];
        Arrays.fill(accounts, initialBalance);
    }

    /**
     * Осуществляет переводы средств с одного счета на другой.
     * @param from — счет, с которого осуществляется перевод
     * @param to — счет, куда осуществляется перевод
     * @param amount — сумма для перевода
     */

    public void transfer(int from, int to, double amount)
    {
        if (accounts[from] < amount) return;
        System.out.print(Thread.currentThread());
        bankLock.lock(); //ставит блокировку
        try {
            accounts[from] -= amount;
            System.out.printf(" %10.2f from %d to %d", amount, from, to);
            accounts[to] += amount;
            System.out.printf(" Total Balance: %10.2f%n", getTotalBalance());
        }
        finally {
            bankLock.unlock();  // снимаем блокировку
        }


    }

    /**
     * Считает сумму остатков на всех счетах.
     * @return общий баланс
     */

    public double getTotalBalance()
    {
        double sum = 0;
        for (double a : accounts)
            sum += a;
        return sum; }
    /**
     * Возвращает количества счетов в банке.
     * @return количество счетов
     */
    public int size()
    {
        return accounts.length;
    }
}

