package com.luckycode.code4work.algorithm.sort;

/**
 * 希尔排序
 */
public class ShellSort {


    public static void shellSort(int[] arr){
        int n= arr.length;
        int gap=n/2;
        while (gap>0){

            for (int i = gap; i <n; i++) {
                int tmp=arr[i];
                int j=0;
                for ( j = i; j >=gap && arr[j-gap]>tmp ; j-=gap) {
                    arr[j]=arr[j-gap];
                }
                arr[j]=tmp;
            }
            gap=gap/2;
        }
    }

    public static void main(String[] args) {
        int[] arr = {64, 34, 25, 12, 22, 11, 90};
        shellSort(arr);
        System.out.println("Sorted array: ");
        for (int i : arr) {
            System.out.print(i + " ");
        }
    }


}
