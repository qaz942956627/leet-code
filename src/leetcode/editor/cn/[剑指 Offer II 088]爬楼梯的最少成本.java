package leetcode.editor.cn;

//leetcode submit region begin(Prohibit modification and deletion)
class SolutionJ088 {
    public int minCostClimbingStairs(int[] cost) {

        int length = cost.length;
        int[] dp = new int[length + 1];

        // 达到0和1需要的花费是0
        dp[0] = dp[1] = 0;


        for (int i = 2; i <= length; i++) {
            dp[i] = Math.min(dp[i - 2] + cost[i - 2], dp[i - 1] + cost[i - 1]);
        }

        return dp[length];
    }

    public static void main(String[] args) {
        Solution solution = new Solution();
        solution.minCostClimbingStairs(new int[]{10, 15, 20});
    }
}
//leetcode submit region end(Prohibit modification and deletion)
