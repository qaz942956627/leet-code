package leetcode.editor.cn;

//leetcode submit region begin(Prohibit modification and deletion)
class Solution9 {
    public boolean isPalindrome(int x) {
        String str = String.valueOf(x);
        int length1 = str.length();
        int length = str.length() / 2;
        for (int i = 0; i < length; i++) {
            if (str.charAt(i) != str.charAt(length1 - 1 - i)) {
                return false;
            }
        }
        return true;
    }

}

//leetcode submit region end(Prohibit modification and deletion)
