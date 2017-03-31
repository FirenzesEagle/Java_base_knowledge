package me.liumingbo.designPattern.strategyPattern;

/**
 * 设计模式 ( 十八 ) 策略模式Strategy（对象行为型）
 * <p>
 * Created by bjliumingbo on 2017/3/21.
 */
public class Strategy {
    /**
     * 没有使用策略模式的情况
     *
     * @param type
     */
    public void selectSort(String type) {
        if ("type1".equals(type)) {
            //选择快速排序
        } else if ("type2".equals(type)) {
            //选择插入排序
        } else if ("type3".equals(type)) {
            //选择冒泡排序
        } else if ("type4".equals(type)) {
            //选择选择排序
        }
    }
}
