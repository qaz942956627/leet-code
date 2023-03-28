package leetcode.editor.cn;

//leetcode submit region begin(Prohibit modification and deletion)
class SolutionJ091 {

    public int minCost(int[][] costs) {
        int length = costs.length;
        // dp数组定义 当第 i 个房子粉刷颜色 j 时，粉刷 [0..i] 这些房子所需的最少花费为 dp[i][j]
        int[][] dp = new int[length][3];

        dp[0][0] = costs[0][0];
        dp[0][1] = costs[0][1];
        dp[0][2] = costs[0][2];

        // 红色:0
        // 蓝色:1
        // 绿色:2
        for (int i = 1; i < length; i++) {
            // 选择红色
            dp[i][0] = Math.min(dp[i - 1][1], dp[i - 1][2]) + costs[i][0];
            // 选择蓝色
            dp[i][1] = Math.min(dp[i - 1][0], dp[i - 1][2]) + costs[i][1];
            // 选择绿色
            dp[i][2] = Math.min(dp[i - 1][0], dp[i - 1][1]) + costs[i][2];
        }

        return Math.min(Math.min(dp[length - 1][0], dp[length - 1][1]), dp[length - 1][2]);
    }

}
//leetcode submit region end(Prohibit modification and deletion)
