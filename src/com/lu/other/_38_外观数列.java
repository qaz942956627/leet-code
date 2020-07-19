package com.lu.other;

import java.util.Deque;
import java.util.LinkedList;

public class _38_外观数列 {

    public String countAndSay(int n) {
        if (n == 1) {
            return "1";
        }
        String str = countAndSay(n - 1);
        StringBuilder sb = new StringBuilder();
        int length = str.length();
        int i = 0;
        //防止string越界
        while (i < length) {
            int j = i;
            //取出下标为j的元素然后第二个where循环会判断和tmp有多少个重复的
            char tmp = str.charAt(j);
            int count = 0;
            //第一次i==j所以每次至少条件成立一次然后相邻有一个重复的就+1
            while (i < length && str.charAt(i) == tmp) {
                count++;
                i++;
            }
            //最后把这个元素的出现个数和出现的元素放进stringBuilder中
            sb.append(count);
            sb.append(tmp);
        }
        return sb.toString();
    }
}
