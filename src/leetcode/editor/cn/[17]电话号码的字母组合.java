package leetcode.editor.cn;

import java.util.*;

//leetcode submit region begin(Prohibit modification and deletion)
class Solution17 {
    String[] mapping = new String[]{
            "", "", "abc", "def", "ghi", "jkl", "mno", "pqrs", "tuv", "wxyz"
    };
    List<String> res = new LinkedList<>();
    public List<String> letterCombinations(String digits) {
        if (digits.isEmpty()) {
            return res;
        }
        // 从 digits[0] 开始进行回溯
        backtrack(digits,0,new StringBuilder());
        return res;
    }

    void backtrack(String digits, int start, StringBuilder sb) {

        if (digits.length() == sb.length()) {
            // 到达回溯树底部
            res.add(sb.toString());
            return;
        }

        // 回溯算法框架
        for (int i = start; i < digits.length(); i++) {

            // 按键索引
            int index = digits.charAt(i) - '0';
            // 选择列表是 对应数字键上的字母
            for (char c : mapping[index].toCharArray()) {
                // 做选择
                sb.append(c);
                // 递归下一层回溯树
                backtrack(digits, i + 1, sb);
                // 撤销选择
                sb.deleteCharAt(sb.length() - 1);
            }
        }
    }

//    public static void main(String[] args) {
//        Solution solution = new Solution();
//        solution.letterCombinations("23");
//    }
}
//leetcode submit region end(Prohibit modification and deletion)
