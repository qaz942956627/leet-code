package com.lu.string;

public class _58_最后一个单词的长度 {

    public int lengthOfLastWord(String s) {
        int curr = 0;

        boolean flg = true;
        for (int i = s.length() - 1; i >= 0; i--) {
            if (flg) {
                if (s.charAt(i) != ' ') {
                    curr++;
                    flg = false;
                }
                //如果最后的元素是空格就什么也不处理
            } else {
                //进入这里已经遇到第一个不是空格的元素了
                if (s.charAt(i) == ' ') {
                    //如果再一次遇见空格提前结束循环
                    return curr;
                } else {
                    curr++;
                    flg = false;
                }
            }
        }
        //也可能全是空格 或者 只有一个单词
        return curr;
    }
}
