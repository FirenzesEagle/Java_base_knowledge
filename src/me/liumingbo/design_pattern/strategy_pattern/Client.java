package me.liumingbo.design_pattern.strategy_pattern;

/**
 * Created by bjliumingbo on 2017/3/27.
 */
public class Client {
    public static void main(String args[]) {
        int arr[] = {1, 4, 6, 2, 5, 3, 7, 10, 9};
        int result[];
        ArrayHandler ah = new ArrayHandler();

        Sort sort = new SelectionSort();    //使用选择排序

        ah.setSortObj(sort); //设置具体策略
        result = ah.sort(arr);

        for (int i = 0; i < result.length; i++) {
            System.out.print(result[i] + ",");
        }
    }
}
