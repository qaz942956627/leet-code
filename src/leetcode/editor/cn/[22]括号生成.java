package leetcode.editor.cn;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

class Solution {

    List<String> res;

    Integer leftCount = 0;
    Integer rightCount = 0;

    public List<String> generateParenthesis(int n) {
        if (n == 0) {
            return new ArrayList<>();
        }
        res = new LinkedList<>();
        StringBuilder track = new StringBuilder();
        backtrack(n, 0, track);
        return res;
    }

    /**
     * 回溯
     *
     * @param n     括号对数
     * @param i     当前放置的index
     * @param track 目前已经添加的左右括号    路径:已经作出的选择
     */
    void backtrack(int n, int i, StringBuilder track) {

        // 结束条件  剩下左括号的个数比有括号多 肯定不合法
        if (i == n << 1 && leftCount.equals(rightCount)) {
            res.add(track.toString());
            return;
        }

        // 选择列表 0代表( 1代表 )
        for (int j = 0; j < 2; j++) {

            // 合法括号[0->1]有右括号的个数不可能大于左括号个数
            if (rightCount > leftCount) {
                return;
            }
            // 合法括号左括号或者右括号的个数不可能括号对数
            if (rightCount > n || leftCount > n) {
                return;
            }

            // 做选择  0代表( 1代表 )
            if (j == 0) {
                track.append('(');
                leftCount++;

            } else {
                track.append(')');
                rightCount++;
            }
            // 穷举下一个位置
            backtrack(n, i + 1, track);
            // 撤销选择
            if (j == 0) {
                leftCount--;
            } else {
                rightCount--;
            }
            track.deleteCharAt(track.length() - 1);
        }
    }

    void backtrack1(int left, int right, StringBuilder track) {

        // 剩下左括号的个数比有括号多 肯定不合法
        if (left > right) {
            return;
        }
        // 数量小于 0 肯定是不合法的 left < 0 || right < 0
        if (left < 0) {
            return;
        }
        if (left == 0 && right == 0) {
            res.add(track.toString());
            return;
        }
        if (left > 0) {
            track.append('(');
            backtrack(left - 1, right, track);
            // System.out.println("----left----");
            // System.out.printf("left:%s,left:%s,删除前:%s.%n",left,right,track);
            track.deleteCharAt(track.length() - 1);
            // System.out.printf("left:%s,left:%s,删除后:%s.%n",left,right,track);
        }
        track.append(')');
        backtrack(left, right - 1, track);
        // System.out.println("----right----");
        // System.out.printf("left:%s,left:%s,删除前:%s.%n",left,right,track);
        track.deleteCharAt(track.length() - 1);
        // System.out.printf("left:%s,left:%s,删除后:%s.%n",left,right,track);
        // System.out.println("-------------------");

    }

    public static void main(String[] args) {
        Solution solution = new Solution();
        System.out.println(solution.generateParenthesis(3));
    }
}
// leetcode submit region end(Prohibit modification and deletion)
