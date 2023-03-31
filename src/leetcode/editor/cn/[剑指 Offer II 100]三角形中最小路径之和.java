package leetcode.editor.cn;

import java.util.LinkedList;
import java.util.List;

//leetcode submit region begin(Prohibit modification and deletion)
class SolutionJ100 {



    public int minimumTotal(List<List<Integer>> triangle) {

        int size = triangle.size();

        // dp数组定义 dp[height][index] 是走到height行index位置的元素最小路径和
        int[][] dp = new int[size][size];

        // base case 第一行只有一个选择
        dp[0][0] = triangle.get(0).get(0);

        // 状态 选择左上角或者右上角

        for (int height = 1; height < size; height++) {
            List<Integer> integers = triangle.get(height);
            int rowSize = integers.size();
            for (int index = 0; index <= height; index++) {
                // 选择左上角
                int leftIndex = index - 1;
                int leftValue = Integer.MAX_VALUE;
                if (leftIndex>=0) {
                    leftValue = dp[height - 1][leftIndex];
                }
                // 选择右上角 右上角的索引就是index
                int rightValue = Integer.MAX_VALUE;
                if (index < height) {
                    rightValue = dp[height - 1][index];
                }
                dp[height][index] = Math.min(leftValue, rightValue) + integers.get(index);
            }
        }

        int res = Integer.MAX_VALUE;

        for (int i = 0; i < dp[size - 1].length; i++) {
            res = Math.min(res, dp[size - 1][i]);
        }
        return res;
    }

    public static void main(String[] args) {
        List<List<Integer>> lists = List.of(List.of(2), List.of(3, 4), List.of(6, 5, 7), List.of(4, 1, 8, 3));
//        Solution solution = new Solution();
//        System.out.println(solution.minimumTotal(lists));
    }

    /**
     * 回溯超时了
     */
    int res = Integer.MAX_VALUE;

    List<List<Integer>> triangle;
    public int minimumTotalBacktrack(List<List<Integer>> triangle) {

        this.triangle = triangle;

        LinkedList<Integer> result = new LinkedList<>();

        backtrack(result,0);

        return res;

    }

    void backtrack(LinkedList<Integer> result,int selectIndex) {

        int currHeight = result.size();
        if (currHeight ==triangle.size()) {
            res = Math.min(result.stream().reduce(0, Integer::sum), res);
            return;
        }

        List<Integer> integers = triangle.get(currHeight);

        // 选择了左边
        Integer left = integers.get(selectIndex);
        result.add(left);
        backtrack(result, selectIndex);
        // 撤销选择
        result.removeLast();

        if (selectIndex + 1 < integers.size()) {
            // 选择了右边
            Integer right = integers.get(selectIndex + 1);
            result.add(right);
            backtrack(result, selectIndex + 1);
            // 撤销选择
            result.removeLast();
        }
    }


}
//leetcode submit region end(Prohibit modification and deletion)
