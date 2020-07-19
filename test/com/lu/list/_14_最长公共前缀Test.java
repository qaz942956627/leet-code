package com.lu.list;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class _14_最长公共前缀Test {

    @Test
    void longestCommonPrefix() {
        _14_最长公共前缀 v = new _14_最长公共前缀();
        String[] strings = {"aa","a"};
        System.out.println(v.longestCommonPrefix(strings));
    }
}