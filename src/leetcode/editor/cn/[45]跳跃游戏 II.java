package leetcode.editor.cn;

import java.util.Arrays;

//leetcode submit region begin(Prohibit modification and deletion)
class Solution45 {

    /**
     * 贪心
     *
     * @param nums nums
     * @return int
     */
    // public int jump(int[] nums) {
    //
    //     int index = 0;
    //     int res = 0;
    //     while (true) {
    //
    //
    //     }
    //
    //     return dp(nums, 0);
    // }


    int[] memo;

    /**
     * 动态规划
     *
     * @param nums nums
     * @return int
     */
    public int jump1(int[] nums) {

        int length = nums.length;
        memo = new int[length];
        // 不能初始化为Integer.MAX_VALUE  在nums[x] = 0的时候 下一次算子问题+1 会导致整形溢出
        Arrays.fill(memo, length);
        return dp(nums, 0);
    }

    /**
     * 定义：从索引 p 跳到最后一格，至少需要 dp(nums, p) 步
     *
     * @param nums nums
     * @param p    索引
     * @return int
     */
    int dp(int[] nums, int p) {

        // 当p超过最后一个不需要跳
        int length = nums.length;
        if (p >= length - 1) {
            return 0;
        }
        if (memo[p] < length) {
            return memo[p];
        }
        int step = nums[p];
        for (int i = 0; i < step; i++) {
            // 穷举每一个选择
            // 计算每一个子问题的结果
            int subProblem = dp(nums, p + i + 1);
            // 取其中最小的作为最终结果
            memo[p] = Math.min(memo[p], subProblem + 1);
            // memo[p] = Math.min(memo[p], dp(nums, p + i) + 1);
        }
        return memo[p];
    }

    public static void main(String[] args) {
        // Solution solution = new Solution();
        // System.out.println(solution.jump(new int[]{2,3,0,1,4}));
    }
}
//leetcode submit region end(Prohibit modification and deletion)
