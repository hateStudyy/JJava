package org.yumi;

import static java.lang.Math.pow;

public class MyString {
    public static void main(String[] args) {
        String str = "2 2 0 0 0 3 0 0 1 0";
        char[] charArray = str.toCharArray();
        for (char c : charArray) {
            System.out.println(c);
        }

        String s1 = "1814/09/06";
        String s2 = "1814/09/20";
        System.out.println("-----------------");
        System.out.println(s2.compareTo(s1));
        String str1 = "7_This_is_a_test\n";
        String upperCase = str1.toUpperCase();
//        System.out.println(str1.toUpperCase());
        System.out.println("========myUpperCase======");
        for (int i = 0; i < upperCase.length(); i++) {
            System.out.print(upperCase.charAt(i));
        }
    }
}
