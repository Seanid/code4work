package com.luckycode.code4work.leetcode;

/**
 * 相同数目的最大操作数I
 * 问题描述：https://leetcode.cn/problems/maximum-number-of-operations-with-the-same-score-i/description/
 * 简单的暴力破解
 */
public class MaximumNumberOfOperationsWithTheSameScoreI {

    public int maxOperations(int[] nums) {
        if (nums.length < 1 ) return 0;
        int sum= nums[0]+nums[1];
        int i=1;
        for (int j = 3; j < nums.length; j+=2) {
            if (sum==nums[j]+nums[j-1]) {
                i++;
            }else {break;}
        }
        return i;
    }


    public static void main(String[] args) {
        int i=new MaximumNumberOfOperationsWithTheSameScoreI().maxOperations(new int[]{1,1,1,1,1,1});
        System.out.println(i);

    }

}
