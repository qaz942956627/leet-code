package leetcode.editor.cn;

import java.util.HashMap;
import java.util.Map;

//leetcode submit region begin(Prohibit modification and deletion)
class SolutionJ57 {
    /**
     * 左右指针
     *
     * @param nums   全国矿工工会
     * @param target 目标
     * @return {@link int[]}
     */
    public int[] twoSum(int[] nums, int target) {
        int left = 0, right = nums.length - 1;

        while (left < right) {
            int sum = nums[left] + nums[right];
            if (sum>target) {
                right = right - 1;
            } else if (sum < target) {
                left = left + 1;
            } else {
                return new int[]{nums[left], nums[right]};
            }
        }
        return null;
    }

    public int[] twoSumBinarySearch(int[] nums, int target) {


        for (int num : nums) {
            int i = target - num;

            int resIndex = binarySearch(nums, i);
            if (resIndex != -1) {
                return new int[]{num, nums[resIndex]};
            }
        }
        return null;

    }

    int binarySearch(int[] nums, int target) {
        int left = 0, right = nums.length - 1;
        while(left <= right) {
            int mid = left + (right - left) / 2;
            if (nums[mid] < target) {
                left = mid + 1;
            } else if (nums[mid] > target) {
                right = mid - 1;
            } else if(nums[mid] == target) {
                // 直接返回
                return mid;
            }
        }
        // 直接返回
        return -1;
    }
    public static void main(String[] args) {
//        Solution solution = new Solution();
//        solution.twoSum(new int[]{2, 7, 11, 15}, 9);
    }

    public int[] twoSumMap(int[] nums, int target) {

        Map<Integer, Integer> map = new HashMap<>();

        for (int num : nums) {
            int i = target - num;
            Integer res = map.get(num);
            if (res != null) {
                return new int[]{num, res};
            }
            map.put(i, num);
        }
        return null;

    }




}
//leetcode submit region end(Prohibit modification and deletion)
