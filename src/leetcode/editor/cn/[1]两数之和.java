package leetcode.editor.cn;

import java.util.*;

//leetcode submit region begin(Prohibit modification and deletion)
class Solution {
    public int[] twoSum(int[] nums, int target) {

        int length = nums.length;

        int[][] ints = new int[length][2];
        for (int i = 0; i < length; i++) {
            ints[i][0] = nums[i];
            ints[i][1] = i;
        }
        Arrays.sort(ints,Comparator.comparing((a)->a[0]));

        int start = 0, end = length - 1;

        while (end > start) {
            int sum = ints[start][0] + ints[end][0];

            if (sum<target) {
                start++;
            } else if (sum > target) {
                end--;
            } else {
                return new int[]{ints[start][1], ints[end][1]};
            }

        }

        return null;
    }


    public static void main(String[] args) {
         new Solution().twoSum(new int[]{2, 7, 11, 15}, 9);
    }
}
//leetcode submit region end(Prohibit modification and deletion)
