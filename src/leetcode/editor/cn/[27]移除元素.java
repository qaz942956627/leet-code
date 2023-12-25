package leetcode.editor.cn;

//leetcode submit region begin(Prohibit modification and deletion)
class Solution27 {
    public int removeElement(int[] nums, int val) {

        if (nums.length == 0) {
            return 0;
        }

        int slow = 0;
        int fast = 0;

        while (fast < nums.length) {
            if (nums[fast] != val) {
                nums[slow] = nums[fast];
                slow++;
            }
            fast++;
        }
        return slow;
    }
}
//leetcode submit region end(Prohibit modification and deletion)
