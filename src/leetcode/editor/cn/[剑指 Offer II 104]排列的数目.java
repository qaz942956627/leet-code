package leetcode.editor.cn;

//leetcode submit region begin(Prohibit modification and deletion)
class SolutionJ104 {

    public int combinationSum4(int[] nums, int target) {

        // dp数组定义: target为数组下标的时候 选择nums的所有排列组合
        int[] dp = new int[target + 1];

        // base case 当target为0的时候只有一种任何元素不选的解法
        dp[0] = 1;

        // 状态 只有target在变化
        for (int i = 1; i <= target; i++) {
            // 选择 每个元素
            for (int num : nums) {
                // 如果目标数值小于当前元素的值 条件不合法直接跳过
                // i == num 的时候? 表示i只够选择一个num的情况
                if (i < num) {
                    continue;
                }
                // dp[i] = 每个dp[i - num] 的和
                dp[i] += dp[i - num];
            }
        }
        return dp[target];

    }

    public static void main(String[] args) {
//        Solution solution = new Solution();
//        solution.combinationSum4(new int[]{1, 2, 3}, 7);
    }


}
//leetcode submit region end(Prohibit modification and deletion)
