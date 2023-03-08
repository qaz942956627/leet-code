package leetcode.editor.cn;

//leetcode submit region begin(Prohibit modification and deletion)
class SolutionJ14_1 {

    int[] memo;
    public int cuttingRope(int n) {

        memo = new int[n + 1];
        return dp(n);

    }

    int dp(int n) {
        if (n==0) {
            return 0;
        }
        if (n==1) {
            return 1;
        }
        if (memo[n]>0) {
            return memo[n];
        }
        int res = Integer.MIN_VALUE;
        int mid = n>>1;
        for (int i = 1; i <= mid; i++) {
            res = Math.max(res, i * Math.max(dp(n - i), n - i));
        }
        memo[n] = res;
        return res;

    }


}
//leetcode submit region end(Prohibit modification and deletion)
