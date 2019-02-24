package me.liumingbo.sorts;

public final class Sort {

    /**
     * 最差时间分析: O(n2)
     * 平均时间复杂度: O(n2)
     * 稳定度: 稳定
     * 空间复杂度: O(1)
     * 最好情况：有序 n-1次
     */
    void bubbleSort(int[] array) {
        for (int i = 0; i < array.length - 1; i++) {
            for (int j = 0; j < array.length - i - 1; j++) {
                if (array[j] > array[j + 1]) {
                    swap(array, j, j + 1);
                }
            }
        }
    }

    /**
     * 最差时间分析: O(n2)
     * 平均时间复杂度: O(n2)
     * 稳定度: 不稳定
     * 空间复杂度: O(1)
     * 最好情况：有序 n-1次
     */
    void selectSort(int[] array) {
        int min;
        for (int i = 0; i < array.length - 1; i++) {
            min = i;
            for (int j = i + 1; j < array.length - 1; j++) {
                if (array[min] > array[j]) {
                    min = j;
                }
            }
            if (min != i) {
                swap(array, min, i);
            }
        }
    }

    /**
     * 最差时间分析: O(n2)
     * 平均时间复杂度: O(n2)
     * 稳定度: 稳定
     * 空间复杂度: O(1)
     * 最好情况：有序 比较n-1次
     */
    void insertSort(int[] array) {
        for (int i = 1; i < array.length; i++) {
            int j = i;
            while (j > 0 && array[j] < array[j - 1]) {
                swap(array, j, j - 1);
                j--;
            }
        }
    }

    /**
     * 最差时间分析: O(n2)
     * 平均时间复杂度: O(nlogn)
     * 稳定度: 不稳定
     * 空间复杂度: O(1)
     * 最好情况：nlogn 一趟排序将数字分为独立的两部分
     * 最差情况，n2 每次划分只能将序列分为一个元素与其他元素两部分，退化为冒泡排序
     */
    void quickSort(int[] array, int low, int high) {
        if (low > high) {
            return;
        }
        int i = low, j = high;
        int key = array[low];
        while (i != j) {
            while (i < j && key <= array[j]) {
                j--;
            }
            while (i < j && key >= array[i]) {
                i++;
            }
            if (i < j) {
                swap(array, i, j);
            }
        }
        swap(array, low, i);
        quickSort(array, low, i - 1);
        quickSort(array, i + 1, high);
    }

    /**
     * 最差时间分析: O(nlogn)
     * 平均时间复杂度: O(nlogn)
     * 稳定度: 稳定
     * 空间复杂度: O(n)
     */
    void mergeSort(int[] array) {
        int[] temp = new int[array.length];
        sort(array, 0, array.length - 1, temp);
    }

    private void sort(int[] array, int left, int right, int[] temp) {
        if (left < right) {
            int mid = (left + right) / 2;
            sort(array, left, mid, temp);
            sort(array, mid + 1, right, temp);
            merge(array, left, mid, right, temp);
        }
    }

    private void merge(int[] array, int left, int mid, int right, int[] temp) {
        int i = left;
        int j = mid + 1;
        int t = 0;
        while (i <= mid && j <= right) {
            if (array[i] <= array[j]) {
                temp[t++] = array[i++];
            } else {
                temp[t++] = array[j++];
            }
        }
        while (i <= mid) {
            temp[t++] = array[i++];
        }
        while (j <= right) {
            temp[t++] = array[j++];
        }
        t = 0;
        while (left <= right) {
            array[left++] = temp[t++];
        }
    }

    void swap(int[] array, int a, int b) {
        int tmp = array[a];
        array[a] = array[b];
        array[b] = tmp;
    }

}
