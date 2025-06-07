package org.yumi.mythread;

public class LoopCreateThread {
    public static void main(String[] args) {
        for (int i = 0; i < 10; i++) {
            int finalI = i;
            new Thread(() -> System.out.println("Hello World in the thread " + finalI)).start();
        }
        System.out.println("Hello World in main");
    }
}
