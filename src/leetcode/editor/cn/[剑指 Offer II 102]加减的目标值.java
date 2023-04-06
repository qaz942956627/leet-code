package leetcode.editor.cn;

import java.util.HashMap;
import java.util.LinkedList;

//leetcode submit region begin(Prohibit modification and deletion)
class SolutionJ102 {


    public int findTargetSumWays(int[] nums, int target) {
        if (nums.length == 0) {
            return 0;
        }
        return dp(nums, 0, target);
    }

    /**
     * 备忘录
     */
    HashMap<String, Integer> memo = new HashMap<>();

    int dp(int[] nums, int i, int remain) {
        // base case
        if (i == nums.length) {
            if (remain == 0) {
                return 1;
            }
            return 0;
        }
        // 把它俩转成字符串才能作为哈希表的键
        String key = i + "," + remain;
        // 避免重复计算
        if (memo.containsKey(key)) {
            return memo.get(key);
        }
        // 还是穷举
        int result = dp(nums, i + 1, remain - nums[i]) + dp(nums, i + 1, remain + nums[i]);
        // 记入备忘录
        memo.put(key, result);
        return result;
    }

    public static void main(String[] args) {
//        Solution solution = new Solution();
//        solution.findTargetSumWays(new int[]{1, 1, 1, 1, 1}, 3);
    }





    int[] nums;

    int target;

    int res;

    /**
     * 回溯方法超时
     *
     * @param nums   全国矿工工会
     * @param target 目标
     * @return int
     */
    public int findTargetSumWaysBacktrack(int[] nums, int target) {
        this.nums = nums;
        this.target = target;

        LinkedList<Integer> result = new LinkedList<>();

        backtrack(result, 0);

        return res;


    }


    void backtrack(LinkedList<Integer> result,int selectIndex) {
        if (result.size()==nums.length) {
            if (result.stream().reduce(0,Integer::sum)==target) {
                res++;
            }
            return;
        }

        // 选择+
        result.add(nums[selectIndex]);
        backtrack(result, selectIndex + 1);
        result.removeLast();

        // 选择-
        result.add(nums[selectIndex] * -1);
        backtrack(result, selectIndex + 1);
        result.removeLast();

    }


}
//leetcode submit region end(Prohibit modification and deletion)
