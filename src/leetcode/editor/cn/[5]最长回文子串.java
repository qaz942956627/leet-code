package leetcode.editor.cn;

//leetcode submit region begin(Prohibit modification and deletion)
class Solution5 {
    public String longestPalindrome(String s) {

        String res = "";

        int length = s.length();
        for (int i = 0; i < length; i++) {
            // 以i为中心的回文长度
            String palindrome = longestPalindrome(s, i, i);
            if (palindrome.length() > res.length()) {
                res = palindrome;
            }
            // 以i,i+1为中心的回文长度
            String palindrome1 = longestPalindrome(s, i, i + 1);
            if (palindrome1.length() > res.length()) {
                res = palindrome1;
            }
        }
        return res;
    }

    private String longestPalindrome(String s, int left, int right) {
        int length = s.length();
        while (left >= 0 && right < length &&
                s.charAt(left) == s.charAt(right)) {
            left--;
            right++;
        }
        return s.substring(left+1, right);

    }

    public static void main(String[] args) {
        // Solution solution = new Solution();
        // System.out.println(solution.longestPalindrome("cbbd"));
    }
}
//leetcode submit region end(Prohibit modification and deletion)
