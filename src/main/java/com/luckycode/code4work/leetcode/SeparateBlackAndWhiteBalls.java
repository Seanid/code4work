package com.luckycode.code4work.leetcode;

import java.util.Arrays;

/**
 * 区分黑球与白球
 * 题目描述：https://leetcode.cn/problems/separate-black-and-white-balls/
 * 解题思路：
 * 使用贪心逻辑，遍历字符串，假设遇到1就都往右去换，那每次需要交换的时候的步数，就是沿路遇到的1的数量以此累加即可
 * 0100110 - 0010110 -0001110 -0000111
 *              1   +  1    + 3 = 5
 */
public class SeparateBlackAndWhiteBalls {
    public long minimumSteps(String s) {

        if (s == null || s.length() == 0) return 0;

        Long result = 0L;
        Long blackBall = 0L;
        for (int i = 0; i < s.length(); i++) {
            if (s.charAt(i) == '1') {
                blackBall++;
            }else if (s.charAt(i) == '0') {
                //遇到0就意味着需要移动
                result += blackBall;
            }

        }


        return result;
    }

    public static void main(String[] args) {
        System.out.println(new SeparateBlackAndWhiteBalls().minimumSteps("0100110"));
    }
}
