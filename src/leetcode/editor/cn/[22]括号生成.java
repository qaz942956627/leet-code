package leetcode.editor.cn;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

//leetcode submit region begin(Prohibit modification and deletion)
class Solution {

    List<String> res;
    public List<String> generateParenthesis(int n) {
        if (n == 0) {
            return new ArrayList<>();
        }
        res = new LinkedList<>();
        StringBuilder track = new StringBuilder();
        backtrack(n, n, track);
        return res;
    }
    void backtrack(int left, int right, StringBuilder track) {

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
        if (left>0) {
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
//leetcode submit region end(Prohibit modification and deletion)
