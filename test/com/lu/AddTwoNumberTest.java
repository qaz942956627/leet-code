package com.lu;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class AddTwoNumberTest {

    @Test
    void addTwoNumbers() {
        ListNode n1 = new ListNode(2);
        n1.next = new ListNode(4);
        n1.next.next = new ListNode(3);
        ListNode n2 = new ListNode(5);
        n2.next = new ListNode(6);
        n2.next.next = new ListNode(9);
        ListNode listNode = new AddTwoNumber().addTwoNumbers(n1, n2);
        assertEquals(listNode.val,7);
        assertEquals(listNode.next.val,0);
        assertEquals(listNode.next.next.val,3);
        assertEquals(listNode.next.next.next.val,1);
    }
}