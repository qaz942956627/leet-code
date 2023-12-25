package leetcode.editor.cn;

import java.util.ArrayList;
import java.util.List;

//leetcode submit region begin(Prohibit modification and deletion)
class Solution057 {
    public int[][] findContinuousSequence(int target) {

        List<int[]> res = new ArrayList<>();

        int slow = 1, fast = 2;
        while (slow < target ) {
            int sum = slow;

            while (fast < target) {
                sum += fast;
                if (sum < target) {

                    fast++;
                } else if (sum == target) {
                    int[] ints = new int[fast - slow + 1];
                    int value = slow;
                    for (int i = 0; i < ints.length; i++) {
                        ints[i] = value;
                        value++;
                    }
                    res.add(ints);
                    break;
                } else {
                    break;
                }
            }
            slow++;
            fast = slow + 1;
        }
        return res.toArray(new int[res.size()][]);
    }
}
//leetcode submit region end(Prohibit modification and deletion)
