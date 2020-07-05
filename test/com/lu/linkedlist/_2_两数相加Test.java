package com.lu.linkedlist;

import org.junit.jupiter.api.Test;

import java.util.Arrays;

import static org.junit.jupiter.api.Assertions.*;

class _2_两数相加Test {

    /**
     * [2,4,3]
     * [5,6,4]
     */

    @Test
    void addTwoNumbers() {
        _2_两数相加 v = new _2_两数相加();
        ListNode l1 = new ListNode(Arrays.asList(0,8,6,5,6,8,3,5,7));

        ListNode l2 = new ListNode(Arrays.asList(6,7,8,0,8,5,8,9,7));

        ListNode listNode = v.addTwoNumbers(l1, l2);
        System.out.println(listNode);
    }

    /**
     * [0,8,6,5,6,8,3,5,7]
     * [6,7,8,0,8,5,8,9,7]
     */
    @Test
    void method() {
        ListNode listNode = new ListNode(Arrays.asList(0,8,6,5,6,8,3,5,7));
        System.out.println(listNode);
    }
}