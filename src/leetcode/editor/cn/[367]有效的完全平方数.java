package leetcode.editor.cn;

//leetcode submit region begin(Prohibit modification and deletion)
class Solution367 {
    public boolean isPerfectSquare(int num) {

        int left = 1, right = (num >> 1) + 1;

        while (left <= right) {
            int mid = left + ((right - left) >> 1);
            long square = (long) mid * mid;
            if (square < num) {
                left = mid + 1;
            } else if (square > num) {
                right = mid - 1;
            } else {
                return true;
            }
        }

        return false;
    }

    //public static void main(String[] args) {
    //    Solution solution = new Solution();
    //    solution.isPerfectSquare(808201);
    //}
}
//leetcode submit region end(Prohibit modification and deletion)
