package leetcode.editor.cn;

import java.util.Arrays;

// leetcode submit region begin(Prohibit modification and deletion)
class Solution {
    public int uniquePathsWithObstacles(int[][] obstacleGrid) {

        int m = obstacleGrid.length;
        int n = obstacleGrid[0].length;
        int[][] dp = new int[m][n];

        // 只有一行的时候中间任何一个位置出现了障碍物则后边的都永远不可能达到了
        for (int i = 0; i < m; i++) {
            if (obstacleGrid[i][0]==1) {
                break;
            }
            dp[i][0] = 1;
        }
        for (int i = 0; i < n; i++) {
            if (obstacleGrid[0][i]==1) {
                break;
            }
            dp[0][i] = 1;
        }


        for (int i = 1; i < m; i++) {
            for (int j = 1; j < n; j++) {
                if (obstacleGrid[i][j] == 1) {
                    // 目标点有障碍物则不可能到达目标点
                    dp[i][j] = 0;
                } else if (obstacleGrid[i - 1][j] == 1) {
                    // 目标点的上边有障碍物 则 dp[i][j] = dp[i][j - 1];
                    dp[i][j] = dp[i][j - 1];
                } else if (obstacleGrid[i][j - 1] == 1) {
                    // 目标点的左边有障碍物 则 dp[i][j] = dp[i - 1][j];
                    dp[i][j] = dp[i - 1][j];
                } else {
                    // 目标点的上下都没有障碍物则 dp[i][j] = dp[i - 1][j] + dp[i][j - 1];
                    dp[i][j] = dp[i - 1][j] + dp[i][j - 1];
                }
            }
        }
        return dp[m - 1][n - 1];
    }

    public static void main(String[] args) {
        int[][] dp = new int[1][1];
        System.out.println(Arrays.deepToString(dp));
    }
}
// leetcode submit region end(Prohibit modification and deletion)
