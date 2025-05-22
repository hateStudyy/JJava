package org.yumi;

import static java.lang.Math.pow;

public class MyString {
    public static void main(String[] args) {
        String str = "Hello World!";
        char[] charArray = str.toCharArray();
        for (char c : charArray) {
            System.out.println(c);
        }
        System.out.println("substring(): " + str.substring(1));

        System.out.println("=======================");
        char[] charArray2 =  {'H', 'e', 'l', 'l', 'o'};
        String str2 = String.valueOf(charArray2);
        System.out.println(str2);
    }
}
