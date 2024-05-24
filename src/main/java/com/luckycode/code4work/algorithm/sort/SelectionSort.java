package com.luckycode.code4work.algorithm.sort;

/**
 * 选择排序
 */
public class SelectionSort {

    /**
     * [ 9, 8, 3, 6, 2, 5, 4, 1 ]
     * [ 1, 8, 3, 6, 2, 5, 4, 9 ]
     * [ 1, 2, 3, 6, 8, 5, 4, 9 ]
     *
     * @param arr
     */
    public static void selectionSort(int[] arr) {

        int length = arr.length;
        int tmp = 0;
        for (int i = 0; i < length - 1; i++) {
            int maxIndex = i;
            for (int j = i + 1; j < length; j++) {
                maxIndex = arr[maxIndex] < arr[j] ? j : maxIndex;
            }
            if (maxIndex != i) {
                tmp = arr[i];
                arr[i] = arr[maxIndex];
                arr[maxIndex] = tmp;
            }
        }

    }

    public static void main(String[] args) {
        int[] arr = {64, 34, 25, 12, 22, 11, 90, 100};
        selectionSort(arr);
        System.out.println("Sorted array: ");
        for (int i : arr) {
            System.out.print(i + " ");
        }
    }

}
