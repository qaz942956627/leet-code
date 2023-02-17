package leetcode.editor.cn;

//leetcode submit region begin(Prohibit modification and deletion)
class SolutionJ10_1 {
    public int fib(int n) {

        if (n < 2) {
            return n;
        }

        int Q = 1000000007;

        int first = 0, second = 1;
        for (int i = 1; i < n; i++) {
            int dp_i = (first % Q + second % Q) % Q;
            int temp = second;
            second = dp_i;
            first = temp;

        }
        return second;
    }


}
//leetcode submit region end(Prohibit modification and deletion)
