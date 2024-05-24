package com.luckycode.code4work.algorithm.sort;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;

/**
 * 基数排序
 */
public class RadixSort {

    public static void radixSort(int[] arr){
        int max= Arrays.stream(arr).max().getAsInt();
        int exp=1;

        /**
         * 可以基于桶排序也可以基于计数排序
         */
        while (max/exp>0){


            List<List<Integer>> buckets=new ArrayList<>();

            //初始化桶
            for (int i = 0; i < 10; i++) {
                buckets.add(i,new ArrayList<>());
            }
            //入桶

            for (int i = 0; i < arr.length; i++) {
                buckets.get((arr[i]/exp)%10).add(arr[i]);
            }

            //重排
            int index=0;
            for (List<Integer> list:buckets){
                for (Integer value:list){
                    arr[index++]=value;
                }
            }
            //提高位数
            exp*=10;

        }

    }
    public static void main(String[] args) {
        int[] arr = {64, 34, 25, 12, 22, 11, 90};
        radixSort(arr);
        System.out.println("Sorted array: ");
        for (int i : arr) {
            System.out.print(i + " ");
        }
    }
}
