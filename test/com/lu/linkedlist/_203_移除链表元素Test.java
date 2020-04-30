package com.lu.linkedlist;

import org.junit.jupiter.api.Test;

class _203_移除链表元素Test {

    @Test
    void removeElements() {
        ListNode node = new ListNode(1);
        node.next = new ListNode(2);
        node.next.next = new ListNode(6);
        node.next.next.next = new ListNode(3);
        node.next.next.next.next = new ListNode(4);
        node.next.next.next.next.next = new ListNode(5);
        node.next.next.next.next.next.next = new ListNode(6);
        ListNode listNode = new _203_移除链表元素().removeElements(node,6);
        listNode.print();
    }

    @Test
    void removeElements1() {
        ListNode node = new ListNode(1);
        node.next = new ListNode(2);

        ListNode listNode = new _203_移除链表元素().removeElements(node,1);
        listNode.print();
    }

    @Test
    void removeElements2() {
        ListNode node = new ListNode(1);
        node.next = new ListNode(2);
        node.next.next = new ListNode(2);
        node.next.next.next = new ListNode(1);
        ListNode listNode = new _203_移除链表元素().removeElements(node,2);
        listNode.print();
    }
}