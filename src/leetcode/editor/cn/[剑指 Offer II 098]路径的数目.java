package leetcode.editor.cn;

//leetcode submit region begin(Prohibit modification and deletion)
class SolutionJ098 {
    public int uniquePaths(int m, int n) {

        // dp数组定义 dp[m][n] = 走到m,n的位置有几种走法
        int[][] dp = new int[m][n];

        // base case 第一行和第一列只有一种走法
        for (int i = 0; i < m; i++) {
            dp[i][0] = 1;
        }
        for (int j = 1; j < n; j++) {
            dp[0][j] = 1;
        }

        // 状态 从当前单元格左边走过了或者从当前单元格上边走过来
        for (int i = 1; i < m; i++) {
            for (int j = 1; j < n; j++) {
                dp[i][j] = dp[i - 1][j] + dp[i][j - 1];
            }
        }

        return dp[m - 1][n - 1];

    }
}
//leetcode submit region end(Prohibit modification and deletion)
