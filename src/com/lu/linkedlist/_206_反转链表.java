package com.lu.linkedlist;

/**
 * https://leetcode-cn.com/problems/reverse-linked-list/
 * @author 小卢
 */
public class _206_反转链表 {
    public ListNode reverseList(ListNode head) {
        //head == null 只是为了判断一下初始传入的head是否为null ,head.next == null 递归的终止条件
        if (head == null || head.next == null) {
            return head;
        }
        ListNode p = reverseList(head.next);
        //head.next理解为当前处理的节点 让当前节点指向前一个节点这样会形成一个环
        head.next.next = head;
        //然后然当前节点设置为null断掉这个环
        head.next = null;
        return p;
    }

    public ListNode reverseList2(ListNode head) {
        ListNode newHead = null;
        while (head != null) {
            ListNode temp = head.next;
            head.next = newHead;
            newHead = head;
            head = temp;
        }
        return newHead;
    }
}
