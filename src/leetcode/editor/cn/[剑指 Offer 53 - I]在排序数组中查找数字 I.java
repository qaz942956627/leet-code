package leetcode.editor.cn;

//leetcode submit region begin(Prohibit modification and deletion)
class SolutionJ53 {
    public int search(int[] nums, int target) {

        int left = 0;

        int right = nums.length - 1;
        int res = 0;


        while (left <= right) {

            int mid = left + (right - left) / 2;

            if (nums[mid]< target) {
                left = mid + 1;
            } else if (nums[mid] > target) {
                right = mid - 1;
            } else {
                res++;
                int rightIndex = mid + 1;
                while (rightIndex <= right && nums[rightIndex] == target) {
                    res++;
                    rightIndex++;
                }

                int leftIndex = mid - 1;
                while (leftIndex >= 0 && nums[leftIndex] == target) {
                    res++;
                    leftIndex--;
                }
                break;
            }
        }


        return res;

    }

    public static void main(String[] args) {
//        Solution solution = new Solution();
//        solution.search(new int[]{5, 7, 7, 8, 8, 10}, 8);
    }
}
//leetcode submit region end(Prohibit modification and deletion)
