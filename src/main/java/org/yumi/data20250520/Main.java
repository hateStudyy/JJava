package org.yumi.data20250520;

import org.yumi.Drawing;

import java.util.ArrayList;

public class Main {
    public static void main(String[] args) {
        System.out.println('A'-'0');
        ArrayList<String> strings = new ArrayList<>();
        strings.add("Hello");
        strings.add("World");
        strings.forEach(System.out::println);

    }
}
