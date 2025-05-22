package org.yumi;

import java.util.Arrays;

public class MyArrays {
    public static void main(String[] args) {
        String str = "hello";
        char[] chars = str.toCharArray();
//        Arrays.sort(chars, (a, b) -> b - a);
        System.out.println(Arrays.toString(chars));
    }
}
