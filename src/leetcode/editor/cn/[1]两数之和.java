package leetcode.editor.cn;

import java.util.*;

//leetcode submit region begin(Prohibit modification and deletion)
class Solution1 {
    public int[] twoSum(int[] nums, int target) {

        int length = nums.length;
        int[][] src = new int[length][2];
        for (int i = 0; i < nums.length; i++) {
            src[i][0] = nums[i];
            src[i][1] = i;
        }
        Arrays.sort(src, Comparator.comparingInt(a -> a[0]));
        int start = 0, end = length - 1;

        while (start < end) {
            int sum = src[start][0] + src[end][0];
            if (sum > target) {
                end--;
            } else if (sum < target) {
                start++;
            } else {
                return new int[]{src[start][1], src[end][1]};
            }
        }

        return null;
    }
    public int[] twoSum1(int[] nums, int target) {

        int[] res = new int[2];
        Map<Integer, Integer> map = new HashMap<>();

        int length = nums.length;
        for (int i = 0; i < length; i++) {
            int num = nums[i];
            if (map.containsKey(num)) {
                return new int[]{i, map.get(num)};
            }
            map.put(target - num, i);
        }
        return res;
    }

    public static void main(String[] args) {
        // new Solution().twoSum(new int[]{2, 7, 11, 15}, 9);
    }
}
//leetcode submit region end(Prohibit modification and deletion)
