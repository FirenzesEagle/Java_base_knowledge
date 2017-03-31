package me.liumingbo.designPattern.strategyPattern;

/**
 * 冒泡排序
 * <p>
 * Created by bjliumingbo on 2017/3/21.
 */
public class BubbleSort implements Sort {
    @Override
    public int[] sort(int[] arr) {
        int length = arr.length;
        for (int i = 0; i < length; i++) {
            for (int j = i + 1; j < length; j++) {
                int temp = 0;
                if (arr[i] > arr[j]) {
                    temp = arr[j];
                    arr[j] = arr[i];
                    arr[i] = temp;
                }
            }
        }
        System.out.println("冒泡排序");
        return arr;
    }
}
