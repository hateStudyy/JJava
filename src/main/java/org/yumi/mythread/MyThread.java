package org.yumi.mythread;

public class MyThread {
    public static void main(String[] args) {
        new Thread(() -> {
            System.out.println("Hello World in the thread 1");
        }).start();

        System.out.println("Hello World in the thread main");
    }
}
