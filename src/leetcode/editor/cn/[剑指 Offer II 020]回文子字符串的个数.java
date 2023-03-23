package leetcode.editor.cn;

//leetcode submit region begin(Prohibit modification and deletion)
class SolutionJ020 {
    public int countSubstrings(String s) {
        int length = s.length();
        // dp定义: i子串起点索引,j子串终点索引 dp[i][j] 标识子串s[i,j]是否为回文
        // i==j 一定是回文 如果s[i]==s[j] 并且j-i<=2一定是回文
        boolean[][] dp = new boolean[length][length];
        int res = 0;

        // dp[0][0]->dp[length][length]一定是true状态是从左下角转义到当前位置所以
        // 参考图片 https://pic.leetcode-cn.com/1618880567-KpUPHx-image.png
        for (int j = 0; j < length; j++) {
            for (int i = 0; i <= j; i++) {
                // 如果两边不等则不是回文
                if (s.charAt(i)!=s.charAt(j)) {
                    continue;
                }
                // j - i<=2 一定是回文 j - i>2的场景 dp[i + 1][j - 1]=true则dp[i][j]是回文
                if (j - i <= 2 || dp[i + 1][j - 1]) {
                    dp[i][j] = true;
                    res++;
                }
            }
        }

        return res;
    }

}
//leetcode submit region end(Prohibit modification and deletion)
