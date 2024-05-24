package com.luckycode.code4work.algorithm.sort;

/**
 * 堆排序
 */
public class HeapSort {

    /**
     * 构建堆
     *
     * @param arr 堆数组
     * @param n   数组长度，防止越界
     * @param p   最大或最小值的定位
     */
    public static void buildHeap(int[] arr, int n, int p) {

        int i = p;
        //子节点
        int left = 2 * i + 1;
        int right = 2 * i + 2;

        if (left < n && arr[i] < arr[left]) {
            i = left;
        }

        if (right < n && arr[i] < arr[right]) {
            i = right;
        }

        //如果当前值不是最大或者最小，交换并下沉
        if (i != p) {
            swap(arr, i, p);

            buildHeap(arr, n, p);
        }


    }

    public static void swap(int[] arr, int i, int j) {
        int tmp = arr[i];
        arr[i] = arr[j];
        arr[j] = tmp;
    }

    public static void heapSort(int[] arr) {
        int n = arr.length;

        //构建初始化堆
        for (int i = n / 2 - 1; i >= 0; i--) {
            buildHeap(arr, n, i);
        }
        System.out.println("====Sorted array: ");
        for (int i : arr) {
            System.out.print(i + " ");
        }
        for (int i = n - 1; i > 0; i--) {
            //将尾部与顶部进行交换
            swap(arr, 0, i);
            //重新构建堆栈
            buildHeap(arr, i, 0);
        }

    }

    public static void main(String[] args) {
        int[] arr = {64, 34, 25, 12, 22, 11, 90};
        heapSort(arr);
        System.out.println("Sorted array: ");
        for (int i : arr) {
            System.out.print(i + " ");
        }
    }
}
