package com.luckycode.code4work.algorithm.search;

import java.util.Arrays;

/**
 * 指数查找
 */
public class ExponentialSearch {


    public static int exponentialSearch(int[] arr, int target) {
        int low = 0;
        int high = 1;
        int n = arr.length;
        //通过指数定位范围
        while (high < n && arr[high] < target) {
            low = high;
            high *= 2;
        }
        //通过二分缩减范围
        int mid = 0;
        while (low <= high) {
            mid = (low + high) / 2;
            if (arr[mid] < target) {
                low = mid + 1;
            } else if (arr[mid] > target) {
                high = mid - 1;
            } else {
                return mid;
            }
        }

        //线性排查
        for (int i = low; i >= 0; i--) {
            if (arr[i] == target) {
                return i;
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

        int p = exponentialSearch(arr, target);
        System.out.println(p);
    }
}
