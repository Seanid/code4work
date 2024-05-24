package com.luckycode.code4work.algorithm.sort;

/**
 * 插入排序
 */
public class InsertionSort {

    public static void insertionSort(int[] arr) {

        int length = arr.length;

        for (int i = 1; i < length; i++) {
            int key = arr[i];
            int index = i - 1;

            /**
             * 对已排序数组进行逐步对比，并按照大小顺位后移
             */
            while (index >= 0 && arr[index] > key) {
                arr[index + 1] = arr[index];
                index--;
            }
            /**
             * 将当前key插入到已排序数组准确位置中
             */
            arr[index + 1] = key;
        }


    }

    public static void main(String[] args) {
        int[] arr = {64, 34, 25, 12, 22, 11, 90};
        insertionSort(arr);
        System.out.println("Sorted array: ");
        for (int i : arr) {
            System.out.print(i + " ");
        }
    }

}
