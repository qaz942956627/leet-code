package leetcode.editor.cn;

import java.util.Arrays;

//leetcode submit region begin(Prohibit modification and deletion)
class SolutionJ103 {

    /**
     * 备忘录
     */
    int[] memo;

    public int coinChange(int[] coins, int amount) {
        memo = new int[amount + 1];
        Arrays.fill(memo, Integer.MIN_VALUE);

        int dp = dp(coins, amount);
        return dp;
    }

    /**
     * dp函数定义 amount对应的最少的硬币个数
     *
     * @param coins  硬币
     * @param amount 量
     * @return int
     */
    int dp(int[] coins, int amount) {
        // 金额为负数的时候,无解返回-1
        if (amount<0) {
            return -1;
        }
        // 金额为0 选择0个硬币
        if (amount==0) {
            return 0;
        }
        // 查备忘录
        if (memo[amount] != Integer.MIN_VALUE) {
            return memo[amount];
        }
        int res = Integer.MAX_VALUE;
        for (int coin : coins) {
            int balance = amount - coin;
            int subProblem = dp(coins, balance);
            // 子问题无解 跳过
            if (subProblem == -1) {
                continue;
            }
            // 在子问题中找最优解
            res = Math.min(res, subProblem + 1);
        }
        memo[amount] = res == Integer.MAX_VALUE ? -1 : res;
        return memo[amount];
    }

    public static void main(String[] args) {
//        Solution solution = new Solution();
//        solution.coinChange(new int[]{1, 2, 5}, 11);
    }

}
//leetcode submit region end(Prohibit modification and deletion)
