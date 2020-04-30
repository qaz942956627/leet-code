package com.lu.stack;

import org.junit.jupiter.api.Test;

import java.util.Stack;

import static org.junit.jupiter.api.Assertions.*;

class _20_有效的括号Test {

    @Test
    void isValid() {
        String s = "()";
        boolean valid = new _20_有效的括号().isValid(s);
        System.out.println(valid);
    }
}