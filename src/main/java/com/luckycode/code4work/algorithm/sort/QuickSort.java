package com.luckycode.code4work.algorithm.sort;

/**
 * 快速排序
 */
public class QuickSort {


    public static void quickSort(int[] arr, int low, int heigh) {
        if (low < heigh) {
            int p = partition(arr, low, heigh);
            //处理基准左侧
            quickSort(arr, low, p - 1);
            //处理基准右侧
            quickSort(arr, p + 1, heigh);
        }

    }


    public static int partition(int[] arr, int low, int heigh) {
        //基准，可以是第一个，最后一个，中间某个
        int pivot = arr[heigh];
        int i = low - 1;
        for (int j = low; j < heigh; j++) {
            if (arr[j] < pivot) {
                i++;
                swap(arr, i, j);
            }
        }
        //将pivot 定位到准确的位置
        swap(arr, i + 1, heigh);
        return i + 1;
    }

    public static void swap(int[] arr, int i, int j) {
        int tmp = arr[i];
        arr[i] = arr[j];
        arr[j] = tmp;
    }


    public static void main(String[] args) {
        int[] arr = {64, 34, 25, 12, 22, 11, 90};
        quickSort(arr, 0, arr.length - 1);
        System.out.println("Sorted array: ");
        for (int i : arr) {
            System.out.print(i + " ");
        }
    }

}
