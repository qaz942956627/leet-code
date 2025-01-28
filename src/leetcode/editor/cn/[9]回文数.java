package leetcode.editor.cn;

//leetcode submit region begin(Prohibit modification and deletion)
class Solution9 {
    public boolean isPalindrome(int x) {
        int temp = x;
        int res = 0;

        while (temp > 0) {
            int lastNum = temp % 10;
            temp = temp / 10;
            res = res * 10 + lastNum;
        }
        return res == x;
    }

}

//leetcode submit region end(Prohibit modification and deletion)
