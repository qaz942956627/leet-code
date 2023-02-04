package leetcode.editor.cn;

//leetcode submit region begin(Prohibit modification and deletion)
class Solution64 {

    int[][] dp;
    public int minPathSum(int[][] grid) {


        int x = grid.length;
        int y = grid[0].length;

        dp = new int[x][y];


        return dp(grid, x - 1, y - 1);
    }

    // 自顶向下
    private int dp(int[][] grid, int x, int y) {
        if (x == 0 && y == 0) {
            return grid[x][y];
        }
        if (x < 0 || y < 0) {
            // 不合法区域
            return Integer.MAX_VALUE;
        }
        // Math.min(dp[i - 1][j], dp[i][j - 1]) + grid[i][j]

        if (dp[x][y] > 0) {
            return dp[x][y];
        }

        dp[x][y] = Math.min(dp(grid, x - 1, y), dp(grid, x, y - 1)) + grid[x][y];
        return dp[x][y];

    }

    // 自底向上
    public int minPathSum1(int[][] grid) {

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
                dp[i][j] = Math.min(dp[i - 1][j], dp[i][j - 1]) + grid[i][j];
            }
        }

        return dp[x - 1][y - 1];
    }

    public static void main(String[] args) {
        Solution solution = new Solution();
        // solution.minPathSum(new int[][]{{1, 3, 1}, {1, 5, 1}, {4, 2, 1}});
        // solution.minPathSum(new int[][]{{1, 2}, {5, 6}, {1, 1}});
    }
}
//leetcode submit region end(Prohibit modification and deletion)
