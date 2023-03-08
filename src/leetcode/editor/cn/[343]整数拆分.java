package leetcode.editor.cn;

//leetcode submit region begin(Prohibit modification and deletion)
class Solution343 {
    int[] memo;
    public int integerBreak(int n) {
        memo = new int[n + 1];
        return dp(n);
    }
    int dp(int n){
        if (n == 0) {
            return n;
        }
        if (n == 1) {
            return n;
        }

        if (memo[n]>0) {
            return memo[n];
        }
        int res = Integer.MIN_VALUE;
        // i=1 保证至少拆分了一次
        for (int i = 1; i < n; i++) {
            res = Math.max(res, i * Math.max(dp(n - i), n - i));
        }
        memo[n] = res;
        return res;
    }

}
//leetcode submit region end(Prohibit modification and deletion)
