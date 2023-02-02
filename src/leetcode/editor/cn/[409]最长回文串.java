package leetcode.editor.cn;

import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;

//leetcode submit region begin(Prohibit modification and deletion)
class Solution409 {
    public int longestPalindrome(String s) {
        int[] count = new int[128];
        int length = s.length();
        for (int i = 0; i < length; ++i) {
            char c = s.charAt(i);
            count[c]++;
        }

        int ans = 0;
        for (int v: count) {
            ans += v / 2 * 2;
            if (v % 2 == 1 && ans % 2 == 0) {
                ans++;
            }
        }
        return ans;
    }


    public int longestPalindrome2(String s) {
        int count = 0;

        Map<Character, Integer> map = new HashMap<>();

        int length = s.length();
        for (int i = 0; i < length; i++) {
            char c = s.charAt(i);
            if (map.containsKey(c)) {
                map.put(c, map.get(c)+1);
            } else {
                map.put(c, 1);
            }
        }
        int mid = 0;
        for (Integer value : map.values()) {
            if (value == 1) {
                mid = 1;
            } else {
                if (value % 2 == 0) {
                    count += value;
                } else {
                    mid = 1;
                    count = count + value - 1;
                }
            }
        }


        return count + mid;
    }

    public int longestPalindrome1(String s) {
        int count = 0;

        Set<Character> set = new HashSet<>();

        int length = s.length();
        for (int i = 0; i < length; i++) {
            char c = s.charAt(i);
            if (set.contains(c)) {
                set.remove(c);
                count = count + 2;
            } else {
                set.add(c);
            }

        }
        if (set.isEmpty()) {
            return count;
        }

        return count + 1;
    }

    public static void main(String[] args) {
        System.out.println(Integer.valueOf('A'));
        System.out.println(Integer.valueOf('a'));
        System.out.println(Integer.valueOf('Z'));
        System.out.println(Integer.valueOf('z'));
    }
}
//leetcode submit region end(Prohibit modification and deletion)
