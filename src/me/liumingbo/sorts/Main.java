package me.liumingbo.sorts;

import java.util.Arrays;

/**
 * Created by FirenzesEagle on 2016/11/14.
 * Email:liumingbo2008@gmail.com
 */
public class Main {
    public static void main(String[] args) {
        Integer[] a = {1, 2, 3, 4, 5, 6, 3, 1, 2, 3};
        Sort.bubbleSort(a);
        System.out.println(Arrays.toString(a));
    }
}
