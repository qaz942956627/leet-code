package leetcode.editor.cn;

import java.util.Arrays;

// leetcode submit region begin(Prohibit modification and deletion)
class Solution55 {


    /**
     * 改成动态规划求最远能跳多远 判断最远的距离是否>= nums.length-1
     *
     * @param nums nums
     * @return boolean
     */
    public boolean canJump(int[] nums) {
        int n = nums.length;
        int farthest = 0;
        for (int i = 0; i < n - 1; i++) {
            // 不断计算能跳到的最远距离  注意是下标加上能跳的距离等于当前能跳最远的距离 不是上一次条的最远距离
            farthest = Math.max(farthest, i + nums[i]);
            // 可能碰到了 0，卡住跳不动了
            if (farthest <= i) {
                return false;
            }
        }
        return farthest >= n - 1;
    }

    public boolean canJump1(int[] nums) {

        int length = nums.length;

        // 只有一个元素的时候不论是不是0都是直接达到目的地了
        if (length == 1 ) {
            return true;
        }

        for (int i = 1; i < length; i++) {

            boolean res = false;

            for (int j = 0; j < i; j++) {
                // 在i的位置之前有任何一个地方可以达到i就任务只一点是能够达到的
                if (nums[j] + j >= i) {
                    res = true;
                    break;
                }
            }

            // 路上有任何一处所有之前的点都不能达到的话 后边的必然不能达到
            if (!res) {
                return false;
            }
        }

        return true;

    }

    public static void main(String[] args) {
        // Solution solution = new Solution();
        // System.out.println(solution.canJump(new int[]{2, 0, 0}));
    }
}
// leetcode submit region end(Prohibit modification and deletion)
