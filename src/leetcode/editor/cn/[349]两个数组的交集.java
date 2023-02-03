package leetcode.editor.cn;

import java.util.HashSet;
import java.util.Set;

//leetcode submit region begin(Prohibit modification and deletion)
class Solution349 {
    public int[] intersection(int[] nums1, int[] nums2) {

        Set<Integer> set = new HashSet<>();

        for (int i : nums1) {
            set.add(i);
        }
        Set<Integer> result = new HashSet<>();

        for (int i : nums2) {
            if (set.contains(i)) {
                result.add(i);
            }
        }
        int[] ints = new int[result.size()];

        int index = 0;
        for (Integer integer : result) {
            ints[index] = integer;
            index++;
        }
        return ints;
    }
}
//leetcode submit region end(Prohibit modification and deletion)
