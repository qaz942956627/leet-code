package leetcode.editor.cn;

// leetcode submit region begin(Prohibit modification and deletion)
class SolutionJ46 {
    public int translateNum(int num) {

        String chars = String.valueOf(num);
        int length = chars.length();


        int first = 1, second = 1;


        for (int i = 2; i <= length; i++) {

            int cur = 0;
            // i-1是当前字符
            char c = chars.charAt(i - 1);
            // i-2是上一个字符
            char d = chars.charAt(i - 2);
            // 当前字符不论是什么都可以作为一个字符来表示
            cur += second;
            // 如果上一个字符是1则可以和上一个字符一起组成10-19
            // 如果上一个字符是2则可以和0-5组成20-25
            if (d == '1' || (d == '2' && c <= '5')) {
                cur += first;
            }

            first = second;
            second = cur;
        }
        return second;
    }

    public int translateNum1(int num) {

        String chars = String.valueOf(num);
        int[] dp = new int[chars.length() + 1];
        dp[0] = 1;
        dp[1] = 1;

        int length = chars.length();
        // dp[i] 标识有i个字符时有多少种标识方法
        for (int i = 2; i <= length; i++) {
            // i-1是当前字符
            char c = chars.charAt(i - 1);
            // i-2是上一个字符
            char d = chars.charAt(i - 2);
            // 当前字符不论是什么都可以作为一个字符来表示
            dp[i] += dp[i - 1];
            // 如果上一个字符是1则可以和上一个字符一起组成10-19
            // 如果上一个字符是2则可以和0-5组成20-25
            if (d == '1' || (d == '2' && c <= '5')) {
                dp[i] += dp[i - 2];
            }
        }
        return dp[length];
    }
}
// leetcode submit region end(Prohibit modification and deletion)
