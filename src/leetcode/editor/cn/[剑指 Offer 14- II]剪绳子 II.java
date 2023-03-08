package leetcode.editor.cn;

// leetcode submit region begin(Prohibit modification and deletion)
class SolutionJ14_2 {
    /**
     * 痴呆的数学题和动规没关系
     *
     * @param n n
     * @return int
     */
    public int cuttingRope(int n) {
        if (n < 4) {
            return n - 1;
        }
        long res = 1;
        while (n > 4) {
            res = res * 3 % 1000000007;
            n -= 3;
        }
        return (int) (res * n % 1000000007);
    }

}

// leetcode submit region end(Prohibit modification and deletion)
