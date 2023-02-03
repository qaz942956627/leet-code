package leetcode.editor.cn;

import java.util.ArrayList;
import java.util.List;

//leetcode submit region begin(Prohibit modification and deletion)
class Solution228 {
    public List<String> summaryRanges(int[] nums) {
        List<String> list = new ArrayList<>();

        int i = 0;

        int length = nums.length;

        while (i < length) {

            int start = i;

            while (i < length - 1 && nums[i] + 1 == nums[i + 1]) {
                i++;
            }

            if (start == i) {
                list.add(String.valueOf(nums[i]));
            } else {
                list.add(nums[start] + "->" + nums[i]);
            }
            i++;
        }


        return list;
    }

    //public static void main(String[] args) {
    //    Solution solution = new Solution();
    //    System.out.println(solution.summaryRanges(new int[]{0, 1, 2, 4, 5,7}));
    //
    //}
}
//leetcode submit region end(Prohibit modification and deletion)
