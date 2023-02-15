package leetcode.editor.cn;

import java.util.HashMap;
import java.util.Map;

//leetcode submit region begin(Prohibit modification and deletion)
class Solution03 {
    public int findRepeatNumber(int[] nums) {

        Map<Integer, Integer> map = new HashMap<>();

        for (int i = 0; i < nums.length; i++) {
            int num = nums[i];
            Integer integer = map.get(num);
            if (integer != null) {
                return num;
            }
            map.put(num, 1);
        }
        return -1;

    }
}
//leetcode submit region end(Prohibit modification and deletion)
