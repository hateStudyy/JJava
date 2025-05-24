package org.yumi;

import java.util.Scanner;

public class Question_1024 {
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        String str = in.nextLine();
        String[] es = str.split("E");
        for (String e : es) {
            System.out.println(e);
        }
    }
}
