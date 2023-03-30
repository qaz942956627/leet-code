package leetcode.editor.cn;

//leetcode submit region begin(Prohibit modification and deletion)
class SolutionJ099 {
    public int minPathSum(int[][] grid) {

        int m = grid.length;
        int n = grid[0].length;

        // dp数组定义 dp[m][n] 是 走到grid[m][n]的最小路径和
        int[][] dp = new int[m][n];
        dp[0][0] = grid[0][0];

        // base case 横向或者纵向固定只有一种走法,直接从起点走到目标
        for (int i = 1; i < m; i++) {
            dp[i][0] = dp[i - 1][0] + grid[i][0];
        }

        for (int j = 1; j < n; j++) {
            dp[0][j] = dp[0][j - 1] + grid[0][j];
        }

        // 状态 要么从左边走过来,要么从上边走过来
        for (int i = 1; i < m; i++) {
            for (int j = 1; j < n; j++) {
                // dp[i][j] = 取左边和上边里边的最小值 + grid[i][j]
                dp[i][j] = Math.min(dp[i - 1][j], dp[i][j - 1]) + grid[i][j];
            }
        }
        return dp[m - 1][n - 1];
    }
}
//leetcode submit region end(Prohibit modification and deletion)
