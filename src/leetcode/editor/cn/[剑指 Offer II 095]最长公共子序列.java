package leetcode.editor.cn;

//leetcode submit region begin(Prohibit modification and deletion)
class SolutionJ095 {
    public int longestCommonSubsequence(String text1, String text2) {
        int m = text1.length();
        int n = text2.length();

        // dp数组定义 dp[m][n] 为 text1[0,m],text2[0,n] 最长公共子序列长度
        // 索引为0表示空字符串
        int[][] dp = new int[m + 1][n + 1];

        // base case 有任何一方是空串则那一行或者一列都是0

        // 转移方向 左 左上 上 转移到右下方

        // 状态text1[m] 等于或者不等于 text2[n]
        // 下标从1开始 0的位置子序列长度一定是0 因为有一方是空串
        for (int i = 1; i <= m; i++) {
            for (int j = 1; j <= n; j++) {
                // 相等的时候
                if (text1.charAt(i - 1) == text2.charAt(j - 1)) {
                    dp[i][j] = dp[i - 1][j - 1] + 1;
                } else {
                    // 不等的时候 取 text1[0,i-1]和text2[0,j] 和 text1[0,i]和text2[0,j-1] 中更大的值
                    dp[i][j] = Math.max(dp[i - 1][j], dp[i][j - 1]);
                }
            }
        }

        return dp[m][n];

    }

    public static void main(String[] args) {
//        Solution solution = new Solution();
//        solution.longestCommonSubsequence("abcde", "ace");
    }
}
//leetcode submit region end(Prohibit modification and deletion)
