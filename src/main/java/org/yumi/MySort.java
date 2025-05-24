package org.yumi;

import java.util.Arrays;
import java.util.Comparator;

public class MySort {
    public static void main(String[] args) {
        Double[] arr = {1.0, 2.0, 3.0, 4.0, 5.0, 6.0, 7.0, 8.0, 9.0, 10.0};
        Arrays.sort(arr, Comparator.comparing(o -> o));
        Arrays.sort(arr, Comparator.reverseOrder());
        System.out.println(Arrays.toString(arr));
    }
}
