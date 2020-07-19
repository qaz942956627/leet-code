package com.lu.linkedlist;

import com.sun.istack.internal.NotNull;

import java.util.LinkedList;
import java.util.List;

public class _53_最大子序和 {

    /**
     * 动态规划
     * 每一次都记录最大长度 当之前最长连续元素的和和当前元素相加 如果更大就加上 如果更小就放弃之前全部元素
     * @param nums
     * @return
     */
    public int maxSubArray(int[] nums) {
        int pre = 0, maxAns = nums[0];
        for (int x : nums) {
            pre = Math.max(pre + x, x);
            maxAns = Math.max(maxAns, pre);
        }
        return maxAns;
    }

    public int maxSubArray1(int[] nums) {
        int num = nums[0];
        //当前和,最大和
        int currSum = num, maxSum = num;
        for (int i = 1; i < nums.length; i++) {
            //当前值
            int currValue = nums[i];
            //当前和 = 当前值+之前和
            currSum = currValue + currSum;

            //如果当前元素加上之前的和更小了则放弃之前元素的和
            currSum = Math.max(currValue , currSum);
            //之前和不小于0比较当前和和历史最大和
            maxSum = Math.max(currSum, maxSum);
        }
        return maxSum;
    }
}
