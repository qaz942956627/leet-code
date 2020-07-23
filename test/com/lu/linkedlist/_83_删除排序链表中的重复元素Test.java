package com.lu.linkedlist;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class _83_删除排序链表中的重复元素Test {

    @Test
    void deleteDuplicates() {
        _83_删除排序链表中的重复元素 v = new _83_删除排序链表中的重复元素();
        ListNode listNode = new ListNode(1);
        listNode.next = new ListNode(1);
        listNode.next.next = new ListNode(2);

        v.deleteDuplicates(listNode);
    }
}