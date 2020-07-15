package com.lu.list;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class _27_移除元素Test {

    @Test
    void removeElement() {
        _27_移除元素 v = new _27_移除元素();
        int[] ints = {3, 2, 2, 3};
        v.removeElement(ints, 3);
    }
}