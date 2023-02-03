package leetcode.editor.cn;

import java.util.HashMap;
import java.util.Map;

//leetcode submit region begin(Prohibit modification and deletion)
class Solution13 {
    public int romanToInt(String s) {
        Map<Character, Integer> map = new HashMap<Character, Integer>(16) {{
            put('I', 1);
            put('V', 5);
            put('X', 10);
            put('L', 50);
            put('C', 100);
            put('D', 500);
            put('M', 1000);
        }};

        int result = 0;
        int length = s.length() - 1;
        for (int i = 0; i < length; i++) {

            char left = s.charAt(i);
            char right = s.charAt(i + 1);
            Integer leftValue = map.get(left);
            if (leftValue < map.get(right)) {
                result -= leftValue;
            } else {
                result += leftValue;
            }

        }
        result += map.get(s.charAt(length));

        return result;
    }
}
//leetcode submit region end(Prohibit modification and deletion)
