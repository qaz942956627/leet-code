package leetcode.editor.cn;

import java.util.Arrays;

//leetcode submit region begin(Prohibit modification and deletion)
class Solution62 {

    public int uniquePaths(int m, int n) {

        int[][] dp = new int[m][n];

        // 竖着只有一条线的所有情况只有一路往下一种走法
        for (int i = 0; i < m; i++) {
            dp[i][0] = 1;
        }
        // 横着着只有一条线的所有情况只有一路往下一种走法
        for (int i = 0; i < n; i++) {
            dp[0][i] = 1;
        }

        // dp[i][j] 的最后一步只有两种走法
        // 1.从dp[i-1][j] 往下走一步
        // 2.从dp[i][j-1] 往右走一步
        // 所以转移方程 dp[i][j] = dp[i - 1][j] + dp[i][j - 1];
        for (int i = 1; i < m; i++) {
            for (int j = 1; j < n; j++) {
                dp[i][j] = dp[i - 1][j] + dp[i][j - 1];
            }
        }
        // for (int i = 0; i < dp.length; i++) {
        //     for (int j = 0; j < dp[i].length; j++) {
        //         System.out.print(dp[i][j]+"\t,");
        //     }
        //     System.out.println();
        // }
        return dp[m-1][n-1];
    }

    public static void main(String[] args) {
        // Solution solution = new Solution();
        // System.out.println(solution.uniquePaths(1, 2));
    }

}
//leetcode submit region end(Prohibit modification and deletion)
