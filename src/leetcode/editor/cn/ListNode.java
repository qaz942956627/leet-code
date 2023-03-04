package leetcode.editor.cn;

import java.util.List;

public class ListNode {

    int val;
    ListNode next;

    ListNode() {
    }

    ListNode(int val) {
        this.val = val;
    }

    ListNode(int val, ListNode next) {
        this.val = val;
        this.next = next;
    }

    public static ListNode build(List<Integer> nodeValues) {
        ListNode dummy = new ListNode();
        ListNode cur = dummy;
        for (Integer nodeValue : nodeValues) {
            cur.next = new ListNode(nodeValue);
            cur = cur.next;
        }
        return dummy.next;

    }
}
