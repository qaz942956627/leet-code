package leetcode.editor.cn;

//leetcode submit region begin(Prohibit modification and deletion)
class Solution509 {
    public int fib(int n) {
        if (n < 2) {
            return n;
        }
        int first = 0;
        int second = 1;
        int three = 0;
        for (int i = 2; i <= n; i++) {
            three = first + second;
            first = second;
            second = three;
        }
        return three;


    }

    public static void main(String[] args) {
        // System.out.println(new Solution().fib(5));
    }
}
//leetcode submit region end(Prohibit modification and deletion)
