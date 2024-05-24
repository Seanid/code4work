package com.luckycode.code4work.algorithm.sort;

/**
 * 冒泡排序
 */
public class BubbleSort {


    private static void bubbleSort(int[] arr) {
        int length = arr.length;
        int tmp = 0;
        for (int i = 0; i < length - 1; i++) {
            boolean swap = false;
            for (int j = 0; j < length - i - 1; j++) {
                if (arr[j] > arr[j + 1]) {
                    tmp = arr[j];
                    arr[j] = arr[j + 1];
                    arr[j + 1] = tmp;
                    swap = true;
                }
            }
            /**
             * 通过标识，提前预支是否交换过，确定需不需要继续排序
             */
            if (!swap) {
                break;
            }
        }

    }


    public static void main(String[] args) {
        int[] arr = {64, 34, 25, 12, 22, 11, 90};
        bubbleSort(arr);
        System.out.println("Sorted array: ");
        for (int i : arr) {
            System.out.print(i + " ");
        }
    }
}
