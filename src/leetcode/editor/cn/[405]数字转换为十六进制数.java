package leetcode.editor.cn;

import java.util.HashMap;
import java.util.Map;

//leetcode submit region begin(Prohibit modification and deletion)
class Solution405 {

    public String toHex(int num) {

        Map<Integer, String> map = new HashMap<Integer, String>() {{
            put(0, "0");
            put(1, "1");
            put(2, "2");
            put(3, "3");
            put(4, "4");
            put(5, "5");
            put(6, "6");
            put(7, "7");
            put(8, "8");
            put(9, "9");
            put(10, "a");
            put(11, "b");
            put(12, "c");
            put(13, "d");
            put(14, "e");
            put(15, "f");
        }};

        String number = "";

        int yushu = num % 16;


        return null;
    }
}
//leetcode submit region end(Prohibit modification and deletion)
