package com.lu.number;

import java.util.HashMap;

public class _13_罗马数字转整数 {

    public int romanToInt(String s) {
        //"MCMXCIV"
        HashMap<Character, Integer> map = new HashMap<>();
        map.put('I', 1);
        map.put('V', 5);
        map.put('X', 10);
        map.put('L', 50);
        map.put('C', 100);
        map.put('D', 500);
        map.put('M', 1000);

        int num = 0;
        int length = s.length() - 1;
        for (int i = 0; i < length; i++) {
            char left = s.charAt(i);
            char right = s.charAt(i + 1);
            //相邻的两个数左边比右边小则减去左边的值 左边大于等于右边则加上左边的值
            Integer leftValue = map.get(left);
            if (leftValue < map.get(right)) {
                num -= leftValue;
            } else {
                num += leftValue;
            }
        }
        num += map.get(s.charAt(length));
        return num;
    }

}
