package me.liumingbo.sorts;


public final class Sort {

    /**
     * 最差时间分析: O(n2)
     * 平均时间复杂度: O(n2)
     * 稳定度: 稳定
     * 空间复杂度: O(1)
     */
    public static <AnyType extends Comparable<? super AnyType>>
    void bubbleSort(AnyType[] a) {
        for (int i = 0; i < a.length - 1; i++) {
            for (int j = 0; j < a.length - i - 1; j++) {
                if (a[j].compareTo(a[j + 1]) > 0) {
                    AnyType temp = a[j + 1];
                    a[j + 1] = a[j];
                    a[j] = temp;
                }
            }
        }
    }

}
