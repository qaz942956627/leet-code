package linkedlist;

public class Tmp {
    public boolean hasCycle(ListNode head) {

        return false;
    }

    public ListNode removeElements(ListNode head, int val) {
        ListNode sentinel = new ListNode(0);
        sentinel.next = head;
        ListNode prev = sentinel;
        ListNode curr = head;
        while (curr != null) {
            if (curr.val == val) {
                prev.next = prev.next.next;
            }else {
                prev = prev.next;
            }
            curr = curr.next;
        }
        return sentinel.next;
    }

    public ListNode reverseList(ListNode head) {
        if (head == null) {
            return head;
        }

        ListNode newHead = null;
        while (head != null) {
            ListNode suffix = head.next;
            head.next = newHead;
            newHead = head;
            head = suffix;
        }
        return newHead;
    }

}
