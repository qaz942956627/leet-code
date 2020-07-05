package com.lu.string;

import java.util.HashMap;
import java.util.Map;

public class _3_无重复字符的最长子串 {

    //"abba"
    public int lengthOfLongestSubstring(String s) {
        char[] chars = s.toCharArray();
        Map<Character, Integer> map = new HashMap<>();
        int max = 0;
        int left = 0;
        for (int i = 0; i < chars.length; i++) {
            if (map.containsKey(chars[i])) {
                left= Math.max(map.get(chars[i])+1,left);
            max =  Math.max(i - left+1, max) ;
            }
            map.put(chars[i], i);
        }
        return Math.max(chars.length - left+1, max);
    }

    public int lengthOfLongestSubstring1(String s) {
        char[] chars = s.toCharArray();
        HashMap<Character, Integer> map = new HashMap<>();
        int max = 0;
        int left = 0;
        for(int i = 0; i < chars.length; i ++){
            if(map.containsKey(chars[i])){
                left = Math.max(left,map.get(chars[i]) + 1);
            }
            map.put(chars[i],i);
            max = Math.max(max,i-left+1);
        }
        return max;

    }

}
