package com.lu.list;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class _35_搜索插入位置Test {

    @Test
    void searchInsert() {
        int[] n = {1,3,5,6};
        _35_搜索插入位置 v = new _35_搜索插入位置();
        System.out.println(v.searchInsert(n, 7));
    }
}