package com.lu.other;

public class _70_爬楼梯 {

    //单纯递归
    public int climbStairs1(int n) {

        if (n == 1) {
            return 1;
        } else if (n == 2) {
            return 2;
        } else {
            return climbStairs(n - 2) + climbStairs(n - 1);
        }
    }

    //记忆递归避免重复计算
    public int climbStairs(int n) {

        int[] memo = new int[n + 1];
        return climbStairsMemo(n, memo);
    }

    private int climbStairsMemo(int n, int[] memo) {
        if (memo[n] > 0) {
            return memo[n];
        }
        if (n == 1) {
            return 1;
        } else if (n == 2) {
            return 2;
        } else {
            memo[n] =  climbStairsMemo(n - 2, memo) + climbStairsMemo(n - 1,memo);
        }
        return memo[n];

    }
}
