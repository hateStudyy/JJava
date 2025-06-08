package org.yumi.mynet;

class BankAccount2 {
    private int balance = 100;
    private int stock  = 100;

    public int getBalance() {
        return balance;
    }

    public void withdraw(int amount) {
        balance = balance - amount;
    }

    public void sellStock(int amount) {
        stock = stock - amount;
    }

    public int getStock() {
        return stock;
    }
}

public class RyanAndMonicaJob2 implements Runnable {
    private BankAccount2 account = new BankAccount2();

    public static void main(String[] args) {
        RyanAndMonicaJob2 theJob = new RyanAndMonicaJob2();
        Thread one = new Thread(theJob);
        Thread two = new Thread(theJob);
        one.setName("Ryan");
        two.setName("Monica");
        one.start();
        two.start();
    }

    public void run() {
        for (int x = 0; x < 10; x++) {
            makeWithdrawal(10);
            if (account.getBalance() < 0) {
                System.out.println("Overdrawn!");
            }
        }

        for (int x = 0; x < 10; x++) {
            makeSellStock(10);
            if (account.getStock() < 0) {
                System.out.println("Overdrawn!");
            }
        }
    }

    // 加 synchronized 关键字
    private synchronized void makeWithdrawal(int amount) {
        if (account.getBalance() >= amount) {
            System.out.println(Thread.currentThread().getName() + " is about to withdraw");
            try {
                System.out.println(Thread.currentThread().getName() + " is going to sleep");
                Thread.sleep(500);
            } catch (InterruptedException ex) {
                ex.printStackTrace();
            }
            System.out.println(Thread.currentThread().getName() + " woke up.");
            account.withdraw(amount);
            System.out.println(Thread.currentThread().getName() + " completes the withdrawal");
        } else {
            System.out.println("Sorry, not enough balance for " + Thread.currentThread().getName());
        }
    }

    // 这个方法不加 synchronized 不会被锁住
    private void makeSellStock(int amount) {
        if (account.getStock() >= amount) {
            System.out.println(Thread.currentThread().getName() + " is about to sell stock");
            try {
                System.out.println(Thread.currentThread().getName() + " is going to sleep");
                Thread.sleep(500);
            } catch (InterruptedException ex) {
                ex.printStackTrace();
            }
            System.out.println(Thread.currentThread().getName() + " woke up.");
            account.sellStock(amount);
            System.out.println(Thread.currentThread().getName() + " completes the sell stock");
        } else {
            System.out.println("Sorry, not enough stock for " + Thread.currentThread().getName());
        }
    }
}