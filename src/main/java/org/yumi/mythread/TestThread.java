package org.yumi.mythread;

public class TestThread {
    public static void main(String[] args) {
        ThreadClass threadClass = new ThreadClass();
        threadClass.start();
        ThreadClassRunnable threadClassRunnable = new ThreadClassRunnable();
        threadClassRunnable.run();
    }
}
