package linkedlist;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class _206_反转链表Test {

    @Test
    void reverseList() {
        ListNode node = new ListNode(1);
        node.next = new ListNode(2);
        node.next.next = new ListNode(3);
        node.next.next.next = new ListNode(4);
        node.next.next.next.next = new ListNode(5);

        _206_反转链表 _206 = new _206_反转链表();

        ListNode listNode = _206.reverseList2(node);
        System.out.println(1);

    }
}