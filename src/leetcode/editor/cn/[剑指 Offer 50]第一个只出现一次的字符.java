package leetcode.editor.cn;

import java.util.HashSet;
import java.util.Set;

//leetcode submit region begin(Prohibit modification and deletion)
class SolutionJ057 {
    public char firstUniqChar(String s) {

        int[] count = new int[26];


        char[] charArray = s.toCharArray();
        for (char c : charArray) {
            count[c - 'a']++;
        }
        // 重新遍历字符串找到第一个出现数量是1的字符
        for (char c : charArray) {
            if (count[c - 'a'] ==1) {
                return c;
            }
        }
        return ' ';

    }
}
//leetcode submit region end(Prohibit modification and deletion)
