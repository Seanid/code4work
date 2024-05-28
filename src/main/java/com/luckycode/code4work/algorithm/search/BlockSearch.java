package com.luckycode.code4work.algorithm.search;

import java.util.Arrays;

/**
 * 分块查找
 */
public class BlockSearch {

    public static int blockSearch(int[] arr, int target) {

        int blockSize = (int) Math.sqrt(arr.length);

        for (int i = 0; i < arr.length; i += blockSize) {
            int left = i;
            int right = Math.min(left + blockSize - 1, arr.length - 1);
            //二分处理
            while (left <= right) {
                int mid = left + (right - left) / 2;
                if (arr[mid] == target) {
                    return mid;
                } else if (arr[mid] < target) {
                    left = mid + 1;
                } else {
                    right = mid - 1;
                }
            }
        }


        return -1;
    }

    public static void main(String[] args) {
        int[] arr = {64, 34, 25, 12, 22, 11, 90};
        //有序数组
        Arrays.sort(arr);
        System.out.println(Arrays.toString(arr));
        int target = 14;

        int p = blockSearch(arr, target);
        System.out.println(p);
    }
}
