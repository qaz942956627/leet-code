package com.lu.list;


public class _14_最长公共前缀 {

    public String longestCommonPrefix(String[] strs) {
        if (strs == null || strs.length == 0) {
            return "";
        }
        StringBuilder prefix = new StringBuilder(strs[0]);
        int prefixLength = strs[0].length();

        for (int i = 1; i < strs.length; i++) {
            //判断PrefixLength长度和当前遍历元素的长度 取长度更短的那个
            String currString = strs[i];
            int sortLength = Math.min(prefixLength, currString.length());
            //比较sortLength  Prefix 和 strs[i]
            //让前缀长度等于更短的字符串长度
            prefixLength = sortLength;
            for (int j = 0; j < prefixLength; j++) {
                //遍历每一个元素 更新前缀长度
                if (prefix.charAt(j) != currString.charAt(j)) {
                    prefixLength = j;
                    break;
                }
            }
            //如果有不相等的字符则删除后面所有的字符
            prefix.delete(prefixLength,prefix.length());
        }
        return prefix.toString();
    }
}
