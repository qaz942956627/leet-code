package leetcode.editor.cn;

//leetcode submit region begin(Prohibit modification and deletion)
class SolutionJ53_2 {
    public int missingNumber(int[] nums) {
        int left = 0;
        int right = nums.length - 1;

        while (left <= right) {
            int mid = left + (right - left) / 2;

            if (nums[mid] == mid + 1) {
                right = mid - 1;
            } else if (nums[mid] == mid){
                left = mid + 1;
            }
        }
        return left;

    }


}
//leetcode submit region end(Prohibit modification and deletion)
