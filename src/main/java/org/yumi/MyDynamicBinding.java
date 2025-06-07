package org.yumi;

public class MyDynamicBinding {
    public static void main(String[] args) {

        A a = new B();

        a.print();
    }
}
class A {
    public void print() {
        System.out.println("A");
    }
}

class  B extends A {
    public void print() {
        System.out.println("B");
    }
}

class C extends A {
    public void print() {
        System.out.println("C");
    }
}