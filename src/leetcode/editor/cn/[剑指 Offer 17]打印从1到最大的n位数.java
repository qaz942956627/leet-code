package leetcode.editor.cn;

//leetcode submit region begin(Prohibit modification and deletion)
class SolutionJ17 {
    public int[] printNumbers(int n) {
        int pow = (int) Math.pow(10, n);
        int[] res = new int[pow-1];
        for (int i = 1; i < pow; i++) {
            res[i-1] = i;
        }
        return res;

    }
}
//leetcode submit region end(Prohibit modification and deletion)
