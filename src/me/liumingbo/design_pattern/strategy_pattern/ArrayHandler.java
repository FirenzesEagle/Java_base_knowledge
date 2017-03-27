package me.liumingbo.design_pattern.strategy_pattern;

/**
 * Created by bjliumingbo on 2017/3/27.
 */
public class ArrayHandler {
    private Sort sortObj;

    public int[] sort(int arr[]){
        sortObj.sort(arr);
        return arr;
    }

    public void setSortObj(Sort sortObj){
        this.sortObj = sortObj;
    }
}
