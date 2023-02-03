package leetcode.editor.cn;

import java.util.*;

//leetcode submit region begin(Prohibit modification and deletion)
class Solution15 {
    public List<List<Integer>> threeSum(int[] nums) {

        int length = nums.length;
        int[][] src = new int[length][2];
        for (int i = 0; i < nums.length; i++) {
            src[i][0] = nums[i];
            src[i][1] = i;
        }
        Arrays.sort(src, Comparator.comparingInt(a -> a[0]));
        return threeSum(src, 0);
    }

    private List<List<Integer>> threeSum(int[][] nums, int target) {
        List<List<Integer>> res = new LinkedList<>();
        for (int i = 0; i < nums.length - 2; i++) {
            int start = nums[i][0];
            List<List<Integer>> lists = twoSum(nums, i + 1, target - start);
            for (List<Integer> list : lists) {
                if (start + list.get(0) + list.get(1) == target) {
                    list.add(start);

                    res.add(list);
                }
            }
            while (i<nums.length -1&&start == nums[i + 1][0]) {
                i++;
            }

        }

        return res;
    }

    public List<List<Integer>> twoSum(int[][] src, int start,int target) {

        int length = src.length;

        int end = length - 1;

        List<List<Integer>> res = new ArrayList<>();

        while (start < end) {
            int startInt = src[start][0];
            int endInt = src[end][0];
            int sum = startInt + endInt;
            if (sum > target) {
                end--;
                while (end>start&&endInt == src[end][0]) {
                    end--;
                }
            } else if (sum < target) {
                start++;
                while (end>start&&startInt == src[start][0]) {
                    start++;
                }
            } else {
                List<Integer> one = new ArrayList<>(2);
                one.add(startInt);
                one.add(endInt);

                res.add(one);
                start++;
                while (end>start&&startInt == src[start][0]) {
                    start++;
                }
                end--;
                while (end>start&&endInt == src[end][0]) {
                    end--;
                }
            }
        }

        return res;
    }

    public static void main(String[] args) {
        // List<List<Integer>> lists = new Solution().threeSum(new int[]{-1, 0, 1, 2, -1, -4});
        // System.out.println(lists);
    }
}
//leetcode submit region end(Prohibit modification and deletion)
