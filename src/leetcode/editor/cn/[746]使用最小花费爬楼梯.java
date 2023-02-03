package leetcode.editor.cn;

//leetcode submit region begin(Prohibit modification and deletion)
class Solution {

    public int minCostClimbingStairs(int[] cost) {
        int n = cost.length;
        int[] dp = new int[n + 1];
        // 达到0和1的最小花费是0,起始可以选择从0开始走,可以选择从1开始走
        dp[0] = dp[1] = 0;
        for (int i = 2; i <= n; i++) {
            // 达到i的花费是
            // 1.达到i-1的最小花费+cost[i - 1] 走一步
            // 2.到达i-2的最小花费+cost[i - 2] 走两步
            // 去最小值
            dp[i] = Math.min(dp[i - 1] + cost[i - 1], dp[i - 2] + cost[i - 2]);
        }
        return dp[n];
    }

    public static void main(String[] args) {
        Solution solution = new Solution();
        System.out.println(solution.minCostClimbingStairs(new int[]{10, 15, 20}));
    }
}
//leetcode submit region end(Prohibit modification and deletion)
