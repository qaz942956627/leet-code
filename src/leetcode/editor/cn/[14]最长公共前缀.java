package leetcode.editor.cn;

//leetcode submit region begin(Prohibit modification and deletion)
class Solution14 {
    public String longestCommonPrefix(String[] strs) {

        int i = 0;
        while (true) {
            Character temp = null;
            for (String str : strs) {
                int length = str.length();
                if (length == 0 || length == i) {
                    return str;
                }

                if (temp == null) {
                    temp = str.charAt(i);
                } else {
                    if (temp!=str.charAt(i)) {
                        return str.substring(0, i);
                    }
                }
            }
            i++;
        }
    }


}
//leetcode submit region end(Prohibit modification and deletion)
