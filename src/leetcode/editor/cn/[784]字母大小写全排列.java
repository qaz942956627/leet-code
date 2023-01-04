package leetcode.editor.cn;

import java.util.ArrayList;
import java.util.List;

// leetcode submit region begin(Prohibit modification and deletion)
class Solution784 {

    public static void main(String[] args) {
        Solution784 solution = new Solution784();
        List<String> stringList = solution.letterCasePermutation("A1b2");
        // List<String> stringList = solution.letterCasePermutation("3z4");
        System.out.println(stringList);

        // char a = 'a';
        // int i = a ^ 32;
        // System.out.println(Integer.toBinaryString(i));
        // char A = 'A';
        // int j = A ^ 32;
        // System.out.println(Integer.toBinaryString(j));
        // System.out.println(Integer.toBinaryString(32));
        // for (int k = 'a'; k <= 'z'; k++) {
        //     System.out.println(Character.toChars(k));
        //     System.out.println(Integer.toBinaryString(k));
        //     System.out.println(Integer.toBinaryString(k^ 32));
        //     System.out.println("0100000");
        //     System.out.println();
        // }

    }

    // public List<String> letterCasePermutation(String s) {
    //     List<String> result = new ArrayList<>();
    //     // 先插入原字符串
    //
    //     char[] chars = s.toCharArray();
    //     result.add(new String(chars));
    //     extracted(0, result, chars);
    //     return result;
    //
    // }

    private static void extracted(int index, List<String> result, char[] chars) {
        int length = chars.length;
        if (index == length) {
            result.add(new String(chars));
        }
        for (int j = index; j < length; j++) {

            char aChar = chars[j];
            String s1 = String.valueOf(aChar);
            if (s1.matches("[a-z]")) {
                chars[j] = s1.toUpperCase().charAt(0);
                extracted(index + 1, result, chars);

            } else if (s1.matches("[A-Z]")) {
                chars[j] = s1.toLowerCase().charAt(0);
                extracted(index + 1, result, chars);
            }
        }
    }

    public List<String> letterCasePermutation(String s) {
        List<String> ans = new ArrayList<String>();
        dfs(s.toCharArray(), 0, ans);
        return ans;
    }

    public void dfs(char[] chars, int pos, List<String> ans) {
        while (pos < chars.length && Character.isDigit(chars[pos])) {
            pos++;
        }
        if (pos == chars.length) {
            ans.add(new String(chars));
            return;
        }
        // a的二进制  1100001
        // A的二进制  1000001
        // 32的二进制 0100000
        // 所有字母的二进制只有第七位是不同的

        chars[pos] ^= 32;
        dfs(chars, pos + 1, ans);
        chars[pos] ^= 32;
        dfs(chars, pos + 1, ans);
    }

}
// leetcode submit region end(Prohibit modification and deletion)
