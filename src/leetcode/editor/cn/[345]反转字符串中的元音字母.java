package leetcode.editor.cn;

import java.util.HashSet;
import java.util.Set;

//leetcode submit region begin(Prohibit modification and deletion)
class Solution345 {

    public String reverseVowels(String s) {
        if (s.length()<2) {
            return s;
        }

        Set<Character> set = new HashSet<Character>() {{
            add('a');
            add('e');
            add('i');
            add('o');
            add('u');
            add('A');
            add('E');
            add('I');
            add('O');
            add('U');
        }};
        char[] chars = s.toCharArray();
        int left = 0;
        int length = s.length();
        int mid = length >> 1;
        int right = length - 1;

        while (left < right) {
            while (left <= mid && !set.contains(chars[left])) {
                left++;
            }
            while (right >= mid && !set.contains(chars[right])) {
                right--;
            }
            if (left < right) {

                swap(chars, left, right);
                left++;
                right--;
            }

        }

        return new String(chars);
    }

    //public static void main(String[] args) {
    //    Solution solution = new Solution();
    //    System.out.println(solution.reverseVowels("a."));
    //}

    public String reverseVowels1(String s) {

        Set<Character> set = new HashSet<Character>() {{
            add('a');
            add('e');
            add('i');
            add('o');
            add('u');
            add('A');
            add('E');
            add('I');
            add('O');
            add('U');
        }};
        char[] chars = s.toCharArray();
        int left = 0;
        int right = s.length() - 1;

        boolean leftFlag = false, rightFlag = false;

        while (left < right) {

            if (leftFlag||set.contains(chars[left])) {
                leftFlag = true;
                if (rightFlag) {
                    swap(chars, left, right);
                    left++;
                    right--;
                    leftFlag = false;
                    rightFlag = false;
                    continue;
                }

            } else {
                left++;

            }
            if (rightFlag||set.contains(chars[right])) {
                rightFlag = true;
                if (leftFlag) {
                    swap(chars, left, right);
                    left++;
                    right--;
                    leftFlag = false;
                    rightFlag = false;
                }
            } else {
                right--;
            }

        }

        return new String(chars);
    }

    public void swap(char[] chars, int left, int right) {
        char temp = chars[left];
        chars[left] = chars[right];
        chars[right] = temp;
    }
}
//leetcode submit region end(Prohibit modification and deletion)
