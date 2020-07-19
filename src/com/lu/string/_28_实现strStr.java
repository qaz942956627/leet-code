package com.lu.string;

public class _28_实现strStr {

    public int strStr(String haystack, String needle) {
        if (haystack.equals(needle)) {
            return 0;
        }
        if (needle.equals("")) {
            return 0;
        }

        for (int i = 0; i < haystack.length(); i++) {
            //在整个haystack中寻找needle第一个元素
            char first = needle.charAt(0);
            if (haystack.charAt(i) == first) {
                //先判断一下haystack.length-i>needle.length 否则返回-1
                if (haystack.length() - i < needle.length()) {
                    return -1;
                }
                //找到第一个元素之后截取needle.length的长度 子串和 needle 比较是否相等
                String substring = haystack.substring(i, i + needle.length());
                if (substring.equals(needle)) {
                    return i;
                }
            }
        }
        return -1;
    }
}
