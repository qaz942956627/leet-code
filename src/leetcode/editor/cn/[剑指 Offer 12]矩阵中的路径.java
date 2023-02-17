package leetcode.editor.cn;

import com.alibaba.fastjson.JSONObject;
import com.alibaba.fastjson.TypeReference;

import java.util.Arrays;
import java.util.List;

//leetcode submit region begin(Prohibit modification and deletion)
class SolutionJ12 {
    public boolean exist(char[][] board, String word) {

        char[] wordArray = word.toCharArray();
        int height = board.length;
        int width = board[0].length;
        boolean[][] visited = new boolean[height][width];

        for (int h = 0; h < height; h++) {
            for (int w = 0; w < width; w++) {
                boolean res = check(board, wordArray, visited, h, w, 0);
                if (res) {
                    return true;
                }
            }
        }
        return false;

    }

    boolean check(char[][] board, char[] wordArray, boolean[][] visited, int height, int width, int index) {
        // 已经被访问过的 剪枝
        if (visited[height][width]) {
            return false;
        }
        if (board[height][width] != wordArray[index]) {
            return false;
        }
        if (index == wordArray.length - 1) {
            return true;
        }


        visited[height][width] = true;

        int h = board.length - 1;

        int w = board[0].length - 1;

        if (height < h) {
            boolean res = check(board, wordArray, visited, height + 1, width, index + 1);
            if (res) {
                return true;
            }
        }

        if (height > 0) {
            boolean res = check(board, wordArray, visited, height - 1, width, index + 1);
            if (res) {
                return true;
            }
        }

        if (width < w) {
            boolean res = check(board, wordArray, visited, height, width + 1, index + 1);
            if (res) {
                return true;
            }
        }

        if (width > 0) {
            boolean res = check(board, wordArray, visited, height, width - 1, index + 1);
            if (res) {
                return true;
            }
        }

        // 撤销选择 访问标识修改回false
        visited[height][width] = false;

        return false;
    }

    public static void main(String[] args) {


        int[][] strings = JSONObject.parseObject("""
                        [[1,4,7,11,15],[2,5,8,12,19],[3,6,9,16,22],[10,13,14,17,24],[18,21,23,26,30]]
                        """,
                new TypeReference<>() {
                });
//        System.out.println(Arrays.deepToString(strings));
//
//        Solution solution = new Solution();
//        System.out.println(solution.exist(strings, "AAB"));


    }
}
//leetcode submit region end(Prohibit modification and deletion)
