package leetcode.editor.cn;

//leetcode submit region begin(Prohibit modification and deletion)
class Solution283 {
    public void moveZeroes(int[] nums) {
        int length = nums.length;

        int slow , fast;
        slow = fast = 0;
        for (int i = 0; i < length; i++) {
            if (nums[fast]!=0) {
                nums[slow] = nums[fast];
                slow++;
            }
            fast++;
        }

        for (int i = slow; i < length; i++) {
            nums[i] = 0;
        }

    }

}
//leetcode submit region end(Prohibit modification and deletion)
