package com.luckycode.code4work.algorithm.sort;

import java.util.Arrays;

/**
 * 计数排序
 */
public class CountingSort {

    public static void countingSort(int[] arr){
        int max= Arrays.stream(arr).max().getAsInt();
        int min= Arrays.stream(arr).min().getAsInt();

        int n=arr.length;
        int range=max-min+1;
        int[] count=new int[range];
        int[] out=new int[n];

        Arrays.stream(arr).forEach(value -> count[value-min]++);
        int index=0;

        //根据数量进行赋值
        for (int i = 0 ; i <range; i++) {
            while (count[i]>0){
                out[index++]=min+i;
                count[i]--;
            }
        }
        System.arraycopy(out,0,arr,0,arr.length);
    }

    public static void main(String[] args) {
        int[] arr = {64, 34, 25, 12, 22, 11, 90};
        countingSort(arr);
        System.out.println("Sorted array: ");
        for (int i : arr) {
            System.out.print(i + " ");
        }
    }

}
