package leetcode.editor.cn;

//leetcode submit region begin(Prohibit modification and deletion)
class Solution28 {
    public int strStr(String haystack, String needle) {

        int res = -1;

        char first = needle.charAt(0);

        int length = haystack.length();
        for (int i = 0; i < length; i++) {
            char c = haystack.charAt(i);

            if (c == first) {
                if (needle.length() <= length - i) {
                    String substring = haystack.substring(i, i + needle.length());
                    if (substring.equals(needle)) {
                        return i;
                    }
                }
            }
        }

        return -1;

    }
}
//leetcode submit region end(Prohibit modification and deletion)
