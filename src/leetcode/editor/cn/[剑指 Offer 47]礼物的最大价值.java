package leetcode.editor.cn;

//leetcode submit region begin(Prohibit modification and deletion)
class SolutionJ47 {
    public int maxValue(int[][] grid) {

        int x = grid.length;
        int y = grid[0].length;

        int[][] dp = new int[x][y];

        dp[0][0] = grid[0][0];
        for (int i = 1; i < x; i++) {
            dp[i][0] = dp[i - 1][0] + grid[i][0];
        }
        for (int i = 1; i < y; i++) {
            dp[0][i] = dp[0][i - 1] + grid[0][i];
        }

        for (int i = 1; i < x; i++) {
            for (int j = 1; j < y; j++) {
                dp[i][j] = Math.max(dp[i - 1][j], dp[i][j - 1]) + grid[i][j];
            }
        }
        return dp[x - 1][y - 1];

    }

    public static void main(String[] args) {
        // int[][] arr = new int[3][2];
        // Solution solution = new Solution();
        // solution.maxValue(arr);
    }
}
//leetcode submit region end(Prohibit modification and deletion)
