package org.yumi;

import jdk.jfr.Unsigned;

public class MyBasicType {
    public static void main(String[] args) {
        long l = 12345;
        System.out.println(Long.BYTES);
        System.out.println(Long.reverse(l)
        );
        System.out.println(Long.toBinaryString(l));
        System.out.println(Long.valueOf(l));
        System.out.println(Long.toUnsignedString(l));
        System.out.println(Long.toHexString(l));
        System.out.println(Long.toOctalString(l));
        System.out.println(Long.MAX_VALUE);
        System.out.println(Long.MIN_VALUE);
    }
}
