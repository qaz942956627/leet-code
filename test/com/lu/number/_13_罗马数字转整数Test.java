package com.lu.number;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class _13_罗马数字转整数Test {

    @Test
    void romanToInt() {
        String s = "III";
        _13_罗马数字转整数 v = new _13_罗马数字转整数();
        System.out.println(v.romanToInt(s));
    }
}