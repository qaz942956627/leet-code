package leetcode.editor.cn;

//leetcode submit region begin(Prohibit modification and deletion)
class Solution70 {
    public int climbStairs(int n) {

        if (n<2) {
            return n;
        }

        int dp_n_1 = 1, dp_n_2 = 2;
        for (int i = 3; i <= n; i++) {
            int dp_i = dp_n_1 + dp_n_2;
            int temp = dp_n_2;
            dp_n_2 = dp_i;
            dp_n_1 = temp;
        }
        return dp_n_2;

    }
}
//leetcode submit region end(Prohibit modification and deletion)
