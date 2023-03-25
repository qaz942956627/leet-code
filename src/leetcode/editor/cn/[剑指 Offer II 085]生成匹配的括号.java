package leetcode.editor.cn;

import java.util.ArrayList;
import java.util.List;

//leetcode submit region begin(Prohibit modification and deletion)
class SolutionJ085 {
    public List<String> generateParenthesis(int n) {
        List<String> res = new ArrayList<>();
        backtrack(n, n, new StringBuilder(), res);
        return res;
    }

    /**
     * 回溯
     *
     * @param left  剩余左括号数量
     * @param right 剩余右括号数量
     * @param str   当前拼接括号
     * @param res   结果
     */
    void backtrack(int left, int right, StringBuilder str, List<String> res) {
        if (right < left) {
            // 剩余右括号一定大于等于剩余左括号
            return;
        }
        if (left < 0 || right < 0) {
            // 任何一方剩余数量小于0都不合法
            return;
        }
        if (left == 0 && right == 0) {
            res.add(str.toString());
        }

        str.append("(");
        backtrack(left - 1, right, str, res);
        // 撤销选择
        str.deleteCharAt(str.length() - 1);
        str.append(")");
        backtrack(left, right - 1, str, res);
        str.deleteCharAt(str.length() - 1);

    }

}
//leetcode submit region end(Prohibit modification and deletion)
