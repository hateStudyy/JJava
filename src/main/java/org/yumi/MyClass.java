package org.yumi;

public class MyClass {
    private String message = "Default Message";

    public void sayHello() {
        System.out.println("Message: " + message);
    }

    public void greet(String name) {
        System.out.println("Hello, " + name + "!");
    }
}