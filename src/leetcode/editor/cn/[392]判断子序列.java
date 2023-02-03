package leetcode.editor.cn;

import java.util.HashMap;
import java.util.Map;

//leetcode submit region begin(Prohibit modification and deletion)
class Solution392 {
    public boolean isSubsequence(String s, String t) {
        int sLength = s.length();
        int tLength = t.length();
        if (sLength == 0) {
            return true;
        }
        if (tLength == 0) {
            return false;
        }
        int i = 0, j = 0;
        while (i < sLength && j < tLength) {
            char c = s.charAt(i);
            char c1 = t.charAt(j);
            if (c == c1) {
                i++;
                j++;
                if (i == sLength) {
                    return true;
                }
            } else {
                j++;
            }
        }

        return false;
    }

    public static void main(String[] args) {
        // System.out.println(new Solution().isSubsequence("bcd", "uuubcd"));
    }
}
//leetcode submit region end(Prohibit modification and deletion)
