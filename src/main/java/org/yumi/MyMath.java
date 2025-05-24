package org.yumi;

public class MyMath {
    public static void main(String[] args) {
        System.out.println(Math.abs(-100.0));
        Math.round(100.6);
        System.out.println(Math.round(100.6));
        System.out.println(Math.round(100.5));
        System.out.println(Math.round(100.4999999));
    }

    public void test() {
        System.out.println("test");
    }
    public int test(int n) {
        System.out.println("test2");
        return n;
    }
}
