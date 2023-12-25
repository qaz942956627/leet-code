package leetcode.editor.cn;

import java.util.Arrays;
import java.util.List;

//leetcode submit region begin(Prohibit modification and deletion)
class SolutionJ29 {
    public int[] spiralOrder(int[][] matrix) {

        int m = matrix.length;
        if (m == 0) {
            return new int[]{};
        }
        int n = matrix[0].length;
        int upper_bound = 0, lower_bound = m - 1;
        int left_bound = 0, right_bound = n - 1;

        int size = m * n;
        int[] res = new int[size];
        int index = 0;
        while (index < size) {

            // 从0,0开始按照 右>下>左>上 循环

            if (upper_bound <= lower_bound) {
                // 在顶部从左向右遍历
                for (int j = left_bound; j <= right_bound; j++) {
                    res[index] = matrix[upper_bound][j];
                    index++;
                }
                // 上边界下移
                upper_bound++;
            }

            if (left_bound <= right_bound) {
                // 在右侧从上向下遍历
                for (int i = upper_bound; i <= lower_bound; i++) {
                    res[index] = matrix[i][right_bound];
                    index++;
                }
                // 右边界左移
                right_bound--;
            }

            if (upper_bound <= lower_bound) {
                // 在底部从右向左遍历
                for (int j = right_bound; j >= left_bound; j--) {
                    res[index] = matrix[lower_bound][j];
                    index++;
                }
                // 下边界上移
                lower_bound--;
            }

            if (left_bound <= right_bound) {
                // 在左侧从下向上遍历
                for (int i = lower_bound; i >= upper_bound; i--) {
                    res[index] = matrix[i][left_bound];
                    index++;
                }
                // 左边界右移
                left_bound++;
            }
        }
        return res;
    }

    public static void main(String[] args) {
        String str = "[[1,2,3,4],[5,6,7,8],[9,10,11,12]]";

        // 去掉字符串中的空格和方括号
        String[] strs = str.replaceAll("\\s+", "")
                .replaceAll("\\[\\[", "")
                .replaceAll("]\\]", "")
                .split("],\\[");

        // 将字符串数组转换为二维数组
        int[][] arr = new int[strs.length][];
        for (int i = 0; i < strs.length; i++) {
            String[] nums = strs[i].split(",");
            arr[i] = new int[nums.length];
            for (int j = 0; j < nums.length; j++) {
                arr[i][j] = Integer.parseInt(nums[j]);
            }
        }

//        Solution solution = new Solution();
//        solution.spiralOrder(new int[][]{});


    }

}
//leetcode submit region end(Prohibit modification and deletion)
