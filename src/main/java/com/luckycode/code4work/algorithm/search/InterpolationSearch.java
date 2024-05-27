package com.luckycode.code4work.algorithm.search;

import java.util.Arrays;

/**
 * 插值查找
 */
public class InterpolationSearch {

    public static int interpolationSearch (int[] arr,int target){
        int low=0;
        int high=arr.length-1;

        while (low<high&&arr[low]<=target&& arr[high]>=target){


            int pos=low + ((target - arr[low]) * (high - low)) / (arr[high] - arr[low]);

            if (arr[pos]==target){
                return pos;
            }else if (arr[pos]<target){
                low=pos+1;
            }else {
                high=pos-1;
            }

        }
        return -1;
    }
    public static void main(String[] args) {
        int[] arr = {64, 34, 25, 12, 22, 11, 90};
        //有序数组
        Arrays.sort(arr);
        System.out.println(Arrays.toString(arr));
        int target=14;
        int p=interpolationSearch(arr,target);
        System.out.println(p);
    }

}
