package leetcode.editor.cn;

//leetcode submit region begin(Prohibit modification and deletion)
class SolutionJ04 {
    public boolean findNumberIn2DArray(int[][] matrix, int target) {

        // 横排二分找最接近的小于target的数
        int[] row = matrix[0];
        int left = 0, right = row.length - 1;

        while (left <= right) {
            int mid = left + (right - left) >> 1;
            if (row[mid] < target) {
                left = mid + 1;
            } else if (row[mid] > target) {
                right = mid - 1;
            } else {
                return true;
            }
        }
        if (left == 0 || right == row.length) {
            return false;
        }

        int up = 0, down = matrix.length - 1;
        while (up <= down) {
            int mid = up + (down - up) >> 1;
            if (row[mid] < target) {
                up = mid + 1;
            } else if (row[mid] > target) {
                down = mid - 1;
            } else {
                return true;
            }
        }
        return false;
    }

    public static void main(String[] args) {
//        Solution solution = new Solution();
//        solution.findNumberIn2DArray()
    }
}
//leetcode submit region end(Prohibit modification and deletion)
