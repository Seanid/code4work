package com.luckycode.code4work.algorithm.search;

import com.luckycode.code4work.algorithm.sort.QuickSort;

import java.util.Arrays;

/**
 * 二分查找
 */
public class BinarySearch {

    public static int binarySearch(int[] arr, int target) {
        int low = 0;
        int high = arr.length - 1;
        while (low < high) {
            int mid = (high - low) / 2;

            if (arr[mid] == target) {
                return mid;
            } else if (arr[mid] < target) {
                low = mid;
            } else {
                high = mid;
            }
        }
        return -1;
    }

    public static void main(String[] args) {
        int[] arr = {64, 34, 25, 12, 22, 11, 90};
        //有序数组
        Arrays.sort(arr);
        System.out.println(Arrays.toString(arr));
        int target = 12;
        int p = binarySearch(arr, target);
        System.out.println(p);
    }

}
