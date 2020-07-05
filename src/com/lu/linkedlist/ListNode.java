package com.lu.linkedlist;

import java.util.List;

/**
 * @author 小卢
 */
public class ListNode {
    int val;
    ListNode next;

    ListNode(int x) {
        val = x;
    }

    /**
     * [0,8,6,5,6,8,3,5,7]
     * [6,7,8,0,8,5,8,9,7]
     */
    ListNode(List<Integer> val) {
        ListNode pre = new ListNode(val.get(0));
        ListNode curr = new ListNode(val.get(1));
        pre.next = curr;
        for (int i = 2; i < val.size(); i++) {
            curr.next = new ListNode(val.get(i));
            curr = curr.next;
        }
        this.val = val.get(0);
        this.next = pre.next;
    }

    public void print() {
        System.out.print("["+val);
        while (next!=null) {
            System.out.print(","+next.val);
            next = next.next;
        }
        System.out.println("]");
    }

    @Override
    public String toString() {
        StringBuffer sb = new StringBuffer();
        sb.append("[").append(val);
        while (next!=null) {
            sb.append(",").append(next.val);
            next = next.next;
        }
        sb.append("]");
        return sb.toString();
    }
}
