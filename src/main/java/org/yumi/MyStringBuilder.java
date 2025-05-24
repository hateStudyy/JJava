package org.yumi;

import java.util.StringJoiner;

public class MyStringBuilder {
    public static void main(String[] args) {
        StringBuilder sb = new StringBuilder();
        StringBuffer sbf = new StringBuffer();
        String str = "hello";
        StringJoiner sj = new StringJoiner(",","[","]");
        sb.insert(0,60);
        sb.insert(0,str + "2");
        sb.insert(0,str + "3");
        System.out.println(sb);
    }
}
