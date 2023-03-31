package leetcode.editor.cn;

//leetcode submit region begin(Prohibit modification and deletion)
class SolutionJ096 {

    /**
     * 不能用双指针 这种解法有问题
     * "aa" "ab" "abaa"
     *
     * @param s1 s1
     * @param s2 s2
     * @param s3 s3
     * @return boolean
     */
    public boolean isInterleave1(String s1, String s2, String s3) {

        int sumLength = s3.length();
        int leftLength = s1.length();
        int rightLength = s2.length();
        if (leftLength + rightLength != sumLength) {
            return false;
        }

        if (leftLength == 0) {
            return s2.equals(s3);
        }
        if (rightLength == 0) {
            return s1.equals(s3);
        }

        int leftIndex = 0, rightIndex = 0;

        for (int i = 0; i < sumLength; i++) {
            char c = s3.charAt(i);

            if (leftIndex >= leftLength || c == s1.charAt(leftIndex)) {
                leftIndex++;
                continue;
            }
            if (rightIndex >= rightLength || c==s2.charAt(rightIndex)) {
                rightIndex++;
                continue;
            }
            return false;
        }
        return true;

    }

    public boolean isInterleave(String s1, String s2, String s3) {

        int s1Length = s1.length();
        int s2Length = s2.length();

        if (s1Length + s2Length != s3.length()) {
            return false;
        }

        // dp数组定义 dp[i][j] 是 s1[0,i] 和 s2[0,j] 能否交错组成s3[0,i+j]
        boolean[][] dp = new boolean[s1Length+1][s2Length+1];
        dp[0][0] = true;
        for (int i = 1; i <= s1Length; i++) {
            // 必须判断前一个是否为true 如果不判断在重复出现多个连续字符的时候结果不对
            dp[i][0] = dp[i - 1][0] && s1.charAt(i-1) == s3.charAt(i-1);
        }

        for (int j = 1; j <= s2Length; j++) {
            dp[0][j] = dp[0][j - 1] && s2.charAt(j-1) == s3.charAt(j-1);
        }

        for (int i = 1; i <= s1Length; i++) {
            for (int j = 1; j <= s2Length; j++) {

                int s3Index = i + j - 1;
                // dp[i - 1][j]前提条件之前的字符串必须能组合成功 判断s1[i - 1] == s3[s3Index] 才有意义
                dp[i][j] = dp[i - 1][j] && s1.charAt(i - 1) == s3.charAt(s3Index);
                // 如果已经找到dp[i][j] 能拼成s3的方法了 就不必要再找其他的方法了
                dp[i][j] = dp[i][j] || (dp[i][j - 1] && s2.charAt(j - 1) == s3.charAt(s3Index));
            }
        }

        return dp[s1Length][s2Length];

    }

    public static void main(String[] args) {
//        Solution solution = new Solution();
//        solution.isInterleave("db", "b", "cbb");
    }
}
//leetcode submit region end(Prohibit modification and deletion)
