package leetcode.editor.cn;


import java.util.Arrays;

//leetcode submit region begin(Prohibit modification and deletion)
class SolutionJ089 {

    int[] memo;
    public int rob(int[] nums) {
        // memo = new int[nums.length];
        // Arrays.fill(memo, -1);
        // return dp(0, nums);

        int length = nums.length;
        int[] dp = new int[length + 2];
        for (int i = length - 1; i >= 0; i--) {
            // 当前这一间不抢
            int skip = dp[i + 1];
            // 当前值一间要抢 那么i+1必然不能抢
            int rob = nums[i] + dp[i + 2];
            dp[i] = Math.max(skip, rob);
        }

        return dp[0];
    }

    /**
     * 从startIndex开始抢,抢到最后获得最大的金额
     *
     * @param startIndex 开始指数
     * @param nums       全国矿工工会
     * @return int
     */
    int dp(int startIndex, int[] nums) {
        int length = nums.length;
        if (startIndex>=length) {
            return 0;
        }
        if (memo[startIndex] >= 0) {
            return memo[startIndex];
        }
        // 要么当前这个不抢
        int skip = dp(startIndex + 1, nums);
        // 要么这个就抢
        int rob = nums[startIndex] + dp(startIndex + 2, nums);
        int res = Math.max(skip, rob);

        memo[startIndex] = res;
        return res;
    }
}
//leetcode submit region end(Prohibit modification and deletion)
