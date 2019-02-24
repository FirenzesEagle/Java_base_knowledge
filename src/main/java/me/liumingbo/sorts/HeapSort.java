package me.liumingbo.sorts;

/**
 * Created by FirenzesEagle on 2017/6/22.
 * Email:liumingbo2008@gmail.com
 */
public class HeapSort {
    private int[] array;
    public HeapSort(int[] arr) {
        this.array = arr;
    }
    private int getParentIndex(int child) {
        return (child - 1) / 2;
    }
    private int getLeftChildIndex(int parent) {
        return 2 * parent + 1;
    }
    /**
     * 初始化一个大根堆。
     */
    private void initHeap() {
        int last = array.length - 1;
        for (int i = getParentIndex(last); i >= 0; --i) { // 从最后一个非叶子结点开始筛选
            int k = i;
            int j = getLeftChildIndex(k);
            while (j <= last) {
                if (j < last) {
                    if (array[j] <= array[j + 1]) { // 右子节点更大
                        j++;
                    }
                }
                if (array[k] > array[j]) {           //父节点大于子节点中较大者，已经找到最终位置
                    break; // 停止筛选
                } else {
                    swap(k, j);
                    k = j; // 继续筛选
                }
                j = getLeftChildIndex(k);
            }// loop while
        }// loop i
    }
    /**
     * 调整堆。
     */
    private void adjustHeap(int lastIndex) {
        int k = 0;
        while (k <= getParentIndex(lastIndex)) {
            int j = getLeftChildIndex(k);
            if (j < lastIndex) {
                if (array[j] < array[j + 1]) {
                    j++;
                }
            }
            if (array[k] < array[j]) {
                swap(k, j);
                k = j; // 继续筛选
            } else {
                break; // 停止筛选
            }
        }
    }
    /**
     * 堆排序。
     * */
    public void sort() {
        initHeap();
        int last = array.length - 1;
        while (last > 0) {
            swap(0, last);
            last--;
            if (last > 0) { // 这里如果不判断，将造成最终前两个元素逆序。
                adjustHeap(last);
            }
        }
    }
    private void swap(int i, int j) {
        int temp = array[i];
        array[i] = array[j];
        array[j] = temp;
    }
}