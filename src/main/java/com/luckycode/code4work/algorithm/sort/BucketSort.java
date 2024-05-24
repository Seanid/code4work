package com.luckycode.code4work.algorithm.sort;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;

/**
 * 桶排序
 */
public class BucketSort {

    public static void bucketSort(int[] arr){

        //获取最大值最小值，确定桶大小
        int max= Arrays.stream(arr).max().getAsInt();
        int min=Arrays.stream(arr).min().getAsInt();
        int bucketSize=(max-min)/ arr.length+1;

        //初始化桶，可以用二维数组，也可以用arraylist
        List<List<Integer>> buckets=new ArrayList<>();
        for (int i = 0; i < bucketSize; i++) {
            buckets.add(new ArrayList<>());
        }

        //分配元素
        Arrays.stream(arr).forEach(value -> buckets.get((value-min)/bucketSize).add(value));

        //对桶进行排序,可以采用任何排序
        buckets.stream().forEach(list-> Collections.sort(list));

        //重新分配桶
        int index=0;
        for (List<Integer> list : buckets){
            for (Integer i:list){
                arr[index++]=i;
            }
        }

    }

    public static void main(String[] args) {
        int[] arr = {64, 34, 25, 12, 22, 11, 90};
        bucketSort(arr);
        System.out.println("Sorted array: ");
        for (int i : arr) {
            System.out.print(i + " ");
        }
    }


}
