package org.yumi;

import org.junit.Test;

import java.util.Arrays;
import java.util.List;

import static org.hamcrest.CoreMatchers.hasItem;
import static org.hamcrest.MatcherAssert.assertThat;

public class MyDependencies {
    public static void main(String[] args) {
        System.out.println("Hello World!");
    }

    @Test
    public void test1() {
        System.out.println("Hello World!");
        List<String> list = Arrays.asList("apple", "banana", "cherry");
        assertThat(list, hasItem("abc")); // 判断集合是否包含 "banana"
    }
    @Test
    public void test2() {
        System.out.println("Hello World!");
    }
    @Test
    public void test3() {
        System.out.println("Hello World!");
    }
    @Test
    public void test4() {
        System.out.println("Hello World!");
    }

}
