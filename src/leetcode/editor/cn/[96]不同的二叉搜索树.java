package leetcode.editor.cn;

//leetcode submit region begin(Prohibit modification and deletion)
class Solution96 {

    int res = 0;

    public int numTrees(int n) {

        memo = new int[n + 1][n + 1];
        return count(1, n);
    }

    int[][] memo;

    int count(int lo, int hi) {
        if (lo >= hi) {
            return 1;
        }

        // 查备忘录
        if (memo[lo][hi] > 0) {
            return memo[lo][hi];
        }

        int res = 0;

        for (int mid = lo; mid <= hi; mid++) {
            int leftCount = count(lo, mid - 1);
            int rightCount = count(mid + 1, hi);
            res += leftCount * rightCount;
        }
        memo[lo][hi] = res;

        return res;
    }
}
//leetcode submit region end(Prohibit modification and deletion)
