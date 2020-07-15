package com.lu.linkedlist;

public class _21_合并两个有序链表 {
    public ListNode mergeTwoLists(ListNode l1, ListNode l2) {
        ListNode prev = new ListNode(0);
        ListNode curr = prev;
        ListNode curr1 = l1;
        ListNode curr2 = l2;

        while (curr1 != null && curr2 != null) {
            if (curr1.val<=curr2.val) {
                curr.next = curr1;
                curr1 = curr1.next;
            } else{
                curr.next = curr2;
                curr2 = curr2.next;
            }
            curr = curr.next;
        }
        //如果c1不为空则直接让curr.next=c1就行 c2不为空等于c2
        curr.next = curr1 != null ? curr1 : curr2;
        return prev.next;
    }
}
