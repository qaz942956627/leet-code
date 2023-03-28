package leetcode.editor.cn;

import java.util.Arrays;

// leetcode submit region begin(Prohibit modification and deletion)
class SolutionJ090 {

    public int rob(int[] nums) {

        int length = nums.length;
        int[] memoRob = new int[length - 1];
        Arrays.fill(memoRob, -1);
        int[] memoSkip = new int[length];
        Arrays.fill(memoSkip, -1);

        // 如果偷第一间
        int rob = nums[0] + dp(2, nums, memoRob);
        // 如果不偷第一间
        int skip = dp(1, nums, memoSkip);
        return Math.max(rob, skip);

    }

    int dp(int start, int[] nums, int[] memo) {
        // 如果已经超过允许的最后一间房了 不允许抢了
        if (start >= memo.length) {
            return 0;
        }

        if (memo[start] > -1) {
            return memo[start];
        }

        // 如果偷第一间
        int rob = nums[start] + dp(start + 2, nums, memo);
        // 如果不偷第一间
        int skip = dp(start + 1, nums, memo);
        int res = Math.max(rob, skip);
        memo[start] = res;
        return res;
    }

    public static void main(String[] args) {
        // Solution solution = new Solution();
        // System.out.println(solution.rob(new int[]{2, 3, 2}));
    }
}
// leetcode submit region end(Prohibit modification and deletion)
