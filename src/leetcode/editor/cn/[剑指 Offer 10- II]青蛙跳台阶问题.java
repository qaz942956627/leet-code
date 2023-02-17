package leetcode.editor.cn;

//leetcode submit region begin(Prohibit modification and deletion)
class SolutionJ10_2 {
    public int numWays(int n) {

        if (n == 0) {
            return 1;
        }

        if (n < 2) {
            return n;
        }

        int Q = 1000000007;

        int n_1 = 1,n_2 = 2;

        for (int i = 3; i <= n; i++) {
            int dp_n =  (n_1 % Q + (n_2) % Q) % Q;
            int temp = n_2;
            n_2 = dp_n;
            n_1 = temp;
        }

        return n_2;

    }
}
//leetcode submit region end(Prohibit modification and deletion)
