package leetcode.editor.cn;

import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

//leetcode submit region begin(Prohibit modification and deletion)
class Solution350 {
    public int[] intersect(int[] nums1, int[] nums2) {
        if (nums1.length > nums2.length) {
            return intersect(nums2, nums1);
        }
        Map<Integer, Integer> map = new HashMap<Integer, Integer>();
        for (int num : nums1) {
            int count = map.getOrDefault(num, 0) + 1;
            map.put(num, count);
        }
        int[] intersection = new int[nums1.length];
        int index = 0;
        for (int num : nums2) {
            int count = map.getOrDefault(num, 0);
            if (count > 0) {
                intersection[index++] = num;
                count--;
                map.put(num, count);
                //if (count > 0) {
                //} else {
                //    map.remove(num);
                //}
            }
        }
        return Arrays.copyOfRange(intersection, 0, index);
    }

    //public static void main(String[] args) {
    //    Solution solution = new Solution();
    //    //[1,2,2,1]
    //    //[2,2]
    //    int[] a = new int[]{1, 2, 2, 1};
    //    int[] b = new int[]{2,2};
    //    solution.intersect(a, b);
    //}
}
//leetcode submit region end(Prohibit modification and deletion)
