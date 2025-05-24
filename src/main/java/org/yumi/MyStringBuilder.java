package org.yumi;

import java.util.StringJoiner;

public class MyStringBuilder {
    public static void main(String[] args) {
        StringBuilder sb = new StringBuilder();
        StringBuffer sbf = new StringBuffer();
        String str = "hello";
        StringJoiner sj = new StringJoiner(",","[","]");
    }
}
