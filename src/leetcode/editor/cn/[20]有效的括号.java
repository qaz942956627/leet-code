package leetcode.editor.cn;

import java.util.Deque;
import java.util.LinkedList;

//leetcode submit region begin(Prohibit modification and deletion)
class Solution {
    public boolean isValid(String s) {

        Deque<Character> stack = new LinkedList<>();
        for (char c : s.toCharArray()) {
            if (c==')') {

                if (stack.isEmpty()) {
                    return false;
                }
                Character left = stack.pop();
                if ('('!=left) {
                    return false;
                }

            } else if (c == ']') {
                if (stack.isEmpty()) {
                    return false;
                }
                Character left = stack.pop();
                if ('['!=left) {
                    return false;
                }

            } else if (c == '}') {
                if (stack.isEmpty()) {
                    return false;
                }
                Character left = stack.pop();
                if ('{'!=left) {
                    return false;
                }

            } else {
                stack.push(c);
            }
        }

        return stack.isEmpty();
    }
}
//leetcode submit region end(Prohibit modification and deletion)
